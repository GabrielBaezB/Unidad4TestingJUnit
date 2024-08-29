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
                    // Ejecuta pruebas con Maven
                    sh 'mvn clean test'
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
