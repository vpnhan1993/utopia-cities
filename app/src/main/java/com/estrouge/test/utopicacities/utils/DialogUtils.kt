/*
 * Created By vpnhan at 11/4/2020.
 */

package com.estrouge.test.utopicacities.utils

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.estrouge.test.utopicacities.R

class DialogUtils {
    companion object {
        fun dialog(context: Context): AlertDialog {
            val root = LayoutInflater.from(context).inflate(R.layout.dialog_loading, null)
            val builder = AlertDialog.Builder(
                context,
                android.R.style.Theme_DeviceDefault_Dialog_NoActionBar
            )
            builder.setView(root)
            val dialog = builder.create()

            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window?.setDimAmount(0.5f)
            dialog.window?.setGravity(Gravity.CENTER)

            return dialog
        }

    }
}