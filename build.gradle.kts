plugins {
    kotlin("jvm") version "1.8.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

val shiratesCoreVersion = "6.7.4"
val appiumClientVersion = "9.1.0"

val userHome = System.getProperty("user.home")

repositories {
    mavenCentral()

//    maven(url = "file:/$userHome/github/ldi-github/shirates-core/build/repository")
}

dependencies {
    testImplementation(kotlin("test"))

    // JUnit 5
    implementation("org.junit.jupiter:junit-jupiter-api:5.10.1")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.1")

    // shirates-core
    testImplementation("io.github.ldi-github:shirates-core:$shiratesCoreVersion")

    // Appium
    testImplementation("io.appium:java-client:$appiumClientVersion")

    // https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core
    testImplementation("org.apache.logging.log4j:log4j-core:2.22.1")

    // https://mvnrepository.com/artifact/org.slf4j/slf4j-nop
    testImplementation("org.slf4j:slf4j-nop:2.0.9")

    // Apache Commons IO
    testImplementation("commons-io:commons-io:2.15.1")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}