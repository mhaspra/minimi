package ch.haspra.minimi.extensions

import android.hardware.SensorEvent

fun SensorEvent.getOrNull(i: Int) = this.values?.getOrNull(i)