pipeline {
    agent any

    environment {
        RECIPIENT_EMAIL = "${env.EMAIL_RECIPIENT}"  // Set in Jenkins "Global Properties"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/rosenzt/nanox-java-selenium-cucumber-jenkins.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }

    post {
        always {
            echo "Email will be sent to: ${env.RECIPIENT_EMAIL}"
        }

        success {
            emailext (
                subject: "Jenkins Build Successful",
                body: "The Jenkins pipeline build was successful!",
                to: "${env.RECIPIENT_EMAIL}"
            )
        }

        failure {
            emailext (
                subject: "Jenkins Build Failed",
                body: "The Jenkins pipeline build has failed!",
                to: "${env.RECIPIENT_EMAIL}"
            )
        }
    }
}
