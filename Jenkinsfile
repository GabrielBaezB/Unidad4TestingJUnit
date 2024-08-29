pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/GabrielBaezB/Unidad4TestingJUnit.git'
            }
        }
        stage('Build and Test') {
            steps {
                script {
                    sh 'mvn clean test'
                }
            }
        }
        stage('List Files') {
            steps {
                script {
                    sh 'ls -R target/surefire-reports'
                }
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}
