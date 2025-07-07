package androidx.compose.ui.node;

import androidx.collection.MutableObjectFloatMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.PlaceableKt;
import androidx.compose.ui.layout.Ruler;
import androidx.compose.ui.layout.RulerScope;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import androidx.compose.ui.layout.VerticalRuler;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.ViewCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LookaheadDelegate.kt */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000 e2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001eB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010=\u001a\u00020>2\u0006\u0010 \u001a\u00020!2\u0006\u0010?\u001a\u000204H\u0002J\u0010\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH&J\u0017\u0010D\u001a\u00020>2\b\u0010E\u001a\u0004\u0018\u00010%H\u0000¢\u0006\u0002\bFJ\u0010\u0010D\u001a\u00020>2\u0006\u0010G\u001a\u00020HH\u0002J\u0010\u0010I\u001a\u00020\u00002\u0006\u0010?\u001a\u000204H\u0002J\u0016\u0010J\u001a\u00020K2\u0006\u0010?\u001a\u0002042\u0006\u0010L\u001a\u00020KJ\u0011\u0010M\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0086\u0002J\u0010\u0010N\u001a\u00020>2\u0006\u0010?\u001a\u000204H\u0002J`\u0010O\u001a\u00020%2\u0006\u0010P\u001a\u00020A2\u0006\u0010Q\u001a\u00020A2\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020A0S2\u0019\u0010T\u001a\u0015\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020>\u0018\u00010U¢\u0006\u0002\bV2\u0017\u0010W\u001a\u0013\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020>0U¢\u0006\u0002\bVH\u0016J\u001c\u0010X\u001a\u00020>2\u0012\u0010Y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0605H\u0002J\u0016\u0010Z\u001a\u00020>2\u0006\u0010?\u001a\u0002042\u0006\u0010[\u001a\u00020KJ\u0016\u0010\\\u001a\u00020>2\u0006\u0010?\u001a\u0002042\u0006\u0010[\u001a\u00020KJ\r\u0010]\u001a\u00020>H ¢\u0006\u0002\b^J\u0010\u0010_\u001a\u00020>2\u0006\u0010`\u001a\u00020\u0013H\u0016J\f\u0010a\u001a\u00020>*\u00020bH\u0004J\u0014\u0010c\u001a\u00020\u0013*\u00020!2\u0006\u0010d\u001a\u00020!H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0015R\u001a\u0010\u0017\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0015\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0015\"\u0004\b\u001c\u0010\u0019R\u001a\u0010\u001d\u001a\u00020\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0019R\u0012\u0010 \u001a\u00020!X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0012\u0010$\u001a\u00020%X \u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\rR\u0011\u0010*\u001a\u00020+¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0018\u0010.\u001a\u00020/X¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b0\u00101R(\u00102\u001a\u001c\u0012\u0004\u0012\u000204\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0605\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u00107\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b8\u00109R\u0016\u0010:\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010<\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006f"}, d2 = {"Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/node/MeasureScopeWithLayoutNode;", "Landroidx/compose/ui/node/MotionReferencePlacementDelegate;", "()V", "_rulerScope", "Landroidx/compose/ui/layout/RulerScope;", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "child", "getChild", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "hasMeasureResult", "", "getHasMeasureResult", "()Z", "isLookingAhead", "isPlacedUnderMotionFrameOfReference", "setPlacedUnderMotionFrameOfReference", "(Z)V", "isPlacingForAlignment", "isPlacingForAlignment$ui_release", "setPlacingForAlignment$ui_release", "isShallowPlacing", "isShallowPlacing$ui_release", "setShallowPlacing$ui_release", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "measureResult", "Landroidx/compose/ui/layout/MeasureResult;", "getMeasureResult$ui_release", "()Landroidx/compose/ui/layout/MeasureResult;", "parent", "getParent", "placementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getPlacementScope", "()Landroidx/compose/ui/layout/Placeable$PlacementScope;", "position", "Landroidx/compose/ui/unit/IntOffset;", "getPosition-nOcc-ac", "()J", "rulerReaders", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/ui/layout/Ruler;", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/ui/node/WeakReference;", "rulerScope", "getRulerScope", "()Landroidx/compose/ui/layout/RulerScope;", "rulerValues", "Landroidx/collection/MutableObjectFloatMap;", "rulerValuesCache", "addRulerReader", "", "ruler", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "captureRulers", "result", "captureRulers$ui_release", "placeableResult", "Landroidx/compose/ui/node/PlaceableResult;", "findAncestorRulerDefiner", "findRulerValue", "", "defaultValue", "get", "invalidateChildrenOfDefiningRuler", TtmlNode.TAG_LAYOUT, "width", "height", "alignmentLines", "", "rulers", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "placementBlock", "notifyRulerValueChange", "layoutNodes", "provideRelativeRulerValue", "value", "provideRulerValue", "replace", "replace$ui_release", "updatePlacedUnderMotionFrameOfReference", "newMFR", "invalidateAlignmentLinesFromPositionChange", "Landroidx/compose/ui/node/NodeCoordinator;", "isLayoutNodeAncestor", "ancestor", "Companion", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LookaheadCapablePlaceable extends Placeable implements MeasureScopeWithLayoutNode, MotionReferencePlacementDelegate {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final Function1<PlaceableResult, Unit> onCommitAffectingRuler = new Function1<PlaceableResult, Unit>() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable$Companion$onCommitAffectingRuler$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PlaceableResult placeableResult) {
            invoke2(placeableResult);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(PlaceableResult placeableResult) {
            if (placeableResult.isValidOwnerScope()) {
                placeableResult.getPlaceable().captureRulers(placeableResult);
            }
        }
    };
    private RulerScope _rulerScope;
    private boolean isPlacedUnderMotionFrameOfReference;
    private boolean isPlacingForAlignment;
    private boolean isShallowPlacing;
    private final Placeable.PlacementScope placementScope = PlaceableKt.PlacementScope(this);
    private MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> rulerReaders;
    private MutableObjectFloatMap<Ruler> rulerValues;
    private MutableObjectFloatMap<Ruler> rulerValuesCache;

    public abstract int calculateAlignmentLine(AlignmentLine alignmentLine);

    public abstract AlignmentLinesOwner getAlignmentLinesOwner();

    public abstract LookaheadCapablePlaceable getChild();

    public abstract LayoutCoordinates getCoordinates();

    public abstract boolean getHasMeasureResult();

    @Override // androidx.compose.ui.node.MeasureScopeWithLayoutNode
    public abstract LayoutNode getLayoutNode();

    public abstract MeasureResult getMeasureResult$ui_release();

    public abstract LookaheadCapablePlaceable getParent();

    /* renamed from: getPosition-nOcc-ac  reason: not valid java name */
    public abstract long mo5633getPositionnOccac();

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public boolean isLookingAhead() {
        return false;
    }

    public abstract void replace$ui_release();

    @Override // androidx.compose.ui.node.MotionReferencePlacementDelegate
    public boolean isPlacedUnderMotionFrameOfReference() {
        return this.isPlacedUnderMotionFrameOfReference;
    }

    public void setPlacedUnderMotionFrameOfReference(boolean z) {
        this.isPlacedUnderMotionFrameOfReference = z;
    }

    @Override // androidx.compose.ui.node.MotionReferencePlacementDelegate
    public void updatePlacedUnderMotionFrameOfReference(boolean z) {
        LookaheadCapablePlaceable parent = getParent();
        LayoutNode layoutNode = parent != null ? parent.getLayoutNode() : null;
        if (Intrinsics.areEqual(layoutNode, getLayoutNode())) {
            setPlacedUnderMotionFrameOfReference(z);
            return;
        }
        if ((layoutNode != null ? layoutNode.getLayoutState$ui_release() : null) != LayoutNode.LayoutState.LayingOut) {
            if ((layoutNode != null ? layoutNode.getLayoutState$ui_release() : null) != LayoutNode.LayoutState.LookaheadLayingOut) {
                return;
            }
        }
        setPlacedUnderMotionFrameOfReference(z);
    }

    public final RulerScope getRulerScope() {
        RulerScope rulerScope = this._rulerScope;
        return rulerScope == null ? new RulerScope() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable$rulerScope$1
            @Override // androidx.compose.ui.layout.RulerScope
            public LayoutCoordinates getCoordinates() {
                LookaheadCapablePlaceable.this.getLayoutNode().getLayoutDelegate$ui_release().onCoordinatesUsed();
                return LookaheadCapablePlaceable.this.getCoordinates();
            }

            @Override // androidx.compose.ui.layout.RulerScope
            public void provides(Ruler ruler, float f) {
                LookaheadCapablePlaceable.this.provideRulerValue(ruler, f);
            }

            @Override // androidx.compose.ui.layout.RulerScope
            public void providesRelative(VerticalRuler verticalRuler, float f) {
                LookaheadCapablePlaceable.this.provideRelativeRulerValue(verticalRuler, f);
            }

            @Override // androidx.compose.ui.unit.Density
            public float getDensity() {
                return LookaheadCapablePlaceable.this.getDensity();
            }

            @Override // androidx.compose.ui.unit.FontScaling
            public float getFontScale() {
                return LookaheadCapablePlaceable.this.getFontScale();
            }
        } : rulerScope;
    }

    @Override // androidx.compose.ui.layout.Measured
    public final int get(AlignmentLine alignmentLine) {
        int calculateAlignmentLine;
        int m6813getYimpl;
        if (getHasMeasureResult() && (calculateAlignmentLine = calculateAlignmentLine(alignmentLine)) != Integer.MIN_VALUE) {
            if (alignmentLine instanceof VerticalAlignmentLine) {
                m6813getYimpl = IntOffset.m6812getXimpl(m5496getApparentToRealOffsetnOccac());
            } else {
                m6813getYimpl = IntOffset.m6813getYimpl(m5496getApparentToRealOffsetnOccac());
            }
            return calculateAlignmentLine + m6813getYimpl;
        }
        return Integer.MIN_VALUE;
    }

    public final boolean isShallowPlacing$ui_release() {
        return this.isShallowPlacing;
    }

    public final void setShallowPlacing$ui_release(boolean z) {
        this.isShallowPlacing = z;
    }

    public final boolean isPlacingForAlignment$ui_release() {
        return this.isPlacingForAlignment;
    }

    public final void setPlacingForAlignment$ui_release(boolean z) {
        this.isPlacingForAlignment = z;
    }

    public final Placeable.PlacementScope getPlacementScope() {
        return this.placementScope;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void invalidateAlignmentLinesFromPositionChange(NodeCoordinator nodeCoordinator) {
        AlignmentLines alignmentLines;
        NodeCoordinator wrapped$ui_release = nodeCoordinator.getWrapped$ui_release();
        if (!Intrinsics.areEqual(wrapped$ui_release != null ? wrapped$ui_release.getLayoutNode() : null, nodeCoordinator.getLayoutNode())) {
            nodeCoordinator.getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
            return;
        }
        AlignmentLinesOwner parentAlignmentLinesOwner = nodeCoordinator.getAlignmentLinesOwner().getParentAlignmentLinesOwner();
        if (parentAlignmentLinesOwner == null || (alignmentLines = parentAlignmentLinesOwner.getAlignmentLines()) == null) {
            return;
        }
        alignmentLines.onAlignmentsChanged();
    }

    public final float findRulerValue(Ruler ruler, float f) {
        if (this.isPlacingForAlignment) {
            return f;
        }
        LookaheadCapablePlaceable lookaheadCapablePlaceable = this;
        while (true) {
            MutableObjectFloatMap<Ruler> mutableObjectFloatMap = lookaheadCapablePlaceable.rulerValues;
            float orDefault = mutableObjectFloatMap != null ? mutableObjectFloatMap.getOrDefault(ruler, Float.NaN) : Float.NaN;
            if (!Float.isNaN(orDefault)) {
                lookaheadCapablePlaceable.addRulerReader(getLayoutNode(), ruler);
                return ruler.calculateCoordinate$ui_release(orDefault, lookaheadCapablePlaceable.getCoordinates(), getCoordinates());
            }
            LookaheadCapablePlaceable parent = lookaheadCapablePlaceable.getParent();
            if (parent == null) {
                lookaheadCapablePlaceable.addRulerReader(getLayoutNode(), ruler);
                return f;
            }
            lookaheadCapablePlaceable = parent;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00a2 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void addRulerReader(LayoutNode layoutNode, Ruler ruler) {
        char c;
        long j;
        long j2;
        long j3;
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> mutableScatterMap;
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> mutableScatterMap2;
        int i;
        int i2;
        MutableScatterSet<WeakReference<LayoutNode>> mutableScatterSet;
        long[] jArr;
        long[] jArr2;
        long j4;
        int i3;
        char c2;
        long j5;
        int i4;
        int i5;
        int i6;
        boolean z;
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> mutableScatterMap3 = this.rulerReaders;
        char c3 = 7;
        long j6 = -9187201950435737472L;
        int i7 = 8;
        if (mutableScatterMap3 != null) {
            MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> mutableScatterMap4 = mutableScatterMap3;
            Object[] objArr = mutableScatterMap4.values;
            long[] jArr3 = mutableScatterMap4.metadata;
            int length = jArr3.length - 2;
            if (length >= 0) {
                int i8 = 0;
                j2 = 128;
                while (true) {
                    long j7 = jArr3[i8];
                    j3 = 255;
                    if ((((~j7) << c3) & j7 & j6) != j6) {
                        int i9 = 8 - ((~(i8 - length)) >>> 31);
                        int i10 = 0;
                        while (i10 < i9) {
                            if ((j7 & 255) < 128) {
                                c2 = c3;
                                MutableScatterSet mutableScatterSet2 = (MutableScatterSet) objArr[(i8 << 3) + i10];
                                j5 = j6;
                                Object[] objArr2 = mutableScatterSet2.elements;
                                long[] jArr4 = mutableScatterSet2.metadata;
                                int length2 = jArr4.length - 2;
                                if (length2 >= 0) {
                                    int i11 = i7;
                                    int i12 = 0;
                                    while (true) {
                                        int i13 = length2;
                                        long j8 = jArr4[i12];
                                        jArr2 = jArr3;
                                        j4 = j7;
                                        if ((((~j8) << c2) & j8 & j5) != j5) {
                                            int i14 = 8 - ((~(i12 - i13)) >>> 31);
                                            int i15 = 0;
                                            while (i15 < i14) {
                                                if ((j8 & 255) < 128) {
                                                    int i16 = (i12 << 3) + i15;
                                                    LayoutNode layoutNode2 = (LayoutNode) ((WeakReference) objArr2[i16]).get();
                                                    i5 = i15;
                                                    if (layoutNode2 != null) {
                                                        boolean isAttached = layoutNode2.isAttached();
                                                        i6 = i10;
                                                        if (isAttached) {
                                                            z = true;
                                                            if (z) {
                                                                mutableScatterSet2.removeElementAt(i16);
                                                            }
                                                        }
                                                    } else {
                                                        i6 = i10;
                                                    }
                                                    z = false;
                                                    if (z) {
                                                    }
                                                } else {
                                                    i5 = i15;
                                                    i6 = i10;
                                                }
                                                j8 >>= i11;
                                                i15 = i5 + 1;
                                                i10 = i6;
                                            }
                                            i3 = i10;
                                            if (i14 != i11) {
                                                break;
                                            }
                                        } else {
                                            i3 = i10;
                                        }
                                        length2 = i13;
                                        if (i12 == length2) {
                                            break;
                                        }
                                        i12++;
                                        jArr3 = jArr2;
                                        j7 = j4;
                                        i10 = i3;
                                        i11 = 8;
                                    }
                                } else {
                                    jArr2 = jArr3;
                                    j4 = j7;
                                    i3 = i10;
                                }
                                i4 = 8;
                            } else {
                                jArr2 = jArr3;
                                j4 = j7;
                                i3 = i10;
                                c2 = c3;
                                j5 = j6;
                                i4 = i7;
                            }
                            i7 = i4;
                            j7 = j4 >> i4;
                            c3 = c2;
                            j6 = j5;
                            i10 = i3 + 1;
                            jArr3 = jArr2;
                        }
                        jArr = jArr3;
                        c = c3;
                        j = j6;
                        if (i9 != i7) {
                            break;
                        }
                    } else {
                        jArr = jArr3;
                        c = c3;
                        j = j6;
                    }
                    if (i8 == length) {
                        break;
                    }
                    i8++;
                    c3 = c;
                    j6 = j;
                    jArr3 = jArr;
                    i7 = 8;
                }
                mutableScatterMap = this.rulerReaders;
                if (mutableScatterMap != null) {
                    long[] jArr5 = mutableScatterMap.metadata;
                    int length3 = jArr5.length - 2;
                    if (length3 >= 0) {
                        int i17 = 0;
                        while (true) {
                            long j9 = jArr5[i17];
                            if ((((~j9) << c) & j9 & j) != j) {
                                int i18 = 8 - ((~(i17 - length3)) >>> 31);
                                for (int i19 = 0; i19 < i18; i19++) {
                                    if ((j9 & j3) < j2) {
                                        int i20 = (i17 << 3) + i19;
                                        Ruler ruler2 = (Ruler) mutableScatterMap.keys[i20];
                                        if (((MutableScatterSet) mutableScatterMap.values[i20]).isEmpty()) {
                                            mutableScatterMap.removeValueAt(i20);
                                        }
                                    }
                                    j9 >>= 8;
                                }
                                if (i18 != 8) {
                                    break;
                                }
                            }
                            if (i17 == length3) {
                                break;
                            }
                            i17++;
                        }
                    }
                }
                mutableScatterMap2 = this.rulerReaders;
                if (mutableScatterMap2 != null) {
                    i = 0;
                    i2 = 1;
                    mutableScatterMap2 = new MutableScatterMap<>(0, 1, null);
                    this.rulerReaders = mutableScatterMap2;
                } else {
                    i = 0;
                    i2 = 1;
                }
                mutableScatterSet = mutableScatterMap2.get(ruler);
                if (mutableScatterSet == null) {
                    mutableScatterSet = new MutableScatterSet<>(i, i2, null);
                    mutableScatterMap2.set(ruler, mutableScatterSet);
                }
                mutableScatterSet.plusAssign((MutableScatterSet<WeakReference<LayoutNode>>) new WeakReference<>(layoutNode));
            }
        }
        c = 7;
        j = -9187201950435737472L;
        j2 = 128;
        j3 = 255;
        mutableScatterMap = this.rulerReaders;
        if (mutableScatterMap != null) {
        }
        mutableScatterMap2 = this.rulerReaders;
        if (mutableScatterMap2 != null) {
        }
        mutableScatterSet = mutableScatterMap2.get(ruler);
        if (mutableScatterSet == null) {
        }
        mutableScatterSet.plusAssign((MutableScatterSet<WeakReference<LayoutNode>>) new WeakReference<>(layoutNode));
    }

    private final LookaheadCapablePlaceable findAncestorRulerDefiner(Ruler ruler) {
        LookaheadCapablePlaceable parent;
        LookaheadCapablePlaceable lookaheadCapablePlaceable = this;
        while (true) {
            MutableObjectFloatMap<Ruler> mutableObjectFloatMap = lookaheadCapablePlaceable.rulerValues;
            if ((mutableObjectFloatMap != null && mutableObjectFloatMap.containsKey(ruler)) || (parent = lookaheadCapablePlaceable.getParent()) == null) {
                return lookaheadCapablePlaceable;
            }
            lookaheadCapablePlaceable = parent;
        }
    }

    private final boolean isLayoutNodeAncestor(LayoutNode layoutNode, LayoutNode layoutNode2) {
        if (layoutNode == layoutNode2) {
            return true;
        }
        LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
        if (parent$ui_release != null) {
            return isLayoutNodeAncestor(parent$ui_release, layoutNode2);
        }
        return false;
    }

    private final void invalidateChildrenOfDefiningRuler(Ruler ruler) {
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> mutableScatterMap = findAncestorRulerDefiner(ruler).rulerReaders;
        MutableScatterSet<WeakReference<LayoutNode>> remove = mutableScatterMap != null ? mutableScatterMap.remove(ruler) : null;
        if (remove != null) {
            notifyRulerValueChange(remove);
        }
    }

    public final void captureRulers$ui_release(MeasureResult measureResult) {
        if (measureResult != null) {
            captureRulers(new PlaceableResult(measureResult, this));
            return;
        }
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> mutableScatterMap = this.rulerReaders;
        if (mutableScatterMap != null) {
            MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> mutableScatterMap2 = mutableScatterMap;
            Object[] objArr = mutableScatterMap2.values;
            long[] jArr = mutableScatterMap2.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                notifyRulerValueChange((MutableScatterSet) objArr[(i << 3) + i3]);
                            }
                            j >>= 8;
                        }
                        if (i2 != 8) {
                            break;
                        }
                    }
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
        }
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> mutableScatterMap3 = this.rulerReaders;
        if (mutableScatterMap3 != null) {
            mutableScatterMap3.clear();
        }
        MutableObjectFloatMap<Ruler> mutableObjectFloatMap = this.rulerValues;
        if (mutableObjectFloatMap != null) {
            mutableObjectFloatMap.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:66:0x013b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void captureRulers(final PlaceableResult placeableResult) {
        long j;
        long j2;
        int length;
        LookaheadCapablePlaceable parent;
        long j3;
        MutableScatterSet<WeakReference<LayoutNode>> remove;
        OwnerSnapshotObserver snapshotObserver;
        char c;
        char c2;
        if (this.isPlacingForAlignment) {
            return;
        }
        Function1<RulerScope, Unit> rulers = placeableResult.getResult().getRulers();
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> mutableScatterMap = this.rulerReaders;
        char c3 = 7;
        int i = 8;
        if (rulers == null) {
            if (mutableScatterMap != null) {
                MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> mutableScatterMap2 = mutableScatterMap;
                Object[] objArr = mutableScatterMap2.values;
                long[] jArr = mutableScatterMap2.metadata;
                int length2 = jArr.length - 2;
                if (length2 >= 0) {
                    int i2 = 0;
                    while (true) {
                        long j4 = jArr[i2];
                        if ((((~j4) << c3) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i3 = 8 - ((~(i2 - length2)) >>> 31);
                            int i4 = 0;
                            while (i4 < i3) {
                                if ((j4 & 255) < 128) {
                                    c2 = c3;
                                    notifyRulerValueChange((MutableScatterSet) objArr[(i2 << 3) + i4]);
                                } else {
                                    c2 = c3;
                                }
                                j4 >>= 8;
                                i4++;
                                c3 = c2;
                            }
                            c = c3;
                            if (i3 != 8) {
                                break;
                            }
                        } else {
                            c = c3;
                        }
                        if (i2 == length2) {
                            break;
                        }
                        i2++;
                        c3 = c;
                    }
                }
                mutableScatterMap.clear();
                return;
            }
            return;
        }
        long j5 = 128;
        MutableObjectFloatMap<Ruler> mutableObjectFloatMap = this.rulerValuesCache;
        if (mutableObjectFloatMap == null) {
            mutableObjectFloatMap = new MutableObjectFloatMap<>(0, 1, null);
            this.rulerValuesCache = mutableObjectFloatMap;
        }
        MutableObjectFloatMap<Ruler> mutableObjectFloatMap2 = this.rulerValues;
        if (mutableObjectFloatMap2 == null) {
            mutableObjectFloatMap2 = new MutableObjectFloatMap<>(0, 1, null);
            this.rulerValues = mutableObjectFloatMap2;
        }
        MutableObjectFloatMap<Ruler> mutableObjectFloatMap3 = mutableObjectFloatMap2;
        mutableObjectFloatMap.putAll(mutableObjectFloatMap3);
        mutableObjectFloatMap2.clear();
        Owner owner$ui_release = getLayoutNode().getOwner$ui_release();
        if (owner$ui_release != null && (snapshotObserver = owner$ui_release.getSnapshotObserver()) != null) {
            snapshotObserver.observeReads$ui_release(placeableResult, onCommitAffectingRuler, new Function0<Unit>() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable$captureRulers$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Function1<RulerScope, Unit> rulers2 = PlaceableResult.this.getResult().getRulers();
                    if (rulers2 != null) {
                        rulers2.invoke(this.getRulerScope());
                    }
                }
            });
        }
        if (mutableScatterMap != null) {
            MutableObjectFloatMap<Ruler> mutableObjectFloatMap4 = mutableObjectFloatMap;
            Object[] objArr2 = mutableObjectFloatMap4.keys;
            float[] fArr = mutableObjectFloatMap4.values;
            long[] jArr2 = mutableObjectFloatMap4.metadata;
            int length3 = jArr2.length - 2;
            if (length3 >= 0) {
                j = -9187201950435737472L;
                int i5 = 0;
                while (true) {
                    long j6 = jArr2[i5];
                    int i6 = i;
                    if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i7 = 8 - ((~(i5 - length3)) >>> 31);
                        int i8 = 0;
                        while (i8 < i7) {
                            if ((j6 & 255) < j5) {
                                int i9 = (i5 << 3) + i8;
                                Ruler ruler = (Ruler) objArr2[i9];
                                j3 = j5;
                                if (mutableObjectFloatMap2.getOrDefault(ruler, Float.NaN) != fArr[i9] && (remove = mutableScatterMap.remove(ruler)) != null) {
                                    notifyRulerValueChange(remove);
                                }
                            } else {
                                j3 = j5;
                            }
                            j6 >>= i6;
                            i8++;
                            j5 = j3;
                        }
                        j2 = j5;
                        if (i7 != i6) {
                            break;
                        }
                    } else {
                        j2 = j5;
                    }
                    if (i5 == length3) {
                        break;
                    }
                    i5++;
                    j5 = j2;
                    i = 8;
                }
                Object[] objArr3 = mutableObjectFloatMap3.keys;
                long[] jArr3 = mutableObjectFloatMap3.metadata;
                length = jArr3.length - 2;
                if (length >= 0) {
                    int i10 = 0;
                    while (true) {
                        long j7 = jArr3[i10];
                        if ((((~j7) << 7) & j7 & j) != j) {
                            int i11 = 8 - ((~(i10 - length)) >>> 31);
                            for (int i12 = 0; i12 < i11; i12++) {
                                if ((j7 & 255) < j2) {
                                    Ruler ruler2 = (Ruler) objArr3[(i10 << 3) + i12];
                                    if (!mutableObjectFloatMap.containsKey(ruler2) && (parent = getParent()) != null) {
                                        parent.invalidateChildrenOfDefiningRuler(ruler2);
                                    }
                                }
                                j7 >>= 8;
                            }
                            if (i11 != 8) {
                                break;
                            }
                        }
                        if (i10 == length) {
                            break;
                        }
                        i10++;
                    }
                }
                mutableObjectFloatMap.clear();
            }
        }
        j = -9187201950435737472L;
        j2 = 128;
        Object[] objArr32 = mutableObjectFloatMap3.keys;
        long[] jArr32 = mutableObjectFloatMap3.metadata;
        length = jArr32.length - 2;
        if (length >= 0) {
        }
        mutableObjectFloatMap.clear();
    }

    private final void notifyRulerValueChange(MutableScatterSet<WeakReference<LayoutNode>> mutableScatterSet) {
        LayoutNode layoutNode;
        MutableScatterSet<WeakReference<LayoutNode>> mutableScatterSet2 = mutableScatterSet;
        Object[] objArr = mutableScatterSet2.elements;
        long[] jArr = mutableScatterSet2.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128 && (layoutNode = (LayoutNode) ((WeakReference) objArr[(i << 3) + i3]).get()) != null) {
                        if (isLookingAhead()) {
                            layoutNode.requestLookaheadRelayout$ui_release(false);
                        } else {
                            layoutNode.requestRelayout$ui_release(false);
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            }
            i++;
        }
    }

    public final void provideRulerValue(Ruler ruler, float f) {
        MutableObjectFloatMap<Ruler> mutableObjectFloatMap = this.rulerValues;
        if (mutableObjectFloatMap == null) {
            mutableObjectFloatMap = new MutableObjectFloatMap<>(0, 1, null);
            this.rulerValues = mutableObjectFloatMap;
        }
        mutableObjectFloatMap.set(ruler, f);
    }

    public final void provideRelativeRulerValue(Ruler ruler, float f) {
        MutableObjectFloatMap<Ruler> mutableObjectFloatMap = this.rulerValues;
        if (mutableObjectFloatMap == null) {
            mutableObjectFloatMap = new MutableObjectFloatMap<>(0, 1, null);
            this.rulerValues = mutableObjectFloatMap;
        }
        if (getLayoutDirection() != LayoutDirection.Ltr) {
            f = getWidth() - f;
        }
        mutableObjectFloatMap.set(ruler, f);
    }

    /* compiled from: LookaheadDelegate.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/node/LookaheadCapablePlaceable$Companion;", "", "()V", "onCommitAffectingRuler", "Lkotlin/Function1;", "Landroidx/compose/ui/node/PlaceableResult;", "", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public MeasureResult layout(final int i, final int i2, final Map<AlignmentLine, Integer> map, final Function1<? super RulerScope, Unit> function1, final Function1<? super Placeable.PlacementScope, Unit> function12) {
        if (!((i & ViewCompat.MEASURED_STATE_MASK) == 0 && ((-16777216) & i2) == 0)) {
            InlineClassHelperKt.throwIllegalStateException("Size(" + i + " x " + i2 + ") is out of range. Each dimension must be between 0 and 16777215.");
        }
        return new MeasureResult() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable$layout$1
            @Override // androidx.compose.ui.layout.MeasureResult
            public int getWidth() {
                return i;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public int getHeight() {
                return i2;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public Map<AlignmentLine, Integer> getAlignmentLines() {
                return map;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public Function1<RulerScope, Unit> getRulers() {
                return function1;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public void placeChildren() {
                function12.invoke(this.getPlacementScope());
            }
        };
    }
}
