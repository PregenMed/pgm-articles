pipeline {
    agent any
    tools {
        jdk 'jdk-17-latest'
        maven 'maven-3'
//         dockerTool 'docker-latest'
    }
    environment {
        dockerImage = ''
        registry = 'pregenmed/pgm-articles'
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
//                 stage('Build') {
//                     steps {
//                           sh 'mvn clean install'
//                     }
//                 }
                stage('Build Image') {
                    steps{
                        script{
                            sh 'podman build -t pregenmed/pgm-articles:lastest .'
                        }
//                       sh("docker build -t pregenmed/pgm-articles:latest .")
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