package com.example.l1
import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val discountButton: Button
        get() = findViewById(R.id.discount_button)

    private val firstName: EditText
        get() =findViewById(R.id.first_name)

    private val lastName: EditText
        get()=findViewById(R.id.last_name)

    private val discountCodeConfirmation: TextView
        get()=findViewById(R.id.discount_code_confirmation)

    private val email: EditText
        get() = findViewById(R.id.email)


    private val discountCode: TextView
        get() =findViewById(R.id.discount_code)

    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG,"onCreate")


    }

    override fun onRestoreInstanceState(savedInstanceState:   Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "onRestoreInstanceState")
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState")
    }



}