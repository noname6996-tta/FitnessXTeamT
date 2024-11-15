import androidx.compose.ui.window.ComposeUIViewController
import com.mobile.fitness_x.App
import di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    App()
}