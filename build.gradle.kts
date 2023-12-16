plugins {
    java
    id("org.springframework.boot") version "3.1.5"
    id("io.spring.dependency-management") version "1.1.3"

}
dependencies {
    implementation ("org.springframework.boot:spring-boot-starter")
    testImplementation(platform("io.cucumber:cucumber-bom:7.14.0"))

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.junit.platform:junit-platform-suite")
    testImplementation("io.cucumber:cucumber-java")
    testImplementation("io.cucumber:cucumber-junit-platform-engine")
    testImplementation("io.cucumber:cucumber-spring")

}

repositories {
    mavenLocal()
    mavenCentral()
}

tasks.withType<Test> {
    useJUnitPlatform()
    systemProperty("cucumber.junit-platform.naming-strategy", "long")
   testLogging {
    showStandardStreams = true
    }
}

