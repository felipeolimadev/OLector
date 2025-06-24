package shop.felipeserver.olector

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import shop.felipeserver.olector.AppConstants.cardPadding
import shop.felipeserver.olector.Datasource.carregarItens

@Composable
fun CardDetail(idDetail: Int, nameDetail: Int, descDetail: Int) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(Color.Transparent)
            
    ) {
        // The image takes up space at the top
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(600.dp), // or any height you want for the image
            painter = painterResource(id = idDetail),
            contentDescription = descDetail.toString(),
            contentScale = ContentScale.Crop
        )
        // Spacer to push the card to the bottom if content is short
        Spacer(modifier = Modifier.weight(1f, fill = true))
        // The card with the text
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),
            shape = RectangleShape
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(cardPadding)

            ) {
                Text(
                    text = stringResource(id = nameDetail),
                    fontSize = AppConstants.cardTitleFontSize
                )
                Text(
                    text = stringResource(id = descDetail)
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CardDetailPreview() {
    val items = carregarItens()
    // Assuming you want to preview the first item
    if (items.isNotEmpty()) {
        CardDetail(
            idDetail = items[1].idImagem,
            nameDetail = items[1].nome,
            descDetail = items[1].descricao
        )
    }
}
