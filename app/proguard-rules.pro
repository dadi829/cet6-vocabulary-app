# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Keep Room entities
-keep class com.example.cet6vocabulary.data.entities.** { *; }

# Keep Kotlin metadata
-keep class kotlin.Metadata { *; }
