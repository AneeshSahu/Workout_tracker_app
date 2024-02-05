package com.example.fitness

import androidx.room.Entity
import java.util.Date

@Entity(primaryKeys = ["date", "name"])
data class WorkoutInfo(val date: Date,
                       val name: String,
                       val set1reps: Int, val set2reps: Int, val set3reps: Int,
                       val weight1: Float, val weight2: Float, val weight3: Float
    )