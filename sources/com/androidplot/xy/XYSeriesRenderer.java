package com.androidplot.xy;

import com.androidplot.ui.SeriesBundle;
import com.androidplot.ui.SeriesRenderer;
import com.androidplot.xy.XYSeries;
import com.androidplot.xy.XYSeriesFormatter;
import java.util.Hashtable;
import java.util.Iterator;
/* loaded from: classes3.dex */
public abstract class XYSeriesRenderer<SeriesType extends XYSeries, XYFormatterType extends XYSeriesFormatter> extends SeriesRenderer<XYPlot, SeriesType, XYFormatterType> {
    public XYSeriesRenderer(XYPlot xYPlot) {
        super(xYPlot);
    }

    public Hashtable<XYRegionFormatter, String> getUniqueRegionFormatters() {
        Hashtable<XYRegionFormatter, String> hashtable = new Hashtable<>();
        Iterator it = getSeriesAndFormatterList().iterator();
        while (it.hasNext()) {
            SeriesBundle seriesBundle = (SeriesBundle) it.next();
            for (RectRegion rectRegion : ((XYSeriesFormatter) seriesBundle.getFormatter()).getRegions().elements()) {
                hashtable.put(((XYSeriesFormatter) seriesBundle.getFormatter()).getRegionFormatter(rectRegion), rectRegion.getLabel());
            }
        }
        return hashtable;
    }
}
