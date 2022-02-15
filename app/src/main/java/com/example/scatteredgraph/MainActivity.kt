package com.example.scatteredgraph

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.ScatterChart
import com.github.mikephil.charting.data.ScatterData
import com.github.mikephil.charting.data.ScatterDataSet
import android.os.Bundle
import com.example.scatteredgraph.R
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.utils.ColorTemplate
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var scatterChart: ScatterChart
    private var scatterData: ScatterData? = null
    private var scatterDataSet: ScatterDataSet? = null
    private lateinit var scatterEntries: ArrayList<Entry>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        scatterChart = findViewById(R.id.scatterChart)
        entries
        scatterDataSet = ScatterDataSet(scatterEntries, "")
        scatterData = ScatterData(scatterDataSet)
        scatterChart.data = scatterData
        scatterDataSet!!.setColors(*ColorTemplate.JOYFUL_COLORS)
        scatterDataSet!!.valueTextSize = 18f
        scatterDataSet!!.setScatterShape(ScatterChart.ScatterShape.CIRCLE)



        val xAxisLabels = arrayListOf("","","Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
        scatterChart.apply {
            this.xAxis.valueFormatter = IndexAxisValueFormatter(xAxisLabels)
            this.xAxis.position = XAxis.XAxisPosition.BOTTOM
            this.xAxis.textSize = 12f
            this.axisRight.isEnabled = false
            this.axisLeft.setDrawGridLines(false)
            this.xAxis.setDrawGridLines(false)
            this.legend.isEnabled = false

        }

    }

    private val entries: Unit
        get() {
            scatterEntries = ArrayList<Entry>()
            scatterEntries.add(BarEntry(2f, 0F))
            scatterEntries.add(BarEntry(4f, 1F))
            scatterEntries.add(BarEntry(6f, 1F))
            scatterEntries.add(BarEntry(8f, 3F))
            scatterEntries.add(BarEntry(7f, 4F))
            scatterEntries.add(BarEntry(3f, 3F))
            scatterEntries.add(BarEntry(3f, 3F))
            scatterEntries.add(BarEntry(3f, 3F))
        }
}