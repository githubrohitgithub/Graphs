package com.example.scatteredgraph

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.ScatterChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.ScatterData
import com.github.mikephil.charting.data.ScatterDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet
import com.github.mikephil.charting.utils.ColorTemplate


class MainActivity : AppCompatActivity() {

    private lateinit var scatterChart: ScatterChart
    private var scatterData: ScatterData? = null
    private lateinit var scatterEntries1: ArrayList<Entry>
    private lateinit var scatterEntries2: ArrayList<Entry>
    private lateinit var scatterEntries3: ArrayList<Entry>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        scatterChart = findViewById(R.id.scatterChart)
        entries1
        entries2
        entries3

        val set1 = ScatterDataSet(scatterEntries1, "Point 1")
        set1.setScatterShape(ScatterChart.ScatterShape.CIRCLE)
        set1.color = Color.BLUE
        set1.setDrawValues(false)

        val set2 = ScatterDataSet(scatterEntries2, "Point 2")
        set2.setScatterShape(ScatterChart.ScatterShape.CIRCLE)
        set2.color = Color.GREEN
        set2.setDrawValues(false)

        val set3 = ScatterDataSet(scatterEntries3, "Point 3")
        set3.setScatterShape(ScatterChart.ScatterShape.CIRCLE)
        set3.color = Color.RED
        set3.setDrawValues(false)

        set1.scatterShapeSize = 15f
        set2.scatterShapeSize = 15f
        set3.scatterShapeSize = 15f

        val dataSets: ArrayList<IScatterDataSet> = ArrayList()

        dataSets.add(set1)
        dataSets.add(set2)
        dataSets.add(set3)

        scatterData = ScatterData(dataSets)
        scatterChart.data = scatterData
        scatterChart.invalidate()

        val xAxisLabels = arrayListOf("","Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
        scatterChart.apply {
            this.xAxis.valueFormatter = IndexAxisValueFormatter(xAxisLabels)
            this.xAxis.position = XAxis.XAxisPosition.BOTTOM
            this.xAxis.textSize = 12f
            this.axisRight.isEnabled = false
            this.axisLeft.setDrawGridLines(true)
            this.xAxis.setDrawGridLines(false)
            this.legend.isEnabled = false
            this.description.isEnabled = false

        }

    }

    private val entries1: Unit
        get() {
            scatterEntries1 = ArrayList()
            scatterEntries1.add(BarEntry(1f, 10F))
            scatterEntries1.add(BarEntry(2f, 10F))
            scatterEntries1.add(BarEntry(3f, 10F))
            scatterEntries1.add(BarEntry(4f, 10F))
            scatterEntries1.add(BarEntry(5f, 10F))
            scatterEntries1.add(BarEntry(6f, 10F))
            scatterEntries1.add(BarEntry(7f, 10F))

        }

    private val entries2: Unit
        get() {
            scatterEntries2 = ArrayList()
            scatterEntries2.add(BarEntry(1f, 120F))
            scatterEntries2.add(BarEntry(2f, 114F))
            scatterEntries2.add(BarEntry(3f, 118F))
            scatterEntries2.add(BarEntry(4f, 120F))
            scatterEntries2.add(BarEntry(5f, 160F))
            scatterEntries2.add(BarEntry(6f, 175F))
            scatterEntries2.add(BarEntry(7f, 123F))

        }

    private val entries3: Unit
        get() {
            scatterEntries3 = ArrayList()
            scatterEntries3.add(BarEntry(1f, 200F))
            scatterEntries3.add(BarEntry(2f, 210F))
            scatterEntries3.add(BarEntry(3f, 210F))
            scatterEntries3.add(BarEntry(4f, 230F))
            scatterEntries3.add(BarEntry(5f, 240F))
            scatterEntries3.add(BarEntry(6f, 10F))
            scatterEntries3.add(BarEntry(7f, 10F))

        }
}