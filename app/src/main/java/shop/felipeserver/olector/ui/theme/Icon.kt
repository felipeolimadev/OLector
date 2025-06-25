package shop.felipeserver.olector.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.material3.Surface
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

val InfinityIcon: ImageVector
    get() {
        if (_Infinity != null) return _Infinity!!

        _Infinity = ImageVector.Builder(
            name = "Infinity",
            defaultWidth = 16.dp,
            defaultHeight = 16.dp,
            viewportWidth = 16f,
            viewportHeight = 16f
        ).apply {
            path(
                fill = SolidColor(Color.Black)
            ) {
                moveTo(5.68f, 5.792f)
                lineTo(7.345f, 7.75f)
                lineTo(5.681f, 9.708f)
                arcToRelative(2.75f, 2.75f, 0f, true, true, 0f, -3.916f)
                close()
                moveTo(8f, 6.978f)
                lineTo(6.416f, 5.113f)
                lineToRelative(-0.014f, -0.015f)
                arcToRelative(3.75f, 3.75f, 0f, true, false, 0f, 5.304f)
                lineToRelative(0.014f, -0.015f)
                lineTo(8f, 8.522f)
                lineToRelative(1.584f, 1.865f)
                lineToRelative(0.014f, 0.015f)
                arcToRelative(3.75f, 3.75f, 0f, true, false, 0f, -5.304f)
                lineToRelative(-0.014f, 0.015f)
                close()
                moveToRelative(0.656f, 0.772f)
                lineToRelative(1.663f, -1.958f)
                arcToRelative(2.75f, 2.75f, 0f, true, true, 0f, 3.916f)
                close()
            }
        }.build()

        return _Infinity!!
    }

private var _Infinity: ImageVector? = null

@Preview
@Composable
private fun InfinityIconPreview() {
        Surface {
            Image(imageVector = InfinityIcon, contentDescription = "InfinityIcon")
        }

}
