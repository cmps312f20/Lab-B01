package cmps312.lab.todoapplication.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cmps312.lab.todoapplication.model.Todo

@Database(entities = [Todo::class], version = 1, exportSchema = false)
abstract class TodoDatabase : RoomDatabase() {

    //inject the dao that you created
    abstract fun todoDao(): TodoDao

    //companion object to create the database or get the instance of the database

    companion object {
        @Volatile // [we dont want it to be cached..always the users should get the updated instance]
        private var database: TodoDatabase? = null

        /*protected from concurrent execution by multiple threads by the monitor of the instance*/
        @Synchronized
        fun getDatabase(context: Context): TodoDatabase {
            if (database == null) {
                database = Room.databaseBuilder(
                    context.applicationContext,
                    TodoDatabase::class.java,
                    "todo_db"
                ).build()
            }
            return database as TodoDatabase
        }
    }
}