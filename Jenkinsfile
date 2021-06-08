node {
    stage('Clone') {
        script {
            checkout poll:true, scm: [$class: 'GitSCM',
            branches: [[name: 'refs/heads/master']],
            doGenerateSubmoduleConfigurations: false,
            extensions: [[$class: 'CleanCheckout'],
            [$class: 'WipeWorkspace'],
            [$class: 'CloneOption', depth: 0,
            noTags: false, reference: '',
            shallow: true],
            [$class: 'RelativeTargetDirectory',
            relativeTargetDir: './'],
            [$class: 'CleanBeforeCheckout']], submoduleCfg: [],
            userRemoteConfigs: [[url: "https://github.com/robsonscruz/05-aluno-springboot.git"]]]
        }
    }

    stage('Tests') {
        sh "mvn test"
    }

    stage('SonarQube') {
        echo "sonar"
    }

    stage('Build') {
        sh "mvn clean install -x test"
    }

    stage('Delivery') {
        sh "cp target/api-0.0.1-SNAPSHOT.war /backend/ROOT.war"
    }
}