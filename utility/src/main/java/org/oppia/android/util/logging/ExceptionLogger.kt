package org.oppia.android.util.logging

import java.lang.Exception

/**
 * Logger for tracking caught exceptions.
 * Note that this utility may later upload the exceptions to remote services
 * or log the exception to a file on disk.
 */
interface ExceptionLogger {

  /**
   * Logs exceptions to remote services or log them to a file on disk.
   *
   * @param exception: non-fatal exception to be logged
   */
  fun logException(exception: Exception)

  /**
   * Sets a custom key-value pair that will be attached to crash reports.
   *
   * Custom keys provide additional context about the app's state at the time of a crash,
   * such as the current screen, profile ID, or other relevant metadata.
   *
   * @param key the key identifier for the custom data
   * @param value the value associated with the key
   */
  fun setCustomKey(key: String, value: String) {
    // Default no-op implementation for backward compatibility.
  }

  /**
   * Logs a breadcrumb message that will be attached to crash reports.
   *
   * Breadcrumb messages help reconstruct the sequence of user actions leading up to a crash.
   * These messages are stored in a circular buffer and included in crash reports.
   *
   * @param message the breadcrumb message to log
   */
  fun log(message: String) {
    // Default no-op implementation for backward compatibility.
  }
}
