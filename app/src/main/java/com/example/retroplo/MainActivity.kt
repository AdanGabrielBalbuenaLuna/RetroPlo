package com.example.retroplo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.retroplo.network.RandomRepo
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    lateinit var  textViewCountry: TextView;
    lateinit var textCity: TextView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewCountry = findViewById(R.id.tvCountry)
        textCity = findViewById(R.id.tvCity)
    }


    fun getRandomPersonaaa(view:View){
        var interceptor = RandomRepo()
        doAsync {
            var response = interceptor.getPersonRandomRepo()
            uiThread {
                textViewCountry.text = response.body()?.results?.get(0)?.location?.country
                textCity.text = response.body()?.results?.get(0)?.location?.city
            }
        }
    }
}
