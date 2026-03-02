package androidx.compose.ui.spatial;

import android.os.Trace;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Actual_androidKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusTargetModifierNode;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.MatrixKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeKt;
import androidx.compose.ui.node.MeasurePassDelegate;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.semantics.SemanticsInfo;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
/* compiled from: RectManager.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0019\u001a\u00020\u0010J5\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u0006\u0010%\u001a\u00020\u0010J\u000e\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u0012J\u0006\u0010(\u001a\u00020\u0010J\u0016\u0010)\u001a\u0004\u0018\u00010\u00012\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ:\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u0002012\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u001002J:\u00104\u001a\u00020,2\u0006\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u0002012\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u001002J\u0010\u00105\u001a\u00020\u00102\b\u00106\u001a\u0004\u0018\u00010\u0001J\u000e\u00107\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u0004J\u001e\u00109\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u00122\u0006\u0010;\u001a\u00020\u0012J\u000e\u0010<\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u0004J\u0018\u0010=\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u00042\b\b\u0002\u0010>\u001a\u00020\u0012J\u0015\u0010?\u001a\u00020\u001c2\u0006\u00108\u001a\u00020\u0004¢\u0006\u0004\b@\u0010AJ\f\u0010B\u001a\u00020\u0010*\u00020\u0004H\u0002J\u0010\u0010C\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u0004H\u0002J\u0010\u0010F\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u0004H\u0002J\u0014\u0010G\u001a\u00020\u0010*\u00020H2\u0006\u0010I\u001a\u00020EH\u0002J\f\u0010J\u001a\u00020\u0012*\u00020HH\u0002J\u0013\u0010K\u001a\u00020\u001c*\u00020\u0004H\u0002¢\u0006\u0004\bL\u0010AJ\u000e\u0010M\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u0004J\u001d\u0010N\u001a\u00020\u00122\u0006\u0010O\u001a\u00020!2\u0006\u0010P\u001a\u00020!H\u0000¢\u0006\u0002\bQJ7\u0010R\u001a\u0004\u0018\u00010S2\u0006\u0010T\u001a\u00020!2\u0006\u0010U\u001a\u00020!2\u0006\u0010V\u001a\u00020!2\u0006\u0010W\u001a\u00020!2\u0006\u0010X\u001a\u00020!H\u0000¢\u0006\u0002\bYJ1\u0010Z\u001a\u00020\u0012*\u0002012\u0006\u0010T\u001a\u00020!2\u0006\u0010U\u001a\u00020!2\u0006\u0010V\u001a\u00020!2\u0006\u0010W\u001a\u00020!H\u0000¢\u0006\u0002\b[J\u0019\u0010\\\u001a\u00020\u0012*\u00020\u00042\u0006\u0010]\u001a\u00020\u0004H\u0000¢\u0006\u0002\b^J\u000e\u0010_\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u0004R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006`"}, d2 = {"Landroidx/compose/ui/spatial/RectManager;", "", "layoutNodes", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/node/LayoutNode;", "<init>", "(Landroidx/collection/IntObjectMap;)V", "rects", "Landroidx/compose/ui/spatial/RectList;", "getRects", "()Landroidx/compose/ui/spatial/RectList;", "throttledCallbacks", "Landroidx/compose/ui/spatial/ThrottledCallbacks;", "callbacks", "Landroidx/collection/MutableObjectList;", "Lkotlin/Function0;", "", "isDirty", "", "isScreenOrWindowDirty", "isFragmented", "dispatchToken", "scheduledDispatchDeadline", "", "dispatchLambda", "invalidate", "updateOffsets", "screenOffset", "Landroidx/compose/ui/unit/IntOffset;", "windowOffset", "viewToWindowMatrix", "Landroidx/compose/ui/graphics/Matrix;", "windowWidth", "", "windowHeight", "updateOffsets-gTq6Wqs", "(JJ[FII)V", "dispatchCallbacks", "scheduleDebounceCallback", "ensureSomethingScheduled", "removeScheduledCallback", "registerOnChangedCallback", "callback", "registerOnRectChangedCallback", "Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "id", "throttleMillis", "debounceMillis", "node", "Landroidx/compose/ui/node/DelegatableNode;", "Lkotlin/Function1;", "Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "registerOnGlobalLayoutCallback", "unregisterOnChangedCallback", "token", "invalidateCallbacksFor", "layoutNode", "updateFlagsFor", "focusable", "gesturable", "onLayoutLayerPositionalPropertiesChanged", "onLayoutPositionChanged", "forceUpdate", "getOffsetFromRectListFor", "getOffsetFromRectListFor-Bjo55l4", "(Landroidx/compose/ui/node/LayoutNode;)J", "resetHasPositionalLayerTransformationsForSubtreeIfNeeded", "insertOrUpdateTransformedNodeSubhierarchy", "cachedRect", "Landroidx/compose/ui/geometry/MutableRect;", "insertOrUpdateTransformedNode", "boundingRectInRoot", "Landroidx/compose/ui/node/NodeCoordinator;", "rect", "hasPositionalLayerTransformations", "outerToInnerOffset", "outerToInnerOffset-Bjo55l4", "remove", "isTargetDrawnFirst", "targetId", "otherId", "isTargetDrawnFirst$ui", "findFocusableNodeFromRect", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", TtmlNode.LEFT, "top", TtmlNode.RIGHT, "bottom", "containerId", "findFocusableNodeFromRect$ui", "intersects", "intersects$ui", "isDescendantOf", TtmlNode.RUBY_CONTAINER, "isDescendantOf$ui", "unsetHasCallbacksFor", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RectManager {
    public static final int $stable = 8;
    private final MutableRect cachedRect;
    private final MutableObjectList<Function0<Unit>> callbacks;
    private final Function0<Unit> dispatchLambda;
    private Object dispatchToken;
    private boolean isDirty;
    private boolean isFragmented;
    private boolean isScreenOrWindowDirty;
    private final IntObjectMap<LayoutNode> layoutNodes;
    private final RectList rects;
    private long scheduledDispatchDeadline;
    private final ThrottledCallbacks throttledCallbacks;

    public RectManager() {
        this(null, 1, null);
    }

    public RectManager(IntObjectMap<LayoutNode> intObjectMap) {
        this.layoutNodes = intObjectMap;
        this.rects = new RectList();
        this.throttledCallbacks = new ThrottledCallbacks();
        this.callbacks = new MutableObjectList<>(0, 1, null);
        this.scheduledDispatchDeadline = -1L;
        this.dispatchLambda = new Function0<Unit>() { // from class: androidx.compose.ui.spatial.RectManager$dispatchLambda$1
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
                RectManager.this.dispatchToken = null;
                RectManager rectManager = RectManager.this;
                Trace.beginSection("OnPositionedDispatch");
                try {
                    rectManager.dispatchCallbacks();
                    Unit unit = Unit.INSTANCE;
                } finally {
                    Trace.endSection();
                }
            }
        };
        this.cachedRect = new MutableRect(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public /* synthetic */ RectManager(IntObjectMap intObjectMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? IntObjectMapKt.intObjectMapOf() : intObjectMap);
    }

    public final RectList getRects() {
        return this.rects;
    }

    public final void invalidate() {
        this.isDirty = true;
    }

    /* renamed from: updateOffsets-gTq6Wqs */
    public final void m6797updateOffsetsgTq6Wqs(long j, long j2, float[] fArr, int i, int i2) {
        int m6800analyzeComponents58bKbWc;
        m6800analyzeComponents58bKbWc = RectManagerKt.m6800analyzeComponents58bKbWc(fArr);
        ThrottledCallbacks throttledCallbacks = this.throttledCallbacks;
        if ((m6800analyzeComponents58bKbWc & 2) != 0) {
            fArr = null;
        }
        this.isScreenOrWindowDirty = throttledCallbacks.m6814updateOffsetsLDcG7Xg(j, j2, fArr, i, i2) || this.isScreenOrWindowDirty;
    }

    public final void dispatchCallbacks() {
        removeScheduledCallback();
        long currentTimeMillis = Actual_androidKt.currentTimeMillis();
        boolean z = this.isDirty;
        boolean z2 = z || this.isScreenOrWindowDirty;
        if (z) {
            this.isDirty = false;
            MutableObjectList<Function0<Unit>> mutableObjectList = this.callbacks;
            Object[] objArr = mutableObjectList.content;
            int i = mutableObjectList._size;
            for (int i2 = 0; i2 < i; i2++) {
                ((Function0) objArr[i2]).invoke();
            }
            RectList rectList = this.rects;
            long[] jArr = rectList.items;
            int i3 = rectList.itemsSize;
            for (int i4 = 0; i4 < jArr.length - 2 && i4 < i3; i4 += 3) {
                long j = jArr[i4 + 2];
                if ((((int) (j >> 60)) & 1) != 0) {
                    this.throttledCallbacks.fireOnUpdatedRect(33554431 & ((int) j), jArr[i4], jArr[i4 + 1], currentTimeMillis);
                }
            }
            this.rects.clearUpdated();
        }
        if (this.isScreenOrWindowDirty) {
            this.isScreenOrWindowDirty = false;
            this.throttledCallbacks.fireOnRectChangedEntries(currentTimeMillis);
        }
        if (z2) {
            this.throttledCallbacks.fireGlobalChangeEntries(currentTimeMillis);
        }
        if (this.isFragmented) {
            this.isFragmented = false;
            this.rects.defragment();
        }
        this.throttledCallbacks.triggerDebounced(currentTimeMillis);
        if (this.throttledCallbacks.getMinDebounceDeadline() > 0) {
            scheduleDebounceCallback(true);
        }
    }

    public final void scheduleDebounceCallback(boolean z) {
        boolean z2 = (z && this.dispatchToken == null) ? false : true;
        long minDebounceDeadline = this.throttledCallbacks.getMinDebounceDeadline();
        if (minDebounceDeadline >= 0 || !z2) {
            if (this.scheduledDispatchDeadline == minDebounceDeadline && z2) {
                return;
            }
            Object obj = this.dispatchToken;
            if (obj != null) {
                Actual_androidKt.removePost(obj);
            }
            long currentTimeMillis = Actual_androidKt.currentTimeMillis();
            long max = Math.max(minDebounceDeadline, 16 + currentTimeMillis);
            this.scheduledDispatchDeadline = max;
            this.dispatchToken = Actual_androidKt.postDelayed(max - currentTimeMillis, this.dispatchLambda);
        }
    }

    public final void removeScheduledCallback() {
        Object obj = this.dispatchToken;
        if (obj != null) {
            Actual_androidKt.removePost(obj);
            this.dispatchToken = null;
        }
    }

    public final Object registerOnChangedCallback(Function0<Unit> function0) {
        this.callbacks.add(function0);
        return function0;
    }

    public final DelegatableNode.RegistrationHandle registerOnRectChangedCallback(int i, long j, long j2, DelegatableNode delegatableNode, Function1<? super RelativeLayoutBounds, Unit> function1) {
        DelegatableNode.RegistrationHandle registerOnRectChanged = this.throttledCallbacks.registerOnRectChanged(i, j, j2, delegatableNode, function1);
        if (DelegatableNodeKt.requireLayoutNode(delegatableNode.getNode()).getAddedToRectList$ui()) {
            this.rects.updateHasCallbacks(i, true);
        }
        invalidate();
        scheduleDebounceCallback(true);
        return registerOnRectChanged;
    }

    public final DelegatableNode.RegistrationHandle registerOnGlobalLayoutCallback(int i, long j, long j2, DelegatableNode delegatableNode, Function1<? super RelativeLayoutBounds, Unit> function1) {
        return this.throttledCallbacks.registerOnGlobalChange(i, j, j2, delegatableNode, function1);
    }

    public final void unregisterOnChangedCallback(Object obj) {
        if ((TypeIntrinsics.isFunctionOfArity(obj, 0) ? (Function0) obj : null) == null) {
            return;
        }
        this.callbacks.remove(obj);
    }

    public final void invalidateCallbacksFor(LayoutNode layoutNode) {
        if (layoutNode.getAddedToRectList$ui()) {
            this.isDirty = true;
            this.rects.markUpdated(layoutNode.getSemanticsId());
        }
        scheduleDebounceCallback(true);
    }

    public final void updateFlagsFor(LayoutNode layoutNode, boolean z, boolean z2) {
        if (layoutNode.isAttached()) {
            this.rects.updateFlagsFor(layoutNode.getSemanticsId(), z, z2);
        }
    }

    public final void onLayoutLayerPositionalPropertiesChanged(LayoutNode layoutNode) {
        boolean m6801isSetgyyYBs;
        if (layoutNode.isPlaced()) {
            long m6795outerToInnerOffsetBjo55l4 = m6795outerToInnerOffsetBjo55l4(layoutNode);
            m6801isSetgyyYBs = RectManagerKt.m6801isSetgyyYBs(m6795outerToInnerOffsetBjo55l4);
            if (m6801isSetgyyYBs) {
                layoutNode.m6450setOuterToInnerOffsetgyyYBs$ui(m6795outerToInnerOffsetBjo55l4);
                layoutNode.setOuterToInnerOffsetDirty$ui(false);
                MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui();
                LayoutNode[] layoutNodeArr = mutableVector.content;
                int size = mutableVector.getSize();
                for (int i = 0; i < size; i++) {
                    onLayoutPositionChanged$default(this, layoutNodeArr[i], false, 2, null);
                }
                invalidateCallbacksFor(layoutNode);
                return;
            }
            insertOrUpdateTransformedNodeSubhierarchy(layoutNode);
        }
    }

    public static /* synthetic */ void onLayoutPositionChanged$default(RectManager rectManager, LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        rectManager.onLayoutPositionChanged(layoutNode, z);
    }

    public final void onLayoutPositionChanged(LayoutNode layoutNode, boolean z) {
        long m7693getMaxnOccac;
        boolean m6801isSetgyyYBs;
        long j;
        long j2;
        if (layoutNode.isPlaced()) {
            LayoutNode parent$ui = layoutNode.getParent$ui();
            if (parent$ui != null && !parent$ui.getHasPositionalLayerTransformationsInOffsetFromRoot$ui()) {
                if (parent$ui.getOuterToInnerOffsetDirty$ui()) {
                    parent$ui.setOuterToInnerOffsetDirty$ui(false);
                    parent$ui.m6450setOuterToInnerOffsetgyyYBs$ui(m6795outerToInnerOffsetBjo55l4(parent$ui));
                }
                m7693getMaxnOccac = parent$ui.m6443getOuterToInnerOffsetnOccac$ui();
            } else if (parent$ui == null) {
                m7693getMaxnOccac = IntOffset.Companion.m7694getZeronOccac();
            } else {
                m7693getMaxnOccac = IntOffset.Companion.m7693getMaxnOccac();
            }
            NodeCoordinator outerCoordinator$ui = layoutNode.getOuterCoordinator$ui();
            m6801isSetgyyYBs = RectManagerKt.m6801isSetgyyYBs(m7693getMaxnOccac);
            if (m6801isSetgyyYBs && !hasPositionalLayerTransformations(outerCoordinator$ui)) {
                if (!layoutNode.getHasPositionalLayerTransformationsInOffsetFromRoot$ui()) {
                    long m7687plusqkQi6aY = IntOffset.m7687plusqkQi6aY(m7693getMaxnOccac, outerCoordinator$ui.mo6464getPositionnOccac());
                    MeasurePassDelegate measurePassDelegate$ui = layoutNode.getMeasurePassDelegate$ui();
                    int measuredWidth = measurePassDelegate$ui.getMeasuredWidth();
                    int measuredHeight = measurePassDelegate$ui.getMeasuredHeight();
                    long m7721constructorimpl = IntSize.m7721constructorimpl((measuredWidth << 32) | (measuredHeight & 4294967295L));
                    int semanticsId = layoutNode.getSemanticsId();
                    if (layoutNode.getAddedToRectList$ui()) {
                        if (z || !IntOffset.m7682equalsimpl0(m7687plusqkQi6aY, layoutNode.m6441getLastOffsetFromParentnOccac$ui()) || !IntSize.m7724equalsimpl0(m7721constructorimpl, layoutNode.m6442getLastSizeYbymL2g$ui())) {
                            RectList rectList = this.rects;
                            if (parent$ui != null) {
                                rectList.moveBasedOnParentOffset(semanticsId, parent$ui.getSemanticsId(), IntOffset.m7683getXimpl(m7687plusqkQi6aY), IntOffset.m7684getYimpl(m7687plusqkQi6aY), measuredWidth, measuredHeight);
                            } else {
                                rectList.move(semanticsId, IntOffset.m7683getXimpl(m7687plusqkQi6aY), IntOffset.m7684getYimpl(m7687plusqkQi6aY), IntOffset.m7683getXimpl(m7687plusqkQi6aY) + measuredWidth, IntOffset.m7684getYimpl(m7687plusqkQi6aY) + measuredHeight);
                            }
                            invalidate();
                        }
                        j = m7687plusqkQi6aY;
                        j2 = m7721constructorimpl;
                    } else {
                        layoutNode.setAddedToRectList$ui(true);
                        boolean m6496hasH91voCI$ui = layoutNode.getNodes$ui().m6496hasH91voCI$ui(NodeKind.m6535constructorimpl(1024));
                        boolean m6496hasH91voCI$ui2 = layoutNode.getNodes$ui().m6496hasH91voCI$ui(NodeKind.m6535constructorimpl(16));
                        boolean containsKey = this.throttledCallbacks.getRectChangedMap().containsKey(semanticsId);
                        RectList rectList2 = this.rects;
                        if (parent$ui != null) {
                            j = m7687plusqkQi6aY;
                            j2 = m7721constructorimpl;
                            rectList2.insertBasedOnParentOffset(semanticsId, parent$ui.getSemanticsId(), IntOffset.m7683getXimpl(m7687plusqkQi6aY), IntOffset.m7684getYimpl(m7687plusqkQi6aY), measuredWidth, measuredHeight, m6496hasH91voCI$ui, m6496hasH91voCI$ui2, containsKey);
                        } else {
                            j = m7687plusqkQi6aY;
                            j2 = m7721constructorimpl;
                            RectList.insert$default(rectList2, semanticsId, IntOffset.m7683getXimpl(j), IntOffset.m7684getYimpl(j), IntOffset.m7683getXimpl(j) + measuredWidth, IntOffset.m7684getYimpl(j) + measuredHeight, 0, m6496hasH91voCI$ui, m6496hasH91voCI$ui2, containsKey, 0, 544, null);
                        }
                        invalidate();
                    }
                    layoutNode.m6449setLastSizeozmzZPI$ui(j2);
                    layoutNode.m6448setLastOffsetFromParentgyyYBs$ui(j);
                    return;
                }
                insertOrUpdateTransformedNodeSubhierarchy(layoutNode);
                resetHasPositionalLayerTransformationsForSubtreeIfNeeded(layoutNode);
                return;
            }
            insertOrUpdateTransformedNodeSubhierarchy(layoutNode);
        }
    }

    /* renamed from: getOffsetFromRectListFor-Bjo55l4 */
    public final long m6796getOffsetFromRectListForBjo55l4(LayoutNode layoutNode) {
        long topLeft = this.rects.getTopLeft(layoutNode.getSemanticsId());
        if (topLeft == Long.MAX_VALUE) {
            return IntOffset.Companion.m7693getMaxnOccac();
        }
        return IntOffset.m7677constructorimpl((((int) (topLeft >> 32)) << 32) | (((int) topLeft) & 4294967295L));
    }

    private final void resetHasPositionalLayerTransformationsForSubtreeIfNeeded(LayoutNode layoutNode) {
        if (!layoutNode.getHasPositionalLayerTransformationsInOffsetFromRoot$ui() || hasPositionalLayerTransformations(layoutNode.getOuterCoordinator$ui())) {
            return;
        }
        layoutNode.setHasPositionalLayerTransformationsInOffsetFromRoot$ui(false);
        if (layoutNode.getOuterToInnerOffsetDirty$ui()) {
            layoutNode.m6450setOuterToInnerOffsetgyyYBs$ui(m6795outerToInnerOffsetBjo55l4(layoutNode));
            layoutNode.setOuterToInnerOffsetDirty$ui(false);
        }
        if (IntOffset.m7682equalsimpl0(layoutNode.m6443getOuterToInnerOffsetnOccac$ui(), IntOffset.Companion.m7693getMaxnOccac())) {
            return;
        }
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            resetHasPositionalLayerTransformationsForSubtreeIfNeeded(layoutNodeArr[i]);
        }
    }

    private final void insertOrUpdateTransformedNodeSubhierarchy(LayoutNode layoutNode) {
        insertOrUpdateTransformedNode(layoutNode);
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            LayoutNode layoutNode2 = layoutNodeArr[i];
            if (layoutNode2.isPlaced()) {
                insertOrUpdateTransformedNodeSubhierarchy(layoutNode2);
            }
        }
    }

    private final void insertOrUpdateTransformedNode(LayoutNode layoutNode) {
        layoutNode.setHasPositionalLayerTransformationsInOffsetFromRoot$ui(true);
        layoutNode.m6448setLastOffsetFromParentgyyYBs$ui(IntOffset.Companion.m7693getMaxnOccac());
        NodeCoordinator outerCoordinator$ui = layoutNode.getOuterCoordinator$ui();
        MeasurePassDelegate measurePassDelegate$ui = layoutNode.getMeasurePassDelegate$ui();
        int measuredWidth = measurePassDelegate$ui.getMeasuredWidth();
        int measuredHeight = measurePassDelegate$ui.getMeasuredHeight();
        MutableRect mutableRect = this.cachedRect;
        mutableRect.set(0.0f, 0.0f, measuredWidth, measuredHeight);
        boundingRectInRoot(outerCoordinator$ui, mutableRect);
        int left = (int) mutableRect.getLeft();
        int top = (int) mutableRect.getTop();
        int right = (int) mutableRect.getRight();
        int bottom = (int) mutableRect.getBottom();
        int semanticsId = layoutNode.getSemanticsId();
        boolean addedToRectList$ui = layoutNode.getAddedToRectList$ui();
        layoutNode.setAddedToRectList$ui(true);
        if (!addedToRectList$ui || !this.rects.update(semanticsId, left, top, right, bottom)) {
            LayoutNode parent$ui = layoutNode.getParent$ui();
            RectList.insert$default(this.rects, semanticsId, left, top, right, bottom, parent$ui != null ? parent$ui.getSemanticsId() : -1, layoutNode.getNodes$ui().m6496hasH91voCI$ui(NodeKind.m6535constructorimpl(1024)), layoutNode.getNodes$ui().m6496hasH91voCI$ui(NodeKind.m6535constructorimpl(16)), this.throttledCallbacks.getRectChangedMap().containsKey(semanticsId), 0, 512, null);
        }
        invalidate();
    }

    private final void boundingRectInRoot(NodeCoordinator nodeCoordinator, MutableRect mutableRect) {
        long m6796getOffsetFromRectListForBjo55l4;
        while (nodeCoordinator != null) {
            LayoutNode layoutNode = nodeCoordinator.getLayoutNode();
            if (nodeCoordinator == layoutNode.getOuterCoordinator$ui() && !layoutNode.getHasPositionalLayerTransformationsInOffsetFromRoot$ui()) {
                if (!IntOffset.m7682equalsimpl0(m6796getOffsetFromRectListForBjo55l4(layoutNode), IntOffset.Companion.m7693getMaxnOccac())) {
                    mutableRect.m4512translatek4lQ0M(Offset.m4519constructorimpl((Float.floatToRawIntBits(IntOffset.m7684getYimpl(m6796getOffsetFromRectListForBjo55l4)) & 4294967295L) | (Float.floatToRawIntBits(IntOffset.m7683getXimpl(m6796getOffsetFromRectListForBjo55l4)) << 32)));
                    return;
                }
            }
            OwnedLayer layer = nodeCoordinator.getLayer();
            if (layer != null) {
                float[] mo6592getUnderlyingMatrixsQKQjiQ = layer.mo6592getUnderlyingMatrixsQKQjiQ();
                if (!MatrixKt.m5041isIdentity58bKbWc(mo6592getUnderlyingMatrixsQKQjiQ)) {
                    Matrix.m5024mapimpl(mo6592getUnderlyingMatrixsQKQjiQ, mutableRect);
                }
            }
            long mo6464getPositionnOccac = nodeCoordinator.mo6464getPositionnOccac();
            mutableRect.m4512translatek4lQ0M(Offset.m4519constructorimpl((Float.floatToRawIntBits(IntOffset.m7684getYimpl(mo6464getPositionnOccac)) & 4294967295L) | (Float.floatToRawIntBits(IntOffset.m7683getXimpl(mo6464getPositionnOccac)) << 32)));
            nodeCoordinator = nodeCoordinator.getWrappedBy$ui();
        }
    }

    private final boolean hasPositionalLayerTransformations(NodeCoordinator nodeCoordinator) {
        OwnedLayer layer = nodeCoordinator.getLayer();
        return (layer == null || MatrixKt.m5041isIdentity58bKbWc(layer.mo6592getUnderlyingMatrixsQKQjiQ())) ? false : true;
    }

    /* renamed from: outerToInnerOffset-Bjo55l4 */
    private final long m6795outerToInnerOffsetBjo55l4(LayoutNode layoutNode) {
        NodeCoordinator outerCoordinator$ui = layoutNode.getOuterCoordinator$ui();
        long m7694getZeronOccac = IntOffset.Companion.m7694getZeronOccac();
        for (NodeCoordinator innerCoordinator$ui = layoutNode.getInnerCoordinator$ui(); innerCoordinator$ui != null && innerCoordinator$ui != outerCoordinator$ui; innerCoordinator$ui = innerCoordinator$ui.getWrappedBy$ui()) {
            if (hasPositionalLayerTransformations(innerCoordinator$ui)) {
                return IntOffset.Companion.m7693getMaxnOccac();
            }
            m7694getZeronOccac = IntOffset.m7687plusqkQi6aY(m7694getZeronOccac, innerCoordinator$ui.mo6464getPositionnOccac());
        }
        return m7694getZeronOccac;
    }

    public final void remove(LayoutNode layoutNode) {
        if (layoutNode.getAddedToRectList$ui()) {
            this.rects.remove(layoutNode.getSemanticsId());
            layoutNode.setAddedToRectList$ui(false);
            invalidate();
            this.isFragmented = true;
        }
    }

    public final boolean isTargetDrawnFirst$ui(int i, int i2) {
        LayoutNode layoutNode;
        LayoutNode parent$ui;
        LayoutNode layoutNode2 = this.layoutNodes.get(i);
        if (layoutNode2 != null && (layoutNode = this.layoutNodes.get(i2)) != null && layoutNode2.getDepth$ui() != 0 && layoutNode.getDepth$ui() != 0) {
            while (layoutNode2.getDepth$ui() > layoutNode.getDepth$ui()) {
                layoutNode2 = layoutNode2.getParent$ui();
                if (layoutNode2 == null) {
                    return false;
                }
            }
            if (layoutNode2 == layoutNode) {
                return false;
            }
            while (layoutNode.getDepth$ui() > layoutNode2.getDepth$ui()) {
                layoutNode = layoutNode.getParent$ui();
                if (layoutNode == null) {
                    return false;
                }
            }
            if (layoutNode2 == layoutNode) {
                return false;
            }
            LayoutNode layoutNode3 = layoutNode;
            LayoutNode layoutNode4 = layoutNode3;
            LayoutNode layoutNode5 = layoutNode2;
            while (layoutNode2 != layoutNode3) {
                LayoutNode parent$ui2 = layoutNode2.getParent$ui();
                if (parent$ui2 == null || (parent$ui = layoutNode3.getParent$ui()) == null) {
                    return false;
                }
                layoutNode5 = layoutNode2;
                layoutNode2 = parent$ui2;
                layoutNode4 = layoutNode3;
                layoutNode3 = parent$ui;
            }
            if (layoutNode5.getMeasurePassDelegate$ui().getZIndex$ui() == layoutNode4.getMeasurePassDelegate$ui().getZIndex$ui()) {
                return layoutNode5.getPlaceOrder$ui() < layoutNode4.getPlaceOrder$ui();
            } else if (layoutNode5.getMeasurePassDelegate$ui().getZIndex$ui() < layoutNode4.getMeasurePassDelegate$ui().getZIndex$ui()) {
                return true;
            }
        }
        return false;
    }

    public final FocusTargetModifierNode findFocusableNodeFromRect$ui(int i, int i2, int i3, int i4, int i5) {
        int i6;
        LayoutNode layoutNode;
        char c;
        FocusTargetNode focusTargetNode;
        int i7;
        LayoutNode layoutNode2;
        boolean z;
        int i8;
        LayoutNode layoutNode3;
        int i9;
        MutableVector mutableVector;
        SemanticsInfo requireSemanticsInfo;
        RectManager rectManager = this;
        LayoutNode layoutNode4 = rectManager.layoutNodes.get(i5);
        if (layoutNode4 == null) {
            return null;
        }
        FocusTargetNode activeFocusTargetNode = LayoutNodeKt.requireOwner(layoutNode4).getFocusOwner().getActiveFocusTargetNode();
        int semanticsId = (activeFocusTargetNode == null || (requireSemanticsInfo = DelegatableNodeKt.requireSemanticsInfo(activeFocusTargetNode)) == null) ? -1 : requireSemanticsInfo.getSemanticsId();
        RectList rectList = rectManager.rects;
        int i10 = i2;
        long j = (i10 & 4294967295L) | (i << 32);
        long j2 = (i4 & 4294967295L) | (i3 << 32);
        long[] jArr = rectList.items;
        int i11 = rectList.itemsSize;
        int i12 = Integer.MAX_VALUE;
        FocusTargetNode focusTargetNode2 = null;
        int i13 = 0;
        while (i13 < jArr.length - 2 && i13 < i11) {
            int i14 = i13;
            long j3 = jArr[i13 + 2];
            boolean z2 = true;
            if ((((int) (j3 >> 61)) & 1) != 0) {
                if (((((j2 - jArr[i14]) - InlineClassHelperKt.Uint64Low32) | ((jArr[i14 + 1] - j) - InlineClassHelperKt.Uint64Low32)) & (-9223372034707292160L)) == 0) {
                    int i15 = ((int) j3) & 33554431;
                    LayoutNode layoutNode5 = rectManager.layoutNodes.get(i15);
                    if (layoutNode5 != null) {
                        if (semanticsId == i15) {
                            c = 65535;
                            if (semanticsId != -1) {
                                return null;
                            }
                        } else {
                            c = 65535;
                        }
                        if (layoutNode5.getDepth$ui() >= i12 || !rectManager.isDescendantOf$ui(layoutNode5, layoutNode4)) {
                            i6 = i12;
                            layoutNode = layoutNode4;
                        } else {
                            NodeChain nodes$ui = layoutNode5.getNodes$ui();
                            int m6535constructorimpl = NodeKind.m6535constructorimpl(1024);
                            if ((nodes$ui.getAggregateChildKindSet() & m6535constructorimpl) != 0) {
                                Modifier.Node head$ui = nodes$ui.getHead$ui();
                                while (head$ui != null) {
                                    if ((head$ui.getKindSet$ui() & m6535constructorimpl) != 0) {
                                        MutableVector mutableVector2 = null;
                                        focusTargetNode = head$ui;
                                        while (focusTargetNode != null) {
                                            if (focusTargetNode instanceof FocusTargetNode) {
                                                i6 = i12;
                                                layoutNode = layoutNode4;
                                                break;
                                            }
                                            if ((focusTargetNode.getKindSet$ui() & m6535constructorimpl) == 0 || !(focusTargetNode instanceof DelegatingNode)) {
                                                i7 = i12;
                                                layoutNode2 = layoutNode4;
                                                z = true;
                                            } else {
                                                Modifier.Node delegate$ui = ((DelegatingNode) focusTargetNode).getDelegate$ui();
                                                int i16 = 0;
                                                while (delegate$ui != null) {
                                                    if ((delegate$ui.getKindSet$ui() & m6535constructorimpl) != 0) {
                                                        i16++;
                                                        i8 = i12;
                                                        if (i16 == 1) {
                                                            focusTargetNode = delegate$ui;
                                                        } else {
                                                            if (mutableVector2 == null) {
                                                                i9 = i16;
                                                                layoutNode3 = layoutNode4;
                                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                            } else {
                                                                i9 = i16;
                                                                layoutNode3 = layoutNode4;
                                                                mutableVector = mutableVector2;
                                                            }
                                                            if (focusTargetNode != null) {
                                                                if (mutableVector != null) {
                                                                    mutableVector.add(focusTargetNode);
                                                                }
                                                                focusTargetNode = null;
                                                            }
                                                            if (mutableVector != null) {
                                                                mutableVector.add(delegate$ui);
                                                            }
                                                            mutableVector2 = mutableVector;
                                                            i16 = i9;
                                                            delegate$ui = delegate$ui.getChild$ui();
                                                            i12 = i8;
                                                            layoutNode4 = layoutNode3;
                                                        }
                                                    } else {
                                                        i8 = i12;
                                                    }
                                                    layoutNode3 = layoutNode4;
                                                    delegate$ui = delegate$ui.getChild$ui();
                                                    i12 = i8;
                                                    layoutNode4 = layoutNode3;
                                                }
                                                i7 = i12;
                                                layoutNode2 = layoutNode4;
                                                z = true;
                                                if (i16 == 1) {
                                                    z2 = z;
                                                    i12 = i7;
                                                    layoutNode4 = layoutNode2;
                                                }
                                            }
                                            focusTargetNode = DelegatableNodeKt.pop(mutableVector2);
                                            z2 = z;
                                            i12 = i7;
                                            layoutNode4 = layoutNode2;
                                        }
                                    }
                                    i6 = i12;
                                    boolean z3 = z2;
                                    layoutNode = layoutNode4;
                                    if ((head$ui.getAggregateChildKindSet$ui() & m6535constructorimpl) == 0) {
                                        break;
                                    }
                                    head$ui = head$ui.getChild$ui();
                                    z2 = z3;
                                    i12 = i6;
                                    layoutNode4 = layoutNode;
                                }
                            }
                            i6 = i12;
                            layoutNode = layoutNode4;
                            focusTargetNode = null;
                            FocusTargetNode focusTargetNode3 = focusTargetNode;
                            if (focusTargetNode3 != null) {
                                if (intersects$ui(focusTargetNode3, i, i10, i3, i4)) {
                                    i12 = layoutNode5.getDepth$ui();
                                    focusTargetNode2 = focusTargetNode3;
                                    i13 = i14 + 3;
                                    rectManager = this;
                                    i10 = i2;
                                    layoutNode4 = layoutNode;
                                }
                            }
                        }
                        i12 = i6;
                        i13 = i14 + 3;
                        rectManager = this;
                        i10 = i2;
                        layoutNode4 = layoutNode;
                    } else {
                        i6 = i12;
                        layoutNode = layoutNode4;
                    }
                    i12 = i6;
                    i13 = i14 + 3;
                    rectManager = this;
                    i10 = i2;
                    layoutNode4 = layoutNode;
                }
            }
            i6 = i12;
            layoutNode = layoutNode4;
            i12 = i6;
            i13 = i14 + 3;
            rectManager = this;
            i10 = i2;
            layoutNode4 = layoutNode;
        }
        return focusTargetNode2;
    }

    public final boolean isDescendantOf$ui(LayoutNode layoutNode, LayoutNode layoutNode2) {
        int depth$ui = layoutNode.getDepth$ui() - layoutNode2.getDepth$ui();
        if (depth$ui <= 0) {
            return false;
        }
        for (int i = 0; i < depth$ui; i++) {
            layoutNode = layoutNode.getParent$ui();
            if (layoutNode == null) {
                return false;
            }
        }
        return layoutNode == layoutNode2;
    }

    public final void unsetHasCallbacksFor(LayoutNode layoutNode) {
        this.rects.updateHasCallbacks(layoutNode.getSemanticsId(), false);
    }

    public final boolean intersects$ui(DelegatableNode delegatableNode, int i, int i2, int i3, int i4) {
        NodeCoordinator m6387requireCoordinator64DMado = DelegatableNodeKt.m6387requireCoordinator64DMado(delegatableNode, NodeKind.m6535constructorimpl(1024));
        LayoutNode layoutNode = m6387requireCoordinator64DMado.getLayoutNode();
        if (Intrinsics.areEqual(m6387requireCoordinator64DMado, layoutNode.getOuterCoordinator$ui())) {
            return true;
        }
        long mo6227localToRootMKHz9U = layoutNode.getOuterCoordinator$ui().mo6227localToRootMKHz9U(LayoutCoordinates.m6223localPositionOfS_NoaFU$default(layoutNode.getOuterCoordinator$ui(), m6387requireCoordinator64DMado, 0L, false, 6, null));
        long mo6224getSizeYbymL2g = m6387requireCoordinator64DMado.mo6224getSizeYbymL2g();
        int round = Math.round(Float.intBitsToFloat((int) (mo6227localToRootMKHz9U >> 32)));
        int i5 = ((int) (mo6224getSizeYbymL2g >> 32)) + round;
        int round2 = Math.round(Float.intBitsToFloat((int) (mo6227localToRootMKHz9U & 4294967295L)));
        return i < i5 && i3 > round && i2 < ((int) (mo6224getSizeYbymL2g & 4294967295L)) + round2 && i4 > round2;
    }
}
