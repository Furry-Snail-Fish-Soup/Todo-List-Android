package `fun`.sast.todolist.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.LocalDateTime

@Entity
data class TodoItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var title: String,
    var content: String,
    var isCompleted: Boolean,
    var isAlarmEnabled: Boolean,
    var firstAlarmTime: LocalDateTime?,
    var alarmPeriod: AlarmPeriod,
    var collectionId: Int,
    var isImportant: Boolean
) {
    enum class AlarmPeriod { Once, Day, Weekday, Week, Month, Year }
}
