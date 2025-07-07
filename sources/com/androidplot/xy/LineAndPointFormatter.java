package com.androidplot.xy;

import android.content.Context;
import android.graphics.Paint;
import androidx.core.internal.view.SupportMenu;
import com.androidplot.ui.SeriesRenderer;
import com.androidplot.util.PixelUtils;
/* loaded from: classes3.dex */
public class LineAndPointFormatter extends XYSeriesFormatter<XYRegionFormatter> {
    private static final float DEFAULT_LINE_STROKE_WIDTH_DP = 1.5f;
    private static final float DEFAULT_VERTEX_STROKE_WIDTH_DP = 4.5f;
    protected FillDirection fillDirection;
    protected Paint fillPaint;
    protected InterpolationParams interpolationParams;
    protected Paint linePaint;
    protected Paint vertexPaint;

    public FillDirection getFillDirection() {
        return this.fillDirection;
    }

    public void setFillDirection(FillDirection fillDirection) {
        this.fillDirection = fillDirection;
    }

    public LineAndPointFormatter(Context context, int i) {
        super(context, i);
        this.fillDirection = FillDirection.BOTTOM;
    }

    public LineAndPointFormatter() {
        this(Integer.valueOf((int) SupportMenu.CATEGORY_MASK), -16711936, -16776961, null);
    }

    public LineAndPointFormatter(Integer num, Integer num2, Integer num3, PointLabelFormatter pointLabelFormatter) {
        this(num, num2, num3, pointLabelFormatter, FillDirection.BOTTOM);
    }

    public LineAndPointFormatter(Integer num, Integer num2, Integer num3, PointLabelFormatter pointLabelFormatter, FillDirection fillDirection) {
        this.fillDirection = FillDirection.BOTTOM;
        initLinePaint(num);
        initVertexPaint(num2);
        initFillPaint(num3);
        setFillDirection(fillDirection);
        setPointLabelFormatter(pointLabelFormatter);
    }

    @Override // com.androidplot.ui.Formatter
    public Class<? extends SeriesRenderer> getRendererClass() {
        return LineAndPointRenderer.class;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.androidplot.ui.Formatter
    public SeriesRenderer doGetRendererInstance(XYPlot xYPlot) {
        return new LineAndPointRenderer(xYPlot);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initLinePaint(Integer num) {
        if (num == null) {
            this.linePaint = null;
            return;
        }
        Paint paint = new Paint();
        this.linePaint = paint;
        paint.setAntiAlias(true);
        this.linePaint.setStrokeWidth(PixelUtils.dpToPix(DEFAULT_LINE_STROKE_WIDTH_DP));
        this.linePaint.setColor(num.intValue());
        this.linePaint.setStyle(Paint.Style.STROKE);
    }

    protected void initVertexPaint(Integer num) {
        if (num == null) {
            this.vertexPaint = null;
            return;
        }
        Paint paint = new Paint();
        this.vertexPaint = paint;
        paint.setAntiAlias(true);
        this.vertexPaint.setStrokeWidth(PixelUtils.dpToPix(DEFAULT_VERTEX_STROKE_WIDTH_DP));
        this.vertexPaint.setColor(num.intValue());
        this.vertexPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initFillPaint(Integer num) {
        if (num == null) {
            this.fillPaint = null;
            return;
        }
        Paint paint = new Paint();
        this.fillPaint = paint;
        paint.setAntiAlias(true);
        this.fillPaint.setColor(num.intValue());
    }

    public boolean hasLinePaint() {
        return this.linePaint != null;
    }

    public Paint getLinePaint() {
        if (this.linePaint == null) {
            initLinePaint(0);
        }
        return this.linePaint;
    }

    public void setLinePaint(Paint paint) {
        this.linePaint = paint;
    }

    public boolean hasVertexPaint() {
        return this.vertexPaint != null;
    }

    public Paint getVertexPaint() {
        if (this.vertexPaint == null) {
            initVertexPaint(0);
        }
        return this.vertexPaint;
    }

    public void setVertexPaint(Paint paint) {
        this.vertexPaint = paint;
    }

    public boolean hasFillPaint() {
        return this.fillPaint != null;
    }

    public Paint getFillPaint() {
        if (this.fillPaint == null) {
            initFillPaint(0);
        }
        return this.fillPaint;
    }

    public void setFillPaint(Paint paint) {
        this.fillPaint = paint;
    }

    public InterpolationParams getInterpolationParams() {
        return this.interpolationParams;
    }

    public void setInterpolationParams(InterpolationParams interpolationParams) {
        this.interpolationParams = interpolationParams;
    }
}
