/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST;

/**
 *
 * @author hamza
 */
import MODELS.Personne;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;

public class chart extends ApplicationFrame {

    public chart(String title) {
        super(title);
        setContentPane(createDemoPanel());
    }

    private static PieDataset createDataset() {
        double M = Personne.sexePourcentage("M.");
        double Mme = Personne.sexePourcentage("Mme");
        double Mlle = Personne.sexePourcentage("Mlle");
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("hommes", M * 100);
        dataset.setValue("mademoiselles", Mlle * 100);
        dataset.setValue("madames", Mme * 100);
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

    public static JPanel createDemoPanel() {
        JFreeChart chart = createChart(createDataset());
        return new ChartPanel(chart);
    }

    public static void main(String[] args) {
        chart demo = new chart("sexe pourcentage");
        demo.setSize(560, 367);
        demo.setVisible(true);
    }
}
