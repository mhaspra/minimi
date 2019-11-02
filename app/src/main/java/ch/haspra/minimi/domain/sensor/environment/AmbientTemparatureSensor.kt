package ch.haspra.minimi.domain.sensor.environment

import android.hardware.Sensor
import ch.haspra.minimi.domain.sensor.SensorEntity

class AmbientTemparatureSensor(hardwareSensor: Sensor) : SensorEntity(hardwareSensor) {
    override val unit: String = "°C"

}