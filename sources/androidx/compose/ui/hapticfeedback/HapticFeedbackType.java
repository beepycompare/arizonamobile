package androidx.compose.ui.hapticfeedback;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: HapticFeedbackType.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/hapticfeedback/HapticFeedbackType;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class HapticFeedbackType {
    public static final Companion Companion = new Companion(null);
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ HapticFeedbackType m5542boximpl(int i) {
        return new HapticFeedbackType(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m5543constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m5544equalsimpl(int i, Object obj) {
        return (obj instanceof HapticFeedbackType) && i == ((HapticFeedbackType) obj).m5548unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m5545equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m5546hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m5544equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m5546hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m5548unboximpl() {
        return this.value;
    }

    private /* synthetic */ HapticFeedbackType(int i) {
        this.value = i;
    }

    public String toString() {
        return m5547toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m5547toStringimpl(int i) {
        Companion companion = Companion;
        return m5545equalsimpl0(i, companion.m5549getConfirm5zf0vsI()) ? "Confirm" : m5545equalsimpl0(i, companion.m5550getContextClick5zf0vsI()) ? "ContextClick" : m5545equalsimpl0(i, companion.m5551getGestureEnd5zf0vsI()) ? "GestureEnd" : m5545equalsimpl0(i, companion.m5552getGestureThresholdActivate5zf0vsI()) ? "GestureThresholdActivate" : m5545equalsimpl0(i, companion.m5553getKeyboardTap5zf0vsI()) ? "KeyboardTap" : m5545equalsimpl0(i, companion.m5554getLongPress5zf0vsI()) ? "LongPress" : m5545equalsimpl0(i, companion.m5555getReject5zf0vsI()) ? "Reject" : m5545equalsimpl0(i, companion.m5556getSegmentFrequentTick5zf0vsI()) ? "SegmentFrequentTick" : m5545equalsimpl0(i, companion.m5557getSegmentTick5zf0vsI()) ? "SegmentTick" : m5545equalsimpl0(i, companion.m5558getTextHandleMove5zf0vsI()) ? "TextHandleMove" : m5545equalsimpl0(i, companion.m5559getToggleOff5zf0vsI()) ? "ToggleOff" : m5545equalsimpl0(i, companion.m5560getToggleOn5zf0vsI()) ? "ToggleOn" : m5545equalsimpl0(i, companion.m5561getVirtualKey5zf0vsI()) ? "VirtualKey" : "Invalid";
    }

    /* compiled from: HapticFeedbackType.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050!R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0018\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0007R\u0011\u0010\u001c\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0007R\u0011\u0010\u001e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0007¨\u0006\""}, d2 = {"Landroidx/compose/ui/hapticfeedback/HapticFeedbackType$Companion;", "", "<init>", "()V", "Confirm", "Landroidx/compose/ui/hapticfeedback/HapticFeedbackType;", "getConfirm-5zf0vsI", "()I", "ContextClick", "getContextClick-5zf0vsI", "GestureEnd", "getGestureEnd-5zf0vsI", "GestureThresholdActivate", "getGestureThresholdActivate-5zf0vsI", "KeyboardTap", "getKeyboardTap-5zf0vsI", "LongPress", "getLongPress-5zf0vsI", "Reject", "getReject-5zf0vsI", "SegmentFrequentTick", "getSegmentFrequentTick-5zf0vsI", "SegmentTick", "getSegmentTick-5zf0vsI", "TextHandleMove", "getTextHandleMove-5zf0vsI", "ToggleOff", "getToggleOff-5zf0vsI", "ToggleOn", "getToggleOn-5zf0vsI", "VirtualKey", "getVirtualKey-5zf0vsI", "values", "", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getConfirm-5zf0vsI  reason: not valid java name */
        public final int m5549getConfirm5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m5562getConfirm5zf0vsI();
        }

        /* renamed from: getContextClick-5zf0vsI  reason: not valid java name */
        public final int m5550getContextClick5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m5563getContextClick5zf0vsI();
        }

        /* renamed from: getGestureEnd-5zf0vsI  reason: not valid java name */
        public final int m5551getGestureEnd5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m5564getGestureEnd5zf0vsI();
        }

        /* renamed from: getGestureThresholdActivate-5zf0vsI  reason: not valid java name */
        public final int m5552getGestureThresholdActivate5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m5565getGestureThresholdActivate5zf0vsI();
        }

        /* renamed from: getKeyboardTap-5zf0vsI  reason: not valid java name */
        public final int m5553getKeyboardTap5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m5566getKeyboardTap5zf0vsI();
        }

        /* renamed from: getLongPress-5zf0vsI  reason: not valid java name */
        public final int m5554getLongPress5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m5567getLongPress5zf0vsI();
        }

        /* renamed from: getReject-5zf0vsI  reason: not valid java name */
        public final int m5555getReject5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m5568getReject5zf0vsI();
        }

        /* renamed from: getSegmentFrequentTick-5zf0vsI  reason: not valid java name */
        public final int m5556getSegmentFrequentTick5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m5569getSegmentFrequentTick5zf0vsI();
        }

        /* renamed from: getSegmentTick-5zf0vsI  reason: not valid java name */
        public final int m5557getSegmentTick5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m5570getSegmentTick5zf0vsI();
        }

        /* renamed from: getTextHandleMove-5zf0vsI  reason: not valid java name */
        public final int m5558getTextHandleMove5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m5571getTextHandleMove5zf0vsI();
        }

        /* renamed from: getToggleOff-5zf0vsI  reason: not valid java name */
        public final int m5559getToggleOff5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m5572getToggleOff5zf0vsI();
        }

        /* renamed from: getToggleOn-5zf0vsI  reason: not valid java name */
        public final int m5560getToggleOn5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m5573getToggleOn5zf0vsI();
        }

        /* renamed from: getVirtualKey-5zf0vsI  reason: not valid java name */
        public final int m5561getVirtualKey5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m5574getVirtualKey5zf0vsI();
        }

        public final List<HapticFeedbackType> values() {
            return CollectionsKt.listOf((Object[]) new HapticFeedbackType[]{HapticFeedbackType.m5542boximpl(m5549getConfirm5zf0vsI()), HapticFeedbackType.m5542boximpl(m5550getContextClick5zf0vsI()), HapticFeedbackType.m5542boximpl(m5551getGestureEnd5zf0vsI()), HapticFeedbackType.m5542boximpl(m5552getGestureThresholdActivate5zf0vsI()), HapticFeedbackType.m5542boximpl(m5553getKeyboardTap5zf0vsI()), HapticFeedbackType.m5542boximpl(m5554getLongPress5zf0vsI()), HapticFeedbackType.m5542boximpl(m5555getReject5zf0vsI()), HapticFeedbackType.m5542boximpl(m5556getSegmentFrequentTick5zf0vsI()), HapticFeedbackType.m5542boximpl(m5557getSegmentTick5zf0vsI()), HapticFeedbackType.m5542boximpl(m5558getTextHandleMove5zf0vsI()), HapticFeedbackType.m5542boximpl(m5559getToggleOff5zf0vsI()), HapticFeedbackType.m5542boximpl(m5560getToggleOn5zf0vsI()), HapticFeedbackType.m5542boximpl(m5561getVirtualKey5zf0vsI())});
        }
    }
}
