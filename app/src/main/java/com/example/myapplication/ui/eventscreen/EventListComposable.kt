package com.example.myapplication.ui.eventscreen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.myapplication.ui.other.VideoComposable
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun EventScreen(eventListViewModel: EventListViewModel, navController:NavController) {

    val mutableVideos = eventListViewModel.streams.collectAsStateWithLifecycle()
    eventListViewModel.getEventsList()
    MyApplicationTheme {
        Scaffold(
            topBar = { Spacer(Modifier.height(20.dp)) },
            content = {
                Row(
                    Modifier
                        .padding(it)
                        .fillMaxWidth()){
                    LazyColumn{
                        itemsIndexed(mutableVideos.value){ _, video ->
                            VideoComposable(video = video, navController)
                        }
                    }
        }}
        )
    }

}
