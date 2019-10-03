package com.post2shyam.reverbuzzy.screens.stationlist.internal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.jakewharton.rxbinding3.view.clicks
import com.post2shyam.reverbuzzy.R
import com.post2shyam.reverbuzzy.backend.radiobrowser.response.RadioBrowserRadioStationRsp
import io.reactivex.subjects.PublishSubject

class StationListAdapter : RecyclerView.Adapter<StationListAdapter.ViewHolder>() {

  val itemViewClickEvent = PublishSubject.create<RadioBrowserRadioStationRsp>()

  private var stationList: List<RadioBrowserRadioStationRsp> = ArrayList()

  fun update(stationList: List<RadioBrowserRadioStationRsp>) {
    this.stationList = stationList
    notifyDataSetChanged()
  }

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): ViewHolder {
    // create a new view
    val inflatedView = LayoutInflater.from(parent.context)
        .inflate(R.layout.station_view, parent, false)
    return ViewHolder(
        inflatedView
    )
  }

  override fun onBindViewHolder(
    viewHolder: ViewHolder,
    position: Int
  ) {
    viewHolder.stationName.text = stationList[position].name
    viewHolder.itemView.clicks() //viewHolder.itemView here You have access to view
        .map { stationList[position] }
        .subscribe(itemViewClickEvent)
  }

  override fun getItemCount(): Int = stationList.size

  override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
    //To avoid memory leaks
    itemViewClickEvent.onComplete()
    super.onDetachedFromRecyclerView(recyclerView)
  }

  class ViewHolder(parentView: View) : RecyclerView.ViewHolder(parentView) {

    @BindView(R.id.fav_icon)
    lateinit var stationImage: AppCompatImageView

    @BindView(R.id.station_name)
    lateinit var stationName: AppCompatTextView

    init {
      ButterKnife.bind(this, parentView)
    }
  }
}
