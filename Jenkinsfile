pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/janardhan0210/dockerjavafile.git'
            }
        }
         stage('Build') {
            steps {
                // Build your Java application
                sh 'mvn clean package'
            }
        }
        
        stage('Test') {
            steps {
                // Run your unit tests
                sh 'mvn test'
            }
        }
    }
}
