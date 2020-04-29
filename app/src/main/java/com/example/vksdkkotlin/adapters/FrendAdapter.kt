package com.example.vksdkkotlin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.vksdkkotlin.R
import com.example.vksdkkotlin.models.FriendModel
import com.squareup.picasso.Picasso
import com.squareup.picasso.PicassoProvider
import de.hdodenhof.circleimageview.CircleImageView

class FrendAdapter: androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder>(){

    var mFrendList:ArrayList<FriendModel> = ArrayList()

    fun setupFriend(friendList: ArrayList<FriendModel>){
        mFrendList.clear()
        mFrendList.addAll(friendList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return mFrendList.count()
    }

    override fun onBindViewHolder(holder: androidx.recyclerview.widget.RecyclerView.ViewHolder, p1: Int) {
        if(holder is FrendsViewHolder){
            holder.bind(mFrendList[p1])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): androidx.recyclerview.widget.RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.cell_friend, parent, false)
        return FrendsViewHolder(itemView = itemView)
    }

    class FrendsViewHolder(itemView: View): androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView){

        private val mAvatar: CircleImageView = itemView.findViewById(R.id.friends_avatar)
        private val mTxtUsername: TextView = itemView.findViewById(R.id.friends_txt_username)
        private val mTxtCity: TextView = itemView.findViewById(R.id.friends_txt_city)
        private val mImgOnline: View = itemView.findViewById(R.id.friend_img_online)

        fun bind(friendModel: FriendModel){
            friendModel.avatar?.let{ url ->
                Picasso.get().load(url).into(mAvatar)
            }

            mTxtUsername.text = "${friendModel.name} ${friendModel.surname}"
            mTxtCity.text = itemView.context.getString(R.string.friends_no_city)
            //mTxtCity.text = "${friendModel.city}"
            friendModel.city?.let{ mTxtCity.text = it}

            if(friendModel.isOnline){
                mImgOnline.visibility = View.VISIBLE
            }else{
                mImgOnline.visibility = View.GONE
            }
        }
    }

}