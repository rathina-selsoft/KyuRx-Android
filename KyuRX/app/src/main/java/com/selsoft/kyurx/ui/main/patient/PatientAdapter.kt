package com.selsoft.kyurx.ui.main.patient

import android.annotation.SuppressLint
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
import org.jetbrains.annotations.Nullable

class PatientAdapter(
    var context: Context,
    var patients: MutableList<Patient>
) : RecyclerView.Adapter<PatientAdapter.PatientViewHolder>() {

    lateinit var onClickListener: View.OnClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.patient_row, parent, false)
        v.setOnClickListener(onClickListener)
        return PatientViewHolder(v)
    }

    fun setClickListener(onClickListener: View.OnClickListener) {
        this.onClickListener = onClickListener
    }

    override fun getItemCount(): Int {
        return patients.size
    }

    @SuppressLint("SetTextI18n")
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

    class PatientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        var patientRow: LinearLayout
        var profileImage: ImageView
        var fullName: TextView
        var email: TextView
        var phoneNumber: TextView

        init {
            patientRow = itemView.findViewById(R.id.ly_patient_row)
            profileImage = itemView.findViewById(R.id.profile_image)
            fullName = itemView.findViewById(R.id.full_name)
            email = itemView.findViewById(R.id.email)
            phoneNumber = itemView.findViewById(R.id.phone)
        }

    }
}