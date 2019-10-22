package com.yusufzengin.movieviewer.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yusufzengin.movieviewer.R
import com.yusufzengin.movieviewer.model.data.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieListAdapter : ListAdapter<Movie, MovieListAdapter.ViewHolder>(
    DiffUtilCallback()
) {
    private lateinit var listener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
    }

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(movie: Movie) {
            Glide.with(view.context).load("https://image.tmdb.org/t/p/w500/${movie.posterPath}")
                .error(R.drawable.ic_launcher_foreground)
                .into(view.image)
            itemView.title_tv.text = movie.title
            //itemView.release_date_tv.text = movie.releaseDate?.formatDate() ?: "-"
            itemView.vote_average_tv.text = "Rating: ${movie.voteAverage.toString()}"
            itemView.setOnClickListener { listener.onItemClicked(movie) }
        }

    }

    interface OnItemClickListener {
        fun onItemClicked(movie: Movie)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    class DiffUtilCallback: DiffUtil.ItemCallback<Movie>() {

        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.equals(newItem)
        }
    }


}