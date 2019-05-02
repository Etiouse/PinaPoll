pipeline {
    agent any
    stages {
	
        stage('Build') { 
            agent {
				docker {
					image 'maven:3-alpine'
				}
            }
            steps {
				sh '(cd ./PinaPollSTS/; mvn clean package)'
				stash name: "app", includes: "**"
            }
        }
		
		stage('QualityTest') { 
            agent {
				docker {
					image 'maven:3-alpine'
				}
            }
            steps {
				unstash "app"
				sh '(cd ./PinaPollSTS/; mvn clean test)'
				sh '(cd ./PinaPollSTS/; mvn sonar:sonar \
				  -Dsonar.projectKey=Etiouse_PinaPoll \
				  -Dsonar.organization=etiouse-github \
				  -Dsonar.host.url=https://sonarcloud.io \
				  -Dsonar.login=db92ca8d9113b7779026b71167a7f3e391d048c8)'
			}
        }
		
        stage('IntegrationTest'){
			agent{ 
				docker{
					image 'lucienmoor/katalon-for-jenkins:latest'
					args '-p 8888:8080'
				}
			}
			steps {
				echo 'IntegrationTest'
				/*unstash "app"
				sh 'java -jar ./PinaPollSTS/target/PinaPollSTS-0.0.1-SNAPSHOT.jar >/dev/null 2>&1 &' 
				sh 'sleep 30'
				sh 'chmod +x ./runTest.sh'
				sh './runTest.sh'

				cleanWs()*/
		    }
        }
		
    }
	post {
		always {
			echo 'always clean up'
			deleteDir()
		}
	}
}