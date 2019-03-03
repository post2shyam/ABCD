package com.post2shyam.abcd.screens.internal

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.post2shyam.abcd.system.localstore.IPersistentStoreManager
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject

open class BaseActivity : AppCompatActivity() {

    val compositeDisposable = CompositeDisposable()

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


    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase!!))
    }

    override fun onDestroy() {
        //Free the memory
        compositeDisposable.dispose()
        super.onDestroy()
    }
}