package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
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
fun TopButton(
    modifier: Modifier = Modifier,
    text: String,
    bg: Color = Color(4288980132),
    onClick: () -> Unit,
) {

    Button(
        colors = ButtonDefaults.buttonColors(containerColor = bg),
        //shape = RoundedCornerShape(60),
        shape = CircleShape,
        modifier = modifier
            .fillMaxHeight()
            .padding(5.dp),
        onClick = onClick
    ) {
        Text(
            text,
            fontSize = 30.sp,
            color = Color.Black,
        )
    }
}

@Composable
fun RightButton(
    modifier: Modifier = Modifier,
    text: String,
    bg: Color = Color(4294876685),
    textColor: Color = Color.White,
    onClick: () -> Unit,
) {

    Button(
        colors = ButtonDefaults.buttonColors(containerColor = bg),
        //shape = RoundedCornerShape(60),
        shape = CircleShape,
        modifier = modifier
            .fillMaxHeight()
            .padding(5.dp),
        onClick = onClick
    ) {
        Text(
            text,
            fontSize = 30.sp,
            color = textColor
        )
    }
}

@Composable
fun CenterButton(
    modifier: Modifier = Modifier,
    text: String,
    bg: Color = Color(4281479730),
    onClick: () -> Unit,
) {

    Button(
        colors = ButtonDefaults.buttonColors(containerColor = bg),
        //shape = RoundedCornerShape(60),
        shape = CircleShape,
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

fun CheckDecimal(num: Double): Boolean {
    val intpart = num.toInt()
    val decpart = num - intpart
    return decpart != 0.0
}

@Composable
fun CalculatorApp(modifier: Modifier = Modifier) {
    var oldNum by remember { mutableDoubleStateOf(0.0) }
    var operator by remember { mutableStateOf("") }
    var numberText by remember { mutableStateOf("0") }
    var reset by remember { mutableStateOf(true) }
    var hasDecimal by remember { mutableStateOf(false) }

    fun numberClicked(value: String) {
        val doubleNumber = numberText.toDouble()
        if((doubleNumber == 0.0 && !hasDecimal) || reset) {
            oldNum = doubleNumber
            numberText = value
            reset = false
        }
        else{
            numberText += value
            hasDecimal = false
        }
    }

    fun calculate() {
        try {
            var result: Double = 0.0;
            when(operator) {
                "+" -> result = oldNum + numberText.toDouble()
                "-" -> result = oldNum - numberText.toDouble()
                "*" -> result = oldNum * numberText.toDouble()
                "/" -> result = oldNum / numberText.toDouble()
                "%" -> result = numberText.toDouble() / 100
            }
            val hasDec = CheckDecimal(result)
            numberText = if(hasDec) result.toString() else result.toInt().toString()
            reset = true
            operator = ""
        } catch (e: ArithmeticException)  {
            println(e)
        }
    }

    fun operatorClicked(op: String) {
        /*if(oldNum != 0) {
            calculate()
        }*/
        operator = op
        reset = true
    }

    Column(
        modifier = modifier.background(Color.Black),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3F),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Bottom,
        ) {
            Text(
                numberText,
                color = Color.White,
                fontWeight = FontWeight.ExtraLight,
                softWrap = false,
                fontSize = if(numberText.length > 6) (100 - (numberText.length * 4)).sp else 100.sp
            )
        }
        Row(
            modifier = Modifier.weight(1F),
        ) {
            TopButton(
                modifier = Modifier.weight(1F),
                text = if(oldNum == 0.0 && numberText.toDouble() == 0.0) "AC" else "C",
                onClick = {
                    operator = ""
                    reset = true
                    oldNum = 0.0
                    numberText = "0"
                },
            )
            TopButton(
                modifier = Modifier.weight(1F),
                text = "+/-",
                onClick = {
                    numberText = (numberText.toDouble() * -1).toString()
                },
            )
            TopButton(
                modifier = Modifier.weight(1F),
                text = "%",
                onClick = { operator = "%"; calculate() },
            )
            RightButton(
                modifier = Modifier.weight(1F),
                text = "÷",
                bg = if(operator == "/") Color.White else Color(4294876685),
                textColor = if(operator == "/") Color(4294876685) else Color.White,
                onClick = { operatorClicked("/") },
            )
        }
        Row(
            modifier = Modifier.weight(1F),
        ) {

            CenterButton(
                modifier = Modifier.weight(1F),
                text = "7",
                onClick = { numberClicked("7") },

            )
            CenterButton(
                modifier = Modifier.weight(1F),
                text = "8",
                onClick = { numberClicked("8") },
            )
            CenterButton(
                modifier = Modifier.weight(1F),
                text = "9",
                onClick = { numberClicked("9") },
            )
            RightButton(
                modifier = Modifier.weight(1F),
                text = "×",
                bg = if(operator == "*") Color.White else Color(4294876685),
                textColor = if(operator == "*") Color(4294876685) else Color.White,
                onClick = { operatorClicked("*") },
            )
        }
        Row(
            modifier = Modifier.weight(1F),
        ) {
            CenterButton(
                modifier = Modifier.weight(1F),
                text = "4",
                onClick = { numberClicked("4") },
            )
            CenterButton(
                modifier = Modifier.weight(1F),
                text = "5",
                onClick = { numberClicked("5") },
            )
            CenterButton(
                modifier = Modifier.weight(1F),
                text = "6",
                onClick = { numberClicked("6") },
            )
            RightButton(
                modifier = Modifier.weight(1F),
                text = "-",
                bg = if(operator == "-") Color.White else Color(4294876685),
                textColor = if(operator == "-") Color(4294876685) else Color.White,
                onClick = { operatorClicked("-") },
            )
        }
        Row(
            modifier = Modifier.weight(1F),
        ) {
            CenterButton(
                modifier = Modifier.weight(1F),
                text = "1",
                onClick = { numberClicked("1") },
            )
            CenterButton(
                modifier = Modifier.weight(1F),
                text = "2",
                onClick = { numberClicked("2") },
            )
            CenterButton(
                modifier = Modifier.weight(1F),
                text = "3",
                onClick = { numberClicked("3") },
            )
            RightButton(
                modifier = Modifier.weight(1F),
                text = "+",
                bg = if(operator == "+") Color.White else Color(4294876685),
                textColor = if(operator == "+") Color(4294876685) else Color.White,
                onClick = { operatorClicked("+") },
            )
        }
        Row(
            modifier = Modifier.weight(1F),
        ) {
            CenterButton(
                modifier = Modifier.weight(2F),
                text = "0",
                onClick = { numberClicked("0") },
            )
            CenterButton(
                modifier = Modifier.weight(1F),
                text = ".",
                onClick = { numberText += "."; hasDecimal = true },
            )
            RightButton(
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