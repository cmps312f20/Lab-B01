package cmps312.lab.todoapplication.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import cmps312.lab.todoapplication.data.local.entity.Project
import cmps312.lab.todoapplication.data.local.entity.Todo

@Dao
interface TodoListDao {
    @Query("SELECT * FROM Project")
    fun getProjects() : LiveData<List<Project>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProject(project: Project) : Long

    @Delete
    suspend fun deleteProject(project: Project)

    @Update
    suspend fun updateProject(project: Project)

    @Query("SELECT * FROM Todo WHERE pid=:pid")
    fun getTodosByProject(pid : Int) : LiveData<List<Todo>>

    @Query("SELECT * FROM Todo WHERE id=:id")
    fun getTodo(id: Int): Todo

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTodo(todo: Todo) : Long

    @Update
    suspend fun updateTodo(todo: Todo)

    @Delete
    suspend fun deleteTodo(todo: Todo)

}



//•	Update an existing todo
//•	Get all the todos for a specific project based on the project key

//•	Delete a specific todo.
