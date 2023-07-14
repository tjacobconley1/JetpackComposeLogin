package com.test.chatapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.chatapplication.ActivityViewModels.LoginUIViewModel
import com.test.chatapplication.ui.theme.ChatApplicationTheme

class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ChatApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginUIScreen(LoginUIViewModel())
                }
            }
        }
    }

}





// wrapper composable function in order to use view model components
@Composable
fun LoginUIScreen(LoginUIViewModel: LoginUIViewModel){

//    var email by rememberSaveable { mutableStateOf("") }
//    var password by rememberSaveable { mutableStateOf("") }
//    var validUser by rememberSaveable { mutableStateOf("") }

//    LoginUI(
//        email = email,
//        password = password,
//        onEmailChange = {email=it},
//        onPasswordChange = {password=it},
//        onSuccessfulVerify = {validUser=it}
//    )

    LoginUI()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginUI() {

    val mContext = LocalContext.current
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var validUser by rememberSaveable { mutableStateOf("") }
    // these variables are like this because they
    // need to read in text input within the Out

    fun checkCredentials(email: String, password: String, context: Context){

        Log.d("Login Activity", "checkCredentials: ")
        // need to do an api call here
        // we must send the entered email and password to the server in json format
        // then the backend must check whether this account exists or not
        // and check if the password it correct
        // and then it must return maybe a boolean within a json

        if(email=="test" && password=="test"){
            Toast.makeText(context, "Logged In", Toast.LENGTH_SHORT).show()
            context.startActivity(Intent(context, UserProfileActivity::class.java))
        }else{
            Toast.makeText(context, "Incorrect email or password", Toast.LENGTH_SHORT).show()
        }
    }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .absoluteOffset(0.dp, (-80).dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Company Name",
            fontFamily = FontFamily.Monospace,
            textAlign = TextAlign.Center,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email=it },
            label = { Text(text = "Enter your email")},
            leadingIcon = {
                Icon(Icons.Default.Person, contentDescription = "Email")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp)
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password=it },
            label = { Text(text = "Enter your password")},
            leadingIcon = {
                Icon(Icons.Default.Info, contentDescription = "Password")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        OutlinedButton(
            onClick = { checkCredentials(email, password, mContext).toString() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp)) {
            Text(
                text = "Login",
                textAlign = TextAlign.Center)
            }
        
        Text(text = "Hint: Try - email: 'test' || password: 'test'")
    }

}


//@Composable
//fun OpenUserProfileActivity(context: Context){
//    context.startActivity(Intent(context, UserProfileActivity::class.java))
//}


