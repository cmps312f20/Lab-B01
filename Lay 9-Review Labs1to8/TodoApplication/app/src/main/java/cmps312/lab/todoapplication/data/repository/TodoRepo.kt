package cmps312.lab.todoapplication.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import cmps312.lab.todoapplication.data.local.TodoDatabase
import cmps312.lab.todoapplication.model.Todo

class TodoRepo(private val context: Context) {

    private val todoDao by lazy {
        TodoDatabase.getDatabase(context).todoDao()
    }

    fun getTodos(): LiveData<Todo> = todoDao.getTodos()
    fun getTodo(id: Int) = todoDao.getTodo(id)
    fun addTodo(todo: Todo) =todoDao.addTodo(todo)
    fun deleteTodo(todo: Todo)  = todoDao.deleteTodo(todo)

}