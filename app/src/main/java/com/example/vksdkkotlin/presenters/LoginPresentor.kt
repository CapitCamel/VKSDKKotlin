package com.example.vksdkkotlin.presenters

import android.os.Handler
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.vksdkkotlin.views.LoginView

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
}