package com.project.githubusersearch.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.project.githubusersearch.R
import com.project.githubusersearch.databinding.ActivityMainBinding
import com.project.githubusersearch.util.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by viewBinding<ActivityMainBinding>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.root.post {
            val navHostFragment = supportFragmentManager.findFragmentById(R.id.mainNavHostContainer) as NavHostFragment
            val navController = navHostFragment.navController

            setSupportActionBar(binding.toolbar)
            setupActionBarWithNavController(navController)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.mainNavHostContainer)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}