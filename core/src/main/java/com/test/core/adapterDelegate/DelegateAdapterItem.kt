package com.test.core.adapterDelegate

/**
 * Interface for items handled by delegate adapters.
 */
interface DelegateAdapterItem {

    /**
     * Returns the ID of the item.
     *
     * @return The ID of the item.
     */
    fun id(): Any

    /**
     * Returns the content of the item.
     *
     * @return The content of the item.
     */
    fun content(): Any

    /**
     * Returns a payload for the item.
     *
     * @param other The other payload.
     * @return A payload for the item.
     */
    fun payload(other: Any): Payloadable = Payloadable.None

    /**
     * Simple marker interface for payloads
     */
    interface Payloadable {
        object None: Payloadable
    }
}