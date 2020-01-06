package com.selsoft.kyurx.ui.bit_status

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
import com.selsoft.kyurx.model.Pharmacy
import com.selsoft.kyurx.model.Prescription
import com.selsoft.kyurx.utils.FontUtils

class BitAdapter(
    private var context: Context,
    private var pharmacies: MutableList<Pharmacy>
) : RecyclerView.Adapter<BitAdapter.BitViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BitViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.pharmacy_bit_row, parent, false)
        return BitViewHolder(v)
    }

    override fun getItemCount(): Int {
        return pharmacies.size
    }

    override fun onBindViewHolder(holder: BitViewHolder, position: Int) {

        val pharmacy = pharmacies[position]

        holder.confirm.tag = pharmacy
        holder.confirm.setOnClickListener(confirmBitTapped)

        holder.available.text = pharmacy.available
        holder.pharmacyName.text = pharmacy.name
        holder.cost.text = pharmacy.cost

        val primary: Typeface = FontUtils.getPrimaryFont(context)
        val boldFont: Typeface = FontUtils.getPrimaryBoldFont(context)

        holder.cost.typeface = boldFont
        holder.totalAmountTxt.typeface = boldFont
        holder.available.typeface = primary
        holder.pharmacyName.typeface = boldFont
        holder.confirmTxt.typeface = boldFont

    }

    @SuppressLint("SetTextI18n")
    val confirmBitTapped: View.OnClickListener = View.OnClickListener {

        val addPrescriptionDialog = AlertDialog.Builder(context)
        val addPrescriptionView =
            LayoutInflater.from(context).inflate(R.layout.auto_bit_dialog, null)
        addPrescriptionDialog.setView(addPrescriptionView)
        val prescriptionDialog = addPrescriptionDialog.create()

        val autoBitDetailTxt = addPrescriptionView.findViewById(R.id.auto_bit_details) as TextView
        autoBitDetailTxt.text = "Bit Details"

        prescriptionDialog.show()
    }

    class BitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var cost: TextView
        var totalAmountTxt: TextView
        var pharmacyName: TextView
        var available: TextView
        var confirmTxt: TextView
        var confirm: LinearLayout

        init {
            cost = itemView.findViewById(R.id.cost)
            totalAmountTxt = itemView.findViewById(R.id.txt_total_amount)
            pharmacyName = itemView.findViewById(R.id.pharmacy_name)
            available = itemView.findViewById(R.id.available)
            confirmTxt = itemView.findViewById(R.id.txt_confirm)
            confirm = itemView.findViewById(R.id.confirm)
        }

    }
}