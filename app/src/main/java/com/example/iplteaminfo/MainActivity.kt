package com.example.iplteaminfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            IPLApp()
        }
    }
}

data class Team(
    val name: String,
    val city: String,
    val logo: Int,
    val color: Color
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IPLApp() {

    var isGrid by remember { mutableStateOf(false) }

    val teamList = listOf(
        Team("Chennai Super Kings", "Chennai", R.drawable.csk, Color(0xFFFFC107)),
        Team("Mumbai Indians", "Mumbai", R.drawable.mi, Color(0xFF1A237E)),
        Team("Royal Challengers Bangalore", "Bangalore", R.drawable.rcb, Color(0xFFD32F2F)),
        Team("Kolkata Knight Riders", "Kolkata", R.drawable.kkr, Color(0xFF512DA8)),
        Team("Rajasthan Royals", "Jaipur", R.drawable.rr, Color(0xFFE91E63)),
        Team("Delhi Capitals", "Delhi", R.drawable.dc, Color(0xFF1565C0)),
        Team("Punjab Kings", "Punjab", R.drawable.pbks, Color(0xFFD32F2F)),
        Team("Sunrisers Hyderabad", "Hyderabad", R.drawable.srh, Color(0xFFFF6F00))
    )

    Scaffold(

        topBar = {
            TopAppBar(
                title = { Text("IPL Teams Info") }
            )
        }

    ) { padding ->

        Box(modifier = Modifier.padding(padding)) {

//                TeamGridView(teamList)
                TeamListView(teamList)
        }

    }
}

@Composable
fun TeamListView(teamList: List<Team>) {

    LazyColumn {

        items(teamList) { team ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                colors = CardDefaults.cardColors(team.color),
                shape = RoundedCornerShape(12.dp)
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(16.dp)
                ) {

                    Image(
                        painter = painterResource(team.logo),
                        contentDescription = team.name,
                        modifier = Modifier.size(50.dp)
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Column {

                        Text(
                            text = team.name,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )

                        Text(
                            text = team.city,
                            fontSize = 14.sp,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TeamGridView(teamList: List<Team>) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(10.dp)
    ) {

        items(teamList) { team ->

            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(team.color),
                shape = RoundedCornerShape(12.dp)
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(20.dp)
                ) {

                    Image(
                        painter = painterResource(team.logo),
                        contentDescription = team.name,
                        modifier = Modifier.size(60.dp)
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = team.name,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text = "Home City",
                        fontSize = 12.sp,
                        color = Color.White
                    )
                }
            }
        }
    }
}