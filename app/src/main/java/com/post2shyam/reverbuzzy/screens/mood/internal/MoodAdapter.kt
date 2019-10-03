package com.post2shyam.reverbuzzy.screens.mood.internal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.jakewharton.rxbinding3.view.clicks
import com.post2shyam.reverbuzzy.R
import com.post2shyam.reverbuzzy.backend.radiobrowser.response.RadioBrowserTagsRsp
import io.reactivex.subjects.PublishSubject


class MoodAdapter : RecyclerView.Adapter<MoodAdapter.MoodViewHolder>() {

    val itemViewClickEvent = PublishSubject.create<RadioBrowserTagsRsp>()

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


        moodViewHolder.itemView.clicks() //viewHolder.itemView here You have access to view
            .map { moodList[position] }
            .subscribe(itemViewClickEvent)
    }

    override fun getItemCount(): Int = moodList.size

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        //To avoid memory leaks
        itemViewClickEvent.onComplete()
        super.onDetachedFromRecyclerView(recyclerView)
    }

    class MoodViewHolder(parentView: View) : RecyclerView.ViewHolder(parentView) {

        @BindView(R.id.station_name)
        lateinit var stationCount: AppCompatTextView

        @BindView(R.id.mood_title)
        lateinit var mood: AppCompatTextView

        init {
            ButterKnife.bind(this, parentView)
        }
    }
}