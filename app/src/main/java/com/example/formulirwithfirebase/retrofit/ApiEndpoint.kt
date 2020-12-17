package com.example.apitest.retrofit

import com.example.formulirwithfirebase.MainModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {
    @GET("indonesia")
    fun getData(): Call<List<MainModel>>
}