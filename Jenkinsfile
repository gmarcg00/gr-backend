pipeline {
    agent any
    tools{
        jdk 'JAVA'
        maven 'MAVEN'
    }

    stages {
        stage('Clean & Compile') {
            steps {
                git branch: 'develop', url: 'https://github.com/gmarcg00/gr-backend.git'
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