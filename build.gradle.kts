// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

plugins {
    `java-library`
    id("jacoco")
}

val applicationJavaVersion = "11"
val jacocoVersion = "0.8.13"
val jacksonVersion = "2.19.0"
val junitVersion = "5.12.2"
val wiremockVersion = "3.13.0"
val slf4jVersion = "2.0.17"
val apacheHttpClientVersion = "5.4.4"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(applicationJavaVersion)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.httpcomponents.client5:httpclient5:$apacheHttpClientVersion")
    implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
    implementation("org.slf4j:slf4j-api:$slf4jVersion")
    testImplementation(platform("org.junit:junit-bom:$junitVersion"))
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")
    {
        exclude("net.minidev:json-smart:2.5.0")
    }
    testImplementation("net.minidev:json-smart:2.5.2")
    testImplementation("org.wiremock:wiremock:$wiremockVersion")
    {
        exclude("org.eclipse.jetty:jetty-http:11.0.24")
        exclude("commons-io:commons-io:2.11.0")
    }
    testImplementation("org.eclipse.jetty:jetty-http:11.0.25")
    testImplementation("commons-io:commons-io:2.19.0")
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
    jacoco {
        enabled = true
    }
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        xml.required.set(true)
        html.required.set(true)
        csv.required.set(false)
    }
}