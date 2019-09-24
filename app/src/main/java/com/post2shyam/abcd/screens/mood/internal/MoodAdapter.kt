package com.post2shyam.abcd.screens.mood.internal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.post2shyam.abcd.R
import com.post2shyam.abcd.backend.radiobrowser.response.RadioBrowserTagsRsp

class MoodAdapter : RecyclerView.Adapter<MoodAdapter.MoodViewHolder>() {

  private var moodList: List<RadioBrowserTagsRsp> = ArrayList()

  fun update(moodList: List<RadioBrowserTagsRsp>) {
    this.moodList = moodList
    notifyDataSetChanged()
  }

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): MoodViewHolder {
    // create a new view
    val inflatedView = LayoutInflater.from(parent.context)
        .inflate(R.layout.mood_view, parent, false)
    return MoodViewHolder(inflatedView)
  }

  override fun onBindViewHolder(
    moodViewHolder: MoodViewHolder,
    position: Int
  ) {
    moodViewHolder.stationCount.text = moodList[position].stationCount.toString()
    moodViewHolder.mood.text = moodList[position].tag
  }

  override fun getItemCount(): Int = moodList.size

  class MoodViewHolder(parentView: View) : RecyclerView.ViewHolder(parentView) {

    @BindView(R.id.station_count)
    lateinit var stationCount: AppCompatTextView

    @BindView(R.id.mood_title)
    lateinit var mood: AppCompatTextView

    init {
      ButterKnife.bind(this, parentView)
    }
  }
}