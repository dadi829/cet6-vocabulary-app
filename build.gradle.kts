plugins {
    // AGP 8.4.0 兼容 Gradle 8.10.2
    id("com.android.application") version "8.4.0" apply false
    // Kotlin 2.0.21 包含 Compose 插件
    id("org.jetbrains.kotlin.android") version "2.0.21" apply false
    // Compose 编译器插件（Kotlin 2.0+ 必需）
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.21" apply false
    // KSP 替代 kapt（Kotlin 2.0+ 必需）
    id("com.google.devtools.ksp") version "2.0.21-1.0.25" apply false
}
