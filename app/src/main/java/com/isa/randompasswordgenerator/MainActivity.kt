package com.isa.randompasswordgenerator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.textfield.TextInputLayout
import java.security.SecureRandom

class MainActivity : AppCompatActivity() {
    private var tilPassword: TextInputLayout? = null
    private lateinit var etPass: EditText // Declare etPass as a member variable

    private val random = SecureRandom()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        tilPassword = findViewById(R.id.til_password)
        etPass = findViewById(R.id.et_pass) // Initialize etPass here
        val btnGenerate = findViewById<Button>(R.id.btn_generate)
        val btnClear = findViewById<Button>(R.id.btn_clear)

        btnGenerate.setOnClickListener(View.OnClickListener { generatePassword() })

        btnClear.setOnClickListener(View.OnClickListener { etPass.setText("")
        })
    }

    private fun generatePassword() {
        val length = 12 // You can change the length of the generated password
        val password = StringBuilder(length)

        for (i in 0 until length) {
            val index = random.nextInt(CHARACTERS.length)
            password.append(CHARACTERS[index])
        }

        etPass.setText(password.toString())
        tilPassword!!.isEnabled = true
    }

    companion object {
        private const val CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_+=<>?"
    }
}
