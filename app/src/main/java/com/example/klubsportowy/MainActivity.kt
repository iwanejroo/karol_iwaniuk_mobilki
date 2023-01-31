package com.example.klubsportowy


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.klubsportowy.databinding.ActivityMainBinding
import com.example.klubsportowy.JSON.JSONActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.jsonButton.setOnClickListener {
            val intent = Intent(this@MainActivity, JSONActivity::class.java)
            this@MainActivity.startActivity(intent)
        }
    }
}