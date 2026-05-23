package androidx.compose.ui.input.pointer;

import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: PointerEvent.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u0003HÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerEventType;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class PointerEventType {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Unknown = m6623constructorimpl(0);
    private static final int Press = m6623constructorimpl(1);
    private static final int Release = m6623constructorimpl(2);
    private static final int Move = m6623constructorimpl(3);
    private static final int Enter = m6623constructorimpl(4);
    private static final int Exit = m6623constructorimpl(5);
    private static final int Scroll = m6623constructorimpl(6);
    private static final int ScaleStart = m6623constructorimpl(7);
    private static final int ScaleChange = m6623constructorimpl(8);
    private static final int ScaleEnd = m6623constructorimpl(9);
    private static final int PanStart = m6623constructorimpl(10);
    private static final int PanMove = m6623constructorimpl(11);
    private static final int PanEnd = m6623constructorimpl(12);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ PointerEventType m6622boximpl(int i) {
        return new PointerEventType(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m6623constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m6624equalsimpl(int i, Object obj) {
        return (obj instanceof PointerEventType) && i == ((PointerEventType) obj).m6628unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m6625equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m6626hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m6624equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m6626hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m6628unboximpl() {
        return this.value;
    }

    /* compiled from: PointerEvent.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007R\u0013\u0010\u0015\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0016\u0010\u0007R\u0013\u0010\u0017\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0018\u0010\u0007R\u0013\u0010\u0019\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001a\u0010\u0007R\u0013\u0010\u001b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001c\u0010\u0007R\u0013\u0010\u001d\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001e\u0010\u0007R\u0013\u0010\u001f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b \u0010\u0007¨\u0006!"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerEventType$Companion;", "", "<init>", "()V", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "Landroidx/compose/ui/input/pointer/PointerEventType;", "getUnknown-7fucELk", "()I", "I", "Press", "getPress-7fucELk", "Release", "getRelease-7fucELk", "Move", "getMove-7fucELk", "Enter", "getEnter-7fucELk", "Exit", "getExit-7fucELk", "Scroll", "getScroll-7fucELk", "ScaleStart", "getScaleStart-7fucELk", "ScaleChange", "getScaleChange-7fucELk", "ScaleEnd", "getScaleEnd-7fucELk", "PanStart", "getPanStart-7fucELk", "PanMove", "getPanMove-7fucELk", "PanEnd", "getPanEnd-7fucELk", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getUnknown-7fucELk  reason: not valid java name */
        public final int m6641getUnknown7fucELk() {
            return PointerEventType.Unknown;
        }

        /* renamed from: getPress-7fucELk  reason: not valid java name */
        public final int m6635getPress7fucELk() {
            return PointerEventType.Press;
        }

        /* renamed from: getRelease-7fucELk  reason: not valid java name */
        public final int m6636getRelease7fucELk() {
            return PointerEventType.Release;
        }

        /* renamed from: getMove-7fucELk  reason: not valid java name */
        public final int m6631getMove7fucELk() {
            return PointerEventType.Move;
        }

        /* renamed from: getEnter-7fucELk  reason: not valid java name */
        public final int m6629getEnter7fucELk() {
            return PointerEventType.Enter;
        }

        /* renamed from: getExit-7fucELk  reason: not valid java name */
        public final int m6630getExit7fucELk() {
            return PointerEventType.Exit;
        }

        /* renamed from: getScroll-7fucELk  reason: not valid java name */
        public final int m6640getScroll7fucELk() {
            return PointerEventType.Scroll;
        }

        /* renamed from: getScaleStart-7fucELk  reason: not valid java name */
        public final int m6639getScaleStart7fucELk() {
            return PointerEventType.ScaleStart;
        }

        /* renamed from: getScaleChange-7fucELk  reason: not valid java name */
        public final int m6637getScaleChange7fucELk() {
            return PointerEventType.ScaleChange;
        }

        /* renamed from: getScaleEnd-7fucELk  reason: not valid java name */
        public final int m6638getScaleEnd7fucELk() {
            return PointerEventType.ScaleEnd;
        }

        /* renamed from: getPanStart-7fucELk  reason: not valid java name */
        public final int m6634getPanStart7fucELk() {
            return PointerEventType.PanStart;
        }

        /* renamed from: getPanMove-7fucELk  reason: not valid java name */
        public final int m6633getPanMove7fucELk() {
            return PointerEventType.PanMove;
        }

        /* renamed from: getPanEnd-7fucELk  reason: not valid java name */
        public final int m6632getPanEnd7fucELk() {
            return PointerEventType.PanEnd;
        }
    }

    private /* synthetic */ PointerEventType(int i) {
        this.value = i;
    }

    public String toString() {
        return m6627toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m6627toStringimpl(int i) {
        return m6625equalsimpl0(i, Press) ? "Press" : m6625equalsimpl0(i, Release) ? "Release" : m6625equalsimpl0(i, Move) ? "Move" : m6625equalsimpl0(i, Enter) ? "Enter" : m6625equalsimpl0(i, Exit) ? "Exit" : m6625equalsimpl0(i, Scroll) ? "Scroll" : m6625equalsimpl0(i, ScaleStart) ? "ScaleStart" : m6625equalsimpl0(i, ScaleChange) ? "ScaleChange" : m6625equalsimpl0(i, ScaleEnd) ? "ScaleFinish" : m6625equalsimpl0(i, PanStart) ? "PanStart" : m6625equalsimpl0(i, PanMove) ? "Pan" : m6625equalsimpl0(i, PanEnd) ? "PanEnd" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }
}
