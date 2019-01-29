/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELS;

import java.text.DecimalFormat;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author hamza
 */
public class Charts {

    //sexe chart
    public static JFreeChart sexeChart() {
        JFreeChart chart = createChart(sexeDataset());
        return chart;
    }

    //sexe dataset
    private static PieDataset sexeDataset() {
        double M = Personne.sexePourcentage("M.");
        double Mme = Personne.sexePourcentage("Mme");
        double Mlle = Personne.sexePourcentage("Mlle");

        DecimalFormat numberFormat = new DecimalFormat("#.0");
        String hommes = numberFormat.format(M * 100);
        String femmes = numberFormat.format((Mlle + Mme) * 100);

        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("hommes " + hommes + "%", M * 100);
        dataset.setValue("femmes " + femmes + "%", (Mlle + Mme) * 100);
        return dataset;
    }

    private static JFreeChart createChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                "sexe pourcentage", // chart title
                dataset, // data
                true, // include legend
                true,
                false);

        return chart;
    }

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
