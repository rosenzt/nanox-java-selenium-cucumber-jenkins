pipeline {
    agent any

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
        success {
            emailext subject: "✅ BUILD SUCCESS: Java-Selenium-Cucumber",
                     body: "The Jenkins job ran successfully.\n\nCheck the report: ${BUILD_URL}/testReport",
                     recipientProviders: [[$class: 'DevelopersRecipientProvider']],
                     to: 'talr@meteo-logic.com'
        }

        failure {
            emailext subject: "❌ BUILD FAILED: Java-Selenium-Cucumber",
                     body: "The Jenkins job failed!\n\nCheck the logs here: ${BUILD_URL}/console",
                     recipientProviders: [[$class: 'DevelopersRecipientProvider']],
                     to: 'talr@meteo-logic.com'
        }
    }
}
