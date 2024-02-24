package com.example.dodopizza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.dodopizza.adapter.PizzaAdapter
import com.example.dodopizza.databinding.ActivityMainBinding
import com.example.dodopizza.models.Pizza
import com.example.dodopizza.models.PizzaDataSource

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var search: EditText
    private lateinit var adapter: PizzaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = PizzaAdapter(
            onPizzaClick = {
                handlePizzaClick(it)
            }
        )

        binding.recyclerView.adapter = adapter

        adapter.setData(PizzaDataSource.pizzaList)


        val editTextSearch = findViewById<EditText>(R.id.pizza_seacrh)
        editTextSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
                adapter.filter(charSequence.toString())
            }

            override fun afterTextChanged(editable: Editable?) {}
        })

    }
    private fun handlePizzaClick(pizza: Pizza){
        /**
         * Intent это - переход между activity
         */
        val intent = Intent(this,SecondActivity::class.java)
        intent.putExtra(SecondActivity.KEY_RESULT,pizza.title)
        startActivity(intent)
    }


}