package com.example.forms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ResetPasswordActivity : AppCompatActivity() {
    private lateinit var tvOldPass: TextView
    private lateinit var etNewPass: EditText
    private lateinit var btnResetPassword: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)
        tvOldPass = findViewById(R.id.tvOldPass)
        etNewPass = findViewById(R.id.etNewPass)
        btnResetPassword = findViewById(R.id.btnResetPassword)

        val oldPass = intent.getStringExtra(Constants.PASSWORD)

        tvOldPass.text = oldPass

        btnResetPassword.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d("ResetPasswordActivity", "Reset password button clicked")
                finish()
            }
        })
    }
}