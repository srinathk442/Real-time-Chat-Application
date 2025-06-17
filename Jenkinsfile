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
                bat 'wsl mvn clean install'
            }
        }

        stage('Test') {
            steps {
                bat 'wsl mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                bat "wsl docker build -t %DOCKER_IMAGE% ."
            }
        }

        stage('Docker Run') {
            steps {
                bat '''
                    wsl docker ps -q --filter "name=realtime-chat-container" | grep -q . && wsl docker stop realtime-chat-container && wsl docker rm realtime-chat-container || exit 0
                    wsl docker run -d --name realtime-chat-container -p 8080:8080 %DOCKER_IMAGE%
                '''
            }
        }
    }
}
