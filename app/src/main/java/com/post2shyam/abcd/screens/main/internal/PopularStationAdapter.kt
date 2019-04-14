package com.post2shyam.abcd.screens.main.internal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.post2shyam.abcd.R
import com.post2shyam.abcd.backend.dirble.interactions.response.PopularStationsRsp
import com.squareup.picasso.Picasso

class PopularStationAdapter(private val popularStationList: Array<PopularStationsRsp>) :
    RecyclerView.Adapter<PopularStationAdapter.PopularStationViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularStationViewHolder {
        // create a new view
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.popular_station_view, parent, false)
        return PopularStationViewHolder(textView)
    }

    override fun onBindViewHolder(popularStationViewHolder: PopularStationViewHolder, position: Int) {
        popularStationViewHolder.stationName.text = popularStationList[position].name
        Picasso.get()
            .load(popularStationList[position].image.thumb.url)
            .placeholder(R.mipmap.ic_launcher)
            .into(popularStationViewHolder.stationThumbImage)
    }

    override fun getItemCount(): Int = popularStationList.size

    class PopularStationViewHolder(parentView: View) : RecyclerView.ViewHolder(parentView) {

        @BindView(R.id.station_name)
        lateinit var stationName: AppCompatTextView

        @BindView(R.id.station_thumb_image)
        lateinit var stationThumbImage: AppCompatImageView

        init {
            ButterKnife.bind(this, parentView)
        }
    }
}