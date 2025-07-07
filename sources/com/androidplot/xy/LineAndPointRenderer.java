package com.androidplot.xy;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.androidplot.Plot;
import com.androidplot.PlotListener;
import com.androidplot.Region;
import com.androidplot.Series;
import com.androidplot.ui.Formatter;
import com.androidplot.ui.RenderStack;
import com.androidplot.util.SeriesUtils;
import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.OrderedXYSeries;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class LineAndPointRenderer<FormatterType extends LineAndPointFormatter> extends XYSeriesRenderer<XYSeries, FormatterType> {
    protected static final int ONE = 1;
    protected static final int ZERO = 0;
    private final Path path;
    protected final ConcurrentHashMap<XYSeries, ArrayList<PointF>> pointsCaches;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.androidplot.ui.SeriesRenderer
    public /* bridge */ /* synthetic */ void onRender(Canvas canvas, RectF rectF, Series series, Formatter formatter, RenderStack renderStack) {
        onRender(canvas, rectF, (XYSeries) series, (XYSeries) ((LineAndPointFormatter) formatter), renderStack);
    }

    public LineAndPointRenderer(XYPlot xYPlot) {
        super(xYPlot);
        this.path = new Path();
        this.pointsCaches = new ConcurrentHashMap<>(2, 0.75f, 2);
        xYPlot.addListener(new PlotListener() { // from class: com.androidplot.xy.LineAndPointRenderer.1
            @Override // com.androidplot.PlotListener
            public void onAfterDraw(Plot plot, Canvas canvas) {
            }

            @Override // com.androidplot.PlotListener
            public void onBeforeDraw(Plot plot, Canvas canvas) {
                LineAndPointRenderer.this.cullPointsCache();
            }
        });
    }

    public void onRender(Canvas canvas, RectF rectF, XYSeries xYSeries, FormatterType formattertype, RenderStack renderStack) {
        drawSeries(canvas, rectF, xYSeries, formattertype);
    }

    @Override // com.androidplot.ui.SeriesRenderer
    public void doDrawLegendIcon(Canvas canvas, RectF rectF, LineAndPointFormatter lineAndPointFormatter) {
        Canvas canvas2;
        float centerY = rectF.centerY();
        float centerX = rectF.centerX();
        if (lineAndPointFormatter.getFillPaint() != null) {
            canvas.drawRect(rectF, lineAndPointFormatter.getFillPaint());
        }
        if (lineAndPointFormatter.hasLinePaint()) {
            canvas2 = canvas;
            canvas2.drawLine(rectF.left, rectF.bottom, rectF.right, rectF.top, lineAndPointFormatter.getLinePaint());
        } else {
            canvas2 = canvas;
        }
        if (lineAndPointFormatter.hasVertexPaint()) {
            canvas2.drawPoint(centerX, centerY, lineAndPointFormatter.getVertexPaint());
        }
    }

    protected void appendToPath(Path path, PointF pointF, PointF pointF2) {
        path.lineTo(pointF.x, pointF.y);
    }

    protected ArrayList<PointF> getPointsCache(XYSeries xYSeries) {
        ArrayList<PointF> arrayList = this.pointsCaches.get(xYSeries);
        int size = xYSeries.size();
        if (arrayList == null) {
            arrayList = new ArrayList<>(size);
            this.pointsCaches.put(xYSeries, arrayList);
        }
        if (arrayList.size() < size) {
            while (arrayList.size() < size) {
                arrayList.add(null);
            }
        } else if (arrayList.size() > size) {
            while (arrayList.size() > size) {
                arrayList.remove(0);
            }
        }
        return arrayList;
    }

    protected void cullPointsCache() {
        for (XYSeries xYSeries : this.pointsCaches.keySet()) {
            if (!getPlot().getRegistry().contains(xYSeries, LineAndPointFormatter.class)) {
                this.pointsCaches.remove(xYSeries);
            }
        }
    }

    protected void drawSeries(Canvas canvas, RectF rectF, XYSeries xYSeries, LineAndPointFormatter lineAndPointFormatter) {
        int i;
        int i2;
        LineAndPointRenderer<FormatterType> lineAndPointRenderer;
        Canvas canvas2;
        this.path.reset();
        ArrayList<PointF> pointsCache = getPointsCache(xYSeries);
        int size = xYSeries.size();
        if (SeriesUtils.getXYOrder(xYSeries) == OrderedXYSeries.XOrder.ASCENDING) {
            Region iBounds = SeriesUtils.iBounds(xYSeries, getPlot().getBounds());
            int intValue = iBounds.getMin().intValue();
            if (intValue > 0) {
                intValue--;
            }
            int intValue2 = iBounds.getMax().intValue();
            int i3 = intValue2 + 1;
            if (i3 < xYSeries.size() - 1) {
                i = intValue2 + 2;
                i2 = intValue;
            } else {
                i2 = intValue;
                i = i3;
            }
        } else {
            i = size;
            i2 = 0;
        }
        PointF pointF = null;
        PointF pointF2 = null;
        for (int i4 = i2; i4 < i; i4++) {
            Number y = xYSeries.getY(i4);
            Number x = xYSeries.getX(i4);
            PointF pointF3 = pointsCache.get(i4);
            if (y != null && x != null) {
                if (pointF3 == null) {
                    pointF3 = new PointF();
                    pointsCache.set(i4, pointF3);
                }
                getPlot().getBounds().transformScreen(pointF3, x, y, rectF);
            } else {
                pointsCache.set(i4, null);
                pointF3 = null;
            }
            if (lineAndPointFormatter.hasLinePaint() && lineAndPointFormatter.getInterpolationParams() == null) {
                if (pointF3 != null) {
                    if (pointF == null) {
                        this.path.reset();
                        this.path.moveTo(pointF3.x, pointF3.y);
                        pointF = pointF3;
                    }
                    if (pointF2 != null) {
                        appendToPath(this.path, pointF3, pointF2);
                    }
                    pointF2 = pointF3;
                } else {
                    if (pointF2 != null) {
                        renderPath(canvas, rectF, this.path, pointF, pointF2, lineAndPointFormatter);
                    }
                    pointF = null;
                    pointF2 = null;
                }
            }
        }
        if (lineAndPointFormatter.hasLinePaint()) {
            if (lineAndPointFormatter.getInterpolationParams() != null) {
                List<XYCoords> interpolate = getInterpolator(lineAndPointFormatter.getInterpolationParams()).interpolate(xYSeries, lineAndPointFormatter.getInterpolationParams());
                pointF = convertPoint(interpolate.get(0), rectF);
                pointF2 = convertPoint(interpolate.get(interpolate.size() - 1), rectF);
                this.path.reset();
                this.path.moveTo(pointF.x, pointF.y);
                for (int i5 = 1; i5 < interpolate.size(); i5++) {
                    PointF convertPoint = convertPoint(interpolate.get(i5), rectF);
                    this.path.lineTo(convertPoint.x, convertPoint.y);
                }
            }
            if (pointF != null) {
                canvas2 = canvas;
                renderPath(canvas2, rectF, this.path, pointF, pointF2, lineAndPointFormatter);
                lineAndPointRenderer = this;
                lineAndPointRenderer.renderPoints(canvas2, rectF, xYSeries, i2, i, pointsCache, lineAndPointFormatter);
            }
        }
        lineAndPointRenderer = this;
        canvas2 = canvas;
        lineAndPointRenderer.renderPoints(canvas2, rectF, xYSeries, i2, i, pointsCache, lineAndPointFormatter);
    }

    protected Interpolator getInterpolator(InterpolationParams interpolationParams) {
        try {
            return (Interpolator) interpolationParams.getInterpolatorClass().newInstance();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        }
    }

    protected PointF convertPoint(XYCoords xYCoords, RectF rectF) {
        return getPlot().getBounds().transformScreen(xYCoords, rectF);
    }

    protected void renderPoints(Canvas canvas, RectF rectF, XYSeries xYSeries, int i, int i2, List<PointF> list, LineAndPointFormatter lineAndPointFormatter) {
        if (lineAndPointFormatter.hasVertexPaint() || lineAndPointFormatter.hasPointLabelFormatter()) {
            Paint vertexPaint = lineAndPointFormatter.hasVertexPaint() ? lineAndPointFormatter.getVertexPaint() : null;
            boolean hasPointLabelFormatter = lineAndPointFormatter.hasPointLabelFormatter();
            PointLabelFormatter pointLabelFormatter = hasPointLabelFormatter ? lineAndPointFormatter.getPointLabelFormatter() : null;
            PointLabeler pointLabeler = hasPointLabelFormatter ? lineAndPointFormatter.getPointLabeler() : null;
            while (i < i2) {
                PointF pointF = list.get(i);
                if (pointF != null) {
                    if (vertexPaint != null) {
                        canvas.drawPoint(pointF.x, pointF.y, vertexPaint);
                    }
                    if (pointLabeler != null) {
                        canvas.drawText(pointLabeler.getLabel(xYSeries, i), pointF.x + pointLabelFormatter.hOffset, pointF.y + pointLabelFormatter.vOffset, pointLabelFormatter.getTextPaint());
                    }
                }
                i++;
            }
        }
    }

    protected void renderPath(Canvas canvas, RectF rectF, Path path, PointF pointF, PointF pointF2, LineAndPointFormatter lineAndPointFormatter) {
        RectF asRectF;
        Path path2 = new Path(path);
        int i = AnonymousClass2.$SwitchMap$com$androidplot$xy$FillDirection[lineAndPointFormatter.getFillDirection().ordinal()];
        if (i == 1) {
            path.lineTo(pointF2.x, rectF.bottom);
            path.lineTo(pointF.x, rectF.bottom);
            path.close();
        } else if (i == 2) {
            path.lineTo(pointF2.x, rectF.top);
            path.lineTo(pointF.x, rectF.top);
            path.close();
        } else if (i == 3) {
            float transform = (float) getPlot().getBounds().getxRegion().transform(getPlot().getRangeOrigin().doubleValue(), rectF.top, rectF.bottom, true);
            path.lineTo(pointF2.x, transform);
            path.lineTo(pointF.x, transform);
            path.close();
        } else {
            throw new UnsupportedOperationException("Fill direction not yet implemented: " + lineAndPointFormatter.getFillDirection());
        }
        if (lineAndPointFormatter.getFillPaint() != null) {
            canvas.drawPath(path, lineAndPointFormatter.getFillPaint());
        }
        RectRegion bounds = getPlot().getBounds();
        RectRegion rectRegion = new RectRegion(rectF);
        for (RectRegion rectRegion2 : bounds.intersects(lineAndPointFormatter.getRegions().elements())) {
            XYRegionFormatter regionFormatter = lineAndPointFormatter.getRegionFormatter(rectRegion2);
            RectRegion transform2 = bounds.transform(rectRegion2, rectRegion, false, true);
            transform2.intersect(rectRegion);
            if (rectRegion2.isFullyDefined() && (asRectF = transform2.asRectF()) != null) {
                try {
                    canvas.save();
                    canvas.clipPath(path);
                    canvas.drawRect(asRectF, regionFormatter.getPaint());
                } finally {
                    canvas.restore();
                }
            }
        }
        if (lineAndPointFormatter.hasLinePaint()) {
            canvas.drawPath(path2, lineAndPointFormatter.getLinePaint());
        }
        path.rewind();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.androidplot.xy.LineAndPointRenderer$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$androidplot$xy$FillDirection;

        static {
            int[] iArr = new int[FillDirection.values().length];
            $SwitchMap$com$androidplot$xy$FillDirection = iArr;
            try {
                iArr[FillDirection.BOTTOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$androidplot$xy$FillDirection[FillDirection.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$androidplot$xy$FillDirection[FillDirection.RANGE_ORIGIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
