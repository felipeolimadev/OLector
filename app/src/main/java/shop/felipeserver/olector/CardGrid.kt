package shop.felipeserver.olector

import androidx.compose.ui.graphics.Shape
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import shop.felipeserver.olector.ui.theme.FABButtonColor
import shop.felipeserver.olector.ui.theme.InfinityIcon
import shop.felipeserver.olector.ui.theme.backgroundColor
import shop.felipeserver.olector.ui.theme.cardBackgroundColor
import shop.felipeserver.olector.ui.theme.cardBorderColor
import shop.felipeserver.olector.ui.theme.cardTitleColor

@Composable
fun CardGrid(listaDecks: List<ItemImagem>, navController: NavController) {

    Scaffold(
        //Habilite o edge to edge e deve ser sempre usado com scaffold
        contentWindowInsets = WindowInsets(0.dp), floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("question_screen") }, containerColor = FABButtonColor
            ) {
                Icon(InfinityIcon,
                    contentDescription = "Add",
                    modifier = Modifier.size(28.dp))
            }
        }, floatingActionButtonPosition = FabPosition.Center

    ) { innerPadding ->

        Column(
            modifier = Modifier
                .background(backgroundColor)
                .fillMaxHeight()
                .fillMaxWidth()

        ) {

            LazyVerticalGrid(
                columns = GridCells.Adaptive(150.dp)
            ) {
                items(listaDecks.size) { item ->
                    ImageCard(
                        itemId = listaDecks[item].idImagem,
                        itemName = listaDecks[item].nome,
                        itemDesc = listaDecks[item].descricao,
                        navController = navController
                    )
                }
            }

        }
    }

}


@Composable
fun ImageCard(itemId: Int, itemName: Int, itemDesc: Int, navController: NavController) {
    val painter = painterResource(itemId)
    val imageWidth =
        painter.intrinsicSize.width.dp / LocalContext.current.resources.displayMetrics.density

    Box(
        modifier = Modifier
            .width(imageWidth)
            .clip(RoundedCornerShape(5.dp))
            .clickable(onClick = {
                navController.navigate("details_screen/$itemId")
            })
            .padding(5.dp)
            .border(
                BorderStroke(1.dp, cardBorderColor), RoundedCornerShape(5.dp)
            )

    ) {
        Image(
            painter = painterResource(itemId),
            contentDescription = itemDesc.toString(),
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop

        )

        Text(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .background(cardBackgroundColor)
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 3.dp, bottom = 3.dp),
            fontSize = 16.sp,
            text = stringResource(itemName),
            textAlign = TextAlign.Center,
            color = cardTitleColor,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1

        )


    }
}

@Composable
fun FloatingActionButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = FloatingActionButtonDefaults.shape,
    containerColor: Color = FABButtonColor,
    contentColor: Color = FABButtonColor,
    elevation: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation(),
    interactionSource: MutableInteractionSource? = null,
    content: @Composable () -> Unit,
) {

}

@Preview
@Composable
fun FloatingActionButtonSample() {
    FloatingActionButton(
        onClick = { /* do something */ },
    ) {
        Icon(Icons.Filled.Add, "Localized description")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CardsListPreview() {
    val sampleData = listOf(
        ItemImagem(R.string.N_00_, R.string.D_00_, R.drawable._0_00_thefool),
        ItemImagem(R.string.N_01_, R.string.D_01_, R.drawable._0_01_themagician),
        ItemImagem(R.string.N_02_, R.string.D_02_, R.drawable._0_02_thehighpriestess),
        ItemImagem(R.string.N_03_, R.string.D_03_, R.drawable._0_03_theempress),
        ItemImagem(R.string.N_04_, R.string.D_04_, R.drawable._0_04_theemperor),
        ItemImagem(R.string.N_05_, R.string.D_05_, R.drawable._0_05_thehierophant),
        ItemImagem(R.string.N_06_, R.string.D_06_, R.drawable._0_06_thelovers),
        ItemImagem(R.string.N_07_, R.string.D_07_, R.drawable._0_07_thechariot),
        ItemImagem(R.string.N_08_, R.string.D_08_, R.drawable._0_08_strength),
        ItemImagem(R.string.N_09_, R.string.D_09_, R.drawable._0_09_thehermit),
        ItemImagem(R.string.N_10_, R.string.D_10_, R.drawable._0_10_wheeloffortune),
        ItemImagem(R.string.N_11_, R.string.D_11_, R.drawable._0_11_justice),
        ItemImagem(R.string.N_12_, R.string.D_12_, R.drawable._0_12_thehangedman),
        ItemImagem(R.string.N_13_, R.string.D_13_, R.drawable._0_13_death),
        ItemImagem(R.string.N_14_, R.string.D_14_, R.drawable._0_14_temperance),
        ItemImagem(R.string.N_15_, R.string.D_15_, R.drawable._0_15_thedevil),
        ItemImagem(R.string.N_16_, R.string.D_16_, R.drawable._0_16_thetower),
        ItemImagem(R.string.N_17_, R.string.D_17_, R.drawable._0_17_thestar),
        ItemImagem(R.string.N_18_, R.string.D_18_, R.drawable._0_18_themoon),
        ItemImagem(R.string.N_19_, R.string.D_19_, R.drawable._0_19_thesun),
        ItemImagem(R.string.N_20_, R.string.D_20_, R.drawable._0_20_judgement),
        ItemImagem(R.string.N_21_, R.string.D_21_, R.drawable._0_21_theworld),
    )
    val previewNavController = rememberNavController()
    CardGrid(listaDecks = sampleData, navController = previewNavController)
}

@Preview
@Composable
fun ImageCardPreview() {
    val previewNavController = rememberNavController()
    ImageCard(
        itemId = R.drawable._0_00_thefool,
        itemName = R.string.N_00_,
        itemDesc = R.string.D_00_,
        navController = previewNavController
    )
}