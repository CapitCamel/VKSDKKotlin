package com.example.vksdkkotlin.activities

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.vksdkkotlin.R
import com.example.vksdkkotlin.fragments.FriendsFragment
import com.example.vksdkkotlin.fragments.LoginFragment
import com.example.vksdkkotlin.presenters.LoginPresentor
import com.example.vksdkkotlin.views.LoginView
import com.github.rahatarmanahmed.cpv.CircularProgressView

class MainActivity : MvpAppCompatActivity(), MainListener {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, LoginFragment()).commit()


    }

    override fun openFriendFragment() {
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fragment_container, FriendsFragment())
//            .commit()

        var fm: FragmentManager = supportFragmentManager
        var fragment: MvpAppCompatFragment = fm.findFragmentById(R.id.fragment_container) as MvpAppCompatFragment

        if (fragment is LoginFragment ){
            var fragmentReplace: MvpAppCompatFragment = FriendsFragment()
            fm.beginTransaction()
                .replace(R.id.fragment_container, fragmentReplace)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()
        }
    }


}
