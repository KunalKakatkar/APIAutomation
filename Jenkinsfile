pipeline {
  
  agent any

  tools {
    maven 'MAVEN-3.9.9'
  }

  stages {

    stage('checkout'){
      steps{
        git 'https://github.com/KunalKakatkar/APIAutomation.git'
      }
    }

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
          reportName: 'API Report'
          keepAll: true,
          alwaysLinkToLastBuild: true,
          allowMissing: false
          ])
      }
    }
  }

  post {
    always{
      emailext(
        subject:
                "Build Status: ${currentBuild.currentResult}",

                body:
                """
                Build Result:
                ${currentBuild.currentResult}

                Job Name:
                ${env.JOB_NAME}

                Build Number:
                ${env.BUILD_NUMBER}
                """,

                to: 'kunalkakatkar16@gmail.com'
        )
        
      }
    }
  }
  
