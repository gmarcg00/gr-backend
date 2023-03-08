pipeline {
    agent any
    tools{
        jdk 'JAVA'
        maven 'MAVEN'
    }

    stages {
        stage('Hello') {
            steps {
                echo 'Hello World'
            }
        }
        stage('Compile') {
            steps {
                git branch: 'develop', url: 'https://github.com/gmarcg00/gr-backend.git'
                sh 'mvn clean compile'
            }
        }
    }
}