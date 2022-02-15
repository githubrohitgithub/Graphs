package com.example.scatteredgraph

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.ScatterChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet


class MainActivity : AppCompatActivity() {

    lateinit var barChart: BarChart
    lateinit var barData: BarData
    lateinit var barDataSet: BarDataSet
    lateinit var barEntries: ArrayList<BarEntry>





    private lateinit var scatterChart: ScatterChart
    private var scatterData: ScatterData? = null
    private lateinit var scatterEntries1: ArrayList<Entry>
    private lateinit var scatterEntries2: ArrayList<Entry>
    private lateinit var scatterEntries3: ArrayList<Entry>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        scatterChart = findViewById(R.id.scatterChart)
        barChart = findViewById(R.id.barChart)
        entries1
        entries2
        entries3
        val set1 = ScatterDataSet(scatterEntries1, "Data set 1")
        set1.setScatterShape(ScatterChart.ScatterShape.CIRCLE)
        set1.color = Color.BLUE
        set1.setDrawValues(false)
        val set2 = ScatterDataSet(scatterEntries2, "Data set 2")
        set2.setScatterShape(ScatterChart.ScatterShape.CIRCLE)
        set2.color = Color.GREEN
        set2.setDrawValues(false)
        val set3 = ScatterDataSet(scatterEntries3, "Data set 3")
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





        //BarChart
        getBarEntries()
        barDataSet = BarDataSet(barEntries, "")
        barDataSet.setDrawValues(false)
        barData = BarData(barDataSet)
        barChart.data = barData
        barDataSet.color = Color.BLUE
        barDataSet.valueTextColor = Color.BLACK
        barDataSet.valueTextSize = 18f

        val xAxisLabelsbar = arrayListOf("","Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")

        barChart.apply {

            this.xAxis.position = XAxis.XAxisPosition.BOTTOM
            this.xAxis.textSize = 12f
            this.axisRight.isEnabled = false
            this.axisLeft.setDrawGridLines(true)
            this.xAxis.setDrawGridLines(false)
            this.legend.isEnabled = false
            this.description.isEnabled = false
            this.xAxis.valueFormatter = IndexAxisValueFormatter(xAxisLabelsbar)

        }


    }


    private fun getBarEntries() {
        barEntries = ArrayList()
        barEntries.add(BarEntry(1F, 70F))
        barEntries.add(BarEntry(2F, 90F))
        barEntries.add(BarEntry(3F, 11F))
        barEntries.add(BarEntry(4F, 120F))
        barEntries.add(BarEntry(5F, 130F))
        barEntries.add(BarEntry(6F, 150F))
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