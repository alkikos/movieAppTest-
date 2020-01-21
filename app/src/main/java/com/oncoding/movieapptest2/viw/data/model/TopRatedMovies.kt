package com.oncoding.movieapptest2.viw.data.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TopRatedMovies(
    @SerializedName("page")
    @Expose
    var page: Int,
    @SerializedName("results")
    @Expose
    var results: List<ResultX>,
    @SerializedName("total_pages")
    @Expose
    var totalPages: Int,
    @SerializedName("total_results")
    @Expose
    var totalResults: Int
)