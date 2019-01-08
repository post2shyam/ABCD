package com.post2shyam.abcd.screens.splash

import android.os.Bundle
import com.post2shyam.abcd.R
import com.post2shyam.abcd.screens.first.FirstActivity
import com.post2shyam.abcd.screens.internal.BaseActivity
import dagger.android.AndroidInjection

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Launch first activity
        FirstActivity.launch(this)
    }
}
