package cz.educanet.simple;

import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.api.PiePlot;
import tech.tablesaw.plotly.components.Figure;

public class Pie {

    public static void main(String[] args) {
        String[] schoolClasses = {"C1", "C2", "C3", "C4"};
        double[] meanGrades = {1.5, 3.4, 1.3, 4.8};

        StringColumn categories = StringColumn.create("categories", schoolClasses);
        DoubleColumn grades = DoubleColumn.create("grades", meanGrades);
        Table table = Table.create(categories, grades);

        Figure fig = PiePlot.create(
            "Grades per class", table, "categories", "grades"
        );
        Plot.show(fig);
    }

}
