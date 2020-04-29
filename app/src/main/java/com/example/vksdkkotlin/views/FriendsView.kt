package com.example.vksdkkotlin.views

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.vksdkkotlin.models.FriendModel

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface FriendsView: MvpView {
    fun showEror(text: Int)
    fun setupEmptyList()
    fun setupFrendList(friendList: ArrayList<FriendModel>)
    fun startLoad()
    fun endLoad()
}