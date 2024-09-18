pipeline {
    agent any
    tools {
        jdk 'jdk-17-latest'
        maven 'maven-3'
    }
    environment {
        DOCKERHUB_REGISTRY = 'https://hub.docker.com'
        DOCKERHUB_CREDENTIALS = 'pregenmed-dockerhub'
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
                        script{
                            docker.build("${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_TAG}")
                        }
                    }
                }
               stage('Login to Docker Hub') {
                    steps {
                        script {
                            withDockerRegistry(credentialsId: DOCKERHUB_CREDENTIALS, toolName: 'docker'){
                                echo "Logged in to Docker Hub"

                            }
//
//                             docker.withCredentials([usernamePassword(credentialsId: 'myregistry-login', passwordVariable: 'DOCKER_REGISTRY_PWD', usernameVariable: 'DOCKER_REGISTRY_USER')]) {
//
//                             docker.withRegistry(DOCKERHUB_REGISTRY, DOCKERHUB_CREDENTIALS) {
//                                 echo "Logged in to Docker Hub"
//                             }
                        }
                    }
               }

               stage('Push Docker image') {
                   steps {
                       script {
                           docker.image("${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_TAG}").push()
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