pipeline {
    agent any

    tools {maven "maven"}

    stages {
        stage('Clean & Compile') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Unit Test') {
            steps {
                sh 'mvn test -Dtest=UserControllerTest'
                sh 'mvn test -Dtest=UserServiceTest'
            }
        }
        stage('SonarQube Analysis') {
            steps{
                script{
                    def sonarqubeScannerHome = tool name: 'sonar', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
                    def mvn = tool 'maven';
                    withCredentials([string(credentialsId: 'sonar', variable: 'sonarLogin')]) {
                      sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=gr-backend -e -Dsonar.host.url=http://172.20.0.10:9000/ -Dsonar.login=${sonarLogin}"
                    }
                }
            }
        }
        stage('Acceptance Test'){
            steps{
                sh 'mvn test -Dtest=RunCucumberTest'
            }
        }
        stage('Package'){
            steps{
                sh 'mvn package'
            }
        }
        stage('API Test'){
            steps{
                sh 'java -jar target/grbackend-0.0.1-SNAPSHOT.jar &'
                sh 'mvn test -Dtest=KarateRunner'
            }
        }
    }
}