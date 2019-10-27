package com.post2shyam.reverbuzzy.screens.mood

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import com.post2shyam.reverbuzzy.R
import com.post2shyam.reverbuzzy.backend.radiobrowser.RadioBrowserDirectoryServices
import com.post2shyam.reverbuzzy.backend.radiobrowser.response.RadioBrowserTagsRsp
import com.post2shyam.reverbuzzy.screens.internal.BaseActivity
import com.post2shyam.reverbuzzy.screens.mood.internal.MoodAdapter
import com.post2shyam.reverbuzzy.screens.stationlist.StationListActivity
import com.post2shyam.reverbuzzy.utils.addTo
import dagger.android.AndroidInjection
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class MoodListActivity : BaseActivity() {

  override val layoutRes = R.layout.activity_moodlist

  @BindView(R.id.mood_list)
  lateinit var moodListView: RecyclerView

  @Inject
  lateinit var moodAdapter: MoodAdapter

  @Inject
  lateinit var radioBrowserDirectoryServices: RadioBrowserDirectoryServices

  companion object {
    fun launch(baseActivity: BaseActivity) {
      val intent = Intent(baseActivity, MoodListActivity::class.java)
      baseActivity.startActivity(intent)
      baseActivity.finish()
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
    super.onCreate(savedInstanceState)

    initUi()

    refreshMoodList()
  }

  private fun initUi() {
    moodAdapter.itemViewClickEvent.subscribe { radioBrowserTagsRsp ->
      StationListActivity.launch(this, radioBrowserTagsRsp.tag)
    }
        .addTo(compositeDisposable)

    moodListView.setHasFixedSize(true)
    moodListView.layoutManager = LinearLayoutManager(this@MoodListActivity)
    moodListView.adapter = moodAdapter

  }

  private fun refreshMoodList() {
    radioBrowserDirectoryServices.getAllTags(true)
        .doOnError { Timber.e(it.cause) }
        .flatMap {
          Observable.fromArray(
              it.sortedWith(compareByDescending(RadioBrowserTagsRsp::stationCount))
          )
        }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .doOnNext {
          moodAdapter.update(it)
        }
        .subscribe()
        .addTo(compositeDisposable)
  }
}
