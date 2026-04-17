pluginManagement {
    repositories {
        // 腾讯云镜像优先，解决所有下载问题
        maven { url = uri("https://mirrors.cloud.tencent.com/repository/google") }
        maven { url = uri("https://mirrors.cloud.tencent.com/repository/central") }
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        // 腾讯云镜像优先
        maven { url = uri("https://mirrors.cloud.tencent.com/repository/google") }
        maven { url = uri("https://mirrors.cloud.tencent.com/repository/central") }
        google()
        mavenCentral()
    }
}

rootProject.name = "text01"
include(":app")