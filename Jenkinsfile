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
}