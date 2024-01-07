package net.asabon.calculator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import net.asabon.calculator.ui.theme.CalculatorTheme

class Calculator {
    private var mMainDisplay: String = ""
    private var mHistoryDisplay: String = ""
    private var mCurrentMode: String = ""

    private var mWorkNumber: Int? = null
    private var mTempNumber: Int? = null

    fun setMainDisplay(message: String) {
        mMainDisplay = message
    }
    /**
     * @brier メインディスプレイの文字列を取得する
     */
    fun getMainDisplay() : String {
        return mMainDisplay
    }

    fun setHistoryDisplay(message: String) {
        mHistoryDisplay = message
    }

    /**
     * @brier テストコードから呼び出す
     */
    fun getHistoryDisplay() : String {
        return mHistoryDisplay
    }

    fun operation(key: Any) {
        when (key) {
            is Int -> mWorkNumber = updateNumber(mWorkNumber, key)
            "+", "-", "*", "/", "=" -> calc(key.toString())
            "C" -> clear()
            else -> println("error")
        }
        mMainDisplay = getDisplayMessage(mWorkNumber)
    }

    private fun calc(key: String) {
        if (mTempNumber == null) {
            /* 初期状態では mTempNumber は null */
            /* 計算できるように null を 0 に置き換える */
            mTempNumber = 0
        }
        if (mWorkNumber == null) {
            /* "+" などの演算記号が連続で押された場合は何もしない */
        } else {
            /* 計算を行う */
            mTempNumber = calculate(mTempNumber!!, mCurrentMode, mWorkNumber!!)
            mHistoryDisplay = mHistoryDisplay + mWorkNumber.toString() + " " + key + " "
            mCurrentMode = key
            if (key == "=") {
                mMainDisplay = getDisplayMessage(mTempNumber)
                mWorkNumber = mTempNumber
            } else {
                mMainDisplay = getDisplayMessage(null)
                mWorkNumber = null
            }
        }
    }
    private fun clear() {
        mTempNumber = null
        mWorkNumber = null
    }

    private fun calculate(before: Int, mode: String, after: Int): Int? {
        if (mode == "/") {
            if (after == 0) {
                /* 0 割りは null を返す */
                return null
            }
        }
        return when(mode) {
            "+" -> before + after
            "-" -> before - after
            "*" -> before * after
            "/" -> before / after
            else -> after
        }
    }

    private fun getDisplayMessage(number: Int?) : String {
        return number?.toString() ?: ""
    }

    private fun updateNumber(baseNumber: Int?, newNumber: Int) : Int {
        if (baseNumber == null) {
            return newNumber
        }
        return (baseNumber * 10) + newNumber
    }

    @Composable
    fun Layout() {
        var historyDisplayMessage by remember { mutableStateOf("") }
        var mainDisplayMessage by remember { mutableStateOf("") }
        Column{
            Text(
                text = historyDisplayMessage,
                textAlign = TextAlign.Right,
                fontSize = 20.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.End)
            )
            Text(
                text = mainDisplayMessage,
                textAlign = TextAlign.Right,
                fontSize = 40.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.End)
            )
            Row{
                Button(
                    onClick = {
                        operation(7)
                        mainDisplayMessage = getMainDisplay()
                    }
                ) {
                    Text("7")
                }
                Button(
                    onClick = {
                        operation(8)
                        mainDisplayMessage = getMainDisplay()
                    }
                ) {
                    Text("8")
                }
                Button(
                    onClick = {
                        operation(9)
                        mainDisplayMessage = getMainDisplay()
                    }
                ) {
                    Text("9")
                }
                Button(
                    onClick = {
                        operation("+")
                        mainDisplayMessage = getMainDisplay()
                        historyDisplayMessage = getHistoryDisplay()
                    }
                ) {
                    Text("+")
                }
            }
            Row{
                Button(
                    onClick = {
                        operation(4)
                        mainDisplayMessage = getMainDisplay()
                    }
                ) {
                    Text("4")
                }
                Button(
                    onClick = {
                        operation(5)
                        mainDisplayMessage = getMainDisplay()
                    }
                ) {
                    Text("5")
                }
                Button(
                    onClick = {
                        operation(6)
                        mainDisplayMessage = getMainDisplay()
                    }
                ) {
                    Text("6")
                }
                Button(
                    onClick = {
                        operation("-")
                        mainDisplayMessage = getMainDisplay()
                        historyDisplayMessage = getHistoryDisplay()
                    }
                ) {
                    Text("-")
                }
            }
            Row{
                Button(
                    onClick = {
                        operation(1)
                        mainDisplayMessage = getMainDisplay()
                    }
                ) {
                    Text("1")
                }
                Button(
                    onClick = {
                        operation(2)
                        mainDisplayMessage = getMainDisplay()
                    }
                ) {
                    Text("2")
                }
                Button(
                    onClick = {
                        operation(3)
                        mainDisplayMessage = getMainDisplay()
                    }
                ) {
                    Text("3")
                }
                Button(
                    onClick = {
                        operation("*")
                        mainDisplayMessage = getMainDisplay()
                        historyDisplayMessage = getHistoryDisplay()
                    }
                ) {
                    Text("*")
                }
            }
            Row{
                Button(
                    onClick = {
                        operation(0)
                        mainDisplayMessage = getMainDisplay()
                    }
                ) {
                    Text("0")
                }
                Button(
                    onClick = {
                        operation(".")
                        mainDisplayMessage = getMainDisplay()
                    }
                ) {
                    Text(".")
                }
                Button(
                    onClick = {
                        operation("=")
                        mainDisplayMessage = getMainDisplay()
                        historyDisplayMessage = getHistoryDisplay()
                    }
                ) {
                    Text("=")
                }
                Button(
                    onClick = {
                        operation("/")
                        mainDisplayMessage = getMainDisplay()
                        historyDisplayMessage = getHistoryDisplay()
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
        val calculator = Calculator()
        CalculatorTheme {
            //Calculator()
            calculator.Layout()
        }
    }
}

