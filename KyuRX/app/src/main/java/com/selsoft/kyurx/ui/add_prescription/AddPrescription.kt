package com.selsoft.kyurx.ui.add_prescription

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.selsoft.kyurx.R

class AddPrescription : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_prescription)

        //to change title of activity
        val actionBar = supportActionBar
        actionBar!!.title = "Add Prescription"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
