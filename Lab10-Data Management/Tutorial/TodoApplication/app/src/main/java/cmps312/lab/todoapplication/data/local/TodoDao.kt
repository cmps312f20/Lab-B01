package cmps312.lab.todoapplication.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import cmps312.lab.todoapplication.data.local.entity.Project

@Dao
interface TodoDao {
    @Query("SELECT * FROM Project")
    fun getProjects() : LiveData<List<Project>>

    @Insert
    suspend fun addProject(project: Project) : Long

    @Delete
    suspend fun deleteProject(project: Project)

    @Update
    suspend fun updateProject(project: Project)
}



//•	Update an existing todo
//•	Get all the todos for a specific project based on the project key

//•	Delete a specific todo.
