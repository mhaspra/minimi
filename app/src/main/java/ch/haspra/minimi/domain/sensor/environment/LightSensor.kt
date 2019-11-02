package ch.haspra.minimi.domain.sensor.environment

import android.hardware.Sensor
import ch.haspra.minimi.domain.sensor.SensorEntity

class LightSensor(hardwareSensor: Sensor) : SensorEntity(hardwareSensor) {
    override val unit: String = "lx"

}