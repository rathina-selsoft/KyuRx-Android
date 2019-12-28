package com.selsoft.kyurx.utils

import android.annotation.SuppressLint
import android.content.Context
import com.selsoft.kyurx.model.User

class SessionManager(private val context: Context) {

    fun clear() {
        val editor = context.getSharedPreferences("KyuRX Data", Context.MODE_PRIVATE).edit()
        editor.clear()
        editor.apply()
    }

    fun setAccessToken(accessToken: String) {
        @SuppressLint("CommitPrefEdits")
        val editor = context.getSharedPreferences("KyuRX Data", Context.MODE_PRIVATE).edit()
        editor.putString("token", accessToken)
        editor.apply()
    }

    fun getAccessToken(): String? {
        val prefs = context.getSharedPreferences("KyuRX Data", Context.MODE_PRIVATE)
        return prefs.getString("token", null)
    }

    fun setUserDetails(user: User) {
        @SuppressLint("CommitPrefEdits")
        val editor = context.getSharedPreferences("KyuRX Data", Context.MODE_PRIVATE).edit()
        editor.putString("firstName", user.firstName)
        editor.putString("lastName", user.lastName)
        editor.putString("phoneNumber", user.phoneNumber)
        editor.putString("role", user.role)
        editor.putString("userStatus", user.userStatus)
        editor.putInt("userId", user.userId)
        editor.putString("email", user.email)
        editor.apply()
    }

    fun getUserDetails(): User? {
        val prefs = context.getSharedPreferences("KyuRX Data", Context.MODE_PRIVATE)
        val user = User()
        user.firstName = prefs.getString("firstName", null)
        user.lastName = prefs.getString("lastName", null)
        user.phoneNumber = prefs.getString("phoneNumber", null)
        user.role = prefs.getString("role", null)
        user.userStatus = prefs.getString("userStatus", null)
        user.userId = prefs.getInt("userId", 0)
        user.email = prefs.getString("email", null)
        return user
    }

}