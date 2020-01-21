package com.oncoding.movieapptest2.viw.ui

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.oncoding.movieapptest2.R
import com.oncoding.movieapptest2.viw.data.network.RetrofitClient
import com.oncoding.movieapptest2.viw.viewmodel.MovieInfoViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_movie_info.*
import kotlinx.android.synthetic.main.movie_list_element.view.*


private const val ARG_PARAM1 = "movieId"

class MovieInfoFragment : Fragment() {

    private var movieId: Int? = null
    private val id: Int? = null

    private var listener: OnFragmentInteractionListener? = null
    private lateinit var viewModel: MovieInfoViewModel
    private lateinit var title: TextView
    private lateinit var genre: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_movie_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        title = movie_info_title
        genre = movie_info_genre

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
        viewModel = ViewModelProviders.of(this).get(MovieInfoViewModel::class.java)
        viewModel.getMovie(movieId?:2).observe(this, Observer {
            genre.text = it.genres[0].name
            title.text = it.title
            if (it.posterPath != null)
                Picasso.get().load(RetrofitClient.TMDB_IMAGEURL + it.posterPath).into(movie_info_image)
            else {
                movie_info_image.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.ic_local_movies_gray, null))
            }
        })
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    interface OnFragmentInteractionListener {
        fun onInfoFragmentInteraction(uri: Uri)
    }

    companion object {

        fun newInstance(movieId: Int) =
            MovieInfoFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, movieId)

                }
            }
    }
}
