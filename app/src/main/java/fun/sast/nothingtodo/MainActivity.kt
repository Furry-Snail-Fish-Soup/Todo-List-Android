@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package `fun`.sast.nothingtodo

import `fun`.sast.nothingtodo.model.TodoCollection
import `fun`.sast.nothingtodo.ui.MainUI
import `fun`.sast.nothingtodo.ui.theme.TodoListTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.AllInclusive
import androidx.compose.material.icons.twotone.FactCheck
import androidx.compose.material.icons.twotone.Task
import androidx.compose.material.icons.twotone.Unarchive
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
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
                DrawerItem(
                    "全部",
                    onClick = { /*TODO*/ },
                    icon = Icons.TwoTone.AllInclusive
                )
                DrawerItem("未完成", onClick = { /*TODO*/ }, icon = Icons.TwoTone.Unarchive)
                DrawerItem("已完成", onClick = { /*TODO*/ }, icon = Icons.TwoTone.Task)
                Divider(modifier = Modifier.padding(16.dp))
                // TODO LazyColumn
                LazyColumn {
                    items(
                        listOf(/*"工作", "要买的东西", "学习"*/
                            TodoCollection(
                                id = 1,
                                title = "1",
                                icon = TodoCollection.Icon.Work
                            )
                        )
                    ) { collection ->
                        DrawerItem(collection.title, { /*TODO*/ }, collection.icon.icon)
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
private fun DrawerItem(label: String, onClick: () -> Unit, icon: ImageVector) {
    NavigationDrawerItem(
        label = { Text(label) },
        selected = false,
        onClick = onClick,
        icon = { Icon(icon, null) },
        modifier = Modifier.padding(vertical = 4.dp)
    )
}
