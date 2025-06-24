package shop.felipeserver.olector
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavHost


sealed class Screen(val route: String) {
    object Home : Screen(route = "home_screen")
    object Details : Screen(route = "details_screen")
}

