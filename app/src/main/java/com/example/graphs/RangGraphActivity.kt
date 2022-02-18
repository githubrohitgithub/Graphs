package com.example.graphs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anychart.AnyChart
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.data.Set
import com.example.scatteredgraph.R
import com.example.scatteredgraph.databinding.ActivityRangegraphBinding


class RangGraphActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRangegraphBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRangegraphBinding.inflate(layoutInflater)
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

   private fun dataList():ArrayList<DataEntry> {

       val dataEntries by lazy { ArrayList<DataEntry>() }
       dataEntries.add(CustomDataEntry("Mon",  90.1, 120.9))
       dataEntries.add(CustomDataEntry("Tue",  100.5, 130.2))
       dataEntries.add(CustomDataEntry("Wed",  75.9, 125.1))
       dataEntries.add(CustomDataEntry("Thu",  700.1, 120.8))
       dataEntries.add(CustomDataEntry("Fri",  111.3, 125.7))
       dataEntries.add(CustomDataEntry("Sat",  90.7, 130.5))
       dataEntries.add(CustomDataEntry("Sun",  99.3, 135.7))
       return dataEntries
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
