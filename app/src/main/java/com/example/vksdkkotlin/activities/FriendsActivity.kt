package com.example.vksdkkotlin.activities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.vksdkkotlin.R
import com.example.vksdkkotlin.adapters.FrendAdapter
import com.example.vksdkkotlin.models.FriendModel
import com.example.vksdkkotlin.presenters.FriendsPresentor
import com.example.vksdkkotlin.views.FriendsView
import com.github.rahatarmanahmed.cpv.CircularProgressView

class FriendsActivity : MvpAppCompatActivity(), FriendsView {


    @InjectPresenter
    lateinit var friendsPresenter: FriendsPresentor
    lateinit var toolbar: Toolbar

    private lateinit var mRVFriends: RecyclerView
    private lateinit var mNoItem: TextView
    private lateinit var mCPVWait: CircularProgressView
    private lateinit var mAdapter: FrendAdapter

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frends)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        mRVFriends = findViewById(R.id.recycler_friends)
        mNoItem = findViewById(R.id.friends_no_item)
        mCPVWait = findViewById(R.id.cpv_friend)

        friendsPresenter.loadFriend()
        mAdapter = FrendAdapter()
        mRVFriends.adapter = mAdapter
        mRVFriends.layoutManager = LinearLayoutManager(applicationContext, OrientationHelper.VERTICAL, false)
        mRVFriends.setHasFixedSize(true)
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
