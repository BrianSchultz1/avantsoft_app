package com.example.avantsoft

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.avantsoft.core.UserModel

class UserListAdapter(
    private val users: List<UserModel>
) : RecyclerView.Adapter<UserListAdapter.UserListViewHolder>() {
    class UserListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(user: UserModel) {
            itemView.findViewById<TextView>(R.id.user_name).text = user.name
            itemView.findViewById<TextView>(R.id.user_age).text = user.age.toString()
            itemView.findViewById<TextView>(R.id.user_email).text = user.email
            itemView.findViewById<TextView>(R.id.user_id).text = user.id.toString()
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserListViewHolder {
        val view = View.inflate(parent.context, R.layout.adapter_card, null)
        return UserListViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        holder.bind(users[position])

    }

    override fun getItemCount(): Int {
        return users.size
    }
}