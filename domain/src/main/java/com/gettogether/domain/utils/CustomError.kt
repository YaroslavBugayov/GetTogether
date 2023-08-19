package com.gettogether.domain.utils

sealed class CustomError(message: String) : Exception(message) {
    object NetworkError : CustomError("Network error")
    object ServerError : CustomError("Server error")
    object SomethingWentWrong : CustomError("Something went wrong")
}