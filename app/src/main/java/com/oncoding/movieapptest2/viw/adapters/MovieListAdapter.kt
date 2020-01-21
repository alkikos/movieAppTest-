package com.oncoding.movieapptest2.viw.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.oncoding.movieapptest2.R
import com.oncoding.movieapptest2.viw.data.model.Movie

import com.oncoding.movieapptest2.viw.data.model.ResultX
import com.oncoding.movieapptest2.viw.data.network.RetrofitClient
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_list_element.view.*

class MovieListAdapter(private val movies: MutableList<Movie>,
                       private var listener: (Int) -> Unit) : RecyclerView.Adapter<MovieListAdapter.MovieHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_list_element, parent, false)

        Log.d("ale","1")
        return MovieHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(movies.get(position))
    }

    fun addMovies(movies: List<Movie>){
        this.movies.addAll(movies)
        notifyDataSetChanged()
    }
    inner class MovieHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(movie: Movie) = with(view) {
            movie_title.text = movie.title
            movie_image.setOnClickListener{
                listener(movie.id)
            }
            if (movie.posterPath != null)
                Picasso.get().load(RetrofitClient.TMDB_IMAGEURL + movie.posterPath).into(movie_image)
            else {
                movie_image.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.ic_local_movies_gray, null))
            }
        }
    }
}

