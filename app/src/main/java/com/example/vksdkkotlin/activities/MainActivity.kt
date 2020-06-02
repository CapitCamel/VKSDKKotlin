package com.example.vksdkkotlin.activities

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
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
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthCallback
import com.vk.api.sdk.utils.VKUtils

class MainActivity : MvpAppCompatActivity(), MainListener {


    private val  TAG: String = MainActivity::class.java.simpleName
    lateinit var loginFragment: LoginFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, LoginFragment()).commit()

//        val fingerprints = VKUtils.getCertificateFingerprint(this, this.packageName)
//        Log.e(TAG, "Fingerprint ${fingerprints?.get(0)}")

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val callback = object: VKAuthCallback {
            override fun onLogin(token: VKAccessToken) {
                openFriendFragment()
            }

            override fun onLoginFailed(errorCode: Int) {
                loginFragment.showError("error")
            }
        }
        if (data == null || !VK.onActivityResult(requestCode, resultCode, data, callback)) {
            super.onActivityResult(requestCode, resultCode, data)
        }
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
