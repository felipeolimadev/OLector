package shop.felipeserver.olector

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import shop.felipeserver.olector.AppConstants.cardPadding
import shop.felipeserver.olector.Datasource.carregarItens

@Composable
fun CardDetail(idDetail: Int, nameDetail: Int, descDetail: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            )
    {

            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = idDetail),
                contentDescription = descDetail.toString(),
                contentScale = ContentScale.Crop

            )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .align(Alignment.BottomCenter)

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
        CardDetail(idDetail = items[0].idImagem, nameDetail = items[0].nome, descDetail = items[0].descricao)
    }
}
