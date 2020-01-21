package com.oncoding.movieapptest2.viw.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.oncoding.movieapptest2.viw.data.model.Movie
import com.oncoding.movieapptest2.viw.data.model.TopRatedMovies
import com.oncoding.movieapptest2.viw.data.repositroy.MovieRepositoryImpl

class MovieListViewModel(val rep: MovieRepositoryImpl = MovieRepositoryImpl()): ViewModel() {
    fun getTopMovies(): LiveData<TopRatedMovies> {
        return rep.getTopMovies()
    }

    fun getMovie(movieId: Int): LiveData<Movie> {
        return rep.getMovie(movieId)
    }

}