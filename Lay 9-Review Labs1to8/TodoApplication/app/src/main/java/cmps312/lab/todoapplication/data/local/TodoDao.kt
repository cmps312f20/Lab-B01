package cmps312.lab.todoapplication.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import cmps312.lab.todoapplication.model.Todo

@Dao
interface TodoDao {
    @Query("SELECT * FROM todo_table")
    fun getTodos(): LiveData<Todo>

    @Query("SELECT * FROM todo_table WHERE id = :id")
    fun getTodo(id: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addTodo(todo: Todo)

    @Delete
    fun deleteTodo(todo: Todo)
}