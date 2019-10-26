package ch.haspra.minimi.ui.sensors

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ch.haspra.minimi.repos.SensorsRepository

class SensorsViewModel(application: Application) : AndroidViewModel(application) {
    private val sensorsRepository: SensorsRepository = SensorsRepository(getApplication())

    private val _title = MutableLiveData<String>().apply {
        value =
            sensorsRepository.getSensors().value?.size.toString()//"There are x sensors available"
    }
    val title: LiveData<String> = _title
}