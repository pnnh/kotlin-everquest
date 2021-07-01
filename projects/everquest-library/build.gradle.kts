plugins {
    application
    kotlin("multiplatform") version "1.5.20"
    id("maven-publish")
}

group = "xyz.sfx"
version = "1.0"

application {
    mainClass.set("xyz.sfx.Main")
}

repositories {
    jcenter()
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/kotlin-js-wrappers") }
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven") }
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }
    js(LEGACY) {
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
        nodejs {

        }
    }

    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }
    nativeTarget.apply {
        val main by compilations.getting
        val interop by main.cinterops.creating{
            defFile = project.file("src/nativeInterop/cinterop/lib.def")
            includeDirs.allHeaders("src/nativeInterop/cinterop")
        }
        binaries {
            sharedLib {
                baseName = "native"
            }
            executable {
                entryPoint = "main"
            }
        }
    }

    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting {
            dependencies {
            }
        }
        val jvmTest by getting
        val jsMain by getting {
            dependencies {
            }
        }
        val jsTest by getting
        val nativeMain by getting
        val nativeTest by getting
    }
}

tasks.wrapper {
    distributionType = Wrapper.DistributionType.ALL
}