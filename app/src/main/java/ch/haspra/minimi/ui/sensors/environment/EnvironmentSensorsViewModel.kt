package ch.haspra.minimi.ui.sensors.environment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ch.haspra.minimi.domain.ObservableSensor
import ch.haspra.minimi.domain.SensorType.ENVIRONMENT
import ch.haspra.minimi.repos.SensorsRepository

class EnvironmentSensorsViewModel(application: Application) : AndroidViewModel(application) {
    private val sensorsRepository: SensorsRepository = SensorsRepository(getApplication())

    private val _title = MutableLiveData<String>().apply {
        value = "Environment Sensors"
    }
    private val _sensors = MutableLiveData<List<ObservableSensor>>().apply {
        value = sensorsRepository.getSensors(ENVIRONMENT).value
    }

    val title: LiveData<String> = _title
    val sensors: LiveData<List<ObservableSensor>> = _sensors
}