package com.test.core.adapterDelegate

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Abstract class for defining delegate adapters.
 *
 * @param M The type of model data.
 * @param VH The type of view holder.
 * @property modelClass The class of the model data handled by the adapter.
 */
abstract class DelegateAdapter<M, in VH : RecyclerView.ViewHolder>(val modelClass: Class<out M>) {

    /**
     * Creates a view holder for the adapter.
     *
     * @param parent The parent view group.
     * @return A new instance of the view holder.
     */
    abstract fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder
    /**
     * Binds the model data to the view holder.
     *
     * @param model The model data to bind.
     * @param viewHolder The view holder to bind to.
     * @param payloads A list of payloads.
     */
    abstract fun bindViewHolder(model: M, viewHolder: VH, payloads: List<DelegateAdapterItem.Payloadable>)

    /**
     * Called when the view holder is recycled.
     *
     * @param viewHolder The recycled view holder.
     */
    open fun onViewRecycled(viewHolder: VH) = Unit
    /**
     * Called when the view holder is detached from the window.
     *
     * @param viewHolder The detached view holder.
     */
    open fun onViewDetachedFromWindow(viewHolder: VH) = Unit

    /**
     * Called when the view holder is attached to the window.
     *
     * @param viewHolder The attached view holder.
     */
    open fun onViewAttachedToWindow(viewHolder: VH) = Unit

}