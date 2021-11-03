package com.example.notificationsapp

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {
    lateinit var btn :Button
    lateinit var ed :EditText
    private val channelId = "myapp.notifications"
    private var description = "Notification App Example"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        btn=findViewById(R.id.btn)
        ed=findViewById(R.id.ed)

        btn.setOnClickListener {

            var notification = ed.text.toString()

            var notificationChannel = NotificationChannel(channelId,description,NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChannel)

            var builder = Notification.Builder(this, channelId)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle("Notification")
                .setContentText(notification)

                notificationManager.notify(1234, builder.build())

            ed.text.clearSpans()
            ed.clearFocus()

        }


    }
}