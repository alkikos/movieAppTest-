package com.oncoding.movieapptest2.viw.ui

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oncoding.movieapptest2.R
import com.oncoding.movieapptest2.viw.adapters.MovieCastAdapter
import com.oncoding.movieapptest2.viw.data.model.CastX
import com.oncoding.movieapptest2.viw.viewmodel.MovieCastViewModel
import kotlinx.android.synthetic.main.fragment_movie_cast.*


private const val ARG_PARAM1 = "param1"


class MovieCastFragment : Fragment() {

    private var movieId: Int? = null
    private var listener: OnFragmentInteractionListener? = null
    private lateinit var recyclerView: RecyclerView
    private var adapter = MovieCastAdapter()
    private lateinit var viewModel: MovieCastViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = movie_cast_recycler
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_movie_cast, container, false)
    }



    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
        arguments?.let {
            movieId = it.getInt(ARG_PARAM1)
        }
        viewModel = ViewModelProviders.of(this).get(MovieCastViewModel::class.java)
        viewModel.getMovieCast(movieId!!).observe(this, Observer {
            adapter.addCast(it.cast)

        })
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    interface OnFragmentInteractionListener {

        fun onCastFragmentInteraction(uri: Uri)
    }

    companion object {

        fun newInstance(movieId: Int) =
            MovieCastFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, movieId)
                }
            }
    }
}
