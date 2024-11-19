package com.yttydev.whm.navigation

sealed class Destination(protected val route: String, vararg params: String) {

    val fullRoute: String = if (params.isEmpty()) {
        route
    } else {
        val builder = StringBuilder(route)
        params.forEach { builder.append("/{${it}}") }
        builder.toString()
    }

    sealed class NoArgumentsDestination(route: String) : Destination(route)

    data object ExercisesScreen : NoArgumentsDestination("exercises")

    data object StatisticsScreen : NoArgumentsDestination("statistics")

    data object ProfileScreen : NoArgumentsDestination("profile")

    data object PracticeDetailsScreen : Destination("practice", "practiceId") {
        private const val PRACTICE_ID_KEY = "practiceId"

        operator fun invoke(practiceId: Long): String = route.appendParams(
            PRACTICE_ID_KEY to practiceId
        )
    }
}

internal fun String.appendParams(vararg params: Pair<String, Any?>): String {
    val builder = StringBuilder(this)

    params.forEach {
        it.second?.toString()?.let { arg ->
            builder.append("/$arg")
        }
    }

    return builder.toString()
}