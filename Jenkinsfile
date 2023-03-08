pipeline {
    agent any
    tools{
        jdk 'JAVA'
        maven 'MAVEN'
    }

    stages {
        stage('Install') {
            steps {
                git branch: 'develop', url: 'https://github.com/gmarcg00/gr-backend.git'
                sh 'mvn clean install -Dmaven.test.skip=true'
            }
        }
        stage('Compile') {
            steps {
                sh 'mvn clean compile'
            }
        }
    }
}