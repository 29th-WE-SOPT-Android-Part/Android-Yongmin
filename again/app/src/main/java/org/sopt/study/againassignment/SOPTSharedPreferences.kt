package org.sopt.study.againassignment

import android.content.Context
import android.content.SharedPreferences

object SOPTSharedPreferences {
    private const val USER_AUTH = "USER_AUTH"
    private const val AUTO_LOGIN = "AUTO_LOGIN"

    lateinit var preferences: SharedPreferences

    fun getAutoLogin(context: Context) : Boolean{
        preferences= setpref(context)
        return preferences.getBoolean(AUTO_LOGIN, false)
    }

    fun setAutoLogin(context: Context, auto:Boolean) {
        preferences= setpref(context)

        preferences.edit()
            .putBoolean(AUTO_LOGIN, auto)
            .apply()
    }

    fun removeAutoLogin(context: Context){
        preferences= setpref(context)
        preferences.edit()
            .remove(AUTO_LOGIN)
            .apply()
    }

    fun clearStorage(context:Context){
        preferences = setpref(context)
        preferences.edit()
            .clear()
            .apply()
    }

    fun setpref(context: Context):SharedPreferences{
        val preferences = context.getSharedPreferences(USER_AUTH, Context.MODE_PRIVATE)
        return preferences
    }
}