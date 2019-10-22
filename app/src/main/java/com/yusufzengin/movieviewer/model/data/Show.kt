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
    var id: Int,
    var name: String?,
    var popularity: Double?,
    var overview: String,
    @SerializedName("original_name")
    var originalName: String,
    @SerializedName("vote_count")
    var voteCount: Int?,
    @SerializedName("first_air_date")
    var firstAirDate: String?,
    @SerializedName("backdrop_path")
    var backdropPath: String?,
    @SerializedName("original_language")
    var originalLanguage: String?,
    @SerializedName("vote_average")
    var voteAverage: Double?,
    @SerializedName("poster_path")
    var posterPath: String?
) : Parcelable

fun Show.getPosterUrl() = "https://image.tmdb.org/t/p/w500/${this.posterPath}"