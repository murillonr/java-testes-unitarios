// -*- mode: groovy -*-
// vim: set filetype=groovy :

pipeline {
    agent any
    tools {
        maven "Maven"
    }
    environment {
        SONNAR_HOME = "/var/jenkins_home/sonar-scanner/sonar-scanner-4.7.0.2747-linux"
    }

    node {
  stage('SCM') {
    checkout scm
  }
  stage('SonarQube Analysis') {
    def mvn = tool 'Default Maven';
    withSonarQubeEnv() {
      sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=simple-test-project"
    }
  }
}
    stages {
        stage('Build/Test') {
            steps {
                echo 'Testing - Coverage Test (Unit/IT)'
                sh "mvn clean package"
                echo 'SonarQube'
                withSonarQubeEnv(credentialsId: 'JenkinsTokenSonar', installationName: 'sonarqubeserver') {
                    sh "$SONNAR_HOME/bin/sonar-scanner -Dproject.settings='sonar-project.properties'"
                }
            }
        }
    }

}
