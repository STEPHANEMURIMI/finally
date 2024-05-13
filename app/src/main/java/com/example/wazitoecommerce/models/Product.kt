package com.example.wazitoecommerce.models

class Product {
    var shopname:String = ""
    var contact:String = ""
    var productName:String = ""
    var lacation :String = ""
    var imageUrl:String = ""
    var id:String = ""

    constructor(shopname: String, contact: String, productName: String,lacation : String,imageUrl: String, id: String) {
        this.shopname = shopname
        this.contact = contact
        this.productName = productName
        this.lacation =  lacation
        this.imageUrl = imageUrl
        this.id = id
    }

    constructor()
}