package com.example.wazitoecommerce.ui.theme.screens.products



import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text

import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wazitoecommerce.R
import androidx.navigation.NavHostController
import com.example.wazitoecommerce.navigation.HOME_URL

import com.example.wazitoecommerce.navigation.VIEW_PRODUCTS_URL

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavHostController) {
    Column (
        modifier = Modifier.fillMaxSize()
    )
    {
        val mContext = LocalContext.current


//Topappbar
        TopAppBar(
            title = {

            },
            colors = TopAppBarDefaults.mediumTopAppBarColors(Color.Blue),
            navigationIcon = {
                IconButton(onClick = { navController.navigate(HOME_URL)
                }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Menu",
                        tint = Color.White
                    )
                }

            }
            , actions = {

                IconButton(onClick = {


                }) {
                    Icon(imageVector = Icons.Default.Share, contentDescription = "Menu",
                        tint = Color.White )


                }

                IconButton(onClick = {
                    navController.navigate(HOME_URL)
                }) {
                    Icon(imageVector = Icons.Default.Settings, contentDescription = "Menu",
                        tint = Color.White )


                }

            }


        )

//end topbar
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentAlignment = Alignment.Center


        ){
            Image(painter = painterResource(id = R.drawable.cart3),
                contentDescription ="" ,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )






        }
        //end box
        Spacer(modifier = Modifier.height(10.dp))
        var search by remember { mutableStateOf("")}

        OutlinedTextField(
            value = search ,
            onValueChange ={search = it},
            placeholder = { Row {
                Text(text = " product or shopname")

            } },
            leadingIcon = { Image(imageVector = Icons.Default.Search, contentDescription = "", modifier = Modifier.clickable {
                navController.navigate(VIEW_PRODUCTS_URL)

            })},
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
                .fillMaxWidth()
                .clickable { navController.navigate(VIEW_PRODUCTS_URL) }
        )
//end of search bar
        Spacer(modifier = Modifier.height(10.dp))



        Spacer(modifier = Modifier.height(10.dp))
 Row (
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ){
     //card2
     Card (modifier = Modifier

         .size(200.dp)
     ){
         Column() {

             Box (modifier = Modifier
                 .size(200.dp)
                 .fillMaxWidth(),
                 contentAlignment = Alignment.Center

             ) {

                 Image(
                     painter = painterResource(id = R.drawable.product2),
                     contentDescription = "",
                     modifier = Modifier.fillMaxWidth(),
                     contentScale = ContentScale.Crop

                 )
                 Text(text = "Shoplenty")
             }


         }

     }
     //card2
     Spacer(modifier = Modifier.width(10.dp))
     //card2
     Card (modifier = Modifier

         .size(200.dp)
     ){
         Column() {

             Box (modifier = Modifier
                 .size(200.dp)
                 .fillMaxWidth(),
                 contentAlignment = Alignment.Center

             ) {

                 Image(
                     painter = painterResource(id = R.drawable.liqour2),
                     contentDescription = "",
                     modifier = Modifier.fillMaxWidth(),
                     contentScale = ContentScale.Crop

                 )
                 Text(text = "Shoplenty")
             }


         }

     }
     //card2

     Spacer(modifier = Modifier.width(10.dp))

     //card2
     Card (modifier = Modifier

         .size(200.dp)
     ){
         Column() {

             Box (modifier = Modifier
                 .size(200.dp)
                 .fillMaxWidth(),
                 contentAlignment = Alignment.Center

             ) {

                 Image(
                     painter = painterResource(id = R.drawable.meat),
                     contentDescription = "",
                     modifier = Modifier.fillMaxWidth(),
                     contentScale = ContentScale.Crop

                 )
                 Text(text = "Shoplenty")
             }


         }

     }
     //card2



 }
    }


}
@Composable
@Preview(showBackground = true)
fun SearchScreenPreview(){

}