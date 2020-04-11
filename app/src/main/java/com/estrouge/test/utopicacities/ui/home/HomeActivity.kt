/*
 * Created By vpnhan at 10/4/2020.
 */

package com.estrouge.test.utopicacities.ui.home

import android.os.Bundle
import com.estrouge.test.utopicacities.R
import com.estrouge.test.utopicacities.base.BaseActivity
import com.estrouge.test.utopicacities.data.local.room.UtopiaDatabase
import com.estrouge.test.utopicacities.databinding.ActivityHomeBinding
import com.estrouge.test.utopicacities.ui.home.listcities.CitiesAdapter
import com.estrouge.test.utopicacities.viewmodel.home.HomeViewModel
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeActivity(override val subLayoutId: Int = R.layout.activity_home) :
    BaseActivity<ActivityHomeBinding, HomeViewModel>(HomeViewModel::class.java) {

    private var adapter: CitiesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = CitiesAdapter(viewModel?.cities)
        rvCities?.adapter = adapter

        viewModel?.launch {
            showLoading()
            val startTime = System.currentTimeMillis()
            viewModel?.cities = withContext(Dispatchers.Default) {
                UtopiaDatabase.getInstance(this@HomeActivity).cityDao().getCities()
                    .toMutableList()
            }
            hideLoading()
            viewModel?.cities?.let { adapter?.update(it) }
            println("total Time: ${(System.currentTimeMillis() - startTime) / 1000}")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        adapter = null
    }
}