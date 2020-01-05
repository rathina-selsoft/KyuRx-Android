package com.selsoft.kyurx.ui.main.medicine_status

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.selsoft.kyurx.R
import com.selsoft.kyurx.model.Prescription
import com.selsoft.kyurx.utils.FontUtils
import com.selsoft.kyurx.utils.Utils

class MedicineStatusAdapter(
    private val context: Context,
    private val prescriptions: MutableList<Prescription>
) : RecyclerView.Adapter<MedicineStatusAdapter.MedicineStatusViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicineStatusViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.medicine_status_row, parent, false)
        return MedicineStatusViewHolder(v)
    }

    override fun getItemCount(): Int {
        return prescriptions.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MedicineStatusViewHolder, position: Int) {

        val prescription: Prescription = prescriptions[position]
        holder.prescriptionLY.tag = prescription
        holder.autoBit.tag = prescription
        holder.medicineCount.text = "${prescription.medicines.size}"
        holder.orgName.text = prescription.orgName
        holder.drName.text =
            "DR. ${prescription.doctor?.firstName} ${prescription.doctor?.lastName}"
        holder.createdDate.text = prescription.createdDate
        holder.autoBit.setOnClickListener(autoBitTapped)

        val primary: Typeface = FontUtils.getPrimaryFont(context)
        val boldFont: Typeface = FontUtils.getPrimaryBoldFont(context)

        holder.orgName.typeface = boldFont
        holder.drName.typeface = boldFont
        holder.createdDate.typeface = primary
        holder.medicineCount.typeface = boldFont
        holder.medicineCountTxt.typeface = boldFont
        holder.autoBitTxt.typeface = boldFont
    }

    val autoBitTapped: View.OnClickListener = View.OnClickListener {
        val prescription = it.tag as Prescription
        val addPrescriptionDialog = AlertDialog.Builder(context)
        val addPrescriptionView = LayoutInflater.from(context).inflate(R.layout.auto_bit_dialog, null)
        addPrescriptionDialog.setView(addPrescriptionView)
        val prescriptionDialog = addPrescriptionDialog.create()
        prescriptionDialog.show()
    }

    class MedicineStatusViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var prescriptionLY: LinearLayout
        var medicineCount: TextView
        var medicineCountTxt: TextView
        var orgName: TextView
        var drName: TextView
        var createdDate: TextView
        var autoBit: LinearLayout
        var autoBitTxt: TextView

        init {
            prescriptionLY = itemView.findViewById(R.id.ly_prescription)
            medicineCount = itemView.findViewById(R.id.medicine_count)
            medicineCountTxt = itemView.findViewById(R.id.txt_medicine_count)
            orgName = itemView.findViewById(R.id.org_name)
            drName = itemView.findViewById(R.id.dr_name)
            createdDate = itemView.findViewById(R.id.created_date)
            autoBit = itemView.findViewById(R.id.auto_bit)
            autoBitTxt = itemView.findViewById(R.id.txt_auto_bit)
        }
    }

}