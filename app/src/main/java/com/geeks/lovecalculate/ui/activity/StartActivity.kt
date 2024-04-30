package com.geeks.lovecalculate.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geeks.lovecalculate.databinding.ActivityStartBinding
import com.geeks.lovecalculate.ui.onBoard.OnBoardActivity

class StartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            val intent = Intent(this@StartActivity, OnBoardActivity::class.java)
            startActivity(intent)
        }
    }
}