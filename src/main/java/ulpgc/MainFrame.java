package ulpgc;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class MainFrame extends JFrame {
    public Map<String, Integer> histogramData;

    public MainFrame(Map<String, Integer> histogramData) throws HeadlessException {
        this.histogramData = histogramData;

        this.setTitle("Histogram Viewer");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(createHistogramDisplay());
    }

    private Component createHistogramDisplay() {
        JFreeChart chart = ChartFactory.createBarChart("Weights Histogram", "Weights Range", "Counts", createDataset(), PlotOrientation.VERTICAL, false, false, rootPaneCheckingEnabled);
        return new ChartPanel(chart);
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        histogramData.forEach((key, value) -> dataset.addValue(value, "", key));
        return dataset;
    }
}
