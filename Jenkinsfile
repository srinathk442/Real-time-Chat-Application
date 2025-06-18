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
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
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
                    docker stop realtime-chat-app || exit /b 0
                    docker rm realtime-chat-app || exit /b 0
                    docker run -d --name realtime-chat-app -p 8081:8080 %DOCKER_IMAGE%
                '''
            }
        }

        stage('Ansible Deploy') {
            steps {
                bat 'wsl ansible-playbook -i ansible/inventory.ini ansible/deploy.yml'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('MySonar') { // Replace 'MySonar' with your configured SonarQube name
                    bat '''
                        mvn sonar:sonar ^
                        -Dsonar.projectKey=realtime-chat ^
                        -Dsonar.host.url=http://localhost:9000 ^
                        -Dsonar.login="Enter login key"
                    '''
                }
            }
        }
    }
}
