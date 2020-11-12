package cmps312.lab.backgroundprocesses

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    lateinit var request: WorkRequest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //make sure that your
        val constraint : Constraints = Constraints.Builder()
            .setRequiresBatteryNotLow(true)
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        request = OneTimeWorkRequestBuilder<MyWorker>()
            .setConstraints(constraint).build()

//        request = PeriodicWorkRequestBuilder<MyWorker>(14, TimeUnit.SECONDS)
//            .setConstraints(constraint).build()

        doWorkBtn.setOnClickListener {
            WorkManager.getInstance(this).enqueue(request)
        }

        WorkManager.getInstance(this)
            .getWorkInfoByIdLiveData(request.id)
            .observe(this) {
                workStatusTv.append("${it.state.name}\n")
            }
    }
}