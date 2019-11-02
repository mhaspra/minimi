package ch.haspra.minimi.domain

import android.hardware.Sensor

class AmbientHumidity(hardwareSensor: Sensor) : SensorEntity(hardwareSensor) {
    override val unit: String = "%"

}