package nz.co.applog.picklist.internal

const val BASE_URL = "https://stephen.applog.co.nz/API/"

// Listener Constants
const val SCAN_RESULTS = "Scan Results"
const val SCAN_DIFFERS = "Scan Differs"
const val SCAN_INCONCLUSIVE = "Scan Inconclusive"
const val FEEDBACK_ACKNOWLEDGED = "Feedback Acknowledged"
const val QTY_UPDATED = "Quantity Updated"
const val GET_PICKLIST_RESULTS = "Get Picklist Results"
const val ERROR_NETWORK = "Network Error"
const val RECORD_EXISTS = "Record Exists"
const val ERROR_UNKNOWN = "Unknown Error"
const val ERROR_SOURCE = "Android"
const val PICK_LIST_DIALOG = "Pick List Dialog"
const val PICK_LIST_LINE_RESULTS = "Pick List Line Results Returned"

// arguments
const val SELECTED_PICKLIST_LINE = "Item No Selected"
const val SELECTED_PICK_SLIP_NO = "Slip No Selected"
const val SCAN_DIFFERS_TEXT = "Scan Differs Text"
const val ITEM_BARCODE = "Item Barcode"

class Constants {
    enum class Network(val tag: String) {
        DATA("data"),
        CSI("csi")
    }

    enum class Feedback(severity: Int) {
        Error(0),
        Warning(1),
        Information(2),
        Confirmation(3),
        ConfirmOrCancel(4),
        Logout(5)
    }

    enum class Sort(sort: Int) {
        ASC(0),
        DESC(1)
    }

    enum class PicklistType(type: Int) {
        CONSOLIDATED(0),
        URGENT(1)
    }

    enum class Button(clicked: Int) {
        Continue(0),
        ReScan(1),
        Cancel(2),
        OK(3),
        Yes(4),
        No(5)
    }


}