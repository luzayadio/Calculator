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
fun MyButton(modifier: Modifier = Modifier, text: String) {
    Button(
        shape = RoundedCornerShape(50),
        modifier = modifier.fillMaxHeight().padding(5.dp),
        onClick = {  }
    ) {
        Text(
            text,
            fontSize = 30.sp,
        )
    }
}

@Composable
fun CalculatorApp(modifier: Modifier = Modifier) {
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
            MyButton(
                modifier = Modifier.weight(1F),
                text = "C"
            )
            MyButton(
                modifier = Modifier.weight(1F),
                text = "+/-"
            )
            MyButton(
                modifier = Modifier.weight(1F),
                text = "%"
            )
            MyButton(
                modifier = Modifier.weight(1F),
                text = "/"
            )
        }
        Row(
            modifier = Modifier.weight(1F),
        ) {

            MyButton(
                modifier = Modifier.weight(1F),
                text = "7"
            )
            MyButton(
                modifier = Modifier.weight(1F),
                text = "8"
            )
            MyButton(
                modifier = Modifier.weight(1F),
                text = "9"
            )
            MyButton(
                modifier = Modifier.weight(1F),
                text = "X"
            )
        }
        Row(
            modifier = Modifier.weight(1F),
        ) {
            MyButton(
                modifier = Modifier.weight(1F),
                text = "4"
            )
            MyButton(
                modifier = Modifier.weight(1F),
                text = "5"
            )
            MyButton(
                modifier = Modifier.weight(1F),
                text = "6"
            )
            MyButton(
                modifier = Modifier.weight(1F),
                text = "-"
            )
        }
        Row(
            modifier = Modifier.weight(1F),
        ) {
            MyButton(
                modifier = Modifier.weight(1F),
                text = "1"
            )
            MyButton(
                modifier = Modifier.weight(1F),
                text = "2"
            )
            MyButton(
                modifier = Modifier.weight(1F),
                text = "3"
            )
            MyButton(
                modifier = Modifier.weight(1F),
                text = "+"
            )
        }
        Row(
            modifier = Modifier.weight(1F),
        ) {
            MyButton(
                modifier = Modifier.weight(2F),
                text = "0"
            )
            MyButton(
                modifier = Modifier.weight(1F),
                text = ","
            )
            MyButton(
                modifier = Modifier.weight(1F),
                text = "="
            )
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