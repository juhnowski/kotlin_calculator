package com.juhnowski.ilya.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_calculator.*

class Calculator : AppCompatActivity() {

    val TAG = "Calculator"

    private val displayOperation by lazy(LazyThreadSafetyMode.NONE) {findViewById<TextView>(R.id.operation)}

    private var arg1: Double? = null
    private var arg2: Double = 0.0
    private var result: Double? = null
    private var op = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val editText: EditText = findViewById(R.id.editText)
        val textView: TextView = findViewById(R.id.textView)
        val button_0: Button = findViewById(R.id.button_0)
        val button_1: Button = findViewById(R.id.button_1)
        val button_2: Button = findViewById(R.id.button_2)
        val button_3: Button = findViewById(R.id.button_3)
        val button_4: Button = findViewById(R.id.button_4)
        val button_5: Button = findViewById(R.id.button_5)
        val button_6: Button = findViewById(R.id.button_6)
        val button_7: Button = findViewById(R.id.button_7)
        val button_8: Button = findViewById(R.id.button_8)
        val button_9: Button = findViewById(R.id.button_9)
        val button_div: Button = findViewById(R.id.button_div)
        val button_mul: Button = findViewById(R.id.button_mul)
        val button_eq: Button = findViewById(R.id.button_eq)
        val button_minus: Button = findViewById(R.id.button_minus)
        val button_plus: Button = findViewById(R.id.button_plus)
        val button_dot: Button = findViewById(R.id.button_dot)
        val operation: TextView = findViewById(R.id.operation)

        val listener = View.OnClickListener { v ->
            val b = v as Button
            editText.append(b.text)
        }

        button_0.setOnClickListener(listener)
        button_1.setOnClickListener(listener)
        button_2.setOnClickListener(listener)
        button_3.setOnClickListener(listener)
        button_4.setOnClickListener(listener)
        button_5.setOnClickListener(listener)
        button_6.setOnClickListener(listener)
        button_7.setOnClickListener(listener)
        button_8.setOnClickListener(listener)
        button_9.setOnClickListener(listener)
        button_dot.setOnClickListener(listener)

        val opListener = View.OnClickListener{ v ->
            val op = (v as Button).text.toString()
            val value = editText.text.toString()
            performOperation(value, op)
        }

        button_div.setOnClickListener (opListener)
        button_eq.setOnClickListener (opListener)
        button_minus.setOnClickListener (opListener)
        button_plus.setOnClickListener (opListener)
        button_mul.setOnClickListener (opListener)
    }

    private fun performOperation(value: String, oper: String){

            if(oper == "="){
                Log.d(TAG, "oper is $oper for op=$op")
                arg2 =  value.toDouble()
                Log.d(TAG, "arg1 is $arg1 and arg2 is $arg2")
                when(op) {
                    "/" -> if (arg2 == 0.0) {
                        result = Double.NaN
                    } else {
                        result = arg1!! / arg2!!
                    }
                    "*" -> result = arg1!! * arg2!!
                    "-" -> result = arg1!! - arg2!!
                    "+" -> result = arg1!! + arg2!!
                }

                Log.d(TAG, "result of $arg1 $op $arg2 = $result ")
                editText.setText(result.toString())
                op=""
            } else {
                arg1 = value.toDouble()
                op = oper
                Log.d(TAG, "operation is $op arg1=$arg1")
                editText.setText("")
            }


    }


}
