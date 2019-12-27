package com.selsoft.kyurx.ui.login

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.selsoft.kyurx.R
import com.selsoft.kyurx.model.Doctor
import com.selsoft.kyurx.ui.login.adapter.DoctorAdapter
import com.selsoft.kyurx.utils.FontUtils
import com.selsoft.kyurx.utils.SessionManager
import com.selsoft.kyurx.utils.Utils

class RegisterActivity : AppCompatActivity() {

    @BindView(R.id.txt_register)
    lateinit var registerTxt: TextView

    @BindView(R.id.org_name)
    lateinit var orgName: EditText

    @BindView(R.id.org_email)
    lateinit var orgEmail: EditText

    @BindView(R.id.password)
    lateinit var password: EditText

    @BindView(R.id.txt_doctor_count)
    lateinit var doctorCountTxt: TextView

    @BindView(R.id.rv_doctor)
    lateinit var doctorRV: RecyclerView

    @BindView(R.id.ly_doctor_count)
    lateinit var doctorsCountLy: LinearLayout

    @BindView(R.id.add_doctor)
    lateinit var addDoctorIcon: TextView

    @BindView(R.id.org_doctors)
    lateinit var orgDoctors: TextView

    lateinit var progressDialog: ProgressDialog
    lateinit var sessionManager: SessionManager
    lateinit var context: Context

    lateinit var doctorAdapter: DoctorAdapter
    var doctors: MutableList<Doctor> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        ButterKnife.bind(this)

        doctorRV.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        doctorAdapter = DoctorAdapter(this, doctors)
        doctorRV.adapter = doctorAdapter

        setFontStyle()
        context = this

    }

    @OnClick(R.id.add_doctor)
    fun openAddDoctorDialog(view: View) {
        val addDoctorDialog = AlertDialog.Builder(this)
        val addDoctorView = this.layoutInflater.inflate(R.layout.add_doctor_view, null)
        addDoctorDialog.setView(addDoctorView)
        val alertDialog = addDoctorDialog.create()
        val addDoctorTxt = addDoctorView.findViewById(R.id.add_doctor) as TextView
        val doctorName = addDoctorView.findViewById(R.id.dr_name) as EditText
        val doctorEmail = addDoctorView.findViewById(R.id.dr_email) as EditText
        val doctorPhone = addDoctorView.findViewById(R.id.dr_phone) as EditText
        val saveBtn = addDoctorView.findViewById(R.id.btn_save) as Button
        val cancelBtn = addDoctorView.findViewById(R.id.btn_cancel) as Button

        saveBtn.setOnClickListener {
            val doctor = Doctor()
            doctor.firstName = doctorName.text.toString()
            doctor.emailId = doctorEmail.text.toString()
            doctor.phoneNumber = doctorPhone.text.toString()

            doctors.add(doctor)
            getDoctorsViews()
            alertDialog.dismiss()

            doctorAdapter.notifyDataSetChanged()
        }

        cancelBtn.setOnClickListener {
            doctorAdapter.notifyDataSetChanged()
            getDoctorsViews()
            alertDialog.dismiss()
        }


        val primary: Typeface = FontUtils.getPrimaryBoldFont(this)
        val boldFont: Typeface = FontUtils.getPrimaryBoldFont(this)

        addDoctorTxt.typeface = boldFont
        doctorName.typeface = primary
        doctorEmail.typeface = primary
        doctorPhone.typeface = primary
        saveBtn.typeface = boldFont
        cancelBtn.typeface = boldFont

        alertDialog.show()

    }


    override fun onResume() {
        super.onResume()

        getDoctorsViews()
    }

    @SuppressLint("SetTextI18n")
    private fun getDoctorsViews() {
        doctorCountTxt.text = "Doctor Count: ${doctors.size}"

        if (doctors.size == 0) {
            doctorCountTxt.visibility = View.VISIBLE
            doctorsCountLy.visibility = View.GONE
        } else {
            doctorCountTxt.visibility = View.GONE
            doctorsCountLy.visibility = View.VISIBLE
        }
    }

    private fun setFontStyle() {
        val primary: Typeface = FontUtils.getPrimaryBoldFont(this)
        val boldFont: Typeface = FontUtils.getPrimaryBoldFont(this)

        registerTxt.typeface = boldFont
        orgName.typeface = primary
        orgEmail.typeface = primary
        password.typeface = primary
        doctorCountTxt.typeface = boldFont
        orgDoctors.typeface = boldFont

    }

}
