package com.post2shyam.reverbuzzy.system.localstore.internal

import android.app.Application
import android.content.Context
import com.post2shyam.reverbuzzy.BuildConfig
import com.post2shyam.reverbuzzy.system.localstore.IPersistentStoreManager

class SharedPreferenceStoreManager(application: Application) : IPersistentStoreManager {

  private val sharedPreferences =
    application.getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE)

  private val sharedPrefEditor = sharedPreferences.edit()

  private val ROLE_KEY = "ROLE_KEY"

  override fun setRollNumber(rollNumber: Int) {
    sharedPrefEditor.putInt(ROLE_KEY, rollNumber)
    sharedPrefEditor.apply()
  }

  override fun getRollNumber(): Int {
    return sharedPreferences.getInt(ROLE_KEY, 0)
  }
}