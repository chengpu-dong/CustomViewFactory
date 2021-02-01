package com.panda.customviewfactory.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.panda.customviewfactory.R
import com.panda.customviewfactory.home.model.MainItemModel
import com.panda.customviewfactory.home.view.adapter.MainAdapter
import com.panda.customviewfactory.home.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private var viewModel: MainViewModel? = null
    private var adapter: MainAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initView()
        initViewModel()
        initData()
    }

    private fun initView() {
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        val layoutManager: LinearLayoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager
        adapter = MainAdapter()
        recyclerView.adapter = adapter
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel!!.getTypeData()
            .observe(
                this,
                Observer { list: List<MainItemModel> ->
                    adapter?.items = ArrayList<MainItemModel>(list)
                })
    }

    private fun initData() {
        viewModel?.initData()
    }
}