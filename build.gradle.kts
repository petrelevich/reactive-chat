import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.gradle.plugins.ide.idea.model.IdeaLanguageLevel

plugins {
    idea
    id("org.springframework.boot") version "2.7.1" apply false
    id("io.spring.dependency-management") version "1.0.12.RELEASE"
}

idea {
    project {
        languageLevel = IdeaLanguageLevel(17)
    }
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
}

allprojects {
    group = "ru.petrelevich.chat"

    repositories {
        mavenLocal()
        mavenCentral()
    }

    apply(plugin = "io.spring.dependency-management")
    dependencyManagement {
        dependencies {
            imports {
                mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
                mavenBom("org.testcontainers:testcontainers-bom:${Versions.testcontainers}")
            }
            dependency("org.webjars:sockjs-client:${Versions.sockjsClient}")
            dependency("org.webjars:stomp-websocket:${Versions.stompWebsocket}")
            dependency("org.webjars:bootstrap:${Versions.bootstrap}")
        }
    }

    configurations.all {
        resolutionStrategy {
            failOnVersionConflict()
        }
    }
}


tasks {
    val hello by registering {
        doLast {
            println("hello task")
        }
    }

    val managedVersions by registering {
        doLast {
            project.extensions.getByType<DependencyManagementExtension>()
                .managedVersions
                .toSortedMap()
                .map { "${it.key}:${it.value}" }
                .forEach(::println)
        }
    }
}