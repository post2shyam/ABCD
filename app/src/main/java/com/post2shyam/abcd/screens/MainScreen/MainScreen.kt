package com.post2shyam.abcd.screens.MainScreen

import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import com.jakewharton.rxbinding3.view.clicks
import com.post2shyam.abcd.R
import com.post2shyam.abcd.backend.dirble.interactions.response.PopularStationsRsp
import com.post2shyam.abcd.backend.dirble.internal.DirbleRadioDirectoryServices
import com.post2shyam.abcd.screens.internal.BaseActivity
import com.post2shyam.abcd.utils.addTo
import dagger.android.AndroidInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_mainscreen.hello_world_tview
import kotlinx.android.synthetic.main.activity_mainscreen.start_button
import timber.log.Timber
import java.util.concurrent.TimeUnit.MILLISECONDS
import javax.inject.Inject

class MainScreen : BaseActivity() {

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
    setContentView(R.layout.activity_mainscreen)

    //Will log tview user clicks for analytics.
    hello_world_tview.setOnClickListener { view -> Timber.d("%s", view.tag) }

    start_button.clicks()
      .debounce(200, MILLISECONDS)
      .switchMap {
        dirbleRadioDirectoryServices.popularStations()
          .subscribeOn(Schedulers.io())
          .doOnNext { popularRadioStations: Array<PopularStationsRsp>? ->
            Timber.d("Ok")
            val url = popularRadioStations?.get(4)?.streams?.get(0)?.stream
            mediaPlayer.apply {
              setAudioStreamType(AudioManager.STREAM_MUSIC)
              setDataSource(url)
              prepare() // takes long! (for buffering, etc)
              start()
            }
          }
      }
      .observeOn(AndroidSchedulers.mainThread())
      .doOnError { Timber.e("%s", "Error loading the stream", it.) }
      .subscribe()
      .addTo(compositeDisposable)
  }
}
