package com.example.retrofit_practice

import com.google.gson.annotations.SerializedName

data class UserListModel_02(
    var page: String,
    @SerializedName("per_page")
    var perPage: String,
    var total: String,
    @SerializedName("total_pages")
    var totalPages: String,
    var data: List<UserModel_02>?
)
