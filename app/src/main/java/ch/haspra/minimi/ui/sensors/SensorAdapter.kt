package ch.haspra.minimi.ui.sensors

import android.content.Context
import android.hardware.Sensor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import ch.haspra.minimi.R

class SensorAdapter(
    context: Context,
    private val sensors: List<Sensor>
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
        val rowView = inflater.inflate(R.layout.list_item_sensor, parent, false)
        val iconImageView = rowView.findViewById(R.id.sensor_item_icon) as ImageView
        val titleTextView = rowView.findViewById(R.id.sensor_item_title) as TextView
        val descriptionTextView = rowView.findViewById(R.id.sensor_item_description) as TextView

        val sensor = getItem(position) as Sensor

        if (SensorsUtil.isEnvironmentSensor(sensor)) {
            iconImageView.setImageResource(android.R.drawable.ic_menu_info_details)
        } else if (SensorsUtil.isPositionSensor(sensor)) {
            iconImageView.setImageResource(android.R.drawable.ic_menu_mylocation)
        } else if (SensorsUtil.isMotionSensor(sensor)) {
            iconImageView.setImageResource(android.R.drawable.ic_menu_rotate)
        }
        titleTextView.text = "${sensor.name} (Type: ${sensor.type})"
        descriptionTextView.text = sensor.vendor

        return rowView
    }
}