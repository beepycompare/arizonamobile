package androidx.compose.foundation.text.input.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
/* compiled from: IntIntervalTree.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0081@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000b\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\f\u001a\u00020\rHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u000e"}, d2 = {"Landroidx/compose/foundation/text/input/internal/Node;", "", FirebaseAnalytics.Param.INDEX, "", "constructor-impl", "(I)I", "getIndex", "()I", "equals", "", "other", "hashCode", "toString", "", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class Node {
    private final int index;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Node m1831boximpl(int i) {
        return new Node(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m1832constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1833equalsimpl(int i, Object obj) {
        return (obj instanceof Node) && i == ((Node) obj).m1837unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1834equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1835hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1836toStringimpl(int i) {
        return "Node(index=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m1833equalsimpl(this.index, obj);
    }

    public int hashCode() {
        return m1835hashCodeimpl(this.index);
    }

    public String toString() {
        return m1836toStringimpl(this.index);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m1837unboximpl() {
        return this.index;
    }

    private /* synthetic */ Node(int i) {
        this.index = i;
    }

    public final int getIndex() {
        return this.index;
    }
}
