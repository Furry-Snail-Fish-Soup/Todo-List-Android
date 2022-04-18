package `fun`.sast.nothingtodo.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Tag(
    @PrimaryKey
    val id: Int,
    var title: String,
    var icon: TagIcon
) {
    enum class TagIcon {
        Home, Work, School, Shopping, Sport, Study, Travel, Other
    }
}
