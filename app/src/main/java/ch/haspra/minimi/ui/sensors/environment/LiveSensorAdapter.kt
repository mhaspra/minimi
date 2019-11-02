package ch.haspra.minimi.ui.sensors.environment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import ch.haspra.minimi.domain.MiSensor


class LiveSensorAdapter(
    private val context: Context,
    private val sensors: List<MiSensor>
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
        val dummyTextView = TextView(context)
        dummyTextView.text = sensors[position].name
        return dummyTextView
    }
}