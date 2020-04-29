package com.example.vksdkkotlin.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.vksdkkotlin.R
import com.example.vksdkkotlin.models.FriendModel
import com.example.vksdkkotlin.providers.FrendsProvider
import com.example.vksdkkotlin.views.FriendsView

@InjectViewState
class FriendsPresentor: MvpPresenter<FriendsView>() {
    fun loadFriend() {
        viewState.startLoad()
        FrendsProvider(this).testLoadFrends(true)
    }

    fun friendLoaded(friendList: ArrayList<FriendModel>){
        viewState.endLoad()
        if(friendList.size == 0){
            //viewState.showEror(R.string.friends_no_item)
            viewState.setupEmptyList()
            viewState.showEror(R.string.friends_no_item)
        }else{
            viewState.setupFrendList(friendList = friendList)
        }
    }
}