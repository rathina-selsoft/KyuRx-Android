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

        val pharmacy1 = Pharmacy()
        pharmacy1.address = "20744 TX-46 W, Spring Branch, TX 78070, United States"
        pharmacy1.name = "Walgreens Pharmacy"
        pharmacy1.phoneNumber = "+1 830-438-1123"
        pharmacy1.isSelected = false
        pharmacy1.available = "Open 24 hours"
        pharmacy1.cost = "$19.8"
        pharmacies.add(pharmacy1)


        val pharmacy2 = Pharmacy()
        pharmacy2.address = "333 Guadalupe St #3, Austin, TX 78701, United States"
        pharmacy2.name = "Texas State Board of Pharmacy"
        pharmacy2.phoneNumber = "+1 512-305-8000"
        pharmacy2.isSelected = false
        pharmacy2.cost = "$24.3"
        pharmacy2.available = "Open 24 hours"
        pharmacies.add(pharmacy2)


        val pharmacy3 = Pharmacy()
        pharmacy3.address = "5201 S Cooper St, Arlington, TX 76017, United States"
        pharmacy3.name = "Geesons Pharmacy"
        pharmacy3.phoneNumber = "+1 817-419-2688"
        pharmacy3.isSelected = false
        pharmacy3.cost = "$20.78"
        pharmacy3.available = "Open 24 hours"
        pharmacies.add(pharmacy3)


        val pharmacy4 = Pharmacy()
        pharmacy4.address = "12820 TX-105, Conroe, TX 77304, United States"
        pharmacy4.name = "Richies Specialty Pharmacy"
        pharmacy4.phoneNumber = "+1 936-588-6337"
        pharmacy4.isSelected = false
        pharmacy4.cost = "$22.5"
        pharmacy4.available = "Open 24 hours"
        pharmacies.add(pharmacy4)

        val pharmacy5 = Pharmacy()
        pharmacy5.address = "3541 Palmer Hwy, Texas City, TX 77590, United States"
        pharmacy5.name = "Kroger Pharmacy"
        pharmacy5.phoneNumber = "+1 409-945-3436"
        pharmacy5.isSelected = false
        pharmacy5.cost = "$21.3"
        pharmacy5.available = "Open 24 hours"
        pharmacies.add(pharmacy5)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
