package com.example.scatteredgraph

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anychart.AnyChart
import com.anychart.AnyChartView
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.data.Set


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val anyChartView = findViewById<AnyChartView>(R.id.any_chart_view)
        anyChartView.setProgressBar(findViewById(R.id.progress_bar))
        val cartesian = AnyChart.cartesian()
//        cartesian.title("Coastal Water Temperature \\nin London vs Edinburgh in 2015 (°C)")
        val data: MutableList<DataEntry> = ArrayList()
        data.add(CustomDataEntry("Mon",  90.1, 120.9))
        data.add(CustomDataEntry("Tue",  100.5, 130.2))
        data.add(CustomDataEntry("Wed", 75.9, 125.1))
        data.add(CustomDataEntry("Thu",  700.1, 120.8))
        data.add(CustomDataEntry("Fri",  111.3, 125.7))
        data.add(CustomDataEntry("Sat",  90.7, 130.5))
        data.add(CustomDataEntry("Sun",  99.3, 135.7))

        val set = Set.instantiate()
        set.data(data)
        val londonData = set.mapAs("{ x: 'x', high: 'pressureHigh', low: 'pressureLow' }")

        val columnLondon = cartesian.rangeColumn(londonData)
        columnLondon.name("Blood Pressure")

        cartesian.xAxis(true)
        cartesian.yAxis(true)
        cartesian.yScale()
            .minimum(80.0)
            .maximum(140.0)
        cartesian.legend(true)
        cartesian.yGrid(true)
            .yMinorGrid(true)
        cartesian.tooltip().titleFormat("{%SeriesName} ({%x})")
        anyChartView.setChart(cartesian)
    }

    private inner class CustomDataEntry(
        x: String?,
        pressureLow: Number?,
        pressureHigh: Number?

    ) :
        DataEntry() {
        init {
            setValue("x", x)
            setValue("pressureLow", pressureLow)
            setValue("pressureHigh", pressureHigh)
        }
    }
}
