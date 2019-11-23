package ch.haspra.minimi.application.usecases.tracking_information

import ch.haspra.minimi.application.output_ports.TrackingInformationPresenter
import ch.haspra.minimi.application.usecases.tracking_information.port.TrackingInformation
import ch.haspra.minimi.domain.Pressure

class ShowTrackingInformation() {
    fun invoke(trackingInformationPresenter: TrackingInformationPresenter) {
        trackingInformationPresenter.present(TrackingInformation(Pressure(1000.0F)))
    }
}

