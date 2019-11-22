package ch.haspra.minimi.usecases.tracking_information

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ShowTrackingInformationTest {

    @Test
    fun trackingInformation_is_compiled_correctly() {
        val showTrackingInformation = ShowTrackingInformation()
        val trackingInformation = showTrackingInformation.invoke()

        assertEquals(1000.0F, trackingInformation.pressure.value)
    }
}

