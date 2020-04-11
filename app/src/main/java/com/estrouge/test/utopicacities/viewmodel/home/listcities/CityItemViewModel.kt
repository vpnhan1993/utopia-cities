/*
 * Created By vpnhan at 10/4/2020.
 */

package com.estrouge.test.utopicacities.viewmodel.home.listcities

import androidx.lifecycle.MutableLiveData
import com.estrouge.test.utopicacities.base.BaseViewModel
import com.estrouge.test.utopicacities.data.local.room.entity.City

class CityItemViewModel : BaseViewModel() {
    val cityItem: MutableLiveData<City> by lazy { MutableLiveData<City>() }
}