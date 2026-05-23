package androidx.compose.ui.platform;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: AutoClearFocusBehavior.android.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u000b\u001a\u00020\u0003HÖ\u0081\u0004¢\u0006\u0004\b\f\u0010\u0005J\u0011\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/platform/AutoClearFocusBehavior;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class AutoClearFocusBehavior {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int None = m7270constructorimpl(0);
    private static final int CursorBased = m7270constructorimpl(1);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ AutoClearFocusBehavior m7269boximpl(int i) {
        return new AutoClearFocusBehavior(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m7270constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m7271equalsimpl(int i, Object obj) {
        return (obj instanceof AutoClearFocusBehavior) && i == ((AutoClearFocusBehavior) obj).m7275unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m7272equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m7273hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m7274toStringimpl(int i) {
        return "AutoClearFocusBehavior(value=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m7271equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m7273hashCodeimpl(this.value);
    }

    public String toString() {
        return m7274toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m7275unboximpl() {
        return this.value;
    }

    /* compiled from: AutoClearFocusBehavior.android.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0011\u0010\u000b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/ui/platform/AutoClearFocusBehavior$Companion;", "", "<init>", "()V", "None", "Landroidx/compose/ui/platform/AutoClearFocusBehavior;", "getNone-4UtRPd4", "()I", "I", "CursorBased", "getCursorBased-4UtRPd4", "Default", "getDefault-4UtRPd4", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getNone-4UtRPd4  reason: not valid java name */
        public final int m7278getNone4UtRPd4() {
            return AutoClearFocusBehavior.None;
        }

        /* renamed from: getCursorBased-4UtRPd4  reason: not valid java name */
        public final int m7276getCursorBased4UtRPd4() {
            return AutoClearFocusBehavior.CursorBased;
        }

        /* renamed from: getDefault-4UtRPd4  reason: not valid java name */
        public final int m7277getDefault4UtRPd4() {
            return m7276getCursorBased4UtRPd4();
        }
    }

    private /* synthetic */ AutoClearFocusBehavior(int i) {
        this.value = i;
    }
}
