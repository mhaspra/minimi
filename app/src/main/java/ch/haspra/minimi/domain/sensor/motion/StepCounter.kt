package ch.haspra.minimi.domain.sensor.motion

import android.hardware.Sensor
import ch.haspra.minimi.domain.sensor.SensorEntity
import ch.haspra.minimi.domain.sensor.SensorEntity.SensorType.MOTION

class StepCounter(hardwareSensor: Sensor) : SensorEntity(hardwareSensor) {
    override val unit: String = "steps"

    override val type: SensorType = MOTION
}