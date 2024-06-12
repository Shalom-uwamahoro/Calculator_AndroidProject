package com.example.calculator

import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener{
            validate("+")
        }

        binding.btnSubstract.setOnClickListener{
            validate("-")
        }

        binding.btnMultiply.setOnClickListener{
            validate("*")
        }

        binding.btnDivide.setOnClickListener{
            validate("/")

       }
    }

        fun validate(operation: String){
            val num1 = binding.etNum1.text.toString()
            val num2 = binding.etNum2.text.toString()
            var errorT = false
            if (num1.isBlank()){
                errorT = true
                binding.etNum1.error = "Num 1 is required" //setting error bcz etNum1 inherites the attributes
                                                 // form Class TextView, one of it properties is error
            }
            if (num2.isBlank()){
                errorT = true
                binding.etNum2.error = "Num 2 is required"
            }
            if (!errorT){
                calculate(num1.toDouble(), num2.toDouble(), operation)
            }
        }
    fun calculate(num1: Double, num2: Double, sign: String) {
        var result = 0.0
        when (sign) {
            "+" -> result = (num1 + num2)
            "-" -> result = (num1 - num2)
            "*" -> result = (num1 * num2)
            "/" -> {
                if (num2 == 0.0) {
                    binding.tvResult.text = "Cannot divide by zero"
                    return
                }
                result = num1 / num2
            }

        }
        binding.tvResult.text = result.toString()
        if (sign == "/") {
            binding.tvResult.text = result.toString()
        } else {
            binding.tvResult.text = if (num1 % 1 == 0.0 && num2 % 1 == 0.0) result.toInt()
                .toString() else result.toString()
        }
    }
}
