package com.oncoding.movieapptest2.viw.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.oncoding.movieapptest2.R
import com.oncoding.movieapptest2.viw.data.model.CastX
import com.oncoding.movieapptest2.viw.data.network.RetrofitClient
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_cast_element.view.*
import kotlinx.android.synthetic.main.movie_list_element.view.*

class MovieCastAdapter(private val cast: MutableList<CastX> = mutableListOf()) :
        RecyclerView.Adapter<MovieCastAdapter.CastHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_cast_element, parent, false)

        return CastHolder(view)
    }

    override fun getItemCount(): Int {
        return cast.size
    }

    override fun onBindViewHolder(holder: CastHolder, position: Int) {
        holder.bind(cast.get(position))
    }


    inner class CastHolder(val item: View) : RecyclerView.ViewHolder(item) {
        fun bind(castx: CastX) = with(item) {
            movie_cast_real_name.text = "real name: " + castx.name
            movie_cast_role_name.text = "role name: " + castx.character

            Log.d("ale",RetrofitClient.TMDB_IMAGEURL + castx.profilePath)

            if (castx.profilePath != null)
                Picasso.get().load(RetrofitClient.TMDB_IMAGEURL + castx.profilePath).into(movie_cast_image)
            else {
                movie_cast_image.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.ic_local_movies_gray,
                        null
                    )
                )
            }
        }
    }
    fun addCast(cast: List<CastX>) {
        this.cast.addAll(cast)
        notifyDataSetChanged()
    }
}



