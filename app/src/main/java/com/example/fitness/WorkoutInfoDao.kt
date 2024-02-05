package com.example.fitness

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import java.util.Date


@Dao
interface WorkoutInfoDao {
    @Query("Select * from WorkoutInfo where date = :date")
    fun WorkoutInfoFromDate(date: Date) : Array<WorkoutInfo>

    @Insert
    fun insert(info:WorkoutInfo)
}