package `fun`.sast.todolist

import `fun`.sast.todolist.model.TodoItem
import `fun`.sast.todolist.ui.theme.TodoListTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PushPin
import androidx.compose.material.icons.outlined.PushPin
import androidx.compose.material.icons.twotone.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
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
                Text(
                    text = ": ) Circle ToDo",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier
                        .padding(16.dp)
                        .padding(bottom = 20.dp)
                )
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
private fun MainUI(onMenuButtonClick: () -> Unit = {}) {
    Scaffold(
        topBar = { TopBar(onMenuButtonClick) },
//        bottomBar = { BottomBar() },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                shape = RoundedCornerShape(16.dp)
            ) { Icon(Icons.TwoTone.Add, "新建待办") }
        }) {
        LazyColumn {
            items(
                listOf(
                    TodoItem(
                        1,
                        "",
                        "",
                        false,
                        false,
                        null,
                        TodoItem.AlarmPeriod.Once,
                        1,
                        false
                    )
                )
            ) { todoItem ->
                TodoItemView(todoItem,
                    {/*todoItem.isCompleted=it*/ },
                    {/*todoItem.isImportant=it*/ })
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TodoItemView(
    todoItem: TodoItem,
    setCompleted: (Boolean) -> Unit,
    setImportant: (Boolean) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 5.dp)
    ) {
        Row {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 2.dp)
            ) {

                Row(modifier = Modifier.padding(vertical = 5.dp)) {
                    Checkbox(
                        checked = todoItem.isCompleted,
                        onCheckedChange = setCompleted
                    )
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            todoItem.title,
                            modifier = Modifier.fillMaxHeight(),
                            textDecoration = if (todoItem.isCompleted) TextDecoration.LineThrough else null,
                            fontSize = MaterialTheme.typography.titleLarge.fontSize
                        )
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.TwoTone.Alarm,
                                contentDescription = "alarm",
                                modifier = Modifier.padding(2.dp)
                            )
                            Text(
                                "今天 14:01",
                                textDecoration = if (todoItem.isCompleted) TextDecoration.LineThrough else null
                            )
                        }
                    }
                    IconButton(onClick = { setImportant(!todoItem.isImportant) }) {
                        Icon(
                            imageVector = if (todoItem.isImportant) Icons.Filled.PushPin else Icons.Outlined.PushPin,
                            contentDescription = "Important"
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview
private fun TopBar(onMenuButtonClick: () -> Unit = {}) {
    var isDelete by rememberSaveable { mutableStateOf(false) }
    CenterAlignedTopAppBar(
        navigationIcon = {
            IconButton(onClick = { onMenuButtonClick() }) {
                Icon(Icons.TwoTone.Menu, "菜单")
            }
        },
        title = { Text("topBar") },
        actions = {
            IconButton(onClick = { isDelete = !isDelete }) {
                Icon(Icons.TwoTone.DeleteSweep, "删除")
            }
        }
    )
}

//@Composable
//private fun BottomBar() {
//    NavigationBar {
//        NavigationBarItem(
//            selected = true,
//            icon = { Icon(Icons.TwoTone.List, "List") },
//            label = { Text("列表") },
//            onClick = { })
//        NavigationBarItem(
//            selected = false,
//            icon = { Icon(Icons.TwoTone.Inbox, "Collection") },
//            label = { Text("收集箱") },
//            onClick = { /*TODO*/ })
//        NavigationBarItem(
//            selected = false,
//            icon = { Icon(Icons.TwoTone.History, "History") },
//            label = { Text(text = "历史") },
//            onClick = { /*TODO*/ })
//    }
//}
