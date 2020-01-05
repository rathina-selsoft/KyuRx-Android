package com.selsoft.kyurx.ui.main.pharmacy_prefrence


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife

import com.selsoft.kyurx.R
import com.selsoft.kyurx.model.Pharmacy
import com.selsoft.kyurx.ui.main.PatientMain

/**
 * A simple [Fragment] subclass.
 */
class PharmacyPreference : Fragment(), View.OnClickListener {

    private lateinit var activity: PatientMain

    @BindView(R.id.rv_pharmacy)
    lateinit var pharmacyRV: RecyclerView

    lateinit var pharmacyAdapter: PharmacyAdapter
    var pharmacies: MutableList<Pharmacy> = ArrayList<Pharmacy>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
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

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        activity = context as PatientMain
    }

    override fun onClick(pharmacyView: View?) {
        val pharmacy = pharmacyView?.tag as Pharmacy
        pharmacy.isSelected = !pharmacy.isSelected
        pharmacyAdapter.notifyDataSetChanged()
    }


}
