package `fun`.sast.todolist

import `fun`.sast.todolist.ui.theme.Shapes
import `fun`.sast.todolist.ui.theme.TodoListTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainUI()
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun MainUI() {
        TodoListTheme {
            ModalNavigationDrawer(drawerContent = {
                Surface(color = Color.Red, modifier = Modifier.fillMaxWidth()) {
                    Text(text = "drawerContent")
                }
            }, drawerShape = Shapes.large) {
                Scaffold(topBar = {
                    CenterAlignedTopAppBar(
                        navigationIcon = { Icon(Icons.TwoTone.Menu, "菜单") },
                        title = { Text("topBar") },
                        actions = { Icon(Icons.TwoTone.Search, "搜索") },
                        modifier = Modifier
                    )
                }, bottomBar = {
                    BottomBar()
                }, floatingActionButton = {
                    FloatingActionButton(
                        shape = androidx.compose.material3.Shapes.Full,
                        onClick = { /*TODO*/ }
                    ) {
                        Icon(Icons.TwoTone.Add, "新建待办")
                    }
                }) {
                    Surface(modifier = Modifier.fillMaxSize()) {
                        LazyColumn {
                            items(listOf(0, 1, 2)) {
                                Text("$it")
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun BottomBar() {
        NavigationBar {
            NavigationBarItem(
                selected = true,
                icon = { Icon(Icons.TwoTone.List, "List") },
                label = { Text(text = "总览") },
                onClick = { /*TODO*/ })
            NavigationBarItem(
                selected = false,
                icon = { Icon(Icons.TwoTone.Tag, "List") },
                label = {
                    Text(
                        text = "标签"
                    )
                },
                onClick = { /*TODO*/ })
            NavigationBarItem(
                selected = false,
                icon = { Icon(Icons.TwoTone.History, "List") },
                label = { Text(text = "历史") },
                onClick = { /*TODO*/ })
        }
    }
}
