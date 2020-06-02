package com.example.vksdkkotlin.providers

import android.os.Handler
import com.example.vksdkkotlin.models.FriendModel
import com.example.vksdkkotlin.presenters.FriendsPresentor


class FrendsProvider(var presentor: FriendsPresentor) {

    fun testLoadFrends(hasFriend: Boolean){
        Handler().postDelayed({
            val friendList: ArrayList<FriendModel> = ArrayList()
            if (hasFriend){
                val friend1 = FriendModel(name = "Ivan", surname = "Komov", city = "Кинешма",
                    avatar = "https://sun9-10.userapi.com/c636330/v636330883/2a476/PG0hl2K6jYA.jpg", isOnline = true)

                val friend2 = FriendModel(name = "Алена", surname = "Бойкова", city = "Москва",
                    avatar = "https://sun9-50.userapi.com/c206616/v206616808/de8f4/ZMPuO3zSe1U.jpg", isOnline = true)

                val friend3 = FriendModel(name = "кукиш", surname = "Хасл", city = null,
                    avatar = "https://upload.wikimedia.org/wikipedia/commons/8/88/%D0%9B%D0%B8%D0%BE%D0%BD_%D0%BB%D1%83%D1%87%D1%88%D0%B8%D0%B9_%D1%80%D1%8D%D0%BF%D0%B5%D1%80_%D0%A3%D0%BA%D1%80%D0%B0%D0%B8%D0%BD%D1%8B.jpg",
                    isOnline = true)

                friendList.add(friend1)
                friendList.add(friend2)
                friendList.add(friend3)
            }

            presentor.friendLoaded(friendList = friendList)
        },2000)
    }

    fun loadFriends(){

    }
}