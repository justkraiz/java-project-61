plugins {
    application
    checkstyle
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.3"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.3")
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass = "hexlet.code.App"
}
