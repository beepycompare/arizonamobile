package androidx.compose.ui.input.pointer;

import android.os.Build;
import android.util.SparseBooleanArray;
import android.util.SparseLongArray;
import android.view.MotionEvent;
import androidx.collection.LongSparseArray;
import androidx.collection.SieveCacheKt;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.indirect.AndroidIndirectPointerEvent;
import androidx.compose.ui.input.indirect.AndroidIndirectPointerEvent_androidKt;
import androidx.compose.ui.input.indirect.IndirectPointerEventPrimaryDirectionalMotionAxis;
import androidx.compose.ui.input.indirect.IndirectPointerInputChange;
import androidx.core.view.InputDeviceCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: MotionEventAdapter.android.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0001\u0018\u00002\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u001f\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0000¢\u0006\u0002\b#J#\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'H\u0000¢\u0006\u0002\b(J\u000e\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u0014J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010,\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0014\u0010-\u001a\u00020\u0017*\u00020 2\u0006\u0010*\u001a\u00020\u0014H\u0002J\u0017\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0014H\u0002¢\u0006\u0004\b1\u00102J\u0010\u00103\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0002J7\u00104\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020 2\b\u00105\u001a\u0004\u0018\u00010\u001a2\u0006\u00106\u001a\u00020\u00142\u0006\u00107\u001a\u00020\u0017H\u0002¢\u0006\u0002\b8R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Landroidx/compose/ui/input/pointer/MotionEventAdapter;", "", "<init>", "()V", "nextId", "", "motionEventToComposePointerIdMap", "Landroid/util/SparseLongArray;", "getMotionEventToComposePointerIdMap$ui$annotations", "getMotionEventToComposePointerIdMap$ui", "()Landroid/util/SparseLongArray;", "activeHoverIds", "Landroid/util/SparseBooleanArray;", "pointers", "", "Landroidx/compose/ui/input/pointer/PointerInputEventData;", "previousIndirectPointerEventData", "Landroidx/collection/LongSparseArray;", "Landroidx/compose/ui/input/pointer/MotionEventAdapter$IndirectPointerEventData;", "previousToolType", "", "previousSource", "isInFakeFingerGesture", "", "isReinterpretingFakeFingerGesture", "inferredCursorRawOffset", "Landroidx/compose/ui/geometry/Offset;", "resetFakeFingerGesture", "", "convertToPointerInputEvent", "Landroidx/compose/ui/input/pointer/PointerInputEvent;", "motionEvent", "Landroid/view/MotionEvent;", "positionCalculator", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "convertToPointerInputEvent$ui", "convertToIndirectPointerEvent", "Landroidx/compose/ui/input/indirect/AndroidIndirectPointerEvent;", "primaryDirectionalMotionAxisOverride", "Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;", "convertToIndirectPointerEvent-k92h6UU$ui", "endStream", "pointerId", "addFreshIds", "removeStaleIds", "hasPointerId", "getComposePointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "motionEventPointerId", "getComposePointerId-_I2yYro", "(I)J", "clearOnDeviceChange", "createPointerInputEventData", "rawPositionOverride", FirebaseAnalytics.Param.INDEX, "pressed", "createPointerInputEventData-InuC1xA", "IndirectPointerEventData", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MotionEventAdapter {
    public static final int $stable = 8;
    private Offset inferredCursorRawOffset;
    private boolean isInFakeFingerGesture;
    private boolean isReinterpretingFakeFingerGesture;
    private long nextId;
    private final SparseLongArray motionEventToComposePointerIdMap = new SparseLongArray();
    private final SparseBooleanArray activeHoverIds = new SparseBooleanArray();
    private final List<PointerInputEventData> pointers = new ArrayList();
    private final LongSparseArray<IndirectPointerEventData> previousIndirectPointerEventData = new LongSparseArray<>(0, 1, null);
    private int previousToolType = -1;
    private int previousSource = -1;

    public static /* synthetic */ void getMotionEventToComposePointerIdMap$ui$annotations() {
    }

    public final SparseLongArray getMotionEventToComposePointerIdMap$ui() {
        return this.motionEventToComposePointerIdMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MotionEventAdapter.android.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0083@\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B!\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001b\u0010\u0012\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004¢\u0006\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0005R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005\u0088\u0001\u0002¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/input/pointer/MotionEventAdapter$IndirectPointerEventData;", "", "packedValue", "", "constructor-impl", "(J)J", "uptime", "position", "Landroidx/compose/ui/geometry/Offset;", "down", "", "(JJZ)J", "getPackedValue", "()J", "getDown-impl", "(J)Z", "getUptime-impl", "getPosition-F1C5BW0", "equals", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @JvmInline
    /* loaded from: classes2.dex */
    public static final class IndirectPointerEventData {
        public static final Companion Companion = new Companion(null);
        private final long packedValue;

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ IndirectPointerEventData m6596boximpl(long j) {
            return new IndirectPointerEventData(j);
        }

        /* renamed from: constructor-impl  reason: not valid java name */
        public static long m6597constructorimpl(long j) {
            return j;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m6599equalsimpl(long j, Object obj) {
            return (obj instanceof IndirectPointerEventData) && j == ((IndirectPointerEventData) obj).m6606unboximpl();
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m6600equalsimpl0(long j, long j2) {
            return j == j2;
        }

        /* renamed from: getDown-impl  reason: not valid java name */
        public static final boolean m6601getDownimpl(long j) {
            return (j & 1) != 0;
        }

        /* renamed from: getUptime-impl  reason: not valid java name */
        public static final long m6603getUptimeimpl(long j) {
            return (j >> 1) & SieveCacheKt.NodeLinkMask;
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m6604hashCodeimpl(long j) {
            return Long.hashCode(j);
        }

        /* renamed from: toString-impl  reason: not valid java name */
        public static String m6605toStringimpl(long j) {
            return "IndirectPointerEventData(packedValue=" + j + ')';
        }

        public boolean equals(Object obj) {
            return m6599equalsimpl(this.packedValue, obj);
        }

        public int hashCode() {
            return m6604hashCodeimpl(this.packedValue);
        }

        public String toString() {
            return m6605toStringimpl(this.packedValue);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ long m6606unboximpl() {
            return this.packedValue;
        }

        private /* synthetic */ IndirectPointerEventData(long j) {
            this.packedValue = j;
        }

        public final long getPackedValue() {
            return this.packedValue;
        }

        /* renamed from: constructor-impl  reason: not valid java name */
        public static long m6598constructorimpl(long j, long j2, boolean z) {
            return m6597constructorimpl(((j & SieveCacheKt.NodeLinkMask) << 1) | (z ? 1L : 0L) | (Companion.packShorts((short) Float.intBitsToFloat((int) (j2 >> 32)), (short) Float.intBitsToFloat((int) (j2 & 4294967295L))) << 32));
        }

        /* renamed from: getPosition-F1C5BW0  reason: not valid java name */
        public static final long m6602getPositionF1C5BW0(long j) {
            int i = (int) (j >>> 32);
            Companion companion = Companion;
            return Offset.m5095constructorimpl((Float.floatToRawIntBits(companion.unpackShort2(i)) & 4294967295L) | (Float.floatToRawIntBits(companion.unpackShort1(i)) << 32));
        }

        /* compiled from: MotionEventAdapter.android.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\n\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0002¨\u0006\f"}, d2 = {"Landroidx/compose/ui/input/pointer/MotionEventAdapter$IndirectPointerEventData$Companion;", "", "<init>", "()V", "packShorts", "", "val1", "", "val2", "unpackShort1", "value", "unpackShort2", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int packShorts(short s, short s2) {
                return (s << 16) | (65535 & s2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final short unpackShort1(int i) {
                return (short) (i >>> 16);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final short unpackShort2(int i) {
                return (short) (65535 & i);
            }

            private Companion() {
            }
        }
    }

    private final void resetFakeFingerGesture() {
        this.isInFakeFingerGesture = false;
        this.isReinterpretingFakeFingerGesture = false;
        this.inferredCursorRawOffset = null;
    }

    public final PointerInputEvent convertToPointerInputEvent$ui(MotionEvent motionEvent, PositionCalculator positionCalculator) {
        int i;
        MotionEventAdapter motionEventAdapter;
        MotionEvent motionEvent2;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 3 || actionMasked == 4) {
            this.motionEventToComposePointerIdMap.clear();
            this.activeHoverIds.clear();
            resetFakeFingerGesture();
            return null;
        }
        clearOnDeviceChange(motionEvent);
        addFreshIds(motionEvent);
        boolean z = actionMasked == 9 || actionMasked == 7 || actionMasked == 10;
        boolean z2 = actionMasked == 8;
        if (z) {
            this.activeHoverIds.put(motionEvent.getPointerId(motionEvent.getActionIndex()), true);
        }
        if (actionMasked != 1) {
            i = actionMasked != 6 ? -1 : motionEvent.getActionIndex();
        } else {
            i = 0;
        }
        this.pointers.clear();
        if (ComposeUiFlags.isTrackpadGestureHandlingEnabled && motionEvent.getActionMasked() == 0) {
            boolean z3 = Build.VERSION.SDK_INT >= 34 && (motionEvent.getClassification() == 3 || motionEvent.getClassification() == 5);
            boolean z4 = motionEvent.getButtonState() == 0 && (motionEvent.isFromSource(8194) || motionEvent.isFromSource(InputDeviceCompat.SOURCE_TOUCHPAD));
            if (z3 || z4) {
                this.isInFakeFingerGesture = true;
            }
        }
        if (ComposeUiFlags.isTrackpadGestureHandlingEnabled && Build.VERSION.SDK_INT >= 34 && motionEvent.getClassification() == 3) {
            this.isReinterpretingFakeFingerGesture = true;
            if (motionEvent.getActionMasked() == 0) {
                float rawX = motionEvent.getRawX(0);
                this.inferredCursorRawOffset = Offset.m5092boximpl(Offset.m5095constructorimpl((Float.floatToRawIntBits(motionEvent.getRawY(0)) & 4294967295L) | (Float.floatToRawIntBits(rawX) << 32)));
            }
            motionEvent2 = motionEvent;
            motionEventAdapter = this;
            this.pointers.add(m6593createPointerInputEventDataInuC1xA(positionCalculator, motionEvent2, this.inferredCursorRawOffset, 0, false));
        } else {
            motionEventAdapter = this;
            PositionCalculator positionCalculator2 = positionCalculator;
            motionEventAdapter.isReinterpretingFakeFingerGesture = false;
            int pointerCount = motionEvent.getPointerCount();
            int i2 = 0;
            while (i2 < pointerCount) {
                motionEventAdapter.pointers.add(motionEventAdapter.m6593createPointerInputEventDataInuC1xA(positionCalculator2, motionEvent, null, i2, (z || i2 == i || (z2 && motionEvent.getButtonState() == 0)) ? false : true));
                i2++;
                positionCalculator2 = positionCalculator2;
            }
            motionEvent2 = motionEvent;
        }
        if (motionEvent2.getActionMasked() == 1) {
            motionEventAdapter.resetFakeFingerGesture();
        }
        motionEventAdapter.removeStaleIds(motionEvent2);
        return new PointerInputEvent(motionEvent2.getEventTime(), motionEventAdapter.pointers, motionEvent2);
    }

    /* renamed from: convertToIndirectPointerEvent-k92h6UU$ui$default  reason: not valid java name */
    public static /* synthetic */ AndroidIndirectPointerEvent m6592convertToIndirectPointerEventk92h6UU$ui$default(MotionEventAdapter motionEventAdapter, MotionEvent motionEvent, IndirectPointerEventPrimaryDirectionalMotionAxis indirectPointerEventPrimaryDirectionalMotionAxis, int i, Object obj) {
        if ((i & 2) != 0) {
            indirectPointerEventPrimaryDirectionalMotionAxis = null;
        }
        return motionEventAdapter.m6595convertToIndirectPointerEventk92h6UU$ui(motionEvent, indirectPointerEventPrimaryDirectionalMotionAxis);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d2  */
    /* renamed from: convertToIndirectPointerEvent-k92h6UU$ui  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final AndroidIndirectPointerEvent m6595convertToIndirectPointerEventk92h6UU$ui(MotionEvent motionEvent, IndirectPointerEventPrimaryDirectionalMotionAxis indirectPointerEventPrimaryDirectionalMotionAxis) {
        int i;
        int indirectPrimaryDirectionalScrollAxis;
        int i2;
        MotionEventAdapter motionEventAdapter = this;
        int actionMasked = motionEvent.getActionMasked();
        clearOnDeviceChange(motionEvent);
        if (actionMasked == 3) {
            motionEventAdapter.motionEventToComposePointerIdMap.clear();
            motionEventAdapter.activeHoverIds.clear();
            return null;
        }
        addFreshIds(motionEvent);
        if (actionMasked != 1) {
            i = actionMasked != 6 ? -1 : motionEvent.getActionIndex();
        } else {
            i = 0;
        }
        boolean z = actionMasked == 0 || actionMasked == 2 || actionMasked == 5;
        int pointerCount = motionEvent.getPointerCount();
        ArrayList arrayList = new ArrayList(pointerCount);
        int i3 = 0;
        while (i3 < pointerCount) {
            long m6594getComposePointerId_I2yYro = motionEventAdapter.m6594getComposePointerId_I2yYro(motionEvent.getPointerId(i3));
            float x = motionEvent.getX(i3);
            long m5095constructorimpl = Offset.m5095constructorimpl((Float.floatToRawIntBits(motionEvent.getY(i3)) & 4294967295L) | (Float.floatToRawIntBits(x) << 32));
            boolean z2 = i3 != i;
            IndirectPointerEventData indirectPointerEventData = motionEventAdapter.previousIndirectPointerEventData.get(m6594getComposePointerId_I2yYro);
            if (i3 == i) {
                motionEventAdapter.previousIndirectPointerEventData.remove(m6594getComposePointerId_I2yYro);
            } else if (z) {
                i2 = actionMasked;
                motionEventAdapter.previousIndirectPointerEventData.put(m6594getComposePointerId_I2yYro, IndirectPointerEventData.m6596boximpl(IndirectPointerEventData.m6598constructorimpl(motionEvent.getEventTime(), m5095constructorimpl, true)));
                arrayList.add(new IndirectPointerInputChange(m6594getComposePointerId_I2yYro, motionEvent.getEventTime(), m5095constructorimpl, z2, motionEvent.getPressure(i3), indirectPointerEventData == null ? IndirectPointerEventData.m6603getUptimeimpl(indirectPointerEventData.m6606unboximpl()) : motionEvent.getEventTime(), indirectPointerEventData == null ? IndirectPointerEventData.m6602getPositionF1C5BW0(indirectPointerEventData.m6606unboximpl()) : m5095constructorimpl, indirectPointerEventData == null ? IndirectPointerEventData.m6601getDownimpl(indirectPointerEventData.m6606unboximpl()) : false, null));
                i3++;
                motionEventAdapter = this;
                actionMasked = i2;
            }
            i2 = actionMasked;
            arrayList.add(new IndirectPointerInputChange(m6594getComposePointerId_I2yYro, motionEvent.getEventTime(), m5095constructorimpl, z2, motionEvent.getPressure(i3), indirectPointerEventData == null ? IndirectPointerEventData.m6603getUptimeimpl(indirectPointerEventData.m6606unboximpl()) : motionEvent.getEventTime(), indirectPointerEventData == null ? IndirectPointerEventData.m6602getPositionF1C5BW0(indirectPointerEventData.m6606unboximpl()) : m5095constructorimpl, indirectPointerEventData == null ? IndirectPointerEventData.m6601getDownimpl(indirectPointerEventData.m6606unboximpl()) : false, null));
            i3++;
            motionEventAdapter = this;
            actionMasked = i2;
        }
        int i4 = actionMasked;
        ArrayList arrayList2 = arrayList;
        removeStaleIds(motionEvent);
        if (indirectPointerEventPrimaryDirectionalMotionAxis != null) {
            indirectPrimaryDirectionalScrollAxis = indirectPointerEventPrimaryDirectionalMotionAxis.m6174unboximpl();
        } else {
            indirectPrimaryDirectionalScrollAxis = AndroidIndirectPointerEvent_androidKt.indirectPrimaryDirectionalScrollAxis(motionEvent);
        }
        return new AndroidIndirectPointerEvent(arrayList2, AndroidIndirectPointerEvent_androidKt.convertActionToIndirectPointerEventType(i4), indirectPrimaryDirectionalScrollAxis, motionEvent, null);
    }

    public final void endStream(int i) {
        this.activeHoverIds.delete(i);
        this.motionEventToComposePointerIdMap.delete(i);
    }

    private final void addFreshIds(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0 && actionMasked != 5) {
            if (actionMasked != 9) {
                return;
            }
            int pointerId = motionEvent.getPointerId(0);
            if (this.motionEventToComposePointerIdMap.indexOfKey(pointerId) < 0) {
                SparseLongArray sparseLongArray = this.motionEventToComposePointerIdMap;
                long j = this.nextId;
                this.nextId = 1 + j;
                sparseLongArray.put(pointerId, j);
                return;
            }
            return;
        }
        int actionIndex = motionEvent.getActionIndex();
        int pointerId2 = motionEvent.getPointerId(actionIndex);
        if (this.motionEventToComposePointerIdMap.indexOfKey(pointerId2) < 0) {
            SparseLongArray sparseLongArray2 = this.motionEventToComposePointerIdMap;
            long j2 = this.nextId;
            this.nextId = 1 + j2;
            sparseLongArray2.put(pointerId2, j2);
            if (motionEvent.getToolType(actionIndex) == 3) {
                this.activeHoverIds.put(pointerId2, true);
            }
        }
    }

    private final void removeStaleIds(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 6) {
            int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
            if (!this.activeHoverIds.get(pointerId, false)) {
                this.motionEventToComposePointerIdMap.delete(pointerId);
                this.activeHoverIds.delete(pointerId);
            }
        }
        if (this.motionEventToComposePointerIdMap.size() > motionEvent.getPointerCount()) {
            for (int size = this.motionEventToComposePointerIdMap.size() - 1; -1 < size; size--) {
                int keyAt = this.motionEventToComposePointerIdMap.keyAt(size);
                if (!hasPointerId(motionEvent, keyAt)) {
                    this.motionEventToComposePointerIdMap.removeAt(size);
                    this.activeHoverIds.delete(keyAt);
                }
            }
        }
    }

    private final boolean hasPointerId(MotionEvent motionEvent, int i) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            if (motionEvent.getPointerId(i2) == i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: getComposePointerId-_I2yYro  reason: not valid java name */
    private final long m6594getComposePointerId_I2yYro(int i) {
        long j;
        int indexOfKey = this.motionEventToComposePointerIdMap.indexOfKey(i);
        if (indexOfKey >= 0) {
            j = this.motionEventToComposePointerIdMap.valueAt(indexOfKey);
        } else {
            long j2 = this.nextId;
            this.nextId = 1 + j2;
            this.motionEventToComposePointerIdMap.put(i, j2);
            j = j2;
        }
        return PointerId.m6662constructorimpl(j);
    }

    private final void clearOnDeviceChange(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() != 1) {
            return;
        }
        int toolType = motionEvent.getToolType(0);
        int source = motionEvent.getSource();
        if (toolType == this.previousToolType && source == this.previousSource) {
            return;
        }
        this.previousToolType = toolType;
        this.previousSource = source;
        this.activeHoverIds.clear();
        this.motionEventToComposePointerIdMap.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01b2 A[EDGE_INSN: B:89:0x01b2->B:64:0x01b2 ?: BREAK  , SYNTHETIC] */
    /* renamed from: createPointerInputEventData-InuC1xA  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final PointerInputEventData m6593createPointerInputEventDataInuC1xA(PositionCalculator positionCalculator, MotionEvent motionEvent, Offset offset, int i, boolean z) {
        char c;
        long j;
        long mo6767localToScreenMKHz9U;
        long j2;
        long mo6768screenToLocalMKHz9U;
        int toolType;
        char c2;
        int m6766getUnknownT8wyACA;
        int historySize;
        int i2;
        float f;
        long m5119getZeroF1C5BW0;
        long j3;
        long m5119getZeroF1C5BW02;
        Float f2;
        long m5119getZeroF1C5BW03;
        long m6594getComposePointerId_I2yYro = m6594getComposePointerId_I2yYro(motionEvent.getPointerId(i));
        float pressure = motionEvent.getPressure(i);
        long m5095constructorimpl = Offset.m5095constructorimpl((Float.floatToRawIntBits(motionEvent.getY(i)) & 4294967295L) | (Float.floatToRawIntBits(motionEvent.getX(i)) << 32));
        if (i == 0) {
            if (offset != null) {
                c = ' ';
                mo6767localToScreenMKHz9U = offset.m5113unboximpl();
                j = 4294967295L;
            } else {
                c = ' ';
                j = 4294967295L;
                mo6767localToScreenMKHz9U = Offset.m5095constructorimpl((Float.floatToRawIntBits(motionEvent.getRawX()) << 32) | (Float.floatToRawIntBits(motionEvent.getRawY()) & 4294967295L));
            }
            mo6768screenToLocalMKHz9U = positionCalculator.mo6768screenToLocalMKHz9U(mo6767localToScreenMKHz9U);
        } else {
            c = ' ';
            j = 4294967295L;
            if (Build.VERSION.SDK_INT >= 29) {
                mo6767localToScreenMKHz9U = offset != null ? offset.m5113unboximpl() : MotionEventHelper.INSTANCE.m6607toRawOffsetdBAh8RU(motionEvent, i);
                mo6768screenToLocalMKHz9U = positionCalculator.mo6768screenToLocalMKHz9U(mo6767localToScreenMKHz9U);
            } else {
                mo6767localToScreenMKHz9U = positionCalculator.mo6767localToScreenMKHz9U(m5095constructorimpl);
                j2 = m5095constructorimpl;
                long j4 = mo6767localToScreenMKHz9U;
                toolType = motionEvent.getToolType(i);
                if (toolType == 0) {
                    c2 = c;
                    if (toolType != 1) {
                        if (toolType == 2) {
                            m6766getUnknownT8wyACA = PointerType.Companion.m6764getStylusT8wyACA();
                        } else if (toolType == 3) {
                            m6766getUnknownT8wyACA = PointerType.Companion.m6763getMouseT8wyACA();
                        } else if (toolType == 4) {
                            m6766getUnknownT8wyACA = PointerType.Companion.m6762getEraserT8wyACA();
                        } else {
                            m6766getUnknownT8wyACA = PointerType.Companion.m6766getUnknownT8wyACA();
                        }
                    } else if (ComposeUiFlags.isTrackpadGestureHandlingEnabled) {
                        if ((motionEvent.isFromSource(8194) || motionEvent.isFromSource(InputDeviceCompat.SOURCE_TOUCHPAD)) && (!this.isInFakeFingerGesture || this.isReinterpretingFakeFingerGesture)) {
                            m6766getUnknownT8wyACA = PointerType.Companion.m6763getMouseT8wyACA();
                        } else {
                            m6766getUnknownT8wyACA = PointerType.Companion.m6765getTouchT8wyACA();
                        }
                    } else {
                        m6766getUnknownT8wyACA = PointerType.Companion.m6765getTouchT8wyACA();
                    }
                } else {
                    c2 = c;
                    m6766getUnknownT8wyACA = PointerType.Companion.m6766getUnknownT8wyACA();
                }
                ArrayList arrayList = new ArrayList(motionEvent.getHistorySize());
                historySize = motionEvent.getHistorySize();
                int i3 = m6766getUnknownT8wyACA;
                i2 = 0;
                while (true) {
                    if (i2 < historySize) {
                        break;
                    }
                    float historicalX = motionEvent.getHistoricalX(i, i2);
                    float historicalY = motionEvent.getHistoricalY(i, i2);
                    long j5 = m5095constructorimpl;
                    if ((Float.floatToRawIntBits(historicalX) & Integer.MAX_VALUE) < 2139095040 && (Float.floatToRawIntBits(historicalY) & Integer.MAX_VALUE) < 2139095040) {
                        long m5095constructorimpl2 = Offset.m5095constructorimpl((Float.floatToRawIntBits(historicalX) << c2) | (Float.floatToRawIntBits(historicalY) & j));
                        long historicalEventTime = motionEvent.getHistoricalEventTime(i2);
                        Float valueOf = Float.valueOf(motionEvent.getHistoricalAxisValue(52, i, i2));
                        f2 = valueOf.floatValue() > 0.0f ? valueOf : null;
                        float floatValue = f2 != null ? f2.floatValue() : 1.0f;
                        if (Build.VERSION.SDK_INT < 29 || motionEvent.getClassification() != 3) {
                            m5119getZeroF1C5BW03 = Offset.Companion.m5119getZeroF1C5BW0();
                        } else {
                            m5119getZeroF1C5BW03 = Offset.m5095constructorimpl((Float.floatToRawIntBits(motionEvent.getHistoricalAxisValue(50, i, i2)) << c2) | (Float.floatToRawIntBits(motionEvent.getHistoricalAxisValue(51, i, i2)) & j));
                        }
                        arrayList.add(new HistoricalChange(historicalEventTime, m5095constructorimpl2, floatValue, m5119getZeroF1C5BW03, m5095constructorimpl2, (DefaultConstructorMarker) null));
                    }
                    i2++;
                    m5095constructorimpl = j5;
                }
                long j6 = m5095constructorimpl;
                if (motionEvent.getActionMasked() == 8) {
                    m5119getZeroF1C5BW0 = Offset.Companion.m5119getZeroF1C5BW0();
                } else {
                    m5119getZeroF1C5BW0 = Offset.m5095constructorimpl((Float.floatToRawIntBits((-motionEvent.getAxisValue(9)) + 0.0f) & j) | (Float.floatToRawIntBits(motionEvent.getAxisValue(10)) << c2));
                }
                if (ComposeUiFlags.isTrackpadGestureHandlingEnabled && Build.VERSION.SDK_INT >= 29 && motionEvent.getClassification() == 5) {
                    Float valueOf2 = Float.valueOf(motionEvent.getAxisValue(52, i));
                    f2 = valueOf2.floatValue() > 0.0f ? valueOf2 : null;
                    if (f2 != null) {
                        f = f2.floatValue();
                    }
                }
                if (ComposeUiFlags.isTrackpadGestureHandlingEnabled || Build.VERSION.SDK_INT < 29 || motionEvent.getClassification() != 3) {
                    j3 = m5119getZeroF1C5BW0;
                    m5119getZeroF1C5BW02 = Offset.Companion.m5119getZeroF1C5BW0();
                } else {
                    j3 = m5119getZeroF1C5BW0;
                    m5119getZeroF1C5BW02 = Offset.m5095constructorimpl((Float.floatToRawIntBits(motionEvent.getAxisValue(50, i)) << c2) | (Float.floatToRawIntBits(motionEvent.getAxisValue(51, i)) & j));
                }
                return new PointerInputEventData(m6594getComposePointerId_I2yYro, motionEvent.getEventTime(), j4, j2, z, pressure, i3, this.activeHoverIds.get(motionEvent.getPointerId(i), false), arrayList, j3, f, m5119getZeroF1C5BW02, j6, null);
            }
        }
        j2 = mo6768screenToLocalMKHz9U;
        long j42 = mo6767localToScreenMKHz9U;
        toolType = motionEvent.getToolType(i);
        if (toolType == 0) {
        }
        ArrayList arrayList2 = new ArrayList(motionEvent.getHistorySize());
        historySize = motionEvent.getHistorySize();
        int i32 = m6766getUnknownT8wyACA;
        i2 = 0;
        while (true) {
            if (i2 < historySize) {
            }
            i2++;
            m5095constructorimpl = j5;
        }
        long j62 = m5095constructorimpl;
        if (motionEvent.getActionMasked() == 8) {
        }
        if (ComposeUiFlags.isTrackpadGestureHandlingEnabled) {
            Float valueOf22 = Float.valueOf(motionEvent.getAxisValue(52, i));
            if (valueOf22.floatValue() > 0.0f) {
            }
            if (f2 != null) {
            }
        }
        if (ComposeUiFlags.isTrackpadGestureHandlingEnabled) {
        }
        j3 = m5119getZeroF1C5BW0;
        m5119getZeroF1C5BW02 = Offset.Companion.m5119getZeroF1C5BW0();
        return new PointerInputEventData(m6594getComposePointerId_I2yYro, motionEvent.getEventTime(), j42, j2, z, pressure, i32, this.activeHoverIds.get(motionEvent.getPointerId(i), false), arrayList2, j3, f, m5119getZeroF1C5BW02, j62, null);
    }
}
