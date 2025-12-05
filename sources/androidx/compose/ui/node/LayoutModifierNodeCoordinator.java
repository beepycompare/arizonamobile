package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.ApproachLayoutModifierNode;
import androidx.compose.ui.layout.ApproachMeasureScopeImpl;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.RulerScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.AdRevenueConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LayoutModifierNodeCoordinator.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 H2\u00020\u0001:\u0002GHB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010#\u001a\u00020$H\u0016J\u0017\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0016H\u0016¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+H\u0016J\u0010\u0010-\u001a\u00020+2\u0006\u0010,\u001a\u00020+H\u0016J\u0010\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u00020+H\u0016J\u0010\u00100\u001a\u00020+2\u0006\u0010/\u001a\u00020+H\u0016J'\u00101\u001a\u00020$2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0014¢\u0006\u0004\b8\u00109J:\u00101\u001a\u00020$2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0019\u0010:\u001a\u0015\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020$\u0018\u00010;¢\u0006\u0002\b=H\u0014¢\u0006\u0004\b8\u0010>J\b\u0010?\u001a\u00020$H\u0002J\u0010\u0010@\u001a\u00020+2\u0006\u0010A\u001a\u00020BH\u0016J\u001a\u0010C\u001a\u00020$2\u0006\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u000107H\u0016R$\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR(\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\b\u001a\u0004\u0018\u00010\u001b@TX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;", "Landroidx/compose/ui/node/NodeCoordinator;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "measureNode", "Landroidx/compose/ui/node/LayoutModifierNode;", "<init>", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/node/LayoutModifierNode;)V", "value", "layoutModifierNode", "getLayoutModifierNode", "()Landroidx/compose/ui/node/LayoutModifierNode;", "setLayoutModifierNode$ui", "(Landroidx/compose/ui/node/LayoutModifierNode;)V", "tail", "Landroidx/compose/ui/Modifier$Node;", "getTail", "()Landroidx/compose/ui/Modifier$Node;", "wrappedNonNull", "getWrappedNonNull", "()Landroidx/compose/ui/node/NodeCoordinator;", "lookaheadConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLookaheadConstraints-DWUhwKw$ui", "()Landroidx/compose/ui/unit/Constraints;", "setLookaheadConstraints-_Sx5XlM$ui", "(Landroidx/compose/ui/unit/Constraints;)V", "Landroidx/compose/ui/node/LookaheadDelegate;", "lookaheadDelegate", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "setLookaheadDelegate", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "approachMeasureScope", "Landroidx/compose/ui/layout/ApproachMeasureScopeImpl;", "ensureLookaheadDelegateCreated", "", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicWidth", "", "height", "maxIntrinsicWidth", "minIntrinsicHeight", "width", "maxIntrinsicHeight", "placeAt", "position", "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "", AdRevenueConstants.LAYER_KEY, "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "placeAt-f8xVGno", "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "(JFLkotlin/jvm/functions/Function1;)V", "onAfterPlaceAt", "calculateAlignmentLine", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "performDraw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "graphicsLayer", "LookaheadDelegateForLayoutModifierNode", "Companion", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LayoutModifierNodeCoordinator extends NodeCoordinator {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final Paint modifierBoundsPaint;
    private ApproachMeasureScopeImpl approachMeasureScope;
    private LayoutModifierNode layoutModifierNode;
    private Constraints lookaheadConstraints;
    private LookaheadDelegate lookaheadDelegate;

    public LayoutModifierNodeCoordinator(LayoutNode layoutNode, LayoutModifierNode layoutModifierNode) {
        super(layoutNode);
        this.layoutModifierNode = layoutModifierNode;
        ApproachMeasureScopeImpl approachMeasureScopeImpl = null;
        this.lookaheadDelegate = layoutNode.getLookaheadRoot$ui() != null ? new LookaheadDelegateForLayoutModifierNode() : null;
        if ((layoutModifierNode.getNode().getKindSet$ui() & NodeKind.m7195constructorimpl(512)) != 0) {
            Intrinsics.checkNotNull(layoutModifierNode, "null cannot be cast to non-null type androidx.compose.ui.layout.ApproachLayoutModifierNode");
            approachMeasureScopeImpl = new ApproachMeasureScopeImpl(this, (ApproachLayoutModifierNode) layoutModifierNode);
        }
        this.approachMeasureScope = approachMeasureScopeImpl;
    }

    public final LayoutModifierNode getLayoutModifierNode() {
        return this.layoutModifierNode;
    }

    public final void setLayoutModifierNode$ui(LayoutModifierNode layoutModifierNode) {
        if (!Intrinsics.areEqual(layoutModifierNode, this.layoutModifierNode)) {
            Modifier.Node node = layoutModifierNode.getNode();
            if ((node.getKindSet$ui() & NodeKind.m7195constructorimpl(512)) != 0) {
                Intrinsics.checkNotNull(layoutModifierNode, "null cannot be cast to non-null type androidx.compose.ui.layout.ApproachLayoutModifierNode");
                ApproachLayoutModifierNode approachLayoutModifierNode = (ApproachLayoutModifierNode) layoutModifierNode;
                ApproachMeasureScopeImpl approachMeasureScopeImpl = this.approachMeasureScope;
                if (approachMeasureScopeImpl != null) {
                    approachMeasureScopeImpl.setApproachNode(approachLayoutModifierNode);
                } else {
                    approachMeasureScopeImpl = new ApproachMeasureScopeImpl(this, approachLayoutModifierNode);
                }
                this.approachMeasureScope = approachMeasureScopeImpl;
            } else {
                this.approachMeasureScope = null;
            }
        }
        this.layoutModifierNode = layoutModifierNode;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public Modifier.Node getTail() {
        return this.layoutModifierNode.getNode();
    }

    public final NodeCoordinator getWrappedNonNull() {
        NodeCoordinator wrapped$ui = getWrapped$ui();
        Intrinsics.checkNotNull(wrapped$ui);
        return wrapped$ui;
    }

    /* renamed from: getLookaheadConstraints-DWUhwKw$ui  reason: not valid java name */
    public final Constraints m7094getLookaheadConstraintsDWUhwKw$ui() {
        return this.lookaheadConstraints;
    }

    /* renamed from: setLookaheadConstraints-_Sx5XlM$ui  reason: not valid java name */
    public final void m7095setLookaheadConstraints_Sx5XlM$ui(Constraints constraints) {
        this.lookaheadConstraints = constraints;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public LookaheadDelegate getLookaheadDelegate() {
        return this.lookaheadDelegate;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    protected void setLookaheadDelegate(LookaheadDelegate lookaheadDelegate) {
        this.lookaheadDelegate = lookaheadDelegate;
    }

    /* compiled from: LayoutModifierNodeCoordinator.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/node/LayoutModifierNodeCoordinator$LookaheadDelegateForLayoutModifierNode;", "Landroidx/compose/ui/node/LookaheadDelegate;", "<init>", "(Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;)V", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "minIntrinsicWidth", "height", "maxIntrinsicWidth", "minIntrinsicHeight", "width", "maxIntrinsicHeight", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    private final class LookaheadDelegateForLayoutModifierNode extends LookaheadDelegate {
        public LookaheadDelegateForLayoutModifierNode() {
            super(LayoutModifierNodeCoordinator.this);
        }

        @Override // androidx.compose.ui.layout.Measurable
        /* renamed from: measure-BRTryo0 */
        public Placeable mo6875measureBRTryo0(long j) {
            LookaheadDelegateForLayoutModifierNode lookaheadDelegateForLayoutModifierNode = this;
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = LayoutModifierNodeCoordinator.this;
            LookaheadDelegate.m7129access$setMeasurementConstraintsBRTryo0(lookaheadDelegateForLayoutModifierNode, j);
            layoutModifierNodeCoordinator.m7095setLookaheadConstraints_Sx5XlM$ui(Constraints.m8198boximpl(j));
            LookaheadDelegate lookaheadDelegate = layoutModifierNodeCoordinator.getWrappedNonNull().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            LookaheadDelegate.access$set_measureResult(lookaheadDelegateForLayoutModifierNode, layoutModifierNodeCoordinator.getLayoutModifierNode().mo82measure3p2s80s(this, lookaheadDelegate, j));
            return lookaheadDelegateForLayoutModifierNode;
        }

        @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
        public int calculateAlignmentLine(AlignmentLine alignmentLine) {
            int calculateAlignmentAndPlaceChildAsNeeded;
            calculateAlignmentAndPlaceChildAsNeeded = LayoutModifierNodeCoordinatorKt.calculateAlignmentAndPlaceChildAsNeeded(this, alignmentLine);
            getCachedAlignmentLinesMap().set(alignmentLine, calculateAlignmentAndPlaceChildAsNeeded);
            return calculateAlignmentAndPlaceChildAsNeeded;
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate, androidx.compose.ui.layout.IntrinsicMeasurable
        public int minIntrinsicWidth(int i) {
            LayoutModifierNode layoutModifierNode = LayoutModifierNodeCoordinator.this.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate = LayoutModifierNodeCoordinator.this.getWrappedNonNull().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return layoutModifierNode.minIntrinsicWidth(this, lookaheadDelegate, i);
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate, androidx.compose.ui.layout.IntrinsicMeasurable
        public int maxIntrinsicWidth(int i) {
            LayoutModifierNode layoutModifierNode = LayoutModifierNodeCoordinator.this.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate = LayoutModifierNodeCoordinator.this.getWrappedNonNull().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return layoutModifierNode.maxIntrinsicWidth(this, lookaheadDelegate, i);
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate, androidx.compose.ui.layout.IntrinsicMeasurable
        public int minIntrinsicHeight(int i) {
            LayoutModifierNode layoutModifierNode = LayoutModifierNodeCoordinator.this.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate = LayoutModifierNodeCoordinator.this.getWrappedNonNull().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return layoutModifierNode.minIntrinsicHeight(this, lookaheadDelegate, i);
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate, androidx.compose.ui.layout.IntrinsicMeasurable
        public int maxIntrinsicHeight(int i) {
            LayoutModifierNode layoutModifierNode = LayoutModifierNodeCoordinator.this.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate = LayoutModifierNodeCoordinator.this.getWrappedNonNull().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return layoutModifierNode.maxIntrinsicHeight(this, lookaheadDelegate, i);
        }
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public void ensureLookaheadDelegateCreated() {
        if (getLookaheadDelegate() == null) {
            setLookaheadDelegate(new LookaheadDelegateForLayoutModifierNode());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00be, code lost:
        if (r1 == null) goto L38;
     */
    @Override // androidx.compose.ui.layout.Measurable
    /* renamed from: measure-BRTryo0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Placeable mo6875measureBRTryo0(long j) {
        final MeasureResult mo82measure3p2s80s;
        if (getForceMeasureWithLookaheadConstraints$ui()) {
            Constraints constraints = this.lookaheadConstraints;
            if (constraints == null) {
                throw new IllegalArgumentException("Lookahead constraints cannot be null in approach pass.".toString());
            }
            j = constraints.m8217unboximpl();
        }
        m6940setMeasurementConstraintsBRTryo0(j);
        ApproachMeasureScopeImpl approachMeasureScopeImpl = this.approachMeasureScope;
        if (approachMeasureScopeImpl != null) {
            ApproachLayoutModifierNode approachNode = approachMeasureScopeImpl.getApproachNode();
            boolean z = false;
            approachMeasureScopeImpl.setApproachMeasureRequired$ui(approachNode.mo88isMeasurementApproachInProgressozmzZPI(approachMeasureScopeImpl.mo6853getLookaheadSizeYbymL2g()) || !Constraints.m8203equalsimpl(j, m7094getLookaheadConstraintsDWUhwKw$ui()));
            if (!approachMeasureScopeImpl.getApproachMeasureRequired$ui()) {
                getWrappedNonNull().setForceMeasureWithLookaheadConstraints$ui(true);
            }
            mo82measure3p2s80s = approachNode.mo87approachMeasure3p2s80s(approachMeasureScopeImpl, getWrappedNonNull(), j);
            getWrappedNonNull().setForceMeasureWithLookaheadConstraints$ui(false);
            int width = mo82measure3p2s80s.getWidth();
            LookaheadDelegate lookaheadDelegate = getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            if (width == lookaheadDelegate.getWidth()) {
                int height = mo82measure3p2s80s.getHeight();
                LookaheadDelegate lookaheadDelegate2 = getLookaheadDelegate();
                Intrinsics.checkNotNull(lookaheadDelegate2);
                if (height == lookaheadDelegate2.getHeight()) {
                    z = true;
                }
            }
            if (!approachMeasureScopeImpl.getApproachMeasureRequired$ui()) {
                long mo6883getSizeYbymL2g = getWrappedNonNull().mo6883getSizeYbymL2g();
                LookaheadDelegate lookaheadDelegate3 = getWrappedNonNull().getLookaheadDelegate();
                if (IntSize.m8426equalsimpl(mo6883getSizeYbymL2g, lookaheadDelegate3 != null ? IntSize.m8421boximpl(lookaheadDelegate3.m7132getSizeYbymL2g$ui()) : null) && !z) {
                    mo82measure3p2s80s = new MeasureResult(this) { // from class: androidx.compose.ui.node.LayoutModifierNodeCoordinator$measure$1$1$1$1
                        private final int height;
                        private final int width;

                        @Override // androidx.compose.ui.layout.MeasureResult
                        public Map<AlignmentLine, Integer> getAlignmentLines() {
                            return MeasureResult.this.getAlignmentLines();
                        }

                        @Override // androidx.compose.ui.layout.MeasureResult
                        public Function1<RulerScope, Unit> getRulers() {
                            return MeasureResult.this.getRulers();
                        }

                        @Override // androidx.compose.ui.layout.MeasureResult
                        public void placeChildren() {
                            MeasureResult.this.placeChildren();
                        }

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            LookaheadDelegate lookaheadDelegate4 = this.getLookaheadDelegate();
                            Intrinsics.checkNotNull(lookaheadDelegate4);
                            this.width = lookaheadDelegate4.getWidth();
                            LookaheadDelegate lookaheadDelegate5 = this.getLookaheadDelegate();
                            Intrinsics.checkNotNull(lookaheadDelegate5);
                            this.height = lookaheadDelegate5.getHeight();
                        }

                        @Override // androidx.compose.ui.layout.MeasureResult
                        public int getWidth() {
                            return this.width;
                        }

                        @Override // androidx.compose.ui.layout.MeasureResult
                        public int getHeight() {
                            return this.height;
                        }
                    };
                }
            }
        }
        mo82measure3p2s80s = getLayoutModifierNode().mo82measure3p2s80s(this, getWrappedNonNull(), j);
        setMeasureResult$ui(mo82measure3p2s80s);
        LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = this;
        onMeasured();
        return layoutModifierNodeCoordinator;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int minIntrinsicWidth(int i) {
        ApproachMeasureScopeImpl approachMeasureScopeImpl = this.approachMeasureScope;
        if (approachMeasureScopeImpl != null) {
            return approachMeasureScopeImpl.getApproachNode().minApproachIntrinsicWidth(approachMeasureScopeImpl, getWrappedNonNull(), i);
        }
        return this.layoutModifierNode.minIntrinsicWidth(this, getWrappedNonNull(), i);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int maxIntrinsicWidth(int i) {
        ApproachMeasureScopeImpl approachMeasureScopeImpl = this.approachMeasureScope;
        if (approachMeasureScopeImpl != null) {
            return approachMeasureScopeImpl.getApproachNode().maxApproachIntrinsicWidth(approachMeasureScopeImpl, getWrappedNonNull(), i);
        }
        return this.layoutModifierNode.maxIntrinsicWidth(this, getWrappedNonNull(), i);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int minIntrinsicHeight(int i) {
        ApproachMeasureScopeImpl approachMeasureScopeImpl = this.approachMeasureScope;
        if (approachMeasureScopeImpl != null) {
            return approachMeasureScopeImpl.getApproachNode().minApproachIntrinsicHeight(approachMeasureScopeImpl, getWrappedNonNull(), i);
        }
        return this.layoutModifierNode.minIntrinsicHeight(this, getWrappedNonNull(), i);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int maxIntrinsicHeight(int i) {
        ApproachMeasureScopeImpl approachMeasureScopeImpl = this.approachMeasureScope;
        if (approachMeasureScopeImpl != null) {
            return approachMeasureScopeImpl.getApproachNode().maxApproachIntrinsicHeight(approachMeasureScopeImpl, getWrappedNonNull(), i);
        }
        return this.layoutModifierNode.maxIntrinsicHeight(this, getWrappedNonNull(), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.node.NodeCoordinator, androidx.compose.ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    public void mo6938placeAtf8xVGno(long j, float f, GraphicsLayer graphicsLayer) {
        super.mo6938placeAtf8xVGno(j, f, graphicsLayer);
        onAfterPlaceAt();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.node.NodeCoordinator, androidx.compose.ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    public void mo6876placeAtf8xVGno(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
        super.mo6876placeAtf8xVGno(j, f, function1);
        onAfterPlaceAt();
    }

    private final void onAfterPlaceAt() {
        boolean z;
        if (isShallowPlacing$ui()) {
            return;
        }
        onPlaced();
        NodeCoordinator wrappedNonNull = getWrappedNonNull();
        ApproachMeasureScopeImpl approachMeasureScopeImpl = this.approachMeasureScope;
        if (approachMeasureScopeImpl != null) {
            ApproachLayoutModifierNode approachNode = approachMeasureScopeImpl.getApproachNode();
            Placeable.PlacementScope placementScope = getPlacementScope();
            LookaheadDelegate lookaheadDelegate = getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            if (!approachNode.isPlacementApproachInProgress(placementScope, lookaheadDelegate.getLookaheadLayoutCoordinates()) && !approachMeasureScopeImpl.getApproachMeasureRequired$ui()) {
                long j = mo6883getSizeYbymL2g();
                LookaheadDelegate lookaheadDelegate2 = getLookaheadDelegate();
                if (IntSize.m8426equalsimpl(j, lookaheadDelegate2 != null ? IntSize.m8421boximpl(lookaheadDelegate2.m7132getSizeYbymL2g$ui()) : null)) {
                    long mo6883getSizeYbymL2g = wrappedNonNull.mo6883getSizeYbymL2g();
                    LookaheadDelegate lookaheadDelegate3 = wrappedNonNull.getLookaheadDelegate();
                    if (IntSize.m8426equalsimpl(mo6883getSizeYbymL2g, lookaheadDelegate3 != null ? IntSize.m8421boximpl(lookaheadDelegate3.m7132getSizeYbymL2g$ui()) : null)) {
                        z = true;
                        wrappedNonNull.setForcePlaceWithLookaheadOffset$ui(z);
                    }
                }
            }
            z = false;
            wrappedNonNull.setForcePlaceWithLookaheadOffset$ui(z);
        }
        wrappedNonNull.setPlacingForAlignment$ui(isPlacingForAlignment$ui());
        getMeasureResult$ui().placeChildren();
        wrappedNonNull.setPlacingForAlignment$ui(false);
        wrappedNonNull.setForcePlaceWithLookaheadOffset$ui(false);
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public int calculateAlignmentLine(AlignmentLine alignmentLine) {
        int calculateAlignmentAndPlaceChildAsNeeded;
        LookaheadDelegate lookaheadDelegate = getLookaheadDelegate();
        if (lookaheadDelegate != null) {
            return lookaheadDelegate.getCachedAlignmentLine$ui(alignmentLine);
        }
        calculateAlignmentAndPlaceChildAsNeeded = LayoutModifierNodeCoordinatorKt.calculateAlignmentAndPlaceChildAsNeeded(this, alignmentLine);
        return calculateAlignmentAndPlaceChildAsNeeded;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public void performDraw(Canvas canvas, GraphicsLayer graphicsLayer) {
        NodeCoordinator wrapped$ui;
        getWrappedNonNull().draw(canvas, graphicsLayer);
        if (!LayoutNodeKt.requireOwner(getLayoutNode()).getShowLayoutBounds() || (wrapped$ui = getWrapped$ui()) == null) {
            return;
        }
        if (IntSize.m8427equalsimpl0(mo6883getSizeYbymL2g(), wrapped$ui.mo6883getSizeYbymL2g()) && IntOffset.m8385equalsimpl0(wrapped$ui.mo7124getPositionnOccac(), IntOffset.Companion.m8397getZeronOccac())) {
            return;
        }
        drawBorder(canvas, modifierBoundsPaint);
    }

    /* compiled from: LayoutModifierNodeCoordinator.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/node/LayoutModifierNodeCoordinator$Companion;", "", "<init>", "()V", "modifierBoundsPaint", "Landroidx/compose/ui/graphics/Paint;", "getModifierBoundsPaint", "()Landroidx/compose/ui/graphics/Paint;", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Paint getModifierBoundsPaint() {
            return LayoutModifierNodeCoordinator.modifierBoundsPaint;
        }
    }

    static {
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.mo5300setColor8_81llA(Color.Companion.m5451getBlue0d7_KjU());
        Paint.setStrokeWidth(1.0f);
        Paint.mo5304setStylek9PVt8s(PaintingStyle.Companion.m5708getStrokeTiuSbCo());
        modifierBoundsPaint = Paint;
    }
}
