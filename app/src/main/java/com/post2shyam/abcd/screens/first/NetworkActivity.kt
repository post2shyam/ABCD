package com.post2shyam.abcd.screens.first

import android.content.Intent
import android.os.Bundle
import com.post2shyam.abcd.R
import com.post2shyam.abcd.screens.internal.BaseActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_network.hello_world_tview
import timber.log.Timber

class NetworkActivity : BaseActivity() {
  companion object {
    fun launch(baseActivity: BaseActivity) {
      val intent = Intent(baseActivity, NetworkActivity::class.java)
      baseActivity.startActivity(intent)
      baseActivity.finish()
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)

    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_network)

    //Will log tview user clicks for analytics.
    hello_world_tview.setOnClickListener { view -> Timber.d("%s", view.tag) }
  }
}
