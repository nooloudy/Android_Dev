package com.example.dodopizza.models

import com.example.dodopizza.R

object PizzaDataSource {
    val pizzaList = arrayListOf<Pizza>(
        Pizza(
            title = "Arriva",
            description = "Chicken, spicy chorizo, burger sauce, sweet peppers, red onion, tomatoes, mozzarella, ranch sauce, garlic",
            image = R.drawable.arriva_pizza,
            cost = "from 2400 KZT",
            shortDescription = "Medium 30cm, traditional dough, 590g",
            costSecond = "Add to cart for 2400 KZT"
        ),
        Pizza(
            title = "Bavarian",
            description = "Spicy chorizo sausages, pickled cucumbers, red onions, tomatoes, mustard sauce, mozzarella, signature tomato sauce",
            image = R.drawable.bavarian_pizza,
            cost = "from 2700 KZT",
            shortDescription = "Medium 30cm, traditional dough, 550g",
            costSecond = "Add to cart for 2700 KZT"
        ),
        Pizza(
            title = "Dodo Mix",
            description = "Four favorite pizzas in one: Carbonara, Pesto, Four Cheese, Ham and Cheese",
            image = R.drawable.dodo_mix_pizza,
            cost = "from 2900 KZT",
            shortDescription = "Medium 30cm, traditional dough, 680g",
            costSecond = "Add to cart for 2900 KZT"
        ),
        Pizza(
            title = "Carbonara",
            description = "Chicken ham, cheddar and parmesan cheeses, tomatoes, red onion, mozzarella, alfredo sauce, garlic and Italian herbs",
            image = R.drawable.carbonara_pizza,
            cost = "from 2400 KZT",
            shortDescription = "Medium 30cm, traditional dough, 580g",
            costSecond = "Add to cart for 2400 KZT"
        )
    )
}