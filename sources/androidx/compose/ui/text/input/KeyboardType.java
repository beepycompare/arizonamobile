package androidx.compose.ui.text.input;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: KeyboardType.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u0003HÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/text/input/KeyboardType;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-text"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class KeyboardType {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Unspecified = m7827constructorimpl(0);
    private static final int Text = m7827constructorimpl(1);
    private static final int Ascii = m7827constructorimpl(2);
    private static final int Number = m7827constructorimpl(3);
    private static final int Phone = m7827constructorimpl(4);
    private static final int Uri = m7827constructorimpl(5);
    private static final int Email = m7827constructorimpl(6);
    private static final int Password = m7827constructorimpl(7);
    private static final int NumberPassword = m7827constructorimpl(8);
    private static final int Decimal = m7827constructorimpl(9);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ KeyboardType m7826boximpl(int i) {
        return new KeyboardType(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m7827constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m7828equalsimpl(int i, Object obj) {
        return (obj instanceof KeyboardType) && i == ((KeyboardType) obj).m7832unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m7829equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m7830hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m7828equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m7830hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m7832unboximpl() {
        return this.value;
    }

    private /* synthetic */ KeyboardType(int i) {
        this.value = i;
    }

    public String toString() {
        return m7831toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m7831toStringimpl(int i) {
        return m7829equalsimpl0(i, Unspecified) ? "Unspecified" : m7829equalsimpl0(i, Text) ? "Text" : m7829equalsimpl0(i, Ascii) ? "Ascii" : m7829equalsimpl0(i, Number) ? "Number" : m7829equalsimpl0(i, Phone) ? "Phone" : m7829equalsimpl0(i, Uri) ? "Uri" : m7829equalsimpl0(i, Email) ? "Email" : m7829equalsimpl0(i, Password) ? "Password" : m7829equalsimpl0(i, NumberPassword) ? "NumberPassword" : m7829equalsimpl0(i, Decimal) ? "Decimal" : "Invalid";
    }

    /* compiled from: KeyboardType.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\bR\u001e\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\bR\u001e\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u0012\u0010\bR\u001e\u0010\u0013\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\bR\u001e\u0010\u0016\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0017\u0010\u0003\u001a\u0004\b\u0018\u0010\bR\u001e\u0010\u0019\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u001a\u0010\u0003\u001a\u0004\b\u001b\u0010\bR\u001e\u0010\u001c\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u001d\u0010\u0003\u001a\u0004\b\u001e\u0010\bR\u001e\u0010\u001f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b \u0010\u0003\u001a\u0004\b!\u0010\bR\u001e\u0010\"\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b#\u0010\u0003\u001a\u0004\b$\u0010\b¨\u0006%"}, d2 = {"Landroidx/compose/ui/text/input/KeyboardType$Companion;", "", "<init>", "()V", "Unspecified", "Landroidx/compose/ui/text/input/KeyboardType;", "getUnspecified-PjHm6EE$annotations", "getUnspecified-PjHm6EE", "()I", "I", "Text", "getText-PjHm6EE$annotations", "getText-PjHm6EE", "Ascii", "getAscii-PjHm6EE$annotations", "getAscii-PjHm6EE", "Number", "getNumber-PjHm6EE$annotations", "getNumber-PjHm6EE", "Phone", "getPhone-PjHm6EE$annotations", "getPhone-PjHm6EE", "Uri", "getUri-PjHm6EE$annotations", "getUri-PjHm6EE", "Email", "getEmail-PjHm6EE$annotations", "getEmail-PjHm6EE", "Password", "getPassword-PjHm6EE$annotations", "getPassword-PjHm6EE", "NumberPassword", "getNumberPassword-PjHm6EE$annotations", "getNumberPassword-PjHm6EE", "Decimal", "getDecimal-PjHm6EE$annotations", "getDecimal-PjHm6EE", "ui-text"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getAscii-PjHm6EE$annotations  reason: not valid java name */
        public static /* synthetic */ void m7833getAsciiPjHm6EE$annotations() {
        }

        /* renamed from: getDecimal-PjHm6EE$annotations  reason: not valid java name */
        public static /* synthetic */ void m7834getDecimalPjHm6EE$annotations() {
        }

        /* renamed from: getEmail-PjHm6EE$annotations  reason: not valid java name */
        public static /* synthetic */ void m7835getEmailPjHm6EE$annotations() {
        }

        /* renamed from: getNumber-PjHm6EE$annotations  reason: not valid java name */
        public static /* synthetic */ void m7836getNumberPjHm6EE$annotations() {
        }

        /* renamed from: getNumberPassword-PjHm6EE$annotations  reason: not valid java name */
        public static /* synthetic */ void m7837getNumberPasswordPjHm6EE$annotations() {
        }

        /* renamed from: getPassword-PjHm6EE$annotations  reason: not valid java name */
        public static /* synthetic */ void m7838getPasswordPjHm6EE$annotations() {
        }

        /* renamed from: getPhone-PjHm6EE$annotations  reason: not valid java name */
        public static /* synthetic */ void m7839getPhonePjHm6EE$annotations() {
        }

        /* renamed from: getText-PjHm6EE$annotations  reason: not valid java name */
        public static /* synthetic */ void m7840getTextPjHm6EE$annotations() {
        }

        /* renamed from: getUnspecified-PjHm6EE$annotations  reason: not valid java name */
        public static /* synthetic */ void m7841getUnspecifiedPjHm6EE$annotations() {
        }

        /* renamed from: getUri-PjHm6EE$annotations  reason: not valid java name */
        public static /* synthetic */ void m7842getUriPjHm6EE$annotations() {
        }

        private Companion() {
        }

        /* renamed from: getUnspecified-PjHm6EE  reason: not valid java name */
        public final int m7851getUnspecifiedPjHm6EE() {
            return KeyboardType.Unspecified;
        }

        /* renamed from: getText-PjHm6EE  reason: not valid java name */
        public final int m7850getTextPjHm6EE() {
            return KeyboardType.Text;
        }

        /* renamed from: getAscii-PjHm6EE  reason: not valid java name */
        public final int m7843getAsciiPjHm6EE() {
            return KeyboardType.Ascii;
        }

        /* renamed from: getNumber-PjHm6EE  reason: not valid java name */
        public final int m7846getNumberPjHm6EE() {
            return KeyboardType.Number;
        }

        /* renamed from: getPhone-PjHm6EE  reason: not valid java name */
        public final int m7849getPhonePjHm6EE() {
            return KeyboardType.Phone;
        }

        /* renamed from: getUri-PjHm6EE  reason: not valid java name */
        public final int m7852getUriPjHm6EE() {
            return KeyboardType.Uri;
        }

        /* renamed from: getEmail-PjHm6EE  reason: not valid java name */
        public final int m7845getEmailPjHm6EE() {
            return KeyboardType.Email;
        }

        /* renamed from: getPassword-PjHm6EE  reason: not valid java name */
        public final int m7848getPasswordPjHm6EE() {
            return KeyboardType.Password;
        }

        /* renamed from: getNumberPassword-PjHm6EE  reason: not valid java name */
        public final int m7847getNumberPasswordPjHm6EE() {
            return KeyboardType.NumberPassword;
        }

        /* renamed from: getDecimal-PjHm6EE  reason: not valid java name */
        public final int m7844getDecimalPjHm6EE() {
            return KeyboardType.Decimal;
        }
    }
}
