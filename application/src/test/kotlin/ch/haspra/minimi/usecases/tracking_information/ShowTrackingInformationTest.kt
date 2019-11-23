package ch.haspra.minimi.usecases.tracking_information

import ch.haspra.minimi.application.usecases.tracking_information.ShowTrackingInformation
import ch.haspra.minimi.ports.testdoubles.TestTrackingInformationPresenter
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ShowTrackingInformationTest {

    @Test
    fun trackingInformation_is_compiled_correctly() {

        val presenter = TestTrackingInformationPresenter()
        val showTrackingInformation = ShowTrackingInformation()
        showTrackingInformation.invoke(presenter)

        assertEquals(1000.0F, presenter.presented.pressure.value)
    }
}

