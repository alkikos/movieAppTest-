package com.oncoding.movieapptest2.viw.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.oncoding.movieapptest2.viw.data.model.Movie
import com.oncoding.movieapptest2.viw.data.repositroy.MovieRepositoryImpl

class MovieInfoViewModel(private val rep: MovieRepositoryImpl = MovieRepositoryImpl()) : ViewModel() {

    fun getMovie(movieId: Int): LiveData<Movie> {
        return rep.getMovie(movieId)
    }
}