package com.oncoding.movieapptest2.viw.data.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Cast(
    @SerializedName("cast")
    @Expose
    var cast: List<CastX>,
    @SerializedName("id")
    @Expose
    var id: Int
)