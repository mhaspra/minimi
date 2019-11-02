package ch.haspra.minimi.domain.sensor

import android.hardware.Sensor
import android.hardware.Sensor.*

class SensorFactory {
    companion object {
        fun create(sensor: Sensor): SensorEntity {
            return when (sensor.type) {
                TYPE_PRESSURE -> Barometer(sensor)
                TYPE_LIGHT -> LightSensor(sensor)
                TYPE_AMBIENT_TEMPERATURE -> AmbientTemparatureSensor(
                    sensor
                )
                TYPE_RELATIVE_HUMIDITY -> AmbientHumidity(sensor)
                else -> SensorEntity(sensor)
            }
        }
    }
}