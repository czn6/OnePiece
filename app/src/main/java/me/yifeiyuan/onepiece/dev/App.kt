package me.yifeiyuan.onepiece.dev

import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import me.yifeiyuan.onepiece.foundation.hook.AMSHook

/**
 * Created by 程序亦非猿 on 2022/7/25.
 */
class App : Application(), ViewModelStoreOwner {

    val appViewModelStore = ViewModelStore()

    companion object{
        lateinit var application : Context
        private const val TAG = "App"
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate() called")
        application = this
        AMSHook.hookAMS(
            object : AMSHook.IActivityHookCallback {
                override fun onStartActivity(intent: Intent) {
                    Log.d(TAG, "onStartActivity() called with: intent = $intent")
                }
            })
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    override fun getViewModelStore(): ViewModelStore {
        return appViewModelStore
    }
}