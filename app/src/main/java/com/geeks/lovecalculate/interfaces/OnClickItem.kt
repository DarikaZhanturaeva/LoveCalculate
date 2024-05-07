package com.geeks.lovecalculate.interfaces

import android.content.Context
import com.geeks.lovecalculate.data.local.entities.History

interface OnClickItem {
    fun onLongClick(history: History)
}