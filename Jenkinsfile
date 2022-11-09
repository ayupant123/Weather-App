pipeline {
 
   agent any

 tools {
    maven 'maven'
  }

 stages {

	stage('Compile') {
      steps {
       echo "-=- compiling project -=-"
       bat "mvn clean compile"
       }
   }

	stage('Package') {
	  steps {
	    echo "-=- packaging project -=-"
	    bat "mvn package -DskipTests"
	    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
	   }
	}

   stage('Build Docker image') {
    steps {
      echo "-=- build Docker image -=-"
      bat "docker build -t weather-app."
   }
 }

   stage('Run Docker image') {
     steps {
        echo "-=- run Docker image -=-"
        bat "docker run --name=weather-app --network weather-app-network -p 8345:8345 weather-app-network"
    }
 }

}
}