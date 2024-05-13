package com.example.wazitoecommerce.models

import android.content.Context
import android.content.Intent
import android.provider.MediaStore
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){
    fun openCamera(context: Context){
        val cameraIntent =
            Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        context.startActivity(cameraIntent)
    }
}