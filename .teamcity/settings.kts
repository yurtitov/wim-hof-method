import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.triggers.vcs

version = "2024.03"

project {

    buildType(Validate)
}

object Validate : BuildType({
    name = "Validate"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        gradle {
            id = "Unit tests"
            tasks = "assembleUnitTest"
            useGradleWrapper = true
        }
        gradle {
            id = "Build"
            tasks = "clean build -x test -x wasmJsBrowserTest"
            useGradleWrapper = true
        }
    }

    triggers {
        vcs {
        }
    }

    features {
        perfmon {
        }
    }
})
