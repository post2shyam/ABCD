package com.post2shyam.abcd.screens.MainScreen

import android.content.Intent
import android.os.Bundle
import com.jakewharton.rxbinding3.view.clicks
import com.post2shyam.abcd.R
import com.post2shyam.abcd.backend.dirble.interactions.response.PopularStationsRsp
import com.post2shyam.abcd.backend.dirble.internal.DirbleRadioDirectoryServices
import com.post2shyam.abcd.screens.internal.BaseActivity
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

  companion object {
    fun launch(baseActivity: BaseActivity) {
      val intent = Intent(baseActivity, MainScreen::class.java)
      baseActivity.startActivity(intent)
      baseActivity.finish()
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)

    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_mainscreen)

    //Will log tview user clicks for analytics.
    hello_world_tview.setOnClickListener { view -> Timber.d("%s", view.tag) }

    compositeDisposable.add(start_button.clicks()
        .debounce(200, MILLISECONDS)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe {
          Timber.d("Clicked")
          dirbleRadioDirectoryServices.popularStations()
              .subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe { it: Array<PopularStationsRsp>? -> Timber.d("%s", it?.get(0)?.name) }
//              .subscribe {popularStationRsp: PopularStationsRsp? ->  Timber.d("%s",
//                  popularStationRsp?.name
//              )}

        })
  }
}
