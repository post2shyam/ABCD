package com.post2shyam.abcd.screens.splash

import android.os.Bundle
import com.post2shyam.abcd.R
import com.post2shyam.abcd.screens.first.FirstActivity
import com.post2shyam.abcd.screens.internal.BaseActivity
import dagger.android.AndroidInjection
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Launch first activity after 2 seconds
        compositeDisposable.add(Observable.timer(2L, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { FirstActivity.launch(this@SplashActivity) })
    }
}
