pipeline {
    agent {
        kubernetes{
            yamlFile 'agents.yaml'
            defaultContainer 'jnlp'
        }
    }
    triggers {
        pollSCM('* * * * *')
    }
    options {
        buildDiscarder(logRotator(numToKeepStr: '2'))
    }
    stages {
        stage("Git Version") {
            steps {
                container("maven"){
                    git branch: 'main', url: 'https://github.com/ullagallu4/sample-spring.git'
                }
            }
        }
        // stage("Maven Version") {
        //     steps {
        //         container("maven"){
        //             script{
        //                sh 'mvn clean install package'
        //             }
        //         }
        //     }
        // }
        stage("Docker"){
            steps{
                container("docker"){
                    sh 'docker version'
                }
            }
        }

    }
}