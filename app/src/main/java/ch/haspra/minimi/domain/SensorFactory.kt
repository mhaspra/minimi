package ch.haspra.minimi.domain

import android.hardware.Sensor

class SensorFactory {
    companion object {
        fun create(sensor: Sensor): SensorEntity {
            return when (sensor.type) {
                Sensor.TYPE_PRESSURE -> Barometer(sensor)
                else -> SensorEntity(sensor)
            }
        }
    }
}