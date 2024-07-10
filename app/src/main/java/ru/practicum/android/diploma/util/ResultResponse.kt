package ru.practicum.android.diploma.util

sealed class ResultResponse<out T> {
    data class Success<T>(val data: T) : ResultResponse<T>()
    data class Error(val message: String) : ResultResponse<Nothing>()
    object Loading : ResultResponse<Nothing>()
    object Initial : ResultResponse<Nothing>()

    val isSuccess: Boolean
        get() = this is Success

    val isError: Boolean
        get() = this is Error

    val isLoading: Boolean
        get() = this is Loading

    val isInitial: Boolean
        get() = this is Initial
}
