package com.example.retrofit_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity_01 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main01)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(RetrofitService_01::class.java)

        service.getUserPage("1")?.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    // 정상적으로 통신이 성공된 경우
                    var result : User? = response.body()
                    Log.d("YMC", "onResponse 성공 : " + result?.toString())
                } else {
                    // 통신이 실패한 경우 (응답코드 3xx, 4xx 등)
                    Log.d("YMC", "onResponse 실패")
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                // 통신 실패 (인터넷 끊킴, 예외 발생 등 시스템적인 이유)
                Log.d("YMC", "onFailure 에러 : " + t.message.toString())
            }
       })
    }
}