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
                bat 'wsl mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t realtime-chat-app .'
            }
        }

        stage('Docker Run') {
            steps {
                bat '''
                    wsl docker rm -f realtime-chat-container || exit 0
                    wsl docker run -d --name realtime-chat-container -p 8080:8080 realtime-chat-app
                '''
            }
        }
    }
}
