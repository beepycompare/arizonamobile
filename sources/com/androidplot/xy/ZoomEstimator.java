package com.androidplot.xy;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
/* loaded from: classes3.dex */
public class ZoomEstimator extends Estimator {
    @Override // com.androidplot.xy.Estimator
    public void run(XYPlot xYPlot, XYSeriesBundle xYSeriesBundle) {
        if (xYSeriesBundle.getSeries() instanceof SampledXYSeries) {
            SampledXYSeries sampledXYSeries = (SampledXYSeries) xYSeriesBundle.getSeries();
            sampledXYSeries.setZoomFactor(calculateZoom(sampledXYSeries, xYPlot.getBounds()));
        }
    }

    protected double calculateZoom(SampledXYSeries sampledXYSeries, RectRegion rectRegion) {
        double abs = Math.abs(Math.round(sampledXYSeries.getMaxZoomFactor() / sampledXYSeries.getBounds().getxRegion().ratio(rectRegion.getxRegion()).doubleValue()));
        if (abs > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return abs;
        }
        return 1.0d;
    }
}
