package ch.haspra.minimi.ui.tracking

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ch.haspra.minimi.application.usecases.tracking_information.ShowTrackingInformation
import ch.haspra.minimi.domain.Pressure

class TrackingViewModel(application: Application) : AndroidViewModel(application) {
    private val showTrackingInformation: ShowTrackingInformation = ShowTrackingInformation()

    private val _title = MutableLiveData<String>().apply {
        value = "Live Tracking"
    }

    private val _pressure = MutableLiveData<Pressure>().apply {
        value = showTrackingInformation.invoke().pressure
    }

    val title: LiveData<String> = _title

    val pressure: LiveData<Pressure> = _pressure
}