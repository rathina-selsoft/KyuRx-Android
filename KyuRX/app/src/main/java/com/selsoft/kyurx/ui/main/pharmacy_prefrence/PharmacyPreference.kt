package com.selsoft.kyurx.ui.main.pharmacy_prefrence


import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick

import com.selsoft.kyurx.R
import com.selsoft.kyurx.model.Pharmacy
import com.selsoft.kyurx.ui.main.PatientMain
import com.selsoft.kyurx.ui.nearby_pharmacy.NearByPharmacy
import com.selsoft.kyurx.utils.FontUtils

/**
 * A simple [Fragment] subclass.
 */
class PharmacyPreference : Fragment(), View.OnClickListener {

    private lateinit var activity: PatientMain

    @BindView(R.id.rv_pharmacy)
    lateinit var pharmacyRV: RecyclerView

    lateinit var pharmacyAdapter: PharmacyAdapter
    var pharmacies: MutableList<Pharmacy> = ArrayList<Pharmacy>()

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_pharmacy_preference, container, false)
        ButterKnife.bind(this, root)

        createStaticPharmacy()

        pharmacyRV.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        pharmacyAdapter = PharmacyAdapter(activity, pharmacies)
        pharmacyAdapter.setClickListener(this)
        pharmacyRV.adapter = pharmacyAdapter

        return root
    }

    @OnClick(R.id.add_pharmacy)
    fun addPharmacyTapped(view: View) {
        startActivity(Intent(activity, NearByPharmacy::class.java))
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

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        activity = context as PatientMain
    }

    override fun onClick(adapterView: View?) {
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater!!.inflate(R.menu.preference, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_preference -> {
            showPreferenceDialog()
        }
        else -> super.onOptionsItemSelected(item)
    }

    private fun showPreferenceDialog(): Boolean {

        val preferenceAlertDialog = AlertDialog.Builder(activity)
        val preferenceView = this.layoutInflater.inflate(R.layout.preference, null)
        preferenceAlertDialog.setView(preferenceView)
        val preferenceDialog = preferenceAlertDialog.create()

        val preferenceTxt = preferenceView.findViewById(R.id.txt_preference) as TextView
        val switch1 = preferenceView.findViewById(R.id.switch1) as Switch
        val switch2 = preferenceView.findViewById(R.id.switch2) as Switch
        val saveBtn = preferenceView.findViewById(R.id.btn_save) as Button
        val cancelBtn = preferenceView.findViewById(R.id.btn_cancel) as Button

        val primary: Typeface = FontUtils.getPrimaryFont(activity)
        val boldFont: Typeface = FontUtils.getPrimaryBoldFont(activity)

        preferenceTxt.typeface = boldFont
        switch1.typeface = primary
        switch2.typeface = primary
        saveBtn.typeface = boldFont
        cancelBtn.typeface = boldFont

        preferenceDialog.show()


        return true
    }

}
