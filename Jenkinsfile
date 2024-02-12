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
        stage('Build Java'){
            steps{
                sh 'mvn package'
            }
        }
        stage('DockerBuild'){
            steps{
                withCredentials([usernamePassword(credentialsId: 'docker', usernameVariable: 'DOCKER_HUB_USERNAME', passwordVariable: 'DOCKER_HUB_PASSWORD')]) {
                    sh 'docker build -t ${DOCKER_HUB_USERNAME}/ss:${BUILD_NUMBER} .'
                    sh 'docker tag ${DOCKER_HUB_USERNAME}/ss:${BUILD_NUMBER} ${DOCKER_HUB_USERNAME}/ss:latest'
                    sh 'echo "${DOCKER_HUB_PASSWORD}" | docker login -u "${DOCKER_HUB_USERNAME}" --password-stdin'
                    sh 'docker-scout cves ${DOCKER_HUB_USERNAME}/ss:${BUILD_NUMBER} --exit-code --only-severity critical,high'
                    sh 'docker push ${DOCKER_HUB_USERNAME}/ss:${BUILD_NUMBER}'
                    sh 'docker push ${DOCKER_HUB_USERNAME}/ss:latest'
                }
            }
        }
        stage('Remove Docker Images') {
            steps {
                script {
                    sh 'docker rmi -f $(docker images -q)'
                }
            }
        }

    }
}
