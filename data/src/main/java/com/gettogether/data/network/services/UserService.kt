package com.gettogether.data.network.services

import android.util.Log
import com.gettogether.data.network.api.UserApi
import com.gettogether.data.network.models.UserResponse
import com.gettogether.domain.models.UserBasicInfo
import com.gettogether.domain.utils.CustomError
import com.gettogether.domain.utils.Resource
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

class UserService {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://localhost:7218/api/User/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService: UserApi = retrofit.create(UserApi::class.java)

    suspend fun createUser(user: UserBasicInfo): Resource<UserResponse> {
        val call = apiService.createUser(user)
        val res = call.awaitResponse()
        return if (res.isSuccessful) {
            Resource.Success(res.body())
        } else {
            Resource.Error(CustomError.ServerError)
        }
    }
}