package cmps312.lab.todoapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_table")
data class Todo(
    val title: String? = null,
    val status: String? = null,
    val priority: String? = null,
    val date: String? = null,
    val time: String? = null,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)