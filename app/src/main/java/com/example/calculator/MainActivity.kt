package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import javax.microedition.khronos.opengles.GL10

class MainActivity : AppCompatActivity() {
    lateinit var etNum1: EditText
    lateinit var etNum2: EditText
    lateinit var btnAdd: Button
    lateinit var btnSubtract: Button
    lateinit var btnMultiply: Button
    lateinit var btnDivide: Button
    lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        castViews()
    }

        fun castViews(){
            etNum1 = findViewById(R.id.etNum1)
            etNum2 = findViewById(R.id.etNum2)
            btnAdd = findViewById(R.id.btnAdd)
            btnSubtract = findViewById(R.id.btnSubstract)
            btnMultiply = findViewById(R.id.btnMultiply)
            btnDivide = findViewById(R.id.btnDivide)
            tvResult = findViewById(R.id.tvResult)
        }
    }
