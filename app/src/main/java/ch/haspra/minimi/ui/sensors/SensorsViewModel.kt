package ch.haspra.minimi.ui.sensors

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ch.haspra.minimi.repos.SensorsRepository

class SensorsViewModel : ViewModel() {
    private val sensorsRepository: SensorsRepository = SensorsRepository()

    private val _title = MutableLiveData<String>().apply {
        value =
            sensorsRepository.getSensors().value?.size.toString()//"There are x sensors available"
    }
    val title: LiveData<String> = _title
}