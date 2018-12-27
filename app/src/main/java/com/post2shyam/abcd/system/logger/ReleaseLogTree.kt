package com.post2shyam.abcd.system.logger

import android.util.Log
import timber.log.Timber

class ReleaseLogTree : Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        when (priority) {
            Log.ASSERT -> Log.wtf(tag, message, t)
            //Only 2 levels of error logs
            Log.ERROR -> Log.e(tag, message, t)
            Log.WARN -> Log.w(tag, message, t)
            //Rest all levels will appear as Debug
            else -> Log.d(tag, message, t)
        }
    }
}