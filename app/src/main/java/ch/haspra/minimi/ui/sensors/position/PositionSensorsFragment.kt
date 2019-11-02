package ch.haspra.minimi.ui.sensors.environment

import android.content.Context
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
import ch.haspra.minimi.ui.sensors.LiveSensorAdapter


class PositionSensorsFragment : Fragment() {
    private lateinit var sensorManager: SensorManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sensorManager = context?.getSystemService(Context.SENSOR_SERVICE) as SensorManager

        val sensorsViewModel by viewModels<PositionSensorsViewModel>()

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
}