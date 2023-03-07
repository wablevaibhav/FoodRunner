package com.telphatech.foodrunner

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton

class RegisterScreen : AppCompatActivity() {

    private lateinit var imgBack: ImageView
    private lateinit var EtName: EditText
    private lateinit var EtPhone: EditText
    private lateinit var EtEmail: EditText
    private lateinit var EtPass: EditText
    private lateinit var EtLoc: EditText
    private lateinit var EtConfPass: EditText
    private lateinit var btnRegister: AppCompatButton

    private lateinit var sharedPreferences: SharedPreferences

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_screen)

        supportActionBar!!.hide()

        sharedPreferences = getSharedPreferences(getString(R.string.login), Context.MODE_PRIVATE)

        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        if (isLoggedIn) {
            startActivity(Intent(this, HomeScreen::class.java))
            finish()
        }

        setUp()


        imgBack.setOnClickListener {
            val intent = Intent(this, LoginScreen::class.java)
            startActivity(intent)
            finish()
        }

        btnRegister.setOnClickListener {

            val name = EtName.text.toString()
            val email = EtEmail.text.toString()
            val phone = EtPhone.text.toString()
            val address = EtLoc.text.toString()
            val pass = EtPass.text.toString()
            val confPass = EtConfPass.text.toString()

            sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
            sharedPreferences.edit().putString("name", name).apply()
            sharedPreferences.edit().putString("email", email).apply()
            sharedPreferences.edit().putString("phone", phone).apply()
            sharedPreferences.edit().putString("address", address).apply()
            sharedPreferences.edit().putString("pass", pass).apply()
            sharedPreferences.edit().putString("confPass", confPass).apply()

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty() || pass.isEmpty() || confPass.isEmpty()) {
                Toast.makeText(this, "Fill all the details", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, HomeScreen::class.java)
                startActivity(intent)
                finish()
            }


        }

    }

    private fun setUp() {
        imgBack = findViewById(R.id.imgBack)
        EtName = findViewById(R.id.EtName)
        EtPhone = findViewById(R.id.EtPhone)
        EtEmail = findViewById(R.id.EtEmail)
        EtLoc = findViewById(R.id.EtLoc)
        EtPass = findViewById(R.id.EtPass)
        EtConfPass = findViewById(R.id.EtConfPass)
        btnRegister = findViewById(R.id.btnRegister)
    }


}