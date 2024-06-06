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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
fun MyButton(
    modifier: Modifier = Modifier,
    text: String,
    bg: Color = Color.Black,
    onClick: () -> Unit,
) {

    Button(
        colors = ButtonDefaults.buttonColors(containerColor = bg),
        shape = RoundedCornerShape(50),
        modifier = modifier
            .fillMaxHeight()
            .padding(5.dp),
        onClick = onClick
    ) {
        Text(
            text,
            fontSize = 30.sp,
        )
    }
}

@Composable
fun CalculatorApp(modifier: Modifier = Modifier) {
    var oldNum by remember { mutableStateOf(0) }
    val num2 by remember { mutableStateOf(0) }
    var operator by remember { mutableStateOf("") }
    val hasResult by remember { mutableStateOf(false) }
    var numberText by remember { mutableStateOf("0") }
    var reset by remember { mutableStateOf(true) }

    fun numberClicked(value: String) {
        val intNumber = numberText.toInt()
        if(intNumber == 0 || reset) {
            oldNum = intNumber
            numberText = value
            reset = false
        }
        else
            numberText += value
    }

    fun calculate() {
        when(operator) {
            "+" -> {
                numberText = (oldNum + numberText.toInt()).toString()
                reset = true
            }
            "-" -> {
                numberText = (oldNum - numberText.toInt()).toString()
                reset = true

            }
            "*" -> {
                numberText = (oldNum * numberText.toInt()).toString()
                reset = true
            }
            "/" -> {
                numberText = (oldNum / numberText.toInt()).toString()
                reset = true
            }
        }
        operator = ""
    }

    fun operatorClicked(op: String) {
        if(oldNum != 0) {
            calculate()
        }
        operator = op
        reset = true
    }

    Column(
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1F),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Bottom,
        ) {
            Text(
                numberText.toString(),
                fontSize = 100.sp,
            )
        }
        Row(
            modifier = Modifier.weight(1F),
        ) {
            MyButton(
                modifier = Modifier.weight(1F),
                text = "C",
                onClick = {
                    operator = ""
                    reset = true
                    oldNum = 0
                    numberText = "0"
                },
            )
            MyButton(
                modifier = Modifier.weight(1F),
                text = "+/-",
                onClick = { operator = "+/-" },
            )
            MyButton(
                modifier = Modifier.weight(1F),
                text = "%",
                onClick = { operator = "%" },
            )
            MyButton(
                modifier = Modifier.weight(1F),
                text = "/",
                bg = if(operator == "/") Color.DarkGray else Color.Black,
                onClick = { operatorClicked("/") },
            )
        }
        Row(
            modifier = Modifier.weight(1F),
        ) {

            MyButton(
                modifier = Modifier.weight(1F),
                text = "7",
                onClick = { numberClicked("7") },

            )
            MyButton(
                modifier = Modifier.weight(1F),
                text = "8",
                onClick = { numberClicked("8") },
            )
            MyButton(
                modifier = Modifier.weight(1F),
                text = "9",
                onClick = { numberClicked("9") },
            )
            MyButton(
                modifier = Modifier.weight(1F),
                text = "X",
                bg = if(operator == "*") Color.DarkGray else Color.Black,
                onClick = { operatorClicked("*") },
            )
        }
        Row(
            modifier = Modifier.weight(1F),
        ) {
            MyButton(
                modifier = Modifier.weight(1F),
                text = "4",
                onClick = { numberClicked("4") },
            )
            MyButton(
                modifier = Modifier.weight(1F),
                text = "5",
                onClick = { numberClicked("5") },
            )
            MyButton(
                modifier = Modifier.weight(1F),
                text = "6",
                onClick = { numberClicked("6") },
            )
            MyButton(
                modifier = Modifier.weight(1F),
                text = "-",
                bg = if(operator == "-") Color.DarkGray else Color.Black,
                onClick = { operatorClicked("-") },
            )
        }
        Row(
            modifier = Modifier.weight(1F),
        ) {
            MyButton(
                modifier = Modifier.weight(1F),
                text = "1",
                onClick = { numberClicked("1") },
            )
            MyButton(
                modifier = Modifier.weight(1F),
                text = "2",
                onClick = { numberClicked("2") },
            )
            MyButton(
                modifier = Modifier.weight(1F),
                text = "3",
                onClick = { numberClicked("3") },
            )
            MyButton(
                modifier = Modifier.weight(1F),
                text = "+",
                bg = if(operator == "+") Color.DarkGray else Color.Black,
                onClick = { operatorClicked("+") },
            )
        }
        Row(
            modifier = Modifier.weight(1F),
        ) {
            MyButton(
                modifier = Modifier.weight(2F),
                text = "0",
                onClick = { numberClicked("0") },
            )
            MyButton(
                modifier = Modifier.weight(1F),
                text = ",",
                onClick = { operator = "," },
            )
            MyButton(
                modifier = Modifier.weight(1F),
                text = "=",
                onClick = { calculate() },
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