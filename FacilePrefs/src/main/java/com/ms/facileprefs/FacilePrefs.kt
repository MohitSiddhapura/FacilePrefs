package com.ms.facileprefs

import android.content.Context
import android.content.ContextWrapper
import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/*
* Created by Mohit Siddhapura
**/

class FacilePrefs<T : Any>(val klass: Class<T>) : ReadWriteProperty<Any?, T?> {

    override fun getValue(thisRef: Any?, property: KProperty<*>): T? {
        removeKey = property.name
        if (sharedPreferences == null) {
            throw Exception(errorMessage)
        }

        return when {
            klass.isAssignableFrom("".javaClass) -> {
                sharedPreferences?.getString(property.name, null) as? T?
            }
            klass.isAssignableFrom(1.javaClass) -> {
                val dummy = sharedPreferences?.getInt(property.name, -1)
                if (dummy == -1) {
                    null
                } else {
                    dummy as T?
                }

            }
            klass.isAssignableFrom(true.javaClass) -> {
                sharedPreferences?.getBoolean(property.name, false) as? T?
            }
            klass.isAssignableFrom(0f.javaClass) -> {
                val dummy = sharedPreferences?.getFloat(property.name, -1f)
                if (dummy == -1f) {
                    null
                } else {
                    dummy as? T?
                }
            }
            klass.isAssignableFrom(0.0.javaClass) -> {
                val dummy = sharedPreferences?.getLong(property.name, java.lang.Double.doubleToRawLongBits(-1.0))
                    ?.let { java.lang.Double.longBitsToDouble(it) }
                if (dummy == java.lang.Double.longBitsToDouble(java.lang.Double.doubleToRawLongBits(-1.0))) {
                    null
                } else {
                    dummy as? T?
                }
            }
            klass.isAssignableFrom(0L.javaClass) -> {
                val dummy = sharedPreferences?.getLong(property.name, -1L)
                if (dummy == -1L) {
                    null
                } else {
                    dummy as? T?
                }
            }
            else -> {
                null
            }
        }

    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T?) {
        if (sharedPreferences == null) {
            throw Exception(errorMessage)
        }
        sharedPreferences?.edit()?.apply {


            when (value) {
                is String -> {
                    putString(property.name, value)
                }
                is Boolean -> {
                    putBoolean(property.name, value)
                }
                is Int -> {
                    putInt(property.name, value)
                }
                is Float -> {
                    putFloat(property.name, value)
                }
                is Double -> {
                    putLong(property.name, java.lang.Double.doubleToRawLongBits(value))
                }
                is Long -> {
                    putLong(property.name, value)
                }
                else -> {
                    throw UnsupportedOperationException("This Data Type is not supported yet.")
                }
            }

            apply()
        }


    }

    companion object {

        private var errorMessage = "Add 'MyPrefs.context = this' in Application Class"
        private var removeKey: String = ""


        private const val defaultData = "defaultdata"
        private var sharedPreferences: SharedPreferences? = null

        var context: Context?
            get() {
                return null
            }
            set(value) {
                sharedPreferences = value?.getSharedPreferences(defaultData, ContextWrapper.MODE_PRIVATE)
            }


        fun clear() {
            if (sharedPreferences == null) {
                throw Exception(errorMessage)
            } else {
                sharedPreferences?.edit()?.clear()?.apply()
            }
        }

        fun getAll()=sharedPreferences?.all.orEmpty()

        fun remove(key:String){
            sharedPreferences?.edit()?.remove(removeKey)?.apply()
        }

    }

}