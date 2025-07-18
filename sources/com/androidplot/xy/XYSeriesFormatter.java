package com.androidplot.xy;

import android.content.Context;
import com.androidplot.ui.Formatter;
import com.androidplot.util.LayerHash;
import com.androidplot.util.Layerable;
import com.androidplot.xy.XYRegionFormatter;
/* loaded from: classes3.dex */
public abstract class XYSeriesFormatter<XYRegionFormatterType extends XYRegionFormatter> extends Formatter<XYPlot> {
    private PointLabelFormatter pointLabelFormatter;
    private PointLabeler pointLabeler;
    LayerHash<RectRegion, XYRegionFormatterType> regions;

    public XYSeriesFormatter() {
        this.pointLabeler = new PointLabeler() { // from class: com.androidplot.xy.XYSeriesFormatter.1
            @Override // com.androidplot.xy.PointLabeler
            public String getLabel(XYSeries xYSeries, int i) {
                return String.valueOf(xYSeries.getY(i));
            }
        };
        this.regions = new LayerHash<>();
    }

    public XYSeriesFormatter(Context context, int i) {
        super(context, i);
        this.pointLabeler = new PointLabeler() { // from class: com.androidplot.xy.XYSeriesFormatter.1
            @Override // com.androidplot.xy.PointLabeler
            public String getLabel(XYSeries xYSeries, int i2) {
                return String.valueOf(xYSeries.getY(i2));
            }
        };
        this.regions = new LayerHash<>();
    }

    public void addRegion(RectRegion rectRegion, XYRegionFormatterType xyregionformattertype) {
        this.regions.addToBottom(rectRegion, xyregionformattertype);
    }

    public void removeRegion(RectRegion rectRegion) {
        this.regions.remove(rectRegion);
    }

    public Layerable<RectRegion> getRegions() {
        return this.regions;
    }

    public XYRegionFormatterType getRegionFormatter(RectRegion rectRegion) {
        return this.regions.get(rectRegion);
    }

    public PointLabeler getPointLabeler() {
        return this.pointLabeler;
    }

    public void setPointLabeler(PointLabeler pointLabeler) {
        this.pointLabeler = pointLabeler;
    }

    public boolean hasPointLabelFormatter() {
        return this.pointLabelFormatter != null;
    }

    public PointLabelFormatter getPointLabelFormatter() {
        if (this.pointLabelFormatter == null) {
            this.pointLabelFormatter = new PointLabelFormatter();
        }
        return this.pointLabelFormatter;
    }

    public void setPointLabelFormatter(PointLabelFormatter pointLabelFormatter) {
        this.pointLabelFormatter = pointLabelFormatter;
    }
}
