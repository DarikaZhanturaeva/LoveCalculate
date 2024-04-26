package com.geeks.lovecalculate.ui.fragments.onBoard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geeks.lovecalculate.R
import com.geeks.lovecalculate.databinding.ActivityOnBoardBinding
import com.geeks.lovecalculate.databinding.ItemOnBoardBinding
import com.geeks.lovecalculate.ui.activity.MainActivity
import com.geeks.lovecalculate.ui.activity.SecondActivity

class OnBoardActivity : AppCompatActivity() {

    private var adapter = OnBoardAdapter()

    private lateinit var binding: ActivityOnBoardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewPager()

        binding.btnNext.setOnClickListener {
            val intent = Intent(this@OnBoardActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupViewPager() {
        binding.viewPager2.adapter=adapter
    }
}