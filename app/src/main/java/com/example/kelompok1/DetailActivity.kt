package com.example.kelompok1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class DetailActivity : AppCompatActivity(),View.OnClickListener{

    //TODO 10

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.buttonTrailer->startActivity(
                Intent(
                    this@DetailActivity,VideoActivity::class.java
                )
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)
//        val toolbar: Toolbar = findViewById(R.id.detail_toolbar)
//        setSupportActionBar(toolbar)
////        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//
//        //bukan lagi di bawah u setDisplayHomeAsUp..jd 1 barisji
//        val actionBar = supportActionBar
//        actionBar?.setDisplayHomeAsUpEnabled(true)

        //TODO 8B

        val intent=intent
        val datasFilm=intent.getParcelableExtra<Movie>("information")
        val posterFilms= datasFilm?.photos
        val titleFilm= datasFilm?.judul
        val detailFilms= datasFilm?.details

        val imageView= findViewById<ImageView>(R.id.image1)
        try {
            if (posterFilms != null){
                imageView.setImageResource(posterFilms)
            }
        }catch (e:Exception){
            e.printStackTrace()
        }





        //TODO 8C

        val textView: TextView = findViewById(R.id.text3)
        textView.text= titleFilm
        val textView2:TextView= findViewById(R.id.overview)
        textView2.text=detailFilms


        //TODO 10

    }


}
