package com.example.livpol

import android.app.Notification
import android.app.NotificationManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedDispatcher
import com.example.livpol.databinding.ActivityDataBinding
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry

@Suppress("DEPRECATION")
class DataActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDataBinding

//    private lateinit var goBack: ImageView
//    private lateinit var people: TextView
//    private lateinit var minutes: TextView
    private lateinit var notificationManager: NotificationManager
//    private lateinit var notificationChannel: NotificationChannel
//    private lateinit var circles: ImageView
    private lateinit var context: Context
    private var notified = false
    lateinit var builder: Notification.Builder
    private val channelId = "i.apps.notifications"
    private val description = "Test notification"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.backBtn.setOnClickListener {
            onBackPressed()
        }

        createBarChart()

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    }

    private fun createBarChart() {

        val entries = ArrayList<BarEntry>()
        entries.add(BarEntry(0f,10f))
        entries.add(BarEntry(1f,30f))
        entries.add(BarEntry(2f,60f))
        entries.add(BarEntry(3f,100f))
        entries.add(BarEntry(5f,70f))
        entries.add(BarEntry(10f,80f))

        val barDataSet = BarDataSet(entries,"BarDataSet")

        val dataSet = BarData(barDataSet)

        dataSet.barWidth = 0.9f

        binding.barchart.data = dataSet
        binding.barchart.setFitBars(true)
        binding.barchart.invalidate()
    }


}