package com.example.klubsportowy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.klubsportowy.model.Players
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import java.io.IOException
import java.nio.charset.Charset



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        try {

            val jsonString = getJSONFromAssets()!!
            val players = Gson().fromJson(jsonString, Players::class.java)

            rv_players_list.layoutManager = LinearLayoutManager(this)
            val itemAdapter = UserAdapter(this, players.players)
            rv_players_list.adapter = itemAdapter


        } catch (e: JSONException) {
            e.printStackTrace()
        }


    }


    /**
     * Method to load the JSON from the Assets file and return the object
     */
    private fun getJSONFromAssets(): String? {

        var json: String? = null
        val charset: Charset = Charsets.UTF_8
        try {
            val myUsersJSONFile = assets.open("klubsportowy.json")
            val size = myUsersJSONFile.available()
            val buffer = ByteArray(size)
            myUsersJSONFile.read(buffer)
            myUsersJSONFile.close()
            json = String(buffer, charset)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }
}