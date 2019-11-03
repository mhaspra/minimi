package ch.haspra.minimi.domain.sensor

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import androidx.lifecycle.MutableLiveData
import ch.haspra.minimi.domain.sensor.SensorEntity.SensorType.*

open class SensorEntity(val hardwareSensor: Sensor) : SensorEventListener {

    val name: String
        get() = hardwareSensor.name

    val vendor: String
        get() = hardwareSensor.vendor

    open val unit: String = ""

    var values: MutableLiveData<List<SensorValue>> = MutableLiveData()


    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        //don't know what to do yet
    }

    override fun onSensorChanged(sensorEvent: SensorEvent?) {
        values.value = sensorEvent?.values?.map { SensorValue(it, unit, "") }
    }

    open val type: SensorType
        get() {
            return when (hardwareSensor.type) {
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

    enum class SensorType {
        ENVIRONMENT, MOTION, POSITION, UNKNOWN
    }
}