package com.selsoft.kyurx.ui.nearby_pharmacy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.selsoft.kyurx.R
import com.selsoft.kyurx.model.Pharmacy
import com.selsoft.kyurx.ui.main.pharmacy_prefrence.PharmacyAdapter

class NearByPharmacy : AppCompatActivity(), View.OnClickListener {

    @BindView(R.id.rv_near_pharmacy)
    lateinit var nearPharmacyRV: RecyclerView

    lateinit var pharmacyAdapter: PharmacyAdapter
    var pharmacies: MutableList<Pharmacy> = ArrayList<Pharmacy>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_near_by_pharmacy)
        ButterKnife.bind(this)

        val actionBar = supportActionBar
        actionBar!!.title = "NearBy Pharmacies"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)

        createStaticPharmacy()

        nearPharmacyRV.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        pharmacyAdapter = PharmacyAdapter(this, pharmacies)
        pharmacyAdapter.setClickListener(this)
        nearPharmacyRV.adapter = pharmacyAdapter
    }

    private fun createStaticPharmacy() {

        for (x in 0..5) {
            val pharmacy = Pharmacy()
            pharmacy.address = "19028 Lincoln Ave, Parker, CO 80134, USA."
            pharmacy.name = "CVS Pharmacy"
            pharmacy.phoneNumber = "9874563210, 9876541230"
            pharmacy.isSelected = false
            pharmacies.add(pharmacy)
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onClick(pharmacyView: View?) {
        val pharmacy = pharmacyView?.tag as Pharmacy
        pharmacy.isSelected = !pharmacy.isSelected
        pharmacyAdapter.notifyDataSetChanged()
    }


}
