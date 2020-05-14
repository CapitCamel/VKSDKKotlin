package com.example.vksdkkotlin.activities

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.MvpAppCompatFragment
import com.example.vksdkkotlin.R
import com.example.vksdkkotlin.fragments.FriendsFragment
import com.example.vksdkkotlin.fragments.LoginFragment
//import com.vk.sdk.util.VKUtil
//import com.vk.api.sdk.utils.VKUtils
import com.vk.sdk.util.VKUtil


class MainActivity : MvpAppCompatActivity(), MainListener {

    private val TAG: String = MainActivity::class.java.simpleName



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, LoginFragment()).commit()

//        val fingerprints: Array<String?>? = VKUtil.getCertificateFingerprint(this, this.packageName)
//        Log.e(TAG, "fingerprint ${fingerprints?.get(0)}")

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
