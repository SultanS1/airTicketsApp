package com.test.core.adapterDelegate

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

/**
 * DiffUtil.ItemCallback implementation for DelegateAdapterItem.
 */
internal class DelegateAdapterItemDiffCallback: DiffUtil.ItemCallback<DelegateAdapterItem>() {

    /**
     * Checks if the items have the same ID.
     *
     * @param oldItem The old item.
     * @param newItem The new item.
     * @return True if the items have the same ID, false otherwise.
     */
    override fun areItemsTheSame(oldItem: DelegateAdapterItem, newItem: DelegateAdapterItem): Boolean =
        oldItem::class == newItem::class && oldItem.id() == newItem.id()

    /**
     * Checks if the contents of the items are the same.
     *
     * @param oldItem The old item.
     * @param newItem The new item.
     * @return True if the contents of the items are the same, false otherwise.
     */
    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: DelegateAdapterItem, newItem: DelegateAdapterItem): Boolean =
        oldItem.content() == newItem.content()

    /**
     * Gets the change payload between two items.
     *
     * @param oldItem The old item.
     * @param newItem The new item.
     * @return The change payload between the old and new items.
     */
    override fun getChangePayload(oldItem: DelegateAdapterItem, newItem: DelegateAdapterItem): Any =
        oldItem.payload(newItem)
}