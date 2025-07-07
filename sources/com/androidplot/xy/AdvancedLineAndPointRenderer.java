package com.androidplot.xy;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.core.internal.view.SupportMenu;
import com.androidplot.ui.RenderStack;
import com.androidplot.ui.SeriesRenderer;
/* loaded from: classes3.dex */
public class AdvancedLineAndPointRenderer extends XYSeriesRenderer<XYSeries, Formatter> {
    private int latestIndex;

    public AdvancedLineAndPointRenderer(XYPlot xYPlot) {
        super(xYPlot);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.androidplot.ui.SeriesRenderer
    public void onRender(Canvas canvas, RectF rectF, XYSeries xYSeries, Formatter formatter, RenderStack renderStack) {
        Canvas canvas2;
        int i = 0;
        PointF pointF = null;
        while (i < xYSeries.size()) {
            Number y = xYSeries.getY(i);
            Number x = xYSeries.getX(i);
            PointF transformScreen = (y == null || x == null) ? null : getPlot().getBounds().transformScreen(x, y, rectF);
            if (formatter.getLinePaint() == null || transformScreen == null || pointF == null) {
                canvas2 = canvas;
            } else {
                canvas2 = canvas;
                canvas2.drawLine(pointF.x, pointF.y, transformScreen.x, transformScreen.y, formatter.getLinePaint(i, this.latestIndex, xYSeries.size()));
            }
            i++;
            pointF = transformScreen;
            canvas = canvas2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.androidplot.ui.SeriesRenderer
    public void doDrawLegendIcon(Canvas canvas, RectF rectF, Formatter formatter) {
        if (formatter.getLinePaint() != null) {
            canvas.drawLine(rectF.left, rectF.bottom, rectF.right, rectF.top, formatter.getLinePaint());
        }
    }

    public void setLatestIndex(int i) {
        this.latestIndex = i;
    }

    /* loaded from: classes3.dex */
    public static class Formatter extends XYSeriesFormatter<XYRegionFormatter> {
        private static final int DEFAULT_STROKE_WIDTH = 3;
        private Paint linePaint;

        public Formatter() {
            Paint paint = new Paint();
            this.linePaint = paint;
            paint.setStrokeWidth(3.0f);
            this.linePaint.setColor(SupportMenu.CATEGORY_MASK);
        }

        public Formatter(Context context, int i) {
            this();
            configure(context, i);
        }

        @Override // com.androidplot.ui.Formatter
        public Class<? extends SeriesRenderer> getRendererClass() {
            return AdvancedLineAndPointRenderer.class;
        }

        @Override // com.androidplot.ui.Formatter
        public AdvancedLineAndPointRenderer doGetRendererInstance(XYPlot xYPlot) {
            return new AdvancedLineAndPointRenderer(xYPlot);
        }

        public Paint getLinePaint() {
            return this.linePaint;
        }

        public Paint getLinePaint(int i, int i2, int i3) {
            return getLinePaint();
        }

        public void setLinePaint(Paint paint) {
            this.linePaint = paint;
        }
    }
}
