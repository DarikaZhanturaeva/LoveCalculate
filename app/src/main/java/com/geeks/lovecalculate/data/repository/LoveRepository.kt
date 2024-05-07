package com.geeks.lovecalculate.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.geeks.lovecalculate.LoveApiService
import com.geeks.lovecalculate.data.local.dao.LoveDao
import com.geeks.lovecalculate.data.local.database.LoveDatabase
import com.geeks.lovecalculate.data.local.entities.History
import com.geeks.lovecalculate.data.network.model.LoveModel
import com.geeks.lovecalculate.extensions.toHistory
import com.geeks.lovecalculate.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class LoveRepository @Inject constructor(
    private val api: LoveApiService,
    private val dao: LoveDao
) {

    private val lovePercentageLv = MutableLiveData<LoveModel>()
    val error = MutableLiveData<String>()
    val loading = MutableLiveData<Boolean>()

    fun getLovePercentage(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        api?.getPercentage(
            apiKey = Constants.API_KEY,
            host = Constants.HOST,
            firstName = firstName,
            secondName = secondName
        )?.enqueue(object :
            Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful && response.body() != null) {
                    response.body()?.let {
                        val history = it.toHistory()
                        dao.insertHistory(history)
                        lovePercentageLv.postValue(it)
                    }
                    loading.value = false
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                error.value = t.localizedMessage
                loading.value = false
            }
        })
        return lovePercentageLv
    }

    fun sortAll(): LiveData<List<History>> = dao.sortAll()

}