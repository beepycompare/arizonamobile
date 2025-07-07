package com.androidplot.xy;

import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.RectF;
import com.androidplot.ui.RenderStack;
import com.androidplot.ui.SeriesRenderer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class FastLineAndPointRenderer extends XYSeriesRenderer<XYSeries, Formatter> {
    private static final int MINIMUM_NUMBER_OF_POINTS_TO_DEFINE_A_LINE = 4;
    private float[] points;
    List<Integer> segmentLengths;
    List<Integer> segmentOffsets;

    public FastLineAndPointRenderer(XYPlot xYPlot) {
        super(xYPlot);
        this.segmentOffsets = new ArrayList();
        this.segmentLengths = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.androidplot.ui.SeriesRenderer
    public void onRender(Canvas canvas, RectF rectF, XYSeries xYSeries, Formatter formatter, RenderStack renderStack) {
        this.segmentOffsets.clear();
        this.segmentLengths.clear();
        int size = xYSeries.size() * 2;
        float[] fArr = this.points;
        if (fArr == null || fArr.length != size) {
            this.points = new float[xYSeries.size() * 2];
        }
        PointF pointF = new PointF();
        boolean z = true;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < xYSeries.size()) {
            Number y = xYSeries.getY(i);
            Number x = xYSeries.getX(i);
            if (y != null && x != null) {
                if (z) {
                    this.segmentOffsets.add(Integer.valueOf(i3));
                    i2 = 0;
                    z = false;
                }
                getPlot().getBounds().transformScreen(pointF, x, y, rectF);
                this.points[i3] = pointF.x;
                this.points[i3 + 1] = pointF.y;
                i2 += 2;
                if (i == xYSeries.size() - 1) {
                    this.segmentLengths.add(Integer.valueOf(i2));
                }
            } else if (!z) {
                this.segmentLengths.add(Integer.valueOf(i2));
                z = true;
            }
            i++;
            i3 += 2;
        }
        if (formatter.linePaint == null && formatter.vertexPaint == null) {
            return;
        }
        for (int i4 = 0; i4 < this.segmentOffsets.size(); i4++) {
            drawSegment(canvas, this.points, this.segmentOffsets.get(i4).intValue(), this.segmentLengths.get(i4).intValue(), formatter);
        }
    }

    protected void drawSegment(Canvas canvas, float[] fArr, int i, int i2, Formatter formatter) {
        if (formatter.linePaint != null && i2 >= 4) {
            if ((i2 & 2) != 0) {
                int i3 = i2 - 2;
                canvas.drawLines(fArr, i, i3, formatter.linePaint);
                canvas.drawLines(fArr, i + 2, i3, formatter.linePaint);
            } else {
                canvas.drawLines(fArr, i, i2, formatter.linePaint);
                canvas.drawLines(fArr, i + 2, i2 - 4, formatter.linePaint);
            }
        }
        if (formatter.vertexPaint != null) {
            canvas.drawPoints(fArr, i, i2, formatter.vertexPaint);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.androidplot.ui.SeriesRenderer
    public void doDrawLegendIcon(Canvas canvas, RectF rectF, Formatter formatter) {
        Canvas canvas2;
        if (formatter.hasLinePaint()) {
            canvas2 = canvas;
            canvas2.drawLine(rectF.left, rectF.bottom, rectF.right, rectF.top, formatter.getLinePaint());
        } else {
            canvas2 = canvas;
        }
        if (formatter.hasVertexPaint()) {
            canvas2.drawPoint(rectF.centerX(), rectF.centerY(), formatter.getVertexPaint());
        }
    }

    /* loaded from: classes3.dex */
    public static class Formatter extends LineAndPointFormatter {
        public Formatter(Integer num, Integer num2, PointLabelFormatter pointLabelFormatter) {
            super(num, num2, null, pointLabelFormatter);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.androidplot.xy.LineAndPointFormatter
        public void initLinePaint(Integer num) {
            super.initLinePaint(num);
            getLinePaint().setAntiAlias(false);
        }

        @Override // com.androidplot.xy.LineAndPointFormatter, com.androidplot.ui.Formatter
        public Class<? extends SeriesRenderer> getRendererClass() {
            return FastLineAndPointRenderer.class;
        }

        @Override // com.androidplot.xy.LineAndPointFormatter, com.androidplot.ui.Formatter
        public SeriesRenderer doGetRendererInstance(XYPlot xYPlot) {
            return new FastLineAndPointRenderer(xYPlot);
        }
    }
}
