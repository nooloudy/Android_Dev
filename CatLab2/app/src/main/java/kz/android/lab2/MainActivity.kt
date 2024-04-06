package kz.android.lab2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kz.android.lab2.adapters.DogAdapter
import kz.android.lab2.api.Repository
import kz.android.lab2.databinding.ActivityMainBinding
import kz.android.lab2.model.DogBreed
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    val adapter = DogAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        with(binding){
            dogList.adapter = adapter
            dogList.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            etSearch.setOnEditorActionListener { it, actionId, _ ->
                if (actionId == android.view.inputmethod.EditorInfo.IME_ACTION_SEARCH) {
                    performSearch(it.text.toString())
                    true
                } else false
            }
        }
        setContentView(binding.root)

    }
    private fun performSearch(query: String) {
        Repository.api.getDogBreedByName(query).enqueue(object :
            Callback<List<DogBreed>> {
            override fun onResponse(call: Call<List<DogBreed>>, response: Response<List<DogBreed>>) {
                if (response.isSuccessful) {
                  adapter.submitList(response.body())
                }
            }
            override fun onFailure(call: Call<List<DogBreed>>, t: Throwable) {
            }
        })
    }
}