package com.example.wazitoecommerce.ui.theme.screens.products

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.wazitoecommerce.R
import com.example.wazitoecommerce.data.ProductViewModel
import com.example.wazitoecommerce.models.Product
import com.example.wazitoecommerce.navigation.SEARCH_URL
import com.example.wazitoecommerce.navigation.VIEW_PRODUCTS_URL
import com.example.wazitoecommerce.ui.theme.WazitoECommerceTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewProductsScreen(navController:NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        var context = LocalContext.current
        var productRepository = ProductViewModel(navController, context)


        val emptyProductState = remember { mutableStateOf(Product("","","","","","")) }
        var emptyProductsListState = remember { mutableStateListOf<Product>() }

        var products = productRepository.allProducts(emptyProductState, emptyProductsListState)


        Column(
            modifier = Modifier
                .fillMaxSize(),

        ) {
            //Topappbar
            TopAppBar(
                title = { Text(text = "shoplenty",
                    color = Color.Blue,
                    fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.ExtraBold
                ) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(Color.White),
                navigationIcon = {


                }
                , actions = {



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

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(){
                items(products){
                    ProductItem(
                        shopname = it.shopname,
                       productName = it.productName,
                    lacation = it.lacation,
                        contact = it.contact,
                        id = it.id,
                        navController = navController,
                        productRepository = productRepository,
                        productImage = it.imageUrl
                    )
                }
            }
        }
    }
}


@Composable
fun ProductItem(shopname:String, productName:String,lacation:String ,contact:String, id:String,
                navController:NavHostController,
                productRepository:ProductViewModel, productImage:String) {

    Column(modifier = Modifier.fillMaxSize()) {

Column {
    Text(text =shopname , fontSize = 26.sp,
        color = Color.Black,
        fontFamily = FontFamily.SansSerif,)
}
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
                            painter = rememberAsyncImagePainter(productImage),
                            contentDescription = null,
                            modifier = Modifier.fillMaxWidth(),
                            contentScale = ContentScale.Crop

                        )

                        Column {

                            Spacer(modifier = Modifier.height(3.dp))
                            Text(text = productName, fontSize = 28.sp,
                                color = Color.Blue,
                                fontFamily = FontFamily.Cursive,)
                            Spacer(modifier = Modifier.height(3.dp))
                            Text(text = contact, fontSize = 28.sp,
                                color = Color.Blue,
                                fontFamily = FontFamily.Cursive,)
                            Spacer(modifier = Modifier.height(3.dp))
                            Text(text = lacation, fontSize = 28.sp,
                                color = Color.Blue,
                                fontFamily = FontFamily.Cursive,
                                fontWeight = FontWeight.ExtraBold)
                        }


                    }


                }

            }

        }
        //row1
        //card2




//Row {
   // Button(onClick = {
      //  productRepository.deleteProduct(id)
   // }) {
       // Text(text = "Delete")
   // }
  //  Spacer(modifier = Modifier.width(10.dp))
   // Button(onClick = {
        //navController.navigate(ROUTE_UPDATE_PRODUCTS+"/$id")
  //  }) {
      //  Text(text = "Update")
        Row {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.AddCircle, contentDescription = "share",
                    tint = Color.Blue )


            }
            Spacer(modifier = Modifier.width(10.dp))
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Info, contentDescription = "share",
                    tint = Color.Blue )


            }
            Spacer(modifier = Modifier.width(10.dp))
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Star, contentDescription = "share",
                    tint = Color.Blue )


            }
            Spacer(modifier = Modifier.width(10.dp))
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.ThumbUp, contentDescription = "share",
                    tint = Color.Blue)


            }
            Spacer(modifier = Modifier.width(10.dp))
            IconButton(onClick = {
                productRepository.deleteProduct(id)

            }) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "share",
                    tint = Color.Blue)


            }



        }

    }
}





@Composable
@Preview(showBackground = true)
fun ViewProductsScreenPreview(){
    WazitoECommerceTheme {
        ViewProductsScreen(navController = rememberNavController())
    }
}


//Image(
//painter = rememberAsyncImagePainter(productImage),
//contentDescription = null,
//modifier = Modifier
//.fillMaxSize()
//.size(250.dp)

//)