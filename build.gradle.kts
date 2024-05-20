plugins {
    application
    id("java")
}

group = "com.kadenfrisk"
version = "1.0"

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
    mainClass.set("App")
}

// Main manifest attributes for the jar file
tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "App"
    }
}