package com.example.vksdkkotlin.presenters

import android.content.Intent
import android.os.Handler
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.vksdkkotlin.views.LoginView
import com.vk.sdk.VKAccessToken
import com.vk.sdk.VKCallback
import com.vk.sdk.VKSdk
import com.vk.sdk.api.VKError
import kotlin.time.days

@InjectViewState
class LoginPresentor: MvpPresenter<LoginView>() {
    fun login(isSuccess: Boolean) {
        viewState.startLoading()

        Handler().postDelayed({
            viewState.endLoading()
            if(isSuccess){
                viewState.openFrends()
            }else{
                viewState.showError("Error")
            }
        },500)
    }

    fun loginVK(requestCode: Int, resultCode: Int, data: Intent?): Boolean {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, object : VKCallback<VKAccessToken>{
                override fun onResult(res: VKAccessToken?) {
                    viewState.openFrends()
                }

                override fun onError(error: VKError?) {
                    viewState.showError("Error")
                }
            })){return false}
        return true
    }


}