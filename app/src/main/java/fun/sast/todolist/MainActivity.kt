package `fun`.sast.todolist

import `fun`.sast.todolist.ui.MainUI
import `fun`.sast.todolist.ui.theme.TodoListTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoListTheme {
                Drawer()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Drawer() {
    val state: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = state,
        drawerContent = {
            Column(modifier = Modifier.padding(16.dp)) {
                Row {
                    Icon(Icons.TwoTone.FactCheck, null, Modifier.padding(16.dp))
                    Text(
                        text = "Nothing To Do",
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier
                            .padding(16.dp)
                    )
                }
                DrawerItem("全部", { /*TODO*/ }, { Icon(Icons.TwoTone.AllInclusive, "All") })
                DrawerItem("未完成", { /*TODO*/ }, { Icon(Icons.TwoTone.Unarchive, "Incomplete") })
                DrawerItem("已完成", { /*TODO*/ }, { Icon(Icons.TwoTone.Task, "Completed") })
                Divider(modifier = Modifier.padding(16.dp))
                // TODO LazyColumn
                LazyColumn {
                    items(listOf("工作", "要买的东西", "学习")) {
                        DrawerItem(it, { /*TODO*/ }, { Icon(Icons.TwoTone.CalendarToday, "All") })
                    }
                }

            }
        },
        drawerShape = MaterialTheme.shapes.large,

        ) {
        MainUI(onMenuButtonClick = { scope.launch { state.open() } })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DrawerItem(label: String, onClick: () -> Unit, icon: @Composable() (() -> Unit)) {
    NavigationDrawerItem(
        label = { Text(label) },
        selected = false,
        onClick = onClick,
        icon = icon,
        modifier = Modifier.padding(vertical = 4.dp)
    )
}
