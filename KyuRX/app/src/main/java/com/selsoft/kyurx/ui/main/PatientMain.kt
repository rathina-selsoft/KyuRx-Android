package com.selsoft.kyurx.ui.main

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.selsoft.kyurx.R
import com.selsoft.kyurx.ui.splash.Welcome
import com.selsoft.kyurx.utils.FontUtils
import com.selsoft.kyurx.utils.SessionManager
import com.selsoft.kyurx.utils.Utils

class PatientMain : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    @BindView(R.id.toolbar)
    lateinit var toolbar: Toolbar

    @BindView(R.id.drawer_layout)
    lateinit var drawerLayout: DrawerLayout

    @BindView(R.id.nav_view)
    lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patient_main)
        ButterKnife.bind(this)
        setSupportActionBar(toolbar)


        val navController = findNavController(R.id.nav_host_fragment)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_medicine_status,
                R.id.nav_pharmacy_preference
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val navHeaderView: View = navView.getHeaderView(0)
        val userEmail = navHeaderView.findViewById(R.id.email) as TextView
        val logoutBtn = navHeaderView.findViewById(R.id.btn_logout) as Button
        userEmail.typeface = FontUtils.getPrimaryBoldFont(this)

        val sessionManager = SessionManager(this)
        logoutBtn.setOnClickListener {
            sessionManager.clear()
            startActivity(Intent(this, Welcome::class.java))
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
