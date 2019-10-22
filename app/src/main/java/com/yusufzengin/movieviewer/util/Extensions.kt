package com.yusufzengin.movieviewer.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.yusufzengin.movieviewer.model.data.Movie
import java.text.SimpleDateFormat
import java.util.*

fun String.formatDate(): String? {
    val inDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val outDateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())

    var reformattedStr = this
    try {
        reformattedStr = outDateFormat.format(inDateFormat.parse(this))
    } catch (e: Exception) {
        e.printStackTrace()
    }

    return reformattedStr
}

fun ImageView.loadFromUrl(url: String, errorDrawable: Int = 0) =
    Glide.with(this.context.applicationContext)
        .load(url)
        .error(errorDrawable)
        //.transition(DrawableTransitionOptions.withCrossFade())
        .into(this)

