package com.androidplot.xy;

import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import com.androidplot.Region;
import com.androidplot.util.RectFUtils;
import java.io.Serializable;
import java.util.EnumSet;
/* loaded from: classes3.dex */
public class PanZoom implements View.OnTouchListener {
    protected static final int FIRST_FINGER = 0;
    protected static final float MIN_DIST_2_FING = 5.0f;
    protected static final int SECOND_FINGER = 1;
    private View.OnTouchListener delegate;
    private DragState dragState;
    protected RectF fingersRect;
    private PointF firstFingerPos;
    private boolean isEnabled;
    private Pan pan;
    private XYPlot plot;
    private State state;
    private Zoom zoom;
    private ZoomLimit zoomLimit;

    /* loaded from: classes3.dex */
    protected enum DragState {
        NONE,
        ONE_FINGER,
        TWO_FINGERS
    }

    /* loaded from: classes3.dex */
    public enum Pan {
        NONE,
        HORIZONTAL,
        VERTICAL,
        BOTH
    }

    /* loaded from: classes3.dex */
    public enum Zoom {
        NONE,
        STRETCH_HORIZONTAL,
        STRETCH_VERTICAL,
        STRETCH_BOTH,
        SCALE
    }

    /* loaded from: classes3.dex */
    public enum ZoomLimit {
        OUTER,
        MIN_TICKS
    }

    /* loaded from: classes3.dex */
    public static class State implements Serializable {
        private BoundaryMode domainBoundaryMode;
        private Number domainLowerBoundary;
        private Number domainUpperBoundary;
        private BoundaryMode rangeBoundaryMode;
        private Number rangeLowerBoundary;
        private Number rangeUpperBoundary;

        public void setDomainBoundaries(Number number, Number number2, BoundaryMode boundaryMode) {
            this.domainLowerBoundary = number;
            this.domainUpperBoundary = number2;
            this.domainBoundaryMode = boundaryMode;
        }

        public void setRangeBoundaries(Number number, Number number2, BoundaryMode boundaryMode) {
            this.rangeLowerBoundary = number;
            this.rangeUpperBoundary = number2;
            this.rangeBoundaryMode = boundaryMode;
        }

        public void applyDomainBoundaries(XYPlot xYPlot) {
            xYPlot.setDomainBoundaries(this.domainLowerBoundary, this.domainUpperBoundary, this.domainBoundaryMode);
        }

        public void applyRangeBoundaries(XYPlot xYPlot) {
            xYPlot.setRangeBoundaries(this.rangeLowerBoundary, this.rangeUpperBoundary, this.rangeBoundaryMode);
        }

        public void apply(XYPlot xYPlot) {
            applyDomainBoundaries(xYPlot);
            applyRangeBoundaries(xYPlot);
        }
    }

    protected PanZoom(XYPlot xYPlot, Pan pan, Zoom zoom) {
        this.isEnabled = true;
        this.dragState = DragState.NONE;
        this.state = new State();
        this.plot = xYPlot;
        this.pan = pan;
        this.zoom = zoom;
        this.zoomLimit = ZoomLimit.OUTER;
    }

    protected PanZoom(XYPlot xYPlot, Pan pan, Zoom zoom, ZoomLimit zoomLimit) {
        this.isEnabled = true;
        this.dragState = DragState.NONE;
        this.state = new State();
        this.plot = xYPlot;
        this.pan = pan;
        this.zoom = zoom;
        this.zoomLimit = zoomLimit;
    }

    public State getState() {
        return this.state;
    }

    public void setState(State state) {
        this.state = state;
        state.apply(this.plot);
    }

    protected void adjustRangeBoundary(Number number, Number number2, BoundaryMode boundaryMode) {
        this.state.setRangeBoundaries(number, number2, boundaryMode);
        this.state.applyRangeBoundaries(this.plot);
    }

    protected void adjustDomainBoundary(Number number, Number number2, BoundaryMode boundaryMode) {
        this.state.setDomainBoundaries(number, number2, boundaryMode);
        this.state.applyDomainBoundaries(this.plot);
    }

    public static PanZoom attach(XYPlot xYPlot) {
        return attach(xYPlot, Pan.BOTH, Zoom.SCALE);
    }

    public static PanZoom attach(XYPlot xYPlot, Pan pan, Zoom zoom) {
        return attach(xYPlot, pan, zoom, ZoomLimit.OUTER);
    }

    public static PanZoom attach(XYPlot xYPlot, Pan pan, Zoom zoom, ZoomLimit zoomLimit) {
        PanZoom panZoom = new PanZoom(xYPlot, pan, zoom, zoomLimit);
        xYPlot.setOnTouchListener(panZoom);
        return panZoom;
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public void setEnabled(boolean z) {
        this.isEnabled = z;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View.OnTouchListener onTouchListener = this.delegate;
        boolean onTouch = onTouchListener != null ? onTouchListener.onTouch(view, motionEvent) : false;
        if (isEnabled() && !onTouch) {
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                this.firstFingerPos = new PointF(motionEvent.getX(), motionEvent.getY());
                this.dragState = DragState.ONE_FINGER;
            } else if (action == 1) {
                reset();
            } else if (action != 2) {
                if (action == 5) {
                    setFingersRect(fingerDistance(motionEvent));
                    if (getFingersRect().width() > MIN_DIST_2_FING || getFingersRect().width() < -5.0f) {
                        this.dragState = DragState.TWO_FINGERS;
                    }
                } else if (action == 6) {
                    this.dragState = DragState.NONE;
                }
            } else if (this.dragState == DragState.ONE_FINGER) {
                pan(motionEvent);
            } else if (this.dragState == DragState.TWO_FINGERS) {
                zoom(motionEvent);
            }
        }
        return true;
    }

    protected RectF fingerDistance(float f, float f2, float f3, float f4) {
        int i = (f > f3 ? 1 : (f == f3 ? 0 : -1));
        float f5 = i > 0 ? f3 : f;
        if (i <= 0) {
            f = f3;
        }
        int i2 = (f2 > f4 ? 1 : (f2 == f4 ? 0 : -1));
        float f6 = i2 > 0 ? f4 : f2;
        if (i2 <= 0) {
            f2 = f4;
        }
        return new RectF(f5, f6, f, f2);
    }

    protected RectF fingerDistance(MotionEvent motionEvent) {
        return fingerDistance(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(1), motionEvent.getY(1));
    }

    protected void pan(MotionEvent motionEvent) {
        if (this.pan == Pan.NONE) {
            return;
        }
        PointF pointF = this.firstFingerPos;
        this.firstFingerPos = new PointF(motionEvent.getX(), motionEvent.getY());
        if (EnumSet.of(Pan.HORIZONTAL, Pan.BOTH).contains(this.pan)) {
            Region region = new Region();
            calculatePan(pointF, region, true);
            adjustDomainBoundary(region.getMin(), region.getMax(), BoundaryMode.FIXED);
        }
        if (EnumSet.of(Pan.VERTICAL, Pan.BOTH).contains(this.pan)) {
            Region region2 = new Region();
            calculatePan(pointF, region2, false);
            adjustRangeBoundary(region2.getMin(), region2.getMax(), BoundaryMode.FIXED);
        }
        this.plot.redraw();
    }

    protected void calculatePan(PointF pointF, Region region, boolean z) {
        float f;
        float floatValue;
        int height;
        if (z) {
            region.setMinMax(this.plot.getBounds().getxRegion());
            f = pointF.x - this.firstFingerPos.x;
            floatValue = region.getMax().floatValue() - region.getMin().floatValue();
            height = this.plot.getWidth();
        } else {
            region.setMinMax(this.plot.getBounds().getyRegion());
            f = -(pointF.y - this.firstFingerPos.y);
            floatValue = region.getMax().floatValue() - region.getMin().floatValue();
            height = this.plot.getHeight();
        }
        float f2 = f * (floatValue / height);
        region.setMin(Float.valueOf(region.getMin().floatValue() + f2));
        region.setMax(Float.valueOf(region.getMax().floatValue() + f2));
        float floatValue2 = region.length().floatValue();
        if (z && this.plot.getOuterLimits().getxRegion().isDefined()) {
            if (region.getMin().floatValue() < this.plot.getOuterLimits().getMinX().floatValue()) {
                region.setMin(this.plot.getOuterLimits().getMinX());
                region.setMax(Float.valueOf(region.getMin().floatValue() + floatValue2));
            }
            if (region.getMax().floatValue() > this.plot.getOuterLimits().getMaxX().floatValue()) {
                region.setMax(this.plot.getOuterLimits().getMaxX());
                region.setMin(Float.valueOf(region.getMax().floatValue() - floatValue2));
            }
        } else if (this.plot.getOuterLimits().getyRegion().isDefined()) {
            if (region.getMin().floatValue() < this.plot.getOuterLimits().getMinY().floatValue()) {
                region.setMin(this.plot.getOuterLimits().getMinY());
                region.setMax(Float.valueOf(region.getMin().floatValue() + floatValue2));
            }
            if (region.getMax().floatValue() > this.plot.getOuterLimits().getMaxY().floatValue()) {
                region.setMax(this.plot.getOuterLimits().getMaxY());
                region.setMin(Float.valueOf(region.getMax().floatValue() - floatValue2));
            }
        }
    }

    protected boolean isValidScale(float f) {
        if (Float.isInfinite(f) || Float.isNaN(f)) {
            return false;
        }
        double d = f;
        return d <= -0.001d || d >= 0.001d;
    }

    protected void zoom(MotionEvent motionEvent) {
        float f;
        if (this.zoom == Zoom.NONE) {
            return;
        }
        RectF fingersRect = getFingersRect();
        RectF fingerDistance = fingerDistance(motionEvent);
        setFingersRect(fingerDistance);
        if (fingersRect == null || RectFUtils.areIdentical(fingersRect, fingerDistance)) {
            return;
        }
        RectF rectF = new RectF();
        int i = AnonymousClass1.$SwitchMap$com$androidplot$xy$PanZoom$Zoom[this.zoom.ordinal()];
        float f2 = 1.0f;
        if (i == 1) {
            float width = fingersRect.width() / getFingersRect().width();
            if (!isValidScale(width)) {
                return;
            }
            f2 = width;
            f = 1.0f;
        } else if (i == 2) {
            f = fingersRect.height() / getFingersRect().height();
            if (!isValidScale(f)) {
                return;
            }
        } else if (i != 3) {
            if (i == 4) {
                f2 = ((float) Math.hypot(fingersRect.height(), fingersRect.width())) / ((float) Math.hypot(getFingersRect().height(), getFingersRect().width()));
                if (!isValidScale(f2) || !isValidScale(f2)) {
                    return;
                }
            }
            f = f2;
        } else {
            f2 = fingersRect.width() / getFingersRect().width();
            f = fingersRect.height() / getFingersRect().height();
            if (!isValidScale(f2) || !isValidScale(f)) {
                return;
            }
        }
        if (EnumSet.of(Zoom.STRETCH_HORIZONTAL, Zoom.STRETCH_BOTH, Zoom.SCALE).contains(this.zoom)) {
            calculateZoom(rectF, f2, true);
            adjustDomainBoundary(Float.valueOf(rectF.left), Float.valueOf(rectF.right), BoundaryMode.FIXED);
        }
        if (EnumSet.of(Zoom.STRETCH_VERTICAL, Zoom.STRETCH_BOTH, Zoom.SCALE).contains(this.zoom)) {
            calculateZoom(rectF, f, false);
            adjustRangeBoundary(Float.valueOf(rectF.top), Float.valueOf(rectF.bottom), BoundaryMode.FIXED);
        }
        this.plot.redraw();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.androidplot.xy.PanZoom$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$androidplot$xy$PanZoom$Zoom;

        static {
            int[] iArr = new int[Zoom.values().length];
            $SwitchMap$com$androidplot$xy$PanZoom$Zoom = iArr;
            try {
                iArr[Zoom.STRETCH_HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$androidplot$xy$PanZoom$Zoom[Zoom.STRETCH_VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$androidplot$xy$PanZoom$Zoom[Zoom.STRETCH_BOTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$androidplot$xy$PanZoom$Zoom[Zoom.SCALE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    protected void calculateZoom(RectF rectF, float f, boolean z) {
        float floatValue;
        float floatValue2;
        RectRegion bounds = this.plot.getBounds();
        if (z) {
            floatValue = bounds.getMaxX().floatValue();
            floatValue2 = bounds.getMinX().floatValue();
        } else {
            floatValue = bounds.getMaxY().floatValue();
            floatValue2 = bounds.getMinY().floatValue();
        }
        float f2 = floatValue - floatValue2;
        float f3 = floatValue - (f2 / 2.0f);
        float f4 = f2 * f;
        float f5 = f4 / 2.0f;
        RectRegion outerLimits = this.plot.getOuterLimits();
        if (z) {
            if (this.zoomLimit == ZoomLimit.MIN_TICKS && this.plot.getDomainStepValue() > f4) {
                f5 = (float) (this.plot.getDomainStepValue() / 2.0d);
            }
            rectF.left = f3 - f5;
            rectF.right = f3 + f5;
            if (outerLimits.isFullyDefined()) {
                if (rectF.left < outerLimits.getMinX().floatValue()) {
                    rectF.left = outerLimits.getMinX().floatValue();
                }
                if (rectF.right > outerLimits.getMaxX().floatValue()) {
                    rectF.right = outerLimits.getMaxX().floatValue();
                    return;
                }
                return;
            }
            return;
        }
        if (this.zoomLimit == ZoomLimit.MIN_TICKS && this.plot.getRangeStepValue() > f4) {
            f5 = (float) (this.plot.getRangeStepValue() / 2.0d);
        }
        rectF.top = f3 - f5;
        rectF.bottom = f3 + f5;
        if (outerLimits.isFullyDefined()) {
            if (rectF.top < outerLimits.getMinY().floatValue()) {
                rectF.top = outerLimits.getMinY().floatValue();
            }
            if (rectF.bottom > outerLimits.getMaxY().floatValue()) {
                rectF.bottom = outerLimits.getMaxY().floatValue();
            }
        }
    }

    public Pan getPan() {
        return this.pan;
    }

    public void setPan(Pan pan) {
        this.pan = pan;
    }

    public Zoom getZoom() {
        return this.zoom;
    }

    public void setZoom(Zoom zoom) {
        this.zoom = zoom;
    }

    public ZoomLimit getZoomLimit() {
        return this.zoomLimit;
    }

    public void setZoomLimit(ZoomLimit zoomLimit) {
        this.zoomLimit = zoomLimit;
    }

    public View.OnTouchListener getDelegate() {
        return this.delegate;
    }

    public void setDelegate(View.OnTouchListener onTouchListener) {
        this.delegate = onTouchListener;
    }

    public void reset() {
        this.firstFingerPos = null;
        setFingersRect(null);
        setFingersRect(null);
    }

    protected RectF getFingersRect() {
        return this.fingersRect;
    }

    protected void setFingersRect(RectF rectF) {
        this.fingersRect = rectF;
    }
}
