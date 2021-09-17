package com.josh.app.ui.main

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.josh.app.R
import com.josh.app.databinding.ActivityWelcomeScreenBinding

class WelcomeScreen : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityWelcomeScreenBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("josh", MODE_PRIVATE)
        binding.btnNext.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        p0?.let {
            when(p0.id){
                binding.btnNext.id -> {
                    sharedPreferences.edit().putBoolean("first_run",false).apply()
                    val intent = Intent(this@WelcomeScreen,LoginActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}