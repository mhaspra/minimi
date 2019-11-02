package ch.haspra.minimi.ui.sensors.environment

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import ch.haspra.minimi.R


class EnvironmentSensorsFragment : Fragment(), SensorEventListener {
    private lateinit var sensorManager: SensorManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sensorManager = context?.getSystemService(Context.SENSOR_SERVICE) as SensorManager

        val sensorsViewModel by viewModels<EnvironmentSensorsViewModel>()

        val root = inflater.inflate(R.layout.fragment_environment_sensors, container, false)
        val textView: TextView = root.findViewById(R.id.environment_sensors_title)
        sensorsViewModel.title.observe(this, Observer {
            textView.text = it
        })

        val gridView = root.findViewById(R.id.environment_sensors_grid) as GridView
        sensorsViewModel.sensors.observe(this, Observer {
            gridView.adapter = LiveSensorAdapter(root.context, it)
        })


        return root
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSensorChanged(p0: SensorEvent?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}