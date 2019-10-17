package com.post2shyam.reverbuzzy.screens.stationlist

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import com.post2shyam.reverbuzzy.R
import com.post2shyam.reverbuzzy.backend.radiobrowser.RadioBrowserDirectoryServices
import com.post2shyam.reverbuzzy.screens.internal.BaseActivity
import com.post2shyam.reverbuzzy.screens.stationlist.internal.StationListAdapter
import com.post2shyam.reverbuzzy.utils.addTo
import dagger.android.AndroidInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class StationListActivity : BaseActivity() {

  override val layoutRes = R.layout.activity_stationlist

  @BindView(R.id.mood_list)
  lateinit var stationListView: RecyclerView

  @Inject
  lateinit var stationListAdapter: StationListAdapter

  @Inject
  lateinit var radioBrowserDirectoryServices: RadioBrowserDirectoryServices

  private val mediaPlayer = MediaPlayer()

  companion object {

    const val TAG: String = "TAG"

    fun launch(
      baseActivity: BaseActivity,
      tag: String
    ) {
      val intent = Intent(baseActivity, StationListActivity::class.java)
      intent.putExtra(TAG, tag)
      baseActivity.startActivity(intent)
      baseActivity.finish()
    }
  }

  override fun onDestroy() {
    mediaPlayer.release()
    super.onDestroy()
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
    super.onCreate(savedInstanceState)

    initUi()

    refreshStationList()
  }

  private fun initUi() {

    stationListAdapter
        .itemViewClickEvent
        .switchMap {
          Timber.d(it.stationuuid)
          radioBrowserDirectoryServices
              .getPlayableStationUrl(it.stationuuid)
              .subscribeOn(Schedulers.io())
        }
        .doOnNext {
          mediaPlayer.apply {
            Timber.d(it.stationUrl)
            //setAudioStreamType(AudioManager.STREAM_MUSIC)
            setDataSource(it.stationUrl)
            prepare() // takes long! (for buffering, etc)
            start()
          }
        }
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            { },
            { exception ->
              Toast.makeText(this, exception.localizedMessage, Toast.LENGTH_SHORT)
                  .show()
            })
        .addTo(compositeDisposable)

    stationListView.setHasFixedSize(true)
    stationListView.layoutManager = LinearLayoutManager(this@StationListActivity)
    stationListView.adapter = stationListAdapter

  }

  private fun refreshStationList() {
    //Based on the current mood populate the list
    val tag = intent.extras?.getString(TAG)
    radioBrowserDirectoryServices
        .getStationList(true, tag!!, 0, 100) //TODO: NPE possibility here
        .doOnError { Timber.e(it.cause) }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .doOnNext {
          stationListAdapter.update(it.toList())
        }
        .subscribe()
        .addTo(compositeDisposable)
  }
}