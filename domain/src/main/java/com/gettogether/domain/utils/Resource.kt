package com.gettogether.domain.utils

sealed class Resource<T>(val data: T?, val error: CustomError? = null) {
    class Success<T>(data: T? = null): Resource<T>(data)
    class Error<T>(error: CustomError, data: T? = null): Resource<T>(data, error)
}