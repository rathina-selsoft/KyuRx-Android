package com.selsoft.kyurx.ui.login

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.selsoft.kyurx.R
import com.selsoft.kyurx.model.User
import com.selsoft.kyurx.ui.main.MainActivity
import com.selsoft.kyurx.utils.FontUtils
import com.selsoft.kyurx.utils.SessionManager
import com.selsoft.kyurx.utils.Utils

class LoginActivity : AppCompatActivity() {

    @BindView(R.id.txt_welcome)
    lateinit var welcomeTxt: TextView

    @BindView(R.id.ly_email)
    lateinit var emailLy: LinearLayout

    @BindView(R.id.user_email)
    lateinit var userEmail: EditText

    @BindView(R.id.password)
    lateinit var password: EditText

    @BindView(R.id.btn_login)
    lateinit var loginBtn: Button

    @BindView(R.id.forget_password)
    lateinit var forgetPassword: TextView

    @BindView(R.id.register)
    lateinit var register: TextView

    lateinit var progressDialog: ProgressDialog
    lateinit var sessionManager: SessionManager
    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        ButterKnife.bind(this)

        setFontStyle()
        sessionManager = SessionManager(this)
        progressDialog = Utils.getProgDialog(this)
        context = this
    }

    @OnClick(R.id.btn_login)
    fun loginTapped(view: View) {
        val user = User()
        user.email = userEmail.text.toString()
        user.phoneNumber = password.text.toString()

        val sessionManager = SessionManager(this)
        sessionManager.setUserDetails(user)
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    @OnClick(R.id.register)
    fun moveToRegister() {
        context.startActivity(Intent(context, RegisterActivity::class.java))
        finish()
    }

    private fun setFontStyle() {
        val primary: Typeface = FontUtils.getPrimaryBoldFont(this)
        val boldFont: Typeface = FontUtils.getPrimaryBoldFont(this)

        welcomeTxt.typeface = boldFont
        userEmail.typeface = primary
        password.typeface = primary
        loginBtn.typeface = boldFont
        forgetPassword.typeface = boldFont
        register.typeface = boldFont
    }
}
