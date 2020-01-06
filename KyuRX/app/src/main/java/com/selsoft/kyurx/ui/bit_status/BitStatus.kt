package com.selsoft.kyurx.ui.bit_status

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.selsoft.kyurx.R
import com.selsoft.kyurx.model.Pharmacy
import com.selsoft.kyurx.ui.main.pharmacy_prefrence.PharmacyAdapter

class BitStatus : AppCompatActivity() {

    @BindView(R.id.rv_pharmacy)
    lateinit var pharmacyRV: RecyclerView

    @BindView(R.id.txt_choice)
    lateinit var choiceTxt: TextView

    var pharmacies: MutableList<Pharmacy> = ArrayList<Pharmacy>()
    lateinit var bitAdapter: BitAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bit_status)
        ButterKnife.bind(this)

        val actionBar = supportActionBar
        actionBar!!.title = "Bit Details"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)

        createStaticBit()

        pharmacyRV.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        bitAdapter = BitAdapter(this, pharmacies)
        pharmacyRV.adapter = bitAdapter

    }

    private fun createStaticBit() {
        for (x in 0..5) {
            val pharmacy = Pharmacy()
            pharmacy.address = "19028 Lincoln Ave, Parker, CO 80134, USA."
            pharmacy.name = "CVS Pharmacy"
            pharmacy.phoneNumber = "9874563210, 9876541230"
            pharmacy.isSelected = false
            pharmacy.available = "Open 24 Hours"
            pharmacy.cost = "$25.3"

            pharmacies.add(pharmacy)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
