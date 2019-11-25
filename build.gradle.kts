// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
     val kotlin_version = "1.3.50"
    repositories {
        google()
        jcenter()
        
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:3.5.1")
        classpath (kotlin("gradle-plugin", version = "1.3.50"))
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        
    }
}


//tasks {
//    register("clean", Delete::class){
//        delete(buildDir)
//    }
//}

tasks.register("clean",Delete::class){
    delete(rootProject.buildDir)
}

//task("clean",{
//    delete rootProject.buildDir
//})
