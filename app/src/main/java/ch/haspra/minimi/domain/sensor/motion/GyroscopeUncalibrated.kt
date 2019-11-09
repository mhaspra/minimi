package ch.haspra.minimi.domain.sensor.motion


import android.hardware.Sensor
import android.hardware.SensorEvent
import ch.haspra.minimi.domain.sensor.SensorEntity
import ch.haspra.minimi.domain.sensor.SensorEntity.SensorType.MOTION
import ch.haspra.minimi.domain.sensor.SensorValue

class GyroscopeUncalibrated(hardwareSensor: Sensor) : SensorEntity(hardwareSensor) {
    override val unit: String = "rad/s"

    override val type: SensorType = MOTION

    override fun onSensorChanged(sensorEvent: SensorEvent?) {
        val sensorValues = ArrayList<SensorValue>(3)
        sensorValues.add(SensorValue(getValueAt(sensorEvent, 0), unit, "x"))
        sensorValues.add(SensorValue(getValueAt(sensorEvent, 1), unit, "y"))
        sensorValues.add(SensorValue(getValueAt(sensorEvent, 2), unit, "z"))

        values.postValue(sensorValues)
    }

    private fun getValueAt(event: SensorEvent?, i: Int) = event?.values?.getOrNull(i)

}