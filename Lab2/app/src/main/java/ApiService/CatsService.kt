package ApiService

import Models.CatModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CatsService {

    @GET("cats")
    fun searchCats(
        @Query("name") name: String,
        @Header("X-Api-Key") apiKey: String
    ): Call<List<CatModel>>
}
