pipeline {
    agent any

    tools {maven "maven"}

    stages {
        stage('Compile') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Init') {
            steps {
                sh 'mvn test'
            }
        }
    }

}