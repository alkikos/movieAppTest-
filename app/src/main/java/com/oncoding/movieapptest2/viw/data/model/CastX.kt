package com.oncoding.movieapptest2.viw.data.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CastX(
    @SerializedName("cast_id")
    @Expose
    var castId: Int,
    @SerializedName("character")
    @Expose
    var character: String,
    @SerializedName("credit_id")
    @Expose
    var creditId: String,
    @SerializedName("gender")
    @Expose
    var gender: Int,
    @SerializedName("id")
    @Expose
    var id: Int,
    @SerializedName("name")
    @Expose
    var name: String,
    @SerializedName("order")
    var order: Int,
    @SerializedName("profile_path")
    @Expose
    var profilePath: String? = null
)