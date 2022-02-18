package com.example.graphs

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.graphs.databinding.ActivitySystolicDiatolicBinding
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter


class SystolicDiatolic : AppCompatActivity() {

    private lateinit var binding: ActivitySystolicDiatolicBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySystolicDiatolicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataset1 = LineDataSet(initDataSet(), "Data set 1")
        dataset1.apply {
            this.color = Color.BLUE
            this.setDrawValues(false)
            this.setColors(Color.BLUE)
            this.valueTextColor = Color.BLACK
            this.valueTextSize = 18f
            this.mode = LineDataSet.Mode.CUBIC_BEZIER
            this.setCircleColor(Color.BLACK)
        }


        val xAxisLabels = arrayListOf("0","100ms", "200ms", "300ms", "400ms", "500ms", "600ms", "700ms","800ms","900ms","1000ms")
        binding.lineChart.apply {
            this.axisRight.isEnabled = false
            this.xAxis.valueFormatter = IndexAxisValueFormatter(xAxisLabels)
            this.xAxis.position = XAxis.XAxisPosition.BOTTOM
            this.data = LineData(dataset1)
            this.description.text = "Systolic and Diatolic"
            this.description.isEnabled = true
        }

    }

    private fun initDataSet():ArrayList<Entry> {

        val dataSetEntries by lazy { ArrayList<Entry>() }
        dataSetEntries.add(Entry(1f, 50f))
        dataSetEntries.add(Entry(2f, 70f))
        dataSetEntries.add(Entry(3f, 30f))
        dataSetEntries.add(Entry(4f, 90f))
        dataSetEntries.add(Entry(5f, 80f))
        dataSetEntries.add(Entry(6f, 110f))
        dataSetEntries.add(Entry(7f, 120f))
        dataSetEntries.add(Entry(8f, 120f))
        dataSetEntries.add(Entry(9f, 120f))
        dataSetEntries.add(Entry(10f, 120f))
        return dataSetEntries
    }

}