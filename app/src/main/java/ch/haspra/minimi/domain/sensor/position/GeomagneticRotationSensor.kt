package ch.haspra.minimi.domain.sensor.position

import android.hardware.Sensor
import android.hardware.SensorEvent
import ch.haspra.minimi.domain.sensor.SensorEntity
import ch.haspra.minimi.domain.sensor.SensorValue

class GeomagneticRotationSensor(hardwareSensor: Sensor) : SensorEntity(hardwareSensor) {
    //Unitless, rotation vector component along the _ axis (_ * sin(θ/2)).
    override val unit: String = ""

    override val type: SensorType = SensorType.POSITION

    override fun onSensorChanged(sensorEvent: SensorEvent?) {
        val sensorValues = ArrayList<SensorValue>(3)
        sensorValues.add(SensorValue(getValueAt(sensorEvent, 0), unit, "x"))
        sensorValues.add(SensorValue(getValueAt(sensorEvent, 1), unit, "y"))
        sensorValues.add(SensorValue(getValueAt(sensorEvent, 2), unit, "z"))

        values.postValue(sensorValues)
    }

    private fun getValueAt(event: SensorEvent?, i: Int) = event?.values?.getOrNull(i)

}