package net.asabon.calculator

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import net.asabon.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Calculator()
                }
            }
        }
    }
}

fun getDisplayNumber(number: Int?) : String {
    return number?.toString() ?: ""
}

fun addNumber(base: Int?, add: Int) : Int? {
    if (base == null) {
        return add
    }
    return (base * 10) + add
}

fun calculate(before: Int?, mode: String, after: Int?): Int? {
    val beforeTemp = before ?: 0
    if (after == null) {
        return null
    }
    return when(mode) {
        "+" -> beforeTemp + after
        "-" -> beforeTemp - after
        "*" -> beforeTemp * after
        "/" -> beforeTemp / after
        else -> after
    }
}

@Composable
fun Calculator(
    modifier: Modifier = Modifier
) {
    var history : String by remember { mutableStateOf("")}
    var displayNumber : String by remember { mutableStateOf("")}
    var tempNumber : Int? by remember { mutableStateOf(0)}
    var currentNumber : Int? by remember { mutableStateOf(0)}
    var currentMode by remember { mutableStateOf("")}

    Column {
        Text(
            text = history,
            textAlign = TextAlign.Right,
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.End)
        )
        Text(
            text = displayNumber,
            textAlign = TextAlign.Right,
            fontSize = 40.sp,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.End)
        )
        Row {
            Button(
                onClick = {
                    if (currentMode == "") {
                        history = ""
                    }
                    currentNumber = addNumber(currentNumber, 7)
                    displayNumber = getDisplayNumber(currentNumber)
                }
            ) {
                Text("7")
            }
            Button(
                onClick = {
                    if (currentMode == "") {
                        history = ""
                    }
                    currentNumber = addNumber(currentNumber, 8)
                    displayNumber = getDisplayNumber(currentNumber)
                }
            ) {
                Text("8")
            }
            Button(
                onClick = {
                    if (currentMode == "") {
                        history = ""
                    }
                    currentNumber = addNumber(currentNumber, 9)
                    displayNumber = getDisplayNumber(currentNumber)
                }
            ) {
                Text("9")
            }
            Button(
                onClick = {
                    tempNumber = calculate(tempNumber, currentMode, currentNumber)
                    if (tempNumber != null) {
                        history = "$history$currentNumber + "
                        currentMode = "+"
                        currentNumber = null
                        displayNumber = getDisplayNumber(null)
                    }
                }
            ) {
                Text("+")
            }
        }
        Row {
            Button(
                onClick = {
                    if (currentMode == "") {
                        history = ""
                    }
                    currentNumber = addNumber(currentNumber, 4)
                    displayNumber = getDisplayNumber(currentNumber)
                }
            ) {
                Text("4")
            }
            Button(
                onClick = {
                    if (currentMode == "") {
                        history = ""
                    }
                    currentNumber = addNumber(currentNumber, 5)
                    displayNumber = getDisplayNumber(currentNumber)
                }
            ) {
                Text("5")
            }
            Button(
                onClick = {
                    if (currentMode == "") {
                        history = ""
                    }
                    currentNumber = addNumber(currentNumber, 6)
                    displayNumber = getDisplayNumber(currentNumber)
                }
            ) {
                Text("6")
            }
            Button(
                onClick = {
                    tempNumber = calculate(tempNumber, currentMode, currentNumber)
                    history = "$history$currentNumber - "
                    currentMode = "-"
                    currentNumber = null
                    displayNumber = getDisplayNumber(null)
                }
            ) {
                Text("-")
            }
        }
        Row {
            Button(
                onClick = {
                    if (currentMode == "") {
                        history = ""
                    }
                    currentNumber = addNumber(currentNumber, 1)
                    displayNumber = getDisplayNumber(currentNumber)
                }
            ) {
                Text("1")
            }
            Button(
                onClick = {
                    if (currentMode == "") {
                        history = ""
                    }
                    currentNumber = addNumber(currentNumber, 2)
                    displayNumber = getDisplayNumber(currentNumber)
                }
            ) {
                Text("2")
            }
            Button(
                onClick = {
                    if (currentMode == "") {
                        history = ""
                    }
                    currentNumber = addNumber(currentNumber, 3)
                    displayNumber = getDisplayNumber(currentNumber)
                }
            ) {
                Text("3")
            }
            Button(
                onClick = {
                    tempNumber = calculate(tempNumber, currentMode, currentNumber)
                    history = "$history$currentNumber * "
                    currentMode = "*"
                    currentNumber = null
                    displayNumber = getDisplayNumber(null)
                }
            ) {
                Text("*")
            }
        }
        Row {
            Button(
                onClick = {
                    if (currentMode == "") {
                        history = ""
                    }
                    currentNumber = addNumber(currentNumber, 0)
                    displayNumber = getDisplayNumber(currentNumber)
                }
            ) {
                Text("0")
            }
            Button(
                onClick = {
                    tempNumber = calculate(tempNumber, currentMode, currentNumber)
                    history = "$history$currentNumber = "
                    currentMode = ""
                    currentNumber = null
                    displayNumber = getDisplayNumber(tempNumber)
                }
            ) {
                Text("=")
            }
            Button(
                onClick = {
                    if (currentMode == "") {
                        history = ""
                    }
                    tempNumber = 0
                    currentMode = ""
                    currentNumber = null
                    displayNumber = getDisplayNumber(null)
                }
            ) {
                Text("C")
            }
            Button(
                onClick = {
                    tempNumber = calculate(tempNumber, currentMode, currentNumber)
                    history = "$history$currentNumber / "
                    currentMode = "/"
                    currentNumber = null
                    displayNumber = getDisplayNumber(null)
                }
            ) {
                Text("/")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    CalculatorTheme {
        Calculator()
    }
}
