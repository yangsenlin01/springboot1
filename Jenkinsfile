node{
	stage('拉取代码') {
		git credentialsId: 'b48144af-144b-4b21-82ff-d7b517eb72f7', url: 'https://github.com/yangsenlin01/springboot1.git'
	}
	stage('maven编译') {
		dir('./') {
		sh '/data/local/apache-maven-3.5.4/bin/mvn clean install -DskipTests=true'
       }
	}
	stage('镜像构建') {
		dir('./') {
        docker.build("192.168.19.114/project/project-java-1:prod-${BUILD_ID}").push()
       }
	}
	stage('运行镜像') {
		dir('./') {
        rancher confirm: false, credentialId: '156f5548-407c-4297-9b91-e2954486a0f9', endpoint: 'http://192.168.19.112:8080/v2-beta', environmentId: '1a5', environments: '', image: '192.168.19.114/project/project-java-1:prod-${BUILD_ID}', ports: '', service: 'myStack/myService', timeout: 50
	   }
	}
}