package com.adematici.healthcalculation.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.adematici.healthcalculation.R
import com.adematici.healthcalculation.fragments.BaslangicFragment
import com.adematici.healthcalculation.fragments.BazalMetabolizmaHiziFragment
import com.adematici.healthcalculation.fragments.KiloIdealFragment
import com.adematici.healthcalculation.fragments.VKIFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var fragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.title = "Sağlık Durum Hesaplayıcı"
        setSupportActionBar(toolbar)

        val toogle = ActionBarDrawerToggle(this,drawer,toolbar,0,0)
        drawer.addDrawerListener(toogle)
        toogle.syncState()

        supportFragmentManager.beginTransaction().add(R.id.frameLayout,BaslangicFragment()).commit()

        navigationView.setNavigationItemSelectedListener { menuItem ->
            if(menuItem.itemId == R.id.nav_bazalmetabolizmahizi){
                fragment = BazalMetabolizmaHiziFragment()
            }
            if(menuItem.itemId == R.id.nav_idealkilo){
                fragment = KiloIdealFragment()
            }
            if(menuItem.itemId == R.id.nav_vki){
                fragment = VKIFragment()
            }

            supportFragmentManager.beginTransaction().replace(R.id.frameLayout,fragment).commit()
            drawer.closeDrawer(GravityCompat.START)
            true
        }

    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START)
        } else {
            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }

}