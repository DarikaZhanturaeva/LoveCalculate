package com.geeks.lovecalculate.ui.activity

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.geeks.lovecalculate.App
import com.geeks.lovecalculate.data.local.entities.History
import com.geeks.lovecalculate.databinding.ActivityHistoryBinding
import com.geeks.lovecalculate.interfaces.OnClickItem
import com.geeks.lovecalculate.ui.adapter.HistoryAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryActivity : AppCompatActivity(), OnClickItem {

    private val binding by lazy {
        ActivityHistoryBinding.inflate(layoutInflater)
    }
    private val historyAdapter = HistoryAdapter(this)

    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupRecyclerView()

        viewModel.getAll().observe(this@HistoryActivity) {
            historyAdapter.submitList(it)
        }
    }

    private fun setupRecyclerView() {
        binding.rvHistory.adapter = historyAdapter //apply {
    }

    override fun onLongClick(history: History) {
        val builder = AlertDialog.Builder(this)
        with(builder) {
            setTitle("Вы точно хотите удалить?")
            setPositiveButton("Да") { dialog, which ->
                App.loveDataBase?.dao()?.deleteHistory(history)
            }
            setNegativeButton("Нет") { dialog, which ->
                dialog.cancel()
            }
            show()
        }
        builder.create()
    }
}