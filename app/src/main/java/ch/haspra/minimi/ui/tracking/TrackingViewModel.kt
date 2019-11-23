package ch.haspra.minimi.ui.tracking

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class TrackingViewModel(application: Application) : AndroidViewModel(application) {

    private val _title = MutableLiveData<String>().apply {
        value = "Live Tracking"
    }

    val title: LiveData<String> = _title
}