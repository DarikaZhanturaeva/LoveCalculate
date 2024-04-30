package com.geeks.lovecalculate.ui.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geeks.lovecalculate.RetrofitService
import com.geeks.lovecalculate.data.model.LoveModel
import com.geeks.lovecalculate.data.repository.LoveRepository
import com.geeks.lovecalculate.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel : ViewModel() {

    private val repository = LoveRepository()

    // var lovePercentageLv = MutableLiveData<LoveModel>()
    fun getLovePercentage(firstName: String, secondName: String):LiveData<LoveModel> =
        repository.getLovePercentage(firstName, secondName)

}