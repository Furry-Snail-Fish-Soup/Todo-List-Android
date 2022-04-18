package `fun`.sast.nothingtodo.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.SET_NULL
import androidx.room.PrimaryKey
import kotlinx.datetime.LocalDateTime

@Entity(
    foreignKeys = [ForeignKey(
        entity = TodoCollection::class,
        parentColumns = ["Id"],
        childColumns = ["collectionId"],
        onDelete = SET_NULL
    )]
)

data class TodoItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var title: String,
    var content: String = "",
    var isCompleted: Boolean,
    var isAlarmEnabled: Boolean = false,
    var firstAlarmTime: LocalDateTime? = null,
    var alarmPeriod: AlarmPeriod = AlarmPeriod.Once,
    var collectionId: Int? = null,
    var isImportant: Boolean
) {
    enum class AlarmPeriod { Once, Day, Weekday, Week, Month, Year }
}
