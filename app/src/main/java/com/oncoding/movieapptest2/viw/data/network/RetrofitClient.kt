package com.oncoding.movieapptest2.viw.data.network

import android.R.attr.apiKey
import com.oncoding.movieapptest2.viw.data.model.Movie

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit

import retrofit2.converter.gson.GsonConverterFactory

import okhttp3.logging.HttpLoggingInterceptor
import android.R.attr.tag
import com.oncoding.movieapptest2.viw.data.model.Cast
import com.oncoding.movieapptest2.viw.data.model.TopRatedMovies


class RetrofitClient {

    private val moviesApi: MovieApi

    companion object {
        const val API_KEY = "7fabd36d89902f10a7d0701c7d99188d"
        const val TMDB_BASE_URL = "https://api.themoviedb.org/3/"
        const val TOP_RATED_MOVIE = "movie/top_rated"
        const val TMDB_IMAGEURL = "https://image.tmdb.org/t/p/w500/"
    }


    init {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BASIC
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()


        val retrofit = Retrofit.Builder()
            .baseUrl(TMDB_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        moviesApi = retrofit.create(MovieApi::class.java)
    }

    fun getMovies(movieId : Int): Call<Movie> {
        return moviesApi.getMovie(movieId, API_KEY)
    }

    fun getTopMovies(): Call<TopRatedMovies> {
        return moviesApi.getTopRatedMovies(1, API_KEY)
    }

    fun getMovieCast(movieId: Int): Call<Cast> {
        return moviesApi.getMovieCast(movieId, API_KEY)
    }

}
