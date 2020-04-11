/*
 * Created By vpnhan at 11/4/2020.
 */

package com.estrouge.test.utopicacities.utils

import java.text.NumberFormat
import java.util.*

class NumberFormatUtils {
    companion object {
        @JvmStatic
        fun formatDecimal(number: Int?): String {
            return if (number == null) "" else NumberFormat.getInstance(Locale.US).format(number)
        }
    }
}