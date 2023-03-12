package edu.uksw.fti.pam.pamactivityintent.ui.screens

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.uksw.fti.pam.pamactivityintent.HomeActivity
import edu.uksw.fti.pam.pamactivityintent.R
import edu.uksw.fti.pam.pamactivityintent.contracts.SignUpContract
import edu.uksw.fti.pam.pamactivityintent.ui.theme.PAMActivityIntentTheme
import edu.uksw.fti.pam.pamactivityintent.DataStore.FirstName
import edu.uksw.fti.pam.pamactivityintent.DataStore.LastName
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.uksw.fti.pam.pamactivityintent.ui.theme.PAMActivityIntentTheme

@Composable
fun ProfileScreen() {
    val context = LocalContext.current
    val dataStore = FirstName(context)
    val storeData = LastName(context)
    val savedFirst = dataStore.getFirst.collectAsState(initial = "")
    val savedLast = storeData.getLast.collectAsState(initial = "")

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .width(400.dp)
            .clip(shape = RoundedCornerShape(10.dp, 10.dp, 10.dp, 10.dp))
            .padding(top = 40.dp, start = 16.dp, end = 16.dp, bottom = 0.dp)
            .clip(shape = RoundedCornerShape(18.dp))
            .height(160.dp)
            .background(Color(0xff36a8eb))
    ) {
        Box(
            modifier = Modifier
                .padding(start = 24.dp, top = 20.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.person_2),
                contentDescription = stringResource(id = R.string.profil),
                modifier = Modifier
                    .size(112.dp)
                    .clip(shape = RoundedCornerShape(80.dp))
            )
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .clip(shape = CircleShape)
                    .background(Color.White)
                    .align(Alignment.BottomEnd)
                    .border(
                        width = 4.0.dp,
                        color = Color(0xff36a8eb),
                        shape = CircleShape
                    )
            ) {
                Icon(
                    painter = painterResource(R.drawable.icon_home),
                    contentDescription = stringResource(id = R.string.icon_bottom),
                    tint = Color(0xff36a8eb),
                    modifier = Modifier
                        .size(26.dp)
                        .padding(start = 6.dp, top = 2.dp)
                )
            }
        }
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(top = 120.dp),
//                horizontalArrangement = Arrangement.Center
//            ) {
        Text(
            modifier = Modifier
                .padding(start = 160.dp, top = 30.dp),
            text = "Hallo ,  ",
            fontSize = 16.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            color = Color.White,
        )
        Text(
            modifier = Modifier
                .padding(start = 214.dp, top = 30.dp),
            text = savedFirst.value!!,
            fontSize = 16.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Text(
            modifier = Modifier
                .padding(start = 268.dp, top = 30.dp),
            text = " "
        )
        Text(
            modifier = Modifier
                .padding(start = 264.dp, top = 30.dp),
            text = savedLast.value!!,
            fontSize = 16.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            color = Color.White,
        )
        Text(
            modifier = Modifier
                .padding(start = 160.dp, top = 71.dp),
            text = "Saya Suka Menabung ...",
            fontSize = 14.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Normal,
            color = Color.White,
        )
    }
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .padding(top = 148.dp, end = 48.dp)
    ) {
        Row(
            modifier = Modifier
                .width(400.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Button(
                modifier = Modifier
                    .width(140.dp)
                    .height(32.dp)
                    .padding(start = 8.dp, top = 0.dp, end = 4.dp),
                colors = ButtonDefaults.buttonColors(Color.White),
                onClick = {},
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Edit My Profil",
                    fontSize = 11.sp,
                    color = Color(0xff36a8eb),
                    fontWeight = FontWeight.Bold
                )
            }
            Icon(
                painter = painterResource(R.drawable.share),
                contentDescription = stringResource(id = R.string.share),
                tint = Color.White,
                modifier = Modifier
                    .size(28.dp)
                    .padding(start = 6.dp, top = 2.dp)
            )
        }
    }

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(start = 36.dp, top = 240.dp, end = 16.dp)
    ) {
        Row(
            modifier = Modifier.width(440.dp),
            horizontalArrangement = Arrangement.Start,

            ) {
            Icon(
                painter = painterResource(R.drawable.favourites),
                contentDescription = stringResource(id = R.string.favourites),
                tint = Color.Black,
                modifier = Modifier.size(24.dp).padding(top = 4.dp)
            )
            Text(
                text = "Favourites",
                modifier = Modifier
                    .padding(start = 36.dp, top = 0.dp, end = 155.dp),
                fontSize = 17.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
            )
            Icon(
                painter = painterResource(R.drawable.arrow_rights),
                contentDescription = stringResource(id = R.string.arrow_rights),
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
                    .padding(start = 0.dp, top = 4.dp)
            )
        }
        Row(
            modifier = Modifier.width(440.dp).padding(top = 24.dp),
            horizontalArrangement = Arrangement.Start,

            ) {
            Icon(
                painter = painterResource(R.drawable.downloads),
                contentDescription = stringResource(id = R.string.downloads),
                tint = Color.Black,
                modifier = Modifier.size(24.dp).padding(top = 4.dp)
            )
            Text(
                text = "Downloads",
                modifier = Modifier
                    .padding(start = 36.dp, top = 0.dp, end = 149.dp),
                fontSize = 17.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
            )
            Icon(
                painter = painterResource(R.drawable.arrow_rights),
                contentDescription = stringResource(id = R.string.arrow_rights),
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
                    .padding(start = 0.dp, top = 4.dp)
            )
        }

        Row(
            modifier = Modifier.width(440.dp).padding(top = 48.dp),
            horizontalArrangement = Arrangement.Start,
        ) {
            Icon(
                painter = painterResource(R.drawable.languages),
                contentDescription = stringResource(id = R.string.languages),
                tint = Color.Black,
                modifier = Modifier.size(24.dp).padding(top = 4.dp)
            )
            Text(
                text = "Languages",
                modifier = Modifier
                    .padding(start = 36.dp, top = 0.dp, end = 150.dp),
                fontSize = 17.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
            )
            Icon(
                painter = painterResource(R.drawable.arrow_rights),
                contentDescription = stringResource(id = R.string.arrow_rights),
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
                    .padding(start = 0.dp, top = 4.dp)
            )
        }
        Row(
            modifier = Modifier.width(440.dp).padding(top = 24.dp),
            horizontalArrangement = Arrangement.Start,
            ) {
            Icon(
                painter = painterResource(R.drawable.location),
                contentDescription = stringResource(id = R.string.location),
                tint = Color.Black,
                modifier = Modifier.size(24.dp).padding(top = 4.dp)
            )
            Text(
                text = "Location",
                modifier = Modifier
                    .padding(start = 36.dp, top = 0.dp, end = 169.dp),
                fontSize = 17.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
            )
            Icon(
                painter = painterResource(R.drawable.arrow_rights),
                contentDescription = stringResource(id = R.string.arrow_rights),
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
                    .padding(start = 0.dp, top = 4.dp)
            )
        }
        Row(
            modifier = Modifier.width(440.dp).padding(top = 24.dp),
            horizontalArrangement = Arrangement.Start,
        ) {
            Icon(
                painter = painterResource(R.drawable.display),
                contentDescription = stringResource(id = R.string.display),
                tint = Color.Black,
                modifier = Modifier.size(24.dp).padding(top = 4.dp)
            )
            Text(
                text = "Display",
                modifier = Modifier
                    .padding(start = 36.dp, top = 0.dp, end = 180.dp),
                fontSize = 17.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
            )
            Icon(
                painter = painterResource(R.drawable.arrow_rights),
                contentDescription = stringResource(id = R.string.arrow_rights),
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
                    .padding(start = 0.dp, top = 4.dp)
            )
        }
        Row(
            modifier = Modifier.width(440.dp).padding(top = 24.dp),
            horizontalArrangement = Arrangement.Start,

            ) {
            Icon(
                painter = painterResource(R.drawable.subscribe),
                contentDescription = stringResource(id = R.string.subscribe),
                tint = Color.Black,
                modifier = Modifier.size(24.dp).padding(top = 4.dp)
            )
            Text(
                text = "Subscription",
                modifier = Modifier
                    .padding(start = 36.dp, top = 0.dp, end = 136.dp),
                fontSize = 17.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
            )
            Icon(
                painter = painterResource(R.drawable.arrow_rights),
                contentDescription = stringResource(id = R.string.arrow_rights),
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
                    .padding(start = 0.dp, top = 4.dp)
            )
        }
        Row(
            modifier = Modifier.width(440.dp).padding(top = 24.dp),
            horizontalArrangement = Arrangement.Start,

            ) {
            Icon(
                painter = painterResource(R.drawable.time),
                contentDescription = stringResource(id = R.string.time),
                tint = Color.Black,
                modifier = Modifier.size(24.dp).padding(top = 4.dp)
            )
            Text(
                text = "Clear History",
                modifier = Modifier
                    .padding(start = 36.dp, top = 0.dp, end = 132.dp),
                fontSize = 17.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
            )
            Icon(
                painter = painterResource(R.drawable.arrow_rights),
                contentDescription = stringResource(id = R.string.arrow_rights),
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
                    .padding(start = 0.dp, top = 4.dp)
            )
        }
        Row(
            modifier = Modifier.width(440.dp).padding(top = 48.dp),
            horizontalArrangement = Arrangement.Start,

            ) {
            Icon(
                painter = painterResource(R.drawable.accounts),
                contentDescription = stringResource(id = R.string.accounts),
                tint = Color.Black,
                modifier = Modifier.size(24.dp).padding(top = 4.dp)
            )
            Text(
                text = "Accounts",
                modifier = Modifier
                    .padding(start = 36.dp, top = 0.dp, end = 160.dp),
                fontSize = 17.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
            )
            Icon(
                painter = painterResource(R.drawable.arrow_rights),
                contentDescription = stringResource(id = R.string.arrow_rights),
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
                    .padding(start = 0.dp, top = 4.dp)
            )
        }
        Row(
            modifier = Modifier.width(440.dp).padding(top = 24.dp),
            horizontalArrangement = Arrangement.Start,

            ) {

            Icon(
                painter = painterResource(R.drawable.logout),
                contentDescription = stringResource(id = R.string.logout),
                tint = Color.Red,
                modifier = Modifier.size(24.dp).padding(top = 4.dp)
            )
            Text(
                text = "Log Out",
                modifier = Modifier
                    .padding(start = 36.dp, top = 0.dp, end = 174.dp),
                fontSize = 17.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal,
                color = Color.Red,
            )
        }
    }
    Column(
        modifier = Modifier
            .width(350.dp)
            .padding(start = 40.dp, top = 340.dp)
    ){
        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier
                .clip(shape = RoundedCornerShape(20.dp))
        )
    }
    Column(
        modifier = Modifier
            .width(350.dp)
            .padding(start = 40.dp, top = 610.dp)
    ){
        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier
                .clip(shape = RoundedCornerShape(20.dp))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3(){
    PAMActivityIntentTheme {
        ProfileScreen()
    }
}


