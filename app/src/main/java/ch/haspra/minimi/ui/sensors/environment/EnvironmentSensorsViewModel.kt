package ch.haspra.minimi.ui.sensors.environment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EnvironmentSensorsViewModel : ViewModel() {
    private val _title = MutableLiveData<String>().apply {
        value = "Environment Sensors"
    }
    val title: LiveData<String> = _title
}