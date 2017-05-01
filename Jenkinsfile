node {
    stage 'Checkout'
    git credentialsId: 'trasukg-bitbucket', 
      url: 'git@bitbucket.org:trasukg/simplegreeting.git'
    
    stage 'Maven build'
    bat 'mvn -Dmaven.test.failure.ignore install'
    
    stage 'Archive Test Results'
    step([$class: 'JUnitResultArchiver',
      testResults: '**/target/surefire-reports/TEST-*.xml'])
}

stage 'User Acceptance Test'

def response= input message: 'Is this build good to go?',
 parameters: [choice(choices: 'Yes\nNo', 
 description: '', name: 'Pass')]

if(response=="Yes") {
 node {
  stage 'Deploy'
  bat 'mvn -Dmaven.test.failure.ignore install'
 }	
}