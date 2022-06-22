package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {



    lateinit var etMobileNumber: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var txtForgotPassword: TextView
    lateinit var txtRegister: TextView
    val validMobilNumber = "9621659530"
    val validPassword = arrayOf("tony", "stave", "bruce", "thanos")
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences =
            getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)
        setContentView(R.layout.activity_login)

        if (isLoggedIn) {
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        title = "Log In"

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtRegister = findViewById(R.id.txtRegister)
        btnLogin = findViewById(R.id.btnLogin)



        btnLogin.setOnClickListener {
            val mobileNumber = etMobileNumber.text.toString()
            val password = etPassword.text.toString()


            if ((mobileNumber == validMobilNumber) && (validPassword.contains(password))) {
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
                Toast.makeText(
                    this@LoginActivity,
                    "login successful",
                    Toast.LENGTH_LONG
                ).show()
                savePreferences()
            } else {
                Toast.makeText(
                    this@LoginActivity,
                    "Invalid Credential",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    fun savePreferences() {
        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
    }

}




