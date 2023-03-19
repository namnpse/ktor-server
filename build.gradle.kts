val ktorVersion: String by project
val logbackVersion: String by project
val kotlinVersion: String by project
val koinVersion: String by project

plugins {
    application
    kotlin("jvm") version "1.5.10"
    kotlin("plugin.serialization") version "1.5.31"
}

group = "com.namnpse"
version = "1.0-SNAPSHOT"

application {
    // for Engine Main
//    mainClass.set("io.ktor.server.netty.EngineMain")
    // for Embedded Server, point to config in Application.kt
    mainClass.set("com.namnpse.ApplicationKt")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
    implementation("io.ktor:ktor-serialization:$ktorVersion")

    // build html content from kotlin DSL
//    implementation("io.ktor:ktor-server-html-builder:$ktorVersion")

    implementation("io.insert-koin:koin-ktor:$koinVersion")
    implementation("io.insert-koin:koin-logger-slf4j:$koinVersion")

    testImplementation("io.ktor:ktor-server-tests:$ktorVersion")
    testImplementation("org.jetbrains.kotlin:kotlin-test:$kotlinVersion")
}