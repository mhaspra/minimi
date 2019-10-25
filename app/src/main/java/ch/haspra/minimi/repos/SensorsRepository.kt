package ch.haspra.minimi.repos

import android.hardware.Sensor
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class SensorsRepository {
    fun getSensors(): LiveData<List<Sensor>> {
        val data = MutableLiveData<List<Sensor>>()
        data.value = emptyList()
        return data
    }
}