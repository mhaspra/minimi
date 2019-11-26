package ch.haspra.minimi.application.input_ports

import ch.haspra.minimi.domain.Pressure

interface BarometerReporter {
    fun report(pressure: Pressure)
}