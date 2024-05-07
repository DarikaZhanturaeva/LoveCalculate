package com.geeks.lovecalculate.extensions

import androidx.room.Entity
import com.geeks.lovecalculate.data.local.entities.History
import com.geeks.lovecalculate.data.network.model.LoveModel
import javax.inject.Inject

fun LoveModel.toHistory(): History {
    return History(
        firstName = this.firstName,
        secondName = this.secondName,
        percent = (this.percentage.toIntOrNull() ?: 0).toString()
    )
}

fun History.toLoveModel(): LoveModel {
    return LoveModel(
        firstName = this.firstName,
        secondName = this.secondName,
        percentage = this.percent,
        result = " "
    )
}