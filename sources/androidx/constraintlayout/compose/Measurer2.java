package androidx.constraintlayout.compose;

import android.util.Log;
import androidx.collection.IntIntPair;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: Measurer.kt */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u001eJ\u001a\u00105\u001a\u0002032\u0006\u00106\u001a\u000207H\u0004ø\u0001\u0000¢\u0006\u0004\b8\u00109J\b\u0010:\u001a\u000203H\u0016J\b\u0010;\u001a\u000203H\u0016J \u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u00172\u0006\u0010>\u001a\u00020\u00172\u0006\u0010?\u001a\u00020\u0007H\u0016J\u0018\u0010@\u001a\u0002032\u0006\u0010A\u001a\u00020B2\u0006\u0010@\u001a\u00020CH\u0016J\"\u0010D\u001a\u00020E2\u0006\u0010A\u001a\u00020B2\u0006\u00106\u001a\u000207H\u0002ø\u0001\u0000¢\u0006\u0004\bF\u0010GJH\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u00172\u0006\u0010M\u001a\u00020\u00172\u0006\u0010N\u001a\u00020\u00172\u0006\u0010O\u001a\u00020I2\u0006\u0010P\u001a\u00020I2\u0006\u0010Q\u001a\u00020\u00172\u0006\u0010R\u001a\u00020\u0014H\u0002JR\u0010S\u001a\u00020T2\u0006\u00106\u001a\u0002072\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020X2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020$0Z2\u0012\u0010[\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0\u000f2\u0006\u0010\\\u001a\u00020\u0017ø\u0001\u0000¢\u0006\u0004\b]\u0010^J\r\u0010_\u001a\u000203H\u0000¢\u0006\u0002\b`J\u001f\u0010a\u001a\u000203*\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010@\u001a\u00020CH\u0002¢\u0006\u0002\u0010bJ,\u0010c\u001a\u000203*\u00020d2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020$0Z2\u0012\u0010[\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00100\u000fX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R&\u0010#\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0\u000fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0012\"\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020*X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020.X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u000e\u00101\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006e"}, d2 = {"Landroidx/constraintlayout/compose/Measurer2;", "Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measurer;", "Landroidx/constraintlayout/compose/DesignInfoProvider;", "density", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/ui/unit/Density;)V", "computedLayoutResult", "", "forcedScaleFactor", "", "getForcedScaleFactor", "()F", "setForcedScaleFactor", "(F)V", "frameCache", "", "Landroidx/constraintlayout/core/state/WidgetFrame;", "getFrameCache", "()Ljava/util/Map;", "heightConstraintsHolder", "", "lastMeasures", "", "", "layoutCurrentHeight", "getLayoutCurrentHeight", "()I", "layoutCurrentWidth", "getLayoutCurrentWidth", "layoutInformationReceiver", "Landroidx/constraintlayout/compose/LayoutInformationReceiver;", "getLayoutInformationReceiver", "()Landroidx/constraintlayout/compose/LayoutInformationReceiver;", "setLayoutInformationReceiver", "(Landroidx/constraintlayout/compose/LayoutInformationReceiver;)V", "placeables", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/Placeable;", "getPlaceables", "setPlaceables", "(Ljava/util/Map;)V", "root", "Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;", "getRoot", "()Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/constraintlayout/compose/State;", "getState", "()Landroidx/constraintlayout/compose/State;", "widthConstraintsHolder", "addLayoutInformationReceiver", "", "layoutReceiver", "applyRootSize", "constraints", "Landroidx/compose/ui/unit/Constraints;", "applyRootSize-BRTryo0", "(J)V", "computeLayoutResult", "didMeasures", "getDesignInfo", "startX", "startY", "args", "measure", "constraintWidget", "Landroidx/constraintlayout/core/widgets/ConstraintWidget;", "Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;", "measureWidget", "Landroidx/collection/IntIntPair;", "measureWidget-yQShABA", "(Landroidx/constraintlayout/core/widgets/ConstraintWidget;J)J", "obtainConstraints", "", "dimensionBehaviour", "Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;", TypedValues.Custom.S_DIMENSION, "matchConstraintDefaultDimension", "measureStrategy", "otherDimensionResolved", "currentDimensionResolved", "rootMaxConstraint", "outConstraints", "performMeasure", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "constraintSet", "Landroidx/constraintlayout/compose/ConstraintSet;", "measurables", "", "placeableMap", "optimizationLevel", "performMeasure-DjhGOtQ", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/constraintlayout/compose/ConstraintSet;Ljava/util/List;Ljava/util/Map;I)J", "resetMeasureState", "resetMeasureState$constraintlayout_compose_release", "copyFrom", "([Ljava/lang/Integer;Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;)V", "performLayout", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public class Measurer2 implements BasicMeasure.Measurer, DesignInfoProvider {
    public static final int $stable = 8;
    private String computedLayoutResult = "";
    private float forcedScaleFactor;
    private final Map<String, WidgetFrame> frameCache;
    private final int[] heightConstraintsHolder;
    private final Map<String, Integer[]> lastMeasures;
    private LayoutInformationReceiver layoutInformationReceiver;
    private Map<Measurable, Placeable> placeables;
    private final ConstraintWidgetContainer root;
    private final State state;
    private final int[] widthConstraintsHolder;

    /* compiled from: Measurer.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ConstraintWidget.DimensionBehaviour.values().length];
            try {
                iArr[ConstraintWidget.DimensionBehaviour.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ConstraintWidget.DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ConstraintWidget.DimensionBehaviour.MATCH_PARENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer
    public void didMeasures() {
    }

    public Measurer2(Density density) {
        ConstraintWidgetContainer constraintWidgetContainer = new ConstraintWidgetContainer(0, 0);
        constraintWidgetContainer.setMeasurer(this);
        this.root = constraintWidgetContainer;
        this.placeables = new LinkedHashMap();
        this.lastMeasures = new LinkedHashMap();
        this.frameCache = new LinkedHashMap();
        this.state = new State(density);
        this.widthConstraintsHolder = new int[2];
        this.heightConstraintsHolder = new int[2];
        this.forcedScaleFactor = Float.NaN;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LayoutInformationReceiver getLayoutInformationReceiver() {
        return this.layoutInformationReceiver;
    }

    protected final void setLayoutInformationReceiver(LayoutInformationReceiver layoutInformationReceiver) {
        this.layoutInformationReceiver = layoutInformationReceiver;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ConstraintWidgetContainer getRoot() {
        return this.root;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Map<Measurable, Placeable> getPlaceables() {
        return this.placeables;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setPlaceables(Map<Measurable, Placeable> map) {
        this.placeables = map;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Map<String, WidgetFrame> getFrameCache() {
        return this.frameCache;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final State getState() {
        return this.state;
    }

    public final float getForcedScaleFactor() {
        return this.forcedScaleFactor;
    }

    public final void setForcedScaleFactor(float f) {
        this.forcedScaleFactor = f;
    }

    public final int getLayoutCurrentWidth() {
        return this.root.getWidth();
    }

    public final int getLayoutCurrentHeight() {
        return this.root.getHeight();
    }

    @Override // androidx.constraintlayout.compose.DesignInfoProvider
    public String getDesignInfo(int i, int i2, String str) {
        return ToolingUtilsKt.parseConstraintsToJson(this.root, this.state, i, i2, str);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer
    public void measure(ConstraintWidget constraintWidget, BasicMeasure.Measure measure) {
        boolean z;
        String str = constraintWidget.stringId;
        Integer[] numArr = this.lastMeasures.get(str);
        boolean z2 = true;
        obtainConstraints(measure.horizontalBehavior, measure.horizontalDimension, constraintWidget.mMatchConstraintDefaultWidth, measure.measureStrategy, (numArr != null ? numArr[1].intValue() : 0) == constraintWidget.getHeight(), constraintWidget.isResolvedHorizontally(), Constraints.m6637getMaxWidthimpl(this.state.m7152getRootIncomingConstraintsmsEJaDk()), this.widthConstraintsHolder);
        obtainConstraints(measure.verticalBehavior, measure.verticalDimension, constraintWidget.mMatchConstraintDefaultHeight, measure.measureStrategy, (numArr != null ? numArr[0].intValue() : 0) == constraintWidget.getWidth(), constraintWidget.isResolvedVertically(), Constraints.m6636getMaxHeightimpl(this.state.m7152getRootIncomingConstraintsmsEJaDk()), this.heightConstraintsHolder);
        int[] iArr = this.widthConstraintsHolder;
        int i = iArr[0];
        int i2 = iArr[1];
        int[] iArr2 = this.heightConstraintsHolder;
        long Constraints = ConstraintsKt.Constraints(i, i2, iArr2[0], iArr2[1]);
        if (measure.measureStrategy == BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS || measure.measureStrategy == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS || measure.horizontalBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.mMatchConstraintDefaultWidth != 0 || measure.verticalBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.mMatchConstraintDefaultHeight != 0) {
            long m7083measureWidgetyQShABA = m7083measureWidgetyQShABA(constraintWidget, Constraints);
            constraintWidget.setMeasureRequested(false);
            Integer valueOf = Integer.valueOf(IntIntPair.m30getFirstimpl(m7083measureWidgetyQShABA));
            Integer valueOf2 = Integer.valueOf(constraintWidget.mMatchConstraintMinWidth);
            if (valueOf2.intValue() <= 0) {
                valueOf2 = null;
            }
            Integer num = valueOf2;
            Integer valueOf3 = Integer.valueOf(constraintWidget.mMatchConstraintMaxWidth);
            if (valueOf3.intValue() <= 0) {
                valueOf3 = null;
            }
            int intValue = ((Number) RangesKt.coerceIn(valueOf, num, valueOf3)).intValue();
            Integer valueOf4 = Integer.valueOf(IntIntPair.m31getSecondimpl(m7083measureWidgetyQShABA));
            Integer valueOf5 = Integer.valueOf(constraintWidget.mMatchConstraintMinHeight);
            if (valueOf5.intValue() <= 0) {
                valueOf5 = null;
            }
            Integer num2 = valueOf5;
            Integer valueOf6 = Integer.valueOf(constraintWidget.mMatchConstraintMaxHeight);
            int intValue2 = ((Number) RangesKt.coerceIn(valueOf4, num2, valueOf6.intValue() > 0 ? valueOf6 : null)).intValue();
            if (intValue != IntIntPair.m30getFirstimpl(m7083measureWidgetyQShABA)) {
                Constraints = ConstraintsKt.Constraints(intValue, intValue, Constraints.m6638getMinHeightimpl(Constraints), Constraints.m6636getMaxHeightimpl(Constraints));
                z = true;
            } else {
                z = false;
            }
            if (intValue2 != IntIntPair.m31getSecondimpl(m7083measureWidgetyQShABA)) {
                Constraints = ConstraintsKt.Constraints(Constraints.m6639getMinWidthimpl(Constraints), Constraints.m6637getMaxWidthimpl(Constraints), intValue2, intValue2);
                z = true;
            }
            if (z) {
                m7083measureWidgetyQShABA(constraintWidget, Constraints);
                constraintWidget.setMeasureRequested(false);
            }
        }
        Placeable placeable = this.placeables.get(constraintWidget.getCompanionWidget());
        measure.measuredWidth = placeable != null ? placeable.getWidth() : constraintWidget.getWidth();
        measure.measuredHeight = placeable != null ? placeable.getHeight() : constraintWidget.getHeight();
        int i3 = (placeable == null || !this.state.isBaselineNeeded(constraintWidget)) ? Integer.MIN_VALUE : placeable.get(AlignmentLineKt.getFirstBaseline());
        measure.measuredHasBaseline = i3 != Integer.MIN_VALUE;
        measure.measuredBaseline = i3;
        Map<String, Integer[]> map = this.lastMeasures;
        Integer[] numArr2 = map.get(str);
        if (numArr2 == null) {
            numArr2 = new Integer[]{0, 0, Integer.MIN_VALUE};
            map.put(str, numArr2);
        }
        copyFrom(numArr2, measure);
        if (measure.measuredWidth == measure.horizontalDimension && measure.measuredHeight == measure.verticalDimension) {
            z2 = false;
        }
        measure.measuredNeedsSolverPass = z2;
    }

    public final void addLayoutInformationReceiver(LayoutInformationReceiver layoutInformationReceiver) {
        this.layoutInformationReceiver = layoutInformationReceiver;
        if (layoutInformationReceiver != null) {
            layoutInformationReceiver.setLayoutInformation(this.computedLayoutResult);
        }
    }

    public void computeLayoutResult() {
        ConstraintWidget constraintWidget;
        StringBuilder sb = new StringBuilder();
        sb.append("{   root: {interpolated: { left:  0,  top:  0,");
        sb.append("  right:   " + this.root.getWidth() + " ,");
        sb.append("  bottom:  " + this.root.getHeight() + " ,");
        sb.append(" } }");
        Iterator<ConstraintWidget> it = this.root.getChildren().iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            Object companionWidget = next.getCompanionWidget();
            if (companionWidget instanceof Measurable) {
                WidgetFrame widgetFrame = null;
                if (next.stringId == null) {
                    Measurable measurable = (Measurable) companionWidget;
                    Object layoutId = LayoutIdKt.getLayoutId(measurable);
                    if (layoutId == null) {
                        layoutId = ConstraintLayoutTagKt.getConstraintLayoutId(measurable);
                    }
                    next.stringId = layoutId != null ? layoutId.toString() : null;
                }
                WidgetFrame widgetFrame2 = this.frameCache.get(MeasurerKt.getAnyOrNullId((Measurable) companionWidget));
                if (widgetFrame2 != null && (constraintWidget = widgetFrame2.widget) != null) {
                    widgetFrame = constraintWidget.frame;
                }
                if (widgetFrame != null) {
                    sb.append(" " + next.stringId + ": {");
                    sb.append(" interpolated : ");
                    widgetFrame.serialize(sb, true);
                    sb.append("}, ");
                }
            } else if (next instanceof Guideline) {
                sb.append(" " + next.stringId + ": {");
                Guideline guideline = (Guideline) next;
                if (guideline.getOrientation() == 0) {
                    sb.append(" type: 'hGuideline', ");
                } else {
                    sb.append(" type: 'vGuideline', ");
                }
                sb.append(" interpolated: ");
                sb.append(" { left: " + guideline.getX() + ", top: " + guideline.getY() + ", right: " + (guideline.getX() + guideline.getWidth()) + ", bottom: " + (guideline.getY() + guideline.getHeight()) + " }");
                sb.append("}, ");
            }
        }
        sb.append(" }");
        String sb2 = sb.toString();
        this.computedLayoutResult = sb2;
        LayoutInformationReceiver layoutInformationReceiver = this.layoutInformationReceiver;
        if (layoutInformationReceiver != null) {
            layoutInformationReceiver.setLayoutInformation(sb2);
        }
    }

    private final boolean obtainConstraints(ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i, int i2, int i3, boolean z, boolean z2, int i4, int[] iArr) {
        int i5 = WhenMappings.$EnumSwitchMapping$0[dimensionBehaviour.ordinal()];
        if (i5 == 1) {
            iArr[0] = i;
            iArr[1] = i;
            return false;
        } else if (i5 == 2) {
            iArr[0] = 0;
            iArr[1] = i4;
            return true;
        } else if (i5 != 3) {
            if (i5 == 4) {
                iArr[0] = i4;
                iArr[1] = i4;
                return false;
            }
            throw new IllegalStateException((dimensionBehaviour + " is not supported").toString());
        } else {
            boolean z3 = z2 || ((i3 == BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS || i3 == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) && (i3 == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS || i2 != 1 || z));
            iArr[0] = z3 ? i : 0;
            if (!z3) {
                i = i4;
            }
            iArr[1] = i;
            return !z3;
        }
    }

    private final void copyFrom(Integer[] numArr, BasicMeasure.Measure measure) {
        numArr[0] = Integer.valueOf(measure.measuredWidth);
        numArr[1] = Integer.valueOf(measure.measuredHeight);
        numArr[2] = Integer.valueOf(measure.measuredBaseline);
    }

    /* renamed from: performMeasure-DjhGOtQ  reason: not valid java name */
    public final long m7085performMeasureDjhGOtQ(long j, LayoutDirection layoutDirection, ConstraintSet constraintSet, List<? extends Measurable> list, Map<Measurable, Placeable> map, int i) {
        androidx.constraintlayout.core.state.Dimension min;
        androidx.constraintlayout.core.state.Dimension min2;
        this.placeables = map;
        if (list.isEmpty()) {
            return IntSizeKt.IntSize(Constraints.m6639getMinWidthimpl(j), Constraints.m6638getMinHeightimpl(j));
        }
        State state = this.state;
        if (Constraints.m6635getHasFixedWidthimpl(j)) {
            min = androidx.constraintlayout.core.state.Dimension.createFixed(Constraints.m6637getMaxWidthimpl(j));
        } else {
            min = androidx.constraintlayout.core.state.Dimension.createWrap().min(Constraints.m6639getMinWidthimpl(j));
        }
        state.width(min);
        State state2 = this.state;
        if (Constraints.m6634getHasFixedHeightimpl(j)) {
            min2 = androidx.constraintlayout.core.state.Dimension.createFixed(Constraints.m6636getMaxHeightimpl(j));
        } else {
            min2 = androidx.constraintlayout.core.state.Dimension.createWrap().min(Constraints.m6638getMinHeightimpl(j));
        }
        state2.height(min2);
        this.state.mParent.getWidth().apply(this.state, this.root, 0);
        this.state.mParent.getHeight().apply(this.state, this.root, 1);
        this.state.m7153setRootIncomingConstraintsBRTryo0(j);
        this.state.setRtl(layoutDirection == LayoutDirection.Rtl);
        resetMeasureState$constraintlayout_compose_release();
        if (constraintSet.isDirty(list)) {
            this.state.reset();
            constraintSet.applyTo(this.state, list);
            ConstraintLayoutKt.buildMapping(this.state, list);
            this.state.apply(this.root);
        } else {
            ConstraintLayoutKt.buildMapping(this.state, list);
        }
        m7084applyRootSizeBRTryo0(j);
        this.root.updateHierarchy();
        this.root.setOptimizationLevel(i);
        ConstraintWidgetContainer constraintWidgetContainer = this.root;
        constraintWidgetContainer.measure(constraintWidgetContainer.getOptimizationLevel(), 0, 0, 0, 0, 0, 0, 0, 0);
        return IntSizeKt.IntSize(this.root.getWidth(), this.root.getHeight());
    }

    public final void resetMeasureState$constraintlayout_compose_release() {
        this.placeables.clear();
        this.lastMeasures.clear();
        this.frameCache.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: applyRootSize-BRTryo0  reason: not valid java name */
    public final void m7084applyRootSizeBRTryo0(long j) {
        this.root.setWidth(Constraints.m6637getMaxWidthimpl(j));
        this.root.setHeight(Constraints.m6636getMaxHeightimpl(j));
        this.forcedScaleFactor = Float.NaN;
        LayoutInformationReceiver layoutInformationReceiver = this.layoutInformationReceiver;
        if (layoutInformationReceiver != null && (layoutInformationReceiver == null || layoutInformationReceiver.getForcedWidth() != Integer.MIN_VALUE)) {
            LayoutInformationReceiver layoutInformationReceiver2 = this.layoutInformationReceiver;
            Intrinsics.checkNotNull(layoutInformationReceiver2);
            int forcedWidth = layoutInformationReceiver2.getForcedWidth();
            if (forcedWidth > this.root.getWidth()) {
                this.forcedScaleFactor = this.root.getWidth() / forcedWidth;
            } else {
                this.forcedScaleFactor = 1.0f;
            }
            this.root.setWidth(forcedWidth);
        }
        LayoutInformationReceiver layoutInformationReceiver3 = this.layoutInformationReceiver;
        if (layoutInformationReceiver3 != null) {
            if (layoutInformationReceiver3 == null || layoutInformationReceiver3.getForcedHeight() != Integer.MIN_VALUE) {
                LayoutInformationReceiver layoutInformationReceiver4 = this.layoutInformationReceiver;
                Intrinsics.checkNotNull(layoutInformationReceiver4);
                int forcedHeight = layoutInformationReceiver4.getForcedHeight();
                if (Float.isNaN(this.forcedScaleFactor)) {
                    this.forcedScaleFactor = 1.0f;
                }
                float height = forcedHeight > this.root.getHeight() ? this.root.getHeight() / forcedHeight : 1.0f;
                if (height < this.forcedScaleFactor) {
                    this.forcedScaleFactor = height;
                }
                this.root.setHeight(forcedHeight);
            }
        }
    }

    public final void performLayout(Placeable.PlacementScope placementScope, List<? extends Measurable> list, Map<Measurable, Placeable> map) {
        Placeable placeable;
        Placeable.PlacementScope placementScope2;
        this.placeables = map;
        int i = 0;
        if (this.frameCache.isEmpty()) {
            ArrayList<ConstraintWidget> children = this.root.getChildren();
            int size = children.size();
            for (int i2 = 0; i2 < size; i2++) {
                ConstraintWidget constraintWidget = children.get(i2);
                Object companionWidget = constraintWidget.getCompanionWidget();
                if (companionWidget instanceof Measurable) {
                    this.frameCache.put(MeasurerKt.getAnyOrNullId((Measurable) companionWidget), new WidgetFrame(constraintWidget.frame.update()));
                }
            }
        }
        int size2 = list.size();
        while (i < size2) {
            Measurable measurable = list.get(i);
            WidgetFrame widgetFrame = this.frameCache.get(MeasurerKt.getAnyOrNullId(measurable));
            if (widgetFrame == null || (placeable = this.placeables.get(measurable)) == null) {
                placementScope2 = placementScope;
            } else {
                placementScope2 = placementScope;
                ConstraintLayoutKt.m7026placeWithFrameTransformKtjjmr4$default(placementScope2, placeable, widgetFrame, 0L, 4, null);
            }
            i++;
            placementScope = placementScope2;
        }
        LayoutInformationReceiver layoutInformationReceiver = this.layoutInformationReceiver;
        if ((layoutInformationReceiver != null ? layoutInformationReceiver.getLayoutInformationMode() : null) == LayoutInfoFlags.BOUNDS) {
            computeLayoutResult();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: measureWidget-yQShABA  reason: not valid java name */
    private final long m7083measureWidgetyQShABA(ConstraintWidget constraintWidget, long j) {
        int i;
        Object companionWidget = constraintWidget.getCompanionWidget();
        String str = constraintWidget.stringId;
        int i2 = 0;
        if (constraintWidget instanceof VirtualLayout) {
            if (Constraints.m6635getHasFixedWidthimpl(j)) {
                i = 1073741824;
            } else {
                i = Constraints.m6633getHasBoundedWidthimpl(j) ? Integer.MIN_VALUE : 0;
            }
            if (Constraints.m6634getHasFixedHeightimpl(j)) {
                i2 = 1073741824;
            } else if (Constraints.m6632getHasBoundedHeightimpl(j)) {
                i2 = Integer.MIN_VALUE;
            }
            VirtualLayout virtualLayout = (VirtualLayout) constraintWidget;
            virtualLayout.measure(i, Constraints.m6637getMaxWidthimpl(j), i2, Constraints.m6636getMaxHeightimpl(j));
            return IntIntPair.m26constructorimpl(virtualLayout.getMeasuredWidth(), virtualLayout.getMeasuredHeight());
        } else if (companionWidget instanceof Measurable) {
            Placeable mo5438measureBRTryo0 = ((Measurable) companionWidget).mo5438measureBRTryo0(j);
            this.placeables.put(companionWidget, mo5438measureBRTryo0);
            return IntIntPair.m26constructorimpl(mo5438measureBRTryo0.getWidth(), mo5438measureBRTryo0.getHeight());
        } else {
            Log.w("CCL", "Nothing to measure for widget: " + str);
            return IntIntPair.m26constructorimpl(0, 0);
        }
    }
}
