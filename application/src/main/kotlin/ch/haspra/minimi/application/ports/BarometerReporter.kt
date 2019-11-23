package ch.haspra.minimi.application.ports

import ch.haspra.minimi.domain.Pressure

interface BarometerReporter {
    fun report(pressure: Pressure)
}