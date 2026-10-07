pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MP20223191"
include(":app")
include(":mp3_!")
include(":mp3_2")
include(":mp3_3")
include(":mp3_4")
include(":mp3_5")
include(":mp3_6")
include(":mp4_1")
include(":mp4_2")
include(":mp4_3")
include(":mp4_4")
