package com.test.chatapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.BottomStart
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.test.chatapplication.ui.theme.ChatApplicationTheme
import kotlinx.coroutines.launch


class UserProfileActivity : ComponentActivity() {
    @OptIn(ExperimentalGlideComposeApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("UserProfileActivity", "onCreate: ")
        setContent {
            ChatApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UserProfileActivityScreen()
                }

            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserProfileActivityScreen(){

    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("Drawer title", modifier = Modifier.padding(16.dp))
                Divider()
                NavigationDrawerItem(
                    label = { Text(text = "Drawer Item") },
                    selected = false,
                    onClick = { /*TODO*/ }
                )
                Divider()
                NavigationDrawerItem(
                    label = { Text(text = "Drawer Item") },
                    selected = false,
                    onClick = { /*TODO*/ }
                )
                // ...other drawer items
            }
        },
    ) {
        // Screen content

        Scaffold(
            snackbarHost = {
                SnackbarHost(hostState = snackbarHostState)
            },
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    text = { Text("Show snackbar") },
                    icon = { stringResource(id = R.string.app_name) },
                    onClick = {
                        scope.launch {
                            val result = snackbarHostState
                                .showSnackbar(
                                    message = "Snackbar",
                                    actionLabel = "Action",
                                    // Defaults to SnackbarDuration.Short
                                    duration = SnackbarDuration.Indefinite
                                )
                            when (result) {
                                SnackbarResult.ActionPerformed -> {
                                    /* Handle snackbar action performed */
                                }

                                SnackbarResult.Dismissed -> {
                                    /* Handle snackbar dismissed */
                                }
                            }
                        }
                    },
                    modifier = Modifier.wrapContentSize(BottomCenter)
                )
            }
        ) {     // this shows syntax error but compiles
                contentPadding ->


            Column(
                modifier = Modifier
                    .padding(14.dp)
                    .fillMaxHeight(0.175F)
                    .fillMaxWidth()
            ) {

                Row(
                    modifier = Modifier

                ) {
                    Box(
                        modifier = Modifier
                            .background(Gray, shape = RoundedCornerShape(20.dp))
                            .fillMaxWidth(0.3F)
                            .fillMaxHeight(0.75F)
                            .wrapContentSize(Center)

                    ) {
                        // this image will show only in preview
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

                    }
                }
                Row(
                    modifier = Modifier
                        .then(Modifier.wrapContentSize(BottomStart))
                ) {
                    Text(text = "Username")
                }
            }
        }
    }
}



//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun floatingActionButton(){
//    Scaffold(modifier = Modifier
//        .fillMaxHeight(0.2F)
//        .then(Modifier.wrapContentSize(Alignment.BottomEnd))
//        .then(Modifier.wrapContentHeight(Alignment.Bottom)),
//        floatingActionButton = {
//            FloatingActionButton(onClick = { /* ... */ }) {
//                /* FAB content */
//            }
//        }
//    ) { contentPadding ->
//        // Screen content
//    }
//}




@Preview
@Composable
fun userProfilePreview(){
    ChatApplicationTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            UserProfileActivityScreen()
        }

    }
}