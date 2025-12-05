package androidx.compose.ui.text.font;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: FontSynthesis.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087@\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\r8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f\u0088\u0001\u0002¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/text/font/FontSynthesis;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "isWeightOn", "", "isWeightOn-impl$ui_text", "(I)Z", "isStyleOn", "isStyleOn-impl$ui_text", "equals", "other", "hashCode", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class FontSynthesis {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int None = m7824constructorimpl(0);
    private static final int Weight = m7824constructorimpl(1);
    private static final int Style = m7824constructorimpl(2);
    private static final int All = m7824constructorimpl(65535);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ FontSynthesis m7823boximpl(int i) {
        return new FontSynthesis(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m7824constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m7825equalsimpl(int i, Object obj) {
        return (obj instanceof FontSynthesis) && i == ((FontSynthesis) obj).m7831unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m7826equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m7827hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* renamed from: isStyleOn-impl$ui_text  reason: not valid java name */
    public static final boolean m7828isStyleOnimpl$ui_text(int i) {
        return (i & 2) != 0;
    }

    /* renamed from: isWeightOn-impl$ui_text  reason: not valid java name */
    public static final boolean m7829isWeightOnimpl$ui_text(int i) {
        return (i & 1) != 0;
    }

    public boolean equals(Object obj) {
        return m7825equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m7827hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m7831unboximpl() {
        return this.value;
    }

    private /* synthetic */ FontSynthesis(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    public String toString() {
        return m7830toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m7830toStringimpl(int i) {
        return m7826equalsimpl0(i, None) ? "None" : m7826equalsimpl0(i, Weight) ? "Weight" : m7826equalsimpl0(i, Style) ? "Style" : m7826equalsimpl0(i, All) ? "All" : "Invalid";
    }

    /* compiled from: FontSynthesis.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/text/font/FontSynthesis$Companion;", "", "<init>", "()V", "None", "Landroidx/compose/ui/text/font/FontSynthesis;", "getNone-GVVA2EU", "()I", "I", "Weight", "getWeight-GVVA2EU", "Style", "getStyle-GVVA2EU", "All", "getAll-GVVA2EU", "valueOf", "value", "", "valueOf-9CiegCU", "(I)I", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getNone-GVVA2EU  reason: not valid java name */
        public final int m7833getNoneGVVA2EU() {
            return FontSynthesis.None;
        }

        /* renamed from: getWeight-GVVA2EU  reason: not valid java name */
        public final int m7835getWeightGVVA2EU() {
            return FontSynthesis.Weight;
        }

        /* renamed from: getStyle-GVVA2EU  reason: not valid java name */
        public final int m7834getStyleGVVA2EU() {
            return FontSynthesis.Style;
        }

        /* renamed from: getAll-GVVA2EU  reason: not valid java name */
        public final int m7832getAllGVVA2EU() {
            return FontSynthesis.All;
        }

        /* renamed from: valueOf-9CiegCU  reason: not valid java name */
        public final int m7836valueOf9CiegCU(int i) {
            boolean z = true;
            if (i != 0 && i != 1 && i != 2 && i != 65535) {
                z = false;
            }
            if (!z) {
                InlineClassHelperKt.throwIllegalArgumentException("The given value=" + i + " is not recognized by FontSynthesis.");
            }
            return FontSynthesis.m7824constructorimpl(i);
        }
    }
}
