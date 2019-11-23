package ch.haspra.minimi.application.output_ports

import ch.haspra.minimi.application.usecases.tracking_information.port.TrackingInformation

interface TrackingInformationPresenter {
    fun present(trackingInformation: TrackingInformation)
}