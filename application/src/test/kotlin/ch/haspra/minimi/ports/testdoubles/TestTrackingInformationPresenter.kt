package ch.haspra.minimi.ports.testdoubles

import ch.haspra.minimi.application.output_ports.TrackingInformationPresenter
import ch.haspra.minimi.application.usecases.tracking_information.port.TrackingInformation

class TestTrackingInformationPresenter : TrackingInformationPresenter {
    lateinit var presented: TrackingInformation

    override fun present(trackingInformation: TrackingInformation) {
        presented = trackingInformation;
    }
}