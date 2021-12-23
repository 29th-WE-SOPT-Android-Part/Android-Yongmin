package org.sopt.study.againassignment.data

data class ResponseSignupData(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: Data2
)

data class Data2(
    val id: Int,
    val name: String,
    val email: String
)
