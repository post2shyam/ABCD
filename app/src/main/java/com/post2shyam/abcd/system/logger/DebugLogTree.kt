package com.post2shyam.abcd.system.logger

import timber.log.Timber
import java.util.*


class DebugLogTree : Timber.DebugTree() {
    override fun createStackElementTag(element: StackTraceElement): String? {
        return String.format(
            Locale.US,
            "%s:%s:%s",
            element.fileName,
            element.lineNumber,
            Thread.currentThread().name
        )
    }
}