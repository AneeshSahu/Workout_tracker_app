package com.example.fitness

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [WorkoutInfo::class],version = 1,exportSchema = false)
@TypeConverters(Converters::class)
abstract class DB:RoomDatabase() {
    abstract fun workoutInfoDao(): WorkoutInfoDao

    companion object {
        private var INSTANCE: DB? = null
        fun getDatabase(context: Context): DB {
            Log.d(null,"ENtered DB")
            if (INSTANCE == null) {
                Log.d(null,"No DB founf")
                synchronized(this) {
                    Log.d(null,"Syncronized")
                    INSTANCE =
                        Room.databaseBuilder(context,DB::class.java, "contact_database")
                            .allowMainThreadQueries().build()
                    Log.d(null,"Buildt")
                }
            }
            Log.d(null,"Return")
            return INSTANCE!!
        }
    }
}