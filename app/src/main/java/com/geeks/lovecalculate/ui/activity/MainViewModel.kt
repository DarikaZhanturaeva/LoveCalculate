package com.geeks.lovecalculate.ui.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.geeks.lovecalculate.data.local.entities.History
import com.geeks.lovecalculate.data.network.model.LoveModel
import com.geeks.lovecalculate.data.repository.LoveRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: LoveRepository
) : ViewModel() {

    // var lovePercentageLv = MutableLiveData<LoveModel>()
    fun getLovePercentage(firstName: String, secondName: String): LiveData<LoveModel> =
        repository.getLovePercentage(firstName, secondName)

    fun getAll(): LiveData<List<History>> = repository.sortAll()
}