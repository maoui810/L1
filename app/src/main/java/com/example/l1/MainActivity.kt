package com.example.l1
import android.content.ContentValues.TAG
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*

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

        discountButton.setOnClickListener {
            val firstName = firstName.text.toString().trim()
            val lastName = lastName.text.toString().trim()
            val email = email.text.toString()

            if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()){
                Toast.makeText(this, getString(R.string.add_text_validation), Toast.LENGTH_LONG).show()
            }
            else {
                val fullName = firstName.plus(" ").plus(lastName)

                discountCodeConfirmation.text =
                    getString(R.string.discount_code_confirmation, fullName)
                // Generates discount code
                discountCode.text = UUID.randomUUID().toString().take(8).toUpperCase()

                hideKeyboard()
                clearInputFields()
            }


        }


    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "onRestoreInstanceState")

        //Get the discount code or an empty string if it hasn't been set
        discountCode.text = savedInstanceState.getString(DISCOUNT_CODE,"")
        //Get the discount confirmation message or an empty string if it hasn't been set
        discountCodeConfirmation.text =
            savedInstanceState.getString(
                DISCOUNT_CONFIRMATION_MESSAGE,"")

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState")

        outState.putString(DISCOUNT_CODE,
            discountCode.text.toString())
        outState.putString(DISCOUNT_CONFIRMATION_MESSAGE,
            discountCodeConfirmation.text.toString())
    }



    private fun clearInputFields() {
        firstName.text.clear()
        lastName.text.clear()
        email.text.clear()
    }

    private fun hideKeyboard() {
        if (currentFocus != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }
    }

    companion object {
        private const val TAG = "MainActivity"
        private const val DISCOUNT_CONFIRMATION_MESSAGE = "DISCOUNT_CONFIRMATION_MESSAGE"
        private const val DISCOUNT_CODE = "DISCOUNT_CODE"
    }


}