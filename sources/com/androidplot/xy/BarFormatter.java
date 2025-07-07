package com.androidplot.xy;

import android.content.Context;
import android.graphics.Paint;
import com.androidplot.ui.SeriesRenderer;
/* loaded from: classes3.dex */
public class BarFormatter extends LineAndPointFormatter {
    private Paint borderPaint;
    private Paint fillPaint;
    private float marginBottom;
    private float marginLeft;
    private float marginRight;
    private float marginTop;

    @Override // com.androidplot.xy.LineAndPointFormatter
    public Paint getFillPaint() {
        return this.fillPaint;
    }

    @Override // com.androidplot.xy.LineAndPointFormatter
    public void setFillPaint(Paint paint) {
        this.fillPaint = paint;
    }

    public Paint getBorderPaint() {
        return this.borderPaint;
    }

    public void setBorderPaint(Paint paint) {
        this.borderPaint = paint;
    }

    public BarFormatter() {
        Paint paint = new Paint();
        this.fillPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.fillPaint.setAlpha(100);
        Paint paint2 = new Paint();
        this.borderPaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.borderPaint.setAlpha(100);
    }

    public BarFormatter(int i, int i2) {
        this();
        this.fillPaint.setColor(i);
        this.borderPaint.setColor(i2);
    }

    public BarFormatter(Context context, int i) {
        this();
        configure(context, i);
    }

    @Override // com.androidplot.xy.LineAndPointFormatter, com.androidplot.ui.Formatter
    public Class<? extends SeriesRenderer> getRendererClass() {
        return BarRenderer.class;
    }

    @Override // com.androidplot.xy.LineAndPointFormatter, com.androidplot.ui.Formatter
    public SeriesRenderer doGetRendererInstance(XYPlot xYPlot) {
        return new BarRenderer(xYPlot);
    }

    public float getMarginTop() {
        return this.marginTop;
    }

    public void setMarginTop(float f) {
        this.marginTop = f;
    }

    public float getMarginBottom() {
        return this.marginBottom;
    }

    public void setMarginBottom(float f) {
        this.marginBottom = f;
    }

    public float getMarginLeft() {
        return this.marginLeft;
    }

    public void setMarginLeft(float f) {
        this.marginLeft = f;
    }

    public float getMarginRight() {
        return this.marginRight;
    }

    public void setMarginRight(float f) {
        this.marginRight = f;
    }
}
