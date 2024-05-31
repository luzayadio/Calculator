package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
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
    Column(
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().weight(1F),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                "0",
            )
        }
        Row(
            modifier = Modifier.weight(1F),
        ) {
            Button(
                modifier = Modifier.weight(1F).fillMaxHeight(),
                onClick = {  }) {
                Text("C")
            }
            Button(
                modifier = Modifier.weight(1F).fillMaxHeight(),
                onClick = {  }) {
                Text("+/-")
            }
            Button(
                modifier = Modifier.weight(1F).fillMaxHeight(),
                onClick = {  }) {
                Text("%")
            }
            Button(
                modifier = Modifier.weight(1F).fillMaxHeight(),
                onClick = {  }) {
                Text("/")
            }
        }
        Row(
            modifier = Modifier.weight(1F),
        ) {
            Button(
                modifier = Modifier.weight(1F).fillMaxHeight(),
                onClick = {  }) {
                Text("7")
            }
            Button(
                modifier = Modifier.weight(1F).fillMaxHeight(),
                onClick = {  }) {
                Text("8")
            }
            Button(
                modifier = Modifier.weight(1F).fillMaxHeight(),
                onClick = {  }) {
                Text("9")
            }
            Button(
                modifier = Modifier.weight(1F).fillMaxHeight(),
                onClick = {  }) {
                Text("X")
            }
        }
        Row(
            modifier = Modifier.weight(1F),
        ) {
            Button(
                modifier = Modifier.weight(1F).fillMaxHeight(),
                onClick = {  }) {
                Text("4")
            }
            Button(
                modifier = Modifier.weight(1F).fillMaxHeight(),
                onClick = {  }) {
                Text("5")
            }
            Button(
                modifier = Modifier.weight(1F).fillMaxHeight(),
                onClick = {  }) {
                Text("6")
            }
            Button(
                modifier = Modifier.weight(1F).fillMaxHeight(),
                onClick = {  }) {
                Text("-")
            }
        }
        Row(
            modifier = Modifier.weight(1F),
        ) {
            Button(
                modifier = Modifier.weight(1F).fillMaxHeight(),
                onClick = {  }) {
                Text("1")
            }
            Button(
                modifier = Modifier.weight(1F).fillMaxHeight(),
                onClick = {  }) {
                Text("2")
            }
            Button(
                modifier = Modifier.weight(1F).fillMaxHeight(),
                onClick = {  }) {
                Text("3")
            }
            Button(
                modifier = Modifier.weight(1F).fillMaxHeight(),
                onClick = {  }) {
                Text("+")
            }
        }
        Row(
            modifier = Modifier.weight(1F),
        ) {
            Button(
                modifier = Modifier.weight(2F).fillMaxHeight(),
                onClick = {  }) {
                Text("0")
            }
            Button(
                modifier = Modifier.weight(1F).fillMaxHeight(),
                onClick = {  }) {
                Text(",")
            }
            Button(
                modifier = Modifier.weight(1F).fillMaxHeight(),
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