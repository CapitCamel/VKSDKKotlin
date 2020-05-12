package com.example.vksdkkotlin.fragments


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter

import com.example.vksdkkotlin.R
import com.example.vksdkkotlin.activities.MainListener
import com.example.vksdkkotlin.adapters.FrendAdapter
import com.example.vksdkkotlin.models.FriendModel
import com.example.vksdkkotlin.presenters.FriendsPresentor
import com.example.vksdkkotlin.views.FriendsView
import com.github.rahatarmanahmed.cpv.CircularProgressView


class FriendsFragment : MvpAppCompatFragment(), FriendsView {

    @InjectPresenter
    lateinit var friendsPresenter: FriendsPresentor

    private lateinit var mListener: MainListener

    private lateinit var mRVFriends: RecyclerView
    private lateinit var mNoItem: TextView
    private lateinit var mCPVWait: CircularProgressView
    private lateinit var mAdapter: FrendAdapter

    @SuppressLint("WrongConstant")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_friends, container, false)

        var view: View = inflater.inflate(R.layout.fragment_friends, container, false)

        mRVFriends = view.findViewById(R.id.recycler_friends)
        mNoItem = view.findViewById(R.id.friends_no_item)
        mCPVWait = view.findViewById(R.id.cpv_friend)

        friendsPresenter.loadFriend()
        mAdapter = FrendAdapter()
        mRVFriends.adapter = mAdapter
        mRVFriends.layoutManager = LinearLayoutManager(activity, OrientationHelper.VERTICAL, false)
        mRVFriends.setHasFixedSize(true)

        return view
    }

    override fun showEror(text: Int) {
        mNoItem.text = getString(text)
    }

    override fun setupEmptyList() {
        mRVFriends.visibility = View.GONE
        mNoItem.visibility = View.VISIBLE
    }

    override fun setupFrendList(friendList: ArrayList<FriendModel>) {
        mRVFriends.visibility = View.VISIBLE
        mNoItem.visibility = View.GONE

        mAdapter.setupFriend(friendList = friendList)
    }

    override fun startLoad() {
        mRVFriends.visibility = View.GONE
        mNoItem.visibility = View.GONE
        mCPVWait.visibility = View.VISIBLE
    }

    override fun endLoad() {
        mCPVWait.visibility = View.GONE
    }





}
