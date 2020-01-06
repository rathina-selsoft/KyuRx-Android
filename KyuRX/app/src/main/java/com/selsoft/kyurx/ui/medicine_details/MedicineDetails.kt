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

        createStaticMedicines()
        medicineAdapter = MedicineAdapter(this, medicines)
        medicineRV.adapter = medicineAdapter
    }

    @OnClick(R.id.btn_check_status)
    fun bitTapped() {
        startActivity(Intent(this, BitStatus::class.java))
    }

    private fun createStaticMedicines() {

        for (x in 0..5) {
            val medicine = Medicine()
            medicine.name = "Dolo 650"
            medicine.quantity = 5
            medicine.dosageInstruction = "Dosage Instruction"

            medicines.add(medicine)
        }

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
