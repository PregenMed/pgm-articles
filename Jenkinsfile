pipeline {
    agent any
    tools {
        jdk 'jdk-17-latest'
        maven 'maven-3'
    }
    stages {
        stage('Pull Request') {
            when {
                branch 'PR/*'
            }
            steps {
                mvn clean package
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
                mvn clean package
            }
        }
        stage('Main Branch Deploy') {
            when {
                branch 'main'
            }
            stages{
                stage('Build') {
                    steps {
                            mvn clean install
                    }
                }
                stage('Build Image') {
                    steps {
                        sh 'docker build -t pgm-articles:latest .'
                    }
                }
                stage('Docker Push'){
                    steps{
                        withCredentials([usernamePassword(credentialsId: 'docker_cred', passwordVariable: 'DOCKERHUB_PASSWORD', usernameVariable: 'DOCKERHUB_USERNAME')]){
                            sh 'docker login -u $DOCKERHUB_USERNAME -p $DOCKERHUB_PASSWORD'
                            sh 'docker tag pgm-articles:latest pregenmed/pgm-articles:latest'
                            sh 'docker push pregenmed/pgm-articles:latest'
                            sh 'docker logout'
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
            echo 'Build Failure. Check out logs'
        }
    }
}