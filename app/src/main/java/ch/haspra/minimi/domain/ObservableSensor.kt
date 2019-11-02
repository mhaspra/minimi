package ch.haspra.minimi.domain

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import androidx.lifecycle.MutableLiveData

class ObservableSensor(val sensor: SensorEntity) : SensorEventListener {
    var values: MutableLiveData<FloatArray> = MutableLiveData(FloatArray(0))

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        //don't know what to do yet
    }

    override fun onSensorChanged(sensorEvent: SensorEvent?) {
        values.value = sensorEvent?.values?.clone()!!
    }

}