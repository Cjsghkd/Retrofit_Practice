package com.example.retrofit_practice

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface INetworkService_02 {
    // @GET : 서버 연동 시 GET 방식으로 하겠다는 의미
    // @Query : 서버에 전달되는 데이터
    // @Url : 요청 URL
    @GET("api/users")
    fun doGetUserList(@Query("page") page : String) : Call<UserListModel_02>
    @GET
    fun getAvatarImage(@Url url : String) : Call<ResponseBody>
}