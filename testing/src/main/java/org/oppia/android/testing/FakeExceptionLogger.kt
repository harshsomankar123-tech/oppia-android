package org.oppia.android.testing

import org.oppia.android.util.logging.ExceptionLogger
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.Exception

/** A test specific fake for the exception logger. */
@Singleton
class FakeExceptionLogger @Inject constructor() : ExceptionLogger {
  private val exceptionList = mutableListOf<Exception>()
  private val customKeys = mutableMapOf<String, String>()
  private val logMessages = mutableListOf<String>()

  override fun logException(exception: Exception) {
    exceptionList.add(exception)
  }

  override fun setCustomKey(key: String, value: String) {
    customKeys[key] = value
  }

  override fun log(message: String) {
    logMessages.add(message)
  }

  /** Returns the most recently logged exception. */
  fun getMostRecentException(): Exception = exceptionList.last()

  /** Clears all the exceptions that are currently logged. */
  fun clearAllExceptions() = exceptionList.clear()

  /** Checks if a certain exception has been logged or not. */
  fun hasExceptionLogged(exception: Exception): Boolean = exceptionList.contains(exception)

  /** Returns true if there are no exceptions logged. */
  fun noExceptionsPresent(): Boolean = exceptionList.isEmpty()

  /** Returns the value of a custom key that was set, or null if not set. */
  fun getCustomKey(key: String): String? = customKeys[key]

  /** Returns all custom keys that have been set. */
  fun getAllCustomKeys(): Map<String, String> = customKeys.toMap()

  /** Returns all log messages that have been recorded. */
  fun getLogMessages(): List<String> = logMessages.toList()

  /** Returns the most recently logged breadcrumb message. */
  fun getMostRecentLogMessage(): String = logMessages.last()

  /** Returns true if there are no log messages recorded. */
  fun noLogMessagesPresent(): Boolean = logMessages.isEmpty()

  /** Clears all custom keys and log messages. */
  fun clearAll() {
    exceptionList.clear()
    customKeys.clear()
    logMessages.clear()
  }
}
