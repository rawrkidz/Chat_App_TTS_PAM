package edu.uksw.fti.pam.pamactivityintent.ui.screens

import edu.uksw.fti.pam.pamactivityintent.ui.theme.PAMActivityIntentTheme
import android.os.Bundle
import android.provider.ContactsContract
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PAMActivityIntentTheme(){
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ContactScreen()
                }
            }
        }
    }
}

@Composable
fun ContactScreen() {
    var contactDisplayName by remember{ mutableStateOf("") }
    val context = LocalContext.current

    val getContactData = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickContact(),
        onResult = { data ->
            val projections = arrayOf(
                ContactsContract.Contacts.DISPLAY_NAME
            )

            val cursor = context.contentResolver.query(
                data!!, //from select query
                projections, //kolom select query
                null,
                null,
                null
            )
            cursor?.moveToFirst()

            val displayNameIndex = cursor?.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)
            val displayName = cursor?.getString(displayNameIndex!!)

            contactDisplayName = displayName!!
        }
    )

    Column() {
        Button(
            onClick = { getContactData.launch()}
        ) {
            Text(text = "Get Contact")
        }
        Text(text = contactDisplayName)
    }
}