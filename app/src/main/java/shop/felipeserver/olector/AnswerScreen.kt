package shop.felipeserver.olector

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavController
import shop.felipeserver.olector.Datasource.carregarItens
import kotlin.random.Random

@Composable
fun AnswerScreen(prompt: String, navController: NavController) {
    val listaDecks: List<ItemImagem> = carregarItens()
    val item = remember { Random.nextInt(listaDecks.size) }
    val itemName = listaDecks[item].nome;
    val itemDesc = listaDecks[item].descricao;
    val itemNameString = stringResource(id = itemName)
    val itemDescString = stringResource(id = itemDesc)
    val itemImagem = painterResource(id = listaDecks[item].idImagem)

    Scaffold(contentWindowInsets = WindowInsets(0.dp)) { innerPadding ->
        Image(
            painter = itemImagem,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .blur(radius = 10.dp),
            alpha = 0.5f, // Adjust the alpha for transparency
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .background(Color.Black.copy(alpha = 0.5f)) // Semi-transparent background
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
                verticalArrangement = androidx.compose.foundation.layout.Arrangement.Top
            ) {
                Text(text = "Answer Screen", color = Color.White)
                Text(text = "Item Name: $itemNameString", color = Color.White)

                Text(text = item.toString(), color = Color.White)
                Text(text = prompt, color = Color.White)
            }

        }
    }
}

@Preview
@Composable
fun AnswerScreenPreview() {
    val navController = rememberNavController()
    AnswerScreen(prompt = "Sample prompt", navController = navController)
}



