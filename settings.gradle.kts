pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "card-trading-app"

include(
    ":app",
    ":core:model",
    ":core:database",
    ":feature:marketplace",
    ":feature:collection",
)
