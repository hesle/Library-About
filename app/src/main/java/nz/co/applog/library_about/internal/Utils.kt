package nz.co.applog.picklist.internal

import android.R
import android.app.DatePickerDialog
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import nz.co.applog.picklist.database.coreRepositories.FeedBackRepository
import java.util.*


class Utils(
    context: Context,
    private val feedBackRepository: FeedBackRepository
) {
    private val appContext = context

    @Suppress("DEPRECATION")
    fun getColor(color: Int): Int {
        return appContext.resources.getColor(color)
    }

    fun createNewFeedback(
        messageID: String,
        source: String,
        severity: String,
        messageText: String
    ) {
        feedBackRepository.createNewFeedback(
            messageID,
            source,
            severity,
            messageText
        )
    }

    fun errorSeverity(severity: String): Int {
        return when (severity) {
            Constants.Feedback.Error.toString() -> Constants.Feedback.Error.ordinal
            Constants.Feedback.Warning.toString() -> Constants.Feedback.Warning.ordinal
            Constants.Feedback.Information.toString() -> Constants.Feedback.Information.ordinal
            Constants.Feedback.Confirmation.toString() -> Constants.Feedback.Confirmation.ordinal
            Constants.Feedback.ConfirmOrCancel.toString() -> Constants.Feedback.ConfirmOrCancel.ordinal
            Constants.Feedback.Logout.toString() -> Constants.Feedback.Logout.ordinal
            else -> -1
        }
    }

    fun datePicker(mContext: Context?, et: EditText) {
        val myCalendar = Calendar.getInstance()
        val year = myCalendar[Calendar.YEAR]
        val month = myCalendar[Calendar.MONTH]
        val day = myCalendar[Calendar.DAY_OF_MONTH]
        val picker = DatePickerDialog(
            mContext!!,
            { _, yearOfYear, monthOfYear, dayOfMonth -> et.setText("""$dayOfMonth/${monthOfYear + 1}/$yearOfYear""") },
            year,
            month,
            day
        )
        picker.datePicker.minDate = System.currentTimeMillis() - 1000
        picker.show()
    }

    fun softKeyboard(view: View, show: Boolean) {
        val imm = appContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (show) {
            imm.hideSoftInputFromWindow(view.windowToken, 0)
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
        } else
            imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun formatDate(dateFrom: String): String {
        val dateList = dateFrom.split(if (dateFrom.contains("/")) "/" else "-")
        return dateList[2] + "/" + dateList[1] + "/" + dateList[0]
    }

    fun returnTextAsString(message: Int): String {
        return String.format(appContext.resources.getString(message))
    }

    // message as an Int
    fun toast(message: Int, color: Int) {
        val msg: String = returnTextAsString(message)
        val toast: Toast = Toast.makeText(appContext, msg, Toast.LENGTH_LONG)
        val toastMessage = toast.view.findViewById<View>(R.id.message) as TextView
        toastMessage.setTextColor(getColor(color))
        toastMessage.textSize = 25F
        toast.show()
    }

    // message as a String
    fun toast(messageText: String, color: Int) {
        val toast: Toast = run { Toast.makeText(appContext, messageText, Toast.LENGTH_LONG) }
        val toastMessage = toast.view.findViewById<View>(R.id.message) as TextView
        toastMessage.setTextColor(getColor(color))
        toastMessage.textSize = 25F
        toast.show()
    }

}


fun View.snackbar(message: String) {
    Snackbar.make(this, message, Snackbar.LENGTH_LONG).also { snackbar ->
        snackbar.setAction("Ok") {
            snackbar.dismiss()
        }
    }.show()
}

fun ProgressBar.show() {
    visibility = View.VISIBLE
}

fun ProgressBar.hide() {
    visibility = View.GONE
}

