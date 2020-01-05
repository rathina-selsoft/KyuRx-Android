package com.selsoft.kyurx.ui.main.pharmacy_prefrence

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.selsoft.kyurx.R
import com.selsoft.kyurx.model.Pharmacy
import com.selsoft.kyurx.utils.FontUtils

class PharmacyAdapter(
    private val context: Context,
    private val pharmacies: MutableList<Pharmacy>
) : RecyclerView.Adapter<PharmacyAdapter.PharmacyViewHolder>() {

    lateinit var onClickListener: View.OnClickListener

    class PharmacyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var pharmacyRow: LinearLayout
        var pharmacyImage: ImageView
        var pharmacyName: TextView
        var pharmacyAddress: TextView
        var pharmacyNumber: TextView

        init {

            pharmacyRow = itemView.findViewById(R.id.pharmacy_row) as LinearLayout
            pharmacyImage = itemView.findViewById(R.id.pharmacy_image) as ImageView
            pharmacyName = itemView.findViewById(R.id.pharmacy_name) as TextView
            pharmacyAddress = itemView.findViewById(R.id.address) as TextView
            pharmacyNumber = itemView.findViewById(R.id.phone) as TextView
        }
    }

    fun setClickListener(onClickListener: View.OnClickListener) {
        this.onClickListener = onClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PharmacyViewHolder {
        val root = LayoutInflater.from(context).inflate(R.layout.pharmacy_row, parent, false)
        root.setOnClickListener(onClickListener)
        return PharmacyViewHolder(root)
    }

    override fun getItemCount(): Int {
        return pharmacies.size
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: PharmacyViewHolder, position: Int) {
        val pharmacy = pharmacies[position]
        holder.pharmacyRow.tag = pharmacy
        holder.pharmacyName.text = pharmacy.name
        holder.pharmacyAddress.text = pharmacy.address
        holder.pharmacyNumber.text = pharmacy.phoneNumber

        if (pharmacy.isSelected){
            holder.pharmacyName.setTextColor(ContextCompat.getColor(context, R.color.colorAccent))
            holder.pharmacyAddress.setTextColor(ContextCompat.getColor(context, R.color.colorPrimary))
            holder.pharmacyNumber.setTextColor(ContextCompat.getColor(context, R.color.colorPrimary))
        }else{
            holder.pharmacyName.setTextColor(ContextCompat.getColor(context, R.color.black))
            holder.pharmacyAddress.setTextColor(ContextCompat.getColor(context, R.color.black))
            holder.pharmacyNumber.setTextColor(ContextCompat.getColor(context, R.color.black))
        }

        val primary: Typeface = FontUtils.getPrimaryFont(context)
        val boldFont: Typeface = FontUtils.getPrimaryBoldFont(context)

        holder.pharmacyName.typeface = boldFont
        holder.pharmacyAddress.typeface = primary
        holder.pharmacyNumber.typeface = primary
    }
}