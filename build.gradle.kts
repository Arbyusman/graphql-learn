plugins {
	java
	id("org.springframework.boot") version "3.0.0"
	id("io.spring.dependency-management") version "1.1.0"
	id("com.netflix.dgs.codegen") version "5.11.1"

}

group = "com.graphql.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")


	// Ngoprek Dependencie
	implementation(platform("com.netflix.graphql.dgs:graphql-dgs-platform-dependencies:6.0.0"))
	implementation("com.netflix.graphql.dgs:graphql-dgs-spring-boot-starter")
	implementation("net.datafaker:datafaker:1.+")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
