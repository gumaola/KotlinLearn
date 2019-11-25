import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins{
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
}


android {
    compileSdkVersion (28)
    defaultConfig {
        applicationId ="cn.nano.kotlinlearn"
        minSdkVersion (15)
        targetSdkVersion (28)
        versionCode =1
        versionName ="1.0"
        testInstrumentationRunner ="androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(kotlin("stdlib-jdk7", KotlinCompilerVersion.VERSION))
    implementation ("androidx.appcompat:appcompat:1.0.2")
    implementation ("androidx.core:core-ktx:1.0.2")
    testImplementation ("junit:junit:4.12")
    testImplementation("androidx.test.ext:junit:1.1.0")
    testImplementation("androidx.test.espresso:espresso-core:3.1.1")
}
