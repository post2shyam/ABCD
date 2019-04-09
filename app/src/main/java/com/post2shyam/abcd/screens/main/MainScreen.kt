package com.post2shyam.abcd.screens.main

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import com.post2shyam.abcd.R
import com.post2shyam.abcd.backend.dirble.internal.DirbleRadioDirectoryServices
import com.post2shyam.abcd.screens.internal.BaseActivity
import com.post2shyam.abcd.screens.main.internal.PopularStationAdapter
import com.post2shyam.abcd.utils.addTo
import dagger.android.AndroidInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_mainscreen.*
import timber.log.Timber
import javax.inject.Inject

class MainScreen : BaseActivity() {

  override val layoutRes: Int
    get() = R.layout.activity_mainscreen

  @BindView(R.id.popular_station_list)
  lateinit var popularStationList: RecyclerView

  @Inject
  lateinit var dirbleRadioDirectoryServices: DirbleRadioDirectoryServices

  private val mediaPlayer = MediaPlayer()

  companion object {
    fun launch(baseActivity: BaseActivity) {
      val intent = Intent(baseActivity, MainScreen::class.java)
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

    //Will log tview user clicks for analytics.
    app_name_tview.setOnClickListener { view -> Timber.d("%s", view.tag) }

//    start_button.clicks()
//        .debounce(200, MILLISECONDS)
//        .switchMap {
//          dirbleRadioDirectoryServices.popularStations(0, 10, 0)
//              .subscribeOn(Schedulers.io())
//              .doOnNext { popularRadioStations: Array<PopularStationsRsp>? ->
//                Timber.d("Ok")
//                val url = popularRadioStations?.get(4)
//                    ?.streams?.get(0)
//                    ?.stream
//                mediaPlayer.apply {
//                  setAudioStreamType(AudioManager.STREAM_MUSIC)
//                  setDataSource(url)
//                  prepare() // takes long! (for buffering, etc)
//                  start()
//                }
//              }
//        }
//        .observeOn(AndroidSchedulers.mainThread())
//        .doOnError { Timber.e(it.cause) }
//        .subscribe()
//        .addTo(compositeDisposable)

  }

  private fun initUi() {
    popularStationList.setHasFixedSize(true)
    popularStationList.layoutManager = LinearLayoutManager(this@MainScreen)

    dirbleRadioDirectoryServices.popularStations(0, 10, 0)
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .doOnNext {
        popularStationList.adapter = PopularStationAdapter(it)
      }
      .doOnError { Timber.e(it.cause) }
      .subscribe()
      .addTo(compositeDisposable)
  }
}
