// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.kotlin.kapt) apply false
    alias(libs.plugins.dagger.hilt.plugin) apply false
    alias(libs.plugins.google.gms.google.services) apply false
//    id("com.google.maps.android.secrets") version "2.0.1" apply false
}
