package com.telphatech.foodrunner

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton

class LoginScreen : AppCompatActivity() {

    private lateinit var txtForget: TextView
    private lateinit var txtRegister: TextView
    private lateinit var EtPhone: EditText
    private lateinit var EtPass: EditText
    private lateinit var btnLogin: AppCompatButton

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        supportActionBar!!.hide()

        EtPhone = findViewById(R.id.EtPhone)
        EtPass = findViewById(R.id.EtPass)
        btnLogin = findViewById(R.id.btnLogin)
        txtRegister = findViewById(R.id.txtRegister)
        txtForget = findViewById(R.id.txtForget)

        txtRegister.setOnClickListener {
            startActivity(Intent(this, RegisterScreen::class.java))
        }

        txtForget.setOnClickListener {
            startActivity(Intent(this, ForgetScreen::class.java))
        }

        sharedPreferences = getSharedPreferences(getString(R.string.login), Context.MODE_PRIVATE)

        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)


        if (isLoggedIn) {
            startActivity(Intent(this, HomeScreen::class.java))
            finish()
        }

        btnLogin.setOnClickListener {

            val phone = EtPhone.text.toString()
            val pass = EtPass.text.toString()

            if (phone.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Invalid Credentials!", Toast.LENGTH_SHORT).show()
            } else {
                savePreferences(phone, pass)
                startActivity(Intent(this, HomeScreen::class.java))
                finish()
            }


        }


    }

    private fun savePreferences(phone: String, pass: String) {
        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
        sharedPreferences.edit().putString("phone", phone).apply()
        sharedPreferences.edit().putString("pass", pass).apply()
    }

}