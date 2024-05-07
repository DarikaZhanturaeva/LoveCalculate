package com.geeks.lovecalculate.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geeks.lovecalculate.databinding.ActivityMainBinding
import com.geeks.lovecalculate.databinding.ActivityStartBinding
import com.geeks.lovecalculate.ui.onBoard.OnBoardActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityStartBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            startActivity(Intent(this@StartActivity, OnBoardActivity::class.java))
        }
    }
}