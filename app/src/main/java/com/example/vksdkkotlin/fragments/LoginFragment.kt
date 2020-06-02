package com.example.vksdkkotlin.fragments

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter

import com.example.vksdkkotlin.R
import com.example.vksdkkotlin.activities.FriendsActivity
import com.example.vksdkkotlin.activities.MainActivity
import com.example.vksdkkotlin.presenters.LoginPresentor
import com.example.vksdkkotlin.views.LoginView
import com.github.rahatarmanahmed.cpv.CircularProgressView
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKScope
import com.example.vksdkkotlin.activities.MainListener as MainListener1


class LoginFragment : MvpAppCompatFragment(), LoginView {

    private lateinit var mListener: MainActivity



    private lateinit var mWait: CircularProgressView
    private lateinit var mTxtHello: TextView
    private lateinit var mBtnEnter: Button

    @InjectPresenter
    lateinit var loginPresentor: LoginPresentor

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view: View = inflater.inflate(R.layout.fragment_login, container, false)
        //return inflater.inflate(R.layout.fragment_login, container, false)
        mTxtHello = view.findViewById(R.id.txt_login_hello)
        mBtnEnter = view.findViewById(R.id.buttonEnter)
        mWait = view.findViewById(R.id.progress_view)

        //friendsFragment = FriendsFragment()
        //mListener = MainActivity()


        mBtnEnter.setOnClickListener {
            //loginPresentor.login(true)
            VK.login(this.requireActivity(), arrayListOf(VKScope.PHOTOS))
        }

        return view
    }


    override fun startLoading() {
        mBtnEnter.visibility = View.GONE
        mWait.visibility = View.VISIBLE
    }

    override fun endLoading() {
        mBtnEnter.visibility = View.VISIBLE
        mWait.visibility = View.GONE
    }

    override fun showError(text: String) {
        Toast.makeText(activity, text, Toast.LENGTH_SHORT).show()
    }

    override fun openFrends() {
        //startActivity(Intent(activity, FriendsActivity::class.java))
        mListener.openFriendFragment()


    }

    override fun onAttach(context: Context) {

        super.onAttach(context)

        if(context is MainListener1){

            mListener =  context as MainActivity
        }
    }



}
