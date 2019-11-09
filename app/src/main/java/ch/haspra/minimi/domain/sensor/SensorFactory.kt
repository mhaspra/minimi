package ch.haspra.minimi.domain.sensor

import android.hardware.Sensor
import android.hardware.Sensor.*
import ch.haspra.minimi.domain.sensor.environment.AmbientHumidity
import ch.haspra.minimi.domain.sensor.environment.AmbientTemparatureSensor
import ch.haspra.minimi.domain.sensor.environment.Barometer
import ch.haspra.minimi.domain.sensor.environment.LightSensor
import ch.haspra.minimi.domain.sensor.motion.Accelerometer
import ch.haspra.minimi.domain.sensor.motion.AccelerometerUncalibrated
import ch.haspra.minimi.domain.sensor.motion.GravitySensor
import ch.haspra.minimi.domain.sensor.position.*

class SensorFactory {
    companion object {
        fun create(sensor: Sensor): SensorEntity {
            return when (sensor.type) {
                TYPE_PRESSURE -> Barometer(sensor)
                TYPE_LIGHT -> LightSensor(sensor)
                TYPE_AMBIENT_TEMPERATURE -> AmbientTemparatureSensor(sensor)
                TYPE_RELATIVE_HUMIDITY -> AmbientHumidity(sensor)
                TYPE_MAGNETIC_FIELD -> Magnetometer(sensor)
                TYPE_MAGNETIC_FIELD_UNCALIBRATED -> MagnetometerUncalibrated(sensor)
                TYPE_GAME_ROTATION_VECTOR -> GameRotationSensor(sensor)
                TYPE_GEOMAGNETIC_ROTATION_VECTOR -> GeomagneticRotationSensor(sensor)
                TYPE_PROXIMITY -> ProximitySensor(sensor)
                TYPE_ACCELEROMETER -> Accelerometer(sensor)
                TYPE_ACCELEROMETER_UNCALIBRATED -> AccelerometerUncalibrated(sensor)
                TYPE_GRAVITY -> GravitySensor(sensor)
                else -> SensorEntity(sensor)
            }
        }
    }
}