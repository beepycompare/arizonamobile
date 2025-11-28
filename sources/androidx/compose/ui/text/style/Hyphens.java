package androidx.compose.ui.text.style;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: Hyphens.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/text/style/Hyphens;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class Hyphens {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int None = m7772constructorimpl(1);
    private static final int Auto = m7772constructorimpl(2);
    private static final int Unspecified = m7772constructorimpl(Integer.MIN_VALUE);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Hyphens m7771boximpl(int i) {
        return new Hyphens(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m7772constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m7773equalsimpl(int i, Object obj) {
        return (obj instanceof Hyphens) && i == ((Hyphens) obj).m7777unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m7774equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m7775hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m7773equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m7775hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m7777unboximpl() {
        return this.value;
    }

    /* compiled from: Hyphens.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/ui/text/style/Hyphens$Companion;", "", "<init>", "()V", "None", "Landroidx/compose/ui/text/style/Hyphens;", "getNone-vmbZdU8", "()I", "I", "Auto", "getAuto-vmbZdU8", "Unspecified", "getUnspecified-vmbZdU8", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getNone-vmbZdU8  reason: not valid java name */
        public final int m7779getNonevmbZdU8() {
            return Hyphens.None;
        }

        /* renamed from: getAuto-vmbZdU8  reason: not valid java name */
        public final int m7778getAutovmbZdU8() {
            return Hyphens.Auto;
        }

        /* renamed from: getUnspecified-vmbZdU8  reason: not valid java name */
        public final int m7780getUnspecifiedvmbZdU8() {
            return Hyphens.Unspecified;
        }
    }

    private /* synthetic */ Hyphens(int i) {
        this.value = i;
    }

    public String toString() {
        return m7776toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m7776toStringimpl(int i) {
        return m7774equalsimpl0(i, None) ? "Hyphens.None" : m7774equalsimpl0(i, Auto) ? "Hyphens.Auto" : m7774equalsimpl0(i, Unspecified) ? "Hyphens.Unspecified" : "Invalid";
    }
}
