plugins {
    application
    id("java")
}

group = "com.kadenfrisk"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

// Specify the main class for the application
application {
    mainClass.set("com.kadenfrisk.App")
}