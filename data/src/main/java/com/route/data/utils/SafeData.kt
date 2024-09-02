package com.route.data.utils

suspend fun <T> safeData(getData: suspend () -> T): T {
    try {
        val response = getData.invoke()
        return response
    } catch (e: Throwable) {
        throw e
    }
}