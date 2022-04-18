package `fun`.sast.nothingtodo.dao

import `fun`.sast.nothingtodo.model.TodoItem
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoItemDao {

    /**
     * Get all TodoItem's. The list is sorted first by isImportant status,
     * and then by the isCompleted status,
     * and then by the creation date.
     * @return all TodoItem's.
     */
    @Query(
        "SELECT * FROM TodoItem " +
                "ORDER BY isImportant DESC, isCompleted DESC, id DESC"
    )
    suspend fun getAll(): Flow<List<TodoItem>>

    /**
     * Get all TodoItem's in the specified TodoCollection.
     * The list is sorted first by isImportant status,
     * and then by the isCompleted status,
     * and then by the creation date.
     * @return all TodoItem's.
     */
    @Query(
        "SELECT * FROM TodoItem " +
                "WHERE collectionId = :collectionId " +
                "ORDER BY isImportant DESC, isCompleted DESC, id DESC"
    )
    suspend fun getCollection(collectionId: Int): Flow<List<TodoItem>>

    /**
     * Insert a todoItem in the database. If the todoItem already exists, abort.
     * @param item the TodoItem to be inserted.
     * @return the rowId of the inserted todoItem.
     */
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(item: TodoItem): Long

    /**
     * Delete a TodoItem from the database.
     * @param item the TodoItem to be deleted.
     * @return the number of deleted TodoItem's.
     */
    @Delete
    suspend fun delete(item: TodoItem): Int

    /**
     * Update a TodoItem in the database.
     * @param item the TodoItem to be updated.
     * @return the number of updated TodoItem's.
     */
    @Update
    suspend fun update(item: TodoItem): Int

}
