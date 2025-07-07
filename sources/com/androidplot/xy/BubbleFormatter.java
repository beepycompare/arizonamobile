package com.androidplot.xy;

import android.content.Context;
import android.graphics.Paint;
import com.androidplot.ui.SeriesRenderer;
import com.androidplot.util.PixelUtils;
/* loaded from: classes3.dex */
public class BubbleFormatter extends XYSeriesFormatter<XYRegionFormatter> {
    private static final int DEFAULT_FILL_COLOR = -256;
    private static final int DEFAULT_STROKE_COLOR = -16777216;
    private static final float DEFAULT_STROKE_PIX = 1.0f;
    private Paint fillPaint;
    private Paint strokePaint;

    public BubbleFormatter() {
        Paint paint = new Paint();
        this.strokePaint = paint;
        paint.setAntiAlias(true);
        this.strokePaint.setStrokeWidth(PixelUtils.dpToPix(1.0f));
        this.strokePaint.setStyle(Paint.Style.STROKE);
        this.strokePaint.setColor(-16777216);
        Paint paint2 = new Paint();
        this.fillPaint = paint2;
        paint2.setAntiAlias(true);
        this.fillPaint.setColor(-256);
        setPointLabeler(new PointLabeler<BubbleSeries>() { // from class: com.androidplot.xy.BubbleFormatter.1
            @Override // com.androidplot.xy.PointLabeler
            public String getLabel(BubbleSeries bubbleSeries, int i) {
                return String.valueOf(bubbleSeries.getZ(i));
            }
        });
    }

    public BubbleFormatter(Context context, int i) {
        this();
        configure(context, i);
    }

    public BubbleFormatter(int i, int i2) {
        Paint paint = new Paint();
        this.strokePaint = paint;
        paint.setAntiAlias(true);
        this.strokePaint.setStrokeWidth(PixelUtils.dpToPix(1.0f));
        this.strokePaint.setStyle(Paint.Style.STROKE);
        this.strokePaint.setColor(-16777216);
        Paint paint2 = new Paint();
        this.fillPaint = paint2;
        paint2.setAntiAlias(true);
        this.fillPaint.setColor(-256);
        setPointLabeler(new PointLabeler<BubbleSeries>() { // from class: com.androidplot.xy.BubbleFormatter.1
            @Override // com.androidplot.xy.PointLabeler
            public String getLabel(BubbleSeries bubbleSeries, int i3) {
                return String.valueOf(bubbleSeries.getZ(i3));
            }
        });
        this.fillPaint.setColor(i);
        this.strokePaint.setColor(i2);
    }

    @Override // com.androidplot.ui.Formatter
    public Class<? extends SeriesRenderer> getRendererClass() {
        return BubbleRenderer.class;
    }

    @Override // com.androidplot.ui.Formatter
    public BubbleRenderer doGetRendererInstance(XYPlot xYPlot) {
        return new BubbleRenderer(xYPlot);
    }

    public Paint getStrokePaint() {
        return this.strokePaint;
    }

    public void setStrokePaint(Paint paint) {
        this.strokePaint = paint;
    }

    public Paint getFillPaint() {
        return this.fillPaint;
    }

    public void setFillPaint(Paint paint) {
        this.fillPaint = paint;
    }
}
