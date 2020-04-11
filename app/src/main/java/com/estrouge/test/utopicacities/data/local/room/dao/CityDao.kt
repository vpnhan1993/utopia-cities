/*
 * Created By vpnhan at 10/4/2020.
 */

package com.estrouge.test.utopicacities.data.local.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.estrouge.test.utopicacities.data.local.room.entity.City

@Dao
interface CityDao {
    @Query("SELECT * FROM cities")
    fun getCities(): List<City>
}