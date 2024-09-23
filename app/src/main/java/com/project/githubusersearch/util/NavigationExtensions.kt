package com.project.githubusersearch.util

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.R as GitHubSearchR

/**
 * Return [NavController] from Fragment Reference
 */
val Fragment.navController get() = findNavController()

/**
 * Navigate To [NavDirections] with null safety or crash issue, it also give Default Animation on
 * It's Navigation
 * @param direction is Direction to other page
 * @param clearTask will clear previous backStack when navigated, same functionality as [Activity.finish]
 */
fun NavController.navigateOrNull(direction: NavDirections?, clearTask: Boolean = false) {
    try {
        val options = NavOptions.Builder().apply {
            setEnterAnim(GitHubSearchR.anim.nav_default_enter_anim)
            setExitAnim(GitHubSearchR.anim.nav_default_exit_anim)
            setPopEnterAnim(GitHubSearchR.anim.nav_default_pop_enter_anim)
            setPopExitAnim(GitHubSearchR.anim.nav_default_pop_exit_anim)

            if (clearTask) {
                setLaunchSingleTop(true)
                currentDestination?.id?.let { currentDest ->
                   setPopUpTo(currentDest, clearTask)
               }
            }
        }.build()

        direction?.let { navigate(it, options) }
    } catch (e: Exception) {
    }
}
