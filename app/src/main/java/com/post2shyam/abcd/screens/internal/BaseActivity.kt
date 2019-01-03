package com.post2shyam.abcd.screens.internal

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.post2shyam.abcd.system.localstore.IPersistentStoreManager
import timber.log.Timber
import javax.inject.Inject

open class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var persistentStoreManager: IPersistentStoreManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("%s", this::class.simpleName)

        //Injection works in Base calls
        persistentStoreManager.setRollNumber(20)

        //Will appear under debug app flavor
        Timber.v("Persisted RollNo is %d", persistentStoreManager.getRollNumber())
    }
}