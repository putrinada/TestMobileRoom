package com.adl.testmobileroom.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.adl.testmobileroom.database.model.DataModel


@Dao
interface DataDao {
    @Insert
    fun insertData(data: DataModel)

    @Delete
    fun deleteData(data: DataModel)

    @Query("SELECT * FROM DataModel")
    fun getAll(): List<DataModel>
}


