package androidx.paging.internal;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
/* compiled from: Atomics.jvmAndAndroid.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0002\u0010\nJ\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0096\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/paging/internal/CopyOnWriteArrayList;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "delegate", "Ljava/util/concurrent/CopyOnWriteArrayList;", "add", "", "value", "(Ljava/lang/Object;)Z", "remove", "iterator", "", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CopyOnWriteArrayList<T> implements Iterable<T>, KMappedMarker {
    private final java.util.concurrent.CopyOnWriteArrayList<T> delegate = new java.util.concurrent.CopyOnWriteArrayList<>();

    public final boolean add(T t) {
        return this.delegate.add(t);
    }

    public final boolean remove(T t) {
        return this.delegate.remove(t);
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        Iterator<T> it = this.delegate.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        return it;
    }
}
