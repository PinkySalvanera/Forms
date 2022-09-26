package com.example.forms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    private lateinit var tvHello: TextView
    private lateinit var buttonResetPass: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email = intent.getStringExtra(Constants.EMAIL)


        Log.d("MainActivity", "$email")

        tvHello = findViewById(R.id.tvHello)
        tvHello.text = "Hello $email!"
        buttonResetPass = findViewById(R.id.btnResetPassword)

        buttonResetPass.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                Log.d("MainActivity", "Reset password button clicked")
                toResetPasswordActivity()
            }
        })
        return
    }

    private fun toResetPasswordActivity(){

        val oldPassword = intent.getStringExtra(Constants.PASSWORD)

        val resetPasswordIntent = Intent(this, ResetPasswordActivity::class.java)
        resetPasswordIntent.putExtra(Constants.PASSWORD, oldPassword)
        startActivity(resetPasswordIntent)
        //finish()
    }

}
