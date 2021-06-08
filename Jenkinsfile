node {
    stage('Clone') {
        checkout scm
    }

    stage('Tests') {
        sh "mvn test"
    }

    stage('SonarQube') {
        //echo "sonar"
    }

    stage('Build') {
        sh "mvn clean install -DskipTests"
    }

    stage('Delivery') {
        sh "cp target/api-0.0.1-SNAPSHOT.war /backend/ROOT.war"
    }
}