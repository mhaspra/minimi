package ch.haspra.minimi.domain.sensor.motion


import android.hardware.Sensor
import android.hardware.SensorEvent
import ch.haspra.minimi.domain.sensor.SensorEntity
import ch.haspra.minimi.domain.sensor.SensorEntity.SensorType.MOTION
import ch.haspra.minimi.domain.sensor.SensorValue
import ch.haspra.minimi.extensions.getOrNull

class GyroscopeUncalibrated(hardwareSensor: Sensor) : SensorEntity(hardwareSensor) {
    override val unit: String = "rad/s"

    override val type: SensorType = MOTION

    override fun onSensorChanged(sensorEvent: SensorEvent?) {
        val sensorValues = ArrayList<SensorValue>(3)
        sensorValues.add(SensorValue(sensorEvent?.getOrNull(0), unit, "x"))
        sensorValues.add(SensorValue(sensorEvent?.getOrNull(1), unit, "y"))
        sensorValues.add(SensorValue(sensorEvent?.getOrNull(2), unit, "z"))

        values.postValue(sensorValues)
    }

}