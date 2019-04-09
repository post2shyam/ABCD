package com.post2shyam.abcd.screens.splash

import android.os.Bundle
import com.post2shyam.abcd.R
import com.post2shyam.abcd.screens.internal.BaseActivity
import com.post2shyam.abcd.screens.main.MainScreen
import dagger.android.AndroidInjection
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

class Splash : BaseActivity() {

    override val layoutRes: Int
        get() = R.layout.activity_splash

    private val TIMEOUT_INTERVAL = 2L

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        //Launch first activity after 2 seconds
        compositeDisposable.add(Observable.timer(TIMEOUT_INTERVAL, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { MainScreen.launch(this@Splash) })
    }
}
