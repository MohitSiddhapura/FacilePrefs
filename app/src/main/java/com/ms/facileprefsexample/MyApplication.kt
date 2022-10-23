package com.ms.facileprefsexample

import android.app.Application
import com.ms.facileprefs.FacilePrefs

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        FacilePrefs.context = this
    }
}