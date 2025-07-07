package com.androidplot.xy;

import com.androidplot.SeriesRegistry;
/* loaded from: classes3.dex */
public class XYSeriesRegistry extends SeriesRegistry<XYSeriesBundle, XYSeries, XYSeriesFormatter> {
    private Estimator estimator;

    public void estimate(XYPlot xYPlot) {
        if (this.estimator != null) {
            for (XYSeriesBundle xYSeriesBundle : getSeriesAndFormatterList()) {
                getEstimator().run(xYPlot, xYSeriesBundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.androidplot.SeriesRegistry
    public XYSeriesBundle newSeriesBundle(XYSeries xYSeries, XYSeriesFormatter xYSeriesFormatter) {
        return new XYSeriesBundle(xYSeries, xYSeriesFormatter);
    }

    public Estimator getEstimator() {
        return this.estimator;
    }

    public void setEstimator(Estimator estimator) {
        this.estimator = estimator;
    }
}
