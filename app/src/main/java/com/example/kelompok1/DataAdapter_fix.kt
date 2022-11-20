package com.example.kelompok1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


//TODO 5A: Lengkapi parameter DataAdapter
class DataAdapter(private val listMovie:ArrayList<Movie>) : RecyclerView.Adapter<DataAdapter
.ListViewHolder>() {

    //TODO 7A
    private lateinit var onItemClickCallback: OnItemClickCallback
    fun setOnItemClickCallback(onItemClickCallback:OnItemClickCallback){
        this.onItemClickCallback=onItemClickCallback
    }
    interface OnItemClickCallback{
        fun onItemClicked(data:Movie)
    }



    //TODO 5A: Uncomment 3 fungsi yang sudah ada
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        //TODO 6A...
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_content_fix, parent, false)
        return ListViewHolder(view)
    }

    //
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        //TODO 6A...
        val model = listMovie[position]
        holder.imgPhoto.setImageResource(model.photos)
        holder.tvNama.text = model.judul
        holder.tvDescriptor.text = model.details

        holder.itemView.setOnClickListener{
            Toast.makeText(holder.itemView.context, "Judul "+ model.judul, Toast.LENGTH_SHORT).show()
            onItemClickCallback.onItemClicked(listMovie[holder.adapterPosition])
        }


        //TODO 6B...


        //TODO 7B...

    }

    //
    override fun getItemCount(): Int {
        return listMovie.size
    }

    //TODO 5B
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvNama: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDescriptor: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    //TODO 6A...


}

