package com.selsoft.kyurx.ui.login

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.selsoft.kyurx.R
import com.selsoft.kyurx.ui.main.PatientMain
import com.selsoft.kyurx.utils.FontUtils

class PatientRegister : AppCompatActivity() {

    @BindView(R.id.txt_account)
    lateinit var accountTxt: TextView

    @BindView(R.id.first_name)
    lateinit var firstName: EditText

    @BindView(R.id.last_name)
    lateinit var lastName: EditText

    @BindView(R.id.address)
    lateinit var address: EditText

    @BindView(R.id.email)
    lateinit var email: EditText

    @BindView(R.id.password)
    lateinit var password: EditText

    @BindView(R.id.phone)
    lateinit var phone: EditText

    @BindView(R.id.cb_phone1)
    lateinit var phoneCB1: CheckBox

    @BindView(R.id.phone2)
    lateinit var phone2: EditText

    @BindView(R.id.cb_phone2)
    lateinit var phoneCB2: CheckBox

    @BindView(R.id.txt_upload_id)
    lateinit var uploadIdTxt: TextView

    @BindView(R.id.img_id)
    lateinit var idImg: ImageView

    @BindView(R.id.txt_insurance)
    lateinit var insuranceTxt: TextView

    @BindView(R.id.img_insurance)
    lateinit var insuranceImg: ImageView

    @BindView(R.id.btn_register)
    lateinit var registerBtn: Button

    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patient_register)
        ButterKnife.bind(this)

        setFontStyle()
        context = this
    }

    @OnClick(R.id.btn_register)
    fun registerTapped(view: View) {
        val agreementDialog = AlertDialog.Builder(this)
        val agreementView = this.layoutInflater.inflate(R.layout.agreement_dialog, null)
        agreementDialog.setView(agreementView)
        val agreementAlertDialog = agreementDialog.create()

        val agreementTxt = agreementView.findViewById(R.id.txt_agreement) as TextView
        val agreement = agreementView.findViewById(R.id.agreement) as TextView
        val serviceCB = agreementView.findViewById(R.id.cb_service) as CheckBox
        val registerBtn = agreementView.findViewById(R.id.btn_register) as Button

        val primary: Typeface = FontUtils.getPrimaryBoldFont(this)
        val boldFont: Typeface = FontUtils.getPrimaryBoldFont(this)

        registerBtn.typeface = boldFont
        serviceCB.typeface = primary
        agreement.typeface = primary
        agreementTxt.typeface = boldFont

        registerBtn.setOnClickListener {
            if (serviceCB.isChecked) {
                agreementAlertDialog.dismiss()
                context.startActivity(Intent(context, PatientMain::class.java))
                finish()
            }
        }

        agreementAlertDialog.show()
    }

    private fun setFontStyle() {
        val primary: Typeface = FontUtils.getPrimaryBoldFont(this)
        val boldFont: Typeface = FontUtils.getPrimaryBoldFont(this)

        accountTxt.typeface = boldFont
        registerBtn.typeface = boldFont
        firstName.typeface = primary
        lastName.typeface = primary
        address.typeface = primary
        email.typeface = primary
        phone.typeface = primary
        phoneCB1.typeface = primary
        phone2.typeface = primary
        phoneCB2.typeface = primary
        password.typeface = primary
        uploadIdTxt.typeface = primary
        insuranceTxt.typeface = primary

    }
}
