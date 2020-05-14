package com.example.vksdkkotlin.activities

import android.app.Application
import android.content.Context
import com.vk.sdk.VKSdk

class MyAplication: Application() {
    override fun onCreate() {
        super.onCreate()
        VKSdk.initialize(applicationContext)
    }
}