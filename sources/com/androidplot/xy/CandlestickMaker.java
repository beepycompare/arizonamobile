package com.androidplot.xy;

import com.androidplot.Series;
/* loaded from: classes3.dex */
public abstract class CandlestickMaker {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static void make(XYPlot xYPlot, CandlestickFormatter candlestickFormatter, XYSeries xYSeries, XYSeries xYSeries2, XYSeries xYSeries3, XYSeries xYSeries4) {
        xYPlot.addSeries((XYPlot) candlestickFormatter, (Series[]) new XYSeries[]{xYSeries3, xYSeries4, xYSeries, xYSeries2});
    }

    public static void make(XYPlot xYPlot, CandlestickFormatter candlestickFormatter, CandlestickSeries candlestickSeries) {
        make(xYPlot, candlestickFormatter, candlestickSeries.getOpenSeries(), candlestickSeries.getCloseSeries(), candlestickSeries.getHighSeries(), candlestickSeries.getLowSeries());
    }

    public static void check(CandlestickSeries candlestickSeries) {
        check(candlestickSeries.getOpenSeries(), candlestickSeries.getCloseSeries(), candlestickSeries.getHighSeries(), candlestickSeries.getLowSeries());
    }

    public static void check(XYSeries xYSeries, XYSeries xYSeries2, XYSeries xYSeries3, XYSeries xYSeries4) {
        int size = xYSeries.size();
        for (int i = 0; i < size; i++) {
            xYSeries3.getY(i).doubleValue();
            xYSeries4.getY(i).doubleValue();
            xYSeries.getY(i).doubleValue();
            xYSeries2.getY(i).doubleValue();
        }
    }
}
