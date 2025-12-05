package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
/* compiled from: HitTestResult.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0081@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f\u0088\u0001\u0002¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/node/DistanceAndFlags;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue", "()J", "distance", "", "getDistance-impl", "(J)F", "isInLayer", "", "isInLayer-impl", "(J)Z", "isInExpandedBounds", "isInExpandedBounds-impl", "compareTo", "", "other", "compareTo-9YPOF3E", "(JJ)I", "equals", "hashCode", "toString", "", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class DistanceAndFlags {
    private final long packedValue;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ DistanceAndFlags m7063boximpl(long j) {
        return new DistanceAndFlags(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m7065constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m7066equalsimpl(long j, Object obj) {
        return (obj instanceof DistanceAndFlags) && j == ((DistanceAndFlags) obj).m7073unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m7067equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m7069hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* renamed from: isInExpandedBounds-impl  reason: not valid java name */
    public static final boolean m7070isInExpandedBoundsimpl(long j) {
        return (j & 2) != 0;
    }

    /* renamed from: isInLayer-impl  reason: not valid java name */
    public static final boolean m7071isInLayerimpl(long j) {
        return (j & 1) != 0;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m7072toStringimpl(long j) {
        return "DistanceAndFlags(packedValue=" + j + ')';
    }

    public boolean equals(Object obj) {
        return m7066equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m7069hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m7072toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m7073unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ DistanceAndFlags(long j) {
        this.packedValue = j;
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    /* renamed from: compareTo-9YPOF3E  reason: not valid java name */
    public static final int m7064compareTo9YPOF3E(long j, long j2) {
        boolean m7071isInLayerimpl = m7071isInLayerimpl(j);
        if (m7071isInLayerimpl != m7071isInLayerimpl(j2)) {
            return m7071isInLayerimpl ? -1 : 1;
        }
        return (Math.min(m7068getDistanceimpl(j), m7068getDistanceimpl(j2)) >= 0.0f && m7070isInExpandedBoundsimpl(j) != m7070isInExpandedBoundsimpl(j2)) ? m7070isInExpandedBoundsimpl(j) ? -1 : 1 : (int) Math.signum(m7068getDistanceimpl(j) - m7068getDistanceimpl(j2));
    }

    /* renamed from: getDistance-impl  reason: not valid java name */
    public static final float m7068getDistanceimpl(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }
}
