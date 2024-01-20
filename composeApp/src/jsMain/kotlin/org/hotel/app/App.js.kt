package org.hotel.app

import androidx.compose.runtime.Composable
import kotlinx.browser.window

internal actual fun openUrl(url: String?) {
    url?.let { window.open(it) }
}
@Composable
internal actual fun NativeNotifier(message: String) {
    window.alert(message)
}