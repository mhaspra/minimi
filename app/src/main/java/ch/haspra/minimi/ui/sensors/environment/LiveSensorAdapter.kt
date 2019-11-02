package ch.haspra.minimi.ui.sensors.environment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
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
        val dummyTextView = TextView(context)

        sensors[position].values.observeForever {
            if (it.isNotEmpty()) {
                dummyTextView.text = it[0].toString()
            }
        }
        return dummyTextView
    }
}