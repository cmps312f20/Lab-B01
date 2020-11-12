package cmps312.lab.backgroundprocesses

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.work.CoroutineWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

class MyWorker(appContext: Context, params: WorkerParameters) :
    CoroutineWorker(appContext, params) {

    override suspend fun doWork(): Result = coroutineScope {
        val jobs = (0..10).map { async { delay(1000) } }
        jobs.awaitAll()

        showNotification("Task completed running ")
        Result.success()
    }

    private fun showNotification(content : String){
        val manager : NotificationManager =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val channel = NotificationChannel("1001", "Retweets and Likes" ,
                NotificationManager.IMPORTANCE_DEFAULT)
            val notification = NotificationCompat
                .Builder(applicationContext,"1001")
                .setContentText("Abdulahi")
                .setContentText(content)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setAutoCancel(true)

            manager.createNotificationChannel(channel)
            manager.notify(1, notification.build())

        }
    }
}