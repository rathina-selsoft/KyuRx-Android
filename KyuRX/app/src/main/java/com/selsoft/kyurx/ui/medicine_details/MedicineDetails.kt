package com.selsoft.kyurx.ui.medicine_details

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.selsoft.kyurx.R
import com.selsoft.kyurx.model.Medicine
import com.selsoft.kyurx.ui.add_prescription.MedicineAdapter
import com.selsoft.kyurx.ui.bit_status.BitStatus
import com.selsoft.kyurx.utils.FontUtils

class MedicineDetails : AppCompatActivity() {

    @BindView(R.id.org_name)
    lateinit var orgName: TextView

    @BindView(R.id.txt_dr_details)
    lateinit var selectDoctor: TextView

    @BindView(R.id.dr_name)
    lateinit var drName: TextView

    @BindView(R.id.dr_specialist)
    lateinit var drSpecialist: TextView

    @BindView(R.id.txt_prescription)
    lateinit var prescriptionTxt: TextView

    @BindView(R.id.rv_medicine)
    lateinit var medicineRV: RecyclerView

    @BindView(R.id.btn_check_status)
    lateinit var checkStatus: TextView

    var medicines: MutableList<Medicine> = ArrayList<Medicine>()
    lateinit var medicineAdapter: MedicineAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medicine_details)
        ButterKnife.bind(this)

        val actionBar = supportActionBar
        actionBar!!.title = "Medicine Detail"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)

        setFontStyle()

        medicineRV.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        medicineRV.isNestedScrollingEnabled = false

        createStaticMedicines()
        medicineAdapter = MedicineAdapter(this, medicines)
        medicineRV.adapter = medicineAdapter
    }

    @OnClick(R.id.btn_check_status)
    fun bitTapped() {
        startActivity(Intent(this, BitStatus::class.java))
    }

    private fun createStaticMedicines() {


        val medicine1 = Medicine()
        medicine1.name = "Paracetamol"
        medicine1.quantity = 10
        medicine1.dosageInstruction =
            "There are many brands and forms of paracetamol available and not all brands are listed on this leaflet."
        medicines.add(medicine1)

        val medicine2 = Medicine()
        medicine2.name = "Acetaminophen"
        medicine2.quantity = 8
        medicine2.dosageInstruction =
            "You should not use this medication if you have severe liver disease."
        medicines.add(medicine2)

        val medicine3 = Medicine()
        medicine3.name = "Tylenol"
        medicine3.quantity = 5
        medicine3.dosageInstruction =
            "Avoid also using other medicines that contain acetaminophen (sometimes abbreviated as APAP), or you could have a fatal overdose."
        medicines.add(medicine3)

        val medicine4 = Medicine()
        medicine4.name = "ibuprofen"
        medicine4.quantity = 3
        medicine4.dosageInstruction = "An ibuprofen overdose can damage your stomach or intestines."
        medicines.add(medicine1)

        val medicine5 = Medicine()
        medicine5.name = "Advil"
        medicine5.quantity = 7
        medicine5.dosageInstruction =
            "Taking Advil during the last 3 months of pregnancy may harm the unborn baby."
        medicines.add(medicine5)

        val medicine6 = Medicine()
        medicine6.name = "Bayer Aspirin"
        medicine6.quantity = 9
        medicine6.dosageInstruction =
            "If you have any of these health problems: Asthma, bleeding problems, nose polyps, or nose irritation."
        medicines.add(medicine6)


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setFontStyle() {
        val primary = FontUtils.getPrimaryFont(this)
        val boldPrimary = FontUtils.getPrimaryBoldFont(this)


        orgName.typeface = boldPrimary
        selectDoctor.typeface = boldPrimary
        drName.typeface = boldPrimary
        drSpecialist.typeface = primary
        prescriptionTxt.typeface = boldPrimary
        checkStatus.typeface = boldPrimary

    }

}
