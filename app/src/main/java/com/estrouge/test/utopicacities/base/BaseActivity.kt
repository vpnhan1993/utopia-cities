/*
 * Created By vpnhan at 10/4/2020.
 */

package com.estrouge.test.utopicacities.base

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.estrouge.test.utopicacities.BR
import com.estrouge.test.utopicacities.utils.DialogUtils

abstract class BaseActivity<V : ViewDataBinding, M : BaseViewModel>(val modelClass: Class<M>) :
    AppCompatActivity() {

    abstract val subLayoutId: Int

    var binding: V? = null
    var viewModel: M? = null
    var loadingView: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpBinding()
        setUpLoading()
    }

    fun showLoading() {
        if (loadingView != null && !loadingView?.isShowing!!) loadingView?.show()
    }

    fun hideLoading() {
        if (loadingView != null && loadingView?.isShowing!!) loadingView?.hide()
    }

    private fun setUpLoading() {
        loadingView = DialogUtils.dialog(this)
        loadingView?.setCancelable(false)
    }

    private fun setUpBinding() {
        viewModel =
            ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(modelClass)
        binding = DataBindingUtil.setContentView(this, subLayoutId)
        binding?.lifecycleOwner = this
        binding?.setVariable(BR.viewModel, viewModel)
        binding?.setVariable(BR.activity, this)
    }

    override fun onDestroy() {
        hideLoading()
        super.onDestroy()
        binding = null
        viewModel = null
        loadingView = null
    }
}