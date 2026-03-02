package androidx.constraintlayout.compose;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: ConstraintLayoutBaseScope.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001d\b\u0012\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\u001a\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0012\u0010\tJ\u001b\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000H\u0086\u0004ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000bR\u000e\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0007\u0092\u0001\u00020\b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"Landroidx/constraintlayout/compose/GridFlag;", "", "isPlaceLayoutsOnSpansFirst", "", "isSubGridByColRow", "constructor-impl", "(ZZ)I", "value", "", "(I)I", "isPlaceLayoutsOnSpansFirst-impl", "(I)Z", "isSubGridByColRow-impl$constraintlayout_compose_release", "equals", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "or", "or-90j8xCw", "(II)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class GridFlag {
    public static final Companion Companion = new Companion(null);
    private static final int None = m7917constructorimpl$default(false, false, 3, null);
    private static final int PlaceLayoutsOnSpansFirst = m7917constructorimpl$default(true, false, 2, null);
    private static final int SubGridByColRow = m7917constructorimpl$default(false, true, 1, null);
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ GridFlag m7914boximpl(int i) {
        return new GridFlag(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m7915constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m7918equalsimpl(int i, Object obj) {
        return (obj instanceof GridFlag) && i == ((GridFlag) obj).m7925unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m7919equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m7920hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* renamed from: isPlaceLayoutsOnSpansFirst-impl  reason: not valid java name */
    public static final boolean m7921isPlaceLayoutsOnSpansFirstimpl(int i) {
        return (i & 2) == 0;
    }

    /* renamed from: isSubGridByColRow-impl$constraintlayout_compose_release  reason: not valid java name */
    public static final boolean m7922isSubGridByColRowimpl$constraintlayout_compose_release(int i) {
        return (i & 1) > 0;
    }

    public boolean equals(Object obj) {
        return m7918equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m7920hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m7925unboximpl() {
        return this.value;
    }

    private /* synthetic */ GridFlag(int i) {
        this.value = i;
    }

    /* renamed from: constructor-impl$default  reason: not valid java name */
    static /* synthetic */ int m7917constructorimpl$default(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        return m7916constructorimpl(z, z2);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m7916constructorimpl(boolean z, boolean z2) {
        return m7915constructorimpl((z ? 0 : 2) | (z2 ? 1 : 0));
    }

    /* renamed from: or-90j8xCw  reason: not valid java name */
    public static final int m7923or90j8xCw(int i, int i2) {
        return m7916constructorimpl(m7921isPlaceLayoutsOnSpansFirstimpl(i) | m7921isPlaceLayoutsOnSpansFirstimpl(i2), m7922isSubGridByColRowimpl$constraintlayout_compose_release(i) | m7922isSubGridByColRowimpl$constraintlayout_compose_release(i2));
    }

    public String toString() {
        return m7924toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m7924toStringimpl(int i) {
        return "GridFlag(isPlaceLayoutsOnSpansFirst = " + m7921isPlaceLayoutsOnSpansFirstimpl(i) + ')';
    }

    /* compiled from: ConstraintLayoutBaseScope.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001e\u0010\n\u001a\u00020\u00048\u0000X\u0081\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, d2 = {"Landroidx/constraintlayout/compose/GridFlag$Companion;", "", "()V", "None", "Landroidx/constraintlayout/compose/GridFlag;", "getNone-dTRCCdc", "()I", "I", "PlaceLayoutsOnSpansFirst", "getPlaceLayoutsOnSpansFirst-dTRCCdc", "SubGridByColRow", "getSubGridByColRow-dTRCCdc$constraintlayout_compose_release", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getNone-dTRCCdc  reason: not valid java name */
        public final int m7926getNonedTRCCdc() {
            return GridFlag.None;
        }

        /* renamed from: getPlaceLayoutsOnSpansFirst-dTRCCdc  reason: not valid java name */
        public final int m7927getPlaceLayoutsOnSpansFirstdTRCCdc() {
            return GridFlag.PlaceLayoutsOnSpansFirst;
        }

        /* renamed from: getSubGridByColRow-dTRCCdc$constraintlayout_compose_release  reason: not valid java name */
        public final int m7928getSubGridByColRowdTRCCdc$constraintlayout_compose_release() {
            return GridFlag.SubGridByColRow;
        }
    }
}
