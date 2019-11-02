package ch.haspra.minimi.domain.sensor.environment

import android.hardware.Sensor
import ch.haspra.minimi.domain.sensor.SensorEntity

class Barometer(hardwareSensor: Sensor) : SensorEntity(hardwareSensor) {
    override val unit: String = "hPa"

}