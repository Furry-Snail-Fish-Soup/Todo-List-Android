package `fun`.sast.todolist.model

import androidx.room.Entity

@Entity(primaryKeys = ["listId", "tagId"])
data class ItemTag(
    val itemId: Int,
    val tagId: Int
)

//@Embedded val playlist: Playlist,
//    @Relation(
//         parentColumn = "playlistId",
//         entityColumn = "songId",
//         associateBy = Junction(PlaylistSongCrossRef::class)
//    )
//    val songs: List<Song>
