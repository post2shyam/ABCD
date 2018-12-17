package com.post2shyam.internal

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import net.hockeyapp.android.CrashManager
import net.hockeyapp.android.UpdateManager

open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkForUpdates()
    }

    override fun onResume() {
        super.onResume()
        checkForCrashes()
    }

    override fun onPause() {
        super.onPause()
        unRegisterManagers()
    }

    override fun onDestroy() {
        super.onDestroy()
        unRegisterManagers()
    }

    private fun unRegisterManagers() {
        UpdateManager.unregister()
    }

    private fun checkForCrashes() {
        CrashManager.register(this)
    }

    private fun checkForUpdates() {
        UpdateManager.register(this)
    }
}