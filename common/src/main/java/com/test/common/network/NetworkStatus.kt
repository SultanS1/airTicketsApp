package com.test.common.network

sealed interface NetworkStatus<T> {
    /**
     * get Successful response
     */
    class Success<T>(val data: T) : NetworkStatus<T>

    /**
     * in case If we get error from network
     */
    class Error<T>(val message: String) : NetworkStatus<T>

    /**
     * status when request is made but waiting for response
     */
    class Loading<T> : NetworkStatus<T>
}