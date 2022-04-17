package `fun`.sast.todolist

import `fun`.sast.todolist.ui.theme.Shapes
import `fun`.sast.todolist.ui.theme.TodoListTheme
import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
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
                MainUI()
            }
        }
    }
}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//private fun Drawer() {
//    val state: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
//    val scope = rememberCoroutineScope()
//    ModalNavigationDrawer(
//        drawerState = state,
//        drawerContent = {
//            NavigationDrawerItem(
//                label = { Text(text = "全部") },
//                selected = false,
//                onClick = { /*TODO*/ },
//                icon = { Icon(Icons.TwoTone.AllInclusive, "All") })
//            NavigationDrawerItem(
//                label = { Text(text = "全部") },
//                selected = false,
//                onClick = { /*TODO*/ },
//                icon = { Icon(Icons.TwoTone.AllInclusive, "All") })
//            NavigationDrawerItem(
//                label = { Text(text = "今日提醒") },
//                selected = false,
//                onClick = { /*TODO*/ },
//                icon = { Icon(Icons.TwoTone.CalendarToday, "All") })
//            NavigationDrawerItem(
//                label = { Text(text = "全部提醒") },
//                selected = false,
//                onClick = { /*TODO*/ },
//                icon = { Icon(Icons.TwoTone.Alarm, "All") })
//        },
//        drawerShape = Shapes.large
//    ) {
//        MainUI(onMenuButtonClick = { scope.launch { state.open() } })
//    }
//}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
private fun MainUI(onMenuButtonClick: () -> Unit = {}) {
    Scaffold(
        topBar = { TopBar(onMenuButtonClick) },
        bottomBar = { BottomBar() },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                shape = RoundedCornerShape(16.dp)
            ) { Icon(Icons.TwoTone.Add, "新建待办") }
        }) {
        LazyColumn {
            items(listOf("摸鱼", "不做锅", "狂打游戏")) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 5.dp)
                ) {
                    var isImportant by rememberSaveable { mutableStateOf(false) }
                    var isCompleted by rememberSaveable { mutableStateOf(true) }
                    Row {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .weight(1f)
                                .padding(vertical = 2.dp)
                        ) {

                            Row(modifier = Modifier.padding(vertical = 5.dp)) {
                                Checkbox(
                                    checked = isCompleted,
                                    onCheckedChange = { isCompleted = !isCompleted })
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        it,
                                        modifier = Modifier.fillMaxHeight(),
                                        textDecoration = if (isCompleted) TextDecoration.LineThrough else null,
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
                                            textDecoration = if (isCompleted) TextDecoration.LineThrough else null
                                        )
                                    }
                                }
                                IconButton(onClick = { isImportant = !isImportant }) {
                                    Icon(
                                        imageVector = if (isImportant) Icons.Filled.PushPin else Icons.Outlined.PushPin,
                                        contentDescription = "Important"
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview
private fun TopBar(onMenuButtonClick: () -> Unit = {}) {
    CenterAlignedTopAppBar(
//        navigationIcon = {
//            IconButton(onClick = { onMenuButtonClick() }) {
//                Icon(Icons.TwoTone.Menu, "菜单")
//            }
//        },
        title = { Text("topBar") },
//        actions = {
//            IconButton(onClick = { /*TODO*/ }) {
//                Icon(Icons.TwoTone.Search, "搜索")
//            }
//        }
    )
}

@Composable
private fun BottomBar() {
    NavigationBar {
        NavigationBarItem(
            selected = true,
            icon = { Icon(Icons.TwoTone.List, "List") },
            label = { Text("列表") },
            onClick = { })
        NavigationBarItem(
            selected = false,
            icon = { Icon(Icons.TwoTone.Inbox, "Collection") },
            label = { Text("收集箱") },
            onClick = { /*TODO*/ })
        NavigationBarItem(
            selected = false,
            icon = { Icon(Icons.TwoTone.History, "History") },
            label = { Text(text = "历史") },
            onClick = { /*TODO*/ })
    }
}
