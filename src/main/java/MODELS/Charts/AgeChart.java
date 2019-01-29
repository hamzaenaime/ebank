/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELS.Charts;

import MODELS.Personne;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author hamza
 */
public class AgeChart {

    //age chart
    public static JFreeChart ageChart() {
        JFreeChart lineChart = ChartFactory.createLineChart(
                "Age chart",
                "Ans", "Nombre de Clients",
                ageDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);

        return lineChart;
    }

    //age dataset
    private static DefaultCategoryDataset ageDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 2001; i > 1990; i -= 1) {
            dataset.addValue(Personne.ageCount("" + i), "Age", "" + (2019 - i));
        }
        return dataset;
    }

}
