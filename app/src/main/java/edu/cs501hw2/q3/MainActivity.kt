package edu.cs501hw2.q3

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.cs501hw2.q3.ui.theme.Q3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Q3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MusicPlayerScreen(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun MusicPlayerScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AlbumCover(painterResource(id = R.drawable.joker_xue), Modifier.fillMaxWidth().height(300.dp))

        Spacer(Modifier.height(24.dp))

        SongInfo("Nothing", "Joker Xue")

        Spacer(Modifier.height(32.dp))

        PlaybackProgress()

        Spacer(Modifier.height(32.dp))

        PlayerControls()
    }
}

@Composable
fun AlbumCover(painter: Painter, modifier: Modifier = Modifier) {
    Box(modifier) {
        Image(painter, "Album Cover", Modifier.fillMaxSize())
    }
}

@Composable
fun SongInfo(title: String, artist: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = title, style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(8.dp))
        
        Text(text = artist, style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
fun PlaybackProgress() {
    Column(modifier = Modifier.fillMaxWidth()) {
        LinearProgressIndicator(
            progress = { 0.28f }, modifier = Modifier.fillMaxWidth().height(4.dp), color = MaterialTheme.colorScheme.primary)

        Spacer(modifier = Modifier.height(8.dp))

        Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
            Text(text = "1:09", style = MaterialTheme.typography.bodySmall)

            Text(text = "3:59", style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Composable
fun PlayerControls() {
    val context = LocalContext.current
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ) {
        IconButton(onClick = { Toast.makeText(context, "Previous", Toast.LENGTH_SHORT).show()}) {
            Image(painterResource(id = R.drawable.skip_previous), "Previous", Modifier.size(48.dp))
        }

        IconButton(onClick = { Toast.makeText(context, "Play/Pause", Toast.LENGTH_SHORT).show()}) {
            Image(
                painterResource(id = R.drawable.play_pause), "Play/Pause", Modifier.size(48.dp))
        }

        IconButton(onClick = { Toast.makeText(context, "Next", Toast.LENGTH_SHORT).show()}) {
            Image(
                painterResource(id = R.drawable.skip_next), "Next", Modifier.size(48.dp))
        }
    }
}
