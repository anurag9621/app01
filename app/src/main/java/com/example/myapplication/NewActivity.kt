package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class NewActivity : AppCompatActivity(){


    lateinit var etMobileNumber: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var txtForgotPassword: TextView
    lateinit var txtRegister: TextView
    val validMobilNumber="9621659530"
    val validPassword="mahadev"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)
        title = "Log In"

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtRegister = findViewById(R.id.txtRegister)
        btnLogin = findViewById(R.id.btnLogin)



        btnLogin.setOnClickListener {
            val mobileNuber = etMobileNumber.text.toString()
            val password=etPassword.text.toString()


            if ((mobileNuber==validMobilNumber) && (password==validPassword)){
                val intent =Intent(this@NewActivity,MainActivity::class.java)
                startActivity(intent)
                Toast.makeText(
                    this@NewActivity,
                    "login successful",
                    Toast.LENGTH_LONG
                ).show()
            }else{
                Toast.makeText(
                    this@NewActivity,
                    "Invalid Credential",
                    Toast.LENGTH_LONG
                ).show()
            }


        }



    }


}