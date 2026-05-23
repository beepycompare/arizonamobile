package androidx.compose.ui.node;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
/* compiled from: NodeKind.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0081@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\t\u001a\u00020\u00042\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0086\f¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0086\f¢\u0006\u0004\b\r\u0010\fJ\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u0002HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0004HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0088\u0001\u0003¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/node/NodeKind;", ExifInterface.GPS_DIRECTION_TRUE, "", "mask", "", "constructor-impl", "(I)I", "getMask", "()I", "or", "other", "or-H91voCI", "(II)I", "or-impl", "equals", "", "hashCode", "toString", "", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class NodeKind<T> {
    private final int mask;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ NodeKind m7134boximpl(int i) {
        return new NodeKind(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static <T> int m7135constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m7136equalsimpl(int i, Object obj) {
        return (obj instanceof NodeKind) && i == ((NodeKind) obj).m7142unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m7137equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m7138hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* renamed from: or-H91voCI  reason: not valid java name */
    public static final int m7139orH91voCI(int i, int i2) {
        return i | i2;
    }

    /* renamed from: or-impl  reason: not valid java name */
    public static final int m7140orimpl(int i, int i2) {
        return i | i2;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m7141toStringimpl(int i) {
        return "NodeKind(mask=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m7136equalsimpl(this.mask, obj);
    }

    public int hashCode() {
        return m7138hashCodeimpl(this.mask);
    }

    public String toString() {
        return m7141toStringimpl(this.mask);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m7142unboximpl() {
        return this.mask;
    }

    private /* synthetic */ NodeKind(int i) {
        this.mask = i;
    }

    public final int getMask() {
        return this.mask;
    }
}
