package com.example.myapplication

import android.content.Intent
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        title = "Log In"

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtRegister = findViewById(R.id.txtRegister)
        btnLogin = findViewById(R.id.btnLogin)



        btnLogin.setOnClickListener {
            val mobileNuber = etMobileNumber.text.toString()
            val password = etPassword.text.toString()


            if ((mobileNuber == validMobilNumber) && (validPassword.contains(password))) {
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
                Toast.makeText(
                    this@LoginActivity,
                    "login successful",
                    Toast.LENGTH_LONG
                ).show()
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


}
