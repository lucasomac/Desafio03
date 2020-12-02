package br.com.lucolimac.desafio03.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.lucolimac.desafio03.R
import br.com.lucolimac.desafio03.domain.Result
import com.bumptech.glide.Glide

class ComicAdapter(val listener: OnClickComic) :
    RecyclerView.Adapter<ComicAdapter.ComicViewHolder>() {
    var listComic = ArrayList<Result>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.card_hq, parent, false)
        return ComicViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComicViewHolder, position: Int) {
        val comic = listComic[position]
        Glide.with(holder.itemView.context).asBitmap()
            .load("${comic.thumbnail.path}.${comic.thumbnail.extension}")
            .into(holder.ivThumb)
        holder.ivThumb.setImageResource(R.drawable.poster_filme)
        holder.tvNumber.text = "#${comic.id}"
//        Log.i("NUMBER", comic.)
    }

    override fun getItemCount() = listComic.size

    fun addComic(list: ArrayList<Result>) {
        listComic.addAll(list)
        listComic.forEach { it.thumbnail.path = it.thumbnail.path.replace("http", "https") }
        notifyDataSetChanged()
    }

    inner class ComicViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var ivThumb: ImageView = view.findViewById(R.id.ivThumb)
        var tvNumber: TextView = view.findViewById(R.id.tvNumber)
    }

    interface OnClickComic {
        fun onClickComic(position: Int)
    }
}