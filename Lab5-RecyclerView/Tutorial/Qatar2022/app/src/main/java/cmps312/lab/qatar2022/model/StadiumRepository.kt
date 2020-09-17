package cmps312.lab.qatar2022.model
import android.content.Context
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

object StadiumRepository {
    var stadiums = listOf<Stadium>()

    fun initStadiums(context: Context){
        var data = context.assets.open("stadiums.json")
            .bufferedReader().use { it.readText() }
        stadiums = Json{ignoreUnknownKeys = true}.decodeFromString(data)
    }
}


