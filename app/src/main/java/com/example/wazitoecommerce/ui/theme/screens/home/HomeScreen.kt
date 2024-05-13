package com.example.wazitoecommerce.ui.theme.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wazitoecommerce.R
import com.example.wazitoecommerce.navigation.ADD_PRODUCTS_URL
import com.example.wazitoecommerce.navigation.SEARCH_URL
import com.example.wazitoecommerce.navigation.VIEW_PRODUCTS_URL
import com.example.wazitoecommerce.ui.theme.WazitoECommerceTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController:NavHostController){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var selected by remember { mutableIntStateOf(0) }
        Scaffold(
            bottomBar = {
                NavigationBar {
                    bottomNavItems.forEachIndexed { index, bottomNavItem ->
                        NavigationBarItem(
                            selected = index == selected,
                            onClick = {
                                selected = index
                                navController.navigate(bottomNavItem.route)
                            },
                            icon = {
                                BadgedBox(
                                    badge = {
                                        if (bottomNavItem.badges != 0) {
                                            Badge {
                                                Text(text = bottomNavItem.badges.toString())
                                            }
                                        } else if (bottomNavItem.hasNews) {
                                            Badge()
                                        }
                                    }
                                ) {
                                    Icon(imageVector =
                                    if (index == selected)
                                        bottomNavItem.selectedIcon
                                    else
                                        bottomNavItem.unselectedIcon,
                                        contentDescription = bottomNavItem.title)
                                }

                            },
                            label = {
                                Text(text = bottomNavItem.title)
                            })
                    }
                }
            },


            floatingActionButton = {
                FloatingActionButton(onClick = {
                navController.navigate(ADD_PRODUCTS_URL)

                 }) {
                    IconButton(onClick = {  navController.navigate(ADD_PRODUCTS_URL)}) {
                        Icon(imageVector = Icons.Default.Add,
                            contentDescription = "menu")
                    }
                }
            },
            //Content Section
            content = @Composable{
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())

                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){

                    //Topappbar
                    TopAppBar(
                        title = { Text(text = "Find my shop",
                            color = Color.Blue,
                            fontFamily = FontFamily.Cursive,
                            fontWeight = FontWeight.ExtraBold
                        ) },
                        colors = TopAppBarDefaults.mediumTopAppBarColors(Color.White),
                        navigationIcon = {


                        }
                        , actions = {

                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(imageVector = Icons.Default.Build, contentDescription = "share",
                                    tint = Color.Black )


                            }

                            IconButton(onClick = {
                                navController.navigate(SEARCH_URL)
                            }) {
                                Icon(imageVector = Icons.Default.Search, contentDescription = "Menu",
                                    tint = Color.Blue )


                            }

                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(imageVector = Icons.Default.Notifications, contentDescription = "Menu",
                                    tint = Color.Black )


                            }

                        }


                    )

//end topbar

                    Column (

                        modifier = Modifier

                            .fillMaxSize(),
                    ){
                        //row1
                        Row (  modifier = Modifier
                            .padding(10.dp)
                            ){
Card (modifier = Modifier
    .clickable { navController.navigate(VIEW_PRODUCTS_URL) }
    .height(200.dp)
    .fillMaxWidth()
    ){
    Column() {

        Box (modifier = Modifier
            .height(210.dp)
            .fillMaxWidth(),
            contentAlignment = Alignment.Center

        ) {

            Image(
                painter = painterResource(id = R.drawable.cart3),
                contentDescription = "",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop

            )
Text(text = "Shoplenty", fontSize = 26.sp,
    color = Color.Blue,
    fontFamily = FontFamily.Cursive,)
        }


    }

}

                        }
                        //row1
//row1
                        Row (  modifier = Modifier
                            .padding(10.dp)
                        ){
                            ElevatedCard (modifier = Modifier
                                .clickable { navController.navigate(VIEW_PRODUCTS_URL) }
                                .height(200.dp)
                                .fillMaxWidth()
                            ){
                                Column() {

                                    Box (modifier = Modifier
                                        .height(210.dp)
                                        .fillMaxWidth(),
                                        contentAlignment = Alignment.Center

                                    ) {

                                        Image(
                                            painter = painterResource(id = R.drawable.liqour2),
                                            contentDescription = "",
                                            modifier = Modifier.fillMaxWidth(),
                                            contentScale = ContentScale.Crop

                                        )
                                        Text(text = "liqour")
                                    }


                                }

                            }

                        }
                        //row1
                        //row1
                        Row (  modifier = Modifier
                            .padding(10.dp)
                        ){
                            ElevatedCard (modifier = Modifier
                                .clickable { navController.navigate(VIEW_PRODUCTS_URL) }
                                .height(200.dp)
                                .fillMaxWidth()
                            ){
                                Column() {

                                    Box (modifier = Modifier
                                        .height(210.dp)
                                        .fillMaxWidth(),
                                        contentAlignment = Alignment.Center

                                    ) {

                                        Image(
                                            painter = painterResource(id = R.drawable.shoe),
                                            contentDescription = "",
                                            modifier = Modifier.fillMaxWidth(),
                                            contentScale = ContentScale.Crop

                                        )
                                        Text(text = "ShoeWear")
                                    }


                                }

                            }

                        }
                        //row1
                        //row1
                        Row (  modifier = Modifier
                            .padding(10.dp)
                        ){
                           ElevatedCard (modifier = Modifier
                                .clickable { navController.navigate(VIEW_PRODUCTS_URL) }
                                .height(200.dp)
                                .fillMaxWidth()
                            ){
                                Column() {

                                    Box (modifier = Modifier
                                        .height(210.dp)
                                        .fillMaxWidth(),
                                        contentAlignment = Alignment.Center

                                    ) {

                                        Image(
                                            painter = painterResource(id = R.drawable.make),
                                            contentDescription = "",
                                            modifier = Modifier.fillMaxWidth(),
                                            contentScale = ContentScale.Crop

                                        )
                                        Text(text = "MakeUp")
                                    }


                                }

                            }

                        }
                        //row1
                        // row2



                        }



                }

            }

        )

    }
}




val bottomNavItems = listOf(
    BottomNavItem(
        title = "Email",
        route="home",
        selectedIcon=Icons.Filled.MailOutline,
        unselectedIcon=Icons.Outlined.AddCircle,
        hasNews = false,
        badges=0
    ),



    BottomNavItem(
        title = "Login",
        route="login",
        selectedIcon=Icons.Filled.Person,
        unselectedIcon=Icons.Outlined.Person,
        hasNews = true,
        badges=5
    ),

    BottomNavItem(
        title = "Signup",
        route="signup",
        selectedIcon=Icons.Filled.Face,
        unselectedIcon=Icons.Outlined.Face,
        hasNews = true,
        badges=1
    ),


    )



data class BottomNavItem(
    val title :String,
    val route :String,
    val selectedIcon: ImageVector,
    val unselectedIcon :ImageVector,
    val hasNews :Boolean,
    val badges :Int
)



@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){
    WazitoECommerceTheme {
        HomeScreen(navController = rememberNavController())
    }
}