/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELS.Charts;

import MODELS.Operation;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author hamza
 */
public class TransactionChart {

    public static JFreeChart transactionChart() {
        JFreeChart barChart = ChartFactory.createBarChart(
                "Somme de Transaction Fait Chaque Mois",
                "Mois", "Montant (DH)",
                transactionDataSet(),
                PlotOrientation.VERTICAL,
                true, true, false);

        return barChart;
    }

    private static CategoryDataset transactionDataSet() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 12; i > 0; i -= 1) {
            if (i < 10) {
                dataset.addValue(Operation.transactionMontant("0" + i), "Montant (DH)", "" + i);
            } else {
                dataset.addValue(Operation.transactionMontant("" + i), "Montant (DH)", "" + i);
            }
        }
        return dataset;
    }
}
