/*
 * Created By vpnhan at 10/4/2020.
 */

package com.estrouge.test.utopicacities.viewmodel.home

import com.estrouge.test.utopicacities.base.BaseViewModel
import com.estrouge.test.utopicacities.data.local.room.entity.City

class HomeViewModel : BaseViewModel() {
    var cities: MutableList<City> = mutableListOf()
}