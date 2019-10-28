package ch.haspra.minimi.ui.sensors

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import ch.haspra.minimi.R
import com.google.android.material.snackbar.Snackbar


class SensorsFragment : Fragment(), SensorEventListener {
    private lateinit var sensorManager: SensorManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sensorManager = context?.getSystemService(Context.SENSOR_SERVICE) as SensorManager

        val sensorsViewModel by viewModels<SensorsViewModel>()

        val root = inflater.inflate(R.layout.fragment_sensors, container, false)
        val textView: TextView = root.findViewById(R.id.sensors_title)
        sensorsViewModel.title.observe(this, Observer {
            textView.text = it
        })

        val listView = root.findViewById(R.id.sensors_list) as ListView
        sensorsViewModel.sensors.observe(this, Observer {
            listView.adapter = ArrayAdapter(
                root.context,
                android.R.layout.simple_list_item_1,
                it.map { sensor -> sensor.name })
        })

        listView.setOnItemClickListener { _, _, position, _ ->
            val sensor = sensorsViewModel.sensors.value?.get(position)
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
        }

        return root
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        //I don't know what to do here yet
    }

    override fun onSensorChanged(sensorEvent: SensorEvent?) {
        val snackbar =
            Snackbar.make(this.view!!, "${sensorEvent?.values?.get(0)}", Snackbar.LENGTH_LONG)
        snackbar.show()
        sensorManager.unregisterListener(this)
    }
}