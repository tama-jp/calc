package club.kodawari.calc

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import calc.Calc

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var calcData: String = ""
    var dispData: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val calcView: TextView = findViewById(R.id.calcView)
        calcView.text = calcData

        calcData = ""
        dispData = ""

//        val data = "log(1 + 5) * sin(10-3 )"

//        val reversePolishNotation = Calc.convert(data)
//        val answer = Calc.answer(data)

        findViewById<Button>(R.id.btnkey1).setOnClickListener(this)
        findViewById<Button>(R.id.btnkey2).setOnClickListener(this)
        findViewById<Button>(R.id.btnkey3).setOnClickListener(this)
        findViewById<Button>(R.id.btnkey4).setOnClickListener(this)
        findViewById<Button>(R.id.btnkey5).setOnClickListener(this)
        findViewById<Button>(R.id.btnkey6).setOnClickListener(this)
        findViewById<Button>(R.id.btnkey7).setOnClickListener(this)
        findViewById<Button>(R.id.btnkey8).setOnClickListener(this)
        findViewById<Button>(R.id.btnkey9).setOnClickListener(this)
        findViewById<Button>(R.id.btnkey0).setOnClickListener(this)
        findViewById<Button>(R.id.btnkey00).setOnClickListener(this)

        findViewById<Button>(R.id.btnkeyplus).setOnClickListener(this)
        findViewById<Button>(R.id.btnkeyminus).setOnClickListener(this)
        findViewById<Button>(R.id.btnkeydivided).setOnClickListener(this)
        findViewById<Button>(R.id.btnkeymultiplied).setOnClickListener(this)
        findViewById<Button>(R.id.btnkeyequal).setOnClickListener(this)

        findViewById<Button>(R.id.btnbracketsforward).setOnClickListener(this)
        findViewById<Button>(R.id.btnbracketsback).setOnClickListener(this)

        findViewById<Button>(R.id.btnbracketsin).setOnClickListener(this)
        findViewById<Button>(R.id.btnbracketcos).setOnClickListener(this)
        findViewById<Button>(R.id.btnbrackettan).setOnClickListener(this)

        findViewById<Button>(R.id.btnbracketsqrt).setOnClickListener(this)
        findViewById<Button>(R.id.btnbracketlog).setOnClickListener(this)
        findViewById<Button>(R.id.btnbracketln).setOnClickListener(this)
        findViewById<Button>(R.id.btnbracketexp).setOnClickListener(this)

        findViewById<Button>(R.id.btnallclear).setOnClickListener(this)
        findViewById<Button>(R.id.btndel).setOnClickListener(this)

//        println(reversePolishNotation);
//        println(answer);
    }

    fun push(data: String) {

        calcData += data

        val calcView: TextView = findViewById(R.id.calcView)
        calcView.text = calcData

    }

    fun del() {
        calcData = calcData.dropLast(1)
        val calcView: TextView = findViewById(R.id.calcView)
        calcView.text = calcData
    }

    fun allclear() {
        calcData = ""
        val calcView: TextView = findViewById(R.id.calcView)
        calcView.text = calcData
    }

    fun calc() {
        val answer = Calc.answer(calcData)
        val calcView: TextView = findViewById(R.id.calcView)
        calcView.text = answer
        calcData = answer
    }


    override fun onClick(v: View?) {
        when ((v as Button).id) {
            R.id.btnkey1 -> {
                Log.v("TAG", "1")
                push("1")
            }
            R.id.btnkey2 -> {
                Log.v("TAG", "2")
                push("2")
            }
            R.id.btnkey3 -> {
                Log.v("TAG", "3")
                push("3")
            }
            R.id.btnkey4 -> {
                Log.v("TAG", "4")
                push("4")

            }
            R.id.btnkey5 -> {
                Log.v("TAG", "5")
                push("5")
            }
            R.id.btnkey6 -> {
                Log.v("TAG", "6")
                push("6")
            }
            R.id.btnkey7 -> {
                Log.v("TAG", "7")
                push("7")
            }
            R.id.btnkey8 -> {
                Log.v("TAG", "8")
                push("8")
            }
            R.id.btnkey9 -> {
                Log.v("TAG", "9")
                push("9")
            }
            R.id.btnkey0 -> {
                Log.v("TAG", "0")
                push("0")
            }
            R.id.btnkey00 -> {
                Log.v("TAG", "00")
                push("00")
            }

            R.id.btnkeyplus -> {
                Log.v("TAG", "+")
                push("+")

            }
            R.id.btnkeyminus -> {
                Log.v("TAG", "-")
                push("-")

            }
            R.id.btnkeydivided -> {
                Log.v("TAG", "/")
                push("/")

            }
            R.id.btnkeymultiplied -> {
                Log.v("TAG", "*")
                push("*")
            }
            R.id.btnkeyequal -> {
                Log.v("TAG", "=")
                calc()
            }

            R.id.btnbracketsforward -> {
                Log.v("TAG", "(")
                push("(")
            }
            R.id.btnbracketsback -> {
                Log.v("TAG", ")")
                push(")")
            }

            R.id.btnbracketsin -> {
                Log.v("TAG", "sin")
                push("sin")

            }
            R.id.btnbracketcos -> {
                Log.v("TAG", "cos")
                push("cos")
            }
            R.id.btnbrackettan -> {
                Log.v("TAG", "tan")
                push("tan")
            }

            R.id.btnbracketsqrt -> {
                Log.v("TAG", "sqrt")
                push("sqrt")

            }
            R.id.btnbracketlog -> {
                Log.v("TAG", "log")
                push("log")

            }
            R.id.btnbracketln -> {
                Log.v("TAG", "ln")
                push("ln")

            }
            R.id.btnbracketexp -> {
                Log.v("TAG", "exp")
                push("exp")
            }

            R.id.btnallclear -> {
                Log.v("TAG", "allclear")
                allclear()
            }

            R.id.btndel -> {
                Log.v("TAG", "del")
                del()
            }
        }
    }
}