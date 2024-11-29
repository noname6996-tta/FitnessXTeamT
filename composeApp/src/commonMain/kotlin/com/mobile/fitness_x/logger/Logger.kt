package com.mobile.fitness_x.logger

interface Logger {
    fun d(tag: String, message: String)
    fun e(tag: String, message: String, throwable: Throwable? = null)
    fun i(tag: String, message: String)
    fun w(tag: String, message: String)
    fun v(tag: String, message: String)
}

// Hàm tiện ích để sử dụng dễ dàng
expect fun getLogger(): Logger
