plugins {
    kotlin("jvm") version "1.3.61"
    id("com.github.johnrengelman.shadow") version "5.1.0"
}

group = "xyz.weberer"
version = "0.1-ALPHA"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.amazonaws:aws-lambda-java-core:1.2.0")
    compile("org.jetbrains.exposed", "exposed-core", "0.23.1")
    compile("org.jetbrains.exposed", "exposed-dao", "0.23.1")
    compile("org.jetbrains.exposed", "exposed-jdbc", "0.23.1")
    compile("com.impossibl.pgjdbc-ng", "pgjdbc-ng", "0.8.3")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}