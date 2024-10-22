package ph.edu.auf.gorospe.patrickjason.rollingdadice.presentation.components

import DiceViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RandomizerButton(
    viewModel: DiceViewModel,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = {
            viewModel.rollDice()  // Keep the original roll functionality
        },
        modifier = modifier
            .padding(16.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFFFF0000), Color(0xFFFFA500)) // Red to Orange gradient
                ),
                shape = RoundedCornerShape(12.dp)
            ),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,  // Transparent background for gradient
            contentColor = Color.White  // White text color
        )
    ) {
        Text(
            text = "Roll",
            fontSize = 18.sp,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}
