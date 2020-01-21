package com.oncoding.movieapptest2.viw.data.repositroy

import androidx.lifecycle.LiveData
import com.oncoding.movieapptest2.viw.data.model.Cast
import com.oncoding.movieapptest2.viw.data.model.Movie
import com.oncoding.movieapptest2.viw.data.model.TopRatedMovies


interface MovieRepositroy {

    fun getMovie(movieId: Int): LiveData<Movie>
    fun getTopMovies(): LiveData<TopRatedMovies>
    fun getMovieCast(movieId: Int): LiveData<Cast>

}