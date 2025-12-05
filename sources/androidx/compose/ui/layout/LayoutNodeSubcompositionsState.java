package androidx.compose.ui.layout;

import androidx.collection.IntSetKt;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PausableComposition;
import androidx.compose.runtime.PausedComposition;
import androidx.compose.runtime.ReusableComposition;
import androidx.compose.runtime.ShouldPauseCallback;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.layout.SubcomposeSlotReusePolicy;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeKt;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.LookaheadPassDelegate;
import androidx.compose.ui.node.MeasurePassDelegate;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.OutOfFrameExecutor;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.platform.SubcompositionKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SubcomposeLayout.kt */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0001\u0018\u00002\u00020\u0001:\u0003opqB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020)H\u0016J\b\u0010+\u001a\u00020)H\u0016J.\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2\b\u0010/\u001a\u0004\u0018\u00010\u001a2\u0011\u00100\u001a\r\u0012\u0004\u0012\u00020)01¢\u0006\u0002\b2¢\u0006\u0002\u00103J:\u0010,\u001a\u00020)2\u0006\u00104\u001a\u00020\u00032\b\u0010/\u001a\u0004\u0018\u00010\u001a2\u0006\u00105\u001a\u0002062\u0011\u00100\u001a\r\u0012\u0004\u0012\u00020)01¢\u0006\u0002\b2H\u0002¢\u0006\u0002\u00107J \u0010,\u001a\u00020)2\u0006\u00104\u001a\u00020\u00032\u0006\u0010<\u001a\u00020\u00182\u0006\u00105\u001a\u000206H\u0002J \u0010=\u001a\u0004\u0018\u00010\u001a2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00030-2\u0006\u0010?\u001a\u00020\u0014H\u0002J\u000e\u0010@\u001a\u00020)2\u0006\u0010A\u001a\u00020\u0014J\u0014\u0010B\u001a\u00020)*\u00020\u00182\u0006\u0010C\u001a\u000209H\u0002J\u0010\u0010D\u001a\u00020)2\u0006\u0010E\u001a\u000206H\u0002J\b\u0010F\u001a\u00020)H\u0002J\u0006\u0010G\u001a\u00020)J\f\u0010H\u001a\u00020)*\u00020\u0003H\u0002J\u0014\u0010I\u001a\u0004\u0018\u00010\u00032\b\u0010/\u001a\u0004\u0018\u00010\u001aH\u0002J%\u0010J\u001a\u00020K2\u001d\u0010L\u001a\u0019\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020P0M¢\u0006\u0002\bQJ\b\u0010R\u001a\u00020)H\u0002J!\u0010S\u001a\u00020P2\u0006\u0010T\u001a\u00020P2\u000e\b\u0004\u0010U\u001a\b\u0012\u0004\u0012\u00020)01H\u0082\bJ(\u0010X\u001a\u00020#2\b\u0010/\u001a\u0004\u0018\u00010\u001a2\u0011\u00100\u001a\r\u0012\u0004\u0012\u00020)01¢\u0006\u0002\b2¢\u0006\u0002\u0010YJ2\u0010X\u001a\u00020)2\b\u0010/\u001a\u0004\u0018\u00010\u001a2\u0011\u00100\u001a\r\u0012\u0004\u0012\u00020)01¢\u0006\u0002\b22\u0006\u00105\u001a\u000206H\u0002¢\u0006\u0002\u0010ZJ\u0014\u0010[\u001a\u00020)*\u00020\u00182\u0006\u0010\\\u001a\u000206H\u0002J\f\u0010]\u001a\u00020)*\u00020\u0018H\u0002J\u0012\u0010^\u001a\u00020)2\b\u0010/\u001a\u0004\u0018\u00010\u001aH\u0002J\u0012\u0010_\u001a\u00020#2\b\u0010/\u001a\u0004\u0018\u00010\u001aH\u0002J(\u0010`\u001a\u00020a2\b\u0010/\u001a\u0004\u0018\u00010\u001a2\u0011\u00100\u001a\r\u0012\u0004\u0012\u00020)01¢\u0006\u0002\b2¢\u0006\u0002\u0010bJ\u0006\u0010c\u001a\u00020)J\u0010\u0010d\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u0014H\u0002J\"\u0010e\u001a\u00020)2\u0006\u0010f\u001a\u00020\u00142\u0006\u0010g\u001a\u00020\u00142\b\b\u0002\u0010h\u001a\u00020\u0014H\u0002J\"\u0010i\u001a\u0002Hj\"\u0004\b\u0000\u0010j2\f\u0010L\u001a\b\u0012\u0004\u0012\u0002Hj01H\u0082\b¢\u0006\u0002\u0010kJ\u0014\u0010l\u001a\u00020)*\u00020\u00182\u0006\u0010m\u001a\u000206H\u0002J0\u0010n\u001a\b\u0012\u0004\u0012\u00020.0-2\b\u0010/\u001a\u0004\u0018\u00010\u001a2\u0011\u00100\u001a\r\u0012\u0004\u0012\u00020)01¢\u0006\u0002\b2H\u0002¢\u0006\u0002\u00103R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020\u00030\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u00060\u001cR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00060\u001eR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020\u00030\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020#0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00108\u001a\u0004\u0018\u0001098BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u000e\u0010V\u001a\u00020WX\u0082D¢\u0006\u0002\n\u0000¨\u0006r"}, d2 = {"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "root", "Landroidx/compose/ui/node/LayoutNode;", "slotReusePolicy", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "<init>", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;)V", "compositionContext", "Landroidx/compose/runtime/CompositionContext;", "getCompositionContext", "()Landroidx/compose/runtime/CompositionContext;", "setCompositionContext", "(Landroidx/compose/runtime/CompositionContext;)V", "value", "getSlotReusePolicy", "()Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "setSlotReusePolicy", "(Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;)V", "currentIndex", "", "currentApproachIndex", "nodeToNodeState", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$NodeState;", "slotIdToNode", "", "scope", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$Scope;", "approachMeasureScope", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$ApproachMeasureScopeImpl;", "precomposeMap", "reusableSlotIdsSet", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy$SlotIdsSet;", "approachPrecomposeSlotHandleMap", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "slotIdsOfCompositionsNeededInApproach", "Landroidx/compose/runtime/collection/MutableVector;", "reusableCount", "precomposedCount", "onReuse", "", "onDeactivate", "onRelease", "subcompose", "", "Landroidx/compose/ui/layout/Measurable;", "slotId", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "node", "pausable", "", "(Landroidx/compose/ui/node/LayoutNode;Ljava/lang/Object;ZLkotlin/jvm/functions/Function2;)V", "outOfFrameExecutor", "Landroidx/compose/ui/node/OutOfFrameExecutor;", "getOutOfFrameExecutor", "()Landroidx/compose/ui/node/OutOfFrameExecutor;", "nodeState", "getSlotIdAtIndex", "foldedChildren", FirebaseAnalytics.Param.INDEX, "disposeOrReuseStartingFromIndex", "startIndex", "deactivateOutOfFrame", "executor", "markActiveNodesAsReused", "deactivate", "disposeCurrentNodes", "makeSureStateIsConsistent", "resetLayoutState", "takeNodeFromReusables", "createMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "block", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "disposeUnusedSlotsInApproach", "createMeasureResult", "result", "placeChildrenBlock", "NoIntrinsicsMessage", "", "precompose", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Z)V", "reuseComposition", "forceDeactivate", "cancelPausedPrecomposition", "disposePrecomposedSlot", "createPrecomposedSlotHandle", "precomposePaused", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PausedPrecomposition;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/layout/SubcomposeLayoutState$PausedPrecomposition;", "forceRecomposeChildren", "createNodeAt", "move", "from", TypedValues.TransitionType.S_TO, "count", "ignoreRemeasureRequests", ExifInterface.GPS_DIRECTION_TRUE, "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "applyPausedPrecomposition", "shouldComplete", "approachSubcompose", "NodeState", "Scope", "ApproachMeasureScopeImpl", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LayoutNodeSubcompositionsState implements ComposeNodeLifecycleCallback {
    public static final int $stable = 8;
    private CompositionContext compositionContext;
    private int currentApproachIndex;
    private int currentIndex;
    private int precomposedCount;
    private int reusableCount;
    private final LayoutNode root;
    private SubcomposeSlotReusePolicy slotReusePolicy;
    private final MutableScatterMap<LayoutNode, NodeState> nodeToNodeState = ScatterMapKt.mutableScatterMapOf();
    private final MutableScatterMap<Object, LayoutNode> slotIdToNode = ScatterMapKt.mutableScatterMapOf();
    private final Scope scope = new Scope();
    private final ApproachMeasureScopeImpl approachMeasureScope = new ApproachMeasureScopeImpl();
    private final MutableScatterMap<Object, LayoutNode> precomposeMap = ScatterMapKt.mutableScatterMapOf();
    private final SubcomposeSlotReusePolicy.SlotIdsSet reusableSlotIdsSet = new SubcomposeSlotReusePolicy.SlotIdsSet(null, 1, null);
    private final MutableScatterMap<Object, SubcomposeLayoutState.PrecomposedSlotHandle> approachPrecomposeSlotHandleMap = ScatterMapKt.mutableScatterMapOf();
    private final MutableVector<Object> slotIdsOfCompositionsNeededInApproach = new MutableVector<>(new Object[16], 0);
    private final String NoIntrinsicsMessage = "Asking for intrinsic measurements of SubcomposeLayout layouts is not supported. This includes components that are built on top of SubcomposeLayout, such as lazy lists, BoxWithConstraints, TabRow, etc. To mitigate this:\n- if intrinsic measurements are used to achieve 'match parent' sizing, consider replacing the parent of the component with a custom layout which controls the order in which children are measured, making intrinsic measurement not needed\n- adding a size modifier to the component, in order to fast return the queried intrinsic measurement.";

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean applyPausedPrecomposition$lambda$0$0$0() {
        return false;
    }

    public LayoutNodeSubcompositionsState(LayoutNode layoutNode, SubcomposeSlotReusePolicy subcomposeSlotReusePolicy) {
        this.root = layoutNode;
        this.slotReusePolicy = subcomposeSlotReusePolicy;
    }

    public final CompositionContext getCompositionContext() {
        return this.compositionContext;
    }

    public final void setCompositionContext(CompositionContext compositionContext) {
        this.compositionContext = compositionContext;
    }

    public final SubcomposeSlotReusePolicy getSlotReusePolicy() {
        return this.slotReusePolicy;
    }

    public final void setSlotReusePolicy(SubcomposeSlotReusePolicy subcomposeSlotReusePolicy) {
        if (this.slotReusePolicy != subcomposeSlotReusePolicy) {
            this.slotReusePolicy = subcomposeSlotReusePolicy;
            markActiveNodesAsReused(false);
            LayoutNode.requestRemeasure$ui$default(this.root, false, false, false, 7, null);
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onReuse() {
        markActiveNodesAsReused(false);
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onDeactivate() {
        markActiveNodesAsReused(true);
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onRelease() {
        disposeCurrentNodes();
    }

    public final List<Measurable> subcompose(Object obj, Function2<? super Composer, ? super Integer, Unit> function2) {
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState;
        makeSureStateIsConsistent();
        LayoutNode.LayoutState layoutState$ui = this.root.getLayoutState$ui();
        if (!(layoutState$ui == LayoutNode.LayoutState.Measuring || layoutState$ui == LayoutNode.LayoutState.LayingOut || layoutState$ui == LayoutNode.LayoutState.LookaheadMeasuring || layoutState$ui == LayoutNode.LayoutState.LookaheadLayingOut)) {
            InlineClassHelperKt.throwIllegalStateException("subcompose can only be used inside the measure or layout blocks");
        }
        MutableScatterMap<Object, LayoutNode> mutableScatterMap = this.slotIdToNode;
        LayoutNode layoutNode = mutableScatterMap.get(obj);
        if (layoutNode == null) {
            layoutNode = this.precomposeMap.remove(obj);
            if (layoutNode != null) {
                this.nodeToNodeState.get(layoutNode);
                if (!(this.precomposedCount > 0)) {
                    InlineClassHelperKt.throwIllegalStateException("Check failed.");
                }
                this.precomposedCount--;
            } else {
                layoutNode = takeNodeFromReusables(obj);
                if (layoutNode == null) {
                    layoutNode = createNodeAt(this.currentIndex);
                }
            }
            mutableScatterMap.set(obj, layoutNode);
        }
        LayoutNode layoutNode2 = layoutNode;
        if (CollectionsKt.getOrNull(this.root.getFoldedChildren$ui(), this.currentIndex) != layoutNode2) {
            int indexOf = this.root.getFoldedChildren$ui().indexOf(layoutNode2);
            if (!(indexOf >= this.currentIndex)) {
                InlineClassHelperKt.throwIllegalArgumentException("Key \"" + obj + "\" was already used. If you are using LazyColumn/Row please make sure you provide a unique key for each item.");
            }
            int i = this.currentIndex;
            if (i != indexOf) {
                layoutNodeSubcompositionsState = this;
                move$default(layoutNodeSubcompositionsState, indexOf, i, 0, 4, null);
                layoutNodeSubcompositionsState.currentIndex++;
                subcompose(layoutNode2, obj, false, function2);
                if (layoutState$ui != LayoutNode.LayoutState.Measuring || layoutState$ui == LayoutNode.LayoutState.LayingOut) {
                    return layoutNode2.getChildMeasurables$ui();
                }
                return layoutNode2.getChildLookaheadMeasurables$ui();
            }
        }
        layoutNodeSubcompositionsState = this;
        layoutNodeSubcompositionsState.currentIndex++;
        subcompose(layoutNode2, obj, false, function2);
        if (layoutState$ui != LayoutNode.LayoutState.Measuring) {
        }
        return layoutNode2.getChildMeasurables$ui();
    }

    private final void subcompose(LayoutNode layoutNode, Object obj, boolean z, Function2<? super Composer, ? super Integer, Unit> function2) {
        MutableScatterMap<LayoutNode, NodeState> mutableScatterMap = this.nodeToNodeState;
        NodeState nodeState = mutableScatterMap.get(layoutNode);
        if (nodeState == null) {
            NodeState nodeState2 = new NodeState(obj, ComposableSingletons$SubcomposeLayoutKt.INSTANCE.getLambda$641200809$ui(), null, 4, null);
            mutableScatterMap.set(layoutNode, nodeState2);
            nodeState = nodeState2;
        }
        NodeState nodeState3 = nodeState;
        boolean z2 = nodeState3.getContent() != function2;
        if (nodeState3.getPausedComposition() != null) {
            if (z2) {
                cancelPausedPrecomposition(nodeState3);
            } else if (z) {
                return;
            } else {
                applyPausedPrecomposition(nodeState3, true);
            }
        }
        ReusableComposition composition = nodeState3.getComposition();
        boolean hasInvalidations = composition != null ? composition.getHasInvalidations() : true;
        if (z2 || hasInvalidations || nodeState3.getForceRecompose()) {
            nodeState3.setContent(function2);
            subcompose(layoutNode, nodeState3, z);
            nodeState3.setForceRecompose(false);
        }
    }

    private final OutOfFrameExecutor getOutOfFrameExecutor() {
        return LayoutNodeKt.requireOwner(this.root).getOutOfFrameExecutor();
    }

    private final void subcompose(LayoutNode layoutNode, final NodeState nodeState, boolean z) {
        if (!(nodeState.getPausedComposition() == null)) {
            InlineClassHelperKt.throwIllegalArgumentException("new subcompose call while paused composition is still active");
        }
        Snapshot.Companion companion = Snapshot.Companion;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            LayoutNode layoutNode2 = this.root;
            layoutNode2.ignoreRemeasureRequests = true;
            PausableComposition composition = nodeState.getComposition();
            CompositionContext compositionContext = this.compositionContext;
            if (compositionContext == null) {
                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("parent composition reference not set");
                throw new KotlinNothingValueException();
            }
            if (composition == null || composition.isDisposed()) {
                if (z) {
                    composition = SubcompositionKt.createPausableSubcomposition(layoutNode, compositionContext);
                } else {
                    composition = SubcompositionKt.createSubcomposition(layoutNode, compositionContext);
                }
            }
            nodeState.setComposition(composition);
            final ComposableLambda content = nodeState.getContent();
            if (getOutOfFrameExecutor() != null) {
                nodeState.setComposedWithReusableContentHost(false);
            } else {
                nodeState.setComposedWithReusableContentHost(true);
                content = ComposableLambdaKt.composableLambdaInstance(1524156494, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$subcompose$4$1$composable$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer, int i) {
                        ComposerKt.sourceInformation(composer, "C706@32593L46:SubcomposeLayout.kt#80mrfh");
                        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1524156494, i, -1, "androidx.compose.ui.layout.LayoutNodeSubcompositionsState.subcompose.<anonymous>.<anonymous>.<anonymous> (SubcomposeLayout.kt:706)");
                            }
                            boolean active = LayoutNodeSubcompositionsState.NodeState.this.getActive();
                            Function2<Composer, Integer, Unit> function2 = content;
                            ComposerKt.sourceInformationMarkerStart(composer, 1991829300, "CC(ReusableContentHost)N(active,content)169@6768L9:Composables.kt#9igjgp");
                            composer.startReusableGroup(ComposerKt.reuseKey, Boolean.valueOf(active));
                            boolean changed = composer.changed(active);
                            if (active) {
                                function2.invoke(composer, 0);
                            } else {
                                composer.deactivateToEndGroup(changed);
                            }
                            composer.endReusableGroup();
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer.skipToGroupEnd();
                    }
                });
            }
            if (z) {
                Intrinsics.checkNotNull(composition, "null cannot be cast to non-null type androidx.compose.runtime.PausableComposition");
                PausableComposition pausableComposition = (PausableComposition) composition;
                if (nodeState.getForceReuse()) {
                    nodeState.setPausedComposition(((PausableComposition) composition).setPausableContentWithReuse(content));
                } else {
                    nodeState.setPausedComposition(((PausableComposition) composition).setPausableContent(content));
                }
            } else if (nodeState.getForceReuse()) {
                composition.setContentWithReuse(content);
            } else {
                composition.setContent(content);
            }
            nodeState.setForceReuse(false);
            Unit unit = Unit.INSTANCE;
            layoutNode2.ignoreRemeasureRequests = false;
            Unit unit2 = Unit.INSTANCE;
        } finally {
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
        }
    }

    private final Object getSlotIdAtIndex(List<LayoutNode> list, int i) {
        NodeState nodeState = this.nodeToNodeState.get(list.get(i));
        Intrinsics.checkNotNull(nodeState);
        return nodeState.getSlotId();
    }

    public final void disposeOrReuseStartingFromIndex(int i) {
        boolean z = false;
        this.reusableCount = 0;
        List<LayoutNode> foldedChildren$ui = this.root.getFoldedChildren$ui();
        int size = (foldedChildren$ui.size() - this.precomposedCount) - 1;
        if (i <= size) {
            this.reusableSlotIdsSet.clear();
            if (i <= size) {
                int i2 = i;
                while (true) {
                    this.reusableSlotIdsSet.add(getSlotIdAtIndex(foldedChildren$ui, i2));
                    if (i2 == size) {
                        break;
                    }
                    i2++;
                }
            }
            this.slotReusePolicy.getSlotsToRetain(this.reusableSlotIdsSet);
            Snapshot.Companion companion = Snapshot.Companion;
            Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
            Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
            boolean z2 = false;
            while (size >= i) {
                try {
                    LayoutNode layoutNode = foldedChildren$ui.get(size);
                    NodeState nodeState = this.nodeToNodeState.get(layoutNode);
                    Intrinsics.checkNotNull(nodeState);
                    NodeState nodeState2 = nodeState;
                    Object slotId = nodeState2.getSlotId();
                    if (!this.reusableSlotIdsSet.contains(slotId)) {
                        LayoutNode layoutNode2 = this.root;
                        layoutNode2.ignoreRemeasureRequests = true;
                        this.nodeToNodeState.remove(layoutNode);
                        ReusableComposition composition = nodeState2.getComposition();
                        if (composition != null) {
                            composition.dispose();
                        }
                        this.root.removeAt$ui(size, 1);
                        Unit unit = Unit.INSTANCE;
                        layoutNode2.ignoreRemeasureRequests = false;
                    } else {
                        this.reusableCount++;
                        if (nodeState2.getActive()) {
                            resetLayoutState(layoutNode);
                            reuseComposition(nodeState2, false);
                            if (nodeState2.getComposedWithReusableContentHost()) {
                                z2 = true;
                            }
                        }
                    }
                    this.slotIdToNode.remove(slotId);
                    size--;
                } catch (Throwable th) {
                    companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                    throw th;
                }
            }
            Unit unit2 = Unit.INSTANCE;
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            z = z2;
        }
        if (z) {
            Snapshot.Companion.sendApplyNotifications();
        }
        makeSureStateIsConsistent();
    }

    private final void deactivateOutOfFrame(final NodeState nodeState, OutOfFrameExecutor outOfFrameExecutor) {
        outOfFrameExecutor.schedule(new Function0<Unit>() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$deactivateOutOfFrame$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                ReusableComposition composition;
                if (LayoutNodeSubcompositionsState.NodeState.this.getActive() || (composition = LayoutNodeSubcompositionsState.NodeState.this.getComposition()) == null) {
                    return;
                }
                composition.deactivate();
            }
        });
    }

    private final void markActiveNodesAsReused(boolean z) {
        this.precomposedCount = 0;
        this.precomposeMap.clear();
        List<LayoutNode> foldedChildren$ui = this.root.getFoldedChildren$ui();
        int size = foldedChildren$ui.size();
        if (this.reusableCount != size) {
            this.reusableCount = size;
            Snapshot.Companion companion = Snapshot.Companion;
            Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
            Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
            for (int i = 0; i < size; i++) {
                try {
                    LayoutNode layoutNode = foldedChildren$ui.get(i);
                    NodeState nodeState = this.nodeToNodeState.get(layoutNode);
                    if (nodeState != null && nodeState.getActive()) {
                        resetLayoutState(layoutNode);
                        reuseComposition(nodeState, z);
                        nodeState.setSlotId(SubcomposeLayoutKt.access$getReusedSlotId$p());
                    }
                } catch (Throwable th) {
                    companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                    throw th;
                }
            }
            Unit unit = Unit.INSTANCE;
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            this.slotIdToNode.clear();
        }
        makeSureStateIsConsistent();
    }

    private final void disposeCurrentNodes() {
        ReusableComposition composition;
        LayoutNode layoutNode = this.root;
        layoutNode.ignoreRemeasureRequests = true;
        MutableScatterMap<LayoutNode, NodeState> mutableScatterMap = this.nodeToNodeState;
        Object[] objArr = mutableScatterMap.values;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128 && (composition = ((NodeState) objArr[(i << 3) + i3]).getComposition()) != null) {
                            composition.dispose();
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
        this.root.removeAll$ui();
        Unit unit = Unit.INSTANCE;
        layoutNode.ignoreRemeasureRequests = false;
        this.nodeToNodeState.clear();
        this.slotIdToNode.clear();
        this.precomposedCount = 0;
        this.reusableCount = 0;
        this.precomposeMap.clear();
        makeSureStateIsConsistent();
    }

    public final void makeSureStateIsConsistent() {
        int size = this.root.getFoldedChildren$ui().size();
        if (!(this.nodeToNodeState.getSize() == size)) {
            InlineClassHelperKt.throwIllegalArgumentException("Inconsistency between the count of nodes tracked by the state (" + this.nodeToNodeState.getSize() + ") and the children count on the SubcomposeLayout (" + size + "). Are you trying to use the state of the disposed SubcomposeLayout?");
        }
        if (!((size - this.reusableCount) - this.precomposedCount >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("Incorrect state. Total children " + size + ". Reusable children " + this.reusableCount + ". Precomposed children " + this.precomposedCount);
        }
        if (this.precomposeMap.getSize() == this.precomposedCount) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("Incorrect state. Precomposed children " + this.precomposedCount + ". Map size " + this.precomposeMap.getSize());
    }

    private final void resetLayoutState(LayoutNode layoutNode) {
        layoutNode.getMeasurePassDelegate$ui().setMeasuredByParent$ui(LayoutNode.UsageByParent.NotUsed);
        LookaheadPassDelegate lookaheadPassDelegate$ui = layoutNode.getLookaheadPassDelegate$ui();
        if (lookaheadPassDelegate$ui != null) {
            lookaheadPassDelegate$ui.setMeasuredByParent$ui(LayoutNode.UsageByParent.NotUsed);
        }
    }

    private final LayoutNode takeNodeFromReusables(Object obj) {
        int i;
        MutableState<Boolean> mutableStateOf$default;
        if (this.reusableCount == 0) {
            return null;
        }
        List<LayoutNode> foldedChildren$ui = this.root.getFoldedChildren$ui();
        int size = foldedChildren$ui.size() - this.precomposedCount;
        int i2 = size - this.reusableCount;
        int i3 = size - 1;
        int i4 = i3;
        while (true) {
            if (i4 < i2) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(getSlotIdAtIndex(foldedChildren$ui, i4), obj)) {
                i = i4;
                break;
            } else {
                i4--;
            }
        }
        if (i == -1) {
            while (i3 >= i2) {
                NodeState nodeState = this.nodeToNodeState.get(foldedChildren$ui.get(i3));
                Intrinsics.checkNotNull(nodeState);
                NodeState nodeState2 = nodeState;
                if (nodeState2.getSlotId() == SubcomposeLayoutKt.access$getReusedSlotId$p() || this.slotReusePolicy.areCompatible(obj, nodeState2.getSlotId())) {
                    nodeState2.setSlotId(obj);
                    i4 = i3;
                    i = i4;
                    break;
                }
                i3--;
            }
            i4 = i3;
        }
        if (i == -1) {
            return null;
        }
        if (i4 != i2) {
            move(i4, i2, 1);
        }
        this.reusableCount--;
        LayoutNode layoutNode = foldedChildren$ui.get(i2);
        NodeState nodeState3 = this.nodeToNodeState.get(layoutNode);
        Intrinsics.checkNotNull(nodeState3);
        NodeState nodeState4 = nodeState3;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
        nodeState4.setActiveState(mutableStateOf$default);
        nodeState4.setForceReuse(true);
        nodeState4.setForceRecompose(true);
        return layoutNode;
    }

    public final MeasurePolicy createMeasurePolicy(final Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> function2) {
        final String str = this.NoIntrinsicsMessage;
        return new LayoutNode.NoIntrinsicsMeasurePolicy(str) { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1
            @Override // androidx.compose.ui.layout.MeasurePolicy
            /* renamed from: measure-3p2s80s */
            public MeasureResult mo54measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                LayoutNodeSubcompositionsState.ApproachMeasureScopeImpl approachMeasureScopeImpl;
                final int i;
                LayoutNodeSubcompositionsState.this.scope.setLayoutDirection(measureScope.getLayoutDirection());
                LayoutNodeSubcompositionsState.this.scope.setDensity(measureScope.getDensity());
                LayoutNodeSubcompositionsState.this.scope.setFontScale(measureScope.getFontScale());
                if (measureScope.isLookingAhead() || LayoutNodeSubcompositionsState.this.root.getLookaheadRoot$ui() == null) {
                    LayoutNodeSubcompositionsState.this.currentIndex = 0;
                    final MeasureResult invoke = function2.invoke(LayoutNodeSubcompositionsState.this.scope, Constraints.m8198boximpl(j));
                    final int i2 = LayoutNodeSubcompositionsState.this.currentIndex;
                    final LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = LayoutNodeSubcompositionsState.this;
                    return new MeasureResult() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1$measure-3p2s80s$$inlined$createMeasureResult$2
                        @Override // androidx.compose.ui.layout.MeasureResult
                        public Map<AlignmentLine, Integer> getAlignmentLines() {
                            return invoke.getAlignmentLines();
                        }

                        @Override // androidx.compose.ui.layout.MeasureResult
                        public int getHeight() {
                            return invoke.getHeight();
                        }

                        @Override // androidx.compose.ui.layout.MeasureResult
                        public Function1<RulerScope, Unit> getRulers() {
                            return invoke.getRulers();
                        }

                        @Override // androidx.compose.ui.layout.MeasureResult
                        public int getWidth() {
                            return invoke.getWidth();
                        }

                        @Override // androidx.compose.ui.layout.MeasureResult
                        public void placeChildren() {
                            layoutNodeSubcompositionsState.currentIndex = i2;
                            invoke.placeChildren();
                            if (layoutNodeSubcompositionsState.root.getLookaheadRoot$ui() == null) {
                                LayoutNodeSubcompositionsState layoutNodeSubcompositionsState2 = layoutNodeSubcompositionsState;
                                layoutNodeSubcompositionsState2.disposeOrReuseStartingFromIndex(layoutNodeSubcompositionsState2.currentIndex);
                            }
                        }
                    };
                }
                LayoutNodeSubcompositionsState.this.currentApproachIndex = 0;
                Function2<SubcomposeMeasureScope, Constraints, MeasureResult> function22 = function2;
                approachMeasureScopeImpl = LayoutNodeSubcompositionsState.this.approachMeasureScope;
                final MeasureResult invoke2 = function22.invoke(approachMeasureScopeImpl, Constraints.m8198boximpl(j));
                i = LayoutNodeSubcompositionsState.this.currentApproachIndex;
                final LayoutNodeSubcompositionsState layoutNodeSubcompositionsState2 = LayoutNodeSubcompositionsState.this;
                return new MeasureResult() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1$measure-3p2s80s$$inlined$createMeasureResult$1
                    @Override // androidx.compose.ui.layout.MeasureResult
                    public Map<AlignmentLine, Integer> getAlignmentLines() {
                        return invoke2.getAlignmentLines();
                    }

                    @Override // androidx.compose.ui.layout.MeasureResult
                    public int getHeight() {
                        return invoke2.getHeight();
                    }

                    @Override // androidx.compose.ui.layout.MeasureResult
                    public Function1<RulerScope, Unit> getRulers() {
                        return invoke2.getRulers();
                    }

                    @Override // androidx.compose.ui.layout.MeasureResult
                    public int getWidth() {
                        return invoke2.getWidth();
                    }

                    @Override // androidx.compose.ui.layout.MeasureResult
                    public void placeChildren() {
                        layoutNodeSubcompositionsState2.currentApproachIndex = i;
                        invoke2.placeChildren();
                        layoutNodeSubcompositionsState2.disposeUnusedSlotsInApproach();
                        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState3 = layoutNodeSubcompositionsState2;
                        layoutNodeSubcompositionsState3.disposeOrReuseStartingFromIndex(layoutNodeSubcompositionsState3.currentIndex);
                    }
                };
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disposeUnusedSlotsInApproach() {
        MutableScatterMap<Object, SubcomposeLayoutState.PrecomposedSlotHandle> mutableScatterMap = this.approachPrecomposeSlotHandleMap;
        long[] jArr = mutableScatterMap.metadata;
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
                    if ((255 & j) < 128) {
                        int i4 = (i << 3) + i3;
                        Object obj = mutableScatterMap.keys[i4];
                        SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle = (SubcomposeLayoutState.PrecomposedSlotHandle) mutableScatterMap.values[i4];
                        int indexOf = this.slotIdsOfCompositionsNeededInApproach.indexOf(obj);
                        if (indexOf < 0 || indexOf >= this.currentApproachIndex) {
                            if (indexOf >= 0) {
                                this.slotIdsOfCompositionsNeededInApproach.set(indexOf, SubcomposeLayoutKt.access$getUnspecifiedSlotId$p());
                            }
                            if (this.precomposeMap.contains(obj)) {
                                precomposedSlotHandle.dispose();
                            }
                            mutableScatterMap.removeValueAt(i4);
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

    private final MeasureResult createMeasureResult(final MeasureResult measureResult, final Function0<Unit> function0) {
        return new MeasureResult() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasureResult$1
            @Override // androidx.compose.ui.layout.MeasureResult
            public Map<AlignmentLine, Integer> getAlignmentLines() {
                return measureResult.getAlignmentLines();
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public int getHeight() {
                return measureResult.getHeight();
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public Function1<RulerScope, Unit> getRulers() {
                return measureResult.getRulers();
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public int getWidth() {
                return measureResult.getWidth();
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public void placeChildren() {
                function0.invoke();
            }
        };
    }

    public final SubcomposeLayoutState.PrecomposedSlotHandle precompose(Object obj, Function2<? super Composer, ? super Integer, Unit> function2) {
        precompose(obj, function2, false);
        return createPrecomposedSlotHandle(obj);
    }

    private final void precompose(Object obj, Function2<? super Composer, ? super Integer, Unit> function2, boolean z) {
        if (this.root.isAttached()) {
            makeSureStateIsConsistent();
            if (this.slotIdToNode.containsKey(obj)) {
                return;
            }
            this.approachPrecomposeSlotHandleMap.remove(obj);
            MutableScatterMap<Object, LayoutNode> mutableScatterMap = this.precomposeMap;
            LayoutNode layoutNode = mutableScatterMap.get(obj);
            if (layoutNode == null) {
                layoutNode = takeNodeFromReusables(obj);
                if (layoutNode != null) {
                    move(this.root.getFoldedChildren$ui().indexOf(layoutNode), this.root.getFoldedChildren$ui().size(), 1);
                    this.precomposedCount++;
                } else {
                    layoutNode = createNodeAt(this.root.getFoldedChildren$ui().size());
                    this.precomposedCount++;
                }
                mutableScatterMap.set(obj, layoutNode);
            }
            subcompose(layoutNode, obj, z, function2);
        }
    }

    private final void reuseComposition(NodeState nodeState, boolean z) {
        MutableState<Boolean> mutableStateOf$default;
        ReusableComposition composition;
        if (z || !nodeState.getComposedWithReusableContentHost()) {
            mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            nodeState.setActiveState(mutableStateOf$default);
        } else {
            nodeState.setActive(false);
        }
        if (nodeState.getPausedComposition() != null) {
            cancelPausedPrecomposition(nodeState);
        } else if (z) {
            ReusableComposition composition2 = nodeState.getComposition();
            if (composition2 != null) {
                composition2.deactivate();
            }
        } else {
            OutOfFrameExecutor outOfFrameExecutor = getOutOfFrameExecutor();
            if (outOfFrameExecutor != null) {
                deactivateOutOfFrame(nodeState, outOfFrameExecutor);
            } else if (nodeState.getComposedWithReusableContentHost() || (composition = nodeState.getComposition()) == null) {
            } else {
                composition.deactivate();
            }
        }
    }

    private final void cancelPausedPrecomposition(NodeState nodeState) {
        PausedComposition pausedComposition = nodeState.getPausedComposition();
        if (pausedComposition != null) {
            pausedComposition.cancel();
            nodeState.setPausedComposition(null);
            ReusableComposition composition = nodeState.getComposition();
            if (composition != null) {
                composition.dispose();
            }
            nodeState.setComposition(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disposePrecomposedSlot(Object obj) {
        makeSureStateIsConsistent();
        LayoutNode remove = this.precomposeMap.remove(obj);
        if (remove != null) {
            if (!(this.precomposedCount > 0)) {
                InlineClassHelperKt.throwIllegalStateException("No pre-composed items to dispose");
            }
            int indexOf = this.root.getFoldedChildren$ui().indexOf(remove);
            if (!(indexOf >= this.root.getFoldedChildren$ui().size() - this.precomposedCount)) {
                InlineClassHelperKt.throwIllegalStateException("Item is not in pre-composed item range");
            }
            this.reusableCount++;
            this.precomposedCount--;
            NodeState nodeState = this.nodeToNodeState.get(remove);
            if (nodeState != null) {
                cancelPausedPrecomposition(nodeState);
            }
            int size = (this.root.getFoldedChildren$ui().size() - this.precomposedCount) - this.reusableCount;
            move(indexOf, size, 1);
            disposeOrReuseStartingFromIndex(size);
        }
        if (this.slotIdsOfCompositionsNeededInApproach.contains(obj)) {
            LayoutNode.requestRemeasure$ui$default(this.root, true, false, false, 6, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SubcomposeLayoutState.PrecomposedSlotHandle createPrecomposedSlotHandle(final Object obj) {
        if (!this.root.isAttached()) {
            return new SubcomposeLayoutState.PrecomposedSlotHandle() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createPrecomposedSlotHandle$1
                @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
                public void dispose() {
                }
            };
        }
        return new SubcomposeLayoutState.PrecomposedSlotHandle() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createPrecomposedSlotHandle$2
            private final MutableIntSet hasPremeasured = IntSetKt.mutableIntSetOf();

            public final MutableIntSet getHasPremeasured() {
                return this.hasPremeasured;
            }

            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
            public void dispose() {
                LayoutNodeSubcompositionsState.this.disposePrecomposedSlot(obj);
            }

            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
            public int getPlaceablesCount() {
                MutableScatterMap mutableScatterMap;
                List<LayoutNode> children$ui;
                mutableScatterMap = LayoutNodeSubcompositionsState.this.precomposeMap;
                LayoutNode layoutNode = (LayoutNode) mutableScatterMap.get(obj);
                if (layoutNode == null || (children$ui = layoutNode.getChildren$ui()) == null) {
                    return 0;
                }
                return children$ui.size();
            }

            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
            /* renamed from: premeasure-0kLqBqw  reason: not valid java name */
            public void mo6903premeasure0kLqBqw(int i, long j) {
                MutableScatterMap mutableScatterMap;
                mutableScatterMap = LayoutNodeSubcompositionsState.this.precomposeMap;
                LayoutNode layoutNode = (LayoutNode) mutableScatterMap.get(obj);
                if (layoutNode == null || !layoutNode.isAttached()) {
                    return;
                }
                int size = layoutNode.getChildren$ui().size();
                if (i < 0 || i >= size) {
                    InlineClassHelperKt.throwIndexOutOfBoundsException("Index (" + i + ") is out of bound of [0, " + size + ')');
                }
                if (layoutNode.isPlaced()) {
                    InlineClassHelperKt.throwIllegalArgumentException("Pre-measure called on node that is not placed");
                }
                LayoutNode layoutNode2 = LayoutNodeSubcompositionsState.this.root;
                layoutNode2.ignoreRemeasureRequests = true;
                LayoutNodeKt.requireOwner(layoutNode).mo7262measureAndLayout0kLqBqw(layoutNode.getChildren$ui().get(i), j);
                Unit unit = Unit.INSTANCE;
                layoutNode2.ignoreRemeasureRequests = false;
                this.hasPremeasured.add(i);
            }

            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
            public void traverseDescendants(Object obj2, Function1<? super TraversableNode, ? extends TraversableNode.Companion.TraverseDescendantsAction> function1) {
                MutableScatterMap mutableScatterMap;
                NodeChain nodes$ui;
                Modifier.Node head$ui;
                mutableScatterMap = LayoutNodeSubcompositionsState.this.precomposeMap;
                LayoutNode layoutNode = (LayoutNode) mutableScatterMap.get(obj);
                if (layoutNode == null || (nodes$ui = layoutNode.getNodes$ui()) == null || (head$ui = nodes$ui.getHead$ui()) == null) {
                    return;
                }
                TraversableNodeKt.traverseDescendants(head$ui, obj2, function1);
            }

            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
            /* renamed from: getSize-YEO4UFw  reason: not valid java name */
            public long mo6902getSizeYEO4UFw(int i) {
                MutableScatterMap mutableScatterMap;
                mutableScatterMap = LayoutNodeSubcompositionsState.this.precomposeMap;
                LayoutNode layoutNode = (LayoutNode) mutableScatterMap.get(obj);
                if (layoutNode != null && layoutNode.isAttached()) {
                    int size = layoutNode.getChildren$ui().size();
                    if (i < 0 || i >= size) {
                        InlineClassHelperKt.throwIndexOutOfBoundsException("Index (" + i + ") is out of bound of [0, " + size + ')');
                    }
                    if (this.hasPremeasured.contains(i)) {
                        return IntSize.m8424constructorimpl((layoutNode.getChildren$ui().get(i).getWidth() << 32) | (layoutNode.getChildren$ui().get(i).getHeight() & 4294967295L));
                    }
                }
                return IntSize.Companion.m8434getZeroYbymL2g();
            }
        };
    }

    public final SubcomposeLayoutState.PausedPrecomposition precomposePaused(final Object obj, Function2<? super Composer, ? super Integer, Unit> function2) {
        if (!this.root.isAttached()) {
            return new PausedPrecompositionImpl() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$precomposePaused$1
                private final boolean isComplete = true;

                @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PausedPrecomposition
                public void cancel() {
                }

                @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PausedPrecomposition
                public boolean resume(ShouldPauseCallback shouldPauseCallback) {
                    return true;
                }

                @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PausedPrecomposition
                public boolean isComplete() {
                    return this.isComplete;
                }

                @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PausedPrecomposition
                public SubcomposeLayoutState.PrecomposedSlotHandle apply() {
                    SubcomposeLayoutState.PrecomposedSlotHandle createPrecomposedSlotHandle;
                    createPrecomposedSlotHandle = LayoutNodeSubcompositionsState.this.createPrecomposedSlotHandle(obj);
                    return createPrecomposedSlotHandle;
                }
            };
        }
        precompose(obj, function2, true);
        return new PausedPrecompositionImpl() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$precomposePaused$2
            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PausedPrecomposition
            public void cancel() {
                LayoutNodeSubcompositionsState.NodeState nodeState = getNodeState();
                if ((nodeState != null ? nodeState.getPausedComposition() : null) != null) {
                    LayoutNodeSubcompositionsState.this.disposePrecomposedSlot(obj);
                }
            }

            private final LayoutNodeSubcompositionsState.NodeState getNodeState() {
                MutableScatterMap mutableScatterMap;
                MutableScatterMap mutableScatterMap2;
                mutableScatterMap = LayoutNodeSubcompositionsState.this.precomposeMap;
                LayoutNode layoutNode = (LayoutNode) mutableScatterMap.get(obj);
                if (layoutNode != null) {
                    mutableScatterMap2 = LayoutNodeSubcompositionsState.this.nodeToNodeState;
                    return (LayoutNodeSubcompositionsState.NodeState) mutableScatterMap2.get(layoutNode);
                }
                return null;
            }

            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PausedPrecomposition
            public boolean isComplete() {
                PausedComposition pausedComposition;
                LayoutNodeSubcompositionsState.NodeState nodeState = getNodeState();
                if (nodeState == null || (pausedComposition = nodeState.getPausedComposition()) == null) {
                    return true;
                }
                return pausedComposition.isComplete();
            }

            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PausedPrecomposition
            public boolean resume(ShouldPauseCallback shouldPauseCallback) {
                LayoutNodeSubcompositionsState.NodeState nodeState = getNodeState();
                PausedComposition pausedComposition = nodeState != null ? nodeState.getPausedComposition() : null;
                if (pausedComposition == null || pausedComposition.isComplete()) {
                    return true;
                }
                Snapshot.Companion companion = Snapshot.Companion;
                LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = LayoutNodeSubcompositionsState.this;
                Object obj2 = obj;
                Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                try {
                    LayoutNode layoutNode = layoutNodeSubcompositionsState.root;
                    layoutNode.ignoreRemeasureRequests = true;
                    boolean resume = pausedComposition.resume(shouldPauseCallback);
                    layoutNode.ignoreRemeasureRequests = false;
                    return resume;
                } finally {
                    companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                }
            }

            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PausedPrecomposition
            public SubcomposeLayoutState.PrecomposedSlotHandle apply() {
                SubcomposeLayoutState.PrecomposedSlotHandle createPrecomposedSlotHandle;
                LayoutNodeSubcompositionsState.NodeState nodeState = getNodeState();
                if (nodeState != null) {
                    LayoutNodeSubcompositionsState.this.applyPausedPrecomposition(nodeState, false);
                }
                createPrecomposedSlotHandle = LayoutNodeSubcompositionsState.this.createPrecomposedSlotHandle(obj);
                return createPrecomposedSlotHandle;
            }
        };
    }

    public final void forceRecomposeChildren() {
        if (this.reusableCount != this.root.getFoldedChildren$ui().size()) {
            MutableScatterMap<LayoutNode, NodeState> mutableScatterMap = this.nodeToNodeState;
            Object[] objArr = mutableScatterMap.values;
            long[] jArr = mutableScatterMap.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                ((NodeState) objArr[(i << 3) + i3]).setForceRecompose(true);
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
            if (this.root.getLookaheadRoot$ui() != null) {
                if (this.root.getLookaheadMeasurePending$ui()) {
                    return;
                }
                LayoutNode.requestLookaheadRemeasure$ui$default(this.root, false, false, false, 7, null);
            } else if (!this.root.getMeasurePending$ui()) {
                LayoutNode.requestRemeasure$ui$default(this.root, false, false, false, 7, null);
            }
        }
    }

    private final LayoutNode createNodeAt(int i) {
        LayoutNode layoutNode = new LayoutNode(true, 0, 2, null);
        LayoutNode layoutNode2 = this.root;
        layoutNode2.ignoreRemeasureRequests = true;
        this.root.insertAt$ui(i, layoutNode);
        Unit unit = Unit.INSTANCE;
        layoutNode2.ignoreRemeasureRequests = false;
        return layoutNode;
    }

    static /* synthetic */ void move$default(LayoutNodeSubcompositionsState layoutNodeSubcompositionsState, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = 1;
        }
        layoutNodeSubcompositionsState.move(i, i2, i3);
    }

    private final <T> T ignoreRemeasureRequests(Function0<? extends T> function0) {
        LayoutNode layoutNode = this.root;
        layoutNode.ignoreRemeasureRequests = true;
        T invoke = function0.invoke();
        layoutNode.ignoreRemeasureRequests = false;
        return invoke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyPausedPrecomposition(NodeState nodeState, boolean z) {
        PausedComposition pausedComposition = nodeState.getPausedComposition();
        if (pausedComposition != null) {
            Snapshot.Companion companion = Snapshot.Companion;
            Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
            Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
            try {
                LayoutNode layoutNode = this.root;
                layoutNode.ignoreRemeasureRequests = true;
                if (z) {
                    while (!pausedComposition.isComplete()) {
                        pausedComposition.resume(new ShouldPauseCallback() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$$ExternalSyntheticLambda0
                            @Override // androidx.compose.runtime.ShouldPauseCallback
                            public final boolean shouldPause() {
                                boolean applyPausedPrecomposition$lambda$0$0$0;
                                applyPausedPrecomposition$lambda$0$0$0 = LayoutNodeSubcompositionsState.applyPausedPrecomposition$lambda$0$0$0();
                                return applyPausedPrecomposition$lambda$0$0$0;
                            }
                        });
                    }
                }
                pausedComposition.apply();
                nodeState.setPausedComposition(null);
                Unit unit = Unit.INSTANCE;
                layoutNode.ignoreRemeasureRequests = false;
                Unit unit2 = Unit.INSTANCE;
            } finally {
                companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SubcomposeLayout.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B0\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0011\u0010\u0003\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0015\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00020:¢\u0006\u0004\b;\u0010<R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR'\u0010\u0003\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R \u0010'\u001a\b\u0012\u0004\u0012\u00020\u00190(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001b\"\u0004\b/\u0010\u001dR$\u00101\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u00198F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b2\u0010\u001b\"\u0004\b3\u0010\u001dR\u0013\u00104\u001a\u0004\u0018\u000105¢\u0006\b\n\u0000\u001a\u0004\b6\u00107¨\u0006="}, d2 = {"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$NodeState;", "", "slotId", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "composition", "Landroidx/compose/runtime/ReusableComposition;", "<init>", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/ReusableComposition;)V", "getSlotId", "()Ljava/lang/Object;", "setSlotId", "(Ljava/lang/Object;)V", "getContent", "()Lkotlin/jvm/functions/Function2;", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "getComposition", "()Landroidx/compose/runtime/ReusableComposition;", "setComposition", "(Landroidx/compose/runtime/ReusableComposition;)V", "forceRecompose", "", "getForceRecompose", "()Z", "setForceRecompose", "(Z)V", "forceReuse", "getForceReuse", "setForceReuse", "pausedComposition", "Landroidx/compose/runtime/PausedComposition;", "getPausedComposition", "()Landroidx/compose/runtime/PausedComposition;", "setPausedComposition", "(Landroidx/compose/runtime/PausedComposition;)V", "activeState", "Landroidx/compose/runtime/MutableState;", "getActiveState", "()Landroidx/compose/runtime/MutableState;", "setActiveState", "(Landroidx/compose/runtime/MutableState;)V", "composedWithReusableContentHost", "getComposedWithReusableContentHost", "setComposedWithReusableContentHost", "value", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "getActive", "setActive", "operations", "Landroidx/collection/MutableIntList;", "getOperations", "()Landroidx/collection/MutableIntList;", "record", "op", "Landroidx/compose/ui/layout/SLOperation;", "record-Fsph7yY", "(I)V", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class NodeState {
        private MutableState<Boolean> activeState;
        private boolean composedWithReusableContentHost;
        private ReusableComposition composition;
        private Function2<? super Composer, ? super Integer, Unit> content;
        private boolean forceRecompose;
        private boolean forceReuse;
        private final MutableIntList operations;
        private PausedComposition pausedComposition;
        private Object slotId;

        public NodeState(Object obj, Function2<? super Composer, ? super Integer, Unit> function2, ReusableComposition reusableComposition) {
            MutableState<Boolean> mutableStateOf$default;
            this.slotId = obj;
            this.content = function2;
            this.composition = reusableComposition;
            mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
            this.activeState = mutableStateOf$default;
            this.operations = null;
        }

        public /* synthetic */ NodeState(Object obj, Function2 function2, ReusableComposition reusableComposition, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, function2, (i & 4) != 0 ? null : reusableComposition);
        }

        public final Object getSlotId() {
            return this.slotId;
        }

        public final void setSlotId(Object obj) {
            this.slotId = obj;
        }

        public final Function2<Composer, Integer, Unit> getContent() {
            return this.content;
        }

        public final void setContent(Function2<? super Composer, ? super Integer, Unit> function2) {
            this.content = function2;
        }

        public final ReusableComposition getComposition() {
            return this.composition;
        }

        public final void setComposition(ReusableComposition reusableComposition) {
            this.composition = reusableComposition;
        }

        public final boolean getForceRecompose() {
            return this.forceRecompose;
        }

        public final void setForceRecompose(boolean z) {
            this.forceRecompose = z;
        }

        public final boolean getForceReuse() {
            return this.forceReuse;
        }

        public final void setForceReuse(boolean z) {
            this.forceReuse = z;
        }

        public final PausedComposition getPausedComposition() {
            return this.pausedComposition;
        }

        public final void setPausedComposition(PausedComposition pausedComposition) {
            this.pausedComposition = pausedComposition;
        }

        public final MutableState<Boolean> getActiveState() {
            return this.activeState;
        }

        public final void setActiveState(MutableState<Boolean> mutableState) {
            this.activeState = mutableState;
        }

        public final boolean getComposedWithReusableContentHost() {
            return this.composedWithReusableContentHost;
        }

        public final void setComposedWithReusableContentHost(boolean z) {
            this.composedWithReusableContentHost = z;
        }

        public final boolean getActive() {
            return this.activeState.getValue().booleanValue();
        }

        public final void setActive(boolean z) {
            this.activeState.setValue(Boolean.valueOf(z));
        }

        public final MutableIntList getOperations() {
            return this.operations;
        }

        /* renamed from: record-Fsph7yY  reason: not valid java name */
        public final void m6901recordFsph7yY(int i) {
            MutableIntList mutableIntList = this.operations;
            if (mutableIntList == null) {
                return;
            }
            mutableIntList.add(i);
            if (mutableIntList._size >= 50) {
                mutableIntList.removeRange(0, 10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SubcomposeLayout.kt */
    @Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\u001d0\u001c¢\u0006\u0002\b\u001eH\u0016¢\u0006\u0002\u0010\u001fJ`\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020#0&2\u0019\u0010(\u001a\u0015\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u001d\u0018\u00010)¢\u0006\u0002\b+2\u0017\u0010,\u001a\u0013\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u001d0)¢\u0006\u0002\b+H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015¨\u0006."}, d2 = {"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$Scope;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "<init>", "(Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;)V", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "density", "", "getDensity", "()F", "setDensity", "(F)V", "fontScale", "getFontScale", "setFontScale", "isLookingAhead", "", "()Z", "subcompose", "", "Landroidx/compose/ui/layout/Measurable;", "slotId", "", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "layout", "Landroidx/compose/ui/layout/MeasureResult;", "width", "", "height", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "rulers", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "Lkotlin/ExtensionFunctionType;", "placementBlock", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public final class Scope implements SubcomposeMeasureScope {
        private float density;
        private float fontScale;
        private LayoutDirection layoutDirection = LayoutDirection.Rtl;

        public Scope() {
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
        public LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        public void setLayoutDirection(LayoutDirection layoutDirection) {
            this.layoutDirection = layoutDirection;
        }

        @Override // androidx.compose.ui.unit.Density
        public float getDensity() {
            return this.density;
        }

        public void setDensity(float f) {
            this.density = f;
        }

        @Override // androidx.compose.ui.unit.FontScaling
        public float getFontScale() {
            return this.fontScale;
        }

        public void setFontScale(float f) {
            this.fontScale = f;
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
        public boolean isLookingAhead() {
            return LayoutNodeSubcompositionsState.this.root.getLayoutState$ui() == LayoutNode.LayoutState.LookaheadLayingOut || LayoutNodeSubcompositionsState.this.root.getLayoutState$ui() == LayoutNode.LayoutState.LookaheadMeasuring;
        }

        @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
        public List<Measurable> subcompose(Object obj, Function2<? super Composer, ? super Integer, Unit> function2) {
            return LayoutNodeSubcompositionsState.this.subcompose(obj, function2);
        }

        @Override // androidx.compose.ui.layout.MeasureScope
        public MeasureResult layout(final int i, final int i2, final Map<AlignmentLine, Integer> map, final Function1<? super RulerScope, Unit> function1, final Function1<? super Placeable.PlacementScope, Unit> function12) {
            if (!((i & (-16777216)) == 0 && ((-16777216) & i2) == 0)) {
                InlineClassHelperKt.throwIllegalStateException("Size(" + i + " x " + i2 + ") is out of range. Each dimension must be between 0 and 16777215.");
            }
            final LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = LayoutNodeSubcompositionsState.this;
            return new MeasureResult() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$Scope$layout$1
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
                    LookaheadDelegate lookaheadDelegate;
                    if (!this.isLookingAhead() || (lookaheadDelegate = layoutNodeSubcompositionsState.root.getInnerCoordinator$ui().getLookaheadDelegate()) == null) {
                        function12.invoke(layoutNodeSubcompositionsState.root.getInnerCoordinator$ui().getPlacementScope());
                    } else {
                        function12.invoke(lookaheadDelegate.getPlacementScope());
                    }
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SubcomposeLayout.kt */
    @Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J0\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\b\rH\u0016¢\u0006\u0002\u0010\u000eJF\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00120\u00152\u0017\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0\u0018¢\u0006\u0002\b\u001aH\u0096\u0001Ja\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00120\u00152\u0019\u0010\u001b\u001a\u0015\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\f\u0018\u00010\u0018¢\u0006\u0002\b\u001a2\u0017\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0\u0018¢\u0006\u0002\b\u001aH\u0096\u0001J\u0014\u0010\u001d\u001a\u00020\u0012*\u00020\u001eH\u0097\u0001¢\u0006\u0004\b\u001f\u0010 J\u0014\u0010\u001d\u001a\u00020\u0012*\u00020!H\u0097\u0001¢\u0006\u0004\b\"\u0010#J\u0014\u0010$\u001a\u00020\u001e*\u00020\u0012H\u0097\u0001¢\u0006\u0004\b%\u0010&J\u0014\u0010$\u001a\u00020\u001e*\u00020'H\u0097\u0001¢\u0006\u0004\b%\u0010(J\u0014\u0010$\u001a\u00020\u001e*\u00020!H\u0097\u0001¢\u0006\u0004\b)\u0010*J\u0014\u0010+\u001a\u00020,*\u00020-H\u0097\u0001¢\u0006\u0004\b.\u0010/J\u0014\u00100\u001a\u00020'*\u00020\u001eH\u0097\u0001¢\u0006\u0004\b1\u0010(J\u0014\u00100\u001a\u00020'*\u00020!H\u0097\u0001¢\u0006\u0004\b2\u0010*J\r\u00103\u001a\u000204*\u000205H\u0097\u0001J\u0014\u00106\u001a\u00020-*\u00020,H\u0097\u0001¢\u0006\u0004\b7\u0010/J\u0014\u00108\u001a\u00020!*\u00020\u0012H\u0097\u0001¢\u0006\u0004\b9\u0010:J\u0014\u00108\u001a\u00020!*\u00020'H\u0097\u0001¢\u0006\u0004\b9\u0010;J\u0014\u00108\u001a\u00020!*\u00020\u001eH\u0097\u0001¢\u0006\u0004\b<\u0010;R\u0014\u0010=\u001a\u00020'8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0014\u0010@\u001a\u00020'8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bA\u0010?R\u0014\u0010B\u001a\u00020C8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\bB\u0010DR\u0012\u0010E\u001a\u00020FX\u0096\u0005¢\u0006\u0006\u001a\u0004\bG\u0010H¨\u0006I"}, d2 = {"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$ApproachMeasureScopeImpl;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/layout/MeasureScope;", "<init>", "(Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;)V", "subcompose", "", "Landroidx/compose/ui/layout/Measurable;", "slotId", "", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "layout", "Landroidx/compose/ui/layout/MeasureResult;", "width", "", "height", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "placementBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "Lkotlin/ExtensionFunctionType;", "rulers", "Landroidx/compose/ui/layout/RulerScope;", "roundToPx", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-u2uoSUM", "(I)F", "", "(F)F", "toDp-GaN1DYA", "(J)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-kPz2Gy4", "(I)J", "(F)J", "toSp-0xMU5do", "density", "getDensity", "()F", "fontScale", "getFontScale", "isLookingAhead", "", "()Z", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public final class ApproachMeasureScopeImpl implements SubcomposeMeasureScope, MeasureScope {
        private final /* synthetic */ Scope $$delegate_0;

        @Override // androidx.compose.ui.unit.Density
        public float getDensity() {
            return this.$$delegate_0.getDensity();
        }

        @Override // androidx.compose.ui.unit.FontScaling
        public float getFontScale() {
            return this.$$delegate_0.getFontScale();
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
        public LayoutDirection getLayoutDirection() {
            return this.$$delegate_0.getLayoutDirection();
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
        public boolean isLookingAhead() {
            return this.$$delegate_0.isLookingAhead();
        }

        @Override // androidx.compose.ui.layout.MeasureScope
        public MeasureResult layout(int i, int i2, Map<AlignmentLine, Integer> map, Function1<? super Placeable.PlacementScope, Unit> function1) {
            return this.$$delegate_0.layout(i, i2, map, function1);
        }

        @Override // androidx.compose.ui.layout.MeasureScope
        public MeasureResult layout(int i, int i2, Map<AlignmentLine, Integer> map, Function1<? super RulerScope, Unit> function1, Function1<? super Placeable.PlacementScope, Unit> function12) {
            return this.$$delegate_0.layout(i, i2, map, function1, function12);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: roundToPx--R2X_6o */
        public int mo457roundToPxR2X_6o(long j) {
            return this.$$delegate_0.mo457roundToPxR2X_6o(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: roundToPx-0680j_4 */
        public int mo458roundToPx0680j_4(float f) {
            return this.$$delegate_0.mo458roundToPx0680j_4(f);
        }

        @Override // androidx.compose.ui.unit.FontScaling
        /* renamed from: toDp-GaN1DYA */
        public float mo459toDpGaN1DYA(long j) {
            return this.$$delegate_0.mo459toDpGaN1DYA(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toDp-u2uoSUM */
        public float mo460toDpu2uoSUM(float f) {
            return this.$$delegate_0.mo460toDpu2uoSUM(f);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toDp-u2uoSUM */
        public float mo461toDpu2uoSUM(int i) {
            return this.$$delegate_0.mo461toDpu2uoSUM(i);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toDpSize-k-rfVVM */
        public long mo462toDpSizekrfVVM(long j) {
            return this.$$delegate_0.mo462toDpSizekrfVVM(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toPx--R2X_6o */
        public float mo463toPxR2X_6o(long j) {
            return this.$$delegate_0.mo463toPxR2X_6o(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toPx-0680j_4 */
        public float mo464toPx0680j_4(float f) {
            return this.$$delegate_0.mo464toPx0680j_4(f);
        }

        @Override // androidx.compose.ui.unit.Density
        public Rect toRect(DpRect dpRect) {
            return this.$$delegate_0.toRect(dpRect);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toSize-XkaWNTQ */
        public long mo465toSizeXkaWNTQ(long j) {
            return this.$$delegate_0.mo465toSizeXkaWNTQ(j);
        }

        @Override // androidx.compose.ui.unit.FontScaling
        /* renamed from: toSp-0xMU5do */
        public long mo466toSp0xMU5do(float f) {
            return this.$$delegate_0.mo466toSp0xMU5do(f);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toSp-kPz2Gy4 */
        public long mo467toSpkPz2Gy4(float f) {
            return this.$$delegate_0.mo467toSpkPz2Gy4(f);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toSp-kPz2Gy4 */
        public long mo468toSpkPz2Gy4(int i) {
            return this.$$delegate_0.mo468toSpkPz2Gy4(i);
        }

        public ApproachMeasureScopeImpl() {
            this.$$delegate_0 = LayoutNodeSubcompositionsState.this.scope;
        }

        @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
        public List<Measurable> subcompose(Object obj, Function2<? super Composer, ? super Integer, Unit> function2) {
            LayoutNode layoutNode = (LayoutNode) LayoutNodeSubcompositionsState.this.slotIdToNode.get(obj);
            if (layoutNode == null || LayoutNodeSubcompositionsState.this.root.getFoldedChildren$ui().indexOf(layoutNode) >= LayoutNodeSubcompositionsState.this.currentIndex) {
                return LayoutNodeSubcompositionsState.this.approachSubcompose(obj, function2);
            }
            return layoutNode.getChildMeasurables$ui();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Measurable> approachSubcompose(Object obj, Function2<? super Composer, ? super Integer, Unit> function2) {
        if (!(this.slotIdsOfCompositionsNeededInApproach.getSize() >= this.currentApproachIndex)) {
            InlineClassHelperKt.throwIllegalArgumentException("Error: currentApproachIndex cannot be greater than the size of theapproachComposedSlotIds list.");
        }
        LayoutNode layoutNode = this.slotIdToNode.get(obj);
        int size = this.slotIdsOfCompositionsNeededInApproach.getSize();
        int i = this.currentApproachIndex;
        if (size == i) {
            this.slotIdsOfCompositionsNeededInApproach.add(obj);
        } else {
            this.slotIdsOfCompositionsNeededInApproach.set(i, obj);
        }
        this.currentApproachIndex++;
        boolean contains = this.precomposeMap.contains(obj);
        if (!contains && layoutNode == null) {
            this.approachPrecomposeSlotHandleMap.set(obj, precompose(obj, function2));
        } else {
            if (!contains && layoutNode != null) {
                move(this.root.getFoldedChildren$ui().indexOf(layoutNode), this.root.getFoldedChildren$ui().size(), 1);
                this.precomposedCount++;
                this.slotIdToNode.remove(obj);
                this.precomposeMap.set(obj, layoutNode);
                this.approachPrecomposeSlotHandleMap.set(obj, createPrecomposedSlotHandle(obj));
                if (this.root.isAttached()) {
                    makeSureStateIsConsistent();
                }
            }
            LayoutNode layoutNode2 = this.precomposeMap.get(obj);
            NodeState nodeState = layoutNode2 != null ? this.nodeToNodeState.get(layoutNode2) : null;
            if (nodeState != null && nodeState.getForceRecompose()) {
                subcompose(layoutNode2, obj, false, function2);
            }
        }
        LayoutNode layoutNode3 = this.precomposeMap.get(obj);
        if (layoutNode3 != null) {
            List<MeasurePassDelegate> childDelegates$ui = layoutNode3.getMeasurePassDelegate$ui().getChildDelegates$ui();
            int size2 = childDelegates$ui.size();
            for (int i2 = 0; i2 < size2; i2++) {
                childDelegates$ui.get(i2).markDetachedFromParentLookaheadPass$ui();
            }
            if (childDelegates$ui != null) {
                return childDelegates$ui;
            }
        }
        return CollectionsKt.emptyList();
    }

    private final void move(int i, int i2, int i3) {
        LayoutNode layoutNode = this.root;
        layoutNode.ignoreRemeasureRequests = true;
        this.root.move$ui(i, i2, i3);
        Unit unit = Unit.INSTANCE;
        layoutNode.ignoreRemeasureRequests = false;
    }
}
