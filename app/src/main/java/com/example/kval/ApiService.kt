package com.example.kval

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

data class Data(
    @SerializedName("text") //менять
    @Expose
    val text: String? = null
)

interface ApiService {

    //2 варианта:
    // 1. либо .../get?q=...&... (надо писать через @Query)
    // 2. либо /get/{str}... (надо писать через @Path)
    @GET("https://cat-fact.herokuapp.com/{facts}")                   //менять
    fun getData(@Path("facts") str:String): Call<List<Data>> //менять

    companion object {
        fun getApi(): ApiService =
            Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://cat-fact.herokuapp.com/") //менять
                .build()
                .create(ApiService::class.java)
    }
}