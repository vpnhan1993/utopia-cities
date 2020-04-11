/*
 * Created By vpnhan at 10/4/2020.
 */

package com.estrouge.test.utopicacities.data.local.room

import android.app.Application
import android.content.Context
import androidx.room.*
import com.estrouge.test.utopicacities.data.local.room.UtopiaDatabase.Companion.VERSION
import com.estrouge.test.utopicacities.data.local.room.dao.CityDao
import com.estrouge.test.utopicacities.data.local.room.entity.City

@Database(version = VERSION, entities = [City::class], exportSchema = false)
abstract class UtopiaDatabase : RoomDatabase() {
    abstract fun cityDao(): CityDao

    companion object {
        const val NAME = "utopia_cities"
        const val VERSION = 1

        var instance: UtopiaDatabase? = null

        fun getInstance(context: Context): UtopiaDatabase {
            if (instance == null)
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    UtopiaDatabase::class.java,
                    NAME
                )
                    .createFromAsset("databases/utopia_cities.db")
                    .allowMainThreadQueries()
                    .build()

            return instance!!
        }

    }
}