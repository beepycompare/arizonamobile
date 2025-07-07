package androidx.constraintlayout.compose;

import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: MotionLayout.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B'\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0000\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\u001a\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0014\u0010\nJ\u000f\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f\u0088\u0001\b\u0092\u0001\u00020\t¨\u0006\u001a"}, d2 = {"Landroidx/constraintlayout/compose/DebugFlags;", "", "showBounds", "", "showPaths", "showKeyPositions", "constructor-impl", "(ZZZ)I", DownloaderServiceMarshaller.PARAMS_FLAGS, "", "(I)I", "getShowBounds-impl", "(I)Z", "getShowKeyPositions-impl", "getShowPaths-impl", "equals", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class DebugFlags {
    private static final int BOUNDS_FLAG = 1;
    private static final int KEY_POSITIONS_FLAG = 4;
    private static final int PATHS_FLAG = 2;
    private final int flags;
    public static final Companion Companion = new Companion(null);
    private static final int None = m7028constructorimpl(0);
    private static final int All = m7028constructorimpl(-1);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ DebugFlags m7027boximpl(int i) {
        return new DebugFlags(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m7028constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m7031equalsimpl(int i, Object obj) {
        return (obj instanceof DebugFlags) && i == ((DebugFlags) obj).m7038unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m7032equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: getShowBounds-impl  reason: not valid java name */
    public static final boolean m7033getShowBoundsimpl(int i) {
        return (i & 1) > 0;
    }

    /* renamed from: getShowKeyPositions-impl  reason: not valid java name */
    public static final boolean m7034getShowKeyPositionsimpl(int i) {
        return (i & 4) > 0;
    }

    /* renamed from: getShowPaths-impl  reason: not valid java name */
    public static final boolean m7035getShowPathsimpl(int i) {
        return (i & 2) > 0;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m7036hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m7031equalsimpl(this.flags, obj);
    }

    public int hashCode() {
        return m7036hashCodeimpl(this.flags);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m7038unboximpl() {
        return this.flags;
    }

    private /* synthetic */ DebugFlags(int i) {
        this.flags = i;
    }

    /* renamed from: constructor-impl$default  reason: not valid java name */
    public static /* synthetic */ int m7030constructorimpl$default(boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        return m7029constructorimpl(z, z2, z3);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m7029constructorimpl(boolean z, boolean z2, boolean z3) {
        return m7028constructorimpl((z ? 1 : 0) | (z2 ? 2 : 0) | (z3 ? 4 : 0));
    }

    public String toString() {
        return m7037toStringimpl(this.flags);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m7037toStringimpl(int i) {
        return "DebugFlags(showBounds = " + m7033getShowBoundsimpl(i) + ", showPaths = " + m7035getShowPathsimpl(i) + ", showKeyPositions = " + m7034getShowKeyPositionsimpl(i) + ')';
    }

    /* compiled from: MotionLayout.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u0019\u0010\u000b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\f\u0010\u0006R\u000e\u0010\r\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000e"}, d2 = {"Landroidx/constraintlayout/compose/DebugFlags$Companion;", "", "()V", "All", "Landroidx/constraintlayout/compose/DebugFlags;", "getAll-bfy_xzQ", "()I", "I", "BOUNDS_FLAG", "", "KEY_POSITIONS_FLAG", "None", "getNone-bfy_xzQ", "PATHS_FLAG", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getNone-bfy_xzQ  reason: not valid java name */
        public final int m7040getNonebfy_xzQ() {
            return DebugFlags.None;
        }

        /* renamed from: getAll-bfy_xzQ  reason: not valid java name */
        public final int m7039getAllbfy_xzQ() {
            return DebugFlags.All;
        }
    }
}
