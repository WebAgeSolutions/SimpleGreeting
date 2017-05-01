node('linux') {
    stage 'Checkout'
    checkout scm
    
    stage 'Maven build'
    sh 'mvn -Dmaven.test.failure.ignore install'
    
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
  sh 'mvn -Dmaven.test.failure.ignore install'
 }	
}