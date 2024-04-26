package com.geeks.lovecalculate.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geeks.lovecalculate.RetrofitService
import com.geeks.lovecalculate.databinding.ActivityMainBinding
import com.geeks.lovecalculate.model.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

         binding.btnCalculate.setOnClickListener {
            val firstName = binding.etFname.text.toString()
            val secondName = binding.etSname.text.toString()

            if (firstName.isNotEmpty() && secondName.isNotEmpty()) {
                initClickers(firstName, secondName)
            }
        }
    }
    private fun initClickers(firstName: String, secondName: String) {
        val loveApi = RetrofitService().api

        loveApi.getPercentage("31349f87c1msh941e3b50ff85859p191fc0jsn6a217a151fa6","love-calculator.p.rapidapi.com",firstName,secondName).enqueue(object : Callback<LoveModel>{
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful){
                    val loveModel = response.body()
                    val intent = Intent(this@MainActivity, SecondActivity::class.java)
                    intent.putExtra("firstName", firstName)
                    intent.putExtra("secondName", secondName)
                    intent.putExtra("percentage", loveModel?.percentage)
                    intent.putExtra("result", loveModel?.result)
                    startActivity(intent)
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
            }
        })
    }
}