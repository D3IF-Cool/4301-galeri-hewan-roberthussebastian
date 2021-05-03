package org.d3if4035.galerihewan.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.d3if4035.galerihewan.Hewan
import org.d3if4035.galerihewan.network.HewanApiService

class MainViewModel : ViewModel() {

    private val data = MutableLiveData<List<Hewan>>()
    init {
        retrieveData()
    }

    private fun retrieveData() {
        viewModelScope.launch {
            try {
                data.value = HewanApiService.HewanApi.service.getHewan()
            } catch (e: Exception) {
                Log.d("MainViewModel", "Failure: ${e.message}")
            }
        }
    }
    // Data ini akan kita ambil dari server
    fun getData(): LiveData<List<Hewan>> = data
}
