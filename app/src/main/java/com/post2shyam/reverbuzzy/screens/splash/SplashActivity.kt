package com.post2shyam.reverbuzzy.screens.splash

import android.os.Bundle
import android.widget.TextView
import butterknife.BindView
import com.post2shyam.reverbuzzy.BuildConfig
import com.post2shyam.reverbuzzy.R
import com.post2shyam.reverbuzzy.R.string
import com.post2shyam.reverbuzzy.screens.internal.BaseActivity
import com.post2shyam.reverbuzzy.screens.mood.MoodListActivity
import dagger.android.AndroidInjection
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

class SplashActivity : BaseActivity() {

  override val layoutRes = R.layout.activity_splash

  private val timeoutInterval = 2L

  @BindView(R.id.version_tview)
  lateinit var versionText: TextView

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
    super.onCreate(savedInstanceState)

    //Update version info from build config
    versionText.text = getString(string.version).format(BuildConfig.VERSION_NAME)

    //Launch first activity after 2 seconds
    compositeDisposable.add(
        Observable.timer(timeoutInterval, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { MoodListActivity.launch(this@SplashActivity) })
  }
}
