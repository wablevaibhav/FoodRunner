package com.telphatech.foodrunner

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toolbar

class HomeScreen : AppCompatActivity() {

    private lateinit var name: TextView
    private lateinit var phone: TextView
    private lateinit var pass: TextView
    private lateinit var email: TextView
    private lateinit var address: TextView
    private lateinit var confPass: TextView

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        sharedPreferences = getSharedPreferences(getString(R.string.login), Context.MODE_PRIVATE)

        name = findViewById(R.id.txtName)
        phone = findViewById(R.id.txtPhone)
        email = findViewById(R.id.txtEmail)
        address = findViewById(R.id.txtAddress)
        pass = findViewById(R.id.txtPass)
        confPass = findViewById(R.id.txtConfPass)


        val Name = sharedPreferences.getString("name", "name")
        val Phone = sharedPreferences.getString("phone", "phone")
        val Pass = sharedPreferences.getString("pass", "pass")
        val Email = sharedPreferences.getString("email", "email")
        val Address = sharedPreferences.getString("address", "address")
        val ConfPass = sharedPreferences.getString("confPass", "confPass")

        name.text = Name
        phone.text = Phone
        email.text = Email
        pass.text = Pass
        address.text = Address
        confPass.text = ConfPass

    }
}