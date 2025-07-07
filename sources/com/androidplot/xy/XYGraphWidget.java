package com.androidplot.xy;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Region;
import androidx.core.view.InputDeviceCompat;
import com.androidplot.R;
import com.androidplot.Region;
import com.androidplot.ui.Insets;
import com.androidplot.ui.LayoutManager;
import com.androidplot.ui.RenderStack;
import com.androidplot.ui.Size;
import com.androidplot.ui.widget.Widget;
import com.androidplot.util.AttrUtils;
import com.androidplot.util.FontUtils;
import com.androidplot.util.PixelUtils;
import com.androidplot.util.RectFUtils;
import com.google.firebase.crashlytics.internal.common.IdManager;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public class XYGraphWidget extends Widget {
    private static final float DEFAULT_LINE_LABEL_TEXT_SIZE_PX = PixelUtils.spToPix(15.0f);
    private static final float FUDGE = 1.0E-5f;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int ZERO = 0;
    private CursorLabelFormatter cursorLabelFormatter;
    private Paint domainCursorPaint;
    private Float domainCursorPosition;
    private Paint domainGridLinePaint;
    private Paint domainOriginLinePaint;
    private Paint domainSubGridLinePaint;
    private boolean drawGridOnTop;
    private boolean drawMarkersEnabled;
    private Paint gridBackgroundPaint;
    private Insets gridInsets;
    private RectF gridRect;
    private boolean isGridClippingEnabled;
    private RectF labelRect;
    private float lineExtensionBottom;
    private float lineExtensionLeft;
    private float lineExtensionRight;
    private float lineExtensionTop;
    private EnumSet<Edge> lineLabelEdges;
    private Insets lineLabelInsets;
    private Map<Edge, LineLabelRenderer> lineLabelRenderers;
    private Map<Edge, LineLabelStyle> lineLabelStyles;
    private int linesPerDomainLabel;
    private int linesPerRangeLabel;
    private XYPlot plot;
    private Paint rangeCursorPaint;
    private Float rangeCursorPosition;
    private Paint rangeGridLinePaint;
    private Paint rangeOriginLinePaint;
    private Paint rangeSubGridLinePaint;
    private RenderStack<? extends XYSeries, ? extends XYSeriesFormatter> renderStack;

    /* loaded from: classes3.dex */
    public interface CursorLabelFormatter {
        Paint getBackgroundPaint();

        String getLabelText(Number number, Number number2);

        Paint getTextPaint();
    }

    /* loaded from: classes3.dex */
    public static class LineLabelRenderer {
        public void drawLabel(Canvas canvas, LineLabelStyle lineLabelStyle, Number number, float f, float f2, boolean z) {
            Canvas canvas2;
            int save = canvas.save();
            try {
                String format = lineLabelStyle.format.format(number);
                canvas.rotate(lineLabelStyle.getRotation(), f, f2);
                canvas2 = canvas;
                try {
                    drawLabel(canvas2, format, lineLabelStyle.getPaint(), f, f2, z);
                    canvas2.restoreToCount(save);
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    canvas2.restoreToCount(save);
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
                canvas2 = canvas;
            }
        }

        protected void drawLabel(Canvas canvas, String str, Paint paint, float f, float f2, boolean z) {
            canvas.drawText(str, f, f2, paint);
        }
    }

    /* loaded from: classes3.dex */
    public static class LineLabelStyle {
        private Paint paint = new Paint();
        private float rotation = 0.0f;
        private Format format = new DecimalFormat(IdManager.DEFAULT_VERSION_NAME);

        public LineLabelStyle() {
            this.paint.setColor(-3355444);
            this.paint.setAntiAlias(true);
            this.paint.setTextAlign(Paint.Align.CENTER);
            this.paint.setTextSize(XYGraphWidget.DEFAULT_LINE_LABEL_TEXT_SIZE_PX);
        }

        public Format getFormat() {
            return this.format;
        }

        public void setFormat(Format format) {
            this.format = format;
        }

        public float getRotation() {
            return this.rotation;
        }

        public void setRotation(float f) {
            this.rotation = f;
        }

        public Paint getPaint() {
            return this.paint;
        }

        public void setPaint(Paint paint) {
            this.paint = paint;
        }
    }

    /* loaded from: classes3.dex */
    public enum Edge {
        NONE(0),
        LEFT(1),
        RIGHT(2),
        TOP(4),
        BOTTOM(8);
        
        private final int value;

        Edge(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public XYGraphWidget(LayoutManager layoutManager, XYPlot xYPlot, Size size) {
        super(layoutManager, size);
        this.linesPerRangeLabel = 1;
        this.linesPerDomainLabel = 1;
        this.gridInsets = new Insets();
        this.lineLabelInsets = new Insets();
        this.isGridClippingEnabled = true;
        this.drawMarkersEnabled = true;
        this.lineLabelEdges = EnumSet.noneOf(Edge.class);
        this.lineLabelStyles = getDefaultLineLabelStyles();
        this.lineLabelRenderers = getDefaultLineLabelRenderers();
        Paint paint = new Paint();
        this.gridBackgroundPaint = paint;
        paint.setColor(Color.rgb(140, 140, 140));
        this.gridBackgroundPaint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        paint2.setColor(Color.rgb(180, 180, 180));
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.STROKE);
        this.rangeGridLinePaint = new Paint(paint2);
        this.domainGridLinePaint = new Paint(paint2);
        this.domainSubGridLinePaint = new Paint(paint2);
        this.rangeSubGridLinePaint = new Paint(paint2);
        this.domainOriginLinePaint = new Paint(paint2);
        this.rangeOriginLinePaint = new Paint(paint2);
        Paint paint3 = new Paint();
        this.domainCursorPaint = paint3;
        paint3.setColor(InputDeviceCompat.SOURCE_ANY);
        Paint paint4 = new Paint();
        this.rangeCursorPaint = paint4;
        paint4.setColor(InputDeviceCompat.SOURCE_ANY);
        setMarginTop(7.0f);
        setMarginRight(4.0f);
        setMarginBottom(4.0f);
        setClippingEnabled(true);
        this.plot = xYPlot;
        this.renderStack = new RenderStack<>(xYPlot);
    }

    public void processAttrs(TypedArray typedArray) {
        setDrawGridOnTop(typedArray.getBoolean(R.styleable.xy_XYPlot_drawGridOnTop, isDrawGridOnTop()));
        int i = typedArray.getInt(R.styleable.xy_XYPlot_lineLabels, 0);
        if (i != 0) {
            setLineLabelEdges(i);
        }
        setGridClippingEnabled(typedArray.getBoolean(R.styleable.xy_XYPlot_gridClippingEnabled, isGridClippingEnabled()));
        LineLabelStyle lineLabelStyle = getLineLabelStyle(Edge.TOP);
        LineLabelStyle lineLabelStyle2 = getLineLabelStyle(Edge.BOTTOM);
        LineLabelStyle lineLabelStyle3 = getLineLabelStyle(Edge.LEFT);
        LineLabelStyle lineLabelStyle4 = getLineLabelStyle(Edge.RIGHT);
        lineLabelStyle.setRotation(typedArray.getFloat(R.styleable.xy_XYPlot_lineLabelRotationTop, lineLabelStyle.getRotation()));
        lineLabelStyle2.setRotation(typedArray.getFloat(R.styleable.xy_XYPlot_lineLabelRotationBottom, lineLabelStyle2.getRotation()));
        lineLabelStyle3.setRotation(typedArray.getFloat(R.styleable.xy_XYPlot_lineLabelRotationLeft, lineLabelStyle3.getRotation()));
        lineLabelStyle4.setRotation(typedArray.getFloat(R.styleable.xy_XYPlot_lineLabelRotationRight, lineLabelStyle4.getRotation()));
        setLineExtensionTop(typedArray.getDimension(R.styleable.xy_XYPlot_lineExtensionTop, getLineExtensionTop()));
        setLineExtensionBottom(typedArray.getDimension(R.styleable.xy_XYPlot_lineExtensionBottom, getLineExtensionBottom()));
        setLineExtensionLeft(typedArray.getDimension(R.styleable.xy_XYPlot_lineExtensionLeft, getLineExtensionLeft()));
        setLineExtensionRight(typedArray.getDimension(R.styleable.xy_XYPlot_lineExtensionRight, getLineExtensionRight()));
        AttrUtils.configureTextPaint(typedArray, lineLabelStyle.getPaint(), R.styleable.xy_XYPlot_lineLabelTextColorTop, R.styleable.xy_XYPlot_lineLabelTextSizeTop, Integer.valueOf(R.styleable.xy_XYPlot_lineLabelAlignTop));
        AttrUtils.configureTextPaint(typedArray, lineLabelStyle2.getPaint(), R.styleable.xy_XYPlot_lineLabelTextColorBottom, R.styleable.xy_XYPlot_lineLabelTextSizeBottom, Integer.valueOf(R.styleable.xy_XYPlot_lineLabelAlignBottom));
        AttrUtils.configureTextPaint(typedArray, lineLabelStyle3.getPaint(), R.styleable.xy_XYPlot_lineLabelTextColorLeft, R.styleable.xy_XYPlot_lineLabelTextSizeLeft, Integer.valueOf(R.styleable.xy_XYPlot_lineLabelAlignLeft));
        AttrUtils.configureTextPaint(typedArray, lineLabelStyle4.getPaint(), R.styleable.xy_XYPlot_lineLabelTextColorRight, R.styleable.xy_XYPlot_lineLabelTextSizeRight, Integer.valueOf(R.styleable.xy_XYPlot_lineLabelAlignRight));
        AttrUtils.configureInsets(typedArray, getGridInsets(), R.styleable.xy_XYPlot_gridInsetTop, R.styleable.xy_XYPlot_gridInsetBottom, R.styleable.xy_XYPlot_gridInsetLeft, R.styleable.xy_XYPlot_gridInsetRight);
        AttrUtils.configureInsets(typedArray, getLineLabelInsets(), R.styleable.xy_XYPlot_lineLabelInsetTop, R.styleable.xy_XYPlot_lineLabelInsetBottom, R.styleable.xy_XYPlot_lineLabelInsetLeft, R.styleable.xy_XYPlot_lineLabelInsetRight);
        AttrUtils.configureWidget(typedArray, this, R.styleable.xy_XYPlot_graphHeightMode, R.styleable.xy_XYPlot_graphHeight, R.styleable.xy_XYPlot_graphWidthMode, R.styleable.xy_XYPlot_graphWidth, R.styleable.xy_XYPlot_graphHorizontalPositioning, R.styleable.xy_XYPlot_graphHorizontalPosition, R.styleable.xy_XYPlot_graphVerticalPositioning, R.styleable.xy_XYPlot_graphVerticalPosition, R.styleable.xy_XYPlot_graphAnchor, R.styleable.xy_XYPlot_graphVisible);
        AttrUtils.configureWidget(typedArray, this, R.styleable.xy_XYPlot_domainTitleHeightMode, R.styleable.xy_XYPlot_domainTitleHeight, R.styleable.xy_XYPlot_domainTitleWidthMode, R.styleable.xy_XYPlot_domainTitleWidth, R.styleable.xy_XYPlot_domainTitleHorizontalPositioning, R.styleable.xy_XYPlot_domainTitleHorizontalPosition, R.styleable.xy_XYPlot_domainTitleVerticalPositioning, R.styleable.xy_XYPlot_domainTitleVerticalPosition, R.styleable.xy_XYPlot_domainTitleAnchor, R.styleable.xy_XYPlot_domainTitleVisible);
        AttrUtils.configureWidget(typedArray, this, R.styleable.xy_XYPlot_rangeTitleHeightMode, R.styleable.xy_XYPlot_rangeTitleHeight, R.styleable.xy_XYPlot_rangeTitleWidthMode, R.styleable.xy_XYPlot_rangeTitleWidth, R.styleable.xy_XYPlot_rangeTitleHorizontalPositioning, R.styleable.xy_XYPlot_rangeTitleHorizontalPosition, R.styleable.xy_XYPlot_rangeTitleVerticalPositioning, R.styleable.xy_XYPlot_rangeTitleVerticalPosition, R.styleable.xy_XYPlot_rangeTitleAnchor, R.styleable.xy_XYPlot_rangeTitleVisible);
        AttrUtils.configureWidgetRotation(typedArray, this, R.styleable.xy_XYPlot_graphRotation);
        AttrUtils.configureBoxModelable(typedArray, this, R.styleable.xy_XYPlot_graphMarginTop, R.styleable.xy_XYPlot_graphMarginBottom, R.styleable.xy_XYPlot_graphMarginLeft, R.styleable.xy_XYPlot_graphMarginRight, R.styleable.xy_XYPlot_graphPaddingTop, R.styleable.xy_XYPlot_graphPaddingBottom, R.styleable.xy_XYPlot_graphPaddingLeft, R.styleable.xy_XYPlot_graphPaddingRight);
        AttrUtils.configureLinePaint(typedArray, getDomainOriginLinePaint(), R.styleable.xy_XYPlot_domainOriginLineColor, R.styleable.xy_XYPlot_domainOriginLineThickness);
        AttrUtils.configureLinePaint(typedArray, getRangeOriginLinePaint(), R.styleable.xy_XYPlot_rangeOriginLineColor, R.styleable.xy_XYPlot_rangeOriginLineThickness);
        AttrUtils.configureLinePaint(typedArray, getDomainGridLinePaint(), R.styleable.xy_XYPlot_domainLineColor, R.styleable.xy_XYPlot_domainLineThickness);
        AttrUtils.configureLinePaint(typedArray, getRangeGridLinePaint(), R.styleable.xy_XYPlot_rangeLineColor, R.styleable.xy_XYPlot_rangeLineThickness);
        AttrUtils.setColor(typedArray, getBackgroundPaint(), R.styleable.xy_XYPlot_graphBackgroundColor);
        AttrUtils.setColor(typedArray, getGridBackgroundPaint(), R.styleable.xy_XYPlot_gridBackgroundColor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public XYCoords screenToSeries(PointF pointF) {
        if (this.plot.getBounds().isFullyDefined()) {
            return new RectRegion(this.gridRect).transform((Number) Float.valueOf(pointF.x), (Number) Float.valueOf(pointF.y), this.plot.getBounds(), false, true);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Number screenToSeriesX(PointF pointF) {
        return screenToSeriesX(pointF.x);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Number screenToSeriesY(PointF pointF) {
        return screenToSeriesY(pointF.y);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Number screenToSeriesX(float f) {
        if (this.plot.getBounds().xRegion.isDefined()) {
            return new Region(Float.valueOf(this.gridRect.left), Float.valueOf(this.gridRect.right)).transform(f, this.plot.getBounds().getxRegion());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Number screenToSeriesY(float f) {
        if (this.plot.getBounds().getyRegion().isDefined()) {
            return new Region(Float.valueOf(this.gridRect.top), Float.valueOf(this.gridRect.bottom)).transform(f, this.plot.getBounds().getyRegion(), true);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PointF seriesToScreen(XYCoords xYCoords) {
        if (this.plot.getBounds().isFullyDefined()) {
            return this.plot.getBounds().transform(xYCoords, this.gridRect, false, true);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float seriesToScreenX(Number number) {
        return (float) this.plot.getBounds().getxRegion().transform(number.doubleValue(), this.gridRect.left, this.gridRect.right, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float seriesToScreenY(Number number) {
        return (float) this.plot.getBounds().getyRegion().transform(number.doubleValue(), this.gridRect.bottom, this.gridRect.top, true);
    }

    @Override // com.androidplot.ui.widget.Widget
    protected void onResize(RectF rectF, RectF rectF2) {
        recalculateSizes(rectF2);
    }

    protected void recalculateSizes(RectF rectF) {
        if (rectF == null) {
            rectF = getWidgetDimensions().paddedRect;
        }
        this.gridRect = RectFUtils.applyInsets(rectF, this.gridInsets);
        this.labelRect = RectFUtils.applyInsets(rectF, this.lineLabelInsets);
    }

    @Override // com.androidplot.ui.widget.Widget
    protected void doOnDraw(Canvas canvas, RectF rectF) {
        if (this.gridRect.height() <= 0.0f || this.gridRect.width() <= 0.0f) {
            return;
        }
        RectRegion bounds = this.plot.getBounds();
        if (bounds.getMinX() == null || bounds.getMaxX() == null || bounds.getMinY() == null || bounds.getMaxY() == null) {
            return;
        }
        if (this.drawGridOnTop) {
            drawData(canvas);
            drawGrid(canvas);
        } else {
            drawGrid(canvas);
            drawData(canvas);
        }
        drawCursors(canvas);
        if (isDrawMarkersEnabled()) {
            drawMarkers(canvas);
        }
    }

    protected void drawDomainLine(Canvas canvas, float f, Number number, Paint paint, boolean z, boolean z2) {
        if (paint != null) {
            canvas.drawLine(f, this.gridRect.top - this.lineExtensionTop, f, this.gridRect.bottom + this.lineExtensionBottom, paint);
        }
        if (z2) {
            if (isLineLabelEnabled(Edge.TOP)) {
                drawLineLabel(canvas, Edge.TOP, number, f, this.labelRect.top, z);
            }
            if (isLineLabelEnabled(Edge.BOTTOM)) {
                drawLineLabel(canvas, Edge.BOTTOM, number, f, this.labelRect.bottom, z);
            }
        }
    }

    protected void drawRangeLine(Canvas canvas, float f, Number number, Paint paint, boolean z, boolean z2) {
        if (paint != null) {
            canvas.drawLine(this.gridRect.left - this.lineExtensionLeft, f, this.gridRect.right + this.lineExtensionRight, f, paint);
        }
        if (z2) {
            if (isLineLabelEnabled(Edge.LEFT)) {
                drawLineLabel(canvas, Edge.LEFT, number, this.labelRect.left, f, z);
            }
            if (isLineLabelEnabled(Edge.RIGHT)) {
                drawLineLabel(canvas, Edge.RIGHT, number, this.labelRect.right, f, z);
            }
        }
    }

    protected void drawLineLabel(Canvas canvas, Edge edge, Number number, float f, float f2, boolean z) {
        getLineLabelRenderer(edge).drawLabel(canvas, getLineLabelStyle(edge), number, f, f2, z);
    }

    protected void drawGrid(Canvas canvas) {
        double d;
        double d2;
        double d3;
        Paint paint;
        double d4;
        Paint paint2;
        XYGraphWidget xYGraphWidget = this;
        if (!xYGraphWidget.drawGridOnTop) {
            drawGridBackground(canvas);
        }
        Number domainOrigin = xYGraphWidget.plot.getDomainOrigin();
        if (domainOrigin != null) {
            d = xYGraphWidget.plot.getBounds().getxRegion().transform(xYGraphWidget.plot.getDomainOrigin().doubleValue(), xYGraphWidget.gridRect.left, xYGraphWidget.gridRect.right, false);
        } else {
            d = xYGraphWidget.gridRect.left;
            domainOrigin = xYGraphWidget.plot.getBounds().getMinX();
        }
        Number number = domainOrigin;
        double d5 = d;
        Step step = XYStepCalculator.getStep(xYGraphWidget.plot, Axis.DOMAIN, xYGraphWidget.gridRect);
        double stepPix = step.getStepPix();
        double d6 = 9.999999747378752E-6d;
        double d7 = ((xYGraphWidget.gridRect.right - d5) + 9.999999747378752E-6d) / stepPix;
        int ceil = (int) Math.ceil(((xYGraphWidget.gridRect.left - d5) - 9.999999747378752E-6d) / stepPix);
        while (true) {
            double d8 = ceil;
            if (d8 > d7) {
                break;
            }
            double doubleValue = number.doubleValue() + (step.getStepVal() * d8);
            double d9 = (d8 * stepPix) + d5;
            boolean z = ceil % xYGraphWidget.getLinesPerDomainLabel() == 0;
            boolean z2 = ceil == 0;
            if (z2) {
                d4 = d6;
                paint2 = xYGraphWidget.domainOriginLinePaint;
            } else {
                d4 = d6;
                if (z) {
                    paint2 = xYGraphWidget.domainGridLinePaint;
                } else {
                    paint2 = xYGraphWidget.domainSubGridLinePaint;
                }
            }
            xYGraphWidget.drawDomainLine(canvas, (float) d9, Double.valueOf(doubleValue), paint2, z2, z);
            ceil++;
            d6 = d4;
        }
        double d10 = d6;
        Number rangeOrigin = xYGraphWidget.plot.getRangeOrigin();
        if (rangeOrigin != null) {
            d2 = xYGraphWidget.plot.getBounds().getyRegion().transform(rangeOrigin.doubleValue(), xYGraphWidget.gridRect.top, xYGraphWidget.gridRect.bottom, true);
        } else {
            d2 = xYGraphWidget.gridRect.bottom;
            rangeOrigin = xYGraphWidget.plot.getBounds().getMinY();
        }
        Number number2 = rangeOrigin;
        double d11 = d2;
        Step step2 = XYStepCalculator.getStep(xYGraphWidget.plot, Axis.RANGE, xYGraphWidget.gridRect);
        double stepPix2 = step2.getStepPix();
        double d12 = ((xYGraphWidget.gridRect.bottom - d11) + d10) / stepPix2;
        int ceil2 = (int) Math.ceil(((xYGraphWidget.gridRect.top - d11) - d10) / stepPix2);
        while (true) {
            double d13 = ceil2;
            if (d13 > d12) {
                return;
            }
            double doubleValue2 = number2.doubleValue() - (step2.getStepVal() * d13);
            double d14 = (d13 * stepPix2) + d11;
            boolean z3 = ceil2 % xYGraphWidget.getLinesPerRangeLabel() == 0;
            boolean z4 = ceil2 == 0;
            if (z4) {
                d3 = doubleValue2;
                paint = xYGraphWidget.rangeOriginLinePaint;
            } else {
                d3 = doubleValue2;
                if (z3) {
                    paint = xYGraphWidget.rangeGridLinePaint;
                } else {
                    paint = xYGraphWidget.rangeSubGridLinePaint;
                }
            }
            xYGraphWidget.drawRangeLine(canvas, (float) d14, Double.valueOf(d3), paint, z4, z3);
            ceil2++;
            xYGraphWidget = this;
        }
    }

    protected void drawMarkers(Canvas canvas) {
        if (this.plot.getYValueMarkers() != null && this.plot.getYValueMarkers().size() > 0) {
            for (YValueMarker yValueMarker : this.plot.getYValueMarkers()) {
                yValueMarker.draw(canvas, this.plot, this.gridRect);
            }
        }
        if (this.plot.getXValueMarkers() == null || this.plot.getXValueMarkers().size() <= 0) {
            return;
        }
        for (XValueMarker xValueMarker : this.plot.getXValueMarkers()) {
            xValueMarker.draw(canvas, this.plot, this.gridRect);
        }
    }

    protected void drawCursors(Canvas canvas) {
        boolean z;
        Float f;
        Float f2;
        boolean z2 = true;
        if (this.domainCursorPaint == null || (f2 = this.domainCursorPosition) == null || f2.floatValue() > this.gridRect.right || this.domainCursorPosition.floatValue() < this.gridRect.left) {
            z = false;
        } else {
            canvas.drawLine(this.domainCursorPosition.floatValue(), this.gridRect.top, this.domainCursorPosition.floatValue(), this.gridRect.bottom, this.domainCursorPaint);
            z = true;
        }
        if (this.rangeCursorPaint == null || (f = this.rangeCursorPosition) == null || f.floatValue() < this.gridRect.top || this.rangeCursorPosition.floatValue() > this.gridRect.bottom) {
            z2 = false;
        } else {
            canvas.drawLine(this.gridRect.left, this.rangeCursorPosition.floatValue(), this.gridRect.right, this.rangeCursorPosition.floatValue(), this.rangeCursorPaint);
        }
        if (getCursorLabelFormatter() != null && z2 && z) {
            drawCursorLabel(canvas);
        }
    }

    protected void drawCursorLabel(Canvas canvas) {
        String labelText = getCursorLabelFormatter().getLabelText(getDomainCursorVal(), getRangeCursorVal());
        RectF rectF = new RectF(FontUtils.getPackedStringDimensions(labelText, getCursorLabelFormatter().getTextPaint()));
        rectF.offsetTo(this.domainCursorPosition.floatValue(), this.rangeCursorPosition.floatValue() - rectF.height());
        if (rectF.right >= this.gridRect.right) {
            rectF.offsetTo(this.domainCursorPosition.floatValue() - rectF.width(), rectF.top);
        }
        if (rectF.top <= this.gridRect.top) {
            rectF.offsetTo(rectF.left, this.rangeCursorPosition.floatValue());
        }
        if (getCursorLabelFormatter().getBackgroundPaint() != null) {
            canvas.drawRect(rectF, getCursorLabelFormatter().getBackgroundPaint());
        }
        canvas.drawText(labelText, rectF.left, rectF.bottom, getCursorLabelFormatter().getTextPaint());
    }

    protected void drawGridBackground(Canvas canvas) {
        Paint paint = this.gridBackgroundPaint;
        if (paint != null) {
            canvas.drawRect(this.gridRect, paint);
        }
    }

    protected void drawData(Canvas canvas) {
        if (this.drawGridOnTop) {
            drawGridBackground(canvas);
        }
        try {
            if (this.isGridClippingEnabled) {
                canvas.save();
                canvas.clipRect(this.gridRect, Region.Op.INTERSECT);
            }
            this.renderStack.sync();
            Iterator<RenderStack<SeriesType, FormatterType>.StackElement<? extends XYSeries, ? extends XYSeriesFormatter>> it = this.renderStack.getElements().iterator();
            while (it.hasNext()) {
                RenderStack<SeriesType, FormatterType>.StackElement<? extends XYSeries, ? extends XYSeriesFormatter> next = it.next();
                if (next.isEnabled()) {
                    ((XYSeriesRenderer) this.plot.getRenderer(next.get().getFormatter().getRendererClass())).render(canvas, this.gridRect, next.get(), this.renderStack);
                }
            }
        } finally {
            if (this.isGridClippingEnabled) {
                canvas.restore();
            }
        }
    }

    protected void drawPoint(Canvas canvas, PointF pointF, Paint paint) {
        canvas.drawPoint(pointF.x, pointF.y, paint);
    }

    public Paint getGridBackgroundPaint() {
        return this.gridBackgroundPaint;
    }

    public void setGridBackgroundPaint(Paint paint) {
        this.gridBackgroundPaint = paint;
    }

    public Paint getDomainGridLinePaint() {
        return this.domainGridLinePaint;
    }

    public void setDomainGridLinePaint(Paint paint) {
        this.domainGridLinePaint = paint;
    }

    public Paint getRangeGridLinePaint() {
        return this.rangeGridLinePaint;
    }

    public Paint getDomainSubGridLinePaint() {
        return this.domainSubGridLinePaint;
    }

    public void setDomainSubGridLinePaint(Paint paint) {
        this.domainSubGridLinePaint = paint;
    }

    public void setRangeGridLinePaint(Paint paint) {
        this.rangeGridLinePaint = paint;
    }

    public Paint getRangeSubGridLinePaint() {
        return this.rangeSubGridLinePaint;
    }

    public void setRangeSubGridLinePaint(Paint paint) {
        this.rangeSubGridLinePaint = paint;
    }

    public int getLinesPerRangeLabel() {
        return this.linesPerRangeLabel;
    }

    public void setLinesPerRangeLabel(int i) {
        this.linesPerRangeLabel = i;
    }

    public int getLinesPerDomainLabel() {
        return this.linesPerDomainLabel;
    }

    public void setLinesPerDomainLabel(int i) {
        this.linesPerDomainLabel = i;
    }

    public Paint getDomainOriginLinePaint() {
        return this.domainOriginLinePaint;
    }

    public void setDomainOriginLinePaint(Paint paint) {
        this.domainOriginLinePaint = paint;
    }

    public Paint getRangeOriginLinePaint() {
        return this.rangeOriginLinePaint;
    }

    public void setRangeOriginLinePaint(Paint paint) {
        this.rangeOriginLinePaint = paint;
    }

    public void setCursorPosition(Float f, Float f2) {
        setDomainCursorPosition(f);
        setRangeCursorPosition(f2);
    }

    public void setCursorPosition(PointF pointF) {
        setCursorPosition(Float.valueOf(pointF.x), Float.valueOf(pointF.y));
    }

    public Float getDomainCursorPosition() {
        return this.domainCursorPosition;
    }

    public Number getDomainCursorVal() {
        return screenToSeriesX(getDomainCursorPosition().floatValue());
    }

    public void setDomainCursorPosition(Float f) {
        this.domainCursorPosition = f;
    }

    public Float getRangeCursorPosition() {
        return this.rangeCursorPosition;
    }

    public Number getRangeCursorVal() {
        return screenToSeriesY(getRangeCursorPosition().floatValue());
    }

    public void setRangeCursorPosition(Float f) {
        this.rangeCursorPosition = f;
    }

    public boolean isDrawGridOnTop() {
        return this.drawGridOnTop;
    }

    public void setDrawGridOnTop(boolean z) {
        this.drawGridOnTop = z;
    }

    public boolean isDrawMarkersEnabled() {
        return this.drawMarkersEnabled;
    }

    public void setDrawMarkersEnabled(boolean z) {
        this.drawMarkersEnabled = z;
    }

    public Paint getDomainCursorPaint() {
        return this.domainCursorPaint;
    }

    public void setDomainCursorPaint(Paint paint) {
        this.domainCursorPaint = paint;
    }

    public Paint getRangeCursorPaint() {
        return this.rangeCursorPaint;
    }

    public void setRangeCursorPaint(Paint paint) {
        this.rangeCursorPaint = paint;
    }

    public float getLineExtensionTop() {
        return this.lineExtensionTop;
    }

    public void setLineExtensionTop(float f) {
        this.lineExtensionTop = f;
    }

    public float getLineExtensionBottom() {
        return this.lineExtensionBottom;
    }

    public void setLineExtensionBottom(float f) {
        this.lineExtensionBottom = f;
    }

    public float getLineExtensionLeft() {
        return this.lineExtensionLeft;
    }

    public void setLineExtensionLeft(float f) {
        this.lineExtensionLeft = f;
    }

    public float getLineExtensionRight() {
        return this.lineExtensionRight;
    }

    public void setLineExtensionRight(float f) {
        this.lineExtensionRight = f;
    }

    protected Map<Edge, LineLabelStyle> getDefaultLineLabelStyles() {
        EnumMap enumMap = new EnumMap(Edge.class);
        enumMap.put((EnumMap) Edge.TOP, (Edge) new LineLabelStyle());
        enumMap.put((EnumMap) Edge.BOTTOM, (Edge) new LineLabelStyle());
        enumMap.put((EnumMap) Edge.LEFT, (Edge) new LineLabelStyle());
        enumMap.put((EnumMap) Edge.RIGHT, (Edge) new LineLabelStyle());
        return enumMap;
    }

    protected Map<Edge, LineLabelRenderer> getDefaultLineLabelRenderers() {
        EnumMap enumMap = new EnumMap(Edge.class);
        enumMap.put((EnumMap) Edge.TOP, (Edge) new LineLabelRenderer());
        enumMap.put((EnumMap) Edge.BOTTOM, (Edge) new LineLabelRenderer());
        enumMap.put((EnumMap) Edge.LEFT, (Edge) new LineLabelRenderer());
        enumMap.put((EnumMap) Edge.RIGHT, (Edge) new LineLabelRenderer());
        return enumMap;
    }

    public LineLabelRenderer getLineLabelRenderer(Edge edge) {
        return this.lineLabelRenderers.get(edge);
    }

    public void setLineLabelRenderer(Edge edge, LineLabelRenderer lineLabelRenderer) {
        this.lineLabelRenderers.put(edge, lineLabelRenderer);
    }

    public LineLabelStyle getLineLabelStyle(Edge edge) {
        return this.lineLabelStyles.get(edge);
    }

    public void setLineLabelStyle(Edge edge, LineLabelStyle lineLabelStyle) {
        this.lineLabelStyles.put(edge, lineLabelStyle);
    }

    public CursorLabelFormatter getCursorLabelFormatter() {
        return this.cursorLabelFormatter;
    }

    public void setCursorLabelFormatter(CursorLabelFormatter cursorLabelFormatter) {
        this.cursorLabelFormatter = cursorLabelFormatter;
    }

    public Insets getGridInsets() {
        return this.gridInsets;
    }

    public void setGridInsets(Insets insets) {
        this.gridInsets = insets;
        recalculateSizes(null);
    }

    public Insets getLineLabelInsets() {
        return this.lineLabelInsets;
    }

    public void setLineLabelInsets(Insets insets) {
        this.lineLabelInsets = insets;
        recalculateSizes(null);
    }

    public RectF getGridRect() {
        return this.gridRect;
    }

    public void setGridRect(RectF rectF) {
        this.gridRect = rectF;
    }

    public RectF getLabelRect() {
        return this.labelRect;
    }

    public void setLabelRect(RectF rectF) {
        this.labelRect = rectF;
    }

    public boolean isGridClippingEnabled() {
        return this.isGridClippingEnabled;
    }

    public void setGridClippingEnabled(boolean z) {
        this.isGridClippingEnabled = z;
    }

    public boolean isLineLabelEnabled(Edge edge) {
        return this.lineLabelEdges.contains(edge);
    }

    public void setLineLabelEdges(Edge... edgeArr) {
        EnumSet<Edge> noneOf = EnumSet.noneOf(Edge.class);
        if (edgeArr != null) {
            Collections.addAll(noneOf, edgeArr);
        }
        this.lineLabelEdges = noneOf;
    }

    public void setLineLabelEdges(Collection<Edge> collection) {
        this.lineLabelEdges = EnumSet.copyOf((Collection) collection);
    }

    protected void setLineLabelEdges(int i) {
        Edge[] values;
        for (Edge edge : Edge.values()) {
            if ((edge.value & i) == edge.value) {
                this.lineLabelEdges.add(edge);
            }
        }
    }

    public boolean containsPoint(float f, float f2) {
        RectF rectF = this.gridRect;
        if (rectF != null) {
            return rectF.contains(f, f2);
        }
        return false;
    }
}
