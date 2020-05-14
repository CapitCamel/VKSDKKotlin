package com.example.vksdkkotlin.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.vksdkkotlin.R
import com.example.vksdkkotlin.activities.MainActivity
import com.example.vksdkkotlin.presenters.LoginPresentor
import com.example.vksdkkotlin.views.LoginView
import com.github.rahatarmanahmed.cpv.CircularProgressView
import com.vk.sdk.VKScope
import com.vk.sdk.VKSdk
//import sun.invoke.util.VerifyAccess.getPackageName
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

//        val fingerprints = VKUtil.getCertificateFingerprint(this, this.getPackageName())

        //friendsFragment = FriendsFragment()
        //mListener = MainActivity()


//        mBtnEnter.setOnClickListener { loginPresentor.login(true) }
        mBtnEnter.setOnClickListener {
            //VKSdk.login(this@LoginFragment, VKScope.FRIENDS)
            VKSdk.login(this.requireActivity(), VKScope.FRIENDS)
        }

        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(!loginPresentor.loginVK(requestCode = requestCode, resultCode = resultCode, data = data)){
        super.onActivityResult(requestCode, resultCode, data)}
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
