package com.selsoft.kyurx.ui.main

import android.content.Intent
import android.os.Bundle
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
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.selsoft.kyurx.R
import com.selsoft.kyurx.ui.login.LoginActivity
import com.selsoft.kyurx.utils.FontUtils
import com.selsoft.kyurx.utils.SessionManager
import com.selsoft.kyurx.utils.Utils

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    @BindView(R.id.toolbar)
    lateinit var toolbar: Toolbar

    @BindView(R.id.drawer_layout)
    lateinit var drawerLayout: DrawerLayout

    @BindView(R.id.nav_view)
    lateinit var navView: NavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        setSupportActionBar(toolbar)

        val navController = findNavController(R.id.nav_host_fragment)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_prescription,
                R.id.nav_doctor,
                R.id.nav_patient,
                R.id.nav_user
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val sessionManager = SessionManager(this)
        Utils.user = sessionManager.getUserDetails()

        if (Utils.user?.email == null) {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        } else {

            val navHeaderView: View = navView.getHeaderView(0)
            val userEmail = navHeaderView.findViewById(R.id.email) as TextView
            userEmail.text = Utils.user!!.email
            userEmail.typeface = FontUtils.getPrimaryBoldFont(this)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
