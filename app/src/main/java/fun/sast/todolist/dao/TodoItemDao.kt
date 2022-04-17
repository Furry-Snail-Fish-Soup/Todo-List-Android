package `fun`.sast.todolist.dao

import `fun`.sast.todolist.model.TodoItem
import androidx.room.*

@Dao
interface TodoItemDao {

    /**
     * Get all TodoItem's.
     * @return all TodoItem's.
     */
    @Query("SELECT * FROM TodoItem ORDER BY isImportant DESC, isCompleted DESC, id DESC")
    fun getAllItems(): List<TodoItem>

    /**
     * Insert a todoItem in the database. If the todoItem already exists, abort.
     * @param item the TodoItem to be inserted.
     * @return the rowId of the inserted todoItem.
     */
    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertItem(item: TodoItem): Long

    /**
     * Delete a TodoItem from the database.
     * @param item the TodoItem to be deleted.
     * @return the number of deleted TodoItem's.
     */
    @Delete
    fun deleteItem(item: TodoItem): Int

    /**
     * Update a TodoItem in the database.
     * @param item the TodoItem to be updated.
     * @return the number of updated TodoItem's.
     */
    @Update
    fun updateItem(item: TodoItem): Int

}
