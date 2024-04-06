package com.example.lab2;
import Adapter.CatsAdapter
import ApiService.ApiFactory
import ApiService.CatsService
import Models.CatModel
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CatsAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = CatsAdapter(this)
        recyclerView.adapter = adapter

        val searchView: SearchView = findViewById(R.id.searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { searchCats(it) }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
        val sheddingButton = findViewById<Button>(R.id.sheddingButton)
        val friendlyButton = findViewById<Button>(R.id.friendlyButton)
        sheddingButton.setOnClickListener {
            sortCatsByShedding()
        }

        friendlyButton.setOnClickListener {
            sortCatsByFriendly()
        }
    }
    private fun sortCatsByShedding() {
        val sortedCats = adapter.currentList.sortedByDescending { it.shedding ?: 0 }
        adapter.submitList(sortedCats)
    }

    private fun sortCatsByFriendly() {
        val sortedCats = adapter.currentList.sortedByDescending { it.familyFriendly ?: 0 }
        adapter.submitList(sortedCats)
    }

    private fun searchCats(query: String) {

        val call = ApiFactory.apiService.searchCats(query, "MR6OSJP40tqTMmBuAyW3Wg==j7J0C367Jyhcdqhs")

        call.enqueue(object : Callback<List<CatModel>> {
            override fun onResponse(call: Call<List<CatModel>>, response: Response<List<CatModel>>) {
                if (response.isSuccessful) {
                    val cats = response.body()
                    cats?.let { adapter.submitList(it) }
                } else {
                    onFailure(call, Throwable("Failed to fetch cats: ${response.message()}"))
                }
            }

            override fun onFailure(call: Call<List<CatModel>>, t: Throwable) {
                    Log.e("getCats", "Error- ", t)
            }
        })
    }
}
