package com.josh.app.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.josh.app.R
import com.josh.app.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.btnLogin.setOnClickListener {
//            when {
//                binding.edtUsername.text.toString().isEmpty() -> {
//                    binding.edtUsername.error = getString(R.string.cannot_null)
//                }
//                binding.edtPassword.text.toString().isEmpty() -> {
//                    binding.edtPassword.error = getString(R.string.cannot_null)
//                }
//                else -> {
//                    val intent = Intent(this,HomeActivity::class.java)
//                    startActivity(intent)
//                }
//            }
//        }
    }
}