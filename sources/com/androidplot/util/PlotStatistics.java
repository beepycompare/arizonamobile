package com.androidplot.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.androidplot.Plot;
import com.androidplot.PlotListener;
/* loaded from: classes3.dex */
public class PlotStatistics implements PlotListener {
    private boolean annotatePlotEnabled;
    long lastAnnotation;
    private Paint paint;
    long updateDelayMs;
    long longestRenderMs = 0;
    long shortestRenderMs = 0;
    long lastStart = 0;
    long lastLatency = 0;
    long latencySamples = 0;
    long latencySum = 0;
    String annotationString = "";

    public PlotStatistics(long j, boolean z) {
        Paint paint = new Paint();
        this.paint = paint;
        paint.setTextAlign(Paint.Align.CENTER);
        this.paint.setColor(-1);
        this.paint.setTextSize(30.0f);
        resetCounters();
        this.updateDelayMs = j;
        this.annotatePlotEnabled = z;
    }

    public void setAnnotatePlotEnabled(boolean z) {
        this.annotatePlotEnabled = z;
    }

    private void resetCounters() {
        this.longestRenderMs = 0L;
        this.shortestRenderMs = 999999999L;
        this.latencySamples = 0L;
        this.latencySum = 0L;
    }

    private void annotatePlot(Plot plot, Canvas canvas) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.lastAnnotation;
        if (j >= this.updateDelayMs) {
            long j2 = this.latencySamples;
            float f = j2 > 0 ? (float) (this.latencySum / j2) : 0.0f;
            this.annotationString = "FPS (potential): " + String.format("%.2f", Float.valueOf(this.latencySamples > 0 ? 1000.0f / f : 0.0f)) + " FPS (actual): " + String.format("%.2f", Float.valueOf(j2 > 0 ? (1000.0f / ((float) j)) * ((float) j2) : 0.0f)) + " Latency (ms) Avg: " + this.lastLatency + " \nMin: " + this.shortestRenderMs + " Max: " + this.longestRenderMs;
            this.lastAnnotation = currentTimeMillis;
            resetCounters();
        }
        RectF rectF = plot.getDisplayDimensions().canvasRect;
        if (this.annotatePlotEnabled) {
            canvas.drawText(this.annotationString, rectF.centerX(), rectF.centerY(), this.paint);
        }
    }

    @Override // com.androidplot.PlotListener
    public void onBeforeDraw(Plot plot, Canvas canvas) {
        this.lastStart = System.currentTimeMillis();
    }

    @Override // com.androidplot.PlotListener
    public void onAfterDraw(Plot plot, Canvas canvas) {
        long currentTimeMillis = System.currentTimeMillis() - this.lastStart;
        this.lastLatency = currentTimeMillis;
        if (currentTimeMillis < this.shortestRenderMs) {
            this.shortestRenderMs = currentTimeMillis;
        }
        if (currentTimeMillis > this.longestRenderMs) {
            this.longestRenderMs = currentTimeMillis;
        }
        this.latencySum += currentTimeMillis;
        this.latencySamples++;
        annotatePlot(plot, canvas);
    }

    public void setEnabled(boolean z) {
        this.annotatePlotEnabled = z;
    }
}
