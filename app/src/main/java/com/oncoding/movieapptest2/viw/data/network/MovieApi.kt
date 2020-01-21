package com.oncoding.movieapptest2.viw.data.network

import com.oncoding.movieapptest2.viw.data.model.Cast
import com.oncoding.movieapptest2.viw.data.model.Movie
import com.oncoding.movieapptest2.viw.data.model.TopRatedMovies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    //top rated movies, list
    @GET(RetrofitClient.TOP_RATED_MOVIE)
    fun getTopRatedMovies(@Query("page") page: Int, @Query("api_key") api_key: String): Call<TopRatedMovies>

    //search movie
    @GET("movie/{movie_id}")
    fun getMovie(@Path("movie_id") id: Int, @Query("api_key") api_key: String): Call<Movie>

    @GET("movie/{movie_id}/images")
    fun getMovieImage(@Path("movie_id") id: Int, @Query("api_key") api_key: String)

    @GET("movie/{movie_id}/credits")
    fun getMovieCast(@Path("movie_id") id: Int,  @Query("api_key") api_key: String) : Call<Cast>

}