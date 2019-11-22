package ch.haspra.minimi.usecases.tracking_information

import ch.haspra.minimi.domain.Pressure
import ch.haspra.minimi.usecases.tracking_information.port.TrackingInformation

class ShowTrackingInformation() {
    fun invoke(): TrackingInformation {
        return TrackingInformation(Pressure(1000.0F))
    }
}

