package org.sopt.study.againassignment

import org.sopt.study.againassignment.data.RequestSignupData
import org.sopt.study.againassignment.data.ResponseSignupData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface SignUp {
    @Headers("Content-Type:application/json")
    @POST("user/signup")
    fun postSignup(
        @Body body : RequestSignupData
    ) : Call<ResponseSignupData>
}