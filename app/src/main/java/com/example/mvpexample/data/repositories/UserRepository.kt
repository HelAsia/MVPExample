package com.example.mvpexample.data.repositories

import com.example.mvpexample.data.pojo.User
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single

/**
 * Created by Joanna Heluszka on 05.11.2019.
 */
interface UserRepository {
    fun addUser(user: User): Single<User>
    fun editUser(userId: Int, user: User): Single<User>
    fun getUsers(): Maybe<List<User>>
    fun deleteUser(userId: Int): Completable
}