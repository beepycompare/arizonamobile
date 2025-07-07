package androidx.constraintlayout.compose;

import android.graphics.Matrix;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.state.CorePixelDp;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: MotionMeasurer.kt */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\u0010H\u0016J4\u0010\u0012\u001a\u00020\u00102\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0012\u0010\u001d\u001a\u00020\u00102\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015J+\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u001e\u0010%\u001a\u00020\b2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\bJ.\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u000b\u001a\u00020,2\u0006\u0010\u001a\u001a\u00020\bJ8\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020(2\f\u00100\u001a\b\u0012\u0004\u0012\u000202012\u0006\u00103\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\b4\u00105J,\u00106\u001a\u00020\u00062\u0006\u00103\u001a\u00020\n2\u0006\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:H\u0002ø\u0001\u0000¢\u0006\u0004\b;\u0010<J|\u0010=\u001a\u00020>2\u0006\u00103\u001a\u00020\n2\u0006\u0010*\u001a\u00020+2\u0006\u0010?\u001a\u00020(2\u0006\u0010@\u001a\u00020(2\u0006\u0010\u000b\u001a\u00020,2\f\u00100\u001a\b\u0012\u0004\u0012\u000202012\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020C0B2\u0006\u0010.\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010D\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:ø\u0001\u0000¢\u0006\u0004\bE\u0010FJb\u0010G\u001a\u00020\u00102\u0006\u00103\u001a\u00020\n2\u0006\u0010*\u001a\u00020+2\u0006\u0010?\u001a\u00020(2\u0006\u0010@\u001a\u00020(2\b\u0010\u000b\u001a\u0004\u0018\u00010,2\f\u00100\u001a\b\u0012\u0004\u0012\u000202012\u0006\u0010.\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010H\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\bI\u0010JJ(\u0010K\u001a\u00020\u0010*\u00020L2\b\b\u0002\u0010M\u001a\u00020\u00062\b\b\u0002\u0010N\u001a\u00020\u00062\b\b\u0002\u0010O\u001a\u00020\u0006J.\u0010P\u001a\u00020\u0010*\u00020L2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020\u001fH\u0002ø\u0001\u0000¢\u0006\u0004\bV\u0010WJF\u0010X\u001a\u00020\u0010*\u00020L2\u0006\u0010Y\u001a\u00020\b2\u0006\u0010Z\u001a\u00020\b2\u0006\u0010[\u001a\u00020R2\u0006\u0010\\\u001a\u00020R2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020\u001fH\u0002ø\u0001\u0000¢\u0006\u0004\b]\u0010^J4\u0010N\u001a\u00020\u0010*\u00020L2\u0006\u0010Y\u001a\u00020\b2\u0006\u0010Z\u001a\u00020\b2\u0006\u0010[\u001a\u00020R2\u0006\u0010_\u001a\u00020\u00062\u0006\u0010O\u001a\u00020\u0006H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006`"}, d2 = {"Landroidx/constraintlayout/compose/MotionMeasurer;", "Landroidx/constraintlayout/compose/Measurer2;", "density", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/ui/unit/Density;)V", "DEBUG", "", "lastProgressInInterpolation", "", "oldConstraints", "Landroidx/compose/ui/unit/Constraints;", "transition", "Landroidx/constraintlayout/core/state/Transition;", "getTransition", "()Landroidx/constraintlayout/core/state/Transition;", "clearConstraintSets", "", "computeLayoutResult", "encodeKeyFrames", "json", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", FirebaseAnalytics.Param.LOCATION, "", "types", "", "progress", "count", "", "encodeRoot", "getCustomColor", "Landroidx/compose/ui/graphics/Color;", "id", "", "name", "getCustomColor-XeAY9LY", "(Ljava/lang/String;Ljava/lang/String;F)J", "getCustomFloat", "initWith", TtmlNode.START, "Landroidx/constraintlayout/compose/ConstraintSet;", TtmlNode.END, "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/constraintlayout/compose/TransitionImpl;", "measureConstraintSet", "optimizationLevel", "constraintSet", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measureConstraintSet--hBUhpc", "(ILandroidx/constraintlayout/compose/ConstraintSet;Ljava/util/List;J)V", "needsRemeasure", "source", "Landroidx/constraintlayout/compose/CompositionSource;", "invalidateOnConstraintsCallback", "Landroidx/constraintlayout/compose/ShouldInvalidateCallback;", "needsRemeasure-NN6Ew-U", "(JLandroidx/constraintlayout/compose/CompositionSource;Landroidx/constraintlayout/compose/ShouldInvalidateCallback;)Z", "performInterpolationMeasure", "Landroidx/compose/ui/unit/IntSize;", "constraintSetStart", "constraintSetEnd", "placeableMap", "", "Landroidx/compose/ui/layout/Placeable;", "compositionSource", "performInterpolationMeasure-LzAeyeM", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/constraintlayout/compose/ConstraintSet;Landroidx/constraintlayout/compose/ConstraintSet;Landroidx/constraintlayout/compose/TransitionImpl;Ljava/util/List;Ljava/util/Map;IFLandroidx/constraintlayout/compose/CompositionSource;Landroidx/constraintlayout/compose/ShouldInvalidateCallback;)J", "recalculateInterpolation", "remeasure", "recalculateInterpolation-36Wf7g4", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/constraintlayout/compose/ConstraintSet;Landroidx/constraintlayout/compose/ConstraintSet;Landroidx/constraintlayout/compose/TransitionImpl;Ljava/util/List;IFZ)V", "drawDebug", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawBounds", "drawPaths", "drawKeyPositions", "drawFrame", TypedValues.AttributesType.S_FRAME, "Landroidx/constraintlayout/core/state/WidgetFrame;", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "color", "drawFrame-g2O1Hgs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/constraintlayout/core/state/WidgetFrame;Landroidx/compose/ui/graphics/PathEffect;J)V", "drawFrameDebug", "parentWidth", "parentHeight", "startFrame", "endFrame", "drawFrameDebug-PE3pjmc", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFLandroidx/constraintlayout/core/state/WidgetFrame;Landroidx/constraintlayout/core/state/WidgetFrame;Landroidx/compose/ui/graphics/PathEffect;J)V", "drawPath", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MotionMeasurer extends Measurer2 {
    public static final int $stable = 8;
    private final boolean DEBUG;
    private float lastProgressInInterpolation;
    private Constraints oldConstraints;
    private final androidx.constraintlayout.core.state.Transition transition;

    public MotionMeasurer(final Density density) {
        super(density);
        this.transition = new androidx.constraintlayout.core.state.Transition(new CorePixelDp() { // from class: androidx.constraintlayout.compose.MotionMeasurer$$ExternalSyntheticLambda0
            @Override // androidx.constraintlayout.core.state.CorePixelDp
            public final float toPixels(float f) {
                float transition$lambda$1;
                transition$lambda$1 = MotionMeasurer.transition$lambda$1(Density.this, f);
                return transition$lambda$1;
            }
        });
    }

    public final androidx.constraintlayout.core.state.Transition getTransition() {
        return this.transition;
    }

    /* renamed from: measureConstraintSet--hBUhpc  reason: not valid java name */
    private final void m7122measureConstraintSethBUhpc(int i, ConstraintSet constraintSet, List<? extends Measurable> list, long j) {
        String str;
        Object layoutId;
        getState().reset();
        constraintSet.applyTo(getState(), list);
        ConstraintLayoutKt.buildMapping(getState(), list);
        getState().apply(getRoot());
        ArrayList<ConstraintWidget> children = getRoot().getChildren();
        int size = children.size();
        for (int i2 = 0; i2 < size; i2++) {
            children.get(i2).setAnimated(true);
        }
        m7084applyRootSizeBRTryo0(j);
        getRoot().updateHierarchy();
        if (this.DEBUG) {
            getRoot().setDebugName("ConstraintLayout");
            ArrayList<ConstraintWidget> children2 = getRoot().getChildren();
            int size2 = children2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                ConstraintWidget constraintWidget = children2.get(i3);
                Object companionWidget = constraintWidget.getCompanionWidget();
                Measurable measurable = companionWidget instanceof Measurable ? (Measurable) companionWidget : null;
                if (measurable == null || (layoutId = LayoutIdKt.getLayoutId(measurable)) == null || (str = layoutId.toString()) == null) {
                    str = "NOTAG";
                }
                constraintWidget.setDebugName(str);
            }
        }
        getRoot().setOptimizationLevel(i);
        getRoot().measure(0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    /* renamed from: performInterpolationMeasure-LzAeyeM  reason: not valid java name */
    public final long m7126performInterpolationMeasureLzAeyeM(long j, LayoutDirection layoutDirection, ConstraintSet constraintSet, ConstraintSet constraintSet2, TransitionImpl transitionImpl, List<? extends Measurable> list, Map<Measurable, Placeable> map, int i, float f, CompositionSource compositionSource, ShouldInvalidateCallback shouldInvalidateCallback) {
        long j2;
        MotionMeasurer motionMeasurer;
        LayoutInformationReceiver layoutInformationReceiver;
        LayoutInformationReceiver layoutInformationReceiver2;
        setPlaceables(map);
        boolean m7123needsRemeasureNN6EwU = m7123needsRemeasureNN6EwU(j, compositionSource, shouldInvalidateCallback);
        if (this.lastProgressInInterpolation != f || ((((layoutInformationReceiver = getLayoutInformationReceiver()) == null || layoutInformationReceiver.getForcedWidth() != Integer.MIN_VALUE) && ((layoutInformationReceiver2 = getLayoutInformationReceiver()) == null || layoutInformationReceiver2.getForcedHeight() != Integer.MIN_VALUE)) || m7123needsRemeasureNN6EwU)) {
            j2 = j;
            motionMeasurer = this;
            motionMeasurer.m7124recalculateInterpolation36Wf7g4(j2, layoutDirection, constraintSet, constraintSet2, transitionImpl, list, i, f, m7123needsRemeasureNN6EwU);
        } else {
            j2 = j;
            motionMeasurer = this;
        }
        motionMeasurer.oldConstraints = Constraints.m6624boximpl(j2);
        return IntSizeKt.IntSize(getRoot().getWidth(), getRoot().getHeight());
    }

    /* renamed from: needsRemeasure-NN6Ew-U  reason: not valid java name */
    private final boolean m7123needsRemeasureNN6EwU(long j, CompositionSource compositionSource, ShouldInvalidateCallback shouldInvalidateCallback) {
        if (this.transition.isEmpty() || getFrameCache().isEmpty()) {
            return true;
        }
        Constraints constraints = this.oldConstraints;
        if (constraints != null && shouldInvalidateCallback != null) {
            Intrinsics.checkNotNull(constraints);
            if (shouldInvalidateCallback.mo7063invokeN9IONVI(constraints.m6643unboximpl(), j)) {
                return true;
            }
        } else if ((Constraints.m6634getHasFixedHeightimpl(j) && !getState().sameFixedHeight(Constraints.m6636getMaxHeightimpl(j))) || (Constraints.m6635getHasFixedWidthimpl(j) && !getState().sameFixedWidth(Constraints.m6637getMaxWidthimpl(j)))) {
            return true;
        }
        return compositionSource == CompositionSource.Content;
    }

    /* renamed from: recalculateInterpolation-36Wf7g4  reason: not valid java name */
    private final void m7124recalculateInterpolation36Wf7g4(long j, LayoutDirection layoutDirection, ConstraintSet constraintSet, ConstraintSet constraintSet2, TransitionImpl transitionImpl, List<? extends Measurable> list, int i, float f, boolean z) {
        WidgetFrame interpolated;
        androidx.constraintlayout.core.state.Dimension min;
        androidx.constraintlayout.core.state.Dimension min2;
        this.lastProgressInInterpolation = f;
        int i2 = 0;
        if (z) {
            this.transition.clear();
            resetMeasureState$constraintlayout_compose_release();
            State state = getState();
            if (Constraints.m6635getHasFixedWidthimpl(j)) {
                min = androidx.constraintlayout.core.state.Dimension.createFixed(Constraints.m6637getMaxWidthimpl(j));
            } else {
                min = androidx.constraintlayout.core.state.Dimension.createWrap().min(Constraints.m6639getMinWidthimpl(j));
            }
            state.width(min);
            State state2 = getState();
            if (Constraints.m6634getHasFixedHeightimpl(j)) {
                min2 = androidx.constraintlayout.core.state.Dimension.createFixed(Constraints.m6636getMaxHeightimpl(j));
            } else {
                min2 = androidx.constraintlayout.core.state.Dimension.createWrap().min(Constraints.m6638getMinHeightimpl(j));
            }
            state2.height(min2);
            getState().m7153setRootIncomingConstraintsBRTryo0(j);
            getState().setRtl(layoutDirection == LayoutDirection.Rtl);
            m7122measureConstraintSethBUhpc(i, constraintSet, list, j);
            this.transition.updateFrom(getRoot(), 0);
            m7122measureConstraintSethBUhpc(i, constraintSet2, list, j);
            this.transition.updateFrom(getRoot(), 1);
            if (transitionImpl != null) {
                transitionImpl.applyKeyFramesTo(this.transition);
            }
        } else {
            ConstraintLayoutKt.buildMapping(getState(), list);
        }
        this.transition.interpolate(getRoot().getWidth(), getRoot().getHeight(), f);
        getRoot().setWidth(this.transition.getInterpolatedWidth());
        getRoot().setHeight(this.transition.getInterpolatedHeight());
        ArrayList<ConstraintWidget> children = getRoot().getChildren();
        int size = children.size();
        while (true) {
            if (i2 >= size) {
                break;
            }
            ConstraintWidget constraintWidget = children.get(i2);
            Object companionWidget = constraintWidget.getCompanionWidget();
            Measurable measurable = companionWidget instanceof Measurable ? (Measurable) companionWidget : null;
            if (measurable != null && (interpolated = this.transition.getInterpolated(constraintWidget)) != null) {
                getPlaceables().put(measurable, measurable.mo5438measureBRTryo0(Constraints.Companion.m6647fixedJhjzzOo(interpolated.width(), interpolated.height())));
                getFrameCache().put(MeasurerKt.getAnyOrNullId(measurable), interpolated);
            }
            i2++;
        }
        LayoutInformationReceiver layoutInformationReceiver = getLayoutInformationReceiver();
        if ((layoutInformationReceiver != null ? layoutInformationReceiver.getLayoutInformationMode() : null) == LayoutInfoFlags.BOUNDS) {
            computeLayoutResult();
        }
    }

    private final void encodeKeyFrames(StringBuilder sb, float[] fArr, int[] iArr, int[] iArr2, int i) {
        if (i == 0) {
            return;
        }
        sb.append("keyTypes : [");
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(" " + iArr[i2] + AbstractJsonLexerKt.COMMA);
        }
        sb.append("],\n");
        sb.append("keyPos : [");
        int i3 = i * 2;
        for (int i4 = 0; i4 < i3; i4++) {
            sb.append(" " + fArr[i4] + AbstractJsonLexerKt.COMMA);
        }
        sb.append("],\n ");
        sb.append("keyFrames : [");
        for (int i5 = 0; i5 < i; i5++) {
            sb.append(" " + iArr2[i5] + AbstractJsonLexerKt.COMMA);
        }
        sb.append("],\n ");
    }

    public final void encodeRoot(StringBuilder sb) {
        sb.append("  root: {");
        sb.append("interpolated: { left:  0,");
        sb.append("  top:  0,");
        sb.append("  right:   " + getRoot().getWidth() + " ,");
        sb.append("  bottom:  " + getRoot().getHeight() + " ,");
        sb.append(" } }");
    }

    @Override // androidx.constraintlayout.compose.Measurer2
    public void computeLayoutResult() {
        MotionMeasurer motionMeasurer = this;
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        motionMeasurer.encodeRoot(sb);
        int[] iArr = new int[50];
        int[] iArr2 = new int[50];
        float[] fArr = new float[100];
        ArrayList<ConstraintWidget> children = motionMeasurer.getRoot().getChildren();
        int size = children.size();
        int i = 0;
        while (i < size) {
            ConstraintWidget constraintWidget = children.get(i);
            WidgetFrame start = motionMeasurer.transition.getStart(constraintWidget.stringId);
            WidgetFrame end = motionMeasurer.transition.getEnd(constraintWidget.stringId);
            WidgetFrame interpolated = motionMeasurer.transition.getInterpolated(constraintWidget.stringId);
            float[] path = motionMeasurer.transition.getPath(constraintWidget.stringId);
            int keyFrames = motionMeasurer.transition.getKeyFrames(constraintWidget.stringId, fArr, iArr, iArr2);
            sb.append(" " + constraintWidget.stringId + ": {");
            sb.append(" interpolated : ");
            interpolated.serialize(sb, true);
            sb.append(", start : ");
            start.serialize(sb);
            sb.append(", end : ");
            end.serialize(sb);
            motionMeasurer.encodeKeyFrames(sb, fArr, iArr, iArr2, keyFrames);
            sb.append(" path : [");
            int length = path.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(" " + path[i2] + " ,");
            }
            sb.append(" ] ");
            sb.append("}, ");
            i++;
            motionMeasurer = this;
        }
        sb.append(" }");
        LayoutInformationReceiver layoutInformationReceiver = getLayoutInformationReceiver();
        if (layoutInformationReceiver != null) {
            layoutInformationReceiver.setLayoutInformation(sb.toString());
        }
    }

    public static /* synthetic */ void drawDebug$default(MotionMeasurer motionMeasurer, DrawScope drawScope, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            z3 = true;
        }
        motionMeasurer.drawDebug(drawScope, z, z2, z3);
    }

    public final void drawDebug(DrawScope drawScope, boolean z, boolean z2, boolean z3) {
        WidgetFrame widgetFrame;
        PathEffect pathEffect;
        PathEffect dashPathEffect = PathEffect.Companion.dashPathEffect(new float[]{10.0f, 10.0f}, 0.0f);
        ArrayList<ConstraintWidget> children = getRoot().getChildren();
        int size = children.size();
        int i = 0;
        while (i < size) {
            ConstraintWidget constraintWidget = children.get(i);
            WidgetFrame start = this.transition.getStart(constraintWidget);
            WidgetFrame end = this.transition.getEnd(constraintWidget);
            if (z) {
                m7120drawFrameg2O1Hgs(drawScope, start, dashPathEffect, Color.Companion.m4105getBlue0d7_KjU());
                m7120drawFrameg2O1Hgs(drawScope, end, dashPathEffect, Color.Companion.m4105getBlue0d7_KjU());
                drawScope.getDrawContext().getTransform().translate(2.0f, 2.0f);
                try {
                    m7120drawFrameg2O1Hgs(drawScope, start, dashPathEffect, Color.Companion.m4115getWhite0d7_KjU());
                    widgetFrame = start;
                    m7120drawFrameg2O1Hgs(drawScope, end, dashPathEffect, Color.Companion.m4115getWhite0d7_KjU());
                    pathEffect = dashPathEffect;
                } finally {
                    drawScope.getDrawContext().getTransform().translate(-2.0f, -2.0f);
                }
            } else {
                widgetFrame = start;
                pathEffect = dashPathEffect;
            }
            drawPaths(drawScope, Size.m3906getWidthimpl(drawScope.mo4640getSizeNHjbRc()), Size.m3903getHeightimpl(drawScope.mo4640getSizeNHjbRc()), widgetFrame, z2, z3);
            i++;
            dashPathEffect = pathEffect;
        }
    }

    private final void drawPaths(DrawScope drawScope, float f, float f2, WidgetFrame widgetFrame, boolean z, boolean z2) {
        new MotionRenderDebug(23.0f).basicDraw(AndroidCanvas_androidKt.getNativeCanvas(drawScope.getDrawContext().getCanvas()), this.transition.getMotion(widgetFrame.widget.stringId), 1000, (int) f, (int) f2, z, z2);
    }

    /* renamed from: drawFrameDebug-PE3pjmc  reason: not valid java name */
    private final void m7121drawFrameDebugPE3pjmc(DrawScope drawScope, float f, float f2, WidgetFrame widgetFrame, WidgetFrame widgetFrame2, PathEffect pathEffect, long j) {
        m7120drawFrameg2O1Hgs(drawScope, widgetFrame, pathEffect, j);
        m7120drawFrameg2O1Hgs(drawScope, widgetFrame2, pathEffect, j);
        int numberKeyPositions = this.transition.getNumberKeyPositions(widgetFrame);
        new MotionRenderDebug(23.0f).draw(AndroidCanvas_androidKt.getNativeCanvas(drawScope.getDrawContext().getCanvas()), this.transition.getMotion(widgetFrame.widget.stringId), 1000, 1, (int) f, (int) f2);
        if (numberKeyPositions == 0) {
            return;
        }
        float[] fArr = new float[numberKeyPositions];
        float[] fArr2 = new float[numberKeyPositions];
        float[] fArr3 = new float[numberKeyPositions];
        this.transition.fillKeyPositions(widgetFrame, fArr, fArr2, fArr3);
        int i = 1;
        int i2 = numberKeyPositions - 1;
        if (i2 < 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            float f3 = fArr3[i3] / 100.0f;
            float f4 = i - f3;
            float width = (widgetFrame.width() * f4) + (widgetFrame2.width() * f3);
            float height = (f4 * widgetFrame.height()) + (f3 * widgetFrame2.height());
            float f5 = (fArr[i3] * f) + (width / 2.0f);
            float f6 = (fArr2[i3] * f2) + (height / 2.0f);
            Path Path = AndroidPath_androidKt.Path();
            Path.moveTo(f5 - 20.0f, f6);
            Path.lineTo(f5, f6 + 20.0f);
            Path.lineTo(f5 + 20.0f, f6);
            Path.lineTo(f5, f6 - 20.0f);
            Path.close();
            int i4 = i3;
            DrawScope.m4630drawPathLG529CI$default(drawScope, Path, j, 1.0f, new Stroke(3.0f, 0.0f, 0, 0, null, 30, null), null, 0, 48, null);
            if (i4 == i2) {
                return;
            }
            i3 = i4 + 1;
            i = 1;
        }
    }

    /* renamed from: drawFrame-g2O1Hgs  reason: not valid java name */
    private final void m7120drawFrameg2O1Hgs(DrawScope drawScope, WidgetFrame widgetFrame, PathEffect pathEffect, long j) {
        if (widgetFrame.isDefaultTransform()) {
            DrawScope.m4634drawRectnJ9OG0$default(drawScope, j, OffsetKt.Offset(widgetFrame.left, widgetFrame.top), SizeKt.Size(widgetFrame.width(), widgetFrame.height()), 0.0f, new Stroke(3.0f, 0.0f, 0, 0, pathEffect, 14, null), null, 0, 104, null);
            return;
        }
        Matrix matrix = new Matrix();
        if (!Float.isNaN(widgetFrame.rotationZ)) {
            matrix.preRotate(widgetFrame.rotationZ, widgetFrame.centerX(), widgetFrame.centerY());
        }
        matrix.preScale(Float.isNaN(widgetFrame.scaleX) ? 1.0f : widgetFrame.scaleX, Float.isNaN(widgetFrame.scaleY) ? 1.0f : widgetFrame.scaleY, widgetFrame.centerX(), widgetFrame.centerY());
        float[] fArr = {widgetFrame.left, widgetFrame.top, widgetFrame.right, widgetFrame.top, widgetFrame.right, widgetFrame.bottom, widgetFrame.left, widgetFrame.bottom};
        matrix.mapPoints(fArr);
        DrawScope.m4626drawLineNGM6Ib0$default(drawScope, j, OffsetKt.Offset(fArr[0], fArr[1]), OffsetKt.Offset(fArr[2], fArr[3]), 3.0f, 0, pathEffect, 0.0f, null, 0, 464, null);
        DrawScope.m4626drawLineNGM6Ib0$default(drawScope, j, OffsetKt.Offset(fArr[2], fArr[3]), OffsetKt.Offset(fArr[4], fArr[5]), 3.0f, 0, pathEffect, 0.0f, null, 0, 464, null);
        DrawScope.m4626drawLineNGM6Ib0$default(drawScope, j, OffsetKt.Offset(fArr[4], fArr[5]), OffsetKt.Offset(fArr[6], fArr[7]), 3.0f, 0, pathEffect, 0.0f, null, 0, 464, null);
        DrawScope.m4626drawLineNGM6Ib0$default(drawScope, j, OffsetKt.Offset(fArr[6], fArr[7]), OffsetKt.Offset(fArr[0], fArr[1]), 3.0f, 0, pathEffect, 0.0f, null, 0, 464, null);
    }

    /* renamed from: getCustomColor-XeAY9LY  reason: not valid java name */
    public final long m7125getCustomColorXeAY9LY(String str, String str2, float f) {
        if (!this.transition.contains(str)) {
            return Color.Companion.m4114getUnspecified0d7_KjU();
        }
        this.transition.interpolate(getRoot().getWidth(), getRoot().getHeight(), f);
        WidgetFrame interpolated = this.transition.getInterpolated(str);
        if (!interpolated.containsCustom(str2)) {
            return Color.Companion.m4114getUnspecified0d7_KjU();
        }
        return ColorKt.Color(interpolated.getCustomColor(str2));
    }

    public final float getCustomFloat(String str, String str2, float f) {
        if (this.transition.contains(str)) {
            this.transition.interpolate(getRoot().getWidth(), getRoot().getHeight(), f);
            return this.transition.getInterpolated(str).getCustomFloat(str2);
        }
        return Float.NaN;
    }

    public final void clearConstraintSets() {
        this.transition.clear();
        getFrameCache().clear();
    }

    public final void initWith(ConstraintSet constraintSet, ConstraintSet constraintSet2, LayoutDirection layoutDirection, TransitionImpl transitionImpl, float f) {
        clearConstraintSets();
        getState().setRtl(layoutDirection == LayoutDirection.Rtl);
        constraintSet.applyTo(getState(), CollectionsKt.emptyList());
        constraintSet.applyTo(this.transition, 0);
        getState().apply(getRoot());
        this.transition.updateFrom(getRoot(), 0);
        constraintSet.applyTo(getState(), CollectionsKt.emptyList());
        constraintSet2.applyTo(this.transition, 1);
        getState().apply(getRoot());
        this.transition.updateFrom(getRoot(), 1);
        this.transition.interpolate(0, 0, f);
        transitionImpl.applyAllTo(this.transition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float transition$lambda$1(Density density, float f) {
        return density.mo389toPx0680j_4(Dp.m6684constructorimpl(f));
    }
}
