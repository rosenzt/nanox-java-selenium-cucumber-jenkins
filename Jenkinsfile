pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/rosenzt/nanox-java-selenium-cucumber-jenkins.git'
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
            script {
                def emailConfig = readProperties file: 'src/test/resources/config.properties'
                def recipient = emailConfig['EMAIL_RECIPIENT']

                echo "Email will be sent to: ${recipient}"

                env.RECIPIENT_EMAIL = recipient
            }
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