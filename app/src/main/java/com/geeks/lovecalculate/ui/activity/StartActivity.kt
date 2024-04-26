package com.geeks.lovecalculate.ui.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation.findNavController
import com.geeks.lovecalculate.R
import com.geeks.lovecalculate.databinding.ActivitySecondBinding
import com.geeks.lovecalculate.databinding.ActivityStartBinding
import com.geeks.lovecalculate.ui.fragments.onBoard.OnBoardActivity

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