pluginManagement {
    repositories {
        // 腾讯镜像（优先，覆盖所有仓库）
        maven { url = uri("https://mirrors.cloud.tencent.com/repository/google") }
        maven { url = uri("https://mirrors.cloud.tencent.com/repository/maven-central") }
        maven { url = uri("https://mirrors.cloud.tencent.com/repository/gradle-plugin") }
        // 阿里云镜像兜底
        maven { url = uri("https://maven.aliyun.com/repository/google") }
        maven { url = uri("https://maven.aliyun.com/repository/central") }
        maven { url = uri("https://maven.aliyun.com/repository/gradle-plugin") }
        // 官方仓库备选（镜像失效时用）
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        // 和上面保持一致，确保所有依赖都走镜像
        maven { url = uri("https://mirrors.cloud.tencent.com/repository/google") }
        maven { url = uri("https://mirrors.cloud.tencent.com/repository/maven-central") }
        maven { url = uri("https://mirrors.cloud.tencent.com/repository/gradle-plugin") }
        maven { url = uri("https://maven.aliyun.com/repository/google") }
        maven { url = uri("https://maven.aliyun.com/repository/central") }
        maven { url = uri("https://maven.aliyun.com/repository/gradle-plugin") }
        google()
        mavenCentral()
    }
}

rootProject.name = "text01"
include(":app")