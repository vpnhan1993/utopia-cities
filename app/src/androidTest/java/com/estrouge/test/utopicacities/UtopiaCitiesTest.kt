package com.estrouge.test.utopicacities

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.estrouge.test.utopicacities.data.local.room.UtopiaDatabase
import com.estrouge.test.utopicacities.data.local.room.dao.CityDao
import org.junit.After

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import java.io.IOException

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class UtopiaCitiesTest {
    private lateinit var cityDao: CityDao
    private lateinit var db: UtopiaDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.databaseBuilder(
            context.applicationContext,
            UtopiaDatabase::class.java,
            UtopiaDatabase.NAME
        )
            .createFromAsset("databases/utopia_cities.db")
            .build()
        cityDao = db.cityDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun getAndCheckTotalRecord() {
        val total = cityDao.getCities().size
        assertEquals(total, 272128)
    }
}
