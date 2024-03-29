package com.example.fitness

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.fitness.ui.theme.FitnessTheme
import java.util.Date

class CardDataUpdate : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            FitnessTheme {
                WorkoutCardUpdate()
                AddButton(this)
            }
        }
    }
}
@Composable
fun AddButton(cardDataUpdate: CardDataUpdate) {
    ConstraintLayout (modifier = Modifier.fillMaxSize()){
        val button = createRef()
        FloatingActionButton(
            onClick = { swapActivity(cardDataUpdate)},
            modifier = Modifier
                .constrainAs(button) {
                    absoluteRight.linkTo(parent.absoluteRight)
                    bottom.linkTo(parent.bottom)
                }
                .padding(15.dp),
            shape = CircleShape
        ) {
            Icon(Icons.Filled.Check, "Floating action button.")
        }
    }
}
fun swapActivity(cardDataUpdate: CardDataUpdate) {

    val db = DB.getDatabase(cardDataUpdate)
    val workoutDao = db.workoutInfoDao()
    workoutDao.insert(WorkoutInfo(Date(1,1,1),"Squat",8,8,8,135F,135F,145F))


    val intent = Intent(cardDataUpdate,MainActivity::class.java)
    ContextCompat.startActivity(cardDataUpdate, intent, null)
}

@Composable
fun WorkoutCardUpdate (){
    var name by rememberSaveable { mutableStateOf("") }
    var weight1 by rememberSaveable { mutableStateOf("") }
    var weight2 by rememberSaveable { mutableStateOf("") }
    var weight3 by rememberSaveable { mutableStateOf("") }
    var rep1 by rememberSaveable { mutableStateOf("") }
    var rep2 by rememberSaveable { mutableStateOf("") }
    var rep3 by rememberSaveable { mutableStateOf("") }



    Card (
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = Modifier
            .padding(all = 15.dp)
            .fillMaxWidth()
        //.defaultMinSize(minHeight = 150.dp)

    ){
        Row(modifier = Modifier.defaultMinSize(minHeight = 5.dp)){}
        Row (
            modifier = Modifier.defaultMinSize(minHeight = 43.3.dp),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Column (
                modifier = Modifier.weight(10F),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    singleLine = true,
                )
            }
        }
        Row(modifier = Modifier.defaultMinSize(minHeight = 5.dp)){}
        Row(
            modifier = Modifier.defaultMinSize(minHeight = 43.3.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Column (
                modifier = Modifier.weight(10F),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = weight1,
                    onValueChange = { weight1 = it },
                    singleLine = true,
                )
            }
            Column (
                modifier = Modifier.weight(10F),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                OutlinedTextField(
                    value = weight2,
                    onValueChange = { weight2 = it },
                    singleLine = true,
                )
            }
            Column (
                modifier = Modifier.weight(10F),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                OutlinedTextField(
                    value = weight3,
                    onValueChange = { weight3 = it },
                    singleLine = true,
                )
            }
        }
        Row(modifier = Modifier.defaultMinSize(minHeight = 5.dp)){}
        Row(
            modifier = Modifier.defaultMinSize(minHeight = 43.3.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Column (
                modifier = Modifier.weight(10F),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = rep1,
                    onValueChange = { rep1 = it },
                    singleLine = true,
                )
            }
            Column (
                modifier = Modifier.weight(10F),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                OutlinedTextField(
                    value = rep2,
                    onValueChange = { rep2 = it },
                    singleLine = true,
                )
            }
            Column (
                modifier = Modifier.weight(10F),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                OutlinedTextField(
                    value = rep3,
                    onValueChange = { rep3 = it },
                    singleLine = true,
                )
            }
        }
        Row(modifier = Modifier.defaultMinSize(minHeight = 5.dp)){}
    }
}
