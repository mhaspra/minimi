package ch.haspra.minimi.repos

import android.content.Context
import android.content.Context.SENSOR_SERVICE
import android.hardware.Sensor.TYPE_ALL
import android.hardware.SensorManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ch.haspra.minimi.domain.MiSensor

class SensorsRepository(private val context: Context) {
    fun getSensors(): LiveData<List<MiSensor>> {
        val sensorManager = context.getSystemService(SENSOR_SERVICE) as SensorManager

        val data = MutableLiveData<List<MiSensor>>()
        data.value = sensorManager.getSensorList(TYPE_ALL).map { sensor -> MiSensor(sensor) }
            .sortedBy { sensor -> sensor.name }
        return data
    }
}