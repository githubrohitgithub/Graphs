package com.example.scatteredgraph

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.scatteredgraph.databinding.ActivityMainBinding
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.ScatterChart
import com.github.mikephil.charting.components.LimitLine
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var barData: BarData
    lateinit var barDataSet: BarDataSet
    lateinit var barEntries: ArrayList<BarEntry>
    private var scatterEntries1: ArrayList<Entry>?=null
    private var scatterEntries2: ArrayList<Entry>?=null
    private var scatterEntries3: ArrayList<Entry>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.candle.setOnClickListener {
            startActivity(Intent(applicationContext,MainActivity2::class.java))
        }

        entries1
        entries2
        entries3

        val set1 = ScatterDataSet(scatterEntries1, "Data set 1")
        set1.apply {
            this.setScatterShape(ScatterChart.ScatterShape.CIRCLE)
            this.color = Color.BLUE
            this.setDrawValues(false)
            this.scatterShapeSize = 15f
        }

        val set2 = ScatterDataSet(scatterEntries2, "Data set 2")
        set2.apply {
            this.setScatterShape(ScatterChart.ScatterShape.CIRCLE)
            this.color = Color.GREEN
            this.setDrawValues(false)
            this.scatterShapeSize = 15f
        }


        val set3 = ScatterDataSet(scatterEntries3, "Data set 3")
        set3.apply {
            this.setScatterShape(ScatterChart.ScatterShape.CIRCLE)
            this.color = Color.RED
            this.setDrawValues(false)
            this.scatterShapeSize = 15f
        }


        val dataSets: ArrayList<IScatterDataSet> = ArrayList()
        dataSets.add(set1)
        dataSets.add(set2)
        dataSets.add(set3)


        binding.scatterChart.data = ScatterData(dataSets)
        binding.scatterChart.invalidate()

        val xAxisLabels = arrayListOf("","Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
        binding.scatterChart.apply {
            this.xAxis.valueFormatter = IndexAxisValueFormatter(xAxisLabels)
            this.xAxis.position = XAxis.XAxisPosition.BOTTOM
            this.xAxis.textSize = 12f
            this.axisRight.isEnabled = false
            this.axisLeft.setDrawGridLines(true)
            this.xAxis.setDrawGridLines(false)
            this.legend.isEnabled = false
            this.description.isEnabled = false
            val limitLine = LimitLine(y)
            this.axisLeft.addLimitLine(limitLine)

        }


      barchatInit()

    }

    private fun barchatInit() {
        getBarEntries()
        barDataSet = BarDataSet(barEntries, "")
        barDataSet.setDrawValues(false)
        barData = BarData(barDataSet)
        binding.barChart.data = barData
        barDataSet.color = Color.BLUE
        barDataSet.valueTextColor = Color.BLACK
        barDataSet.valueTextSize = 18f

        val xAxisLabelsbar = arrayListOf("","Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
        binding.barChart.apply {
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
            scatterEntries1?.add(BarEntry(1f, 10F))
            scatterEntries1?.add(BarEntry(2f, 10F))
            scatterEntries1?.add(BarEntry(3f, 10F))
            scatterEntries1?.add(BarEntry(4f, 10F))
            scatterEntries1?.add(BarEntry(5f, 10F))
            scatterEntries1?.add(BarEntry(6f, 10F))
            scatterEntries1?.add(BarEntry(7f, 10F))

        }


    private val entries2: Unit
        get() {
            scatterEntries2 = ArrayList()
            scatterEntries2?.add(BarEntry(1f, 120F))
            scatterEntries2?.add(BarEntry(2f, 114F))
            scatterEntries2?.add(BarEntry(3f, 118F))
            scatterEntries2?.add(BarEntry(4f, 120F))
            scatterEntries2?.add(BarEntry(5f, 160F))
            scatterEntries2?.add(BarEntry(6f, 175F))
            scatterEntries2?.add(BarEntry(7f, 123F))

        }

    private val entries3: Unit
        get() {
            scatterEntries3 = ArrayList()
            scatterEntries3?.add(BarEntry(1f, 200F))
            scatterEntries3?.add(BarEntry(2f, 210F))
            scatterEntries3?.add(BarEntry(3f, 210F))
            scatterEntries3?.add(BarEntry(4f, 230F))
            scatterEntries3?.add(BarEntry(5f, 240F))
            scatterEntries3?.add(BarEntry(6f, 10F))
            scatterEntries3?.add(BarEntry(7f, 10F))

        }
}