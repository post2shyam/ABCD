package com.post2shyam.abcd.system.logger

import android.util.Log
import com.microsoft.appcenter.analytics.Analytics
import timber.log.Timber
import java.util.*


class AnalyticsLogTree : Timber.Tree() {
    override fun isLoggable(tag: String?, priority: Int): Boolean {
        //Ignore the lower log levels completely
        return priority > Log.VERBOSE
    }

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        when (priority) {
            //Point to default system wtf handler
            Log.ASSERT -> Log.wtf(tag, message, t)

            //For ERROR and WARN capture the stacktrace as part of analytics
            Log.ERROR -> {
                Log.e(tag, message, t)
                val properties = HashMap<String, String?>()
                properties["LOCATION"] = tag
                properties["MESSAGE"] = message
                Analytics.trackEvent("ERROR", properties)
            }

            Log.WARN -> {
                Log.w(tag, message, t)
                val properties = HashMap<String, String?>()
                properties["LOCATION"] = tag
                properties["MESSAGE"] = message
                Analytics.trackEvent("WARN", properties)
            }

            //NOTE: Should be used to record screen transitions only
            Log.INFO -> {
                Log.i(tag, message, t)
                val properties = HashMap<String, String?>()
                properties["LOCATION"] = tag
                Analytics.trackEvent("SCREEN", properties)
            }

            //NOTE: Should be used to record user-inputs (like button clicks)
            Log.DEBUG -> {
                Log.d(tag, message, t)
                val properties = HashMap<String, String?>()
                properties["LOCATION"] = tag
                Analytics.trackEvent("USER-INTERACTION", properties)
            }
        }
    }
}