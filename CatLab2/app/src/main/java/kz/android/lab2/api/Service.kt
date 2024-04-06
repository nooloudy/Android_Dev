package kz.android.lab2.api

import kz.android.lab2.model.DogBreed
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface Service {
    @Headers("X-Api-Key:G+7vMUfMQfdL4r7b6y/HoA==AusKrOpk7HdD3rvP")
    @GET("dogs")
    fun getDogBreedByName(@Query("name") name: String): Call<List<DogBreed>>
}