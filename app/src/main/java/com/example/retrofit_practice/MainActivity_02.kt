package com.example.retrofit_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Array.get

class MainActivity_02 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main02)

        val retrofit : Retrofit
                = Retrofit.Builder()
                .baseUrl("https://reqres.in/")
                .addConverterFactory(GsonConverterFactory.create()) // GsonConverter 이용하겠다는 의미
                .build()

        val networkService : INetworkService_02 = retrofit.create(INetworkService_02::class.java)

        val userListModel = networkService.doGetUserList("1")

        userListModel.enqueue(object : Callback<UserListModel_02> {
            override fun onResponse(
                call: Call<UserListModel_02>,
                response: Response<UserListModel_02>
            ) {
                val userList = response.body()
                Log.d("testt", "success")
            }

            override fun onFailure(call: Call<UserListModel_02>, t: Throwable) {
                call.cancel()
                Log.d("testt", "failure")
            }
        })
    }
}