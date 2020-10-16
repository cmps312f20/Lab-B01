package cmps312.lab.qatar2022.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cmps312.lab.qatar2022.model.Stadium
import com.example.qatar2022.R
import kotlinx.android.synthetic.main.list_item_stadium.view.*

//5 Steps

//Step 2:
class StadiumAdapter(val stadiums : List<Stadium>, val context : Context)
    : RecyclerView.Adapter<StadiumAdapter.StadiumViewHolder>() {

    //STEP 1-> Create the view holder
    class StadiumViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bind(stadium : Stadium){
            itemView.apply {
                nameTv.text = stadium.name
                statusTv.text = stadium.status
                cityTv.text = stadium.city

                val imageName = stadium.imageName
                val imageID = context.resources.getIdentifier(imageName, "drawable",
                    context.packageName)
                stadiumIv.setImageResource(imageID)
            }
        }
    }

    //step 4
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StadiumViewHolder {
        val itemView = LayoutInflater.from(context)
            .inflate(R.layout.list_item_stadium, parent , false)
        return StadiumViewHolder(itemView)
    }

    //  step 5
    override fun onBindViewHolder(holder: StadiumViewHolder, position: Int) {
        holder.bind(stadiums[position])
    }

    //Step 3
    override fun getItemCount() = stadiums.size  //10 rows generated


}