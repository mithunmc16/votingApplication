package com.example.comp2100_6442;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.charts.Pie;
import com.anychart.chart.common.dataentry.ValueDataEntry;


public class ViewResultsNEW extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_results);

        AnyChartView anyChartView = findViewById(R.id.any_chart_view);


        Pie pie = AnyChart.pie();

        // chart appearance
        pie.background().fill("#55707D");
        pie.title().fontSize(25);
        pie.title().fontColor("white");
        pie.stroke("white", 3, "0", "bevel", "round");
        pie.labels().fontColor("white");
        pie.labels().fontSize(16);
        pie.legend().fontColor("white");
        pie.legend().fontSize(16);

        // chart title (i.e. question)
        pie.title("Do you like COMP2100?");

        // chart data
        List<DataEntry> data = new ArrayList<>();
        data.add(new ValueDataEntry("Ya", 30));
        data.add(new ValueDataEntry("Meh", 30));
        data.add(new ValueDataEntry("Nah", 40));

        pie.data(data);

        anyChartView.setChart(pie);
    }
}
