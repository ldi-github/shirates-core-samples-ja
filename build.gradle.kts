plugins {
    kotlin("jvm") version "1.8.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

val shiratesCoreVersion = "6.7.0"
val appiumClientVersion = "9.1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    // JUnit 5
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.2")

    // shirates-core
    testImplementation("io.github.ldi-github:shirates-core:$shiratesCoreVersion")

    // Appium
    testImplementation("io.appium:java-client:$appiumClientVersion")

    // https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core
    testImplementation("org.apache.logging.log4j:log4j-core:2.20.0")

    // https://mvnrepository.com/artifact/org.slf4j/slf4j-nop
    testImplementation("org.slf4j:slf4j-nop:2.0.5")

    // Apache Commons IO
    testImplementation("commons-io:commons-io:2.11.0")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}