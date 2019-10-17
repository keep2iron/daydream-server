import com.google.protobuf.gradle.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.1.8.RELEASE"
	id("io.spring.dependency-management") version "1.0.8.RELEASE"
	id("com.google.protobuf") version "0.8.3"
	kotlin("jvm") version "1.2.71"
	kotlin("plugin.spring") version "1.2.71"
}

group = "io.github.keep2iron"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	maven("https://repo1.maven.org/maven2")
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	runtimeOnly("mysql:mysql-connector-java")

	testImplementation("org.springframework.boot:spring-boot-starter-test")

	implementation("com.google.protobuf:protobuf-java:3.4.0")
	implementation("com.googlecode.protobuf-java-format:protobuf-java-format:1.4")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

//protobuf {
//	this.protobuf.protoc({
//
//	})
//	protoc {
//		// Download from repositories
//		artifact = 'com.google.protobuf:protoc:3.4.0'
//		generatedFilesBaseDir = "$projectDir/src"
//	}
//}