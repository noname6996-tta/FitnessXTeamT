package loggger

object LoggerProvider {
    val logger: Logger by lazy { getLogger() }
}