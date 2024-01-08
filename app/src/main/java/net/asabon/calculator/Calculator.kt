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
    private var mainDisplay : Display = Display()
    //private var subDisplay : Display = Display()
    private var mOperation: String = ""
    private var mWorkNumber: Number = Number()
    private val nList = ArrayList<Double>()
    private val oList = ArrayList<String>()

    /**
     * メインディスプレイに強制的に文字列をセットする。
     *
     * デバッグやテスト用途で使用する。
     */
    fun setMainDisplay(message: String) {
        mainDisplay.setMessage(message)
    }

    /**
     * メインディスプレイの文字列を取得する。
     *
     * アプリが「表示部」に出力する文字列を取得するのに使用する。
     */
    fun getMainDisplay() : String {
        return mainDisplay.getMessage()
    }

    /**
     * 履歴ディスプレイに強制的に文字列をセットする。
     *
     * デバッグやテスト用途で使用する。
     */
    /*
    fun setSubDisplay(message: String) {
        subDisplay.setMessage(message)
    }
     */

    /**
     * 履歴ディスプレイの文字列を取得する。
     *
     * アプリが「表示部」に出力する文字列を取得するのに使用する。
     */
    /*
    fun getSubDisplay(): String {
        return subDisplay.getMessage()
    }
     */

    /**
     * キーを一つ押したときの動作
     *
     * @return メインディスプレイに出力したい文字列
     */
    fun pushKey(key: String) {
        when (key) {
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "." -> {
                if (mOperation == "=") {
                    mOperation = ""
                    //subDisplay.setMessage("")
                }
                mainDisplay.setMessage(mWorkNumber.putKey(key))
            }
            "+", "-", "*", "/", "=" -> {
                if (mWorkNumber.getNumber() != "") {
                    nList.add(mWorkNumber.getNumber().toDouble())
                    oList.add(mOperation)
                    mWorkNumber.clear()
                    mOperation = key
                    printList()
                    if (key == "=") {
                        /* 計算する */
                        mainDisplay.setMessage(calculate().toString())
                        //subDisplay.setMessage(getHistory())
                    } else {
                        /* メインディスプレイをクリアする */
                        mainDisplay.setMessage("")
                        //subDisplay.setMessage(getHistory())
                    }
                } else {
                    mWorkNumber.setNumber(mainDisplay.getMessage())
                    mainDisplay.setMessage("")
                    //subDisplay.setMessage(getHistory())
                }
            }
            "C" -> {
                mainDisplay.clear()
                //subDisplay.clear()
                mWorkNumber.clear()
                mOperation = ""
                oList.clear()
                nList.clear()
            }
        }
    }

    /**
     * サブディスプレイに表示する「履歴」を生成する
     */
    /*
    private fun getHistory(): String {
        var history: String = ""
        history = nList[0].toString()
        for (i in 1 until nList.size) {
            history += " " + oList[i] + " " + nList[i].toString()
        }
        history += " $mOperation "
        return history
    }
     */

    /**
     * リスト (nList, oList) をダンプする（デバッグ用途）
     */
    private fun printList() {
        println("===")
        println("nList.size = " + nList.size)
        for (i in 0 until nList.size) {
            println("oList[" + i + "] = " + oList[i])
            println("nList[" + i + "] = " + nList[i].toString())
        }
    }

    private fun calculate() : Double {
        var temp : Double = nList[0]
        for (i in 1 until nList.size) {
            when (oList[i]) {
                "+" -> temp += nList[i]
                "-" -> temp -= nList[i]
                "*" -> temp /= nList[i]
                "/" -> temp /= nList[i]
                else -> println("error")
            }
        }
        return temp
    }

    @Composable
    fun Layout() {
        //var subDisplayMessage by remember { mutableStateOf("") }
        var mainDisplayMessage by remember { mutableStateOf("") }
        Column{
            /*
            Text(
                text = subDisplayMessage,
                textAlign = TextAlign.Right,
                fontSize = 20.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.End)
            )
             */
            Text(
                text = mainDisplayMessage,
                textAlign = TextAlign.Right,
                fontSize = 40.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.End)
            )
            Row(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Button(
                    onClick = {
                        pushKey("C")
                        mainDisplayMessage = getMainDisplay()
                        //subDisplayMessage = getSubDisplay()
                    }
                ) {
                    Text("C")
                }
            }
            Row(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Button(
                    onClick = {
                        pushKey("7")
                        mainDisplayMessage = getMainDisplay()
                        //subDisplayMessage = getSubDisplay()
                    }
                ) {
                    Text("7")
                }
                Button(
                    onClick = {
                        pushKey("8")
                        mainDisplayMessage = getMainDisplay()
                        //subDisplayMessage = getSubDisplay()
                    }
                ) {
                    Text("8")
                }
                Button(
                    onClick = {
                        pushKey("9")
                        mainDisplayMessage = getMainDisplay()
                        //subDisplayMessage = getSubDisplay()
                    }
                ) {
                    Text("9")
                }
                Button(
                    onClick = {
                        pushKey("+")
                        mainDisplayMessage = getMainDisplay()
                        //subDisplayMessage = getSubDisplay()
                    }
                ) {
                    Text("+")
                }
            }
            Row(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
            {
                Button(
                    onClick = {
                        pushKey("4")
                        mainDisplayMessage = getMainDisplay()
                        //subDisplayMessage = getSubDisplay()
                    }
                ) {
                    Text("4")
                }
                Button(
                    onClick = {
                        pushKey("5")
                        mainDisplayMessage = getMainDisplay()
                        //subDisplayMessage = getSubDisplay()
                    }
                ) {
                    Text("5")
                }
                Button(
                    onClick = {
                        pushKey("6")
                        mainDisplayMessage = getMainDisplay()
                        //subDisplayMessage = getSubDisplay()
                    }
                ) {
                    Text("6")
                }
                Button(
                    onClick = {
                        pushKey("-")
                        mainDisplayMessage = getMainDisplay()
                        //subDisplayMessage = getSubDisplay()
                    }
                ) {
                    Text("-")
                }
            }
            Row(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Button(
                    onClick = {
                        pushKey("1")
                        mainDisplayMessage = getMainDisplay()
                        //subDisplayMessage = getSubDisplay()
                    }
                ) {
                    Text("1")
                }
                Button(
                    onClick = {
                        pushKey("2")
                        mainDisplayMessage = getMainDisplay()
                        //subDisplayMessage = getSubDisplay()
                    }
                ) {
                    Text("2")
                }
                Button(
                    onClick = {
                        pushKey("3")
                        mainDisplayMessage = getMainDisplay()
                        //subDisplayMessage = getSubDisplay()
                    }
                ) {
                    Text("3")
                }
                Button(
                    onClick = {
                        pushKey("*")
                        mainDisplayMessage = getMainDisplay()
                        //subDisplayMessage = getSubDisplay()
                    }
                ) {
                    Text("*")
                }
            }
            Row(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Button(
                    onClick = {
                        pushKey("0")
                        mainDisplayMessage = getMainDisplay()
                        //subDisplayMessage = getSubDisplay()
                    }
                ) {
                    Text("0")
                }
                Button(
                    onClick = {
                        pushKey(".")
                        mainDisplayMessage = getMainDisplay()
                        //subDisplayMessage = getSubDisplay()
                    }
                ) {
                    Text(".")
                }
                Button(
                    onClick = {
                        pushKey("=")
                        mainDisplayMessage = getMainDisplay()
                        //subDisplayMessage = getSubDisplay()
                    }
                ) {
                    Text("=")
                }
                Button(
                    onClick = {
                        pushKey("/")
                        mainDisplayMessage = getMainDisplay()
                        //subDisplayMessage = getSubDisplay()
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
