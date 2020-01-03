package com.selsoft.kyurx.ui.add_prescription

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.selsoft.kyurx.R
import com.selsoft.kyurx.model.Doctor
import com.selsoft.kyurx.model.Patient
import com.selsoft.kyurx.utils.FontUtils

class DoctorPatientAdapter(
    private val context: Context,
    private val models: MutableList<*>
) : RecyclerView.Adapter<DoctorPatientAdapter.DoctorPatientViewHolder>() {

    lateinit var onClickListener: View.OnClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorPatientViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.doctor_patient_row, parent, false)
        v.setOnClickListener(onClickListener)
        return DoctorPatientViewHolder(v)
    }

    fun setClickListener(onClickListener: View.OnClickListener) {
        this.onClickListener = onClickListener
    }

    override fun getItemCount(): Int {
        return models.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: DoctorPatientViewHolder, position: Int) {
        val model = models[position]
        if (model is Doctor) {
            holder.doctorRow.tag = model
            holder.doctorName.text = "Dr. ${model.firstName.toString()}"
            holder.specialist.text = model.emailId
        } else if (model is Patient) {
            holder.doctorRow.tag = model
            holder.doctorName.text = model.firstName.toString()
            holder.specialist.text = model.emailId
        }

        val primary: Typeface = FontUtils.getPrimaryFont(context)
        val boldFont: Typeface = FontUtils.getPrimaryBoldFont(context)

        holder.specialist.typeface = primary
        holder.doctorName.typeface = boldFont
    }


    class DoctorPatientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var doctorRow: LinearLayout
        var doctorName: TextView
        var specialist: TextView


        init {
            doctorRow = itemView.findViewById(R.id.ly_doctor_row)
            doctorName = itemView.findViewById(R.id.dr_name)
            specialist = itemView.findViewById(R.id.dr_specialist)
        }

    }
}
