package com.androidplot.xy;

import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.RectF;
import com.androidplot.Region;
import com.androidplot.Series;
import com.androidplot.ui.Formatter;
import com.androidplot.ui.RenderStack;
import com.androidplot.ui.SeriesBundle;
import com.androidplot.util.FontUtils;
import com.androidplot.util.PixelUtils;
import com.androidplot.util.SeriesUtils;
import com.androidplot.xy.BubbleFormatter;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class BubbleRenderer<FormatterType extends BubbleFormatter> extends XYSeriesRenderer<BubbleSeries, FormatterType> {
    protected static final float MAX_BUBBLE_RADIUS_DEFAULT_DP = 25.0f;
    protected static final float MIN_BUBBLE_RADIUS_DEFAULT_DP = 9.0f;
    private Region bubbleBounds;
    private BubbleScaleMode bubbleScaleMode;

    /* loaded from: classes3.dex */
    public enum BubbleScaleMode {
        LINEAR,
        SQUARE_ROOT
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.androidplot.ui.SeriesRenderer
    protected /* bridge */ /* synthetic */ void doDrawLegendIcon(Canvas canvas, RectF rectF, Formatter formatter) {
        doDrawLegendIcon(canvas, rectF, (RectF) ((BubbleFormatter) formatter));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.androidplot.ui.SeriesRenderer
    protected /* bridge */ /* synthetic */ void onRender(Canvas canvas, RectF rectF, Series series, Formatter formatter, RenderStack renderStack) {
        onRender(canvas, rectF, (BubbleSeries) series, (BubbleSeries) ((BubbleFormatter) formatter), renderStack);
    }

    public BubbleRenderer(XYPlot xYPlot) {
        super(xYPlot);
        this.bubbleScaleMode = BubbleScaleMode.SQUARE_ROOT;
        this.bubbleBounds = new Region(Float.valueOf(PixelUtils.dpToPix(MIN_BUBBLE_RADIUS_DEFAULT_DP)), Float.valueOf(PixelUtils.dpToPix(MAX_BUBBLE_RADIUS_DEFAULT_DP)));
    }

    protected void onRender(Canvas canvas, RectF rectF, BubbleSeries bubbleSeries, FormatterType formattertype, RenderStack renderStack) {
        double doubleValue;
        BubbleSeries bubbleSeries2 = bubbleSeries;
        Region calculateBounds = calculateBounds();
        int i = 0;
        while (i < bubbleSeries2.size()) {
            if (bubbleSeries2.getY(i) != null && bubbleSeries2.getZ(i).doubleValue() > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                PointF transform = getPlot().getBounds().transform(bubbleSeries2.getX(i), bubbleSeries2.getY(i), rectF, false, true);
                if (this.bubbleScaleMode == BubbleScaleMode.SQUARE_ROOT) {
                    doubleValue = Math.sqrt(bubbleSeries2.getZ(i).doubleValue());
                } else {
                    doubleValue = bubbleSeries2.getZ(i).doubleValue();
                }
                drawBubble(canvas, formattertype, bubbleSeries2, i, transform, calculateBounds.transform(doubleValue, this.bubbleBounds).floatValue());
            }
            i++;
            bubbleSeries2 = bubbleSeries;
        }
    }

    protected void drawBubble(Canvas canvas, FormatterType formattertype, BubbleSeries bubbleSeries, int i, PointF pointF, float f) {
        canvas.drawCircle(pointF.x, pointF.y, f, formattertype.getFillPaint());
        canvas.drawCircle(pointF.x, pointF.y, f, formattertype.getStrokePaint());
        if (bubbleSeries == null || !formattertype.hasPointLabelFormatter() || formattertype.getPointLabeler() == null) {
            return;
        }
        FontUtils.drawTextVerticallyCentered(canvas, formattertype.getPointLabeler().getLabel(bubbleSeries, i), pointF.x, pointF.y, formattertype.getPointLabelFormatter().getTextPaint());
    }

    protected void doDrawLegendIcon(Canvas canvas, RectF rectF, FormatterType formattertype) {
        drawBubble(canvas, formattertype, null, 0, new PointF(rectF.centerX(), rectF.centerY()), rectF.width() / 2.5f);
    }

    public float getMinBubbleRadius() {
        return this.bubbleBounds.getMin().floatValue();
    }

    public void setMinBubbleRadius(float f) {
        this.bubbleBounds.setMin(Float.valueOf(f));
    }

    public float getMaxBubbleRadius() {
        return this.bubbleBounds.getMax().floatValue();
    }

    public void setMaxBubbleRadius(float f) {
        this.bubbleBounds.setMax(Float.valueOf(f));
    }

    public BubbleScaleMode getBubbleScaleMode() {
        return this.bubbleScaleMode;
    }

    public void setBubbleScaleMode(BubbleScaleMode bubbleScaleMode) {
        this.bubbleScaleMode = bubbleScaleMode;
    }

    protected Region calculateBounds() {
        Region region = new Region();
        Iterator it = getSeriesAndFormatterList().iterator();
        while (it.hasNext()) {
            SeriesUtils.minMax(region, ((BubbleSeries) ((SeriesBundle) it.next()).getSeries()).getZVals());
        }
        if (region.getMax() == null || region.getMax().doubleValue() <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return null;
        }
        if (this.bubbleScaleMode == BubbleScaleMode.SQUARE_ROOT) {
            region.setMax(Double.valueOf(Math.sqrt(region.getMax().doubleValue())));
        }
        if (region.getMin().doubleValue() > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            if (this.bubbleScaleMode == BubbleScaleMode.SQUARE_ROOT) {
                region.setMin(Double.valueOf(Math.sqrt(region.getMin().doubleValue())));
            }
            return region;
        }
        region.setMax(0);
        return region;
    }
}
