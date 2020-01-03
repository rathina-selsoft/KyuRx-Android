package com.selsoft.kyurx.ui.add_prescription

import android.annotation.SuppressLint
import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.selsoft.kyurx.R
import com.selsoft.kyurx.model.Doctor
import com.selsoft.kyurx.model.Patient
import com.selsoft.kyurx.utils.FontUtils

class AddPrescription : AppCompatActivity(), View.OnClickListener {

    @BindView(R.id.org_name)
    lateinit var orgName: TextView

    @BindView(R.id.txt_select_doctor)
    lateinit var selectDoctor: TextView

    @BindView(R.id.dr_name)
    lateinit var drName: TextView

    @BindView(R.id.dr_specialist)
    lateinit var drSpecialist: TextView


    @BindView(R.id.txt_select_patient)
    lateinit var selectPatient: TextView

    @BindView(R.id.patient_name)
    lateinit var patientName: TextView

    @BindView(R.id.patient_email)
    lateinit var patientEmail: TextView

    @BindView(R.id.txt_prescription)
    lateinit var prescriptionTxt: TextView

    @BindView(R.id.txt_medicine_available)
    lateinit var medicineAvailable: TextView

    @BindView(R.id.rv_medicine)
    lateinit var medicineRV: RecyclerView

    @BindView(R.id.btn_add_prescription)
    lateinit var addPrescriptionBtn: TextView

    @BindView(R.id.btn_send_kyurx)
    lateinit var sendKyurxBtn: TextView

    lateinit var selectedDoctor: Doctor
    lateinit var selectedPatient: Patient
    lateinit var doctorPatientDialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_prescription)
        ButterKnife.bind(this)


        val actionBar = supportActionBar
        actionBar!!.title = "Add Prescription"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)

        setFontStyle()
    }

    @SuppressLint("InflateParams", "SetTextI18n")
    @OnClick(R.id.choose_doctor)
    fun chooseDoctor(view: View) {

        val chooseDoctorDialog = AlertDialog.Builder(this)
        val chooseDoctorView = this.layoutInflater.inflate(R.layout.choose_doctor, null)
        chooseDoctorDialog.setView(chooseDoctorView)
        doctorPatientDialog = chooseDoctorDialog.create()

        val chooseTxt = chooseDoctorView.findViewById(R.id.choose) as TextView
        val doctorRV = chooseDoctorView.findViewById(R.id.rv_doctor) as RecyclerView

        chooseTxt.text = "Choose Doctor"
        chooseTxt.typeface = FontUtils.getPrimaryBoldFont(this)

        doctorRV.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val doctorAdapter = DoctorPatientAdapter(this, getDoctors())
        doctorAdapter.setClickListener(this)
        doctorRV.adapter = doctorAdapter
        doctorAdapter.notifyDataSetChanged()

        doctorPatientDialog.show()


    }

    private fun getDoctors(): MutableList<*> {
        val doctors: MutableList<Doctor> = ArrayList<Doctor>()
        for (x in 0..8) {
            val doctor = Doctor()
            if (x % 2 == 0) {
                doctor.firstName = "Pushban"
                doctor.lastName = "Rajaiyan"
                doctor.emailId = "pushban@selsoftinc.com"
                doctor.specialist = "ENT"
            } else {
                doctor.firstName = "Ramesh"
                doctor.lastName = "Rajaiyan"
                doctor.emailId = "ramesh@selsoftinc.com"
                doctor.specialist = "Dentist"
            }
            doctors.add(doctor)
        }
        return doctors
    }

    @SuppressLint("SetTextI18n", "InflateParams")
    @OnClick(R.id.choose_patient)
    fun choosePatient(view: View) {
        val chooseDoctorDialog = AlertDialog.Builder(this)
        val chooseDoctorView = this.layoutInflater.inflate(R.layout.choose_doctor, null)
        chooseDoctorDialog.setView(chooseDoctorView)
        doctorPatientDialog = chooseDoctorDialog.create()

        val chooseTxt = chooseDoctorView.findViewById(R.id.choose) as TextView
        val doctorRV = chooseDoctorView.findViewById(R.id.rv_doctor) as RecyclerView

        chooseTxt.text = "Choose Patient"
        chooseTxt.typeface = FontUtils.getPrimaryBoldFont(this)
        doctorRV.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val doctorAdapter = DoctorPatientAdapter(this, getPatients())
        doctorAdapter.setClickListener(this)
        doctorRV.adapter = doctorAdapter
        doctorAdapter.notifyDataSetChanged()

        doctorPatientDialog.show()
    }

    private fun getPatients(): MutableList<*> {
        val patients: MutableList<Patient> = ArrayList<Patient>()
        for (x in 0..8) {
            val patient = Patient()
            if (x % 2 == 0) {
                patient.firstName = "Rathina Sabapathi"
                patient.lastName = "M"
                patient.emailId = "rathina@selsoftinc.com"
            } else {
                patient.firstName = "Raghul"
                patient.lastName = "Raj"
                patient.emailId = "raghul@selsoftinc.com"
            }
            patients.add(patient)
        }
        return patients
    }

    private fun setFontStyle() {
        val primary = FontUtils.getPrimaryFont(this)
        val boldPrimary = FontUtils.getPrimaryBoldFont(this)


        orgName.typeface = boldPrimary
        selectDoctor.typeface = boldPrimary
        selectPatient.typeface = boldPrimary
        drName.typeface = boldPrimary
        drSpecialist.typeface = primary
        patientEmail.typeface = primary
        patientName.typeface = boldPrimary
        prescriptionTxt.typeface = boldPrimary
        medicineAvailable.typeface = boldPrimary
        addPrescriptionBtn.typeface = boldPrimary
        sendKyurxBtn.typeface = boldPrimary

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onClick(adapterView: View?) {
        val model = adapterView?.tag
        if (model is Doctor) {
            selectedDoctor = model

            drName.text = selectedDoctor.firstName
            drSpecialist.text = selectedDoctor.specialist
        } else if (model is Patient) {
            selectedPatient = model

            patientName.text = selectedPatient.firstName
            patientEmail.text = selectedPatient.emailId
        }

        doctorPatientDialog.dismiss()
    }
}
