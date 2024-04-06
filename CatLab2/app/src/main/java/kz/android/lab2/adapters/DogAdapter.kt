package kz.android.lab2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kz.android.lab2.databinding.ItemDogBinding
import kz.android.lab2.model.DogBreed

class DogAdapter : ListAdapter<DogBreed, DogAdapter.DogViewHolder>(DogBreedDiffCallback) {


    object DogBreedDiffCallback : DiffUtil.ItemCallback<DogBreed>() {
        override fun areItemsTheSame(oldItem: DogBreed, newItem: DogBreed): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: DogBreed, newItem: DogBreed): Boolean {
            return oldItem == newItem
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemDogBinding.inflate(layoutInflater, parent, false)
        return DogViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val dogBreed = getItem(position)
        holder.bind(dogBreed)
    }

    class DogViewHolder(private val binding: ItemDogBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(dogBreed: DogBreed) {
            with(binding) {
                tvDogName.text = dogBreed.name
                tvGoodWithChildren.text = "Good with Children: ${dogBreed.goodWithChildren}"
                tvGoodWithOtherDogs.text = "Good with Other Dogs: ${dogBreed.goodWithOtherDogs}"
                tvEnergy.text = "Energy: ${dogBreed.energy}"
                tvLifeExpectancy.text = "Life Expectancy: ${dogBreed.minLifeExpectancy}-${dogBreed.maxLifeExpectancy} years"

                Glide.with(ivDogImage.context)
                    .load(dogBreed.imageLink)
                    .into(ivDogImage)
            }
        }
    }
}
