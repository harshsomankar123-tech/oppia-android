package org.oppia.android.util.logging.firebase

import com.google.firebase.crashlytics.FirebaseCrashlytics
import org.oppia.android.util.logging.ExceptionLogger

/** Logger for providing custom crash reporting to Firebase Crashlytics. */
class FirebaseExceptionLogger(
  private var firebaseCrashlytics: FirebaseCrashlytics
) : ExceptionLogger {

  /** Logs a custom non-fatal exception to Firebase Crashlytics. */
  override fun logException(exception: Exception) {
    firebaseCrashlytics.log("Exception: ${exception.message}")
    firebaseCrashlytics.recordException(exception)
  }

  /**
   * Sets a custom key-value pair on the Crashlytics crash report.
   *
   * These keys appear in the Firebase Crashlytics dashboard and help provide context
   * about the app's state at the time of a crash.
   */
  override fun setCustomKey(key: String, value: String) {
    firebaseCrashlytics.setCustomKey(key, value)
  }

  /**
   * Logs a breadcrumb message to Firebase Crashlytics.
   *
   * These messages appear in the Crashlytics dashboard under the "Logs" tab and help
   * reconstruct the sequence of events leading up to a crash.
   */
  override fun log(message: String) {
    firebaseCrashlytics.log(message)
  }
}
