pipeline {
    agent any

    tools {
        maven 'maven-3.9.8'   // match exactly with your configured Maven name
        jdk 'jdk-17'          // match exactly with your configured JDK name
    }

    environment {
        DOCKER_IMAGE = 'realtime-chat-app'
    }

    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/srinathk442/Real-time-Chat-Application.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                sh "docker build -t ${DOCKER_IMAGE} ."
            }
        }

        stage('Docker Run') {
            steps {
                sh '''
                    docker ps -q --filter "name=realtime-chat-container" | grep -q . && docker stop realtime-chat-container && docker rm realtime-chat-container || true
                    docker run -d --name realtime-chat-container -p 8080:8080 ${DOCKER_IMAGE}
                '''
            }
        }
    }
}
