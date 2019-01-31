/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELS.Charts;

import MODELS.Personne;
import java.text.DecimalFormat;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author hamza
 */
public class SexeChart {
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
                "Total : " + Personne.personneCount() + " Clients", // chart title
                dataset, // data
                true, // include legend
                true,
                false);

        return chart;
    }

}
