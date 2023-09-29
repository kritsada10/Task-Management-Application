package com.exam.examrbh.util

import android.util.DisplayMetrics
import android.util.TypedValue

object SetDecoration {

    fun calculateDecoration(displayMetrics: DisplayMetrics): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, 8f,
            displayMetrics
        ).toInt()
    }

}