package com.oncoding.movieapptest2.viw.ui

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.oncoding.movieapptest2.R
import com.oncoding.movieapptest2.viw.data.model.Movie
import com.oncoding.movieapptest2.viw.data.model.TopRatedMovies
import com.oncoding.movieapptest2.viw.data.network.RetrofitClient
import com.oncoding.movieapptest2.viw.data.repositroy.MovieRepositoryImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), MovieListFragment.OnFragmentInteractionListener,
                                            MovieDetailsFragment.OnFragmentInteractionListener,
                                                MovieInfoFragment.OnFragmentInteractionListener,
                                                    MovieCastFragment.OnFragmentInteractionListener{
    override fun onCastFragmentInteraction(uri: Uri) {

    }

    override fun onInfoFragmentInteraction(uri: Uri) {

    }

    override fun onDetailsFragmentInteraction(uri: Uri) {

    }

    override fun onFragmentInteraction(movieId: Int) {
        movieDetailsFragment = MovieDetailsFragment.newInstance(movieId)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, movieDetailsFragment)
            .addToBackStack(null)
            .commit()
    }

    lateinit var movieDetailsFragment: MovieDetailsFragment
    lateinit var movieListFragment: MovieListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        movieListFragment = MovieListFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, movieListFragment)
            .disallowAddToBackStack()
            .commit()

    }


}
