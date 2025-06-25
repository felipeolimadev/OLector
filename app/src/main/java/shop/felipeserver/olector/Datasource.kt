package shop.felipeserver.olector

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class ItemImagem(
    val nome: Int,
    val descricao: Int,
    val idImagem: Int // 'Int' para referenciar o ID da imagem em res/drawable
)

object Color {



    //Font Sizes
    val cardTitleFontSize = 18.sp
    val cardDescriptionFontSize = 14.sp

    //Layout
    val cardPadding = 16.dp
}
object Datasource {
    fun carregarItens(): List<ItemImagem>{
        return listOf(
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
            ItemImagem(R.string.N_21_, R.string.D_21_, R.drawable._0_21_theworld)
        )
    }
}