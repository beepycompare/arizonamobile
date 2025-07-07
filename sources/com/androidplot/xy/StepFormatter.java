package com.androidplot.xy;

import com.androidplot.ui.SeriesRenderer;
/* loaded from: classes3.dex */
public class StepFormatter extends LineAndPointFormatter {
    public StepFormatter() {
    }

    public StepFormatter(Integer num, Integer num2) {
        initLinePaint(num);
        initFillPaint(num2);
    }

    @Override // com.androidplot.xy.LineAndPointFormatter, com.androidplot.ui.Formatter
    public Class<? extends SeriesRenderer> getRendererClass() {
        return StepRenderer.class;
    }

    @Override // com.androidplot.xy.LineAndPointFormatter, com.androidplot.ui.Formatter
    public SeriesRenderer doGetRendererInstance(XYPlot xYPlot) {
        return new StepRenderer(xYPlot);
    }
}
