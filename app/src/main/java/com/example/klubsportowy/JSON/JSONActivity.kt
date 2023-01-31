package com.example.klubsportowy.JSON

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.klubsportowy.R
import com.example.klubsportowy.APIService
import com.example.klubsportowy.List
import com.example.klubsportowy.RVAdapter
import com.example.klubsportowy.databinding.ActivityJsonBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class JSONActivity : AppCompatActivity() {

    var itemsArray: ArrayList<List> = ArrayList()
    lateinit var adapter: RVAdapter
    private lateinit var binding: ActivityJsonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJsonBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupRecyclerView()
        parseJSON()
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        binding.jsonResultsRecyclerview.layoutManager = layoutManager
        binding.jsonResultsRecyclerview.setHasFixedSize(true)
        val dividerItemDecoration =
            DividerItemDecoration(binding.jsonResultsRecyclerview.context, layoutManager.orientation)
        ContextCompat.getDrawable(this, R.drawable.line_divider)
            ?.let { drawable -> dividerItemDecoration.setDrawable(drawable) }
        binding.jsonResultsRecyclerview.addItemDecoration(dividerItemDecoration)
    }

    @SuppressLint("LongLogTag")
    private fun parseJSON() {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(APIService::class.java)

        CoroutineScope(Dispatchers.IO).launch {

            val response = service.getPlayers()

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {

                    //val gson = GsonBuilder().setPrettyPrinting().create()
                    //val prettyJson = gson.toJson(response.body())


                    val items = response.body()?.players
                    if (items != null) {
                        for (i in 0 until items.count()) {

                            val id = items[i].playerID ?: "N/A"
                            Log.d("ID: ", id)

                            val  playername = items[i].player?.imie ?: "N/A"
                            Log.d("---", playername)

                            val  playersurname = items[i].player?.nazwisko ?: "N/A"
                            Log.d("---", playersurname)

                            val playerage = items[i].player?.wiek?: 0
                            Log.d("---", playerage.toString())

                            val  playerposition = items[i].player?.pozycja?: "N/A"
                            Log.d("---", playerposition)

                            val  playerimg = items[i].player?.zdjecie ?: "N/A"
                            Log.d("---", playerimg)

                            val  playercountry = items[i].player?.narodowosc ?: "N/A"
                            Log.d("---", playercountry)

                            val mecze = items[i].player?.statystyki?.mecze?: 0
                            Log.d("---", mecze.toString())

                            val gole = items[i].player?.statystyki?.gole?: 0
                            Log.d("---", gole.toString())

                            val asysty = items[i].player?.statystyki?.asysty?: 0
                            Log.d("---", asysty.toString())


                            val model =
                                List(
                                    id,
                                    playername,
                                    playersurname,
                                    playerage,
                                    playerposition,
                                    playerimg,
                                    playercountry,
                                    mecze,
                                    gole,
                                    asysty

                                )
                            itemsArray.add(model)

                            adapter = RVAdapter(itemsArray)
                            adapter.notifyDataSetChanged()
                        }
                    }

                    binding.jsonResultsRecyclerview.adapter = adapter

                } else {

                    Log.e("RETROFIT_ERROR", response.code().toString())

                }
            }
        }
    }
}