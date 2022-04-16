package `fun`.sast.todolist

import `fun`.sast.todolist.ui.theme.TodoListTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoListTheme {

                ModalNavigationDrawer(drawerContent = {
                    Surface {
                        Text(text = "drawerContent")
                    }
                }) {
                    Scaffold(topBar = {
                        Surface {
                            Text(text = "topBar")
                        }
                    }, bottomBar = {
                        Surface {
                            Text(text = "bottomBar")
                        }
                    }, snackbarHost = {
                        Surface {
                            Text(text = "snackbarHost")
                        }
                    }) {
                        Surface {
                            Text(text = "content")
                        }
                    }
                }
            }
        }
    }
}
