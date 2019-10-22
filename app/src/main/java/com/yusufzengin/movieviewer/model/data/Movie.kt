package com.yusufzengin.movieviewer.model.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "movies")
data class Movie(
    @PrimaryKey
    var id: Int,
    var title: String,
    var overview: String,
    var adult: Boolean?,
    var budget: Int?,
    var homepage: String?,
    var status: String?,
    @SerializedName("original_language")
    var originalLanguage: String?,
    @SerializedName("original_title")
    var originalTitle: String?,
    @SerializedName("poster_path")
    var posterPath: String?,
    @SerializedName("release_date")
    var releaseDate: String?,
    @SerializedName("vote_average")
    var voteAverage: Double?,
    @SerializedName("vote_count")
    var voteCount: Int?
) : Parcelable

fun Movie.getPosterUrl() = "https://image.tmdb.org/t/p/w500/${this.posterPath}"