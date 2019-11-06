package com.example.mvpexample.data.network

import com.example.mvpexample.data.pojo.User
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import retrofit2.http.*

/**
 * Created by Joanna Heluszka on 05.11.2019.
 */
interface UserAPI {
    @POST("users/")
    fun addUser(@Body user: User): Single<User>

    @PUT("users/{userId}/")
    fun editUser(@Path("userId") userId: Int, @Body user: User): Single<User>

    @GET("users/")
    fun getUsers(): Maybe<List<User>>

    @DELETE("users/{userId}/")
    fun deleteUser(@Path("userId") userId: Int): Completable
}