package org.hotel.app

import androidx.compose.runtime.Composable
import platform.Foundation.NSURL
import platform.UIKit.UIApplication

internal actual fun openUrl(url: String?) {
    val nsUrl = url?.let { NSURL.URLWithString(it) } ?: return
    UIApplication.sharedApplication.openURL(nsUrl)
}
@Composable
internal actual fun NativeNotifier(message: String) {
    val alertController = UIAlertController.alertControllerWithTitle(
        title = UIDevice.currentDevice.systemName,
        message = message,
        preferredStyle = UIAlertControllerStyleUIAlertControllerStyleAlert
    )
    alertController.addAction(
        UIAlertAction.actionWithTitle(
            "OK",
            style = UIAlertActionStyleUIAlertActionStyleDefault,
            handler = null
        )
    )
    viewController.presentViewController(alertController, animated = true, completion = null)
}