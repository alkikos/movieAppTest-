package com.oncoding.movieapptest2.viw.ui

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.oncoding.movieapptest2.R
import kotlinx.android.synthetic.main.fragment_movie_details.*
import kotlinx.android.synthetic.main.fragment_movie_info.*

private const val ARG_PARAM1 = "movieId"

class MovieDetailsFragment : Fragment(), MovieInfoFragment.OnFragmentInteractionListener,
                                        MovieCastFragment.OnFragmentInteractionListener{

    override fun onCastFragmentInteraction(uri: Uri) {

    }

    override fun onInfoFragmentInteraction(uri: Uri) {

    }

    private var listener: OnFragmentInteractionListener? = null

    private var movieId: Int? = null

    private lateinit var infoButton: Button
    private lateinit var castButton: Button
    private lateinit var infoFragment: MovieInfoFragment
    private lateinit var castFragment: MovieCastFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            movieId = it.getInt(ARG_PARAM1)
        }

        Log.d("ale", "$movieId aba raa")
        castFragment = MovieCastFragment.newInstance(movieId?:1)
        infoFragment = MovieInfoFragment.newInstance(movieId?:1)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        infoButton = info_button
        castButton = cast_button


        infoButton.setOnClickListener{
            startMovieInfoFragment()
        }

        castButton.setOnClickListener{
            startMovieCastFragment()
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_details, container, false)
    }



    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }

    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onDetailsFragmentInteraction(uri: Uri)
    }

    companion object {

        fun newInstance(movieId: Int) =
            MovieDetailsFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, movieId)

                }
            }
    }

    private fun startMovieInfoFragment() {
        childFragmentManager.beginTransaction()
            .replace(R.id.infto_cast_cotainer, infoFragment)
            .disallowAddToBackStack()
            .commit()
    }

    private fun startMovieCastFragment() {
        childFragmentManager.beginTransaction()
            .replace(R.id.infto_cast_cotainer, castFragment)
            .disallowAddToBackStack()
            .commit()
    }
}
