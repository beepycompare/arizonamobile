package androidx.compose.ui.hapticfeedback;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: HapticFeedbackType.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u0003HÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/hapticfeedback/HapticFeedbackType;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class HapticFeedbackType {
    public static final Companion Companion = new Companion(null);
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ HapticFeedbackType m6118boximpl(int i) {
        return new HapticFeedbackType(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m6119constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m6120equalsimpl(int i, Object obj) {
        return (obj instanceof HapticFeedbackType) && i == ((HapticFeedbackType) obj).m6124unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m6121equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m6122hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m6120equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m6122hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m6124unboximpl() {
        return this.value;
    }

    private /* synthetic */ HapticFeedbackType(int i) {
        this.value = i;
    }

    public String toString() {
        return m6123toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m6123toStringimpl(int i) {
        Companion companion = Companion;
        return m6121equalsimpl0(i, companion.m6125getConfirm5zf0vsI()) ? "Confirm" : m6121equalsimpl0(i, companion.m6126getContextClick5zf0vsI()) ? "ContextClick" : m6121equalsimpl0(i, companion.m6127getGestureEnd5zf0vsI()) ? "GestureEnd" : m6121equalsimpl0(i, companion.m6128getGestureThresholdActivate5zf0vsI()) ? "GestureThresholdActivate" : m6121equalsimpl0(i, companion.m6129getKeyboardTap5zf0vsI()) ? "KeyboardTap" : m6121equalsimpl0(i, companion.m6130getLongPress5zf0vsI()) ? "LongPress" : m6121equalsimpl0(i, companion.m6131getReject5zf0vsI()) ? "Reject" : m6121equalsimpl0(i, companion.m6132getSegmentFrequentTick5zf0vsI()) ? "SegmentFrequentTick" : m6121equalsimpl0(i, companion.m6133getSegmentTick5zf0vsI()) ? "SegmentTick" : m6121equalsimpl0(i, companion.m6134getTextHandleMove5zf0vsI()) ? "TextHandleMove" : m6121equalsimpl0(i, companion.m6135getToggleOff5zf0vsI()) ? "ToggleOff" : m6121equalsimpl0(i, companion.m6136getToggleOn5zf0vsI()) ? "ToggleOn" : m6121equalsimpl0(i, companion.m6137getVirtualKey5zf0vsI()) ? "VirtualKey" : "Invalid";
    }

    /* compiled from: HapticFeedbackType.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050!R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0018\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0007R\u0011\u0010\u001c\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0007R\u0011\u0010\u001e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0007¨\u0006\""}, d2 = {"Landroidx/compose/ui/hapticfeedback/HapticFeedbackType$Companion;", "", "<init>", "()V", "Confirm", "Landroidx/compose/ui/hapticfeedback/HapticFeedbackType;", "getConfirm-5zf0vsI", "()I", "ContextClick", "getContextClick-5zf0vsI", "GestureEnd", "getGestureEnd-5zf0vsI", "GestureThresholdActivate", "getGestureThresholdActivate-5zf0vsI", "KeyboardTap", "getKeyboardTap-5zf0vsI", "LongPress", "getLongPress-5zf0vsI", "Reject", "getReject-5zf0vsI", "SegmentFrequentTick", "getSegmentFrequentTick-5zf0vsI", "SegmentTick", "getSegmentTick-5zf0vsI", "TextHandleMove", "getTextHandleMove-5zf0vsI", "ToggleOff", "getToggleOff-5zf0vsI", "ToggleOn", "getToggleOn-5zf0vsI", "VirtualKey", "getVirtualKey-5zf0vsI", "values", "", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getConfirm-5zf0vsI  reason: not valid java name */
        public final int m6125getConfirm5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m6138getConfirm5zf0vsI();
        }

        /* renamed from: getContextClick-5zf0vsI  reason: not valid java name */
        public final int m6126getContextClick5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m6139getContextClick5zf0vsI();
        }

        /* renamed from: getGestureEnd-5zf0vsI  reason: not valid java name */
        public final int m6127getGestureEnd5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m6140getGestureEnd5zf0vsI();
        }

        /* renamed from: getGestureThresholdActivate-5zf0vsI  reason: not valid java name */
        public final int m6128getGestureThresholdActivate5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m6141getGestureThresholdActivate5zf0vsI();
        }

        /* renamed from: getKeyboardTap-5zf0vsI  reason: not valid java name */
        public final int m6129getKeyboardTap5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m6142getKeyboardTap5zf0vsI();
        }

        /* renamed from: getLongPress-5zf0vsI  reason: not valid java name */
        public final int m6130getLongPress5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m6143getLongPress5zf0vsI();
        }

        /* renamed from: getReject-5zf0vsI  reason: not valid java name */
        public final int m6131getReject5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m6144getReject5zf0vsI();
        }

        /* renamed from: getSegmentFrequentTick-5zf0vsI  reason: not valid java name */
        public final int m6132getSegmentFrequentTick5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m6145getSegmentFrequentTick5zf0vsI();
        }

        /* renamed from: getSegmentTick-5zf0vsI  reason: not valid java name */
        public final int m6133getSegmentTick5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m6146getSegmentTick5zf0vsI();
        }

        /* renamed from: getTextHandleMove-5zf0vsI  reason: not valid java name */
        public final int m6134getTextHandleMove5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m6147getTextHandleMove5zf0vsI();
        }

        /* renamed from: getToggleOff-5zf0vsI  reason: not valid java name */
        public final int m6135getToggleOff5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m6148getToggleOff5zf0vsI();
        }

        /* renamed from: getToggleOn-5zf0vsI  reason: not valid java name */
        public final int m6136getToggleOn5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m6149getToggleOn5zf0vsI();
        }

        /* renamed from: getVirtualKey-5zf0vsI  reason: not valid java name */
        public final int m6137getVirtualKey5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m6150getVirtualKey5zf0vsI();
        }

        public final List<HapticFeedbackType> values() {
            return CollectionsKt.listOf((Object[]) new HapticFeedbackType[]{HapticFeedbackType.m6118boximpl(m6125getConfirm5zf0vsI()), HapticFeedbackType.m6118boximpl(m6126getContextClick5zf0vsI()), HapticFeedbackType.m6118boximpl(m6127getGestureEnd5zf0vsI()), HapticFeedbackType.m6118boximpl(m6128getGestureThresholdActivate5zf0vsI()), HapticFeedbackType.m6118boximpl(m6129getKeyboardTap5zf0vsI()), HapticFeedbackType.m6118boximpl(m6130getLongPress5zf0vsI()), HapticFeedbackType.m6118boximpl(m6131getReject5zf0vsI()), HapticFeedbackType.m6118boximpl(m6132getSegmentFrequentTick5zf0vsI()), HapticFeedbackType.m6118boximpl(m6133getSegmentTick5zf0vsI()), HapticFeedbackType.m6118boximpl(m6134getTextHandleMove5zf0vsI()), HapticFeedbackType.m6118boximpl(m6135getToggleOff5zf0vsI()), HapticFeedbackType.m6118boximpl(m6136getToggleOn5zf0vsI()), HapticFeedbackType.m6118boximpl(m6137getVirtualKey5zf0vsI())});
        }
    }
}
