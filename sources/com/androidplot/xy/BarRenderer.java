package com.androidplot.xy;

import android.graphics.Canvas;
import android.graphics.RectF;
import com.androidplot.ui.RenderStack;
import com.androidplot.ui.SeriesBundle;
import com.androidplot.util.PixelUtils;
import com.androidplot.util.RectFUtils;
import com.androidplot.xy.BarFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class BarRenderer<FormatterType extends BarFormatter> extends GroupRenderer<FormatterType> {
    private BarGroupWidthMode barGroupWidthMode;
    private BarOrientation barOrientation;
    private float width;

    /* loaded from: classes3.dex */
    public enum BarGroupWidthMode {
        FIXED_WIDTH,
        FIXED_GAP
    }

    /* loaded from: classes3.dex */
    public enum BarOrientation {
        IN_ORDER,
        OVERLAID,
        STACKED,
        SIDE_BY_SIDE
    }

    public FormatterType getFormatter(int i, XYSeries xYSeries) {
        return null;
    }

    public BarRenderer(XYPlot xYPlot) {
        super(xYPlot);
        this.barOrientation = BarOrientation.OVERLAID;
        this.barGroupWidthMode = BarGroupWidthMode.FIXED_WIDTH;
        this.width = PixelUtils.dpToPix(3.0f);
    }

    public void setBarOrientation(BarOrientation barOrientation) {
        this.barOrientation = barOrientation;
    }

    public BarOrientation getBarOrientation() {
        return this.barOrientation;
    }

    public BarGroupWidthMode getBarGroupWidthMode() {
        return this.barGroupWidthMode;
    }

    public float getBarGroupWidth() {
        return this.width;
    }

    public void setBarGroupWidth(BarGroupWidthMode barGroupWidthMode, float f) {
        this.barGroupWidthMode = barGroupWidthMode;
        this.width = f;
    }

    protected BarComparator getBarComparator(float f) {
        return new BarComparator(getBarOrientation(), f);
    }

    @Override // com.androidplot.ui.SeriesRenderer
    public void doDrawLegendIcon(Canvas canvas, RectF rectF, BarFormatter barFormatter) {
        if (barFormatter.hasFillPaint()) {
            canvas.drawRect(rectF, barFormatter.getFillPaint());
        }
        canvas.drawRect(rectF, barFormatter.getBorderPaint());
    }

    @Override // com.androidplot.xy.GroupRenderer
    public void onRender(Canvas canvas, RectF rectF, List<SeriesBundle<XYSeries, ? extends FormatterType>> list, int i, RenderStack renderStack) {
        ArrayList<BarGroup> arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            BarGroup barGroup = new BarGroup(i2, 0.0f, rectF);
            int i3 = 0;
            for (SeriesBundle<XYSeries, ? extends FormatterType> seriesBundle : list) {
                if (seriesBundle.getSeries().getX(i2) != null) {
                    Bar bar = new Bar(getPlot(), seriesBundle.getSeries(), seriesBundle.getFormatter(), i3, i2, rectF);
                    barGroup.addBar(bar);
                    barGroup.centerPix = bar.xPix;
                }
                i3++;
            }
            arrayList.add(barGroup);
        }
        int size = arrayList.size();
        for (BarGroup barGroup2 : arrayList) {
            int i4 = AnonymousClass1.$SwitchMap$com$androidplot$xy$BarRenderer$BarGroupWidthMode[this.barGroupWidthMode.ordinal()];
            if (i4 == 1) {
                barGroup2.leftPix = barGroup2.centerPix - (this.width / 2.0f);
                barGroup2.rightPix = barGroup2.leftPix + this.width;
            } else if (i4 == 2) {
                float width = rectF.width();
                if (size > 1) {
                    width = (((BarGroup) arrayList.get(1)).centerPix - ((BarGroup) arrayList.get(0)).centerPix) - this.width;
                }
                float f = width / 2.0f;
                barGroup2.leftPix = barGroup2.centerPix - f;
                barGroup2.rightPix = barGroup2.centerPix + f;
            }
            float transform = (float) getPlot().getBounds().yRegion.transform(getPlot().getRangeOrigin().doubleValue(), rectF.top, rectF.bottom, true);
            BarComparator barComparator = getBarComparator(transform);
            int i5 = AnonymousClass1.$SwitchMap$com$androidplot$xy$BarRenderer$BarOrientation[this.barOrientation.ordinal()];
            if (i5 == 1 || i5 == 2) {
                Collections.sort(barGroup2.bars, barComparator);
                Iterator<Bar> it = barGroup2.bars.iterator();
                while (it.hasNext()) {
                    Bar next = it.next();
                    drawBar(canvas, next, createBarRect(next.barGroup.leftPix, next.yPix, next.barGroup.rightPix, transform, next.formatter));
                }
            } else if (i5 == 3) {
                float width2 = barGroup2.getWidth() / barGroup2.bars.size();
                float f2 = barGroup2.leftPix;
                Collections.sort(barGroup2.bars, barComparator);
                Iterator<Bar> it2 = barGroup2.bars.iterator();
                float f3 = f2;
                while (it2.hasNext()) {
                    Bar next2 = it2.next();
                    float f4 = transform;
                    float f5 = f3 + width2;
                    drawBar(canvas, next2, createBarRect(f3, next2.yPix, f5, f4, next2.formatter));
                    f3 = f5;
                    transform = f4;
                }
            } else if (i5 == 4) {
                float f6 = (int) barGroup2.plotArea.bottom;
                Collections.sort(barGroup2.bars, barComparator);
                Iterator<Bar> it3 = barGroup2.bars.iterator();
                while (true) {
                    float f7 = f6;
                    if (it3.hasNext()) {
                        Bar next3 = it3.next();
                        f6 = f7 - (((int) next3.barGroup.plotArea.bottom) - next3.yPix);
                        drawBar(canvas, next3, createBarRect(next3.barGroup.leftPix, f6, next3.barGroup.rightPix, f7, next3.formatter));
                    }
                }
            } else {
                throw new UnsupportedOperationException("Unexpected BarOrientation: " + this.barOrientation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.androidplot.xy.BarRenderer$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$androidplot$xy$BarRenderer$BarGroupWidthMode;
        static final /* synthetic */ int[] $SwitchMap$com$androidplot$xy$BarRenderer$BarOrientation;

        static {
            int[] iArr = new int[BarOrientation.values().length];
            $SwitchMap$com$androidplot$xy$BarRenderer$BarOrientation = iArr;
            try {
                iArr[BarOrientation.IN_ORDER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$androidplot$xy$BarRenderer$BarOrientation[BarOrientation.OVERLAID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$androidplot$xy$BarRenderer$BarOrientation[BarOrientation.SIDE_BY_SIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$androidplot$xy$BarRenderer$BarOrientation[BarOrientation.STACKED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[BarGroupWidthMode.values().length];
            $SwitchMap$com$androidplot$xy$BarRenderer$BarGroupWidthMode = iArr2;
            try {
                iArr2[BarGroupWidthMode.FIXED_WIDTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$androidplot$xy$BarRenderer$BarGroupWidthMode[BarGroupWidthMode.FIXED_GAP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    protected RectF createBarRect(float f, float f2, float f3, float f4, BarFormatter barFormatter) {
        RectF createFromEdges = RectFUtils.createFromEdges(f, f2, f3, f4);
        createFromEdges.left += barFormatter.getMarginLeft();
        createFromEdges.right -= barFormatter.getMarginRight();
        createFromEdges.top += barFormatter.getMarginTop();
        createFromEdges.bottom -= barFormatter.getMarginBottom();
        return createFromEdges;
    }

    protected void drawBar(Canvas canvas, Bar<FormatterType> bar, RectF rectF) {
        if (bar.getY() == null) {
            return;
        }
        FormatterType formatter = getFormatter(bar.i, bar.series);
        if (formatter == null) {
            formatter = bar.formatter;
        }
        if (rectF.height() > 0.0f && rectF.width() > 0.0f) {
            if (formatter.hasFillPaint()) {
                canvas.drawRect(rectF.left, rectF.top, rectF.right, rectF.bottom, formatter.getFillPaint());
            }
            if (formatter.hasLinePaint()) {
                canvas.drawRect(rectF.left, rectF.top, rectF.right, rectF.bottom, formatter.getBorderPaint());
            }
        }
        PointLabelFormatter pointLabelFormatter = formatter.hasPointLabelFormatter() ? formatter.getPointLabelFormatter() : null;
        PointLabeler pointLabeler = formatter != null ? formatter.getPointLabeler() : null;
        if (pointLabelFormatter == null || !pointLabelFormatter.hasTextPaint() || pointLabeler == null) {
            return;
        }
        canvas.drawText(pointLabeler.getLabel(bar.series, bar.i), rectF.centerX() + pointLabelFormatter.hOffset, bar.yPix + pointLabelFormatter.vOffset, pointLabelFormatter.getTextPaint());
    }

    /* loaded from: classes3.dex */
    public static class Bar<FormatterType extends BarFormatter> {
        protected BarGroup barGroup;
        public final FormatterType formatter;
        public final int i;
        public final XYSeries series;
        public final int seriesOrder;
        public final float xPix;
        public final float yPix;

        public Bar(XYPlot xYPlot, XYSeries xYSeries, FormatterType formattertype, int i, int i2, RectF rectF) {
            this.series = xYSeries;
            this.formatter = formattertype;
            this.i = i2;
            this.seriesOrder = i;
            this.xPix = (float) xYPlot.getBounds().getxRegion().transform(xYSeries.getX(i2).doubleValue(), rectF.left, rectF.right, false);
            if (xYSeries.getY(i2) != null) {
                this.yPix = (float) xYPlot.getBounds().yRegion.transform(xYSeries.getY(i2).doubleValue(), rectF.top, rectF.bottom, true);
                return;
            }
            this.yPix = 0.0f;
        }

        public Number getY() {
            return this.series.getY(this.i);
        }
    }

    /* loaded from: classes3.dex */
    private static class BarGroup {
        public ArrayList<Bar> bars = new ArrayList<>();
        public float centerPix;
        public int i;
        public float leftPix;
        public RectF plotArea;
        public float rightPix;

        public BarGroup(int i, float f, RectF rectF) {
            this.centerPix = f;
            this.plotArea = rectF;
            this.i = i;
        }

        public void addBar(Bar bar) {
            bar.barGroup = this;
            this.bars.add(bar);
        }

        protected float getWidth() {
            return this.rightPix - this.leftPix;
        }
    }

    /* loaded from: classes3.dex */
    public static class BarComparator implements Comparator<Bar> {
        private final BarOrientation barOrientation;
        private final float rangeOriginPx;

        public BarComparator(BarOrientation barOrientation, float f) {
            this.rangeOriginPx = f;
            this.barOrientation = barOrientation;
        }

        @Override // java.util.Comparator
        public int compare(Bar bar, Bar bar2) {
            if (AnonymousClass1.$SwitchMap$com$androidplot$xy$BarRenderer$BarOrientation[this.barOrientation.ordinal()] == 2) {
                if (bar.yPix > this.rangeOriginPx && bar2.yPix > this.rangeOriginPx) {
                    return Float.valueOf(bar2.yPix).compareTo(Float.valueOf(bar.yPix));
                }
                return Float.valueOf(bar.yPix).compareTo(Float.valueOf(bar2.yPix));
            }
            return Integer.valueOf(bar.seriesOrder).compareTo(Integer.valueOf(bar2.seriesOrder));
        }
    }
}
