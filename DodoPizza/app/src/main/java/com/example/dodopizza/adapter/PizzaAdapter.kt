package com.example.dodopizza.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dodopizza.databinding.ItemPizzaBinding
import com.example.dodopizza.models.Pizza

class PizzaAdapter(
    private val onPizzaClick: (Pizza) -> Unit
) : RecyclerView.Adapter<PizzaAdapter.ViewHolder>() {
    private val pizzaList: ArrayList<Pizza> = ArrayList()

    fun setData(pizzas:ArrayList<Pizza>){
        pizzaList.clear()

        pizzaList.addAll(pizzas)
        /**
         * Метод для обновления списка элементов
         */
        notifyDataSetChanged()
    }
    inner class ViewHolder(
        private val binding: ItemPizzaBinding
    ):RecyclerView.ViewHolder(binding.root){
        fun bind(pizza: Pizza){
            with(binding){
                pizzaImage.setImageResource(pizza.image)
                pizzaTitle.text = pizza.title
                pizzaDescription.text = pizza.description
                pizzaCost.text = pizza.cost


                root.setOnClickListener{
                    onPizzaClick(pizza)
                }
            }
        }
    }

    /**
     * Метод который будет создавать view для каждого обьекта
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPizzaBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            )
        )
    }

    /**
     *Метод для определения количество элементов списка
     */
    override fun getItemCount() = pizzaList.size

    /**
     *Для вызова метода из ViewHolder'a
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind((pizzaList[position]))
    }
}