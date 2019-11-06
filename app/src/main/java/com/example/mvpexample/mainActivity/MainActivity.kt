package com.example.mvpexample.mainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvpexample.R
import com.example.mvpexample.data.pojo.User
import com.example.mvpexample.data.repositories.UserRepositoryImpl
import com.example.mvpexample.utils.showErrorMessage
import com.example.mvpexample.utils.showSuccessMessage
import com.example.mvpexample.utils.showValidateErrorMessage
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {
    private val presenter: MainContract.Presenter
            by lazy { MainPresenter(this, UserRepositoryImpl()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.loadUsers()
        setOnClickListeners()
    }

    private fun setOnClickListeners(){
        setAddClickListener()
        setEditClickListener()
        setDeleteClickListener()
    }

    private fun setAddClickListener(){
        add_user_mainActivity.setOnClickListener {
            val userToAdd = User(4, userName_mainActivity.text.toString(),
                userSurname_mainActivity.text.toString()
            )
            presenter.addUser(userToAdd)
        }
    }

    private fun setEditClickListener(){
        edit_user_mainActivity.setOnClickListener {
            val userId = edit_userId_mainActivity.text.toString().toInt()
            val userToEdit = User(
                edit_userId_mainActivity.text.toString().toInt(),
                edit_userName_mainActivity.text.toString(),
                edit_userSurname_mainActivity.text.toString()
            )
            presenter.editUser(userId, userToEdit)
        }
    }

    private fun setDeleteClickListener(){
        delete_user_mainActivity.setOnClickListener {
            val userId = delete_userId_mainActivity.text.toString().toInt()
            presenter.deleteUser(userId)
        }
    }

    override fun showUserList(userList: List<User>) {
        val userAdapter = UserAdapter(userList, this)
        userList_mainActivity.adapter = userAdapter
        userList_mainActivity.layoutManager = LinearLayoutManager(this)
    }

    override fun showError(message: String?) {
        showErrorMessage(message)
    }

    override fun showSuccess() {
        showSuccessMessage()
    }

    override fun showValidateError() {
        showValidateErrorMessage()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}
