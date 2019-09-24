package com.post2shyam.abcd.screens.main

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import com.post2shyam.abcd.R
import com.post2shyam.abcd.backend.radiobrowser.RadioBrowserDirectoryServices
import com.post2shyam.abcd.backend.radiobrowser.response.RadioBrowserTagsRsp
import com.post2shyam.abcd.screens.internal.BaseActivity
import com.post2shyam.abcd.screens.main.internal.MoodAdapter
import com.post2shyam.abcd.utils.addTo
import dagger.android.AndroidInjection
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class MainScreen : BaseActivity() {

    override val layoutRes = R.layout.activity_mainscreen

    @BindView(R.id.mood_list)
    lateinit var moodListView: RecyclerView

    @Inject
    lateinit var moodAdapter: MoodAdapter

//    @Inject
//    lateinit var dirbleRadioDirectoryServices: DirbleRadioDirectoryServices

    @Inject
    lateinit var radioBrowserDirectoryServices: RadioBrowserDirectoryServices

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

        refreshMoodList()

        //Will log tview user clicks for analytics.
        //app_name_tview.setOnClickListener { view -> Timber.d("%s", view.tag) }

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

    //Dirble.com is dead unfortunately !

    //  private fun initUi() {
//    moodListView.setHasFixedSize(true)
//    moodListView.layoutManager = LinearLayoutManager(this@MainScreen)
//
//    dirbleRadioDirectoryServices.popularStations(0, 10, 0)
//      .subscribeOn(Schedulers.io())
//      .observeOn(AndroidSchedulers.mainThread())
//      .doOnNext {
//        moodListView.adapter = MoodAdapter(it)
//      }
//      .doOnError { Timber.e(it.cause) }
//      .subscribe()
//      .addTo(compositeDisposable)
//  }
    private fun initUi() {
        moodListView.setHasFixedSize(true)
        moodListView.layoutManager = LinearLayoutManager(this@MainScreen)
        moodListView.adapter = moodAdapter
    }

    private fun refreshMoodList() {
        radioBrowserDirectoryServices.getAllTags(true)
            .doOnError { Timber.e(it.cause) }
            .flatMap {
                Observable.fromArray(it.sortedWith(compareByDescending(RadioBrowserTagsRsp::stationCount)))
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
