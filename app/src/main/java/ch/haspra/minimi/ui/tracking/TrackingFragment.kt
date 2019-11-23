package ch.haspra.minimi.ui.tracking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import ch.haspra.minimi.R


class TrackingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val sensorsViewModel by viewModels<TrackingViewModel>()

        val root = inflater.inflate(R.layout.fragment_tracking, container, false)
        val textView: TextView = root.findViewById(R.id.tracking_title)
        sensorsViewModel.title.observe(this, Observer {
            textView.text = it
        })

        val pressureView: TextView = root.findViewById(R.id.tracking_pressure_value)
        sensorsViewModel.pressure.observe(this, Observer {
            pressureView.text = it.value.toString()
        })

        return root
    }
}