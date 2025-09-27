package androidx.compose.ui.spatial;

import android.os.Trace;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
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
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.spatial.ThrottledCallbacks;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.TypeIntrinsics;
/* compiled from: RectManager.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0019\u001a\u00020\u0010J5\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u0006\u0010%\u001a\u00020\u0010J\u000e\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u0012J\u0016\u0010(\u001a\u0004\u0018\u00010\u00012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ:\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u0002002\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u001001J:\u00103\u001a\u00020+2\u0006\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u0002002\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u001001J\u0010\u00104\u001a\u00020\u00102\b\u00105\u001a\u0004\u0018\u00010\u0001J\u000e\u00106\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u0004J\u001e\u00108\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u00122\u0006\u0010:\u001a\u00020\u0012J\u000e\u0010;\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u0004J\u0016\u0010<\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u0012J\u0010\u0010>\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u0004H\u0002J\u0010\u0010?\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u0004H\u0002J\u0018\u0010B\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u0012H\u0002J8\u0010C\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u00122\u0006\u0010D\u001a\u00020!2\u0006\u0010E\u001a\u00020!2\u0006\u0010F\u001a\u00020!2\u0006\u0010G\u001a\u00020!H\u0002J\u0014\u0010H\u001a\u00020\u0010*\u00020I2\u0006\u0010J\u001a\u00020AH\u0002J\u0013\u0010K\u001a\u00020\u001c*\u00020\u0004H\u0002¢\u0006\u0004\bL\u0010MJ\u000e\u0010N\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u0004J\u001d\u0010O\u001a\u00020\u00122\u0006\u0010P\u001a\u00020!2\u0006\u0010Q\u001a\u00020!H\u0000¢\u0006\u0002\bRR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Landroidx/compose/ui/spatial/RectManager;", "", "layoutNodes", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/node/LayoutNode;", "<init>", "(Landroidx/collection/IntObjectMap;)V", "rects", "Landroidx/compose/ui/spatial/RectList;", "getRects", "()Landroidx/compose/ui/spatial/RectList;", "throttledCallbacks", "Landroidx/compose/ui/spatial/ThrottledCallbacks;", "callbacks", "Landroidx/collection/MutableObjectList;", "Lkotlin/Function0;", "", "isDirty", "", "isScreenOrWindowDirty", "isFragmented", "dispatchToken", "scheduledDispatchDeadline", "", "dispatchLambda", "invalidate", "updateOffsets", "screenOffset", "Landroidx/compose/ui/unit/IntOffset;", "windowOffset", "viewToWindowMatrix", "Landroidx/compose/ui/graphics/Matrix;", "windowWidth", "", "windowHeight", "updateOffsets-gTq6Wqs", "(JJ[FII)V", "dispatchCallbacks", "scheduleDebounceCallback", "ensureSomethingScheduled", "registerOnChangedCallback", "callback", "registerOnRectChangedCallback", "Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "id", "throttleMillis", "debounceMillis", "node", "Landroidx/compose/ui/node/DelegatableNode;", "Lkotlin/Function1;", "Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "registerOnGlobalLayoutCallback", "unregisterOnChangedCallback", "token", "invalidateCallbacksFor", "layoutNode", "updateFlagsFor", "focusable", "gesturable", "onLayoutLayerPositionalPropertiesChanged", "onLayoutPositionChanged", "firstPlacement", "recalculateOffsetFromRoot", "insertOrUpdateTransformedNodeSubhierarchy", "cachedRect", "Landroidx/compose/ui/geometry/MutableRect;", "insertOrUpdateTransformedNode", "insertOrUpdate", CmcdData.STREAM_TYPE_LIVE, "t", "r", "b", "boundingRectInRoot", "Landroidx/compose/ui/node/NodeCoordinator;", "rect", "outerToInnerOffset", "outerToInnerOffset-Bjo55l4", "(Landroidx/compose/ui/node/LayoutNode;)J", "remove", "isTargetDrawnFirst", "targetId", "otherId", "isTargetDrawnFirst$ui_release", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

    /* renamed from: updateOffsets-gTq6Wqs  reason: not valid java name */
    public final void m6496updateOffsetsgTq6Wqs(long j, long j2, float[] fArr, int i, int i2) {
        int m6499analyzeComponents58bKbWc;
        m6499analyzeComponents58bKbWc = RectManagerKt.m6499analyzeComponents58bKbWc(fArr);
        ThrottledCallbacks throttledCallbacks = this.throttledCallbacks;
        if ((m6499analyzeComponents58bKbWc & 2) != 0) {
            fArr = null;
        }
        this.isScreenOrWindowDirty = throttledCallbacks.m6513updateOffsetsLDcG7Xg(j, j2, fArr, i, i2) || this.isScreenOrWindowDirty;
    }

    public final void dispatchCallbacks() {
        long[] jArr;
        long[] jArr2;
        int i;
        final long currentTimeMillis = Actual_androidKt.currentTimeMillis();
        boolean z = this.isDirty;
        int i2 = 0;
        boolean z2 = z || this.isScreenOrWindowDirty;
        if (z) {
            this.isDirty = false;
            MutableObjectList<Function0<Unit>> mutableObjectList = this.callbacks;
            Object[] objArr = mutableObjectList.content;
            int i3 = mutableObjectList._size;
            for (int i4 = 0; i4 < i3; i4++) {
                ((Function0) objArr[i4]).invoke();
            }
            RectList rectList = this.rects;
            long[] jArr3 = rectList.items;
            int i5 = rectList.itemsSize;
            for (int i6 = 0; i6 < jArr3.length - 2 && i6 < i5; i6 += 3) {
                long j = jArr3[i6 + 2];
                if ((((int) (j >> 61)) & 1) != 0) {
                    this.throttledCallbacks.fireOnUpdatedRect(67108863 & ((int) j), jArr3[i6], jArr3[i6 + 1], currentTimeMillis);
                }
            }
            MutableIntObjectMap<ThrottledCallbacks.Entry> rectChangedMap = this.throttledCallbacks.getRectChangedMap();
            Object[] objArr2 = rectChangedMap.values;
            long[] jArr4 = rectChangedMap.metadata;
            int length = jArr4.length - 2;
            if (length >= 0) {
                int i7 = 0;
                while (true) {
                    long j2 = jArr4[i7];
                    if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i8 = 8;
                        int i9 = 8 - ((~(i7 - length)) >>> 31);
                        int i10 = i2;
                        while (i10 < i9) {
                            if ((255 & j2) < 128) {
                                final ThrottledCallbacks.Entry entry = (ThrottledCallbacks.Entry) objArr2[(i7 << 3) + i10];
                                ThrottledCallbacks.Entry entry2 = entry;
                                while (entry2 != null) {
                                    if (entry.getLastInvokeMillis() == Long.MIN_VALUE) {
                                        i = i8;
                                        jArr2 = jArr4;
                                        this.rects.withTopLeftBottomRight(entry.getId(), new Function2<Long, Long, Unit>() { // from class: androidx.compose.ui.spatial.RectManager$dispatchCallbacks$3$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2) {
                                                invoke(l.longValue(), l2.longValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(long j3, long j4) {
                                                ThrottledCallbacks throttledCallbacks;
                                                throttledCallbacks = RectManager.this.throttledCallbacks;
                                                throttledCallbacks.fireWithUpdatedRect$ui_release(entry, j3, j4, currentTimeMillis);
                                            }
                                        });
                                    } else {
                                        jArr2 = jArr4;
                                        i = i8;
                                    }
                                    entry2 = entry2.getNext();
                                    i8 = i;
                                    jArr4 = jArr2;
                                }
                            }
                            int i11 = i8;
                            j2 >>= i11;
                            i10++;
                            i8 = i11;
                            jArr4 = jArr4;
                        }
                        jArr = jArr4;
                        if (i9 != i8) {
                            break;
                        }
                    } else {
                        jArr = jArr4;
                    }
                    if (i7 == length) {
                        break;
                    }
                    i7++;
                    jArr4 = jArr;
                    i2 = 0;
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

    public final Object registerOnChangedCallback(Function0<Unit> function0) {
        this.callbacks.add(function0);
        return function0;
    }

    public final DelegatableNode.RegistrationHandle registerOnRectChangedCallback(int i, long j, long j2, DelegatableNode delegatableNode, Function1<? super RelativeLayoutBounds, Unit> function1) {
        DelegatableNode.RegistrationHandle registerOnRectChanged = this.throttledCallbacks.registerOnRectChanged(i, j, j2, delegatableNode, function1);
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
        this.isDirty = true;
        this.rects.markUpdated(layoutNode.getSemanticsId());
        scheduleDebounceCallback(true);
    }

    public final void updateFlagsFor(LayoutNode layoutNode, boolean z, boolean z2) {
        if (layoutNode.isAttached()) {
            this.rects.updateFlagsFor(layoutNode.getSemanticsId(), z, z2);
        }
    }

    public final void onLayoutLayerPositionalPropertiesChanged(LayoutNode layoutNode) {
        boolean m6500isSetgyyYBs;
        if (ComposeUiFlags.isRectTrackingEnabled) {
            long m6495outerToInnerOffsetBjo55l4 = m6495outerToInnerOffsetBjo55l4(layoutNode);
            m6500isSetgyyYBs = RectManagerKt.m6500isSetgyyYBs(m6495outerToInnerOffsetBjo55l4);
            if (m6500isSetgyyYBs) {
                layoutNode.m6173setOuterToInnerOffsetgyyYBs$ui_release(m6495outerToInnerOffsetBjo55l4);
                layoutNode.setOuterToInnerOffsetDirty$ui_release(false);
                MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
                LayoutNode[] layoutNodeArr = mutableVector.content;
                int size = mutableVector.getSize();
                for (int i = 0; i < size; i++) {
                    onLayoutPositionChanged(layoutNodeArr[i], false);
                }
                invalidateCallbacksFor(layoutNode);
                return;
            }
            insertOrUpdateTransformedNodeSubhierarchy(layoutNode);
        }
    }

    public final void onLayoutPositionChanged(LayoutNode layoutNode, boolean z) {
        boolean m6500isSetgyyYBs;
        if (ComposeUiFlags.isRectTrackingEnabled) {
            MeasurePassDelegate measurePassDelegate$ui_release = layoutNode.getMeasurePassDelegate$ui_release();
            int measuredWidth = measurePassDelegate$ui_release.getMeasuredWidth();
            int measuredHeight = measurePassDelegate$ui_release.getMeasuredHeight();
            long m6165getOffsetFromRootnOccac$ui_release = layoutNode.m6165getOffsetFromRootnOccac$ui_release();
            long m6164getLastSizeYbymL2g$ui_release = layoutNode.m6164getLastSizeYbymL2g$ui_release();
            int i = (int) (m6164getLastSizeYbymL2g$ui_release >> 32);
            int i2 = (int) (m6164getLastSizeYbymL2g$ui_release & 4294967295L);
            recalculateOffsetFromRoot(layoutNode);
            long m6165getOffsetFromRootnOccac$ui_release2 = layoutNode.m6165getOffsetFromRootnOccac$ui_release();
            m6500isSetgyyYBs = RectManagerKt.m6500isSetgyyYBs(m6165getOffsetFromRootnOccac$ui_release2);
            if (!m6500isSetgyyYBs) {
                insertOrUpdateTransformedNode(layoutNode, z);
                return;
            }
            layoutNode.m6171setLastSizeozmzZPI$ui_release(IntSize.m7430constructorimpl((measuredWidth << 32) | (4294967295L & measuredHeight)));
            int m7392getXimpl = IntOffset.m7392getXimpl(m6165getOffsetFromRootnOccac$ui_release2);
            int m7393getYimpl = IntOffset.m7393getYimpl(m6165getOffsetFromRootnOccac$ui_release2);
            int i3 = m7392getXimpl + measuredWidth;
            int i4 = m7393getYimpl + measuredHeight;
            if (!z && IntOffset.m7391equalsimpl0(m6165getOffsetFromRootnOccac$ui_release2, m6165getOffsetFromRootnOccac$ui_release) && i == measuredWidth && i2 == measuredHeight) {
                return;
            }
            insertOrUpdate(layoutNode, z, m7392getXimpl, m7393getYimpl, i3, i4);
        }
    }

    private final void recalculateOffsetFromRoot(LayoutNode layoutNode) {
        boolean m6500isSetgyyYBs;
        boolean m6500isSetgyyYBs2;
        long m6166getOuterToInnerOffsetnOccac$ui_release;
        boolean m6500isSetgyyYBs3;
        long mo6187getPositionnOccac = layoutNode.getOuterCoordinator$ui_release().mo6187getPositionnOccac();
        LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
        if (parent$ui_release != null) {
            m6500isSetgyyYBs = RectManagerKt.m6500isSetgyyYBs(parent$ui_release.m6165getOffsetFromRootnOccac$ui_release());
            if (!m6500isSetgyyYBs) {
                recalculateOffsetFromRoot(parent$ui_release);
            }
            long m6165getOffsetFromRootnOccac$ui_release = parent$ui_release.m6165getOffsetFromRootnOccac$ui_release();
            m6500isSetgyyYBs2 = RectManagerKt.m6500isSetgyyYBs(m6165getOffsetFromRootnOccac$ui_release);
            if (!m6500isSetgyyYBs2) {
                mo6187getPositionnOccac = IntOffset.Companion.m7402getMaxnOccac();
            } else {
                if (parent$ui_release.getOuterToInnerOffsetDirty$ui_release()) {
                    m6166getOuterToInnerOffsetnOccac$ui_release = m6495outerToInnerOffsetBjo55l4(parent$ui_release);
                    parent$ui_release.m6173setOuterToInnerOffsetgyyYBs$ui_release(m6166getOuterToInnerOffsetnOccac$ui_release);
                    parent$ui_release.setOuterToInnerOffsetDirty$ui_release(false);
                } else {
                    m6166getOuterToInnerOffsetnOccac$ui_release = parent$ui_release.m6166getOuterToInnerOffsetnOccac$ui_release();
                }
                m6500isSetgyyYBs3 = RectManagerKt.m6500isSetgyyYBs(m6166getOuterToInnerOffsetnOccac$ui_release);
                if (!m6500isSetgyyYBs3) {
                    mo6187getPositionnOccac = IntOffset.Companion.m7402getMaxnOccac();
                } else {
                    mo6187getPositionnOccac = IntOffset.m7396plusqkQi6aY(IntOffset.m7396plusqkQi6aY(m6165getOffsetFromRootnOccac$ui_release, m6166getOuterToInnerOffsetnOccac$ui_release), mo6187getPositionnOccac);
                }
            }
        }
        layoutNode.m6172setOffsetFromRootgyyYBs$ui_release(mo6187getPositionnOccac);
    }

    private final void insertOrUpdateTransformedNode(LayoutNode layoutNode, boolean z) {
        NodeCoordinator outerCoordinator$ui_release = layoutNode.getOuterCoordinator$ui_release();
        MeasurePassDelegate measurePassDelegate$ui_release = layoutNode.getMeasurePassDelegate$ui_release();
        int measuredWidth = measurePassDelegate$ui_release.getMeasuredWidth();
        int measuredHeight = measurePassDelegate$ui_release.getMeasuredHeight();
        MutableRect mutableRect = this.cachedRect;
        mutableRect.set(0.0f, 0.0f, measuredWidth, measuredHeight);
        boundingRectInRoot(outerCoordinator$ui_release, mutableRect);
        int left = (int) mutableRect.getLeft();
        int top = (int) mutableRect.getTop();
        int right = (int) mutableRect.getRight();
        int bottom = (int) mutableRect.getBottom();
        int semanticsId = layoutNode.getSemanticsId();
        if (z || !this.rects.update(semanticsId, left, top, right, bottom)) {
            LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
            this.rects.insert(semanticsId, left, top, right, bottom, parent$ui_release != null ? parent$ui_release.getSemanticsId() : -1, layoutNode.getNodes$ui_release().m6219hasH91voCI$ui_release(NodeKind.m6258constructorimpl(1024)), layoutNode.getNodes$ui_release().m6219hasH91voCI$ui_release(NodeKind.m6258constructorimpl(16)));
        }
        invalidate();
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0010, code lost:
        if (r9.rects.move(r1, r2, r3, r4, r5) == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void insertOrUpdate(LayoutNode layoutNode, boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int semanticsId = layoutNode.getSemanticsId();
        if (z) {
            i5 = i;
            i6 = i2;
            i7 = i3;
            i8 = i4;
        } else {
            i5 = i;
            i6 = i2;
            i7 = i3;
            i8 = i4;
        }
        LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
        this.rects.insert(semanticsId, i5, i6, i7, i8, parent$ui_release != null ? parent$ui_release.getSemanticsId() : -1, layoutNode.getNodes$ui_release().m6219hasH91voCI$ui_release(NodeKind.m6258constructorimpl(1024)), layoutNode.getNodes$ui_release().m6219hasH91voCI$ui_release(NodeKind.m6258constructorimpl(16)));
        invalidate();
    }

    private final void boundingRectInRoot(NodeCoordinator nodeCoordinator, MutableRect mutableRect) {
        while (nodeCoordinator != null) {
            OwnedLayer layer = nodeCoordinator.getLayer();
            long mo6187getPositionnOccac = nodeCoordinator.mo6187getPositionnOccac();
            mutableRect.m4290translatek4lQ0M(Offset.m4297constructorimpl((Float.floatToRawIntBits(IntOffset.m7392getXimpl(mo6187getPositionnOccac)) << 32) | (Float.floatToRawIntBits(IntOffset.m7393getYimpl(mo6187getPositionnOccac)) & 4294967295L)));
            nodeCoordinator = nodeCoordinator.getWrappedBy$ui_release();
            if (layer != null) {
                float[] mo6311getUnderlyingMatrixsQKQjiQ = layer.mo6311getUnderlyingMatrixsQKQjiQ();
                if (!MatrixKt.m4816isIdentity58bKbWc(mo6311getUnderlyingMatrixsQKQjiQ)) {
                    Matrix.m4799mapimpl(mo6311getUnderlyingMatrixsQKQjiQ, mutableRect);
                }
            }
        }
    }

    /* renamed from: outerToInnerOffset-Bjo55l4  reason: not valid java name */
    private final long m6495outerToInnerOffsetBjo55l4(LayoutNode layoutNode) {
        int m6499analyzeComponents58bKbWc;
        NodeCoordinator outerCoordinator$ui_release = layoutNode.getOuterCoordinator$ui_release();
        long m4321getZeroF1C5BW0 = Offset.Companion.m4321getZeroF1C5BW0();
        NodeCoordinator innerCoordinator$ui_release = layoutNode.getInnerCoordinator$ui_release();
        while (innerCoordinator$ui_release != null && innerCoordinator$ui_release != outerCoordinator$ui_release) {
            OwnedLayer layer = innerCoordinator$ui_release.getLayer();
            m4321getZeroF1C5BW0 = IntOffsetKt.m7407plusNvtHpc(m4321getZeroF1C5BW0, innerCoordinator$ui_release.mo6187getPositionnOccac());
            innerCoordinator$ui_release = innerCoordinator$ui_release.getWrappedBy$ui_release();
            if (layer != null) {
                float[] mo6311getUnderlyingMatrixsQKQjiQ = layer.mo6311getUnderlyingMatrixsQKQjiQ();
                m6499analyzeComponents58bKbWc = RectManagerKt.m6499analyzeComponents58bKbWc(mo6311getUnderlyingMatrixsQKQjiQ);
                if (m6499analyzeComponents58bKbWc == 3) {
                    continue;
                } else if ((m6499analyzeComponents58bKbWc & 2) == 0) {
                    return IntOffset.Companion.m7402getMaxnOccac();
                } else {
                    m4321getZeroF1C5BW0 = Matrix.m4797mapMKHz9U(mo6311getUnderlyingMatrixsQKQjiQ, m4321getZeroF1C5BW0);
                }
            }
        }
        return IntOffsetKt.m7409roundk4lQ0M(m4321getZeroF1C5BW0);
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
            insertOrUpdateTransformedNode(layoutNode2, false);
            insertOrUpdateTransformedNodeSubhierarchy(layoutNode2);
        }
    }
}
