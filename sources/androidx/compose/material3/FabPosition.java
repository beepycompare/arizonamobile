package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: Scaffold.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/material3/FabPosition;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class FabPosition {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Start = m2461constructorimpl(0);
    private static final int Center = m2461constructorimpl(1);
    private static final int End = m2461constructorimpl(2);
    private static final int EndOverlay = m2461constructorimpl(3);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ FabPosition m2460boximpl(int i) {
        return new FabPosition(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m2461constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m2462equalsimpl(int i, Object obj) {
        return (obj instanceof FabPosition) && i == ((FabPosition) obj).m2466unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m2463equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m2464hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m2462equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2464hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m2466unboximpl() {
        return this.value;
    }

    /* compiled from: Scaffold.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u000f"}, d2 = {"Landroidx/compose/material3/FabPosition$Companion;", "", "<init>", "()V", "Start", "Landroidx/compose/material3/FabPosition;", "getStart-ERTFSPs", "()I", "I", "Center", "getCenter-ERTFSPs", "End", "getEnd-ERTFSPs", "EndOverlay", "getEndOverlay-ERTFSPs", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getStart-ERTFSPs  reason: not valid java name */
        public final int m2470getStartERTFSPs() {
            return FabPosition.Start;
        }

        /* renamed from: getCenter-ERTFSPs  reason: not valid java name */
        public final int m2467getCenterERTFSPs() {
            return FabPosition.Center;
        }

        /* renamed from: getEnd-ERTFSPs  reason: not valid java name */
        public final int m2468getEndERTFSPs() {
            return FabPosition.End;
        }

        /* renamed from: getEndOverlay-ERTFSPs  reason: not valid java name */
        public final int m2469getEndOverlayERTFSPs() {
            return FabPosition.EndOverlay;
        }
    }

    private /* synthetic */ FabPosition(int i) {
        this.value = i;
    }

    public String toString() {
        return m2465toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m2465toStringimpl(int i) {
        return m2463equalsimpl0(i, Start) ? "FabPosition.Start" : m2463equalsimpl0(i, Center) ? "FabPosition.Center" : m2463equalsimpl0(i, End) ? "FabPosition.End" : "FabPosition.EndOverlay";
    }
}
