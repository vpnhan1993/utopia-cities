/*
 * Created By vpnhan at 10/4/2020.
 */

package com.estrouge.test.utopicacities.ui.home.listcities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.estrouge.test.utopicacities.R
import com.estrouge.test.utopicacities.base.BaseRvAdapter
import com.estrouge.test.utopicacities.data.local.room.entity.City
import com.estrouge.test.utopicacities.databinding.RvItemCityBinding
import com.estrouge.test.utopicacities.viewmodel.home.listcities.CityItemViewModel

class CitiesAdapter(listCities: MutableList<City>?) :
    BaseRvAdapter<City, CityItemViewModel, CitiesAdapter.CityHolder>(listCities) {

    override fun onCreate(parent: ViewGroup, viewType: Int): ViewDataBinding {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.rv_item_city,
            parent,
            false
        )
    }

    override fun onNewInstanceHolder(binding: ViewDataBinding): CityHolder {
        return CityHolder(binding as RvItemCityBinding)
    }

    class CityHolder(bindingHolder: RvItemCityBinding) :
        BaseRvAdapter.BaseHolder<City, CityItemViewModel>(bindingHolder) {

        override fun bind(t: City?) {
            itemViewModel = CityItemViewModel()
            itemViewModel?.cityItem?.value = t
            super.bind(t)
        }
    }
}