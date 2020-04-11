/*
 * Created By vpnhan at 10/4/2020.
 */

package com.estrouge.test.utopicacities.data.local.room.entity

import androidx.annotation.NonNull
import androidx.room.*

@Entity(tableName = "cities")
data class City(
    @NonNull
    @PrimaryKey
    val id: String,
    val country: String?,
    val city: String?,
    val population: Int?
)