package com.selsoft.kyurx.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.selsoft.kyurx.R
import com.selsoft.kyurx.ui.login.LoginActivity
import com.selsoft.kyurx.ui.login.PatientRegister
import com.selsoft.kyurx.utils.FontUtils
import com.selsoft.kyurx.utils.SessionManager

class Welcome : AppCompatActivity() {

    @BindView(R.id.doctor_portal)
    lateinit var doctorPortal: TextView

    @BindView(R.id.patient_portal)
    lateinit var patientPortal: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        ButterKnife.bind(this)


        doctorPortal.typeface = FontUtils.getPrimaryBoldFont(this)
        patientPortal.typeface = FontUtils.getPrimaryBoldFont(this)

        val sessionManager = SessionManager(this)
        val portalName = sessionManager.getPortalName()

        if (portalName == "Doctor") {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        } else if (portalName == "Patient") {
            startActivity(Intent(this, PatientRegister::class.java))
            finish()
        }


    }

    @OnClick(R.id.doctor_portal)
    fun doctorPortalTapped(view: View) {
        val sessionManager = SessionManager(this)
        sessionManager.selectedPortal("Doctor")

        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    @OnClick(R.id.patient_portal)
    fun patientPortalTapped(view: View) {
        val sessionManager = SessionManager(this)
        sessionManager.selectedPortal("Patient")

        startActivity(Intent(this, PatientRegister::class.java))
        finish()
    }
}
