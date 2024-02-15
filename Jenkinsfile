pipeline {
    agent {
        kubernetes{
            yamlFile 'agents.yaml'
        }
    }
    triggers {
        pollSCM('* * * * *')
    }

    stages {
        stage("Git Version") {
            steps {
                container("maven"){
                    git branch: 'main', url: 'https://github.com/ullagallu4/sample-spring.git'
                }
            }
        }
        stage("Maven Version") {
            steps {
                container("maven"){
                    script{
                        sh 'git --version'
                        sh 'mvn --version'
                        sh 'java --version'
                    }
                }
            }
        }
    }
}