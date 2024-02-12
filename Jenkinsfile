pipeline {
    agent any
    environment{
        JDK_VERSION = 'jdk17'
        MAVEN_VERSION = 'maven3'
        DOCKER_HOME = tool 'docker25'
    }
    tools {
        jdk JDK_VERSION
        maven MAVEN_VERSION
    }
    triggers {
        pollSCM('* * * * *')
    }
    options {
        buildDiscarder(logRotator(numToKeepStr: '2'))
    }
    stages {
        stage('SCM Checkout') {
            steps {
               git branch: 'main', url: 'https://github.com/ullagallu4/sample-spring.git'
            }
        }
        stage('Maven Clean'){
            steps{
                sh 'mvn clean'
            }
        }
        stage('Maven test'){
            steps{
                sh 'mvn test'
            }
        }
        stage(''){
            steps{
                sh 'mvn package'
            }
        }
    }
}
