package com.example.vksdkkotlin.activities

import android.app.Application
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKScope

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
            //VK.login(activity, arrayListOf(VKScope.WALL, VKScope.FRIENDS))
    }
}