pipeline {
    agent any
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
    }
}
