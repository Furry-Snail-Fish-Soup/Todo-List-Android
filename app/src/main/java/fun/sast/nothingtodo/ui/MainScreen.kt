@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package `fun`.sast.nothingtodo.ui

import `fun`.sast.nothingtodo.model.TodoItem
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun MainUI(onMenuButtonClick: () -> Unit = {}) {
    val items = remember {
        mutableListOf(
            TodoItem(
                1,
                "点击右下角新建待办",
                isCompleted = false,
                isImportant = false
            )
        )
    }
    Scaffold(
        topBar = { TopBar(onMenuButtonClick) },
//        bottomBar = { BottomBar() },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* TODO Navigate to Edit page */ },
                shape = RoundedCornerShape(16.dp)
            ) { Icon(Icons.TwoTone.Add, "新建待办") }
        }) {
        LazyColumn {
            items(
                // TODO hoist this to ViewModel
                items
            ) { todoItem ->
                TodoItemView(todoItem,
                    { todoItem.isCompleted = it },
                    { todoItem.isImportant = it })
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoItemView(
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
                        if (todoItem.isAlarmEnabled) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.TwoTone.Alarm,
                                    contentDescription = "alarm",
                                    modifier = Modifier.padding(2.dp)
                                )
                                Text(
                                    "${todoItem.firstAlarmTime}",
                                    textDecoration = if (todoItem.isCompleted) TextDecoration.LineThrough else null
                                )
                            }
                        } else {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.TwoTone.AlarmOff,
                                    contentDescription = "No Alarm",
                                    modifier = Modifier.padding(2.dp)
                                )
                                Text(
                                    "无提醒",
                                    textDecoration = if (todoItem.isCompleted) TextDecoration.LineThrough else null
                                )
                            }
                        }
                    }
                    IconButton(onClick = { setImportant(!todoItem.isImportant) }) {
                        Icon(
                            imageVector = if (todoItem.isImportant) Icons.Filled.PushPin else Icons.Outlined.PushPin,
                            contentDescription = "重要"
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun TopBar(onMenuButtonClick: () -> Unit = {}) {
    var isDelete by rememberSaveable { mutableStateOf(false) }
    CenterAlignedTopAppBar(
        navigationIcon = {
            IconButton(onClick = { onMenuButtonClick() }) {
                Icon(Icons.TwoTone.Menu, "菜单")
            }
        },
        title = { Text("全部待办") },
        actions = {
            IconButton(onClick = { isDelete = !isDelete }) {
                Icon(Icons.TwoTone.DeleteSweep, "删除")
            }
        }
    )
}

//@Composable
//fun BottomBar() {
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
//            onClick = {
//                TODO
//            })
//        NavigationBarItem(
//            selected = false,
//            icon = { Icon(Icons.TwoTone.History, "History") },
//            label = { Text(text = "历史") },
//            onClick = {
//                TODO
//            })
//    }
//}
