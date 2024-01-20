import androidx.compose.ui.window.ComposeUIViewController
import org.hotel.app.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
