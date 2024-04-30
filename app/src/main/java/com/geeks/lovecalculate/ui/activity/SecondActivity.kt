package com.geeks.lovecalculate.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geeks.lovecalculate.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstName = intent.getStringExtra("firstName")
        val secondName = intent.getStringExtra("secondName")
        val percentage = intent.getStringExtra("percentage")
        val result = intent.getStringExtra("result")
        binding.tvFname.text = "$firstName"
        binding.tvSname.text = "$secondName"
        binding.tvPercent.text = "$percentage"
        binding.tvResult.text = "Result for: \n  $result"

        binding.btnTryAgain.setOnClickListener {
            val intent = Intent(this@SecondActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}