package com.geeks.lovecalculate.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.geeks.lovecalculate.RetrofitService
import com.geeks.lovecalculate.databinding.ActivityMainBinding
import com.geeks.lovecalculate.data.model.LoveModel
import com.geeks.lovecalculate.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initClickers()
    }


    private fun initClickers() = with(binding) {
        btnCalculate.setOnClickListener {
            viewModel.getLovePercentage(
                firstName = etFname.text.toString(),
                secondName = etSname.text.toString()
            ).observe(this@MainActivity) { data ->
                setupObservers(data)
            }
        }
    }

    private fun setupObservers(data: LoveModel) = with(viewModel) {
        startActivity(
            Intent(this@MainActivity, SecondActivity::class.java).apply {
                putExtra(ARG_FIRST_NAME, binding.etFname.text.toString())
                putExtra(ARG_SECOND_NAME, binding.etSname.text.toString())
                putExtra(ARG_PERCENTAGE, data.percentage)
                putExtra(ARG_RESULT, data.result)
            }
        )
    }

    companion object {
        const val ARG_FIRST_NAME = "firstName"
        const val ARG_SECOND_NAME = "secondName"
        const val ARG_PERCENTAGE = "percentage"
        const val ARG_RESULT = "result"
    }
}