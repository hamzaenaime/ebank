/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELS;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author hamza
 */
public class Charts {

    public static JFreeChart sexeChart() {
        JFreeChart chart = createChart(createDataset());
        return chart;
    }

    //sexe dataset
    private static PieDataset createDataset() {
        double M = Personne.sexePourcentage("M.");
        double Mme = Personne.sexePourcentage("Mme");
        double Mlle = Personne.sexePourcentage("Mlle");
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("hommes", M * 100);
        dataset.setValue("femmes", (Mlle + Mme) * 100);
        return dataset;
    }

    //sexe chart
    private static JFreeChart createChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                "sexe pourcentage", // chart title
                dataset, // data
                true, // include legend
                true,
                false);

        return chart;
    }

}
