package ch.haspra.minimi.ui.sensors.environment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ch.haspra.minimi.domain.sensor.SensorEntity
import ch.haspra.minimi.domain.sensor.SensorEntity.SensorType.POSITION
import ch.haspra.minimi.repos.SensorsRepository

class PositionSensorsViewModel(application: Application) : AndroidViewModel(application) {
    private val sensorsRepository: SensorsRepository = SensorsRepository(getApplication())

    private val _title = MutableLiveData<String>().apply {
        value = "Position Sensors"
    }
    private val _sensors = MutableLiveData<List<SensorEntity>>().apply {
        value = sensorsRepository.getSensors(POSITION).value
    }

    val title: LiveData<String> = _title
    val sensors: LiveData<List<SensorEntity>> = _sensors
}