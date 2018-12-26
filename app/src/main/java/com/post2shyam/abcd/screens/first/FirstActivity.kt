package com.post2shyam.abcd.screens.first

import android.os.Bundle
import com.post2shyam.abcd.R
import com.post2shyam.abcd.screens.internal.BaseActivity
import com.post2shyam.abcd.system.localstore.IPersistentStoreManager
import dagger.android.AndroidInjection
import javax.inject.Inject

class FirstActivity : BaseActivity() {

    @Inject
    lateinit var persistentStoreManager: IPersistentStoreManager

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        persistentStoreManager.getRollNumber()
    }
}
