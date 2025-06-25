package shop.felipeserver.olector

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


fun Color.Companion.fromHex(colorString: String): Color {
    return Color(android.graphics.Color.parseColor(colorString))
}

@Preview
@Composable
fun BoxBlurEffect() {
    val infiniteTransition = rememberInfiniteTransition()

    val purple950 = Color(0xFF3B0764)      // Tailwind's purple-950
    val indigo950 = Color(0xFF1E1B4B)      // Tailwind's indigo-950
    val black = Color(0xFF000000)          // Tailwind's black
    val abyssalPurple = Color(0xFF24243E)  // A compatible dark purple from the theme


    val blueX by infiniteTransition.animateFloat(
        initialValue = -50.dp.value,
        targetValue = 0.dp.value,
        animationSpec = infiniteRepeatable(
            animation = tween(5000),
            repeatMode = RepeatMode.Reverse
        )
    )

    val blueY by infiniteTransition.animateFloat(
        initialValue = -50.dp.value,
        targetValue = 0.dp.value,
        animationSpec = infiniteRepeatable(
            animation = tween(5000),
            repeatMode = RepeatMode.Reverse
        )
    )

    val redX by infiniteTransition.animateFloat(
        initialValue = (-150).dp.value,
        targetValue = 150.dp.value,
        animationSpec = infiniteRepeatable(
            animation = tween(5000),
            repeatMode = RepeatMode.Reverse
        )
    )
    val lightBlueX by infiniteTransition.animateFloat(
        initialValue = 150.dp.value,
        targetValue = 129.dp.value,
        animationSpec = infiniteRepeatable(
            animation = tween(5000),
            repeatMode = RepeatMode.Reverse
        )
    )
    val lightBlueY by infiniteTransition.animateFloat(
        initialValue = 130.dp.value,
        targetValue = -130.dp.value,
        animationSpec = infiniteRepeatable(
            animation = tween(5000),
            repeatMode = RepeatMode.Reverse
        )
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black) // Base color
                .blur(90.dp)

                // Original: #4B0F1F -> Translated to a base purple
                .background(purple950)
                .offset(x = blueX.dp, y = blueY.dp)

                // Original: #0D1B2A -> Translated to Indigo (Circle Shape)
                .background(color = indigo950, shape = CircleShape)
                .offset(x = redX.dp, y = 90.dp)

                // Original: #1A1A1A -> Translated to Black (Rounded Corner Shape)
                .background(color = black, shape = RoundedCornerShape(4.dp))
                .offset(x = lightBlueX.dp, y = lightBlueY.dp)

                // Original: #2E1A47 -> Translated to a compatible dark purple (Triangle Shape)
                .background(color = abyssalPurple, shape = GenericShape { size, _ ->
                    moveTo(size.width / 2f, 0f)
                    lineTo(size.width, size.height)
                    lineTo(0f, size.height)
                    close()
                })
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RevealButton(onReveal: () -> Unit) {
    val infiniteTransition = rememberInfiniteTransition()
    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(90.dp)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(Color(0xFF4B0F1F), Color(0xFF2E1A47)),
                    center = Offset(45f, 45f),
                    radius = 90f
                ),
                shape = CircleShape
            )
            .clickable { onReveal() }
            .shadow(12.dp, CircleShape)
    ) {
        Text(
            text = "♾",
            fontSize = 36.sp,
            color = Color(0xFFEDEDED),
            fontFamily = FontFamily.Cursive
        )
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun TarotRevealScreenPreview() {
    RevealButton(onReveal = {})
}
