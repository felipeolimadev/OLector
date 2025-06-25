package shop.felipeserver.olector

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import shop.felipeserver.olector.Datasource.carregarItens
import shop.felipeserver.olector.ui.theme.OLectorTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OLectorTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentWindowInsets = WindowInsets(0.dp)

                ) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "home",
                        modifier = Modifier.padding(innerPadding) // Apply padding from Scaffold
                    ) {
                        composable(route = "home") {
                            CardGrid(
                                listaDecks = carregarItens(),
                                navController = navController
                            )
                        }

                        composable(
                            route = "details_screen/{itemId}",
                            arguments = listOf(navArgument("itemId") { type = NavType.IntType })
                        ) { backStackEntry ->

                            val itemId = backStackEntry.arguments?.getInt("itemId") ?: 0

                            val items = carregarItens()

                            val item = items.find { it.idImagem == itemId } ?: items[0]

                            CardDetail(
                                idDetail = item.idImagem,
                                nameDetail = item.nome,
                                descDetail = item.descricao
                            )
                        }
                        composable(route = "question_screen") {
                            QuestionScreen(
                                navController = navController,
                                listaDecks = carregarItens()
                            )
                        }
                        composable(route = "answer_screen/{prompt}") { backStackEntry ->
                            val prompt = backStackEntry.arguments?.getString("prompt") ?: ""
                            AnswerScreen(prompt = prompt, navController = navController)
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OLectorTheme {
        // Previewing CardsList requires a NavController, which is tricky in previews.
        // Consider creating a separate preview for CardsList content if needed.
    }
}