val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val prometeus_version: String by project

plugins {
    kotlin("jvm") version "1.8.0"
    id("io.ktor.plugin") version "2.2.2"
//    id("org.jetbrains.kotlin.plugin.serialization") version "1.8.0"
}

group = "ru.vood"
version = "0.0.1"
application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
//    maven {
//        url = uri("https://kotlin.bintray.com/ktor")
//    }
}

dependencies {
    implementation ("io.github.microutils:kotlin-logging:1.7.7")
    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin_version")
    implementation ("org.apache.kafka:kafka-clients:2.3.1")
    implementation ("io.ktor:ktor-server-netty:$ktor_version")
    implementation ("ch.qos.logback:logback-classic:$logback_version")
    implementation ("io.ktor:ktor-server-core:$ktor_version")
    implementation ("io.ktor:ktor-server-host-common:$ktor_version")
//    implementation ("io.ktor:ktor-jackson:$ktor_version")
    implementation ("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.10.1")
    testImplementation ("io.ktor:ktor-server-tests:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}