package com.example.mvpexample.mainActivity

import com.example.mvpexample.data.pojo.User

/**
 * Created by Joanna Heluszka on 05.11.2019.
 */
interface MainContract {
    interface View{
        fun showUserList(userList: List<User>)
        fun showError(message: String?)
        fun showValidateError()
        fun showSuccess()
    }

    interface Presenter {
        fun addUser(user: User)
        fun editUser(userId: Int, user: User)
        fun loadUsers()
        fun deleteUser(userId: Int)
        fun onDestroy()
    }
}