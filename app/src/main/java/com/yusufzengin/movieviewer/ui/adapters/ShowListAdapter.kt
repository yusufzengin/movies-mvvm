package com.yusufzengin.movieviewer.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yusufzengin.movieviewer.R
import com.yusufzengin.movieviewer.model.data.Show
import com.yusufzengin.movieviewer.model.data.getPosterUrl
import com.yusufzengin.movieviewer.util.formatDate
import com.yusufzengin.movieviewer.util.loadFromUrl
import kotlinx.android.synthetic.main.item_show.view.*

class ShowListAdapter : ListAdapter<Show, ShowListAdapter.ViewHolder>(
    DiffUtilCallback()
) {
    private lateinit var listener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_show, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val show = getItem(position)
        holder.bind(show)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(show: Show) {
            itemView.image.loadFromUrl(show.getPosterUrl())
            itemView.title_tv.text = show.originalName
            itemView.release_date_tv.text = show.firstAirDate?.formatDate() ?: "-"
            itemView.vote_average_tv.text = "Rating: ${show.voteAverage.toString()}"
            itemView.setOnClickListener { listener.onItemClicked(show) }
        }

    }

    interface OnItemClickListener {
        fun onItemClicked(show: Show)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    class DiffUtilCallback: DiffUtil.ItemCallback<Show>() {

        override fun areItemsTheSame(oldItem: Show, newItem: Show): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Show, newItem: Show): Boolean {
            return oldItem.equals(newItem)
        }
    }


}