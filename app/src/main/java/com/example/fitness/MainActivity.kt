package com.example.fitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitness.ui.theme.FitnessTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FitnessTheme {
                // A surface container using the 'background' color from the theme
                /*Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    WorkoutCard()
                }*/
                var weight = mutableListOf<Float>(165F,165F,165F)

                var reps = mutableListOf<Int>(16,16,16)

                LazyColumn{
                    item(){
                        WorkoutCard(name = "bench", weights = weight, reps = reps)
                    }
                    item(){
                        WorkoutCard(name = "bench", weights = weight, reps = reps)
                    }
                    item(){
                        WorkoutCard(name = "bench", weights = weight, reps = reps)
                    }
                }

            }
        }
    }
}

@Composable
fun WorkoutCard (name: String, weights : List<Float>, reps : List<Int>){
    Card (
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = Modifier
            .padding(all = 15.dp)
            .fillMaxWidth()
            //.defaultMinSize(minHeight = 150.dp)

    ){
        Row (
            modifier = Modifier.defaultMinSize(minHeight = 50.dp),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Column (
                modifier = Modifier.weight(10F),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(name, fontSize = 25.sp)
            }
        }
        Row(
            modifier = Modifier.defaultMinSize(minHeight = 50.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Column (
                modifier = Modifier.weight(10F),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(weights[0].toString())
            }
            Column (
                modifier = Modifier.weight(10F),
                horizontalAlignment = Alignment.CenterHorizontally
                //modifier = Modifier.fillMaxWidth()
            ){
                Text(weights[1].toString())
            }
            Column (
                modifier = Modifier.weight(10F),
                horizontalAlignment = Alignment.CenterHorizontally
                //modifier = Modifier.fillMaxWidth()
            ){
                Text(weights[2].toString())
            }
        }
        Row(
            modifier = Modifier.defaultMinSize(minHeight = 50.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Column (
                modifier = Modifier.weight(10F),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(reps[0].toString())
            }
            Column (
                modifier = Modifier.weight(10F),
                horizontalAlignment = Alignment.CenterHorizontally
                //modifier = Modifier.fillMaxWidth()
            ){
                Text(reps[1].toString())
            }
            Column (
                modifier = Modifier.weight(10F),
                horizontalAlignment = Alignment.CenterHorizontally
                //modifier = Modifier.fillMaxWidth()
            ){
                Text(reps[2].toString())
            }
        }

    }
}