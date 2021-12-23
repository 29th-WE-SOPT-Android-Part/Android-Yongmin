package org.sopt.study.againassignment.server

import org.sopt.study.againassignment.data.RequestLoginData
import org.sopt.study.againassignment.data.ResponseLoginData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface SampleService {
    @Headers("Content-Type:application/json")
    @POST("user/login")
    fun postLogin(
        @Body body : RequestLoginData
    ) : Call<ResponseLoginData>
}