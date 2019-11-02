package ch.haspra.minimi.domain.sensor

import android.hardware.Sensor

class Barometer(hardwareSensor: Sensor) : SensorEntity(hardwareSensor) {
    override val unit: String = "hPa"

}