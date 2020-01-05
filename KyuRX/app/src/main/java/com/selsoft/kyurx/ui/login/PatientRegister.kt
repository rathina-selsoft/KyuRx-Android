package com.selsoft.kyurx.ui.login

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import butterknife.BindView
import butterknife.ButterKnife
import com.selsoft.kyurx.R
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patient_register)
        ButterKnife.bind(this)

        setFontStyle()
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
