package ch.haspra.minimi.ui.sensors

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ch.haspra.minimi.R

class SensorsFragment : Fragment() {

    private lateinit var sensorsViewModel: SensorsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sensorsViewModel =
            ViewModelProviders.of(this).get(SensorsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_sensors, container, false)
        val textView: TextView = root.findViewById(R.id.text_sensors)
        sensorsViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}