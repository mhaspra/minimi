package ch.haspra.minimi.domain.sensor.environment

import android.hardware.Sensor
import ch.haspra.minimi.domain.sensor.SensorEntity
import ch.haspra.minimi.domain.sensor.SensorEntity.SensorType.ENVIRONMENT

class Barometer(hardwareSensor: Sensor) : SensorEntity(hardwareSensor) {
    override val unit: String = "hPa"
    override val type: SensorType = ENVIRONMENT
}