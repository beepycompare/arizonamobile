package androidx.compose.ui.graphics;

import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: TileMode.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u0003HÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/graphics/TileMode;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-graphics"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class TileMode {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Clamp = m5737constructorimpl(0);
    private static final int Repeated = m5737constructorimpl(1);
    private static final int Mirror = m5737constructorimpl(2);
    private static final int Decal = m5737constructorimpl(3);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ TileMode m5736boximpl(int i) {
        return new TileMode(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m5737constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m5738equalsimpl(int i, Object obj) {
        return (obj instanceof TileMode) && i == ((TileMode) obj).m5742unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m5739equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m5740hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m5738equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m5740hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m5742unboximpl() {
        return this.value;
    }

    /* compiled from: TileMode.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/graphics/TileMode$Companion;", "", "<init>", "()V", "Clamp", "Landroidx/compose/ui/graphics/TileMode;", "getClamp-3opZhB0", "()I", "I", "Repeated", "getRepeated-3opZhB0", "Mirror", "getMirror-3opZhB0", "Decal", "getDecal-3opZhB0", "ui-graphics"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getClamp-3opZhB0  reason: not valid java name */
        public final int m5743getClamp3opZhB0() {
            return TileMode.Clamp;
        }

        /* renamed from: getRepeated-3opZhB0  reason: not valid java name */
        public final int m5746getRepeated3opZhB0() {
            return TileMode.Repeated;
        }

        /* renamed from: getMirror-3opZhB0  reason: not valid java name */
        public final int m5745getMirror3opZhB0() {
            return TileMode.Mirror;
        }

        /* renamed from: getDecal-3opZhB0  reason: not valid java name */
        public final int m5744getDecal3opZhB0() {
            return TileMode.Decal;
        }
    }

    private /* synthetic */ TileMode(int i) {
        this.value = i;
    }

    public String toString() {
        return m5741toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m5741toStringimpl(int i) {
        return m5739equalsimpl0(i, Clamp) ? "Clamp" : m5739equalsimpl0(i, Repeated) ? "Repeated" : m5739equalsimpl0(i, Mirror) ? "Mirror" : m5739equalsimpl0(i, Decal) ? "Decal" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }
}
