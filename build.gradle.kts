plugins {
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.20" apply false
}

buildscript {
    repositories {
        maven { url = uri("https://mirrors.cloud.tencent.com/repository/google") }
        maven { url = uri("https://mirrors.cloud.tencent.com/repository/central") }
        google()
        mavenCentral()
    }
}
