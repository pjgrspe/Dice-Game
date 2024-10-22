package ph.edu.auf.gorospe.patrickjason.rollingdadice.util

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
import kotlin.random.Random

@Composable
fun Modifier.bouncingAnimation(): Modifier {
    val infiniteTransition = rememberInfiniteTransition()

    // Bounce effect parameters
    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.2f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 500, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    return this.scale(scale)
}

@Composable
fun Modifier.floatingAnimation(): Modifier {


    val infiniteTransition = rememberInfiniteTransition()

    // Scale animations with wider ranges for a more obvious effect
    val initialScale = remember { Random.nextFloat().coerceIn(0.95f, 1.0f) }
    val targetScale = remember { Random.nextFloat().coerceIn(1.05f, 1.1f) }
    val durationScale = remember { Random.nextInt(2000, 3000) }

    // Position (translation) animations with more pronounced movement
    val translationXRange = remember { Random.nextFloat().coerceIn(-15f, 15f) }
    val translationYRange = remember { Random.nextFloat().coerceIn(-15f, 15f) }
    val durationPosition = remember { Random.nextInt(2500, 3500) }

    // Rotation animations with larger angles for more obvious tilting
    val initialRotation = remember { Random.nextFloat().coerceIn(-5f, 5f) }
    val targetRotation = remember { Random.nextFloat().coerceIn(-10f, 10f) }
    val durationRotation = remember { Random.nextInt(2500, 3500) }

    val scale by infiniteTransition.animateFloat(
        initialValue = initialScale,
        targetValue = targetScale,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = durationScale),
            repeatMode = RepeatMode.Reverse
        )
    )

    val translationX by infiniteTransition.animateFloat(
        initialValue = -translationXRange,
        targetValue = translationXRange,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = durationPosition),
            repeatMode = RepeatMode.Reverse
        )
    )

    val translationY by infiniteTransition.animateFloat(
        initialValue = -translationYRange,
        targetValue = translationYRange,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = durationPosition),
            repeatMode = RepeatMode.Reverse
        )
    )

    val rotation by infiniteTransition.animateFloat(
        initialValue = initialRotation,
        targetValue = targetRotation,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = durationRotation),
            repeatMode = RepeatMode.Reverse
        )
    )

    return this
        .scale(scale)
        .graphicsLayer(
            translationX = translationX,
            translationY = translationY,
            rotationZ = rotation
        )
}
