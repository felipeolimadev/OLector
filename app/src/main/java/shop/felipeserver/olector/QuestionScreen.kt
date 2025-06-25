package shop.felipeserver.olector

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

import kotlin.random.Random


@Composable
fun QuestionScreen(listaDecks: List<ItemImagem>, navController: NavController) {


    var prompt by remember { mutableStateOf(TextFieldValue("")) }
    Scaffold() { innerPadding ->
        BoxBlurEffect()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,

            ) {
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = stringResource(R.string.question_title),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 35.sp,
                    fontFamily = FontFamily.Serif,
                    letterSpacing = 1.sp,
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF1A0B2E),
                            Color(0xFFA935A4),
                            Color(0xFFE8709A),
                            Color(0xFFFBAF8C)
                        )
                    ),
                    shadow = Shadow(
                        color = Color.White.copy(alpha = 0.2f),
                        offset = Offset(2f, 2f),
                        blurRadius = 6f
                    )

                )
            )
            Spacer(modifier = Modifier.padding(80.dp))
            Text(
                text = stringResource(R.string.thinking_question),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Serif,
                    letterSpacing = 1.sp,
                    color = Color(0xFFd8b4fe),
                    shadow = Shadow(
                        color = Color.White.copy(alpha = 0.2f),
                        offset = Offset(2f, 2f),
                        blurRadius = 6f
                    )
                )
            )
            Spacer(modifier = Modifier.height(152.dp))
            OutlinedTextField(
                value = prompt,
                onValueChange = { newText -> prompt = newText },
                placeholder = { Text(text = stringResource(R.string.write_question)) },
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = {
                    navController.navigate("answer_screen/${prompt.text}")
                }
            ) {

            }


        }
    }
}

@Preview
@Composable
fun QuestionScreenPreview() {
    val listaDecks = Datasource.carregarItens()
    val navController = rememberNavController()
    QuestionScreen(listaDecks = listaDecks, navController = navController)
}



