package com.example.scatteredgraph

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.scatteredgraph.databinding.ActivityMainBinding
import com.github.mikephil.charting.charts.ScatterChart
import com.github.mikephil.charting.components.LimitLine
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val dataSets by lazy { ArrayList<IScatterDataSet>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCandle.setOnClickListener {
            startActivity(Intent(applicationContext,MainActivity2::class.java))
        }


        val set1 = ScatterDataSet(initDataset1(), "Data set 1")
        set1.apply {
            this.setScatterShape(ScatterChart.ScatterShape.CIRCLE)
            this.color = Color.BLUE
            this.setDrawValues(false)
            this.scatterShapeSize = 15f
        }

        val set2 = ScatterDataSet(initDataset2(), "Data set 2")
        set2.apply {
            this.setScatterShape(ScatterChart.ScatterShape.CIRCLE)
            this.color = Color.GREEN
            this.setDrawValues(false)
            this.scatterShapeSize = 15f
        }

        val set3 = ScatterDataSet(initDataset3(), "Data set 3")
        set3.apply {
            this.setScatterShape(ScatterChart.ScatterShape.CIRCLE)
            this.color = Color.RED
            this.setDrawValues(false)
            this.scatterShapeSize = 15f
        }

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

    }

    private fun initDataset1():ArrayList<Entry> {

        val scatterEntries by lazy { ArrayList<Entry>() }
        scatterEntries.add(BarEntry(1f, 10F))
        scatterEntries.add(BarEntry(2f, 10F))
        scatterEntries.add(BarEntry(3f, 10F))
        scatterEntries.add(BarEntry(4f, 10F))
        scatterEntries.add(BarEntry(5f, 10F))
        scatterEntries.add(BarEntry(6f, 10F))
        scatterEntries.add(BarEntry(7f, 10F))

        return scatterEntries

    }

    private fun initDataset2():ArrayList<Entry> {

        val scatterEntries by lazy { ArrayList<Entry>() }
        scatterEntries.add(BarEntry(1f, 120F))
        scatterEntries.add(BarEntry(2f, 114F))
        scatterEntries.add(BarEntry(3f, 118F))
        scatterEntries.add(BarEntry(4f, 120F))
        scatterEntries.add(BarEntry(5f, 160F))
        scatterEntries.add(BarEntry(6f, 175F))
        scatterEntries.add(BarEntry(7f, 123F))

        return scatterEntries
    }


    private fun initDataset3():ArrayList<Entry> {

        val scatterEntries by lazy { ArrayList<Entry>() }
        scatterEntries.add(BarEntry(1f, 200F))
        scatterEntries.add(BarEntry(2f, 210F))
        scatterEntries.add(BarEntry(3f, 210F))
        scatterEntries.add(BarEntry(4f, 230F))
        scatterEntries.add(BarEntry(5f, 240F))
        scatterEntries.add(BarEntry(6f, 10F))
        scatterEntries.add(BarEntry(7f, 10F))

        return scatterEntries
    }


}