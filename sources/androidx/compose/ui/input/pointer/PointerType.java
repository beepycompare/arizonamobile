package androidx.compose.ui.input.pointer;

import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: PointerEvent.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerType;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class PointerType {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Unknown = m6813constructorimpl(0);
    private static final int Touch = m6813constructorimpl(1);
    private static final int Mouse = m6813constructorimpl(2);
    private static final int Stylus = m6813constructorimpl(3);
    private static final int Eraser = m6813constructorimpl(4);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ PointerType m6812boximpl(int i) {
        return new PointerType(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m6813constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m6814equalsimpl(int i, Object obj) {
        return (obj instanceof PointerType) && i == ((PointerType) obj).m6818unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m6815equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m6816hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m6814equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m6816hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m6818unboximpl() {
        return this.value;
    }

    private /* synthetic */ PointerType(int i) {
        this.value = i;
    }

    public String toString() {
        return m6817toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m6817toStringimpl(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        return "Eraser";
                    }
                    return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                }
                return "Stylus";
            }
            return "Mouse";
        }
        return "Touch";
    }

    /* compiled from: PointerEvent.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerType$Companion;", "", "<init>", "()V", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "Landroidx/compose/ui/input/pointer/PointerType;", "getUnknown-T8wyACA", "()I", "I", "Touch", "getTouch-T8wyACA", "Mouse", "getMouse-T8wyACA", "Stylus", "getStylus-T8wyACA", "Eraser", "getEraser-T8wyACA", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getUnknown-T8wyACA  reason: not valid java name */
        public final int m6823getUnknownT8wyACA() {
            return PointerType.Unknown;
        }

        /* renamed from: getTouch-T8wyACA  reason: not valid java name */
        public final int m6822getTouchT8wyACA() {
            return PointerType.Touch;
        }

        /* renamed from: getMouse-T8wyACA  reason: not valid java name */
        public final int m6820getMouseT8wyACA() {
            return PointerType.Mouse;
        }

        /* renamed from: getStylus-T8wyACA  reason: not valid java name */
        public final int m6821getStylusT8wyACA() {
            return PointerType.Stylus;
        }

        /* renamed from: getEraser-T8wyACA  reason: not valid java name */
        public final int m6819getEraserT8wyACA() {
            return PointerType.Eraser;
        }
    }
}
