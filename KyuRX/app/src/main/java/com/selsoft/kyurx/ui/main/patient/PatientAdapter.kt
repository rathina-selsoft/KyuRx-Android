package com.selsoft.kyurx.ui.main.patient

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.selsoft.kyurx.R
import com.selsoft.kyurx.model.Patient
import com.selsoft.kyurx.utils.FontUtils

class PatientAdapter(
    var context: Context,
    var patients: MutableList<Patient>
) : RecyclerView.Adapter<PatientAdapter.PatientViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.patient_row, parent, false)
        return PatientViewHolder(v)
    }

    override fun getItemCount(): Int {
        return patients.size
    }

    override fun onBindViewHolder(holder: PatientViewHolder, position: Int) {

        val patient: Patient = patients[position]

        holder.patientRow.tag = patient
        holder.fullName.text = "${patient.firstName.toString()} ${patient.lastName.toString()}"
        holder.email.text = patient.emailId
        holder.phoneNumber.text = patient.phoneNumber

        val primary: Typeface = FontUtils.getPrimaryFont(context)
        val boldFont: Typeface = FontUtils.getPrimaryBoldFont(context)

        holder.email.typeface = primary
        holder.phoneNumber.typeface = primary
        holder.fullName.typeface = boldFont

    }

    class PatientViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        @BindView(R.id.ly_patient_row)
        lateinit var patientRow: LinearLayout

        @BindView(R.id.profile_image)
        lateinit var profileImage: ImageView

        @BindView(R.id.full_name)
        lateinit var fullName: TextView

        @BindView(R.id.email)
        lateinit var email: TextView

        @BindView(R.id.phone)
        lateinit var phoneNumber: TextView

        init {
            ButterKnife.bind(this, itemView)
        }

    }
}