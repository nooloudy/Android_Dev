package kz.android.lab2.model

import com.google.gson.annotations.SerializedName

data class DogBreed(
    @SerializedName("name") val name: String,
    @SerializedName("image_link") val imageLink: String,
    @SerializedName("good_with_children") val goodWithChildren: Int,
    @SerializedName("good_with_other_dogs") val goodWithOtherDogs: Int,
    @SerializedName("energy") val energy: Int,
    @SerializedName("min_life_expectancy") val minLifeExpectancy: Int,
    @SerializedName("max_life_expectancy") val maxLifeExpectancy: Int
)