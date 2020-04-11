/*
 * Created By vpnhan at 10/4/2020.
 */

package com.estrouge.test.utopicacities.base

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.recyclerview.widget.RecyclerView
import com.estrouge.test.utopicacities.BR

abstract class BaseRvAdapter<D, M : BaseViewModel, T : BaseRvAdapter.BaseHolder<D, M>>
    (var data: MutableList<D>?) : RecyclerView.Adapter<T>() {

    abstract fun onCreate(parent: ViewGroup, viewType: Int): ViewDataBinding

    abstract fun onNewInstanceHolder(binding: ViewDataBinding): T

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): T {
        val binding = onCreate(parent, viewType)
        val holder = onNewInstanceHolder(binding)
        binding.lifecycleOwner = holder
        return holder
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: T, position: Int) {
        data?.let { holder.bind(it.getOrNull(position)) }
    }

    override fun onViewAttachedToWindow(holder: T) {
        super.onViewAttachedToWindow(holder)
        holder.markAttach()
    }

    override fun onViewDetachedFromWindow(holder: T) {
        super.onViewDetachedFromWindow(holder)
        holder.markDetach()
    }

    fun update(list: MutableList<D>) {
        data?.clear()
        data?.addAll(list)
        notifyDataSetChanged()
    }

    open class BaseHolder<D, M : BaseViewModel>(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root), LifecycleOwner {

        private val lifecycleRegistry = LifecycleRegistry(this@BaseHolder)

        open fun markAttach() {
            lifecycleRegistry.currentState = Lifecycle.State.STARTED
        }

        open fun markDetach() {
            lifecycleRegistry.currentState = Lifecycle.State.DESTROYED
        }

        override fun getLifecycle(): Lifecycle {
            return lifecycleRegistry
        }

        var itemViewModel: M? = null

        init {
            lifecycleRegistry.currentState = Lifecycle.State.INITIALIZED
        }

        open fun bind(t: D?) {
            itemViewModel?.let { binding.setVariable(BR.itemViewModel, it) }
            this@BaseHolder.let { binding.setVariable(BR.holder, it) }
        }
    }
}