package com.example.forms

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var tvAppName: TextView
    private lateinit var etEmailAdd: EditText
    private lateinit var etPasswd: EditText
    private lateinit var imgLogo: ImageView
    private lateinit var buttonLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tvAppName = findViewById(R.id.tvAppName)
        etEmailAdd = findViewById(R.id.etEmail)
        etPasswd = findViewById(R.id.etPassword)
        imgLogo = findViewById(R.id.imgLogo)
        buttonLogin = findViewById(R.id.btnLogin)

        buttonLogin.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d("LoginActivity", "Login button clicked")
                login()
            }
        })
    }

    private fun login() {
        val email = etEmailAdd.text.toString()
        val password = etPasswd.text.toString()
        val isValidPassword = validatePassword()

        if(!isValidPassword){
            Toast.makeText(this, "Password should be greater than 6 characters", Toast.LENGTH_SHORT)
                .show()
            return
        }

        Log.d("LoginActivity", "email: $email password:$password")
        toMainActivity()

    }

    private fun validatePassword(): Boolean {
        val password = etPasswd.text.toString()
        return password.length > 6
    }

    private fun toMainActivity(){
        val email = etEmailAdd.text.toString()
        val password = etPasswd.text.toString()

        val mainIntent = Intent(this, MainActivity::class.java)
        mainIntent.putExtra(Constants.EMAIL, email)
        mainIntent.putExtra(Constants.PASSWORD, password)

        startActivity(mainIntent)
        finish()
    }
}






