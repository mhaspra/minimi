package ch.haspra.minimi.repos

import android.content.Context
import android.content.Context.SENSOR_SERVICE
import android.hardware.Sensor.TYPE_ALL
import android.hardware.SensorManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ch.haspra.minimi.domain.MiSensor
import ch.haspra.minimi.domain.ObservableSensor
import ch.haspra.minimi.domain.SensorType
import ch.haspra.minimi.domain.SensorType.ENVIRONMENT

class SensorsRepository(context: Context) {
    private val sensorManager = context.getSystemService(SENSOR_SERVICE) as SensorManager

    fun getSensors(): LiveData<List<MiSensor>> {
        val data = MutableLiveData<List<MiSensor>>()
        data.value = getSensorsFromSensorManager()
        return data
    }


    fun getSensors(type: SensorType): LiveData<List<ObservableSensor>> {
        val data = MutableLiveData<List<ObservableSensor>>()
        val sensors = getSensorsFromSensorManager()
            .filter { it.type == ENVIRONMENT }
            .map { ObservableSensor(it) }

        sensors.forEach {
            sensorManager.registerListener(
                it, it.sensor.sensor,
                SensorManager.SENSOR_DELAY_NORMAL
            )
        }

        data.value = sensors
        return data
    }

    private fun getSensorsFromSensorManager() =
        sensorManager.getSensorList(TYPE_ALL).map { sensor -> MiSensor(sensor) }
            .sortedBy { sensor -> sensor.name }
}