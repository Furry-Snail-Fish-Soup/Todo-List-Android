package `fun`.sast.todolist

import `fun`.sast.todolist.ui.theme.Shapes
import `fun`.sast.todolist.ui.theme.TodoListTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Drawer()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Drawer() {
    TodoListTheme {
        ModalNavigationDrawer(
            drawerContent = {
                Text(text = "标题", modifier = Modifier.align(Alignment.Start))
                NavigationDrawerItem(
                    label = { Text(text = "全部") },
                    selected = false,
                    onClick = { /*TODO*/ },
                    icon = { Icon(Icons.TwoTone.AllInclusive, "All") })
                NavigationDrawerItem(
                    label = { Text(text = "今日提醒") },
                    selected = false,
                    onClick = { /*TODO*/ },
                    icon = { Icon(Icons.TwoTone.CalendarToday, "All") })
                NavigationDrawerItem(
                    label = { Text(text = "全部提醒") },
                    selected = false,
                    onClick = { /*TODO*/ },
                    icon = { Icon(Icons.TwoTone.Alarm, "All") })
            },
            drawerShape = Shapes.large
        ) { MainUI() }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
private fun MainUI() {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar() },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(16.dp)
            ) { Icon(Icons.TwoTone.Add, "新建待办") }
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

@Composable
@Preview
private fun TopBar() {
    CenterAlignedTopAppBar(
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.TwoTone.Menu, "菜单")
            }
        },
        title = { Text("topBar") },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.TwoTone.Search, "搜索")
            }
        }
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
            icon = { Icon(Icons.TwoTone.Tag, "List") },
            label = { Text("标签") },
            onClick = { /*TODO*/ })
        NavigationBarItem(
            selected = false,
            icon = { Icon(Icons.TwoTone.History, "List") },
            label = { Text(text = "历史") },
            onClick = { /*TODO*/ })
    }
}
