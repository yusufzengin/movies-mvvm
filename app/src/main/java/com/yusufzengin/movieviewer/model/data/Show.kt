package com.yusufzengin.movieviewer.model.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "tv_shows")
data class Show(
    @PrimaryKey
    val id: Int,
    val name: String?,
    val popularity: Double?,
    val overview: String,
    @SerializedName("original_name")
    val originalName: String,
    @SerializedName("vote_count")
    val voteCount: Int?,
    @SerializedName("first_air_date")
    val firstAirDate: String?,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("original_language")
    val originalLanguage: String?,
    @SerializedName("vote_average")
    val voteAverage: Double?,
    @SerializedName("poster_path")
    val posterPath: String?
) : Parcelable

fun Show.getPosterUrl() = "https://image.tmdb.org/t/p/w500/${this.posterPath}"