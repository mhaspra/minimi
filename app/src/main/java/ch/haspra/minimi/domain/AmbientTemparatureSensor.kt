package ch.haspra.minimi.domain

import android.hardware.Sensor

class AmbientTemparatureSensor(hardwareSensor: Sensor) : SensorEntity(hardwareSensor) {
    override val unit: String = "°C"

}