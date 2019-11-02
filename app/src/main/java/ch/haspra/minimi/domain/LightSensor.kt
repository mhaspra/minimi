package ch.haspra.minimi.domain

import android.hardware.Sensor

class LightSensor(hardwareSensor: Sensor) : SensorEntity(hardwareSensor) {
    override val unit: String = "lx"

}