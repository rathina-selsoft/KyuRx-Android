package com.selsoft.kyurx.utils

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Context
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import com.selsoft.kyurx.model.User

class Utils {
    companion object{

        var user: User? = null
        var token: String? = null

        fun log(message: String) {
            Log.e("KyuRX ->", message)
        }

        fun getProgDialog(context: Context): ProgressDialog {
            val progDialog = ProgressDialog(context)
            progDialog.setMessage("Loading...")
            progDialog.isIndeterminate = false
            progDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER)
            progDialog.setCancelable(false)
            return progDialog
        }

        fun defaultString(string: String?): String {
            return if (string == null || string == "")
                ""
            else
                string
        }

        fun isValid(string: String): Boolean {
            return !(string == "" || string == "null")
        }

        fun isValidEmail(target: String): Boolean {
            return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
        }

        @SuppressLint("ShowToast")
        fun showToast(context: Context, message: String) : Toast {
            val toast = Toast.makeText(context, message, Toast.LENGTH_LONG)
            return toast
        }
    }
}