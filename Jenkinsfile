pipeline {
    agent any
    tools {
        jdk 'jdk-17-latest'
        maven 'maven-3'
    }
    environment {
        DOCKERHUB_CREDENTIALS = credentials('pregenmed-dockerhub')
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
                    steps {
                        sh 'docker build -t pregenmed/pgm-articles:latest .'
                    }
                }
                stage('Dockerhub Login') {
                    steps {
                            sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                    }
                }
                stage('Dockerhub Push') {
                    steps {
                         sh 'docker push pregenmed/pgm-articles:latest'
                    }
                }
            }
        }
    }
    post {
        always {
            sh 'docker logout'
        }
        success {
            echo 'Build Completed'
        }
        failure {
            echo 'Build Failure. Check out logs'
        }
    }
}