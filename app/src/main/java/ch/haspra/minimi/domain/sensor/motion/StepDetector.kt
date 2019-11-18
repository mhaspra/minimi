package ch.haspra.minimi.domain.sensor.motion

import android.hardware.Sensor
import ch.haspra.minimi.domain.sensor.SensorEntity
import ch.haspra.minimi.domain.sensor.SensorEntity.SensorType.MOTION

class StepDetector(hardwareSensor: Sensor) : SensorEntity(hardwareSensor) {
    override val unit: String = "detected"

    override val type: SensorType = MOTION
}