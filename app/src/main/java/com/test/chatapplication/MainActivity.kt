package com.test.chatapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.test.chatapplication.ui.theme.ChatApplicationTheme
import kotlinx.coroutines.delay


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ChatApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Greeting()

                    Handler().postDelayed({
                        // Show an animation or something instead of delay
                    }, 7000)

                    OpenLoginScreen()
                    finish()
                }
            }
        }
    }
}


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun Greeting(modifier: Modifier = Modifier) {

    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data("")
            .crossfade(true)
            .build(),
        placeholder = painterResource(R.drawable.ic_launcher_foreground),
        contentDescription = "Test AsyncImage",
        contentScale = ContentScale.Inside,
        modifier = Modifier.clip(CircleShape)
    )
    Column(
        modifier = Modifier
            .padding(50.dp)
            .then(Modifier.fillMaxSize())
            .then(Modifier.wrapContentSize(Alignment.Center))
            .then(Modifier.wrapContentHeight(Alignment.CenterVertically))
    ) {
        Row(
            modifier = Modifier
                .then(Modifier.fillMaxSize())
                .then(Modifier.wrapContentSize(Alignment.TopCenter))
                .then(Modifier.wrapContentHeight(Alignment.CenterVertically))
                .then(Modifier.padding(0.dp, 250.dp))
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                modifier = modifier
            )
        }
    }
}

@Composable
fun OpenLoginScreen(){
    val context = LocalContext.current

    Handler().postDelayed({
        // Show an animation or something instead of delay
    }, 7000)

    context.startActivity(Intent(context, Login::class.java))
}




@Preview
@Composable
fun mainPreview(){

    ChatApplicationTheme {

        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

            Greeting()

            Handler().postDelayed(
                {
                // Show an animation or something instead of delay
                }, 7000)

           // OpenLoginScreen()
            //finish()
        }
    }

}