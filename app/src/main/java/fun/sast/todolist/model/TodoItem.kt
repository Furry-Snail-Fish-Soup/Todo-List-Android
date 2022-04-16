package `fun`.sast.todolist.model

import kotlinx.datetime.LocalDateTime

data class TodoItem(
    val id: Int, val title: String, val content: String,
    val isCompleted: Boolean, val idBell: Boolean, val bellTime: LocalDateTime,
    val period: Period, val tableId: Int, val IsImportant: Boolean
) {
    enum class Period { No, Day, Weekday, Week, Month, Year }
}
