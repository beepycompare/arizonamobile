package androidx.compose.ui.spatial;

import android.os.Trace;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Actual_androidKt;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.MatrixKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.MeasurePassDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
/* compiled from: RectManager.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u000bJ8\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u001dH\u0002J*\u0010(\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010)\u001a\u00020*2\u0006\u0010#\u001a\u00020\u000fH\u0002ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u0004H\u0002J\u0006\u0010.\u001a\u00020\u000bJ\u000e\u0010/\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u0004J\u001d\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u001dH\u0000¢\u0006\u0002\b3J\u000e\u00104\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u0004J(\u00105\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010)\u001a\u00020*2\u0006\u0010#\u001a\u00020\u000fø\u0001\u0000¢\u0006\u0004\b6\u0010,J\u0016\u00107\u001a\u0004\u0018\u00010\u00012\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ:\u00109\u001a\u00020:2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020\u00172\u0006\u0010<\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000b0=J:\u0010>\u001a\u00020:2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020\u00172\u0006\u0010<\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000b0=J\u000e\u0010?\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u0004J\u000e\u0010@\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020\u000fJ\u0010\u0010B\u001a\u00020\u000b2\b\u0010C\u001a\u0004\u0018\u00010\u0001J(\u0010D\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020*2\u0006\u0010F\u001a\u00020*2\u0006\u0010G\u001a\u00020Hø\u0001\u0000¢\u0006\u0004\bI\u0010JJ\u0014\u0010K\u001a\u00020\u000b*\u00020L2\u0006\u0010M\u001a\u00020\u0007H\u0002J\u0019\u0010N\u001a\u00020**\u00020\u0004H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bO\u0010PJ\u0019\u0010Q\u001a\u00020**\u00020LH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bR\u0010SR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006T"}, d2 = {"Landroidx/compose/ui/spatial/RectManager;", "", "layoutNodes", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/collection/IntObjectMap;)V", "cachedRect", "Landroidx/compose/ui/geometry/MutableRect;", "callbacks", "Landroidx/collection/MutableObjectList;", "Lkotlin/Function0;", "", "dispatchLambda", "dispatchToken", "isDirty", "", "isFragmented", "isScreenOrWindowDirty", "rects", "Landroidx/compose/ui/spatial/RectList;", "getRects", "()Landroidx/compose/ui/spatial/RectList;", "scheduledDispatchDeadline", "", "throttledCallbacks", "Landroidx/compose/ui/spatial/ThrottledCallbacks;", "currentRectInfo", "Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "id", "", "node", "Landroidx/compose/ui/node/DelegatableNode;", "dispatchCallbacks", "insertOrUpdate", "layoutNode", "firstPlacement", CmcdData.STREAM_TYPE_LIVE, "t", "r", "b", "insertOrUpdateTransformedNode", "position", "Landroidx/compose/ui/unit/IntOffset;", "insertOrUpdateTransformedNode-70tqf50", "(Landroidx/compose/ui/node/LayoutNode;JZ)V", "insertOrUpdateTransformedNodeSubhierarchy", "invalidate", "invalidateCallbacksFor", "isTargetDrawnFirst", "targetId", "otherId", "isTargetDrawnFirst$ui_release", "onLayoutLayerPositionalPropertiesChanged", "onLayoutPositionChanged", "onLayoutPositionChanged-70tqf50", "registerOnChangedCallback", "callback", "registerOnGlobalLayoutCallback", "Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "throttleMillis", "debounceMillis", "Lkotlin/Function1;", "registerOnRectChangedCallback", "remove", "scheduleDebounceCallback", "ensureSomethingScheduled", "unregisterOnChangedCallback", "token", "updateOffsets", "screenOffset", "windowOffset", "viewToWindowMatrix", "Landroidx/compose/ui/graphics/Matrix;", "updateOffsets-ucfNpQE", "(JJ[F)V", "boundingRectInRoot", "Landroidx/compose/ui/node/NodeCoordinator;", "rect", "outerToInnerOffset", "outerToInnerOffset-Bjo55l4", "(Landroidx/compose/ui/node/LayoutNode;)J", "positionInRoot", "positionInRoot-Bjo55l4", "(Landroidx/compose/ui/node/NodeCoordinator;)J", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    /* renamed from: updateOffsets-ucfNpQE  reason: not valid java name */
    public final void m5936updateOffsetsucfNpQE(long j, long j2, float[] fArr) {
        int m5939analyzeComponents58bKbWc;
        m5939analyzeComponents58bKbWc = RectManagerKt.m5939analyzeComponents58bKbWc(fArr);
        ThrottledCallbacks throttledCallbacks = this.throttledCallbacks;
        if ((m5939analyzeComponents58bKbWc & 2) != 0) {
            fArr = null;
        }
        this.isScreenOrWindowDirty = throttledCallbacks.m5952updateOffsetsbT0EZQs(j, j2, fArr) || this.isScreenOrWindowDirty;
    }

    public final void dispatchCallbacks() {
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
                if ((((int) (j >> 61)) & 1) != 0) {
                    this.throttledCallbacks.fireOnUpdatedRect(67108863 & ((int) j), jArr[i4], jArr[i4 + 1], currentTimeMillis);
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

    public final RelativeLayoutBounds currentRectInfo(int i, final DelegatableNode delegatableNode) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        this.rects.withRect(i, new Function4<Integer, Integer, Integer, Integer, Unit>() { // from class: androidx.compose.ui.spatial.RectManager$currentRectInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2, Integer num3, Integer num4) {
                invoke(num.intValue(), num2.intValue(), num3.intValue(), num4.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r12v9, types: [androidx.compose.ui.spatial.RelativeLayoutBounds, T] */
            public final void invoke(int i2, int i3, int i4, int i5) {
                ThrottledCallbacks throttledCallbacks;
                ThrottledCallbacks throttledCallbacks2;
                ThrottledCallbacks throttledCallbacks3;
                throttledCallbacks = this.throttledCallbacks;
                long m5948getWindowOffsetnOccac = throttledCallbacks.m5948getWindowOffsetnOccac();
                throttledCallbacks2 = this.throttledCallbacks;
                long m5946getScreenOffsetnOccac = throttledCallbacks2.m5946getScreenOffsetnOccac();
                throttledCallbacks3 = this.throttledCallbacks;
                objectRef.element = ThrottledCallbacksKt.m5954rectInfoForQMZNJw(delegatableNode, (i2 << 32) | (i3 & 4294967295L), (i4 << 32) | (i5 & 4294967295L), m5948getWindowOffsetnOccac, m5946getScreenOffsetnOccac, throttledCallbacks3.m5947getViewToWindowMatrix3i98HWw());
            }
        });
        return (RelativeLayoutBounds) objectRef.element;
    }

    public final Object registerOnChangedCallback(Function0<Unit> function0) {
        this.callbacks.add(function0);
        return function0;
    }

    public final DelegatableNode.RegistrationHandle registerOnRectChangedCallback(int i, long j, long j2, DelegatableNode delegatableNode, Function1<? super RelativeLayoutBounds, Unit> function1) {
        return this.throttledCallbacks.registerOnRectChanged(i, j, j2, delegatableNode, function1);
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
        this.isDirty = true;
        this.rects.markUpdated(layoutNode.getSemanticsId());
        scheduleDebounceCallback(true);
    }

    public final void onLayoutLayerPositionalPropertiesChanged(LayoutNode layoutNode) {
        boolean m5940isSetgyyYBs;
        if (ComposeUiFlags.isRectTrackingEnabled) {
            long m5933outerToInnerOffsetBjo55l4 = m5933outerToInnerOffsetBjo55l4(layoutNode);
            m5940isSetgyyYBs = RectManagerKt.m5940isSetgyyYBs(m5933outerToInnerOffsetBjo55l4);
            if (m5940isSetgyyYBs) {
                layoutNode.m5621setOuterToInnerOffsetgyyYBs$ui_release(m5933outerToInnerOffsetBjo55l4);
                layoutNode.setOuterToInnerOffsetDirty$ui_release(false);
                MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
                LayoutNode[] layoutNodeArr = mutableVector.content;
                int size = mutableVector.getSize();
                for (int i = 0; i < size; i++) {
                    LayoutNode layoutNode2 = layoutNodeArr[i];
                    m5935onLayoutPositionChanged70tqf50(layoutNode2, layoutNode2.getOuterCoordinator$ui_release().mo5633getPositionnOccac(), false);
                }
                invalidateCallbacksFor(layoutNode);
                return;
            }
            insertOrUpdateTransformedNodeSubhierarchy(layoutNode);
        }
    }

    /* renamed from: onLayoutPositionChanged-70tqf50  reason: not valid java name */
    public final void m5935onLayoutPositionChanged70tqf50(LayoutNode layoutNode, long j, boolean z) {
        long j2;
        long j3;
        boolean m5940isSetgyyYBs;
        boolean m5940isSetgyyYBs2;
        long j4;
        boolean m5940isSetgyyYBs3;
        if (ComposeUiFlags.isRectTrackingEnabled) {
            MeasurePassDelegate measurePassDelegate$ui_release = layoutNode.getMeasurePassDelegate$ui_release();
            int measuredWidth = measurePassDelegate$ui_release.getMeasuredWidth();
            int measuredHeight = measurePassDelegate$ui_release.getMeasuredHeight();
            LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
            long m5613getOffsetFromRootnOccac$ui_release = layoutNode.m5613getOffsetFromRootnOccac$ui_release();
            long m5612getLastSizeYbymL2g$ui_release = layoutNode.m5612getLastSizeYbymL2g$ui_release();
            int i = (int) (m5612getLastSizeYbymL2g$ui_release >> 32);
            int i2 = (int) (m5612getLastSizeYbymL2g$ui_release & 4294967295L);
            boolean z2 = false;
            if (parent$ui_release != null) {
                boolean outerToInnerOffsetDirty$ui_release = parent$ui_release.getOuterToInnerOffsetDirty$ui_release();
                long m5613getOffsetFromRootnOccac$ui_release2 = parent$ui_release.m5613getOffsetFromRootnOccac$ui_release();
                long m5614getOuterToInnerOffsetnOccac$ui_release = parent$ui_release.m5614getOuterToInnerOffsetnOccac$ui_release();
                m5940isSetgyyYBs2 = RectManagerKt.m5940isSetgyyYBs(m5613getOffsetFromRootnOccac$ui_release2);
                if (m5940isSetgyyYBs2) {
                    if (outerToInnerOffsetDirty$ui_release) {
                        j2 = 4294967295L;
                        j4 = m5933outerToInnerOffsetBjo55l4(parent$ui_release);
                        parent$ui_release.m5621setOuterToInnerOffsetgyyYBs$ui_release(j4);
                        parent$ui_release.setOuterToInnerOffsetDirty$ui_release(false);
                    } else {
                        j2 = 4294967295L;
                        j4 = m5614getOuterToInnerOffsetnOccac$ui_release;
                    }
                    m5940isSetgyyYBs3 = RectManagerKt.m5940isSetgyyYBs(j4);
                    j3 = IntOffset.m6816plusqkQi6aY(IntOffset.m6816plusqkQi6aY(m5613getOffsetFromRootnOccac$ui_release2, j4), j);
                    z2 = !m5940isSetgyyYBs3;
                } else {
                    j2 = 4294967295L;
                    j3 = m5934positionInRootBjo55l4(layoutNode.getOuterCoordinator$ui_release());
                }
            } else {
                j2 = 4294967295L;
                j3 = j;
            }
            if (!z2) {
                m5940isSetgyyYBs = RectManagerKt.m5940isSetgyyYBs(j3);
                if (m5940isSetgyyYBs) {
                    layoutNode.m5620setOffsetFromRootgyyYBs$ui_release(j3);
                    layoutNode.m5619setLastSizeozmzZPI$ui_release(IntSize.m6850constructorimpl((measuredWidth << 32) | (measuredHeight & j2)));
                    int m6812getXimpl = IntOffset.m6812getXimpl(j3);
                    int m6813getYimpl = IntOffset.m6813getYimpl(j3);
                    int i3 = m6812getXimpl + measuredWidth;
                    int i4 = m6813getYimpl + measuredHeight;
                    if (!z && IntOffset.m6811equalsimpl0(j3, m5613getOffsetFromRootnOccac$ui_release) && i == measuredWidth && i2 == measuredHeight) {
                        return;
                    }
                    insertOrUpdate(layoutNode, z, m6812getXimpl, m6813getYimpl, i3, i4);
                    return;
                }
            }
            m5932insertOrUpdateTransformedNode70tqf50(layoutNode, j, z);
        }
    }

    /* renamed from: insertOrUpdateTransformedNode-70tqf50  reason: not valid java name */
    private final void m5932insertOrUpdateTransformedNode70tqf50(LayoutNode layoutNode, long j, boolean z) {
        NodeCoordinator outerCoordinator$ui_release = layoutNode.getOuterCoordinator$ui_release();
        MeasurePassDelegate measurePassDelegate$ui_release = layoutNode.getMeasurePassDelegate$ui_release();
        int measuredWidth = measurePassDelegate$ui_release.getMeasuredWidth();
        int measuredHeight = measurePassDelegate$ui_release.getMeasuredHeight();
        MutableRect mutableRect = this.cachedRect;
        mutableRect.set(IntOffset.m6812getXimpl(j), IntOffset.m6813getYimpl(j), IntOffset.m6812getXimpl(j) + measuredWidth, IntOffset.m6813getYimpl(j) + measuredHeight);
        boundingRectInRoot(outerCoordinator$ui_release, mutableRect);
        int left = (int) mutableRect.getLeft();
        int top = (int) mutableRect.getTop();
        int right = (int) mutableRect.getRight();
        int bottom = (int) mutableRect.getBottom();
        int semanticsId = layoutNode.getSemanticsId();
        if (z || !this.rects.update(semanticsId, left, top, right, bottom)) {
            LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
            RectList.insert$default(this.rects, semanticsId, left, top, right, bottom, parent$ui_release != null ? parent$ui_release.getSemanticsId() : -1, false, false, 192, null);
        }
        invalidate();
    }

    private final void insertOrUpdate(LayoutNode layoutNode, boolean z, int i, int i2, int i3, int i4) {
        int semanticsId = layoutNode.getSemanticsId();
        if (z || !this.rects.move(semanticsId, i, i2, i3, i4)) {
            LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
            RectList.insert$default(this.rects, semanticsId, i, i2, i3, i4, parent$ui_release != null ? parent$ui_release.getSemanticsId() : -1, false, false, 192, null);
        }
        invalidate();
    }

    /* renamed from: positionInRoot-Bjo55l4  reason: not valid java name */
    private final long m5934positionInRootBjo55l4(NodeCoordinator nodeCoordinator) {
        int m5939analyzeComponents58bKbWc;
        long m3853getZeroF1C5BW0 = Offset.Companion.m3853getZeroF1C5BW0();
        while (nodeCoordinator != null) {
            OwnedLayer layer = nodeCoordinator.getLayer();
            m3853getZeroF1C5BW0 = IntOffsetKt.m6827plusNvtHpc(m3853getZeroF1C5BW0, nodeCoordinator.mo5633getPositionnOccac());
            nodeCoordinator = nodeCoordinator.getWrappedBy$ui_release();
            if (layer != null) {
                float[] mo5751getUnderlyingMatrixsQKQjiQ = layer.mo5751getUnderlyingMatrixsQKQjiQ();
                m5939analyzeComponents58bKbWc = RectManagerKt.m5939analyzeComponents58bKbWc(mo5751getUnderlyingMatrixsQKQjiQ);
                if (m5939analyzeComponents58bKbWc == 3) {
                    continue;
                } else if ((m5939analyzeComponents58bKbWc & 2) == 0) {
                    return IntOffset.Companion.m6822getMaxnOccac();
                } else {
                    m3853getZeroF1C5BW0 = Matrix.m4315mapMKHz9U(mo5751getUnderlyingMatrixsQKQjiQ, m3853getZeroF1C5BW0);
                }
            }
        }
        return IntOffsetKt.m6829roundk4lQ0M(m3853getZeroF1C5BW0);
    }

    private final void boundingRectInRoot(NodeCoordinator nodeCoordinator, MutableRect mutableRect) {
        while (nodeCoordinator != null) {
            OwnedLayer layer = nodeCoordinator.getLayer();
            long mo5633getPositionnOccac = nodeCoordinator.mo5633getPositionnOccac();
            mutableRect.m3822translatek4lQ0M(Offset.m3829constructorimpl((Float.floatToRawIntBits(IntOffset.m6812getXimpl(mo5633getPositionnOccac)) << 32) | (Float.floatToRawIntBits(IntOffset.m6813getYimpl(mo5633getPositionnOccac)) & 4294967295L)));
            nodeCoordinator = nodeCoordinator.getWrappedBy$ui_release();
            if (layer != null) {
                float[] mo5751getUnderlyingMatrixsQKQjiQ = layer.mo5751getUnderlyingMatrixsQKQjiQ();
                if (!MatrixKt.m4334isIdentity58bKbWc(mo5751getUnderlyingMatrixsQKQjiQ)) {
                    Matrix.m4317mapimpl(mo5751getUnderlyingMatrixsQKQjiQ, mutableRect);
                }
            }
        }
    }

    /* renamed from: outerToInnerOffset-Bjo55l4  reason: not valid java name */
    private final long m5933outerToInnerOffsetBjo55l4(LayoutNode layoutNode) {
        int m5939analyzeComponents58bKbWc;
        NodeCoordinator outerCoordinator$ui_release = layoutNode.getOuterCoordinator$ui_release();
        long m3853getZeroF1C5BW0 = Offset.Companion.m3853getZeroF1C5BW0();
        NodeCoordinator innerCoordinator$ui_release = layoutNode.getInnerCoordinator$ui_release();
        while (innerCoordinator$ui_release != null && innerCoordinator$ui_release != outerCoordinator$ui_release) {
            OwnedLayer layer = innerCoordinator$ui_release.getLayer();
            m3853getZeroF1C5BW0 = IntOffsetKt.m6827plusNvtHpc(m3853getZeroF1C5BW0, innerCoordinator$ui_release.mo5633getPositionnOccac());
            innerCoordinator$ui_release = innerCoordinator$ui_release.getWrappedBy$ui_release();
            if (layer != null) {
                float[] mo5751getUnderlyingMatrixsQKQjiQ = layer.mo5751getUnderlyingMatrixsQKQjiQ();
                m5939analyzeComponents58bKbWc = RectManagerKt.m5939analyzeComponents58bKbWc(mo5751getUnderlyingMatrixsQKQjiQ);
                if (m5939analyzeComponents58bKbWc == 3) {
                    continue;
                } else if ((m5939analyzeComponents58bKbWc & 2) == 0) {
                    return IntOffset.Companion.m6822getMaxnOccac();
                } else {
                    m3853getZeroF1C5BW0 = Matrix.m4315mapMKHz9U(mo5751getUnderlyingMatrixsQKQjiQ, m3853getZeroF1C5BW0);
                }
            }
        }
        return IntOffsetKt.m6829roundk4lQ0M(m3853getZeroF1C5BW0);
    }

    public final void remove(LayoutNode layoutNode) {
        this.rects.remove(layoutNode.getSemanticsId());
        invalidate();
        this.isFragmented = true;
    }

    public final boolean isTargetDrawnFirst$ui_release(int i, int i2) {
        LayoutNode layoutNode;
        LayoutNode parent$ui_release;
        LayoutNode layoutNode2 = this.layoutNodes.get(i);
        if (layoutNode2 != null && (layoutNode = this.layoutNodes.get(i2)) != null && layoutNode2.getDepth$ui_release() != 0 && layoutNode.getDepth$ui_release() != 0) {
            while (layoutNode2.getDepth$ui_release() > layoutNode.getDepth$ui_release()) {
                layoutNode2 = layoutNode2.getParent$ui_release();
                if (layoutNode2 == null) {
                    return false;
                }
            }
            if (layoutNode2 == layoutNode) {
                return false;
            }
            while (layoutNode.getDepth$ui_release() > layoutNode2.getDepth$ui_release()) {
                layoutNode = layoutNode.getParent$ui_release();
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
                LayoutNode parent$ui_release2 = layoutNode2.getParent$ui_release();
                if (parent$ui_release2 == null || (parent$ui_release = layoutNode3.getParent$ui_release()) == null) {
                    return false;
                }
                layoutNode5 = layoutNode2;
                layoutNode2 = parent$ui_release2;
                layoutNode4 = layoutNode3;
                layoutNode3 = parent$ui_release;
            }
            if (layoutNode5.getMeasurePassDelegate$ui_release().getZIndex$ui_release() == layoutNode4.getMeasurePassDelegate$ui_release().getZIndex$ui_release()) {
                return layoutNode5.getPlaceOrder$ui_release() < layoutNode4.getPlaceOrder$ui_release();
            } else if (layoutNode5.getMeasurePassDelegate$ui_release().getZIndex$ui_release() < layoutNode4.getMeasurePassDelegate$ui_release().getZIndex$ui_release()) {
                return true;
            }
        }
        return false;
    }

    private final void insertOrUpdateTransformedNodeSubhierarchy(LayoutNode layoutNode) {
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            LayoutNode layoutNode2 = layoutNodeArr[i];
            m5932insertOrUpdateTransformedNode70tqf50(layoutNode2, layoutNode2.getOuterCoordinator$ui_release().mo5633getPositionnOccac(), false);
            insertOrUpdateTransformedNodeSubhierarchy(layoutNode2);
        }
    }
}
