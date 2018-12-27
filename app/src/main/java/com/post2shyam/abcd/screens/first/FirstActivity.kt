package com.post2shyam.abcd.screens.first

import android.os.Bundle
import com.post2shyam.abcd.R
import com.post2shyam.abcd.screens.internal.BaseActivity
import com.post2shyam.abcd.system.localstore.IPersistentStoreManager
import dagger.android.AndroidInjection
import timber.log.Timber
import javax.inject.Inject

class FirstActivity : BaseActivity() {

    @Inject
    lateinit var persistentStoreManager: IPersistentStoreManager

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        //Local store transactions
        persistentStoreManager.setRollNumber(90)

        //Will appear only in debug app flavor
        Timber.d("Persisted RollNo is %d", persistentStoreManager.getRollNumber())

        //Will appear in all app flavors
        Timber.e("Persisted RollNo is %d", persistentStoreManager.getRollNumber())
    }
}
