package com.josh.app.ui.main

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.josh.app.R
import com.josh.app.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("josh",MODE_PRIVATE)


        binding.tvVersion.apply{
            try{
                val packageInfo = packageManager.getPackageInfo(packageName,0)
                text = packageInfo.versionName
            }catch (e: Exception){
                e.printStackTrace()
            }
        }

        Handler(Looper.getMainLooper()).postDelayed(
            {
                val firstRun = sharedPreferences.getBoolean("first_run",true)
                val username = sharedPreferences.getString("username",null)
                val password = sharedPreferences.getString("password",null)
                if(firstRun){
                    val intent = Intent(this@SplashScreen,WelcomeScreen::class.java)
                    startActivity(intent)
                }else{
                    if(username.isNullOrEmpty() && password.isNullOrEmpty()){
                        val intent = Intent(this,LoginActivity::class.java)
                        startActivity(intent)
                    }else{
                        //TODO: Do Login Here.
                    }
                }
            },2000)
    }
}