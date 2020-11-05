package cmps312.lab.todoapplication.repository

import android.util.Log
import cmps312.lab.todoapplication.model.Project
import cmps312.lab.todoapplication.model.Todo
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

object TodoListRepo {
    val TAG = "TodoListRepo"
    val db by lazy { FirebaseFirestore.getInstance() }
    val projectsDocumentRef by lazy { db.collection("projects") }

    suspend fun getProjects() = projectsDocumentRef.get().await().toObjects(Project::class.java)
    fun addProject(project: Project) = projectsDocumentRef.add(project)
        .addOnSuccessListener { Log.d(TAG, "Successfully added new project") }
        .addOnFailureListener{Log.d(TAG, "Was not able to add the new project")}
    fun deleteProject(project: Project) = projectsDocumentRef.document(project.projectId).delete()

    suspend fun getTodoListByProject(pid: String) = null
    suspend fun addTodo(todo: Todo) = null
    suspend fun getTodo(id: String) =null
    suspend fun deleteTodo(todo: Todo) = null
    suspend fun updateToDo(todo: Todo) = null
}
