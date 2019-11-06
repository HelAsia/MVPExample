package com.example.mvpexample.data.repositories

import com.example.mvpexample.data.network.RetrofitUtils
import com.example.mvpexample.data.network.UserAPI
import com.example.mvpexample.data.pojo.User
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

/**
 * Created by Joanna Heluszka on 05.11.2019.
 */
class UserRepositoryImpl: UserRepository {
    private val retrofit: Retrofit by lazy {RetrofitUtils.createRetrofitInstance()}
    private val userAPI: UserAPI by lazy { retrofit.create(UserAPI::class.java) }

    override fun addUser(user: User): Single<User> {
        return userAPI.addUser(user)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun editUser(userId: Int, user: User): Single<User> {
        return userAPI.editUser(userId, user)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getUsers(): Maybe<List<User>> {
        return userAPI.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun deleteUser(userId: Int): Completable {
        return userAPI.deleteUser(userId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}