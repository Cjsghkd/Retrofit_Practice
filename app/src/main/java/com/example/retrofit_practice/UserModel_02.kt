package com.example.retrofit_practice

import android.graphics.Bitmap
import com.google.gson.annotations.SerializedName

data class UserModel_02(
    var id : String,
    @SerializedName("first_name")
    var firstName : String,
    var lastName : String,
    var avatar : String,
    var avatarBitmap : Bitmap
)
