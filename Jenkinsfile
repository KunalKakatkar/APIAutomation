pipeline {
  
  agent any

  tools {
    maven 'MAVEN-3.9.9'
  }

  stages {

    stage('compile'){
      steps{
        bat 'mvn compile'
      }
    }

    stage('build'){
      steps{
        bat 'mvn clean package'
    }
  }

    stage('test'){
      steps{
        bat 'mvn test'
      }
    }

    stage('report'){
      steps{
        publishHTML([
          reportDir: 'Reports',
          reportFiles: 'APIReport_*.html',
          reportName: 'API Report',
          keepAll: true,
          alwaysLinkToLastBuild: true,
          allowMissing: false
          ])
      }
    }
  }

  post {

        success {
            echo 'Pipeline executed successfully'
        }

        failure {
            echo 'Pipeline execution failed'
        }
    }
  }
  
