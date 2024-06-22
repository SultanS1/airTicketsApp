import org.gradle.api.JavaVersion

/**
 * Configuration object containing various settings for the project.
 */
object Configs {

    val compileSdk = 34

    val defaultConfig = DefaultConfig()
    val buildTypes = BuildTypes()
    val compileOptions = CompileOptions()
    val kotlinOptions = KotlinOptions()
    val buildFeatures = BuildFeatures()

    class DefaultConfig {
        val applicationId= "com.test.airtickets"
        val minSdk = 24
        val targetSdk = 34
        val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        val consumerProguardFiles = "consumer-rules.pro"
        val versionCode = 1
        val versionName = "1.0"
    }

    class BuildTypes {
        val release = Release()

        class Release {
            val isMinifyEnabled = false
            val proguardFiles = ProguardFiles(
                androidOptimize = "proguard-android-optimize.txt",
                customRules = "proguard-rules.pro"
            )
        }
    }

    class ProguardFiles(val androidOptimize: String, val customRules: String)

    class CompileOptions {
        val sourceCompatibility = JavaVersion.VERSION_1_8
        val targetCompatibility = JavaVersion.VERSION_1_8
    }

    class KotlinOptions {
        val jvmTarget = "1.8"
    }

    class BuildFeatures {
        val viewBinding = true
    }
}
