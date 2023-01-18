package cz.educanet;

import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.components.Axis;
import tech.tablesaw.plotly.components.Figure;
import tech.tablesaw.plotly.components.Layout;
import tech.tablesaw.plotly.components.Line;
import tech.tablesaw.plotly.traces.BarTrace;
import tech.tablesaw.plotly.traces.ScatterTrace;
import tech.tablesaw.plotly.traces.Trace;

import java.util.Arrays;

public class TraceExamples {

    public static void main(String[] args) {
        double[] xValues = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Object[] xValuesAsObj = Arrays.stream(xValues).boxed().toArray();
        double[] yValues = {1, 4, 9, 16, 25, 36, 49, 64, 81, 100};

        double[] xValues2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double[] yValues2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Axis xAxis = Axis.builder()
                .title("X axis title")
                .build();

        Layout layout = Layout.builder()
                .title("My Title")
                .height(650)
                .xAxis(xAxis)
                .width(650)
                .build();

        String[] texts = {"First", "Second", "..."};
        Trace trace = ScatterTrace
                .builder(xValues, yValues)
                .mode(ScatterTrace.Mode.LINE)
                .build();

        Line trace2Line = Line.builder()
                .color("pink")
                .dash(Line.Dash.DASH)
                .width(10)
                .build();

        Trace trace2 = ScatterTrace
                .builder(xValues2, yValues2)
                .line(trace2Line)
                .text(texts)
                .mode(ScatterTrace.Mode.LINE)
                .build();

        BarTrace trace3 = BarTrace.builder(xValuesAsObj, yValues).build();

        Figure fig = new Figure(layout, trace, trace2, trace3);
        Plot.show(fig);
    }

}
