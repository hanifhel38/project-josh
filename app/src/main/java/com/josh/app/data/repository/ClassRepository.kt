package com.josh.app.data.repository

import androidx.lifecycle.MutableLiveData
import com.josh.app.data.model.ClassModel
import com.josh.app.data.rest.ApiClient
import com.josh.app.data.rest.ApiInterface
import com.josh.app.others.ApiResponse
import com.josh.app.others.Status

class ClassRepository {
    private val api = ApiClient.getClient().create(ApiInterface::class.java)
    val data = MutableLiveData<ApiResponse<List<ClassModel>>>()

    fun getClass(){
        //TODO: Add API Call to server
    }

    fun getDummyClass(): MutableLiveData<ApiResponse<List<ClassModel>>> {
        val list = listOf(
            ClassModel("https://picsum.photos/200","Kelas 1"),
            ClassModel("https://picsum.photos/200","Kelas 2"),
            ClassModel("https://picsum.photos/200","Kelas 3"),
            ClassModel("https://picsum.photos/200","Kelas 4"),
            ClassModel("https://picsum.photos/200","Kelas 5"),
            ClassModel("https://picsum.photos/200","Kelas 6")
        )

        data.value = ApiResponse.success(list)
        return data
    }
}