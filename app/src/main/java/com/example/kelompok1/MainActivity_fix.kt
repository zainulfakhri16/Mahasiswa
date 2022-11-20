package com.example.kelompok1

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kelompok1.Datavalues.Companion.detailfilm
import com.example.kelompok1.Datavalues.Companion.gambarfilm
import com.example.kelompok1.Datavalues.Companion.namafilm

class MainActivity_fix : AppCompatActivity() {

    //TODO 01 : deklarasi
    private lateinit var rvMovie: RecyclerView
    private var list = ArrayList<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fix)

        //TODO 04
        rvMovie =findViewById(R.id.rv_movies)
        rvMovie.setHasFixedSize(true)
        list.addAll(listMovie)
        showRecyclerList()

//        val context: Context=this@MainActivity_fix
//        val intent= Intent(context,DetailActivity::class.java)
//        val dataMovie = Movie(data.judul, data.details,data.photos)
//        intent.putExtra("information",dataMovie)
//        context.startActivity(intent)

    }


    //TODO 02
    val listMovie: ArrayList<Movie>
    get() {
        val dataJudul = namafilm
        val dataDetail = detailfilm
        val dataPhoto = gambarfilm
        val listMovie = ArrayList<Movie>()
        for (i in dataJudul.indices){
            val movie = Movie(dataJudul[i], dataDetail[i],dataPhoto[i])
            listMovie.add(movie)
        }
        return listMovie
    }



    //TODO 03
    private fun showRecyclerList(){
        if(applicationContext.resources.configuration.orientation== Configuration.ORIENTATION_LANDSCAPE){
            rvMovie.layoutManager=GridLayoutManager(this,2)
        }else{
            rvMovie.layoutManager=LinearLayoutManager(this)
        }
        val listMovieAdapter = DataAdapter(list)
        rvMovie.adapter = listMovieAdapter
        listMovieAdapter.setOnItemClickCallback(object : DataAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Movie) {
                showSelectedHero(data)
            }
        })
    }

//fun show(data:Movie){
//    val context: Context=this@MainActivity_fix
//        val intent= Intent(context,DetailActivity::class.java)
//        val dataMovie = Movie(data.judul, data.details,data.photos)
//        intent.putExtra("information",dataMovie)
//        context.startActivity(intent)
//}
    private fun showSelectedHero(data: Movie){
        val context: Context=this@MainActivity_fix
        val intent= Intent(context,DetailActivity::class.java)
        val dataMovie = Movie(data.judul, data.details,data.photos)
        intent.putExtra("information",dataMovie)
        startActivity(intent)
    }

        //TODO 7C


            //TODO 8
//    val context: Context=this@MainActivity_fix
//    val intent= Intent(context,DetailActivity::class.java)




    //}

    //TODO 7C
}
