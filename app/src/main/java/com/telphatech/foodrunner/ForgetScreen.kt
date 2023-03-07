package com.telphatech.foodrunner

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton

class ForgetScreen : AppCompatActivity() {

    private lateinit var EtPhone: EditText
    private lateinit var EtEmail: EditText
    private lateinit var btnNext: AppCompatButton

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_screen)

        supportActionBar!!.hide()

        EtPhone = findViewById(R.id.EtPhone)
        EtEmail = findViewById(R.id.EtEmail)
        btnNext = findViewById(R.id.btnNext)

        btnNext.setOnClickListener {

            val email = EtEmail.text.toString()
            val phone = EtPhone.text.toString()

            sharedPreferences =
                getSharedPreferences(getString(R.string.login), Context.MODE_PRIVATE)
            sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
            sharedPreferences.edit().putString("email", email).apply()
            sharedPreferences.edit().putString("phone", phone).apply()

            if (email.isEmpty() || phone.isEmpty()) {
                Toast.makeText(this, "Fill all the details", Toast.LENGTH_SHORT).show()
            } else {
                savePreferences(phone, email)
                val intent = Intent(this, HomeScreen::class.java)
                startActivity(intent)
                finish()
            }


        }

    }

    private fun savePreferences(phone: String, email: String) {
        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
        sharedPreferences.edit().putString("phone", phone).apply()
        sharedPreferences.edit().putString("pass", email).apply()
    }
}