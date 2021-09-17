package com.josh.app.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.josh.app.adapter.ClassAdapter
import com.josh.app.databinding.ActivityHomeBinding
import com.josh.app.others.Status
import com.josh.app.ui.viewmodel.HomeViewModel

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var viewModel: HomeViewModel
    private lateinit var classAdapter: ClassAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(HomeViewModel::class.java)

        initRecyclerView()
        initViewModel()
        viewModel.getDummyData()
    }

    private fun initViewModel() {
        classAdapter = ClassAdapter()
        binding.appBarMain.rvList.apply {
            val gridlayoutManager = GridLayoutManager(this@HomeActivity, 2)
            layoutManager = gridlayoutManager
            adapter = classAdapter
        }
    }

    private fun initRecyclerView() {
        viewModel.data.observe(this,{
            when(it.status){
                Status.NO_DATA -> {

                }

                Status.LOADING -> {

                }

                Status.ERROR -> {

                }

                Status.SUCCESS ->{
                    Log.i(TAG, "initRecyclerView: Data Updated $it")
                    classAdapter.setData(it.data)
                }
            }
        })
    }
    
    companion object{
        private const val TAG = "HomeActivity"
    }
}