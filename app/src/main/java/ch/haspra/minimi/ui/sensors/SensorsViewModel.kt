package ch.haspra.minimi.ui.sensors

import android.app.Application
import android.hardware.Sensor
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ch.haspra.minimi.repos.SensorsRepository

class SensorsViewModel(application: Application) : AndroidViewModel(application) {
    private val sensorsRepository: SensorsRepository = SensorsRepository(getApplication())

    private val _title = MutableLiveData<String>().apply {
        val numOfSensors = sensorsRepository.getSensors().value?.size
        value = "There are $numOfSensors sensors available"
    }

    private val _sensors = MutableLiveData<List<Sensor>>().apply {
        value = sensorsRepository.getSensors().value
    }

    val title: LiveData<String> = _title
    val sensors: LiveData<List<Sensor>> = _sensors
}