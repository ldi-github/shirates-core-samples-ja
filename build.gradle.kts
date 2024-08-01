plugins {
    kotlin("jvm") version "1.8.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

val shiratesCoreVersion = "7.4.0"
val appiumClientVersion = "9.1.0"

val userHome = System.getProperty("user.home")

repositories {
    mavenCentral()

    maven(url = "file:/$userHome/github/ldi-github/shirates-core/build/repository")
}

dependencies {

    // JUnit 5
    implementation("org.junit.jupiter:junit-jupiter-api:5.10.1")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.1")

    // shirates-core
    testImplementation("io.github.ldi-github:shirates-core:$shiratesCoreVersion")

    // Appium
    testImplementation("io.appium:java-client:$appiumClientVersion")

    // Apache Commons IO
    testImplementation("commons-io:commons-io:2.15.1")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}