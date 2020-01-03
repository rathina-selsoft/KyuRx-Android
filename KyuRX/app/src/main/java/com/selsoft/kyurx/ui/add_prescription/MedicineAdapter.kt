package com.selsoft.kyurx.ui.add_prescription

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.selsoft.kyurx.R
import com.selsoft.kyurx.model.Medicine
import com.selsoft.kyurx.utils.FontUtils

class MedicineAdapter(
    private val context: Context,
    private val medicines: MutableList<Medicine>
) : RecyclerView.Adapter<MedicineAdapter.MedicineViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicineViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.medicine_row, parent, false)
        return MedicineViewHolder(v)
    }

    override fun getItemCount(): Int {
        return medicines.size
    }

    override fun onBindViewHolder(holder: MedicineViewHolder, position: Int) {
        val medicine = medicines[position]

        holder.medicineRow.tag = medicine
        holder.medicineName.text = medicine.name
        holder.quantity.text = "${medicine.quantity}"
        holder.dosageInstruction.text = medicine.dosageInstruction


        val primary: Typeface = FontUtils.getPrimaryFont(context)
        val boldFont: Typeface = FontUtils.getPrimaryBoldFont(context)

        holder.medicineName.typeface = boldFont
        holder.quantity.typeface = primary
        holder.dosageInstruction.typeface = primary
    }

    class MedicineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var medicineRow: LinearLayout
        var medicineName: TextView
        var quantity: TextView
        var dosageInstruction: TextView


        init {
            medicineRow = itemView.findViewById(R.id.ly_medicine_row)
            medicineName = itemView.findViewById(R.id.medicine_name)
            quantity = itemView.findViewById(R.id.quantity)
            dosageInstruction = itemView.findViewById(R.id.dosage_instruction)
        }
    }
}