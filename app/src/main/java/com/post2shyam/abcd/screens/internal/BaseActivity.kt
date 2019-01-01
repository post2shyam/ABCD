package com.post2shyam.abcd.screens.internal

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import timber.log.Timber

open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("Created: %s", this::class.simpleName)

        checkForUpdates()
    }

    override fun onDestroy() {
        Timber.i("Destroyed: %s", this::class.simpleName)
        super.onDestroy()
    }


    private fun checkForUpdates() {
        //TODO
    }
}