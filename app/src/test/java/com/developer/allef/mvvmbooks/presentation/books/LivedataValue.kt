package com.developer.allef.mvvmbooks.presentation.books

sealed class LiveDataResult<Value> {
    /**
     * Success, contains the value returned by the cache execution
     * @property value Result
     */
    class Success<Value>(val value: Value) : LiveDataResult<Value>()

    /**
     * Failure, contains the exception thrown by the cache execution
     * @property exception  Thrown exception
     */
    class Failure<Value>(val exception: Throwable?) : LiveDataResult<Value>()

    /**
     * Loading, when a cache execution is in progress and is not yet Success or Failure
     */
    class Loading<Value> : LiveDataResult<Value>()
}