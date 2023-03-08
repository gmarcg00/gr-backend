pipeline {
    agent any
    tools{
        jdk 'JAVA'
        maven 'MAVEN'
    }

    stages {
        stage('Clean & Compile') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Unit Test') {
            steps {
                echo 'TO DO JUNIT TEST'
            }
        }
        stage('Package') {
            steps {
                echo 'TO DO PACKAGE STAGEeeeeee'
            }
        }

    }
}