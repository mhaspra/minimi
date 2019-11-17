package ch.haspra.minimi.domain.sensor.position

import android.hardware.Sensor
import android.hardware.SensorEvent
import ch.haspra.minimi.domain.sensor.SensorEntity
import ch.haspra.minimi.domain.sensor.SensorValue
import ch.haspra.minimi.extensions.getOrNull

class GeomagneticRotationSensor(hardwareSensor: Sensor) : SensorEntity(hardwareSensor) {
    //Unitless, rotation vector component along the _ axis (_ * sin(θ/2)).
    override val unit: String = ""

    override val type: SensorType = SensorType.POSITION

    override fun onSensorChanged(sensorEvent: SensorEvent?) {
        val sensorValues = ArrayList<SensorValue>(3)
        sensorValues.add(SensorValue(sensorEvent?.getOrNull(0), unit, "x"))
        sensorValues.add(SensorValue(sensorEvent?.getOrNull(1), unit, "y"))
        sensorValues.add(SensorValue(sensorEvent?.getOrNull(2), unit, "z"))

        values.postValue(sensorValues)
    }

}