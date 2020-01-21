package com.oncoding.movieapptest2.viw.data.repositroy

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.oncoding.movieapptest2.viw.data.model.Cast
import com.oncoding.movieapptest2.viw.data.model.Movie
import com.oncoding.movieapptest2.viw.data.model.TopRatedMovies
import com.oncoding.movieapptest2.viw.data.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MovieRepositoryImpl(): MovieRepositroy {
    override fun getMovieCast(movieId: Int): LiveData<Cast> {
        val result  = MutableLiveData<Cast>()

        retrofitClient.getMovieCast(movieId).enqueue(object : Callback<Cast?> {
            override fun onFailure(call: Call<Cast?>, t: Throwable) {

                Log.d("ale","herixaa")
            }

            override fun onResponse(call: Call<Cast?>, response: Response<Cast?>) {
                result.value = response.body()
                Log.d("ale","${response.body()}")

            }
        })

        return result
    }

    override fun getTopMovies(): LiveData<TopRatedMovies> {
        val result  = MutableLiveData<TopRatedMovies>()

        retrofitClient.getTopMovies().enqueue(object : Callback<TopRatedMovies?> {
            override fun onFailure(call: Call<TopRatedMovies?>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<TopRatedMovies?>,
                response: Response<TopRatedMovies?>
            ) {
                result.value = response.body()
            }
        })

        return result
    }

    private val retrofitClient = RetrofitClient()

    override fun getMovie(movieId: Int): LiveData<Movie> {
        val result  = MutableLiveData<Movie>()

        retrofitClient.getMovies(movieId).enqueue(object : Callback<Movie?> {
            override fun onFailure(call: Call<Movie?>, t: Throwable) {

            }

            override fun onResponse(call: Call<Movie?>, response: Response<Movie?>) {
                result.value = response.body()

            }
        })

        return result
    }


}
