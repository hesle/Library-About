package nz.co.applog.about.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment.STYLE_NORMAL
import nz.co.applog.about.R

class AboutFragment : DialogFragmentTemplate() {

    lateinit var binding: AboutFragmentBinding
    private var isDebug: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.about_fragment, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isDebug = BuildConfig.DEBUG
        var versionName: String = BuildConfig.VERSION_NAME
        versionName += if (isDebug) "-${BuildConfig.DEBUG_VERSION}" else ""
        binding.versionCodeLabel.visibility = if (isDebug) View.VISIBLE else View.INVISIBLE
        binding.versionCode.visibility = if (isDebug) View.VISIBLE else View.INVISIBLE
        binding.appName.text = getString(R.string.app_name)
        binding.appVersion.text = versionName
        binding.versionCode.text = BuildConfig.VERSION_CODE.toString()
    }

}