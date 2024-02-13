package com.example.test_application

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.TelephonyCallback.BarringInfoListener
import android.view.inputmethod.InputBinding
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstNameText: EditText = findViewById(R.id.first_name_text)
        val lastNameText:EditText = findViewById(R.id.last_name_text)
        val dateOfBirthText: EditText = findViewById(R.id.date_of_birth)
        val login: EditText = findViewById(R.id.login)
        val password: EditText = findViewById(R.id.password)
        val registerButton: Button = findViewById(R.id.register_button)

        registerButton.setOnClickListener {
            val person = Person(
                firstNameText.text.toString(),
                lastNameText.text.toString(),
                dateOfBirthText.text.toString(),
                login.text.toString(),
                password.text.toString()
            )
            val intent = Intent(this, DetailsMain::class.java)
            intent.putExtra("Person", person)
            startActivity(intent)
        }

    }
}

