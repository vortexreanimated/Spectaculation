plugins {
    java
    id("io.freefair.lombok") version "8.10.2"
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

repositories {
    mavenCentral()
    mavenLocal() // you need to have cb sources installed
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/groups/public/")
    maven("https://repo.bukkit.org/content/groups/public/")
    maven("https://maven.enginehub.org/repo/")
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.8.8-R0.1-SNAPSHOT")
    compileOnly("org.bukkit:craftbukkit:1.8.8-R0.1-SNAPSHOT")
}

tasks.processResources {
    inputs.property("version", project.version)
    inputs.property("name", project.name)
    inputs.property("description", project.description)
    inputs.property("mainClass", project.property("mainClass"))

    filesMatching(listOf("plugin.yml")) {
        expand(inputs.properties)
    }
}
