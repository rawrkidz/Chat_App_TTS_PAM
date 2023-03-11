package edu.uksw.fti.pam.pamactivityintent.ui.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import edu.uksw.fti.pam.pamactivityintent.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import edu.uksw.fti.pam.pamactivityintent.models.GroupViewModel
import edu.uksw.fti.pam.pamactivityintent.models.TodosViewModel
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import kotlin.math.roundToInt
import edu.uksw.fti.pam.pamactivityintent.ui.theme.PAMActivityIntentTheme

@Composable
fun HomeField(
    vm: TodosViewModel,
    vm2: GroupViewModel
) {
    LaunchedEffect(
        Unit,
        block = {
            vm.getToDoList()
            vm2.getGroupList()
        }
    )

    val displayMetrics = DisplayMetrics()
    val height = (displayMetrics.heightPixels / displayMetrics.density) - 150;
    val width = displayMetrics.widthPixels / displayMetrics.density;
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.07f),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.icon_notification),
                contentDescription = stringResource(id = R.string.notif),
                tint = Color.Gray,
                modifier = Modifier.padding(start = 15.dp, end = 30.dp)
            )
            Text(
                "Telegram",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                color = Color(0xff36a8eb),
                fontSize = 22.sp
            )
            Row(
                modifier = Modifier.padding(end = 15.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.filter_list),
                    contentDescription = stringResource(id = R.string.filter_list),
                    tint = Color.Gray,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Icon(
                    painter = painterResource(R.drawable.search),
                    contentDescription = stringResource(id = R.string.search),
                    tint = Color.Gray,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.05f),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = stringResource(R.string.all),color = Color(0xff2d8bc2))
            Text(text = stringResource(R.string.message))
            Text(text = stringResource(R.string.grup))
            Text(text = stringResource(R.string.channel))
            Text(text = stringResource(R.string.unread))
        }
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .size(width = width.dp, height = height.dp)


        ) {
            Column(
                modifier = Modifier
                    .padding(start = 30.dp, end = 30.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp, bottom = 20.dp)
                ) {
                    Text(
                        text = stringResource(R.string.message),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                    Icon(
                        painter = painterResource(R.drawable.icon_more),
                        contentDescription = stringResource(id = R.string.icon_more),
                        tint = Color.Black,
                        modifier = Modifier.size(30.dp)
                    )
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    if (vm.errorMessage != null){
                        LazyColumn(modifier = Modifier.padding(15.dp)){
                            items(vm.toDoList.size) { index ->
                                Card(modifier = Modifier
                                    .padding(10.dp, 6.dp)
                                    .fillMaxWidth()
                                    .height(90.dp), shape = RoundedCornerShape(10.dp), elevation = 4.dp,
                                    backgroundColor = Color.Gray
                                ) {
                                    Surface() {
                                        Row(
                                            Modifier
                                                .padding(4.dp)
                                                .fillMaxSize()
                                        ) {
                                            Image(
                                                painter = rememberImagePainter(data = vm.toDoList[index].image,
                                                    builder = {
                                                        scale(Scale.FILL)
                                                        placeholder(coil.compose.base.R.drawable.notification_action_background)
                                                        transformations(
                                                            CircleCropTransformation()
                                                        )
                                                    }),
                                                contentDescription = null)

                                            Column(verticalArrangement = Arrangement.Center,
                                                modifier = Modifier
                                                    .padding(6.dp)
                                                    .fillMaxHeight()
                                                    .weight(0.8f))
                                            {
                                                Text(text = vm.toDoList[index].title,
                                                    fontSize = 16.sp,
                                                    color = Color(0xff2d8bc2),
                                                    fontWeight = FontWeight.Bold

                                                )
                                                Text(text = vm.toDoList[index].chat,
                                                    fontSize = 12.sp,
                                                    color = Color(0xff2d8bc2),
                                                    maxLines = 1,
                                                    overflow = TextOverflow.Ellipsis
                                                )
                                            }

                                            Column(
                                                modifier = Modifier
                                                    .size(height = 80.dp, width = 30.dp)
                                                    .padding(
                                                        top = 4.dp,
                                                        bottom = 4.dp
                                                    ),
                                                verticalArrangement = Arrangement.SpaceBetween,
                                                horizontalAlignment = Alignment.CenterHorizontally
                                            ) {
                                                Text("09.00", fontSize = 11.sp)
                                                Icon(
                                                    painter = painterResource(R.drawable.icon_read),
                                                    contentDescription = null,
                                                    tint = Color.Gray,
                                                    modifier = Modifier.size(20.dp)
                                                )
                                            }
                                        }
                                    }
                                }

                            }
                        }
                    }
                    else {
                        Text(text = vm.errorMessage)
                    }
                }
            }

            Column(
                modifier = Modifier
                    .padding(start = 30.dp, end = 30.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp, bottom = 20.dp)
                ) {
                    Text(
                        text = stringResource(R.string.grup),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                    Icon(
                        painter = painterResource(R.drawable.icon_more),
                        contentDescription = stringResource(id = R.string.icon_more),
                        tint = Color.Black,
                        modifier = Modifier.size(30.dp)
                    )
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    if (vm2.errorMessage != null){
                        LazyColumn(modifier = Modifier.padding(15.dp)){
                            items(vm2.GroupList.size) { index ->
                                Card(modifier = Modifier
                                    .padding(10.dp, 6.dp)
                                    .fillMaxWidth()
                                    .height(90.dp), shape = RoundedCornerShape(10.dp), elevation = 4.dp,
                                    backgroundColor = Color.Gray
                                ) {
                                    Surface() {
                                        Row(
                                            Modifier
                                                .padding(4.dp)
                                                .fillMaxSize()
                                        ) {
                                            Image(
                                                painter = rememberImagePainter(data = vm2.GroupList[index].image,
                                                    builder = {
                                                        scale(Scale.FILL)
                                                        placeholder(coil.compose.base.R.drawable.notification_action_background)
                                                        transformations(CircleCropTransformation())
                                                    }),
                                                contentDescription = null)

                                            Column(verticalArrangement = Arrangement.Center,
                                                modifier = Modifier
                                                    .padding(6.dp)
                                                    .fillMaxHeight()
                                                    .weight(0.8f))
                                            {
                                                Text(text = vm2.GroupList[index].title,
                                                    fontSize = 16.sp,
                                                    color = Color(0xff2d8bc2),
                                                    fontWeight = FontWeight.Bold

                                                )
                                                Text(text = vm2.GroupList[index].chat,
                                                    fontSize = 12.sp,
                                                    color = Color(0xff2d8bc2),
                                                    maxLines = 1,
                                                    overflow = TextOverflow.Ellipsis
                                                )
                                            }

                                            Column(
                                                modifier = Modifier
                                                    .size(height = 80.dp, width = 30.dp)
                                                    .padding(
                                                        top = 4.dp,
                                                        bottom = 4.dp
                                                    ),
                                                verticalArrangement = Arrangement.SpaceBetween,
                                                horizontalAlignment = Alignment.CenterHorizontally
                                            ) {
                                                Text("10.00", fontSize = 11.sp)
                                                Box(
                                                    modifier = Modifier
                                                        .size(18.dp)
                                                        .clip(shape = CircleShape)
                                                        .background(Color(0xff2d8bc2)),
                                                    contentAlignment = Alignment.Center
                                                ) {
                                                    Text(
                                                        "1",
                                                        color = Color.White,
                                                        fontSize = 10.sp,
                                                        fontWeight = FontWeight.Bold
                                                    )
                                                }
                                            }
                                        }
                                    }
                                }

                            }
                        }
                    }
                    else {
                        Text(text = vm2.errorMessage)
                    }
                }
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview20(){
    val vm = TodosViewModel()
    val vm2 = GroupViewModel()
    PAMActivityIntentTheme {
        HomeField(vm,vm2)
    }
}