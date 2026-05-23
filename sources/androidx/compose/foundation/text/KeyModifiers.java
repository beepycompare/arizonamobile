package androidx.compose.foundation.text;

import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: KeyModifiers.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0081@\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B1\b\u0016\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0014\u0010\u0010\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/text/KeyModifiers;", "", DownloaderServiceMarshaller.PARAMS_FLAGS, "", "constructor-impl", "(I)I", "isAltPressed", "", "isCtrlPressed", "isMetaPressed", "isShiftPressed", "(ZZZZ)I", "plus", "other", "plus-1uj4btU", "(II)I", "equals", "hashCode", "toString", "", "Companion", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class KeyModifiers {
    private static final int ALT_FLAG = 1;
    private static final int Alt;
    private static final int AltMeta;
    private static final int AltShift;
    private static final int CTRL_FLAG = 2;
    private static final int Ctrl;
    private static final int CtrlAlt;
    private static final int CtrlMeta;
    private static final int CtrlShift;
    private static final int META_FLAG = 4;
    private static final int Meta;
    private static final int SHIFT_FLAG = 8;
    private static final int Shift;
    private static final int ShiftMeta;
    private final int flags;
    public static final Companion Companion = new Companion(null);
    private static final int None = m1544constructorimpl(0);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ KeyModifiers m1543boximpl(int i) {
        return new KeyModifiers(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m1544constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1547equalsimpl(int i, Object obj) {
        return (obj instanceof KeyModifiers) && i == ((KeyModifiers) obj).m1563unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1548equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: getAlt-AuQ4EfA  reason: not valid java name */
    public static final int m1549getAltAuQ4EfA() {
        return Companion.m1575getAltAuQ4EfA();
    }

    /* renamed from: getAltMeta-AuQ4EfA  reason: not valid java name */
    public static final int m1550getAltMetaAuQ4EfA() {
        return Companion.m1576getAltMetaAuQ4EfA();
    }

    /* renamed from: getAltShift-AuQ4EfA  reason: not valid java name */
    public static final int m1551getAltShiftAuQ4EfA() {
        return Companion.m1577getAltShiftAuQ4EfA();
    }

    /* renamed from: getCtrl-AuQ4EfA  reason: not valid java name */
    public static final int m1552getCtrlAuQ4EfA() {
        return Companion.m1578getCtrlAuQ4EfA();
    }

    /* renamed from: getCtrlAlt-AuQ4EfA  reason: not valid java name */
    public static final int m1553getCtrlAltAuQ4EfA() {
        return Companion.m1579getCtrlAltAuQ4EfA();
    }

    /* renamed from: getCtrlMeta-AuQ4EfA  reason: not valid java name */
    public static final int m1554getCtrlMetaAuQ4EfA() {
        return Companion.m1580getCtrlMetaAuQ4EfA();
    }

    /* renamed from: getCtrlShift-AuQ4EfA  reason: not valid java name */
    public static final int m1555getCtrlShiftAuQ4EfA() {
        return Companion.m1581getCtrlShiftAuQ4EfA();
    }

    /* renamed from: getMeta-AuQ4EfA  reason: not valid java name */
    public static final int m1556getMetaAuQ4EfA() {
        return Companion.m1582getMetaAuQ4EfA();
    }

    /* renamed from: getNone-AuQ4EfA  reason: not valid java name */
    public static final int m1557getNoneAuQ4EfA() {
        return Companion.m1583getNoneAuQ4EfA();
    }

    /* renamed from: getShift-AuQ4EfA  reason: not valid java name */
    public static final int m1558getShiftAuQ4EfA() {
        return Companion.m1584getShiftAuQ4EfA();
    }

    /* renamed from: getShiftMeta-AuQ4EfA  reason: not valid java name */
    public static final int m1559getShiftMetaAuQ4EfA() {
        return Companion.m1585getShiftMetaAuQ4EfA();
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1560hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1562toStringimpl(int i) {
        return "KeyModifiers(flags=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m1547equalsimpl(this.flags, obj);
    }

    public int hashCode() {
        return m1560hashCodeimpl(this.flags);
    }

    public String toString() {
        return m1562toStringimpl(this.flags);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m1563unboximpl() {
        return this.flags;
    }

    private /* synthetic */ KeyModifiers(int i) {
        this.flags = i;
    }

    /* renamed from: constructor-impl$default  reason: not valid java name */
    public static /* synthetic */ int m1546constructorimpl$default(boolean z, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        if ((i & 8) != 0) {
            z4 = false;
        }
        return m1545constructorimpl(z, z2, z3, z4);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m1545constructorimpl(boolean z, boolean z2, boolean z3, boolean z4) {
        return m1544constructorimpl((z ? 1 : 0) | (z2 ? 2 : 0) | (z3 ? 4 : 0) | (z4 ? 8 : 0));
    }

    /* renamed from: plus-1uj4btU  reason: not valid java name */
    public static final int m1561plus1uj4btU(int i, int i2) {
        return m1544constructorimpl(i | i2);
    }

    /* compiled from: KeyModifiers.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b#\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000f\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\rR\u001e\u0010\u0012\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\u0013\u0010\u0003\u001a\u0004\b\u0014\u0010\rR\u001e\u0010\u0015\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\u0016\u0010\u0003\u001a\u0004\b\u0017\u0010\rR\u001e\u0010\u0018\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\u0019\u0010\u0003\u001a\u0004\b\u001a\u0010\rR\u001e\u0010\u001b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\u001c\u0010\u0003\u001a\u0004\b\u001d\u0010\rR\u001e\u0010\u001e\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\u001f\u0010\u0003\u001a\u0004\b \u0010\rR\u001e\u0010!\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\"\u0010\u0003\u001a\u0004\b#\u0010\rR\u001e\u0010$\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b%\u0010\u0003\u001a\u0004\b&\u0010\rR\u001e\u0010'\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b(\u0010\u0003\u001a\u0004\b)\u0010\rR\u001e\u0010*\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b+\u0010\u0003\u001a\u0004\b,\u0010\r¨\u0006-"}, d2 = {"Landroidx/compose/foundation/text/KeyModifiers$Companion;", "", "<init>", "()V", "ALT_FLAG", "", "CTRL_FLAG", "META_FLAG", "SHIFT_FLAG", "None", "Landroidx/compose/foundation/text/KeyModifiers;", "getNone-AuQ4EfA$annotations", "getNone-AuQ4EfA", "()I", "I", "Alt", "getAlt-AuQ4EfA$annotations", "getAlt-AuQ4EfA", "Ctrl", "getCtrl-AuQ4EfA$annotations", "getCtrl-AuQ4EfA", "Meta", "getMeta-AuQ4EfA$annotations", "getMeta-AuQ4EfA", "Shift", "getShift-AuQ4EfA$annotations", "getShift-AuQ4EfA", "AltShift", "getAltShift-AuQ4EfA$annotations", "getAltShift-AuQ4EfA", "CtrlShift", "getCtrlShift-AuQ4EfA$annotations", "getCtrlShift-AuQ4EfA", "ShiftMeta", "getShiftMeta-AuQ4EfA$annotations", "getShiftMeta-AuQ4EfA", "CtrlAlt", "getCtrlAlt-AuQ4EfA$annotations", "getCtrlAlt-AuQ4EfA", "CtrlMeta", "getCtrlMeta-AuQ4EfA$annotations", "getCtrlMeta-AuQ4EfA", "AltMeta", "getAltMeta-AuQ4EfA$annotations", "getAltMeta-AuQ4EfA", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        /* renamed from: getAlt-AuQ4EfA$annotations  reason: not valid java name */
        public static /* synthetic */ void m1564getAltAuQ4EfA$annotations() {
        }

        @JvmStatic
        /* renamed from: getAltMeta-AuQ4EfA$annotations  reason: not valid java name */
        public static /* synthetic */ void m1565getAltMetaAuQ4EfA$annotations() {
        }

        @JvmStatic
        /* renamed from: getAltShift-AuQ4EfA$annotations  reason: not valid java name */
        public static /* synthetic */ void m1566getAltShiftAuQ4EfA$annotations() {
        }

        @JvmStatic
        /* renamed from: getCtrl-AuQ4EfA$annotations  reason: not valid java name */
        public static /* synthetic */ void m1567getCtrlAuQ4EfA$annotations() {
        }

        @JvmStatic
        /* renamed from: getCtrlAlt-AuQ4EfA$annotations  reason: not valid java name */
        public static /* synthetic */ void m1568getCtrlAltAuQ4EfA$annotations() {
        }

        @JvmStatic
        /* renamed from: getCtrlMeta-AuQ4EfA$annotations  reason: not valid java name */
        public static /* synthetic */ void m1569getCtrlMetaAuQ4EfA$annotations() {
        }

        @JvmStatic
        /* renamed from: getCtrlShift-AuQ4EfA$annotations  reason: not valid java name */
        public static /* synthetic */ void m1570getCtrlShiftAuQ4EfA$annotations() {
        }

        @JvmStatic
        /* renamed from: getMeta-AuQ4EfA$annotations  reason: not valid java name */
        public static /* synthetic */ void m1571getMetaAuQ4EfA$annotations() {
        }

        @JvmStatic
        /* renamed from: getNone-AuQ4EfA$annotations  reason: not valid java name */
        public static /* synthetic */ void m1572getNoneAuQ4EfA$annotations() {
        }

        @JvmStatic
        /* renamed from: getShift-AuQ4EfA$annotations  reason: not valid java name */
        public static /* synthetic */ void m1573getShiftAuQ4EfA$annotations() {
        }

        @JvmStatic
        /* renamed from: getShiftMeta-AuQ4EfA$annotations  reason: not valid java name */
        public static /* synthetic */ void m1574getShiftMetaAuQ4EfA$annotations() {
        }

        private Companion() {
        }

        /* renamed from: getNone-AuQ4EfA  reason: not valid java name */
        public final int m1583getNoneAuQ4EfA() {
            return KeyModifiers.None;
        }

        /* renamed from: getAlt-AuQ4EfA  reason: not valid java name */
        public final int m1575getAltAuQ4EfA() {
            return KeyModifiers.Alt;
        }

        /* renamed from: getCtrl-AuQ4EfA  reason: not valid java name */
        public final int m1578getCtrlAuQ4EfA() {
            return KeyModifiers.Ctrl;
        }

        /* renamed from: getMeta-AuQ4EfA  reason: not valid java name */
        public final int m1582getMetaAuQ4EfA() {
            return KeyModifiers.Meta;
        }

        /* renamed from: getShift-AuQ4EfA  reason: not valid java name */
        public final int m1584getShiftAuQ4EfA() {
            return KeyModifiers.Shift;
        }

        /* renamed from: getAltShift-AuQ4EfA  reason: not valid java name */
        public final int m1577getAltShiftAuQ4EfA() {
            return KeyModifiers.AltShift;
        }

        /* renamed from: getCtrlShift-AuQ4EfA  reason: not valid java name */
        public final int m1581getCtrlShiftAuQ4EfA() {
            return KeyModifiers.CtrlShift;
        }

        /* renamed from: getShiftMeta-AuQ4EfA  reason: not valid java name */
        public final int m1585getShiftMetaAuQ4EfA() {
            return KeyModifiers.ShiftMeta;
        }

        /* renamed from: getCtrlAlt-AuQ4EfA  reason: not valid java name */
        public final int m1579getCtrlAltAuQ4EfA() {
            return KeyModifiers.CtrlAlt;
        }

        /* renamed from: getCtrlMeta-AuQ4EfA  reason: not valid java name */
        public final int m1580getCtrlMetaAuQ4EfA() {
            return KeyModifiers.CtrlMeta;
        }

        /* renamed from: getAltMeta-AuQ4EfA  reason: not valid java name */
        public final int m1576getAltMetaAuQ4EfA() {
            return KeyModifiers.AltMeta;
        }
    }

    static {
        int m1544constructorimpl = m1544constructorimpl(1);
        Alt = m1544constructorimpl;
        int m1544constructorimpl2 = m1544constructorimpl(2);
        Ctrl = m1544constructorimpl2;
        int m1544constructorimpl3 = m1544constructorimpl(4);
        Meta = m1544constructorimpl3;
        int m1544constructorimpl4 = m1544constructorimpl(8);
        Shift = m1544constructorimpl4;
        AltShift = m1561plus1uj4btU(m1544constructorimpl, m1544constructorimpl4);
        CtrlShift = m1561plus1uj4btU(m1544constructorimpl2, m1544constructorimpl4);
        ShiftMeta = m1561plus1uj4btU(m1544constructorimpl3, m1544constructorimpl4);
        CtrlAlt = m1561plus1uj4btU(m1544constructorimpl2, m1544constructorimpl);
        CtrlMeta = m1561plus1uj4btU(m1544constructorimpl2, m1544constructorimpl3);
        AltMeta = m1561plus1uj4btU(m1544constructorimpl3, m1544constructorimpl4);
    }
}
