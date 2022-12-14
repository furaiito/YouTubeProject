package com.example.youtubeapp.data.remote.network

import android.util.Log

data class Resource<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {


        fun <T> success(data: T): Resource<T> =
            Resource(status = Status.SUCCESS, data = data, message = null)

        fun <T> error(data: T?, message: String): Resource<T> {
            val result = Resource(status = Status.ERROR, data = data, message = message)
            Log.e("Error resource request:", result.toString())
            return result
        }

        fun <T> loading(data: T?): Resource<T> =
            Resource(status = Status.LOADING, data = data, message = null)

        fun <T> fetchFromDB(data: T?): Resource<T> {
            return if (data != null) Resource(status = Status.SUCCESS, data = data, message = null)
            else Resource(status = Status.ERROR, data = null, message = null)
        }
    }
}

enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}
