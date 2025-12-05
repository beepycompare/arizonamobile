package androidx.compose.ui.input.indirect;

import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: IndirectPointerEvent.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/input/indirect/IndirectPointerEventType;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class IndirectPointerEventType {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Unknown = m6261constructorimpl(0);
    private static final int Press = m6261constructorimpl(1);
    private static final int Release = m6261constructorimpl(2);
    private static final int Move = m6261constructorimpl(3);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ IndirectPointerEventType m6260boximpl(int i) {
        return new IndirectPointerEventType(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m6261constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m6262equalsimpl(int i, Object obj) {
        return (obj instanceof IndirectPointerEventType) && i == ((IndirectPointerEventType) obj).m6266unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m6263equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m6264hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m6262equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m6264hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m6266unboximpl() {
        return this.value;
    }

    /* compiled from: IndirectPointerEvent.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/input/indirect/IndirectPointerEventType$Companion;", "", "<init>", "()V", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "Landroidx/compose/ui/input/indirect/IndirectPointerEventType;", "getUnknown-4ZHQPSE", "()I", "I", "Press", "getPress-4ZHQPSE", "Release", "getRelease-4ZHQPSE", "Move", "getMove-4ZHQPSE", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getUnknown-4ZHQPSE  reason: not valid java name */
        public final int m6270getUnknown4ZHQPSE() {
            return IndirectPointerEventType.Unknown;
        }

        /* renamed from: getPress-4ZHQPSE  reason: not valid java name */
        public final int m6268getPress4ZHQPSE() {
            return IndirectPointerEventType.Press;
        }

        /* renamed from: getRelease-4ZHQPSE  reason: not valid java name */
        public final int m6269getRelease4ZHQPSE() {
            return IndirectPointerEventType.Release;
        }

        /* renamed from: getMove-4ZHQPSE  reason: not valid java name */
        public final int m6267getMove4ZHQPSE() {
            return IndirectPointerEventType.Move;
        }
    }

    private /* synthetic */ IndirectPointerEventType(int i) {
        this.value = i;
    }

    public String toString() {
        return m6265toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m6265toStringimpl(int i) {
        return m6263equalsimpl0(i, Press) ? "Press" : m6263equalsimpl0(i, Release) ? "Release" : m6263equalsimpl0(i, Move) ? "Move" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }
}
