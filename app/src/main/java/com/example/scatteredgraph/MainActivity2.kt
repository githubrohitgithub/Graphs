package com.example.scatteredgraph

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anychart.AnyChart
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.core.ui.ChartCredits
import com.anychart.data.Set
import com.example.scatteredgraph.databinding.ActivityMain2Binding


class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.anyChartView.setProgressBar(findViewById(R.id.progress_bar))
        val cartesian = AnyChart.cartesian()

        cartesian.apply {
            this.pointWidth(8)
            this.xAxis(true)
            this.yAxis(true)
            this.yScale()
                .minimum(80.0)
                .maximum(140.0)
            this.legend(true)
            this.yGrid(true)
                .yMinorGrid(true)

        }

        val set = Set.instantiate()
        set.data(dataList())

        val columnBar = cartesian.rangeColumn(set.mapAs("{ x: 'x', high: 'pressureHigh', low: 'pressureLow' }"))

        columnBar.apply {
            name("Blood Pressure")
            color("#1c64f2")
        }

        binding.anyChartView.setChart(cartesian)

    }

   private fun dataList():MutableList<DataEntry> {
       val data: MutableList<DataEntry> = ArrayList()
       data.add(CustomDataEntry("Mon",  90.1, 120.9))
       data.add(CustomDataEntry("Tue",  100.5, 130.2))
       data.add(CustomDataEntry("Wed",  75.9, 125.1))
       data.add(CustomDataEntry("Thu",  700.1, 120.8))
       data.add(CustomDataEntry("Fri",  111.3, 125.7))
       data.add(CustomDataEntry("Sat",  90.7, 130.5))
       data.add(CustomDataEntry("Sun",  99.3, 135.7))
       return data
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
