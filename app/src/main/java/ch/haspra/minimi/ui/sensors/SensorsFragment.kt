package ch.haspra.minimi.ui.sensors

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import ch.haspra.minimi.R

class SensorsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val sensorsViewModel by viewModels<SensorsViewModel>()

        val root = inflater.inflate(R.layout.fragment_sensors, container, false)
        val textView: TextView = root.findViewById(R.id.sensors_title)
        sensorsViewModel.title.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}