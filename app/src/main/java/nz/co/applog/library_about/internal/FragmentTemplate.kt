package nz.co.applog.picklist.internal

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext


abstract class FragmentTemplate : Fragment(), CoroutineScope {
    private lateinit var job: Job
    private lateinit var callback: OnBackPressedCallback

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        job = Job()
        setBackButtonDispatcher()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (this::job.isInitialized) {
            job.cancel()
        }
    }

    /**
     * Adding BackButtonDispatcher callback to activity
     */
    private fun setBackButtonDispatcher() {
        callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                onBackPressed()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    /**
     * Override this method into your fragment to handleBackButton
     */
    open fun onBackPressed() {
    }
}

