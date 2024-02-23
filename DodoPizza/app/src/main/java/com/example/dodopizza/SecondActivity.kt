package com.example.dodopizza

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.dodopizza.adapter.PizzaAdapter
import com.example.dodopizza.databinding.ActivitySecondBinding
import com.example.dodopizza.models.Pizza
import com.example.dodopizza.models.PizzaDataSource

class SecondActivity : AppCompatActivity() {

    companion object{
        const val KEY_RESULT = "KeyResult"
    }

    private lateinit var binding:ActivitySecondBinding
    private lateinit var pizza:Pizza

    private lateinit var pizzaImage: ImageView
    private lateinit var pizzaTitle: TextView
    private lateinit var pizzaShortDescription: TextView
    private lateinit var pizzaDescription: TextView
    private lateinit var buttonCost: Button

    private lateinit var buttonLite: Button
    private lateinit var buttonMedium: Button
    private lateinit var buttonHigh: Button

    private lateinit var buttonTraditional: Button
    private lateinit var buttonThin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_second)

        val result = intent.getStringExtra(KEY_RESULT)

        pizzaTitle = findViewById(R.id.pizza_title)
        pizzaImage = findViewById(R.id.pizza_image)
        pizzaShortDescription = findViewById(R.id.pizza_short_description)
        pizzaDescription = findViewById((R.id.pizza_description))
        buttonCost = findViewById(R.id.cost)

        val pizza = PizzaDataSource.pizzaList.find { it.title == result }

        pizza?.let {
            pizzaTitle.text = it.title
            pizzaImage.setImageResource(pizza.image)
            pizzaShortDescription.text = it.shortDescription
            pizzaDescription.text = it.description
            buttonCost.text= it.costSecond
        }

        buttonLite = findViewById(R.id.button_Lite)
        buttonMedium = findViewById(R.id.button_Medium)
        buttonHigh = findViewById(R.id.button_High)

        val buttons = listOf(buttonLite, buttonMedium, buttonHigh)

        // Устанавливаем белый цвет для buttonMedium по умолчанию
        buttonLite.backgroundTintList = ContextCompat.getColorStateList(this, R.color.gray)
        buttonMedium.backgroundTintList = ContextCompat.getColorStateList(this, R.color.gray)
        buttonHigh.backgroundTintList = ContextCompat.getColorStateList(this, R.color.gray)


        buttonLite.setOnClickListener {
            if (buttonLite.backgroundTintList == ContextCompat.getColorStateList(this, R.color.white)) {
                buttonLite.backgroundTintList = ContextCompat.getColorStateList(this, R.color.gray)
            } else {
                buttonLite.backgroundTintList = ContextCompat.getColorStateList(this, R.color.white)
                buttonMedium.backgroundTintList = ContextCompat.getColorStateList(this, R.color.gray)
                buttonHigh.backgroundTintList = ContextCompat.getColorStateList(this, R.color.gray)
            }
        }

        buttonMedium.setOnClickListener {
            if (buttonMedium.backgroundTintList == ContextCompat.getColorStateList(this, R.color.white)) {
                buttonMedium.backgroundTintList = ContextCompat.getColorStateList(this, R.color.gray)
            } else {
                buttonLite.backgroundTintList = ContextCompat.getColorStateList(this, R.color.gray)
                buttonMedium.backgroundTintList = ContextCompat.getColorStateList(this, R.color.white)
                buttonHigh.backgroundTintList = ContextCompat.getColorStateList(this, R.color.gray)
            }
        }

        buttonHigh.setOnClickListener {
            if (buttonHigh.backgroundTintList == ContextCompat.getColorStateList(this, R.color.white)) {
                buttonHigh.backgroundTintList = ContextCompat.getColorStateList(this, R.color.gray)
            } else {
                buttonLite.backgroundTintList = ContextCompat.getColorStateList(this, R.color.gray)
                buttonMedium.backgroundTintList = ContextCompat.getColorStateList(this, R.color.gray)
                buttonHigh.backgroundTintList = ContextCompat.getColorStateList(this, R.color.white)
            }
        }

        buttonTraditional = findViewById(R.id.button_Traditional)
        buttonThin = findViewById(R.id.button_Thin)

        buttonTraditional.backgroundTintList = ContextCompat.getColorStateList(this,R.color.gray)
        buttonThin.backgroundTintList = ContextCompat.getColorStateList(this,R.color.gray)

        buttonTraditional.setOnClickListener{
            if (buttonTraditional.backgroundTintList == ContextCompat.getColorStateList(this, R.color.gray)){
                buttonTraditional.backgroundTintList = ContextCompat.getColorStateList(this, R.color.white)
                buttonThin.backgroundTintList = ContextCompat.getColorStateList(this,R.color.gray)
            }
            else if (buttonThin.backgroundTintList == ContextCompat.getColorStateList(this,R.color.gray)){
                buttonThin.backgroundTintList = ContextCompat.getColorStateList(this, R.color.white)
                buttonTraditional.backgroundTintList = ContextCompat.getColorStateList(this,R.color.gray)
            }
        }


    }
    fun goBack(view: View) {
        finish()
    }




}