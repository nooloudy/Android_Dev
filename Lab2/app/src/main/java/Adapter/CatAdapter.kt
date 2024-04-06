package Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import Models.CatModel
import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.lab2.R

class CatsAdapter(private val context :Context) : ListAdapter<CatModel, CatsAdapter.CatViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cat, parent, false)
        return CatViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        val currentCat = getItem(position)
        holder.bind(currentCat)
    }

    inner class CatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val minWeightTextView: TextView = itemView.findViewById(R.id.minWeightTextView)
        private val maxWeightTextView: TextView = itemView.findViewById(R.id.maxWeightTextView)
        private val sheddingTextView: TextView = itemView.findViewById(R.id.sheddingTextView)
        private val familyFriendlyTextView: TextView = itemView.findViewById(R.id.familyFriendlyTextView)
        private val image:ImageView = itemView.findViewById(R.id.image)
        fun bind(cat: CatModel) {
            nameTextView.text = cat.name
            minWeightTextView.text = "Min Weight: ${cat.minWeight} pounds"
            maxWeightTextView.text = "Max Weight: ${cat.maxWeight} pounds"
            sheddingTextView.text = "Shedding: ${cat.shedding}"
            familyFriendlyTextView.text = "Family Friendly: ${cat.familyFriendly}"
            Glide.with(context).load(cat.imageLink).fitCenter().into(image)
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<CatModel>() {
        override fun areItemsTheSame(oldItem: CatModel, newItem: CatModel): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: CatModel, newItem: CatModel): Boolean {
            return oldItem == newItem
        }
    }
}
