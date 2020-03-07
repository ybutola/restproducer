pipeline {
    agent any
    
    tools {
        maven 'Maven' 
    }
    
    stages {
        stage ('compile') {
            steps {
               sh 'echo "Running clean and compile"' 
               sh 'mvn clean compile'
            }
        }

        stage ('test') {
            steps{
               sh 'echo "Running test"' 
               sh 'mvn test'
            }
        }

        stage ('deploy') {
            steps{
               sh 'echo "Running deploy"' 
               sh 'mvn deploy'
            }
        }
    }
}
