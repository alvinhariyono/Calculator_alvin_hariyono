package com.alvinisbproject.calculator_alvin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
//import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception
import kotlin.math.*





class MainActivity : AppCompatActivity() {






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //supportActionBar?.hide()

        /*Number Buttons*/

        b1.setOnClickListener {
            evaluateExpression("1", clear = true)
        }

        b2.setOnClickListener {
            evaluateExpression("2", clear = true)
        }

        b3.setOnClickListener {
            evaluateExpression("3", clear = true)
        }
        b4.setOnClickListener {
            evaluateExpression("4", clear = true)
        }

        b5.setOnClickListener {
            evaluateExpression("5", clear = true)
        }

        b6.setOnClickListener {
            evaluateExpression("6", clear = true)
        }

        b7.setOnClickListener {
            evaluateExpression("7", clear = true)
        }

        b8.setOnClickListener {
            evaluateExpression("8", clear = true)
        }

        b9.setOnClickListener {
            evaluateExpression("9", clear = true)
        }

        b0.setOnClickListener {
            evaluateExpression("0", clear = true)
        }

        /*Operators*/

        bplus.setOnClickListener {
            if ((tvwork.text.toString() != "") && (tvwork.text.last().toString() in arrayOf(".", "/", "+", "-", "*"))){
                tvwork.text = tvwork.text.toString().dropLast(1)
                evaluateExpression("+", clear = true)
            }else {
                evaluateExpression("+", clear = true)
            }

            //evaluateExpression("+", clear = true)
        }

        bminus.setOnClickListener {
            if ((tvwork.text.toString() != "") && (tvwork.text.last().toString() in arrayOf(".", "/", "+", "-", "*"))){
                tvwork.text = tvwork.text.toString().dropLast(1)
                evaluateExpression("-", clear = true)
            }else {
                evaluateExpression("-", clear = true)
            }
            //evaluateExpression("-", clear = true)
        }

        bmul.setOnClickListener {
            if ((tvwork.text.toString() != "") && (tvwork.text.last().toString() in arrayOf(".", "/", "+", "-", "*"))){
                tvwork.text = tvwork.text.toString().dropLast(1)
                evaluateExpression("*", clear = true)
            }else {
                evaluateExpression("*", clear = true)
            }
            //evaluateExpression("*", clear = true)
        }

        bdiv.setOnClickListener {
            if ((tvwork.text.toString() != "") && (tvwork.text.last().toString() in arrayOf(".", "/", "+", "-", "*"))){
                tvwork.text = tvwork.text.toString().dropLast(1)
                evaluateExpression("/", clear = true)
            }else {
                evaluateExpression("/", clear = true)
            }
            //evaluateExpression("/", clear = true)
        }

        bDot.setOnClickListener {
            if ((tvwork.text.toString() != "") && (tvwork.text.last().toString() !in arrayOf(".", "/", "+", "-", "*"))){
                var add: Boolean = true
                var simpenandot: String =tvwork.text.toString()
                var arraysimpenandot: List<String> = simpenandot.split("/", "+", "-", "*")
            for(i in arraysimpenandot){
                add = "." !in i
            }
                if(add){
                    evaluateExpression(".", clear = true)

                }
            }

            //evaluateExpression(".", clear = true)
        }

        bac.setOnClickListener {
            tvwork.text = ""
            tvresult.text = ""
        }

        bc.setOnClickListener {
            tvresult.text = ""
        }



        bequal.setOnClickListener {
           /* if ((tvwork.text.last().toString() in arrayOf(".", "/", "+", "-", "*"))){
                tvwork.text = tvwork.text.toString().dropLast(1)
            }

            val text = tvwork.text.toString()
            val expression = ExpressionBuilder(text).build()

            val result = expression.evaluate()
            val longResult = result.toLong()
            if (result == longResult.toDouble()) {
                tvresult.text = longResult.toString()
            } else {
                tvresult.text = result.toString()
            }*/

            equals()
        }

        bback.setOnClickListener {
            val text = tvwork.text.toString()
            if(text.isNotEmpty()) {
                tvwork.text = text.dropLast(1)
            }

            tvresult.text = ""

             /*
            if(tvwork.text.length>1 && tvwork.text.toString()!="") {
                tvwork.text = tvwork.text.substring(0, tvwork.text.length - 1)
            }else if(tvwork.text.length==1) {
                tvwork.text=""
            }
            tvresult.text = ""

             */
        }

        bpower2.setOnClickListener {
            var string: String =equals()
            tvresult.text = string.toDouble().pow(2).toString()

        }

        bsqrt.setOnClickListener {
            var string: String =equals()
            tvresult.text = sqrt(string.toDouble()).toString()
        }

        bfloor.setOnClickListener {
            var string: String =equals()
            tvresult.text = floor(string.toDouble()).toInt().toString()
        }
        bround.setOnClickListener {
            var string: String =equals()
            tvresult.text = "%.1f".format(string.toDouble())
        }
        bceiling.setOnClickListener {
            var string: String =equals()
            tvresult.text = ceil(string.toDouble()).toInt().toString()
        }










    }

    /*Function to calculate the expressions using expression builder library*/

    fun evaluateExpression(string: String, clear: Boolean) {
        if(clear) {
            tvresult.text = ""
            tvwork.append(string)
        } else {
            tvwork.append(tvresult.text)
            tvwork.append(string)
            tvresult.text = ""
        }


    }
    fun equals(): String {
        var text = tvwork.text.toString()
        if ((tvwork.text.toString() != "") && (tvwork.text.last().toString() in arrayOf(".", "/", "+", "-", "*"))){
            tvwork.text = tvwork.text.toString().dropLast(1)
        }else if(tvwork.text.toString()==""){
            text = "0"
        }
        val expression = ExpressionBuilder(text).build()

        val result = expression.evaluate()
        val longResult = result.toLong()
        if (result == longResult.toDouble()) {
            tvresult.text = longResult.toString()
        } else {
            tvresult.text = result.toString()
        }
        return tvresult.text.toString()
    }

 }

































