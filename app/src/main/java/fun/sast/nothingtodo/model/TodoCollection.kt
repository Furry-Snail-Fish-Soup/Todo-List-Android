package `fun`.sast.nothingtodo.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Home
import androidx.compose.material.icons.twotone.Luggage
import androidx.compose.material.icons.twotone.Person
import androidx.compose.material.icons.twotone.Work
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TodoCollection(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var title: String,
    var icon: Icon = Icon.Work
) {
    enum class Icon(val icon: ImageVector) {
        Work(Icons.TwoTone.Work),
        Person(Icons.TwoTone.Person),
        Home(Icons.TwoTone.Home),
        Travel(Icons.TwoTone.Luggage)
    }
}
