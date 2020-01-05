package com.selsoft.kyurx.ui.main.medicine_status

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.selsoft.kyurx.R
import com.selsoft.kyurx.model.Doctor
import com.selsoft.kyurx.model.Medicine
import com.selsoft.kyurx.model.Patient
import com.selsoft.kyurx.model.Prescription
import com.selsoft.kyurx.ui.main.PatientMain

class MedicineStatus : Fragment() {

    private lateinit var activity: PatientMain

    @BindView(R.id.rv_medicine_status)
    lateinit var medicineStatusRV: RecyclerView

    var prescriptions: MutableList<Prescription> = ArrayList()
    lateinit var medicineStatusAdapter: MedicineStatusAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_medicine_status, container, false)
        ButterKnife.bind(this, root)

        createStaticPrescriptions()

        medicineStatusRV.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        medicineStatusAdapter = MedicineStatusAdapter(activity, prescriptions)
        medicineStatusRV.adapter = medicineStatusAdapter

        return root
    }

    private fun createStaticPrescriptions() {
        val patient = Patient()
        patient.firstName = "Rathina Sabapathi"
        patient.lastName = "M"

        val patient2 = Patient()
        patient2.firstName = "Raghul"
        patient2.lastName = "Raj"

        val doctor = Doctor()
        doctor.firstName = "Ramesh"
        doctor.lastName = "Rasaiyan"

        val doctor2 = Doctor()
        doctor2.firstName = "Pushban"
        doctor2.lastName = "Rasaiyan"


        for (x in 0..5) {
            val prescription = Prescription()
            if (x % 2 == 0) {
                prescription.doctor = doctor
                prescription.patient = patient
                prescription.medicines.add(Medicine())
                prescription.medicines.add(Medicine())
                prescription.orgName = "Saba Clinic"
            } else {
                prescription.doctor = doctor2
                prescription.patient = patient2
                prescription.medicines.add(Medicine())
                prescription.medicines.add(Medicine())
                prescription.medicines.add(Medicine())
                prescription.medicines.add(Medicine())
                prescription.orgName = "Raghul Clinic"
            }
            prescription.createdDate = "Dec 22 at 11:00 AM"
            prescriptions.add(prescription)

        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        activity = context as PatientMain
    }


}
