package androidx.compose.ui.layout;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: ValueInsets.android.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0081@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\u0011\u0010\u001b\u001a\u00020\tHÖ\u0081\u0004¢\u0006\u0004\b\u001c\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0012\u0010\u000e\u001a\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0012\u0010\u0010\u001a\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000b\u0088\u0001\u0002¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/layout/ValueInsets;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue", "()J", TtmlNode.LEFT, "", "getLeft-impl", "(J)I", "top", "getTop-impl", TtmlNode.RIGHT, "getRight-impl", "bottom", "getBottom-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class ValueInsets {
    private final long packedValue;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ValueInsets m6951boximpl(long j) {
        return new ValueInsets(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m6952constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m6953equalsimpl(long j, Object obj) {
        return (obj instanceof ValueInsets) && j == ((ValueInsets) obj).m6961unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m6954equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getBottom-impl  reason: not valid java name */
    public static final int m6955getBottomimpl(long j) {
        return (int) (j & WebSocketProtocol.PAYLOAD_SHORT_MAX);
    }

    /* renamed from: getLeft-impl  reason: not valid java name */
    public static final int m6956getLeftimpl(long j) {
        return (int) ((j >>> 48) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
    }

    /* renamed from: getRight-impl  reason: not valid java name */
    public static final int m6957getRightimpl(long j) {
        return (int) ((j >>> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
    }

    /* renamed from: getTop-impl  reason: not valid java name */
    public static final int m6958getTopimpl(long j) {
        return (int) ((j >>> 32) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m6959hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m6953equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m6959hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m6961unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ ValueInsets(long j) {
        this.packedValue = j;
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    public String toString() {
        return m6960toStringimpl(this.packedValue);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m6960toStringimpl(long j) {
        return "ValueInsets(" + ((int) ((j >>> 48) & WebSocketProtocol.PAYLOAD_SHORT_MAX)) + ", " + ((int) ((j >>> 32) & WebSocketProtocol.PAYLOAD_SHORT_MAX)) + ", " + ((int) ((j >>> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX)) + ", " + ((int) (j & WebSocketProtocol.PAYLOAD_SHORT_MAX)) + ')';
    }
}
