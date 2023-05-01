pipeline {
    agent any

    tools {maven "maven"}

    stages {
        stage('Compile') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Unit Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('SonarQube Analysis') {
            steps{
                script{
                    def mvn = tool 'maven';
                    withSonarQubeEnv() {
                      sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=gr-backend"
                    }
                }
            }
        }
    }
}