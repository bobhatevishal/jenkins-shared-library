def call(Map config = [:]) {
    pipeline {
        agent { label config.agentLabel ?: 'any' } // Routes to your slave container
        stages {
            stage('Library Setup') {
                steps {
                    sayHello(config.user)
                }
            }
            stage('Build') {
                steps {
                    echo "Building ${config.appName}..."
                }
            }
        }
    }
}
