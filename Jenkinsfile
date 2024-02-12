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
        stage('versions'){
            steps{
                script{
                    sh 'mvn --version'
                    sh 'java --version'
                }
            }
        }
    }
}
