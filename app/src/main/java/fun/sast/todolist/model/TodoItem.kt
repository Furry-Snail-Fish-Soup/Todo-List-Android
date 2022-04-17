package `fun`.sast.todolist.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.LocalDateTime

@Entity
data class TodoItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val content: String,
    val isCompleted: Boolean,
    val isAlarmEnabled: Boolean,
    val firstAlarmTime: LocalDateTime?,
    val alarmPeriod: AlarmPeriod,
    val listId: Int,
    val isImportant: Boolean
) {
    enum class AlarmPeriod { Once, Day, Weekday, Week, Month, Year }
}
