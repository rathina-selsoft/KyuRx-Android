package com.selsoft.kyurx.ui.main.patient

import android.app.AlertDialog
import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.selsoft.kyurx.R
import com.selsoft.kyurx.model.Patient
import com.selsoft.kyurx.ui.login.adapter.DoctorAdapter
import com.selsoft.kyurx.ui.main.MainActivity
import com.selsoft.kyurx.utils.FontUtils
import com.selsoft.kyurx.utils.Utils

class PatientFragment : Fragment() {

    private lateinit var activity: MainActivity

    @BindView(R.id.rv_patient)
    lateinit var patientRV: RecyclerView

    @BindView(R.id.patient_available)
    lateinit var patientAvailable: TextView

    var patients: MutableList<Patient> = ArrayList()
    lateinit var patientAdapter: PatientAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_patient, container, false)
        ButterKnife.bind(this, root)

        val boldFont: Typeface = FontUtils.getPrimaryBoldFont(activity)
        patientAvailable.typeface = boldFont

        patientRV.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        patientAdapter = PatientAdapter(activity, patients)
        patientRV.adapter = patientAdapter

        getPatientsViews()
        return root
    }

    override fun onResume() {
        super.onResume()
        getPatientsViews()
        patientAdapter.notifyDataSetChanged()
    }

    @OnClick(R.id.add_patient)
    fun addPatient(view: View) {
        val addPatientDialog = AlertDialog.Builder(activity)
        val addPatientView = this.layoutInflater.inflate(R.layout.add_patient_view, null)
        addPatientDialog.setView(addPatientView)
        val alertDialog = addPatientDialog.create()

        val addPatientTxt = addPatientView.findViewById(R.id.add_patient) as TextView
        val firstName = addPatientView.findViewById(R.id.first_name) as EditText
        val lastName = addPatientView.findViewById(R.id.last_name) as EditText
        val emailId = addPatientView.findViewById(R.id.email) as EditText
        val phoneNumber = addPatientView.findViewById(R.id.phone) as EditText
        val saveBtn = addPatientView.findViewById(R.id.btn_save) as Button
        val cancelBtn = addPatientView.findViewById(R.id.btn_cancel) as Button

        saveBtn.setOnClickListener {
            val patient = Patient()
            patient.firstName = firstName.text.toString()
            patient.lastName = lastName.text.toString()
            patient.emailId = emailId.text.toString()
            patient.phoneNumber = phoneNumber.text.toString()

            patients.add(patient)
            getPatientsViews()
            alertDialog.dismiss()

            patientAdapter.notifyDataSetChanged()
        }

        cancelBtn.setOnClickListener {
            alertDialog.dismiss()
        }


        val primary: Typeface = FontUtils.getPrimaryBoldFont(activity)
        val boldFont: Typeface = FontUtils.getPrimaryBoldFont(activity)

        addPatientTxt.typeface = boldFont
        firstName.typeface = primary
        lastName.typeface = primary
        emailId.typeface = primary
        phoneNumber.typeface = primary
        saveBtn.typeface = boldFont
        cancelBtn.typeface = boldFont

        alertDialog.show()
    }

    private fun getPatientsViews() {
        if (patients.size == 0) {
            patientAvailable.visibility = View.VISIBLE
            patientRV.visibility = View.GONE
        } else {
            patientAvailable.visibility = View.GONE
            patientRV.visibility = View.VISIBLE
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        activity = context as MainActivity
    }
}