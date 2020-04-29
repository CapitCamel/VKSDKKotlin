package com.example.vksdkkotlin.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.vksdkkotlin.R
import com.example.vksdkkotlin.presenters.LoginPresentor
import com.example.vksdkkotlin.views.LoginView
import com.github.rahatarmanahmed.cpv.CircularProgressView

class MainActivity : MvpAppCompatActivity(), LoginView {


    private lateinit var mWait: CircularProgressView
    private lateinit var mTxtHello: TextView
    private lateinit var mBtnEnter: Button

    @InjectPresenter
    lateinit var loginPresentot: LoginPresentor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        mTxtHello = findViewById(R.id.txt_login_hello)
        mBtnEnter = findViewById(R.id.buttonEnter)
        mWait = findViewById(R.id.progress_view)

        mBtnEnter.setOnClickListener {
            loginPresentot.login(true)
        }
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
        Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT).show()
    }

    override fun openFrends() {
        startActivity(Intent(applicationContext, FriendsActivity::class.java))
    }

}
