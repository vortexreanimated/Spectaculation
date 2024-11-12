plugins {
    java
    id("io.freefair.lombok") version "8.10.2"
    id("org.openrewrite.rewrite") version("6.27.0")
}

rewrite {
    activeRecipe("org.openrewrite.java.migrate.UpgradeToJava21")
    activeRecipe("org.openrewrite.java.migrate.guava.NoGuava")
    activeRecipe("org.openrewrite.java.RemoveUnusedImports")
    activeRecipe("org.openrewrite.java.OrderImports")
    activeRecipe("dev.vortex.sculk.rewrite.LicenseHeader")
    activeRecipe("dev.vortex.sculk.rewrite.PackageRefactor")
    activeRecipe("org.openrewrite.staticanalysis.RemoveRedundantTypeCast")
    activeRecipe("org.openrewrite.staticanalysis.CodeCleanup")
    activeRecipe("org.openrewrite.staticanalysis.CombineSemanticallyEqualCatchBlocks")
    activeRecipe("org.openrewrite.staticanalysis.java.MoveFieldAnnotationToType")
    activeRecipe("org.openrewrite.staticanalysis.JavaApiBestPractices")
    activeRecipe("org.openrewrite.staticanalysis.MissingOverrideAnnotation")
    activeRecipe("org.openrewrite.staticanalysis.NoEmptyCollectionWithRawType")
    activeRecipe("org.openrewrite.staticanalysis.NoToStringOnStringType")
    activeRecipe("org.openrewrite.staticanalysis.NoValueOfOnStringType")
    activeRecipe("org.openrewrite.staticanalysis.RemoveUnusedPrivateMethods")
    activeRecipe("org.openrewrite.staticanalysis.RemoveUnusedPrivateFields")
    activeRecipe("org.openrewrite.staticanalysis.RemoveUnusedLocalVariables")
    activeRecipe("org.openrewrite.staticanalysis.StaticMethodNotFinal")
    activeRecipe("org.openrewrite.staticanalysis.UseJavaStyleArrayDeclarations")
    activeRecipe("org.openrewrite.staticanalysis.UseLambdaForFunctionalInterface")
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

    rewrite("org.openrewrite.recipe:rewrite-migrate-java:2.28.0")
    rewrite("org.openrewrite.recipe:rewrite-static-analysis:1.19.0")
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
