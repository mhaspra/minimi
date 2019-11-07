package ch.haspra.minimi.domain.sensor.position

import android.hardware.Sensor
import ch.haspra.minimi.domain.sensor.SensorEntity
import ch.haspra.minimi.domain.sensor.SensorEntity.SensorType.POSITION

class ProximitySensor(hardwareSensor: Sensor) : SensorEntity(hardwareSensor) {
    override val unit: String = "cm"
    override val type: SensorType = POSITION
}