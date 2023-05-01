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
                    def sonarqubeScannerHome = tool name: 'sonar', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
                    def mvn = tool 'maven';
                    withCredentials([string(credentialsId: 'sonar', variable: 'sonarLogin')]) {
                      sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=gr-backend -e -Dsonar.host.url=http://172.27.0.4:9000/"
                    }
                }
            }
        }
    }
}