package cz.educanet.simple;

import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.api.LinePlot;
import tech.tablesaw.plotly.components.Figure;

public class Line {

    public static void main(String[] args) {
        double[] xValues = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double[] yValues = {1, 4, 9, 16, 25, 36, 49, 64, 81, 100};

        Figure fig = LinePlot.create(
                "Main Title",
                "Title for X axis", xValues,
                "Title for Y axis", yValues
        );
        Plot.show(fig);
    }

}
