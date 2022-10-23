package com.ms.facileprefsexample

import com.ms.facileprefs.FacilePrefs

object Prefs {
    var name by FacilePrefs(String::class.java)
}