package com.example.test_application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class DetailsMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_main)

        val userDetailsText: TextView = findViewById(R.id.user_details)

        val person: Person = intent.getSerializableExtra("Person") as Person
        val userDetails = "First Name: ${person.firstName}\nLast Name: ${person.lastName}\nDate of Birth: ${person.dateOfBirth}\nLogin: ${person.login}\nPassword: ${person.password}"
        userDetailsText.text = userDetails
    }
}