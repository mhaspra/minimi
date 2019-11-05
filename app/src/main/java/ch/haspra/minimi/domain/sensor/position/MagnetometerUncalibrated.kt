package ch.haspra.minimi.domain.sensor.position

import android.hardware.Sensor
import android.hardware.SensorEvent
import ch.haspra.minimi.domain.sensor.SensorEntity
import ch.haspra.minimi.domain.sensor.SensorEntity.SensorType.POSITION
import ch.haspra.minimi.domain.sensor.SensorValue

class MagnetometerUncalibrated(hardwareSensor: Sensor) : SensorEntity(hardwareSensor) {
    override val unit: String = "μT"
    override val type: SensorType = POSITION

    override fun onSensorChanged(sensorEvent: SensorEvent?) {
        val sensorValues = ArrayList<SensorValue>(3)
        sensorValues.add(SensorValue(getValueAt(sensorEvent, 0), unit, "x"))
        sensorValues.add(SensorValue(getValueAt(sensorEvent, 1), unit, "y"))
        sensorValues.add(SensorValue(getValueAt(sensorEvent, 2), unit, "z"))

        //skip the estimated bias as we are not interested in that at the moment

        values.postValue(sensorValues)
    }

    private fun getValueAt(event: SensorEvent?, i: Int) = event?.values?.getOrNull(i)
}