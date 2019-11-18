package ch.haspra.minimi.domain.sensor

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Handler
import android.os.HandlerThread
import androidx.lifecycle.MutableLiveData
import ch.haspra.minimi.domain.sensor.SensorEntity.SensorType.POSITION
import ch.haspra.minimi.domain.sensor.SensorEntity.SensorType.UNKNOWN

open class SensorEntity(val hardwareSensor: Sensor) : SensorEventListener {
    private var handlerThread: HandlerThread? = null

    val name: String
        get() = hardwareSensor.name

    val vendor: String
        get() = hardwareSensor.vendor

    open val unit: String = ""

    var values: MutableLiveData<List<SensorValue>> = MutableLiveData()

    fun register(sensorManager: SensorManager) {
        handlerThread = HandlerThread(name)
        handlerThread?.start()
        val handler = Handler(this.handlerThread?.looper)
        sensorManager.registerListener(
            this,
            hardwareSensor,
            500_000,
            handler
        )
    }

    fun unregister(sensorManager: SensorManager) {
        sensorManager.unregisterListener(this)
        if (handlerThread?.isAlive == true)
            handlerThread?.quitSafely()
    }


    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        //don't know what to do yet
    }

    override fun onSensorChanged(sensorEvent: SensorEvent?) {
        values.postValue(sensorEvent?.values?.map { SensorValue(it, unit, "") })
    }

    open val type: SensorType
        get() {
            return when (hardwareSensor.type) {
                Sensor.TYPE_ORIENTATION -> POSITION
                else -> UNKNOWN
            }
        }

    enum class SensorType {
        ENVIRONMENT, MOTION, POSITION, UNKNOWN
    }
}