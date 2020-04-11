/*
 * Created By vpnhan at 10/4/2020.
 */

package com.estrouge.test.utopicacities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.estrouge.test.utopicacities.base.BaseActivity
import com.estrouge.test.utopicacities.databinding.ActivitySplashBinding
import com.estrouge.test.utopicacities.ui.home.HomeActivity
import com.estrouge.test.utopicacities.viewmodel.SplashViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SplashActivity(override val subLayoutId: Int = R.layout.activity_splash) :
    BaseActivity<ActivitySplashBinding, SplashViewModel>(SplashViewModel::class.java) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

        viewModel?.launch {
            delay(2000)

            this@SplashActivity.startActivity(
                Intent(this@SplashActivity, HomeActivity::class.java)
            )
        }
    }

}