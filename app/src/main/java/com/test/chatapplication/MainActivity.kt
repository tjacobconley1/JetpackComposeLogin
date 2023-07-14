package com.test.chatapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
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

//                    AsyncImage(
//                        model = "https://example.com/image.jpg",
//                        contentDescription = "Translated description of what the image contains"
//                    )
//
//                    Handler().postDelayed({
//                        // Show an animation or something instead of delay
//                    }, 7000)

                    OpenLoginScreen()
                    finish()
                }
            }
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