package `fun`.sast.todolist.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TodoList(
    @PrimaryKey(autoGenerate = true)
    val listId: Int,
    val title: String,
    val color: ListColor
) {
    enum class ListColor {
        Red, Green, Blue, Yellow, Purple, Orange
    }
}
