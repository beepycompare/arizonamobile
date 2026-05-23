package androidx.compose.ui.input.key;

import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: KeyEvent.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u0003HÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/input/key/KeyEventType;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class KeyEventType {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Unknown = m6508constructorimpl(0);
    private static final int KeyUp = m6508constructorimpl(1);
    private static final int KeyDown = m6508constructorimpl(2);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ KeyEventType m6507boximpl(int i) {
        return new KeyEventType(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m6508constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m6509equalsimpl(int i, Object obj) {
        return (obj instanceof KeyEventType) && i == ((KeyEventType) obj).m6513unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m6510equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m6511hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m6509equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m6511hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m6513unboximpl() {
        return this.value;
    }

    private /* synthetic */ KeyEventType(int i) {
        this.value = i;
    }

    public String toString() {
        return m6512toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m6512toStringimpl(int i) {
        return m6510equalsimpl0(i, KeyUp) ? "KeyUp" : m6510equalsimpl0(i, KeyDown) ? "KeyDown" : m6510equalsimpl0(i, Unknown) ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN : "Invalid";
    }

    /* compiled from: KeyEvent.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/ui/input/key/KeyEventType$Companion;", "", "<init>", "()V", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "Landroidx/compose/ui/input/key/KeyEventType;", "getUnknown-CS__XNY", "()I", "I", "KeyUp", "getKeyUp-CS__XNY", "KeyDown", "getKeyDown-CS__XNY", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getUnknown-CS__XNY  reason: not valid java name */
        public final int m6516getUnknownCS__XNY() {
            return KeyEventType.Unknown;
        }

        /* renamed from: getKeyUp-CS__XNY  reason: not valid java name */
        public final int m6515getKeyUpCS__XNY() {
            return KeyEventType.KeyUp;
        }

        /* renamed from: getKeyDown-CS__XNY  reason: not valid java name */
        public final int m6514getKeyDownCS__XNY() {
            return KeyEventType.KeyDown;
        }
    }
}
