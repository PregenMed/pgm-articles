pipeline {
    agent any
    tools {
        jdk 'jdk-17-latest'
        maven 'maven-3'
    }
    environment {
        DOCKERHUB_REGISTRY = 'https://hub.docker.com'
        DOCKERHUB_CREDENTIALS = credentials('pregenmed-dockerhub')
        DOCKER_IMAGE_NAME = 'pregenmed/pgm-articles'
        DOCKER_IMAGE_TAG = 'latest'
    }
    stages {
        stage('Pull Request') {
            when {
                branch 'PR/*'
            }
            steps {
               sh 'mvn clean package'
            }
        }
        stage('Build Branch') {
            when {
                anyOf {
                    branch 'feature/*';
                    branch 'bugfix/*'
                }
            }
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Main Branch Deploy') {
            when {
                branch 'main'
            }
            stages {
                stage('Build') {
                    steps {
                          sh 'mvn clean install'
                    }
                }
                stage('Build Image') {
                    steps{
                            sh 'docker build -t $DOCKER_IMAGE_NAME:$DOCKER_IMAGE_TAG .'
                    }
                }
               stage('Login to Docker Hub') {
                    steps {
                            sh "echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin"
//                         script {
//                             withDockerRegistry(credentialsId: DOCKERHUB_CREDENTIALS, ){
//                                 echo "Logged in to Docker Hub"
//                                 docker
//                             }
//                         }
                    }
               }

               stage('Push Docker image') {
                   steps {
                            sh "docker push $DOCKER_IMAGE_NAME:$DOCKER_IMAGE_TAG"
                            echo "Image Pushed to registry"
//                        script {
//                            docker.image("${DOCKER_IMAGE_NAME}:${BUILD_NUMBER}").push()
//                        }
                   }
               }
               stage('Docker logout') {
                   steps{
                        sh 'docker logout'
                        echo "Docker logged out"
                   }
               }
               stage('Docker image clean up') {
                   steps{
                        script {
                            try {
                                sh "docker rmi $DOCKER_IMAGE_NAME:$DOCKER_IMAGE_TAG"
                            } catch (Exception e) {
                                echo "Error - cannot remove image $DOCKER_IMAGE_NAME:$DOCKER_IMAGE_TAG, message - ${e.getMessage()}"
                            }
                        }
                   }
               }
            }
        }
    }
    post {
        success {
            echo 'Build Completed'
        }
        failure {
            echo 'Build Failure. Check out logs.'
        }
    }
}