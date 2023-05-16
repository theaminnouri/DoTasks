package com.pignasoft.dotasks

import android.annotation.SuppressLint

const val CATEGORY_ROUTE = "CATEGORY_ROTE"
const val TASKS_ROUTE = "TASKS_ROUTE"
const val ACCOUNT_ROUTE = "ACCOUNT_ROUTE"

@SuppressLint("NavRoutes")
sealed class NavRoutes(
    val route: String,
    val titleResId: Int = -1,
) {
    object CategoryNav : NavRoutes(
        route = CATEGORY_ROUTE,
        titleResId = R.string.category_screen_title,
    )

    object TasksNav : NavRoutes(
        route = TASKS_ROUTE,
        titleResId = R.string.tasks_screen_title,
    )

    object AccountNav : NavRoutes(
        route = ACCOUNT_ROUTE,
        titleResId = R.string.account_screen_title,
    )
}
