node {
    stage('SCM') {
        git 'https://github.com/RockNJU/Lrms.git'
    }
    stage('QA') {
        sh 'sonar-scanner'
    }
    stage('build') {
        def mvnHome = tool 'M3'
        sh "${mvnHome}/bin/mvn -B clean package"
    }
    stage('deploy') {
        sh "docker stop myd || true"
        sh "docker rm myd || true"
        sh "docker run --name myd -p 11113:8080 -v /root/logs:/usr/local/tomcat/logs -d tomcat"
        sh "docker cp target/maven-web-demo.war myd:/usr/local/tomcat/webapps"
    }
    stage('results') {
        archiveArtifacts artifacts: '**/target/*.war', fingerprint: true
    }
}
