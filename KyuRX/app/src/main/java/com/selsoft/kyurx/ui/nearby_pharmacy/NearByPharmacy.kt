package com.selsoft.kyurx.ui.nearby_pharmacy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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


        val pharmacy1 = Pharmacy()
        pharmacy1.address = "20744 TX-46 W, Spring Branch, TX 78070, United States"
        pharmacy1.name = "Walgreens Pharmacy"
        pharmacy1.phoneNumber = "+1 830-438-1123"
        pharmacy1.isSelected = false
        pharmacies.add(pharmacy1)


        val pharmacy2 = Pharmacy()
        pharmacy2.address = "333 Guadalupe St #3, Austin, TX 78701, United States"
        pharmacy2.name = "Texas State Board of Pharmacy"
        pharmacy2.phoneNumber = "+1 512-305-8000"
        pharmacy2.isSelected = false
        pharmacies.add(pharmacy2)


        val pharmacy3 = Pharmacy()
        pharmacy3.address = "5201 S Cooper St, Arlington, TX 76017, United States"
        pharmacy3.name = "Geesons Pharmacy"
        pharmacy3.phoneNumber = "+1 817-419-2688"
        pharmacy3.isSelected = false
        pharmacies.add(pharmacy3)


        val pharmacy4 = Pharmacy()
        pharmacy4.address = "12820 TX-105, Conroe, TX 77304, United States"
        pharmacy4.name = "Richies Specialty Pharmacy"
        pharmacy4.phoneNumber = "+1 936-588-6337"
        pharmacy4.isSelected = false
        pharmacies.add(pharmacy4)

        val pharmacy5 = Pharmacy()
        pharmacy5.address = "3541 Palmer Hwy, Texas City, TX 77590, United States"
        pharmacy5.name = "Kroger Pharmacy"
        pharmacy5.phoneNumber = "+1 409-945-3436"
        pharmacy5.isSelected = false
        pharmacies.add(pharmacy5)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.action_upload -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
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
