package com.geeks.lovecalculate.ui.onBoard

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geeks.lovecalculate.ApplicationModule
import com.geeks.lovecalculate.Pref
import com.geeks.lovecalculate.databinding.ActivityMainBinding
import com.geeks.lovecalculate.databinding.ActivityOnBoardBinding
import com.geeks.lovecalculate.ui.activity.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardActivity : AppCompatActivity() {

    @Inject
    lateinit var pref :Pref
    private var adapter = OnBoardAdapter(this::onClick)


    private val binding by lazy {
        ActivityOnBoardBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupViewPager()
        onClick()
    }

    private fun onClick() {
        pref.onBoardingShow()
        startActivity(Intent(this@OnBoardActivity, MainActivity::class.java))
    }

    private fun setupViewPager() {
        binding.viewPager2.adapter = adapter
    }
}