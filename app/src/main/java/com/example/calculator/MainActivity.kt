package com.example.calculator

import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    lateinit var etNum1: EditText
    lateinit var etNum2: EditText
    lateinit var btnAdd: Button
    lateinit var btnSubtract: Button
    lateinit var btnMultiply: Button
    lateinit var btnDivide: Button
    lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        castViews()

        btnAdd.setOnClickListener{
            validate("+")
        }

        btnSubtract.setOnClickListener{
            validate("-")
        }

        btnMultiply.setOnClickListener{
            validate("*")
        }

        btnDivide.setOnClickListener{
            validate("/")

       }
    }
        fun castViews(){
            etNum1 = binding.etNum1
            etNum2 = binding.etNum2
            btnAdd = binding.btnAdd
            btnSubtract = binding.btnSubstract
            btnMultiply = binding.btnMultiply
            btnDivide = binding.btnDivide
            tvResult = binding.tvResult
        }

        fun validate(operation: String){
            val num1 = etNum1.text.toString()
            val num2 = etNum2.text.toString()
            var errorT = false
            if (num1.isBlank()){
                errorT = true
                etNum1.error = "Num 1 is required" //setting error bcz etNum1 inherites the attributes
                                                 // form Class TextView, one of it properties is error
            }
            if (num2.isBlank()){
                errorT = true
                etNum2.error = "Num 2 is required"
            }
            if (!errorT){
                calculate(num1.toDouble(), num2.toDouble(), operation)
            }
        }
        fun calculate(num1: Double, num2:Double, operation: String){
            var result = 0.0
            when(operation){
                "+" -> {
                    result = num1 + num2
                }
                "-" -> {
                    result = num1 - num2
                }
                "*" -> {
                    result = num1 * num2
                }
                "/" -> {
                    result = num1 / num2
                }
            }
            tvResult.text = result.toString()
            //Anything editable in Android is perceive to be text, so to convert it to any other data type we first convert it to string.
        }
    }
