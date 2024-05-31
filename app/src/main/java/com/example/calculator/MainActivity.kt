package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CalculatorApp(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun CalculatorApp(modifier: Modifier = Modifier) {
    val buttonMod = Modifier.fillMaxHeight().padding(5.dp);
    val buttonShape = RoundedCornerShape(50);
    //val buttonBorder = BorderStroke(2.dp, Color(105, 205, 216));

    Column(
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().weight(1F),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Bottom,
        ) {
            Text(
                "0",
                fontSize = 100.sp,
            )
        }
        Row(
            modifier = Modifier.weight(1F),
        ) {
            Button(
                shape = buttonShape,
                modifier = buttonMod.weight(1F),
                onClick = {  }) {
                Text("C")
            }
            Button(
                shape = buttonShape,
                modifier = buttonMod.weight(1F),
                onClick = {  }) {
                Text("+/-")
            }
            Button(
                shape = buttonShape,
                modifier = buttonMod.weight(1F),
                onClick = {  }) {
                Text("%")
            }
            Button(
                shape = buttonShape,
                modifier = buttonMod.weight(1F),
                onClick = {  }) {
                Text("/")
            }
        }
        Row(
            modifier = Modifier.weight(1F),
        ) {
            Button(
                shape = buttonShape,
                modifier = buttonMod.weight(1F),
                onClick = {  }) {
                Text("7")
            }
            Button(
                shape = buttonShape,
                modifier = buttonMod.weight(1F),
                onClick = {  }) {
                Text("8")
            }
            Button(
                shape = buttonShape,
                modifier = buttonMod.weight(1F),
                onClick = {  }) {
                Text("9")
            }
            Button(
                shape = buttonShape,
                modifier = buttonMod.weight(1F),
                onClick = {  }) {
                Text("X")
            }
        }
        Row(
            modifier = Modifier.weight(1F),
        ) {
            Button(
                shape = buttonShape,
                modifier = buttonMod.weight(1F),
                onClick = {  }) {
                Text("4")
            }
            Button(
                shape = buttonShape,
                modifier = buttonMod.weight(1F),
                onClick = {  }) {
                Text("5")
            }
            Button(
                shape = buttonShape,
                modifier = buttonMod.weight(1F),
                onClick = {  }) {
                Text("6")
            }
            Button(
                shape = buttonShape,
                modifier = buttonMod.weight(1F),
                onClick = {  }) {
                Text("-")
            }
        }
        Row(
            modifier = Modifier.weight(1F),
        ) {
            Button(
                shape = buttonShape,
                modifier = buttonMod.weight(1F),
                onClick = {  }) {
                Text("1")
            }
            Button(
                shape = buttonShape,
                modifier = buttonMod.weight(1F),
                onClick = {  }) {
                Text("2")
            }
            Button(
                shape = buttonShape,
                modifier = buttonMod.weight(1F),
                onClick = {  }) {
                Text("3")
            }
            Button(
                shape = buttonShape,
                modifier = buttonMod.weight(1F),
                onClick = {  }) {
                Text("+")
            }
        }
        Row(
            modifier = Modifier.weight(1F),
        ) {
            Button(
                shape = buttonShape,
                modifier = buttonMod.weight(2F),
                onClick = {  }) {
                Text("0")
            }
            Button(
                shape = buttonShape,
                modifier = buttonMod.weight(1F),
                onClick = {  }) {
                Text(",")
            }
            Button(
                shape = buttonShape,
                modifier = buttonMod.weight(1F),
                onClick = {  }) {
                Text("=")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    CalculatorTheme {
        CalculatorApp(modifier = Modifier.fillMaxSize())
    }
}