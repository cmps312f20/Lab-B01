package cmps312.lab.qatar2022

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cmps312.lab.qatar2022.model.StadiumRepository
import com.example.qatar2022.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item_stadium.*

class MainActivity : AppCompatActivity() {

    var currentIndex = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        StadiumRepository.initStadiums(this)
        displayStadium()

    }

    fun displayStadium() {
        StadiumRepository.apply {
            currentIndex = (currentIndex + stadiums.size) % stadiums.size

            nameTv.text = stadiums[currentIndex].name
            statusTv.text = stadiums[currentIndex].status
            cityTv.text = stadiums[currentIndex].city

            val imageName = stadiums[currentIndex].imageName
            val imageID = resources.getIdentifier(imageName, "drawable", packageName)
            stadiumIv.setImageResource(imageID)

            currentIndexTv.text = "${currentIndex + 1} of ${stadiums.size}"
        }

    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.prevBtn -> currentIndex--
            R.id.nextBtn -> currentIndex++
        }
        displayStadium()
    }

}