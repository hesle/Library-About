package nz.co.applog.picklist.internal

import android.content.Context
import android.content.SharedPreferences

object AppPreferences {
    private const val NAME = "PICK_LIST"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    //SharedPreferences constants
    private val USERNAME = Pair("USER_NAME", "")
    private val USER_ID = Pair("USER_ID", "")
    private val PICK_LIST_LINE_FILTER = Pair("PICK_LIST_LINE_FILTER", "")
    private val CSI = Pair("CSI", "")
    private val SYSTEM_CODE = Pair("SYSTEM_CODE", "")
    private val USER_DEFAULT_LEDGER = Pair("USER_DEFAULT_LEDGER", "")
    private val PICK_LIST_ID = Pair("PICK_LIST_ID", "")
    private val LAST_TYPE_CHECKED = Pair("LAST_TYPE_CHECKED", -1)
    private val NETWORK_CONNECTED = Pair("NETWORK_CONNECTED", false)
    private val DISPLAY_DIVIDER = Pair("DISPLAY_DIVIDER", true)

    //an inline function to put variable and save it
    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    //SharedPreferences variables getters/setters
    var pickListLineFilter: String
        get() = preferences.getString(PICK_LIST_LINE_FILTER.first, PICK_LIST_LINE_FILTER.second)
            ?: ""
        set(value) = preferences.edit {
            it.putString(PICK_LIST_LINE_FILTER.first, value)
        }

    var pickListID: String
        get() = preferences.getString(PICK_LIST_ID.first, PICK_LIST_ID.second) ?: ""
        set(value) = preferences.edit {
            it.putString(PICK_LIST_ID.first, value)
        }

    var userDefaultLedger: String
        get() = preferences.getString(USER_DEFAULT_LEDGER.first, USER_DEFAULT_LEDGER.second) ?: ""
        set(value) = preferences.edit {
            it.putString(USER_DEFAULT_LEDGER.first, value)
        }

    var systemCode: String
        get() = preferences.getString(SYSTEM_CODE.first, SYSTEM_CODE.second) ?: ""
        set(value) = preferences.edit {
            it.putString(SYSTEM_CODE.first, value)
        }

    var isNetworkConnected: Boolean
        get() = preferences.getBoolean(NETWORK_CONNECTED.first, NETWORK_CONNECTED.second)
        set(value) = preferences.edit {
            it.putBoolean(NETWORK_CONNECTED.first, value)
        }

    var displayDivider: Boolean
        get() = preferences.getBoolean(DISPLAY_DIVIDER.first, DISPLAY_DIVIDER.second)
        set(value) = preferences.edit {
            it.putBoolean(DISPLAY_DIVIDER.first, value)
        }

    var lastTypeChecked: Int
        get() = preferences.getInt(LAST_TYPE_CHECKED.first, LAST_TYPE_CHECKED.second)
        set(value) = preferences.edit {
            it.putInt(LAST_TYPE_CHECKED.first, value)
        }

    var csi: String
        get() = preferences.getString(CSI.first, CSI.second) ?: ""
        set(value) = preferences.edit {
            it.putString(CSI.first, value)
        }

    var userName: String
        get() = preferences.getString(USERNAME.first, USERNAME.second) ?: ""
        set(value) = preferences.edit {
            it.putString(USERNAME.first, value)
        }

    var userID: String
        get() = preferences.getString(USER_ID.first, USER_ID.second) ?: ""
        set(value) = preferences.edit {
            it.putString(USER_ID.first, value)
        }
}