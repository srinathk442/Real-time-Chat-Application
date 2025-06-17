pipeline {
    agent any

    tools {
        maven 'maven-3.9.8'
        jdk 'jdk-17'
    }

    environment {
        DOCKER_IMAGE = 'realtime-chat-app'
    }

    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'main', url: 'https://github.com/srinathk442/Real-time-Chat-Application.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install -DskipTests'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                bat "docker build -t %DOCKER_IMAGE% ."
            }
        }

        stage('Docker Run') {
            steps {
                bat '''
                    docker stop realtime-chat-container || exit 0
                    docker rm realtime-chat-container || exit 0
                    docker run -d --name realtime-chat-container -p 8081:8080 %DOCKER_IMAGE%
                '''
            }
        }
    }
}
