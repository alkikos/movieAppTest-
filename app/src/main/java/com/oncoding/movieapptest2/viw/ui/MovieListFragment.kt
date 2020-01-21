package com.oncoding.movieapptest2.viw.ui

import android.content.Context

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oncoding.movieapptest2.R
import com.oncoding.movieapptest2.viw.adapters.MovieListAdapter
import com.oncoding.movieapptest2.viw.data.model.Movie
import com.oncoding.movieapptest2.viw.viewmodel.MovieListViewModel
import kotlinx.android.synthetic.main.fragment_movie_list.*




class MovieListFragment : Fragment() {

    private var listener: OnFragmentInteractionListener? = null
    private var mAdapter = MovieListAdapter(mutableListOf(),{movie-> bla(movie)})
    private lateinit var recyclerView: RecyclerView
    lateinit var viewModel: MovieListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = movie_list
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = mAdapter


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }



    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }

        viewModel = ViewModelProviders.of(this).get(MovieListViewModel::class.java)
        viewModel.getTopMovies().observe(this, Observer {
            it?.let {
                val movieList = mutableListOf<Movie>()
                it.results.forEachIndexed{index, it ->
                    viewModel.getMovie(it.id).observe(this, Observer {
                        movieList.add(it)
                        if(index == 19) {
                            mAdapter.addMovies(movieList)
                        }
                    })
                }



            }
        })
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(movieId: Int)
    }

    companion object {

        fun newInstance() =
            MovieListFragment()
    }
    private fun bla(movieId: Int) {
        listener?.let {
            it.onFragmentInteraction(movieId)
        }
    }
}
