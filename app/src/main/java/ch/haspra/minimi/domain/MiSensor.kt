package ch.haspra.minimi.domain

import android.hardware.Sensor
import ch.haspra.minimi.domain.SensorType.*

class MiSensor(val sensor: Sensor) {

    val name: String
        get() = sensor.name

    val vendor: String
        get() = sensor.vendor

    val type: SensorType
        get() {
            return when (sensor.type) {
                Sensor.TYPE_AMBIENT_TEMPERATURE -> ENVIRONMENT
                Sensor.TYPE_LIGHT -> ENVIRONMENT
                Sensor.TYPE_PRESSURE -> ENVIRONMENT
                Sensor.TYPE_RELATIVE_HUMIDITY -> ENVIRONMENT
                Sensor.TYPE_GAME_ROTATION_VECTOR -> POSITION
                Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR -> POSITION
                Sensor.TYPE_MAGNETIC_FIELD -> POSITION
                Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED -> POSITION
                Sensor.TYPE_ORIENTATION -> POSITION
                Sensor.TYPE_PROXIMITY -> POSITION
                Sensor.TYPE_ACCELEROMETER -> MOTION
                Sensor.TYPE_ACCELEROMETER_UNCALIBRATED -> MOTION
                Sensor.TYPE_GRAVITY -> MOTION
                Sensor.TYPE_GYROSCOPE -> MOTION
                Sensor.TYPE_GYROSCOPE_UNCALIBRATED -> MOTION
                Sensor.TYPE_LINEAR_ACCELERATION -> MOTION
                Sensor.TYPE_ROTATION_VECTOR -> MOTION
                Sensor.TYPE_SIGNIFICANT_MOTION -> MOTION
                Sensor.TYPE_STEP_COUNTER -> MOTION
                Sensor.TYPE_STEP_DETECTOR -> MOTION
                else -> UNKNOWN
            }
        }
}

enum class SensorType {
    ENVIRONMENT, MOTION, POSITION, UNKNOWN
}