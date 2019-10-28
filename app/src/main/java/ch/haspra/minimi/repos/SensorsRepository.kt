package ch.haspra.minimi.repos

import android.content.Context
import android.content.Context.SENSOR_SERVICE
import android.hardware.Sensor
import android.hardware.Sensor.TYPE_ALL
import android.hardware.SensorManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class SensorsRepository(private val context: Context) {
    fun getSensors(): LiveData<List<Sensor>> {
        val sensorManager = context.getSystemService(SENSOR_SERVICE) as SensorManager

        val data = MutableLiveData<List<Sensor>>()
        data.value = sensorManager.getSensorList(TYPE_ALL).sortedBy { sensor -> sensor.name }
        return data
    }
}