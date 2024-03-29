package ch.haspra.minimi.repos

import android.content.Context
import android.content.Context.SENSOR_SERVICE
import android.hardware.Sensor.TYPE_ALL
import android.hardware.SensorManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ch.haspra.minimi.domain.sensor.SensorEntity
import ch.haspra.minimi.domain.sensor.SensorEntity.SensorType
import ch.haspra.minimi.domain.sensor.SensorFactory

class SensorsRepository(context: Context) {
    private val sensorManager = context.getSystemService(SENSOR_SERVICE) as SensorManager

    fun getSensors(): LiveData<List<SensorEntity>> {
        val data = MutableLiveData<List<SensorEntity>>()
        data.value = getSensorsFromSensorManager()
        return data
    }


    fun getSensors(type: SensorType): LiveData<List<SensorEntity>> {
        val data = MutableLiveData<List<SensorEntity>>()
        val sensors = getSensorsFromSensorManager()
            .filter { it.type == type }

        data.value = sensors
        return data
    }

    private fun getSensorsFromSensorManager() =
        sensorManager.getSensorList(TYPE_ALL).map { sensor -> SensorFactory.create(sensor) }
            .sortedBy { sensor -> sensor.name }
}