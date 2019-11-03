package ch.haspra.minimi.ui.sensors

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import ch.haspra.minimi.R
import ch.haspra.minimi.domain.sensor.SensorValue

class SensorValuesAdapter(
    private val context: Context,
    private val values: List<SensorValue>
) : BaseAdapter() {
    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return values.size
    }

    override fun getItem(position: Int): Any {
        return values[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val valueView: View

        if (convertView == null) {
            val layoutInflater = LayoutInflater.from(context)
            valueView = layoutInflater.inflate(R.layout.sensor_value, null)
        } else {
            valueView = convertView
        }

        val value = values[position]

        val descriptionTextView = valueView.findViewById(R.id.sensor_value_description) as TextView
        val valueTextView = valueView.findViewById(R.id.sensor_value_value) as TextView
        val unitTextView = valueView.findViewById(R.id.sensor_value_unit) as TextView

        descriptionTextView.text = value.description
        valueTextView.text = value.value.toString()
        unitTextView.text = value.unit

        return valueView
    }
}