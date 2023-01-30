package com.example.klubsportowy

import com.example.klubsportowy.JSON.JSONModel
import retrofit2.Response
import retrofit2.http.GET

interface APIService {

    @GET("/iwanejroo/karol_iwaniuk_mobilki/master/klubsportowy.json")
    suspend fun getPlayers(): Response<JSONModel>
}