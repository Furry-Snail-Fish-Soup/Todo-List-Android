package `fun`.sast.todolist.dao

import `fun`.sast.todolist.model.TodoItem
import androidx.room.*

@Dao
interface TodoItemDao {

    /**
     * Get all TodoItem's. The list is sorted first by importance and then by the isCompleted status,
     * and then by the creation date.
     * @return all TodoItem's.
     */
    @Query("SELECT * FROM TodoItem ORDER BY isImportant DESC, isCompleted DESC, id DESC")
    suspend fun getAllItems(): List<TodoItem>

    /**
     * Insert a todoItem in the database. If the todoItem already exists, abort.
     * @param item the TodoItem to be inserted.
     * @return the rowId of the inserted todoItem.
     */
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertItem(item: TodoItem): Long

    /**
     * Delete a TodoItem from the database.
     * @param item the TodoItem to be deleted.
     * @return the number of deleted TodoItem's.
     */
    @Delete
    suspend fun deleteItem(item: TodoItem): Int

    /**
     * Update a TodoItem in the database.
     * @param item the TodoItem to be updated.
     * @return the number of updated TodoItem's.
     */
    @Update
    suspend fun updateItem(item: TodoItem): Int

}
