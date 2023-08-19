package com.gettogether.data.network.api

import com.gettogether.data.network.models.UserResponse
import com.gettogether.domain.models.UserBasicInfo
import retrofit2.Call
import retrofit2.http.POST

interface UserApi {
    @POST
    fun createUser(user: UserBasicInfo) : Call<UserResponse>
}