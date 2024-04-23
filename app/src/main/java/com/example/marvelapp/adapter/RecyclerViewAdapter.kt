package com.example.marvelapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvelapp.R
import com.example.marvelapp.model.Superheroe

class RecyclerViewAdapter (private  val isHorizontal:Boolean = false):
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

     var superheroes: MutableList<Superheroe> = ArrayList()
     lateinit var context: Context
     //Constructor
     fun RecyclerViewAdapter(superheroes: MutableList<Superheroe>,
                         context: Context){
         this.superheroes = superheroes
         this.context = context
     }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutRes = if (isHorizontal) R.layout.item_superheroe_horizontal else R.layout.item_superheroe
        return ViewHolder(LayoutInflater.from(context).
            inflate(layoutRes, parent, false))
    }

    override fun getItemCount(): Int {
        return superheroes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = superheroes.get(position)
        //holder.bindingAdapterPosition
        holder.bind(item)
    }

   inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val superheroeName:TextView =
            if (isHorizontal) view.findViewById(R.id.tvSuperheroHorizontal) else itemView.findViewById(R.id.tvSuperhero)
        val realName:TextView
                = if (isHorizontal) TextView(context) else itemView.findViewById(R.id.tvRealName)
        val publiser: TextView = if (isHorizontal) TextView(context) else itemView.findViewById(R.id.tvPublisher)
        val foto: ImageView = if (isHorizontal) itemView.findViewById(R.id.ivAvatarHorizontal) else itemView.findViewById(R.id.ivAvatar)

       fun bind(superheroe: Superheroe) {
           superheroeName.text = superheroe.nombre
           realName.text = superheroe.nombreReal
           publiser.text = superheroe.publisher
           foto.loadImage(superheroe.foto)
       }

       fun ImageView.loadImage(url: String) {
           Glide.with(context).load(url).into(this)
       }
    }
}


