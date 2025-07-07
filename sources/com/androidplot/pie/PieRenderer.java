package com.androidplot.pie;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Region;
import com.androidplot.ui.RenderStack;
import com.androidplot.ui.SeriesBundle;
import com.androidplot.ui.SeriesRenderer;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;
/* loaded from: classes3.dex */
public class PieRenderer extends SeriesRenderer<PieChart, Segment, SegmentFormatter> {
    private static final float FULL_PIE_DEGS = 360.0f;
    private static final float HALF_PIE_DEGS = 180.0f;
    private DonutMode donutMode;
    private float donutSize;
    private float extentDegs;
    private float startDegs;

    /* loaded from: classes3.dex */
    public enum DonutMode {
        PERCENT,
        PIXELS
    }

    protected static float degsToScreenDegs(float f) {
        float f2 = f % FULL_PIE_DEGS;
        return f2 > 0.0f ? FULL_PIE_DEGS - f2 : f2;
    }

    public PieRenderer(PieChart pieChart) {
        super(pieChart);
        this.startDegs = 0.0f;
        this.extentDegs = FULL_PIE_DEGS;
        this.donutSize = 0.5f;
        this.donutMode = DonutMode.PERCENT;
    }

    public float getRadius(RectF rectF) {
        return (rectF.width() < rectF.height() ? rectF.width() : rectF.height()) / 2.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.androidplot.ui.SeriesRenderer
    public void onRender(Canvas canvas, RectF rectF, Segment segment, SegmentFormatter segmentFormatter, RenderStack renderStack) {
        renderStack.disable(getClass());
        float radius = getRadius(rectF);
        PointF pointF = new PointF(rectF.centerX(), rectF.centerY());
        double[] values = getValues();
        double calculateScale = calculateScale(values);
        float degsToScreenDegs = degsToScreenDegs(this.startDegs);
        RectF rectF2 = new RectF(pointF.x - radius, pointF.y - radius, pointF.x + radius, pointF.y + radius);
        float f = degsToScreenDegs;
        int i = 0;
        for (SeriesBundle<Segment, ? extends SegmentFormatter> seriesBundle : getSeriesAndFormatterList()) {
            float f2 = (float) (values[i] * calculateScale * this.extentDegs);
            drawSegment(canvas, rectF2, seriesBundle.getSeries(), seriesBundle.getFormatter(), radius, f, f2);
            i++;
            f += f2;
        }
    }

    protected void drawSegment(Canvas canvas, RectF rectF, Segment segment, SegmentFormatter segmentFormatter, float f, float f2, float f3) {
        float f4;
        float f5;
        float f6;
        float f7;
        Canvas canvas2 = canvas;
        canvas2.save();
        float radialInset = f2 + segmentFormatter.getRadialInset();
        float radialInset2 = f3 - (segmentFormatter.getRadialInset() * 2.0f);
        float f8 = radialInset + (radialInset2 / 2.0f);
        PointF calculateLineEnd = calculateLineEnd(rectF.centerX(), rectF.centerY(), segmentFormatter.getOffset(), f8);
        float f9 = calculateLineEnd.x;
        float f10 = calculateLineEnd.y;
        int i = AnonymousClass1.$SwitchMap$com$androidplot$pie$PieRenderer$DonutMode[this.donutMode.ordinal()];
        if (i == 1) {
            f4 = this.donutSize * f;
        } else if (i == 2) {
            f4 = this.donutSize;
            if (f4 <= 0.0f) {
                f4 = f + f4;
            }
        } else {
            throw new UnsupportedOperationException("Unsupported DonutMde: " + this.donutMode);
        }
        float outerInset = f - segmentFormatter.getOuterInset();
        float innerInset = f4 != 0.0f ? f4 + segmentFormatter.getInnerInset() : 0.0f;
        if (Math.abs(radialInset2 - this.extentDegs) > Float.MIN_VALUE) {
            PointF calculateLineEnd2 = calculateLineEnd(f9, f10, outerInset, radialInset);
            PointF calculateLineEnd3 = calculateLineEnd(f9, f10, innerInset, radialInset);
            float f11 = radialInset + radialInset2;
            PointF calculateLineEnd4 = calculateLineEnd(f9, f10, outerInset, f11);
            PointF calculateLineEnd5 = calculateLineEnd(f9, f10, innerInset, f11);
            f5 = 2.0f;
            Path path = new Path();
            f6 = f8;
            float f12 = innerInset;
            path.arcTo(new RectF(rectF.left - outerInset, rectF.top - outerInset, rectF.right + outerInset, rectF.bottom + outerInset), radialInset, radialInset2);
            path.lineTo(f9, f10);
            path.close();
            canvas2.clipPath(path);
            Path path2 = new Path();
            path2.arcTo(new RectF(f9 - outerInset, f10 - outerInset, f9 + outerInset, f10 + outerInset), radialInset, radialInset2);
            path2.lineTo(calculateLineEnd5.x, calculateLineEnd5.y);
            path2.arcTo(new RectF(f9 - f12, f10 - f12, f9 + f12, f10 + f12), f11, -radialInset2);
            path2.close();
            canvas2.drawPath(path2, segmentFormatter.getFillPaint());
            canvas2.drawLine(calculateLineEnd3.x, calculateLineEnd3.y, calculateLineEnd2.x, calculateLineEnd2.y, segmentFormatter.getRadialEdgePaint());
            canvas2 = canvas;
            canvas2.drawLine(calculateLineEnd5.x, calculateLineEnd5.y, calculateLineEnd4.x, calculateLineEnd4.y, segmentFormatter.getRadialEdgePaint());
            innerInset = f12;
            f7 = outerInset;
        } else {
            f5 = 2.0f;
            f6 = f8;
            canvas2.save();
            Path path3 = new Path();
            f7 = outerInset;
            path3.addCircle(f9, f10, f7, Path.Direction.CW);
            Path path4 = new Path();
            path4.addCircle(f9, f10, innerInset, Path.Direction.CW);
            canvas2.clipPath(path4, Region.Op.DIFFERENCE);
            canvas2.drawPath(path3, segmentFormatter.getFillPaint());
            canvas2.restore();
        }
        canvas2.drawCircle(f9, f10, innerInset, segmentFormatter.getInnerEdgePaint());
        canvas2.drawCircle(f9, f10, f7, segmentFormatter.getOuterEdgePaint());
        canvas2.restore();
        PointF calculateLineEnd6 = calculateLineEnd(f9, f10, f7 - ((f7 - innerInset) / f5), f6);
        if (segmentFormatter.getLabelPaint() != null) {
            drawSegmentLabel(canvas2, calculateLineEnd6, segment, segmentFormatter);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.androidplot.pie.PieRenderer$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$androidplot$pie$PieRenderer$DonutMode;

        static {
            int[] iArr = new int[DonutMode.values().length];
            $SwitchMap$com$androidplot$pie$PieRenderer$DonutMode = iArr;
            try {
                iArr[DonutMode.PERCENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$androidplot$pie$PieRenderer$DonutMode[DonutMode.PIXELS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    protected void drawSegmentLabel(Canvas canvas, PointF pointF, Segment segment, SegmentFormatter segmentFormatter) {
        canvas.drawText(segment.getTitle(), pointF.x, pointF.y, segmentFormatter.getLabelPaint());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.androidplot.ui.SeriesRenderer
    public void doDrawLegendIcon(Canvas canvas, RectF rectF, SegmentFormatter segmentFormatter) {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    protected double calculateScale(double[] dArr) {
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (double d2 : dArr) {
            d += d2;
        }
        return 1.0d / d;
    }

    protected double[] getValues() {
        List<SeriesBundle<Segment, ? extends SegmentFormatter>> seriesAndFormatterList = getSeriesAndFormatterList();
        double[] dArr = new double[seriesAndFormatterList.size()];
        int i = 0;
        for (SeriesBundle<Segment, ? extends SegmentFormatter> seriesBundle : seriesAndFormatterList) {
            dArr[i] = seriesBundle.getSeries().getValue().doubleValue();
            i++;
        }
        return dArr;
    }

    protected PointF calculateLineEnd(float f, float f2, float f3, float f4) {
        return calculateLineEnd(new PointF(f, f2), f3, f4);
    }

    protected PointF calculateLineEnd(PointF pointF, float f, float f2) {
        double d = (f2 * 3.141592653589793d) / 180.0d;
        double d2 = f;
        return new PointF(pointF.x + ((float) (Math.cos(d) * d2)), pointF.y + ((float) (d2 * Math.sin(d))));
    }

    public void setDonutSize(float f, DonutMode donutMode) {
        int i = AnonymousClass1.$SwitchMap$com$androidplot$pie$PieRenderer$DonutMode[donutMode.ordinal()];
        if (i != 1) {
            if (i != 2) {
                throw new UnsupportedOperationException("Not yet implemented.");
            }
        } else if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("Size parameter must be between 0 and 1 when operating in PERCENT mode.");
        }
        this.donutMode = donutMode;
        this.donutSize = f;
    }

    public Segment getContainingSegment(PointF pointF) {
        RectF rectF = getPlot().getPie().getWidgetDimensions().marginatedRect;
        PointF pointF2 = new PointF(rectF.centerX(), rectF.centerY());
        double atan2 = Math.atan2(pointF.y - pointF2.y, pointF.x - pointF2.x) * 57.29577951308232d;
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        double d2 = 360.0d;
        if (atan2 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            atan2 += 360.0d;
        }
        List<SeriesBundle<Segment, ? extends SegmentFormatter>> seriesAndFormatterList = getSeriesAndFormatterList();
        double[] values = getValues();
        double calculateScale = calculateScale(values);
        float degsToScreenDegs = degsToScreenDegs(this.startDegs);
        int i = 0;
        for (SeriesBundle<Segment, ? extends SegmentFormatter> seriesBundle : seriesAndFormatterList) {
            double d3 = d;
            float f = (((float) ((values[i] * calculateScale) * this.extentDegs)) + degsToScreenDegs) % FULL_PIE_DEGS;
            double d4 = f;
            double signedDistance = signedDistance(d4, atan2);
            double d5 = d2;
            double signedDistance2 = signedDistance(d4, degsToScreenDegs);
            if (signedDistance2 < d3) {
                signedDistance2 += d5;
            }
            if (signedDistance > d3 && signedDistance <= signedDistance2) {
                return seriesBundle.getSeries();
            }
            i++;
            degsToScreenDegs = f;
            d = d3;
            d2 = d5;
        }
        return null;
    }

    protected static double signedDistance(double d, double d2) {
        double d3 = d - d2;
        double abs = Math.abs(d3) % 360.0d;
        if (abs > 180.0d) {
            abs = 360.0d - abs;
        }
        return abs * (((d3 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || d3 > 180.0d) && (d3 > -180.0d || d3 < -360.0d)) ? -1 : 1);
    }

    protected static void validateInputDegs(float f) {
        if (f < 0.0f || f > FULL_PIE_DEGS) {
            throw new IllegalArgumentException("Degrees values must be between 0.0 and 360.");
        }
    }

    public void setStartDegs(float f) {
        validateInputDegs(f);
        this.startDegs = f;
    }

    public float getStartDegs() {
        return this.startDegs;
    }

    public void setExtentDegs(float f) {
        validateInputDegs(f);
        this.extentDegs = f;
    }

    public float getExtentDegs() {
        return this.extentDegs;
    }
}
