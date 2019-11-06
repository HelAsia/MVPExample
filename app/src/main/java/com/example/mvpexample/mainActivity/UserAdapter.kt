package com.example.mvpexample.mainActivity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mvpexample.R
import com.example.mvpexample.data.pojo.User
import kotlinx.android.synthetic.main.one_user_card.view.*

/**
 * Created by Joanna Heluszka on 05.11.2019.
 */
class UserAdapter(users: List<User>, private val context: Context) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    private var users: List<User> = listOf()

    init {
        this.users = users
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.one_user_card, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(users[position])

        holder.itemView.setOnClickListener {
            Toast.makeText(context,
                context.resources.getString(R.string.users_list_clicked) + users[position].id,
                Toast.LENGTH_LONG).show()
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: User){
            itemView.name_UserOneCard.text = user.name
            itemView.surname_UserOneCard.text = user.surname
        }
    }
}