package ch.haspra.minimi.ui.tracking

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ch.haspra.minimi.application.output_ports.TrackingInformationPresenter
import ch.haspra.minimi.application.usecases.tracking_information.ShowTrackingInformation
import ch.haspra.minimi.application.usecases.tracking_information.port.TrackingInformation
import ch.haspra.minimi.domain.Pressure

class TrackingViewModel(application: Application) : AndroidViewModel(application),
    TrackingInformationPresenter {

    private val showTrackingInformation: ShowTrackingInformation = ShowTrackingInformation()

    private val _title = MutableLiveData<String>().apply {
        value = "Live Tracking"
    }

    private val _pressure = MutableLiveData<Pressure>()

    val title: LiveData<String> = _title

    val pressure: LiveData<Pressure> = _pressure


    init {
        showTrackingInformation.invoke(this)
    }

    override fun present(trackingInformation: TrackingInformation) {
        _pressure.postValue(trackingInformation.pressure)
    }

}