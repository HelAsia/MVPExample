package com.example.mvpexample.mainActivity

import com.example.mvpexample.data.pojo.User
import com.example.mvpexample.data.repositories.UserRepositoryImpl
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Joanna Heluszka on 05.11.2019.
 */
class MainPresenter(private val userView: MainContract.View,
                    private val userRepositoryImpl: UserRepositoryImpl) : MainContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun addUser(user: User) {
        if(user.name.isEmpty() || user.surname.isEmpty()){
            userView.showValidateError()
        }else {
            compositeDisposable.add(userRepositoryImpl.addUser(user)
                .subscribe(
                    { userView.showSuccess() },
                    { t -> userView.showError(t.message) }
                )
            )
        }
    }

    override fun editUser(userId: Int, user: User) {
        if(userId == 0 || user.name.isEmpty() || user.surname.isEmpty()){
            userView.showValidateError()
        }else {
            compositeDisposable.add(userRepositoryImpl.editUser(userId, user)
                .subscribe(
                    { userView.showSuccess() },
                    { t -> userView.showError(t.message) }
                )
            )
        }
    }

    override fun loadUsers() {
        compositeDisposable.add(userRepositoryImpl.getUsers()
            .subscribe(
                { userView.showUserList(it) },
                { t -> userView.showError(t.message) }
            )
        )
    }

    override fun deleteUser(userId: Int) {
        if(userId == 0){
            userView.showValidateError()
        }else {
            compositeDisposable.add(userRepositoryImpl.deleteUser(userId)
                .subscribe(
                    { userView.showSuccess() },
                    { t -> userView.showError(t.message) }
                )
            )
        }
    }

    override fun onDestroy() {
        compositeDisposable.clear()
    }
}