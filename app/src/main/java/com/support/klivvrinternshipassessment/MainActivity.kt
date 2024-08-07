package com.support.klivvrinternshipassessment

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.support.klivvrinternshipassessment.core.data.Coord
import com.support.klivvrinternshipassessment.feature.citymap.MapScreen
import com.support.klivvrinternshipassessment.feature.home.presentation.screen.HomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Navigation()
        }
    }

    companion object {
        const val TAG = "MainActivity"
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen { coord ->
                navController.navigate(
                    "citymap/${coord.lat}/${coord.lon}"
                )
            }
        }
        composable("citymap/{lat}/{lon}") { backStackEntry ->
            val lat = backStackEntry.arguments?.getString("lat") ?: "0.0"
            val lon = backStackEntry.arguments?.getString("lon") ?: "0.0"
            Log.d(MainActivity.TAG, "Navigation: lat $lat")
            Log.d(MainActivity.TAG, "Navigation: lon $lon")
            MapScreen(
                coord = Coord(lat.toDouble(), lon.toDouble())
            )

        }
    }


}
