package ch.haspra.minimi.ui.sensors

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import ch.haspra.minimi.R
import ch.haspra.minimi.domain.sensor.SensorEntity


class LiveSensorAdapter(
    private val context: Context,
    private val sensors: List<SensorEntity>
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
            sensorView = layoutInflater.inflate(R.layout.grid_item_sensor, parent, false)
        } else {
            sensorView = convertView
        }

        val sensor = sensors[position]

        val nameTextView = sensorView.findViewById(R.id.grid_sensor_name) as TextView


        nameTextView.text = sensor.name

        sensor.values.observeForever {
            if (it.isNotEmpty()) {
                val listView = sensorView.findViewById(R.id.sensor_values_list) as ListView
                listView.adapter = SensorValuesAdapter(context, it)
            }
        }

        return sensorView
    }
}