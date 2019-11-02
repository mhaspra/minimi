package ch.haspra.minimi.ui.sensors.environment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import ch.haspra.minimi.R
import ch.haspra.minimi.domain.ObservableSensor


class LiveSensorAdapter(
    private val context: Context,
    private val sensors: List<ObservableSensor>
) : BaseAdapter() {
    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return sensors.size
    }

    override fun getItem(position: Int): Any {
        return sensors[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val sensorView: View

        if (convertView == null) {
            val layoutInflater = LayoutInflater.from(context)
            sensorView = layoutInflater.inflate(R.layout.grid_item_sensor, null)
        } else {
            sensorView = convertView
        }

        val sensor = sensors[position]

        val nameTextView = sensorView.findViewById(R.id.grid_sensor_name) as TextView
        val valueTextView = sensorView.findViewById(R.id.grid_sensor_value) as TextView
        val unitTextView = sensorView.findViewById(R.id.grid_sensor_unit) as TextView

        nameTextView.text = sensor.sensor.name

        sensor.values.observeForever {
            if (it.isNotEmpty()) {
                valueTextView.text = it[0].toString()
            }
        }

        unitTextView.text = sensor.sensor.unit

        return sensorView
    }
}