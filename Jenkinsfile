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
        DOCKER_IMAGE_LATEST_TAG = 'latest'
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
//                 stage('Build') {
//                     steps {
//                           sh 'mvn clean install'
//                     }
//                 }
//                 stage('Build image') {
//                     steps{
//                             sh "docker build -t $DOCKER_IMAGE_NAME:${BUILD_NUMBER} -t $DOCKER_IMAGE_NAME:$DOCKER_IMAGE_LATEST_TAG ."
//                     }
//                 }
//                stage('Login to registry') {
//                     steps {
//                             echo "Login to registry"
//                             sh "echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin"
//                     }
//                }
//
//                stage('Docker push image') {
//                    steps {
//                             echo "Pushing image $DOCKER_IMAGE_NAME:${BUILD_NUMBER}"
//                             sh "docker push $DOCKER_IMAGE_NAME:${BUILD_NUMBER}"
//
//                             echo "Pushing image $DOCKER_IMAGE_NAME:$DOCKER_IMAGE_LATEST_TAG"
//                             sh "docker push $DOCKER_IMAGE_NAME:$DOCKER_IMAGE_LATEST_TAG"
//                    }
//                }
//                stage('Docker logout') {
//                    steps {
//                         echo "Docker logging out..."
//                         sh 'docker logout'
//                    }
//                }
//                stage('Docker image clean up') {
//                    steps{
//                         script {
//                             try {
//                                 sh "docker rmi $DOCKER_IMAGE_NAME:${BUILD_NUMBER}"
//                             } catch (Exception e) {
//                                 echo "Error - cannot remove image $DOCKER_IMAGE_NAME:${BUILD_NUMBER}, message - ${e.getMessage()}"
//                             }
//                             try {
//                                 sh "docker rmi $DOCKER_IMAGE_NAME:$DOCKER_IMAGE_LATEST_TAG"
//                             } catch (Exception e) {
//                                 echo "Error - cannot remove image $DOCKER_IMAGE_NAME:$DOCKER_IMAGE_LATEST_TAG, message - ${e.getMessage()}"
//                             }
//                         }
//                    }
//                }
               stage('Trigger other pipeline'){
                    steps {
                        script {
                            build job: 'pregenmed/example-pipeline'
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