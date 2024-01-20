package org.hotel.app

import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.ExperimentalResourceApi
import java.awt.Desktop
import java.awt.SystemTray
import java.awt.Toolkit
import java.awt.TrayIcon
import java.net.URI
import javax.swing.JOptionPane

internal actual fun openUrl(url: String?) {
    val uri = url?.let { URI.create(it) } ?: return
    Desktop.getDesktop().browse(uri)
}
@OptIn(ExperimentalResourceApi::class)
@Composable
internal actual fun NativeNotifier(message: String) {
    if (SystemTray.isSupported()) {
        val tray = SystemTray.getSystemTray()
        val image = Toolkit.getDefaultToolkit().createImage("logo.webp")
        val trayIcon = TrayIcon(image, "Desktop Notification")
        tray.add(trayIcon)
        trayIcon.displayMessage("Desktop Notification", message, TrayIcon.MessageType.INFO)
    } else {
        // Fallback for systems that don't support SystemTray
        JOptionPane.showMessageDialog(
            null,
            message,
            "Desktop Notification",
            JOptionPane.INFORMATION_MESSAGE
        )
    }
}