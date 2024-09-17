pipeline {
    agent any
    tools {
        jdk 'jdk-17-latest'
        maven 'maven-3'
        dockerTool 'docker-latest'
    }
    environment {
        dockerImage = ''
        registry = 'pregenmed/pgm-articles'
        registryCredential = 'pregenmed-dockerhub'
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
                stage('Build & Push Image') {
                    steps{
                      sh("mvn spring-boot:build-image -Dregistry.username=$DOCKERHUB_USERNAME -Dregistry.password=$DOCKERHUB_PASSWORD -Dregistry.url=$DOCKERHUB_URL ")
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