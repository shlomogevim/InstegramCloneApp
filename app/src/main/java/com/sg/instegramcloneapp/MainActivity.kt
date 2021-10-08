package com.sg.instegramcloneapp

import android.os.Bundle
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.sg.instegramcloneapp.databinding.ActivityMainBinding
import com.sg.instegramcloneapp.fragments.HomeFragment
import com.sg.instegramcloneapp.fragments.NotificationsFragment
import com.sg.instegramcloneapp.fragments.ProfileFragment
import com.sg.instegramcloneapp.fragments.SearchFragment

class MainActivity : AppCompatActivity() {

   internal var selectFragment:Fragment?=null

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                   selectFragment=HomeFragment()
                }
                R.id.nav_search -> {

                    selectFragment=SearchFragment()
                }
                R.id.nav_add_post -> {

                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_notifications -> {

                    selectFragment=NotificationsFragment()
                }
                R.id.nav_profile -> {

                    selectFragment=ProfileFragment()
                }
            }
            if (selectFragment!=null){
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container,selectFragment!!
                ).commit()

            }

            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container,HomeFragment()
        ).commit()


    }


}