package com.josh.app.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.josh.app.data.repository.ClassRepository

class HomeViewModel: ViewModel() {
    private val repository = ClassRepository()
    val data = repository.data

    fun getDummyData(){
        data.value = repository.getDummyClass().value
    }
}