package com.example.papb_9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.papb_9.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())

        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> replaceFragment(HomeFragment())
                R.id.nav_theater -> replaceFragment(TheaterFragment())
                R.id.nav_profile -> replaceFragment(ProfileFragment())
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        var fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}