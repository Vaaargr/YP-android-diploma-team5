// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    id("com.android.application") version "8.4.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.21" apply false
    id("convention.detekt")
    kotlin("kapt") version "1.9.22" apply false
}
