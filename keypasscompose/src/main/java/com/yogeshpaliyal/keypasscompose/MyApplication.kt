package com.yogeshpaliyal.keypasscompose

import android.content.Intent
import com.yogeshpaliyal.common.CommonMyApplication
import com.yogeshpaliyal.keypasscompose.ui.CrashActivity
import dagger.hilt.android.HiltAndroidApp

/*
* @author Yogesh Paliyal
* yogeshpaliyal.foss@gmail.com
* https://techpaliyal.com
* created on 22-01-2021 22:41
*/
@HiltAndroidApp
class MyApplication : CommonMyApplication() {

    override fun getCrashActivityIntent(throwable: Throwable): Intent {
        return CrashActivity.getIntent(this, throwable.localizedMessage)
    }
}
