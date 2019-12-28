package com.selsoft.kyurx.ui.main.prescription

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.selsoft.kyurx.ui.main.MainActivity
import com.selsoft.kyurx.R
import com.selsoft.kyurx.model.Doctor
import com.selsoft.kyurx.model.Medicine
import com.selsoft.kyurx.model.Patient
import com.selsoft.kyurx.model.Prescription
import com.selsoft.kyurx.ui.add_prescription.AddPrescription
import com.selsoft.kyurx.utils.FontUtils

class PrescriptionFragment : Fragment() {

    private lateinit var activity: MainActivity

    @BindView(R.id.prescription_available)
    lateinit var prescriptionAvailable: TextView

    @BindView(R.id.rv_prescription)
    lateinit var prescriptionRV: RecyclerView

    var prescriptions: MutableList<Prescription> = ArrayList()
    lateinit var prescriptionAdapter: PrescriptionAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_prescription, container, false)
        ButterKnife.bind(this, root)

        prescriptionAvailable.typeface = FontUtils.getPrimaryBoldFont(activity)

        createStaticPrescriptions()

        prescriptionRV.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        prescriptionAdapter = PrescriptionAdapter(activity, prescriptions)
        prescriptionRV.adapter = prescriptionAdapter

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
            } else {
                prescription.doctor = doctor2
                prescription.patient = patient2
                prescription.medicines.add(Medicine())
                prescription.medicines.add(Medicine())
                prescription.medicines.add(Medicine())
                prescription.medicines.add(Medicine())
            }
            prescription.createdDate = "Dec 22 at 11:00 AM"
            prescriptions.add(prescription)

        }

    }

    @OnClick(R.id.add_prescription)
    fun addPrescriptionTapped(view: View) {
        startActivity(Intent(activity, AddPrescription::class.java))
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        activity = context as MainActivity
    }
}