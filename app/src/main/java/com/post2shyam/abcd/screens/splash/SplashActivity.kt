package com.post2shyam.abcd.screens.splash

import android.os.Bundle
import com.post2shyam.abcd.R
import com.post2shyam.abcd.screens.internal.BaseActivity
import com.post2shyam.abcd.screens.mood.MoodListActivity
import dagger.android.AndroidInjection
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

class SplashActivity : BaseActivity() {

  override val layoutRes = R.layout.activity_splash

  private val timeout_interval = 2L

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
    super.onCreate(savedInstanceState)

    //Launch first activity after 2 seconds
    compositeDisposable.add(Observable.timer(timeout_interval, TimeUnit.SECONDS)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe { MoodListActivity.launch(this@SplashActivity) })
  }
}
