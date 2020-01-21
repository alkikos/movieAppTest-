package com.oncoding.movieapptest2.viw.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.oncoding.movieapptest2.viw.data.model.Cast
import com.oncoding.movieapptest2.viw.data.repositroy.MovieRepositoryImpl

class MovieCastViewModel(private val rep: MovieRepositoryImpl =
                             MovieRepositoryImpl()) : ViewModel() {
    fun getMovieCast(movieId: Int): LiveData<Cast> {
        return rep.getMovieCast(movieId)
    }
}