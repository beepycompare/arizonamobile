package androidx.compose.ui.spatial;

import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ThrottledCallbacks.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0000\u0018\u00002\u00020\u0001:\u0001RB\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\"\u001a\u00020#2\n\u0010$\u001a\u00060\u0004R\u00020\u0000H\u0002JH\u0010%\u001a\u00020\n2\n\u0010$\u001a\u00060\u0004R\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\b(\u0010)J@\u0010*\u001a\u00020#2\n\u0010$\u001a\u00060\u0004R\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010&\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u000e\u0010-\u001a\u00020#2\u0006\u0010&\u001a\u00020\nJ\u000e\u0010.\u001a\u00020#2\u0006\u0010&\u001a\u00020\nJ&\u0010/\u001a\u00020#2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020\n2\u0006\u0010&\u001a\u00020\nJ,\u00104\u001a\u00020#2\n\u0010$\u001a\u00060\u0004R\u00020\u00002\u0006\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020\n2\u0006\u0010&\u001a\u00020\nH\u0002J:\u00105\u001a\u0002062\u0006\u00100\u001a\u0002012\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020:2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020#0<J:\u0010>\u001a\u0002062\u0006\u00100\u001a\u0002012\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020:2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020#0<J\u0014\u0010?\u001a\u00020@2\n\u0010$\u001a\u00060\u0004R\u00020\u0000H\u0002J\u0010\u0010A\u001a\u00020\n2\u0006\u0010B\u001a\u00020\nH\u0002J\u000e\u0010C\u001a\u00020#2\u0006\u0010&\u001a\u00020\nJ*\u0010D\u001a\u00020@2\u0006\u0010E\u001a\u00020\u00142\u0006\u0010F\u001a\u00020\u00142\b\u0010G\u001a\u0004\u0018\u00010\u0019ø\u0001\u0000¢\u0006\u0004\bH\u0010IJ)\u0010J\u001a\u00020#*\u00060\u0004R\u00020\u00002\u0016\u0010K\u001a\u0012\u0012\b\u0012\u00060\u0004R\u00020\u0000\u0012\u0004\u0012\u00020#0<H\u0082\bJ/\u0010L\u001a\u00020#*\f\u0012\b\u0012\u00060\u0004R\u00020\u00000\u00102\u0016\u0010K\u001a\u0012\u0012\b\u0012\u00060\u0004R\u00020\u0000\u0012\u0004\u0012\u00020#0<H\u0082\bJ.\u0010M\u001a\u00060\u0004R\u00020\u0000*\f\u0012\b\u0012\u00060\u0004R\u00020\u00000\u00102\u0006\u0010N\u001a\u0002012\n\u0010O\u001a\u00060\u0004R\u00020\u0000H\u0002J*\u0010P\u001a\u00020@*\f\u0012\b\u0012\u00060\u0004R\u00020\u00000\u00102\u0006\u0010N\u001a\u0002012\n\u0010O\u001a\u00060\u0004R\u00020\u0000H\u0002J7\u0010Q\u001a\u00020#*\f\u0012\b\u0012\u00060\u0004R\u00020\u00000\u00102\u0006\u00100\u001a\u0002012\u0016\u0010K\u001a\u0012\u0012\b\u0012\u00060\u0004R\u00020\u0000\u0012\u0004\u0012\u00020#0<H\u0082\bR \u0010\u0003\u001a\b\u0018\u00010\u0004R\u00020\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\f\u0012\b\u0012\u00060\u0004R\u00020\u00000\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u0014X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR$\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u0014X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\u000e\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006S"}, d2 = {"Landroidx/compose/ui/spatial/ThrottledCallbacks;", "", "()V", "globalChangeEntries", "Landroidx/compose/ui/spatial/ThrottledCallbacks$Entry;", "getGlobalChangeEntries", "()Landroidx/compose/ui/spatial/ThrottledCallbacks$Entry;", "setGlobalChangeEntries", "(Landroidx/compose/ui/spatial/ThrottledCallbacks$Entry;)V", "minDebounceDeadline", "", "getMinDebounceDeadline", "()J", "setMinDebounceDeadline", "(J)V", "rectChangedMap", "Landroidx/collection/MutableIntObjectMap;", "getRectChangedMap", "()Landroidx/collection/MutableIntObjectMap;", "screenOffset", "Landroidx/compose/ui/unit/IntOffset;", "getScreenOffset-nOcc-ac", "setScreenOffset--gyyYBs", "J", "viewToWindowMatrix", "Landroidx/compose/ui/graphics/Matrix;", "getViewToWindowMatrix-3i98HWw", "()[F", "setViewToWindowMatrix-Q8lPUPs", "([F)V", "[F", "windowOffset", "getWindowOffset-nOcc-ac", "setWindowOffset--gyyYBs", "addToGlobalEntries", "", "entry", "debounceEntry", "currentMillis", "minDeadline", "debounceEntry-b8qMvQI", "(Landroidx/compose/ui/spatial/ThrottledCallbacks$Entry;JJ[FJJ)J", "fire", "fire-WY9HvpM", "(Landroidx/compose/ui/spatial/ThrottledCallbacks$Entry;JJ[FJ)V", "fireGlobalChangeEntries", "fireOnRectChangedEntries", "fireOnUpdatedRect", "id", "", "topLeft", "bottomRight", "fireWithUpdatedRect", "registerOnGlobalChange", "Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "throttleMillis", "debounceMillis", "node", "Landroidx/compose/ui/node/DelegatableNode;", "callback", "Lkotlin/Function1;", "Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "registerOnRectChanged", "removeFromGlobalEntries", "", "roundDownToMultipleOf8", "x", "triggerDebounced", "updateOffsets", "screen", "window", "matrix", "updateOffsets-bT0EZQs", "(JJ[F)Z", "linkedForEach", "block", "multiForEach", "multiPut", "key", "value", "multiRemove", "runFor", "Entry", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ThrottledCallbacks {
    public static final int $stable = 8;
    private Entry globalChangeEntries;
    private float[] viewToWindowMatrix;
    private final MutableIntObjectMap<Entry> rectChangedMap = IntObjectMapKt.mutableIntObjectMapOf();
    private long minDebounceDeadline = -1;
    private long windowOffset = IntOffset.Companion.m6823getZeronOccac();
    private long screenOffset = IntOffset.Companion.m6823getZeronOccac();

    private final long roundDownToMultipleOf8(long j) {
        return (j >> 3) << 3;
    }

    /* compiled from: ThrottledCallbacks.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\u0010\rJ:\u0010*\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,2\b\u0010.\u001a\u0004\u0018\u00010/ø\u0001\u0000¢\u0006\u0004\b0\u00101J\b\u00102\u001a\u00020\fH\u0016R\u001a\u0010\u000e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\u001a\u0010\u001b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0012R \u0010\u001e\u001a\b\u0018\u00010\u0000R\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0010R\u001a\u0010'\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0010\"\u0004\b)\u0010\u0012\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00063"}, d2 = {"Landroidx/compose/ui/spatial/ThrottledCallbacks$Entry;", "Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "id", "", "throttleMillis", "", "debounceMillis", "node", "Landroidx/compose/ui/node/DelegatableNode;", "callback", "Lkotlin/Function1;", "Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "", "(Landroidx/compose/ui/spatial/ThrottledCallbacks;IJJLandroidx/compose/ui/node/DelegatableNode;Lkotlin/jvm/functions/Function1;)V", "bottomRight", "getBottomRight", "()J", "setBottomRight", "(J)V", "getCallback", "()Lkotlin/jvm/functions/Function1;", "getDebounceMillis", "getId", "()I", "lastInvokeMillis", "getLastInvokeMillis", "setLastInvokeMillis", "lastUninvokedFireMillis", "getLastUninvokedFireMillis", "setLastUninvokedFireMillis", "next", "Landroidx/compose/ui/spatial/ThrottledCallbacks;", "getNext", "()Landroidx/compose/ui/spatial/ThrottledCallbacks$Entry;", "setNext", "(Landroidx/compose/ui/spatial/ThrottledCallbacks$Entry;)V", "getNode", "()Landroidx/compose/ui/node/DelegatableNode;", "getThrottleMillis", "topLeft", "getTopLeft", "setTopLeft", "fire", "windowOffset", "Landroidx/compose/ui/unit/IntOffset;", "screenOffset", "viewToWindowMatrix", "Landroidx/compose/ui/graphics/Matrix;", "fire-9b-9wPM", "(JJJJ[F)V", "unregister", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public final class Entry implements DelegatableNode.RegistrationHandle {
        private long bottomRight;
        private final Function1<RelativeLayoutBounds, Unit> callback;
        private final long debounceMillis;
        private final int id;
        private long lastInvokeMillis;
        private long lastUninvokedFireMillis = -1;
        private Entry next;
        private final DelegatableNode node;
        private final long throttleMillis;
        private long topLeft;

        /* JADX WARN: Multi-variable type inference failed */
        public Entry(int i, long j, long j2, DelegatableNode delegatableNode, Function1<? super RelativeLayoutBounds, Unit> function1) {
            this.id = i;
            this.throttleMillis = j;
            this.debounceMillis = j2;
            this.node = delegatableNode;
            this.callback = function1;
            this.lastInvokeMillis = -j;
        }

        public final int getId() {
            return this.id;
        }

        public final long getThrottleMillis() {
            return this.throttleMillis;
        }

        public final long getDebounceMillis() {
            return this.debounceMillis;
        }

        public final DelegatableNode getNode() {
            return this.node;
        }

        public final Function1<RelativeLayoutBounds, Unit> getCallback() {
            return this.callback;
        }

        public final Entry getNext() {
            return this.next;
        }

        public final void setNext(Entry entry) {
            this.next = entry;
        }

        public final long getTopLeft() {
            return this.topLeft;
        }

        public final void setTopLeft(long j) {
            this.topLeft = j;
        }

        public final long getBottomRight() {
            return this.bottomRight;
        }

        public final void setBottomRight(long j) {
            this.bottomRight = j;
        }

        public final long getLastInvokeMillis() {
            return this.lastInvokeMillis;
        }

        public final void setLastInvokeMillis(long j) {
            this.lastInvokeMillis = j;
        }

        public final long getLastUninvokedFireMillis() {
            return this.lastUninvokedFireMillis;
        }

        public final void setLastUninvokedFireMillis(long j) {
            this.lastUninvokedFireMillis = j;
        }

        @Override // androidx.compose.ui.node.DelegatableNode.RegistrationHandle
        public void unregister() {
            ThrottledCallbacks throttledCallbacks = ThrottledCallbacks.this;
            if (throttledCallbacks.multiRemove(throttledCallbacks.getRectChangedMap(), this.id, this)) {
                return;
            }
            ThrottledCallbacks.this.removeFromGlobalEntries(this);
        }

        /* renamed from: fire-9b-9wPM  reason: not valid java name */
        public final void m5953fire9b9wPM(long j, long j2, long j3, long j4, float[] fArr) {
            RelativeLayoutBounds m5954rectInfoForQMZNJw = ThrottledCallbacksKt.m5954rectInfoForQMZNJw(this.node, j, j2, j3, j4, fArr);
            if (m5954rectInfoForQMZNJw == null) {
                return;
            }
            this.callback.invoke(m5954rectInfoForQMZNJw);
        }
    }

    public final MutableIntObjectMap<Entry> getRectChangedMap() {
        return this.rectChangedMap;
    }

    public final Entry getGlobalChangeEntries() {
        return this.globalChangeEntries;
    }

    public final void setGlobalChangeEntries(Entry entry) {
        this.globalChangeEntries = entry;
    }

    public final long getMinDebounceDeadline() {
        return this.minDebounceDeadline;
    }

    public final void setMinDebounceDeadline(long j) {
        this.minDebounceDeadline = j;
    }

    /* renamed from: getWindowOffset-nOcc-ac  reason: not valid java name */
    public final long m5948getWindowOffsetnOccac() {
        return this.windowOffset;
    }

    /* renamed from: setWindowOffset--gyyYBs  reason: not valid java name */
    public final void m5951setWindowOffsetgyyYBs(long j) {
        this.windowOffset = j;
    }

    /* renamed from: getScreenOffset-nOcc-ac  reason: not valid java name */
    public final long m5946getScreenOffsetnOccac() {
        return this.screenOffset;
    }

    /* renamed from: setScreenOffset--gyyYBs  reason: not valid java name */
    public final void m5949setScreenOffsetgyyYBs(long j) {
        this.screenOffset = j;
    }

    /* renamed from: getViewToWindowMatrix-3i98HWw  reason: not valid java name */
    public final float[] m5947getViewToWindowMatrix3i98HWw() {
        return this.viewToWindowMatrix;
    }

    /* renamed from: setViewToWindowMatrix-Q8lPUPs  reason: not valid java name */
    public final void m5950setViewToWindowMatrixQ8lPUPs(float[] fArr) {
        this.viewToWindowMatrix = fArr;
    }

    /* renamed from: updateOffsets-bT0EZQs  reason: not valid java name */
    public final boolean m5952updateOffsetsbT0EZQs(long j, long j2, float[] fArr) {
        boolean z;
        if (IntOffset.m6811equalsimpl0(j2, this.windowOffset)) {
            z = false;
        } else {
            this.windowOffset = j2;
            z = true;
        }
        if (!IntOffset.m6811equalsimpl0(j, this.screenOffset)) {
            this.screenOffset = j;
            z = true;
        }
        if (fArr != null) {
            this.viewToWindowMatrix = fArr;
            return true;
        }
        return z;
    }

    public final DelegatableNode.RegistrationHandle registerOnRectChanged(int i, long j, long j2, DelegatableNode delegatableNode, Function1<? super RelativeLayoutBounds, Unit> function1) {
        return multiPut(this.rectChangedMap, i, new Entry(i, j, j2 == 0 ? j : j2, delegatableNode, function1));
    }

    public final DelegatableNode.RegistrationHandle registerOnGlobalChange(int i, long j, long j2, DelegatableNode delegatableNode, Function1<? super RelativeLayoutBounds, Unit> function1) {
        Entry entry = new Entry(i, j, j2 == 0 ? j : j2, delegatableNode, function1);
        addToGlobalEntries(entry);
        return entry;
    }

    public final void fireOnUpdatedRect(int i, long j, long j2, long j3) {
        for (Entry entry = this.rectChangedMap.get(i); entry != null; entry = entry.getNext()) {
            fireWithUpdatedRect(entry, j, j2, j3);
        }
    }

    public final void fireOnRectChangedEntries(long j) {
        ThrottledCallbacks throttledCallbacks = this;
        long j2 = throttledCallbacks.windowOffset;
        long j3 = throttledCallbacks.screenOffset;
        float[] fArr = throttledCallbacks.viewToWindowMatrix;
        MutableIntObjectMap<Entry> mutableIntObjectMap = throttledCallbacks.rectChangedMap;
        Object[] objArr = mutableIntObjectMap.values;
        long[] jArr = mutableIntObjectMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j4 = jArr[i];
            if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                long j5 = j4;
                int i3 = 0;
                while (i3 < i2) {
                    if ((j5 & 255) < 128) {
                        Entry entry = (Entry) objArr[(i << 3) + i3];
                        while (entry != null) {
                            int i4 = i3;
                            Entry entry2 = entry;
                            throttledCallbacks.m5945fireWY9HvpM(entry2, j2, j3, fArr, j);
                            entry = entry2.getNext();
                            throttledCallbacks = this;
                            i3 = i4;
                        }
                    }
                    j5 >>= 8;
                    i3++;
                    throttledCallbacks = this;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            }
            i++;
            throttledCallbacks = this;
        }
    }

    public final void fireGlobalChangeEntries(long j) {
        long j2 = this.windowOffset;
        long j3 = this.screenOffset;
        float[] fArr = this.viewToWindowMatrix;
        Entry entry = this.globalChangeEntries;
        if (entry != null) {
            for (Entry entry2 = entry; entry2 != null; entry2 = entry2.getNext()) {
                LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(entry2.getNode());
                long m5613getOffsetFromRootnOccac$ui_release = requireLayoutNode.m5613getOffsetFromRootnOccac$ui_release();
                long m5612getLastSizeYbymL2g$ui_release = requireLayoutNode.m5612getLastSizeYbymL2g$ui_release();
                entry2.setTopLeft(m5613getOffsetFromRootnOccac$ui_release);
                entry2.setBottomRight(((IntOffset.m6812getXimpl(m5613getOffsetFromRootnOccac$ui_release) + ((int) (m5612getLastSizeYbymL2g$ui_release >> 32))) << 32) | ((IntOffset.m6813getYimpl(m5613getOffsetFromRootnOccac$ui_release) + ((int) (m5612getLastSizeYbymL2g$ui_release & 4294967295L))) & 4294967295L));
                m5945fireWY9HvpM(entry2, j2, j3, fArr, j);
            }
        }
    }

    public final void triggerDebounced(long j) {
        long j2;
        long j3;
        int i;
        if (this.minDebounceDeadline > j) {
            return;
        }
        long j4 = this.windowOffset;
        long j5 = this.screenOffset;
        float[] fArr = this.viewToWindowMatrix;
        MutableIntObjectMap<Entry> mutableIntObjectMap = this.rectChangedMap;
        Object[] objArr = mutableIntObjectMap.values;
        long[] jArr = mutableIntObjectMap.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            j3 = Long.MAX_VALUE;
            while (true) {
                long j6 = jArr[i2];
                j2 = Long.MAX_VALUE;
                if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8 - ((~(i2 - length)) >>> 31);
                    long j7 = j6;
                    int i4 = 0;
                    while (i4 < i3) {
                        if ((j7 & 255) < 128) {
                            Entry entry = (Entry) objArr[(i2 << 3) + i4];
                            while (entry != null) {
                                int i5 = i2;
                                Entry entry2 = entry;
                                j3 = m5944debounceEntryb8qMvQI(entry2, j4, j5, fArr, j, j3);
                                i4 = i4;
                                entry = entry2.getNext();
                                i2 = i5;
                            }
                            i = i4;
                        } else {
                            i = i4;
                        }
                        j7 >>= 8;
                        i4 = i + 1;
                        i2 = i2;
                    }
                    int i6 = i2;
                    if (i3 != 8) {
                        break;
                    }
                    i2 = i6;
                }
                if (i2 == length) {
                    break;
                }
                i2++;
            }
        } else {
            j2 = Long.MAX_VALUE;
            j3 = Long.MAX_VALUE;
        }
        Entry entry3 = this.globalChangeEntries;
        if (entry3 != null) {
            long j8 = j3;
            while (entry3 != null) {
                j8 = m5944debounceEntryb8qMvQI(entry3, j4, j5, fArr, j, j8);
                entry3 = entry3.getNext();
            }
            j3 = j8;
        }
        if (j3 == j2) {
            j3 = -1;
        }
        this.minDebounceDeadline = j3;
    }

    private final void fireWithUpdatedRect(Entry entry, long j, long j2, long j3) {
        long lastInvokeMillis = entry.getLastInvokeMillis();
        long throttleMillis = entry.getThrottleMillis();
        long debounceMillis = entry.getDebounceMillis();
        boolean z = true;
        boolean z2 = j3 - lastInvokeMillis >= throttleMillis;
        boolean z3 = debounceMillis == 0;
        boolean z4 = throttleMillis == 0;
        entry.setTopLeft(j);
        entry.setBottomRight(j2);
        if ((z3 || z4) && !z3) {
            z = false;
        }
        if (z2 && z) {
            entry.setLastUninvokedFireMillis(-1L);
            entry.setLastInvokeMillis(j3);
            entry.m5953fire9b9wPM(j, j2, this.windowOffset, this.screenOffset, this.viewToWindowMatrix);
        } else if (z3) {
        } else {
            entry.setLastUninvokedFireMillis(j3);
            long j4 = this.minDebounceDeadline;
            long j5 = j3 + debounceMillis;
            if (j4 <= 0 || j5 >= j4) {
                return;
            }
            this.minDebounceDeadline = j4;
        }
    }

    /* renamed from: fire-WY9HvpM  reason: not valid java name */
    private final void m5945fireWY9HvpM(Entry entry, long j, long j2, float[] fArr, long j3) {
        boolean z = j3 - entry.getLastInvokeMillis() > entry.getThrottleMillis();
        boolean z2 = entry.getDebounceMillis() == 0;
        entry.setLastUninvokedFireMillis(j3);
        if (z && z2) {
            entry.setLastInvokeMillis(j3);
            entry.m5953fire9b9wPM(entry.getTopLeft(), entry.getBottomRight(), j, j2, fArr);
        }
        if (z2) {
            return;
        }
        long j4 = this.minDebounceDeadline;
        long debounceMillis = entry.getDebounceMillis() + j3;
        if (j4 <= 0 || debounceMillis >= j4) {
            return;
        }
        this.minDebounceDeadline = j4;
    }

    /* renamed from: debounceEntry-b8qMvQI  reason: not valid java name */
    private final long m5944debounceEntryb8qMvQI(Entry entry, long j, long j2, float[] fArr, long j3, long j4) {
        if (entry.getDebounceMillis() <= 0 || entry.getLastUninvokedFireMillis() <= 0) {
            return j4;
        }
        if (j3 - entry.getLastUninvokedFireMillis() > entry.getDebounceMillis()) {
            entry.setLastInvokeMillis(j3);
            entry.setLastUninvokedFireMillis(-1L);
            entry.m5953fire9b9wPM(entry.getTopLeft(), entry.getBottomRight(), j, j2, fArr);
            return j4;
        }
        return Math.min(j4, entry.getLastUninvokedFireMillis() + entry.getDebounceMillis());
    }

    private final void addToGlobalEntries(Entry entry) {
        entry.setNext(this.globalChangeEntries);
        this.globalChangeEntries = entry;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean removeFromGlobalEntries(Entry entry) {
        Entry entry2 = this.globalChangeEntries;
        if (entry2 == entry) {
            this.globalChangeEntries = entry2.getNext();
            entry.setNext(null);
            return true;
        }
        Entry next = entry2 != null ? entry2.getNext() : null;
        while (true) {
            Entry entry3 = next;
            Entry entry4 = entry2;
            entry2 = entry3;
            if (entry2 == null) {
                return false;
            }
            if (entry2 == entry) {
                if (entry4 != null) {
                    entry4.setNext(entry2.getNext());
                }
                entry.setNext(null);
                return true;
            }
            next = entry2.getNext();
        }
    }

    private final void linkedForEach(Entry entry, Function1<? super Entry, Unit> function1) {
        while (entry != null) {
            function1.invoke(entry);
            entry = entry.getNext();
        }
    }

    private final void multiForEach(MutableIntObjectMap<Entry> mutableIntObjectMap, Function1<? super Entry, Unit> function1) {
        MutableIntObjectMap<Entry> mutableIntObjectMap2 = mutableIntObjectMap;
        Object[] objArr = mutableIntObjectMap2.values;
        long[] jArr = mutableIntObjectMap2.metadata;
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
                        for (Entry entry = (Entry) objArr[(i << 3) + i3]; entry != null; entry = entry.getNext()) {
                            function1.invoke(entry);
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

    private final void runFor(MutableIntObjectMap<Entry> mutableIntObjectMap, int i, Function1<? super Entry, Unit> function1) {
        for (Entry entry = mutableIntObjectMap.get(i); entry != null; entry = entry.getNext()) {
            function1.invoke(entry);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean multiRemove(MutableIntObjectMap<Entry> mutableIntObjectMap, int i, Entry entry) {
        Entry remove = mutableIntObjectMap.remove(i);
        if (remove == null) {
            return false;
        }
        if (Intrinsics.areEqual(remove, entry)) {
            Entry next = entry.getNext();
            entry.setNext(null);
            if (next != null) {
                mutableIntObjectMap.put(i, next);
            }
            return true;
        }
        mutableIntObjectMap.put(i, remove);
        while (true) {
            if (remove == null) {
                break;
            }
            Entry next2 = remove.getNext();
            if (next2 == null) {
                return false;
            }
            if (next2 == entry) {
                remove.setNext(entry.getNext());
                entry.setNext(null);
                break;
            }
            remove = remove.getNext();
        }
        return true;
    }

    private final Entry multiPut(MutableIntObjectMap<Entry> mutableIntObjectMap, int i, Entry entry) {
        Entry entry2 = mutableIntObjectMap.get(i);
        if (entry2 == null) {
            mutableIntObjectMap.set(i, entry);
            entry2 = entry;
        }
        Entry entry3 = entry2;
        if (entry3 != entry) {
            while (entry3.getNext() != null) {
                entry3 = entry3.getNext();
                Intrinsics.checkNotNull(entry3);
            }
            entry3.setNext(entry);
        }
        return entry;
    }
}
