package `fun`.sast.todolist.model

import androidx.room.Embedded
import androidx.room.Relation

data class ListWithItems(
    @Embedded val todoList: TodoList,
    @Relation(parentColumn = "id", entityColumn = "listId")
    val items: List<TodoItem>
)
