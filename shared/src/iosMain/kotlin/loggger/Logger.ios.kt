package loggger

import platform.Foundation.NSLog

class IOSLogger : Logger {
    override fun d(tag: String, message: String) {
        NSLog("DEBUG: $tag - $message")
    }

    override fun e(tag: String, message: String, throwable: Throwable?) {
        NSLog("ERROR: $tag - $message")
        throwable?.message?.let { NSLog("Throwable: $it") }
    }

    override fun i(tag: String, message: String) {
        NSLog("INFO: $tag - $message")
    }

    override fun w(tag: String, message: String) {
        NSLog("WARN: $tag - $message")
    }

    override fun v(tag: String, message: String) {
        NSLog("VERBOSE: $tag - $message")
    }
}

actual fun getLogger(): Logger = IOSLogger()