/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELS.Charts;

import MODELS.Compte;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author hamza
 */
public class NbCompteChart {

    public static JFreeChart nbCompteChart() {
        JFreeChart lineChart = ChartFactory.createLineChart(
                "Nombre de Compte Créer Chaque Mois",
                "Mois", "Nombre de Compte",
                nbCompteDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);

        return lineChart;
    }

    private static DefaultCategoryDataset nbCompteDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 12; i > 0; i -= 1) {
            if (i < 10) {
                dataset.addValue(Compte.nbCompte("0" + i), "Age", "" + i);
            } else {
                dataset.addValue(Compte.nbCompte("" + i), "Age", "" + i);
            }
        }
        return dataset;
    }
}
