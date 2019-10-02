package com.post2shyam.reverbuzzy.screens.internal

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import butterknife.ButterKnife
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber

abstract class BaseActivity : AppCompatActivity() {

    protected abstract val layoutRes: Int

    val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("%s", this::class.simpleName)
        setContentView(layoutRes)
        ButterKnife.bind(this)
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