package kotlinx.collections.immutable.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ListImplementation.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0002\b\tJ\u001d\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0002\b\u000bJ%\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0002\b\u000fJ\u0019\u0010\u0010\u001a\u00020\u00072\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0001¢\u0006\u0002\b\u0013J%\u0010\u0014\u001a\u00020\u00152\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00122\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0001¢\u0006\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lkotlinx/collections/immutable/internal/ListImplementation;", "", "<init>", "()V", "checkElementIndex", "", FirebaseAnalytics.Param.INDEX, "", "size", "checkElementIndex$kotlinx_collections_immutable", "checkPositionIndex", "checkPositionIndex$kotlinx_collections_immutable", "checkRangeIndexes", "fromIndex", "toIndex", "checkRangeIndexes$kotlinx_collections_immutable", "orderedHashCode", "c", "", "orderedHashCode$kotlinx_collections_immutable", "orderedEquals", "", "other", "orderedEquals$kotlinx_collections_immutable", "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ListImplementation {
    public static final ListImplementation INSTANCE = new ListImplementation();

    private ListImplementation() {
    }

    @JvmStatic
    public static final void checkElementIndex$kotlinx_collections_immutable(int i, int i2) {
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException("index: " + i + ", size: " + i2);
        }
    }

    @JvmStatic
    public static final void checkPositionIndex$kotlinx_collections_immutable(int i, int i2) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException("index: " + i + ", size: " + i2);
        }
    }

    @JvmStatic
    public static final void checkRangeIndexes$kotlinx_collections_immutable(int i, int i2, int i3) {
        if (i < 0 || i2 > i3) {
            throw new IndexOutOfBoundsException("fromIndex: " + i + ", toIndex: " + i2 + ", size: " + i3);
        }
        if (i > i2) {
            throw new IllegalArgumentException("fromIndex: " + i + " > toIndex: " + i2);
        }
    }

    @JvmStatic
    public static final int orderedHashCode$kotlinx_collections_immutable(Collection<?> c) {
        Intrinsics.checkNotNullParameter(c, "c");
        Iterator<?> it = c.iterator();
        int i = 1;
        while (it.hasNext()) {
            Object next = it.next();
            i = (i * 31) + (next != null ? next.hashCode() : 0);
        }
        return i;
    }

    @JvmStatic
    public static final boolean orderedEquals$kotlinx_collections_immutable(Collection<?> c, Collection<?> other) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(other, "other");
        if (c.size() != other.size()) {
            return false;
        }
        Iterator<?> it = other.iterator();
        Iterator<?> it2 = c.iterator();
        while (it2.hasNext()) {
            if (!Intrinsics.areEqual(it2.next(), it.next())) {
                return false;
            }
        }
        return true;
    }
}
